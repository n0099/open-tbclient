package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.a.i;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class m<T> extends TypeAdapter<T> {
    private final TypeAdapter<T> delegate;
    private final Gson mMc;
    private final Type type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.mMc = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        return this.delegate.read(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.delegate;
        Type a = a(this.type, t);
        if (a != this.type) {
            typeAdapter = this.mMc.getAdapter(com.google.gson.b.a.get(a));
            if ((typeAdapter instanceof i.a) && !(this.delegate instanceof i.a)) {
                typeAdapter = this.delegate;
            }
        }
        typeAdapter.write(bVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }
}
