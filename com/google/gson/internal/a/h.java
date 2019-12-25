package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class h extends TypeAdapter<Object> {
    public static final TypeAdapterFactory mGD = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.h.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(gson);
            }
            return null;
        }
    };
    private final Gson gson;

    h(Gson gson) {
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        switch (aVar.dyA()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.dyw();
                while (aVar.hasNext()) {
                    arrayList.add(read(aVar));
                }
                aVar.dyx();
                return arrayList;
            case BEGIN_OBJECT:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.dyy();
                while (aVar.hasNext()) {
                    linkedTreeMap.put(aVar.dyD(), read(aVar));
                }
                aVar.dyz();
                return linkedTreeMap;
            case STRING:
                return aVar.dyE();
            case NUMBER:
                return Double.valueOf(aVar.dyH());
            case BOOLEAN:
                return Boolean.valueOf(aVar.dyF());
            case NULL:
                aVar.dyG();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.dyT();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof h) {
            bVar.dyR();
            bVar.dyS();
            return;
        }
        adapter.write(bVar, obj);
    }
}
