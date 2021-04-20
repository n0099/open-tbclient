package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import d.g.d.d.b;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final TypeAdapterFactory f31246b = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, d.g.d.c.a<T> aVar) {
            if (aVar.c() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Gson f31247a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31248a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f31248a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31248a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31248a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31248a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31248a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31248a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ObjectTypeAdapter(Gson gson) {
        this.f31247a = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(d.g.d.d.a aVar) throws IOException {
        switch (a.f31248a[aVar.M().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.n();
                while (aVar.y()) {
                    arrayList.add(read(aVar));
                }
                aVar.t();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.o();
                while (aVar.y()) {
                    linkedTreeMap.put(aVar.G(), read(aVar));
                }
                aVar.v();
                return linkedTreeMap;
            case 3:
                return aVar.K();
            case 4:
                return Double.valueOf(aVar.D());
            case 5:
                return Boolean.valueOf(aVar.C());
            case 6:
                aVar.I();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.B();
            return;
        }
        TypeAdapter adapter = this.f31247a.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            bVar.r();
            bVar.v();
            return;
        }
        adapter.write(bVar, obj);
    }
}
