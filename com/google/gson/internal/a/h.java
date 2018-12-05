package com.google.gson.internal.a;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class h extends o<Object> {
    public static final p iuj = new p() { // from class: com.google.gson.internal.a.h.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.caT() == Object.class) {
                return new h(dVar);
            }
            return null;
        }
    };
    private final com.google.gson.d gson;

    h(com.google.gson.d dVar) {
        this.gson = dVar;
    }

    @Override // com.google.gson.o
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        switch (aVar.caH()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.beginArray();
                while (aVar.hasNext()) {
                    arrayList.add(b(aVar));
                }
                aVar.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.beginObject();
                while (aVar.hasNext()) {
                    linkedTreeMap.put(aVar.nextName(), b(aVar));
                }
                aVar.endObject();
                return linkedTreeMap;
            case STRING:
                return aVar.nextString();
            case NUMBER:
                return Double.valueOf(aVar.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(aVar.nextBoolean());
            case NULL:
                aVar.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.o
    public void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.caS();
            return;
        }
        o t = this.gson.t(obj.getClass());
        if (t instanceof h) {
            bVar.caQ();
            bVar.caR();
            return;
        }
        t.a(bVar, obj);
    }
}
