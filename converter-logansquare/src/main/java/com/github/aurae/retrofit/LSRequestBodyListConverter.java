package com.github.aurae.retrofit;

import com.bluelinelabs.logansquare.JsonMapper;
import com.squareup.okhttp.RequestBody;
import retrofit.Converter;

import java.io.IOException;
import java.util.List;

import static com.github.aurae.retrofit.LSConverterUtils.MEDIA_TYPE;

final class LSRequestBodyListConverter<T> implements Converter<List<T>, RequestBody> {

    private final JsonMapper<T> mapper;

    public LSRequestBodyListConverter(JsonMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public RequestBody convert(List<T> value) throws IOException {
        String serializedValue = mapper.serialize(value);
        return RequestBody.create(MEDIA_TYPE, serializedValue);
    }
}
