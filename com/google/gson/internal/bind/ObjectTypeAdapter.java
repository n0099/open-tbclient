package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory puF = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.eyW() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };
    private final Gson gson;

    ObjectTypeAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        switch (aVar.eyz()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.eyx();
                while (aVar.hasNext()) {
                    arrayList.add(read(aVar));
                }
                aVar.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.eyy();
                while (aVar.hasNext()) {
                    linkedTreeMap.put(aVar.eyC(), read(aVar));
                }
                aVar.endObject();
                return linkedTreeMap;
            case STRING:
                return aVar.eyD();
            case NUMBER:
                return Double.valueOf(aVar.eyG());
            case BOOLEAN:
                return Boolean.valueOf(aVar.eyE());
            case NULL:
                aVar.eyF();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.eyS();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            bVar.eyQ();
            bVar.eyR();
            return;
        }
        adapter.write(bVar, obj);
    }
}
