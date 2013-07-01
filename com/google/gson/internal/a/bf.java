package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class bf extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    private final Map f1626a = new HashMap();
    private final Map b = new HashMap();

    public bf(Class cls) {
        Enum[] enumArr;
        try {
            for (Enum r5 : (Enum[]) cls.getEnumConstants()) {
                String name = r5.name();
                com.google.gson.a.b bVar = (com.google.gson.a.b) cls.getField(name).getAnnotation(com.google.gson.a.b.class);
                String a2 = bVar != null ? bVar.a() : name;
                this.f1626a.put(a2, r5);
                this.b.put(r5, a2);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Enum b(com.google.gson.stream.a aVar) {
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        return (Enum) this.f1626a.get(aVar.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Enum r3) {
        dVar.b(r3 == null ? null : (String) this.b.get(r3));
    }
}
