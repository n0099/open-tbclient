package d.g.c.b;

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
    public final Map<Type, InstanceCreator<?>> f66089a;

    /* renamed from: b  reason: collision with root package name */
    public final d.g.c.b.k.b f66090b = d.g.c.b.k.b.a();

    /* loaded from: classes6.dex */
    public class a implements d.g.c.b.e<T> {
        public a(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // d.g.c.b.e
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* renamed from: d.g.c.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1807b implements d.g.c.b.e<T> {
        public C1807b(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // d.g.c.b.e
        public T a() {
            return new TreeMap();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.g.c.b.e<T> {
        public c(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // d.g.c.b.e
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d.g.c.b.e<T> {
        public d(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // d.g.c.b.e
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements d.g.c.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.g.c.b.i f66091a = d.g.c.b.i.b();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f66092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Type f66093c;

        public e(b bVar, Class cls, Type type) {
            this.f66092b = cls;
            this.f66093c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // d.g.c.b.e
        public T a() {
            try {
                return this.f66091a.c(this.f66092b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f66093c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements d.g.c.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstanceCreator f66094a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f66095b;

        public f(b bVar, InstanceCreator instanceCreator, Type type) {
            this.f66094a = instanceCreator;
            this.f66095b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // d.g.c.b.e
        public T a() {
            return this.f66094a.createInstance(this.f66095b);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements d.g.c.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InstanceCreator f66096a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f66097b;

        public g(b bVar, InstanceCreator instanceCreator, Type type) {
            this.f66096a = instanceCreator;
            this.f66097b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // d.g.c.b.e
        public T a() {
            return this.f66096a.createInstance(this.f66097b);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements d.g.c.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Constructor f66098a;

        public h(b bVar, Constructor constructor) {
            this.f66098a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // d.g.c.b.e
        public T a() {
            try {
                return this.f66098a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f66098a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f66098a + " with no args", e4.getTargetException());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements d.g.c.b.e<T> {
        public i(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // d.g.c.b.e
        public T a() {
            return new TreeSet();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements d.g.c.b.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Type f66099a;

        public j(b bVar, Type type) {
            this.f66099a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // d.g.c.b.e
        public T a() {
            Type type = this.f66099a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f66099a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f66099a.toString());
        }
    }

    /* loaded from: classes6.dex */
    public class k implements d.g.c.b.e<T> {
        public k(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // d.g.c.b.e
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* loaded from: classes6.dex */
    public class l implements d.g.c.b.e<T> {
        public l(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // d.g.c.b.e
        public T a() {
            return new ArrayDeque();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements d.g.c.b.e<T> {
        public m(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // d.g.c.b.e
        public T a() {
            return new ArrayList();
        }
    }

    /* loaded from: classes6.dex */
    public class n implements d.g.c.b.e<T> {
        public n(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // d.g.c.b.e
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public b(Map<Type, InstanceCreator<?>> map) {
        this.f66089a = map;
    }

    public <T> d.g.c.b.e<T> a(d.g.c.c.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c2 = aVar.c();
        InstanceCreator<?> instanceCreator = this.f66089a.get(e2);
        if (instanceCreator != null) {
            return new f(this, instanceCreator, e2);
        }
        InstanceCreator<?> instanceCreator2 = this.f66089a.get(c2);
        if (instanceCreator2 != null) {
            return new g(this, instanceCreator2, e2);
        }
        d.g.c.b.e<T> b2 = b(c2);
        if (b2 != null) {
            return b2;
        }
        d.g.c.b.e<T> c3 = c(e2, c2);
        return c3 != null ? c3 : d(e2, c2);
    }

    public final <T> d.g.c.b.e<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f66090b.b(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> d.g.c.b.e<T> c(Type type, Class<? super T> cls) {
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
                return new C1807b(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(d.g.c.c.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                return new c(this);
            }
            return new d(this);
        } else {
            return null;
        }
    }

    public final <T> d.g.c.b.e<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public String toString() {
        return this.f66089a.toString();
    }
}
