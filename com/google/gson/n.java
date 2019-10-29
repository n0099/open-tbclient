package com.google.gson;

import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class n<T> {
    public abstract void a(com.google.gson.stream.a aVar, T t) throws IOException;

    public final n<T> cKf() {
        return new n<T>() { // from class: com.google.gson.n.1
            @Override // com.google.gson.n
            public void a(com.google.gson.stream.a aVar, T t) throws IOException {
                if (t == null) {
                    aVar.cKD();
                } else {
                    n.this.a(aVar, t);
                }
            }
        };
    }

    public final h aZ(T t) {
        try {
            com.google.gson.internal.a.e eVar = new com.google.gson.internal.a.e();
            a(eVar, t);
            return eVar.cKx();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
