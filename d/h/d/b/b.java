package d.h.d.b;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Type, InstanceCreator<?>> f67230a;

    /* renamed from: b  reason: collision with root package name */
    public final d.h.d.b.k.b f67231b = d.h.d.b.k.b.a();

    /* loaded from: classes6.dex */
    public class a implements d.h.d.b.e<T> {
        public a(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // d.h.d.b.e
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* renamed from: d.h.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1847b implements d.h.d.b.e<T> {
        public C1847b(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // d.h.d.b.e
        public T a() {
            return new TreeMap();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.h.d.b.e<T> {
        public c(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // d.h.d.b.e
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d.h.d.b.e<T> {
        public d(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // d.h.d.b.e
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements d.h.d.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.h.d.b.i f67232a = d.h.d.b.i.b();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f67233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Type f67234c;

        public e(b bVar, Class cls, Type type) {
            this.f67233b = cls;
            this.f67234c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // d.h.d.b.e
        public T a() {
            try {
                return this.f67232a.c(this.f67233b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f67234c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements d.h.d.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstanceCreator f67235a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f67236b;

        public f(b bVar, InstanceCreator instanceCreator, Type type) {
            this.f67235a = instanceCreator;
            this.f67236b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // d.h.d.b.e
        public T a() {
            return this.f67235a.createInstance(this.f67236b);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d.h.d.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstanceCreator f67237a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f67238b;

        public g(b bVar, InstanceCreator instanceCreator, Type type) {
            this.f67237a = instanceCreator;
            this.f67238b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // d.h.d.b.e
        public T a() {
            return this.f67237a.createInstance(this.f67238b);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements d.h.d.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Constructor f67239a;

        public h(b bVar, Constructor constructor) {
            this.f67239a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // d.h.d.b.e
        public T a() {
            try {
                return this.f67239a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f67239a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f67239a + " with no args", e4.getTargetException());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d.h.d.b.e<T> {
        public i(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // d.h.d.b.e
        public T a() {
            return new TreeSet();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements d.h.d.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Type f67240a;

        public j(b bVar, Type type) {
            this.f67240a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // d.h.d.b.e
        public T a() {
            Type type = this.f67240a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f67240a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f67240a.toString());
        }
    }

    /* loaded from: classes6.dex */
    public class k implements d.h.d.b.e<T> {
        public k(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // d.h.d.b.e
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* loaded from: classes6.dex */
    public class l implements d.h.d.b.e<T> {
        public l(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // d.h.d.b.e
        public T a() {
            return new ArrayDeque();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements d.h.d.b.e<T> {
        public m(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // d.h.d.b.e
        public T a() {
            return new ArrayList();
        }
    }

    /* loaded from: classes6.dex */
    public class n implements d.h.d.b.e<T> {
        public n(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // d.h.d.b.e
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public b(Map<Type, InstanceCreator<?>> map) {
        this.f67230a = map;
    }

    public <T> d.h.d.b.e<T> a(d.h.d.c.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c2 = aVar.c();
        InstanceCreator<?> instanceCreator = this.f67230a.get(e2);
        if (instanceCreator != null) {
            return new f(this, instanceCreator, e2);
        }
        InstanceCreator<?> instanceCreator2 = this.f67230a.get(c2);
        if (instanceCreator2 != null) {
            return new g(this, instanceCreator2, e2);
        }
        d.h.d.b.e<T> b2 = b(c2);
        if (b2 != null) {
            return b2;
        }
        d.h.d.b.e<T> c3 = c(e2, c2);
        return c3 != null ? c3 : d(e2, c2);
    }

    public final <T> d.h.d.b.e<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f67231b.b(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> d.h.d.b.e<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C1847b(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(d.h.d.c.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                return new c(this);
            }
            return new d(this);
        } else {
            return null;
        }
    }

    public final <T> d.h.d.b.e<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public String toString() {
        return this.f67230a.toString();
    }
}
