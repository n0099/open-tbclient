package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonToken;
import d.g.d.a.c;
import d.g.d.b.e;
import d.g.d.b.g;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: e  reason: collision with root package name */
    public final d.g.d.b.b f31249e;

    /* renamed from: f  reason: collision with root package name */
    public final FieldNamingStrategy f31250f;

    /* renamed from: g  reason: collision with root package name */
    public final Excluder f31251g;

    /* renamed from: h  reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f31252h;
    public final d.g.d.b.k.b i = d.g.d.b.k.b.a();

    /* loaded from: classes6.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        public final e<T> f31253a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, b> f31254b;

        public Adapter(e<T> eVar, Map<String, b> map) {
            this.f31253a = eVar;
            this.f31254b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(d.g.d.d.a aVar) throws IOException {
            if (aVar.M() == JsonToken.NULL) {
                aVar.I();
                return null;
            }
            T a2 = this.f31253a.a();
            try {
                aVar.o();
                while (aVar.y()) {
                    b bVar = this.f31254b.get(aVar.G());
                    if (bVar != null && bVar.f31262c) {
                        bVar.a(aVar, a2);
                    }
                    aVar.W();
                }
                aVar.v();
                return a2;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(d.g.d.d.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.B();
                return;
            }
            bVar.r();
            try {
                for (b bVar2 : this.f31254b.values()) {
                    if (bVar2.c(t)) {
                        bVar.z(bVar2.f31260a);
                        bVar2.b(bVar, t);
                    }
                }
                bVar.v();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends b {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Field f31255d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f31256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f31257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Gson f31258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g.d.c.a f31259h;
        public final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, d.g.d.c.a aVar, boolean z4) {
            super(str, z, z2);
            this.f31255d = field;
            this.f31256e = z3;
            this.f31257f = typeAdapter;
            this.f31258g = gson;
            this.f31259h = aVar;
            this.i = z4;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void a(d.g.d.d.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object read = this.f31257f.read(aVar);
            if (read == null && this.i) {
                return;
            }
            this.f31255d.set(obj, read);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void b(d.g.d.d.b bVar, Object obj) throws IOException, IllegalAccessException {
            (this.f31256e ? this.f31257f : new TypeAdapterRuntimeTypeWrapper(this.f31258g, this.f31257f, this.f31259h.e())).write(bVar, this.f31255d.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.f31261b && this.f31255d.get(obj) != obj;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f31260a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31261b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f31262c;

        public b(String str, boolean z, boolean z2) {
            this.f31260a = str;
            this.f31261b = z;
            this.f31262c = z2;
        }

        public abstract void a(d.g.d.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void b(d.g.d.d.b bVar, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(d.g.d.b.b bVar, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f31249e = bVar;
        this.f31250f = fieldNamingStrategy;
        this.f31251g = excluder;
        this.f31252h = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public static boolean c(Field field, boolean z, Excluder excluder) {
        return (excluder.d(field.getType(), z) || excluder.g(field, z)) ? false : true;
    }

    public final b a(Gson gson, Field field, String str, d.g.d.c.a<?> aVar, boolean z, boolean z2) {
        boolean b2 = g.b(aVar.c());
        d.g.d.a.b bVar = (d.g.d.a.b) field.getAnnotation(d.g.d.a.b.class);
        TypeAdapter<?> a2 = bVar != null ? this.f31252h.a(this.f31249e, gson, aVar, bVar) : null;
        boolean z3 = a2 != null;
        if (a2 == null) {
            a2 = gson.getAdapter(aVar);
        }
        return new a(this, str, z, z2, field, z3, a2, gson, aVar, b2);
    }

    public boolean b(Field field, boolean z) {
        return c(field, z, this.f31251g);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, d.g.d.c.a<T> aVar) {
        Class<? super T> c2 = aVar.c();
        if (Object.class.isAssignableFrom(c2)) {
            return new Adapter(this.f31249e.a(aVar), d(gson, aVar, c2));
        }
        return null;
    }

    public final Map<String, b> d(Gson gson, d.g.d.c.a<?> aVar, Class<?> cls) {
        b bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type e2 = aVar.e();
        d.g.d.c.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean b2 = b(field, true);
                boolean b3 = b(field, z);
                if (b2 || b3) {
                    this.i.b(field);
                    Type p = C$Gson$Types.p(aVar2.e(), cls2, field.getGenericType());
                    List<String> e3 = e(field);
                    int size = e3.size();
                    b bVar2 = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = e3.get(i2);
                        boolean z2 = i2 != 0 ? false : b2;
                        int i3 = i2;
                        b bVar3 = bVar2;
                        int i4 = size;
                        List<String> list = e3;
                        Field field2 = field;
                        bVar2 = bVar3 == null ? (b) linkedHashMap.put(str, a(gson, field, str, d.g.d.c.a.b(p), z2, b3)) : bVar3;
                        i2 = i3 + 1;
                        b2 = z2;
                        e3 = list;
                        size = i4;
                        field = field2;
                    }
                    if (bVar2 != null) {
                        throw new IllegalArgumentException(e2 + " declares multiple JSON fields named " + bVar.f31260a);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = d.g.d.c.a.b(C$Gson$Types.p(aVar2.e(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.c();
        }
        return linkedHashMap;
    }

    public final List<String> e(Field field) {
        c cVar = (c) field.getAnnotation(c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f31250f.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
