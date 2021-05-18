package d.g.c.c;

import d.g.c.c.i0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public final class r0 {

    /* loaded from: classes6.dex */
    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Field f66262a;

        public void a(T t, int i2) {
            try {
                this.f66262a.set(t, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void b(T t, Object obj) {
            try {
                this.f66262a.set(t, obj);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public b(Field field) {
            this.f66262a = field;
            field.setAccessible(true);
        }
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public static <K, V> void d(h0<K, V> h0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(h0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: d.g.c.c.h0<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(h0<K, V> h0Var, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            Collection collection = h0Var.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i4 = 0; i4 < readInt; i4++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static <E> void f(i0<E> i0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(i0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: d.g.c.c.i0<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(i0<E> i0Var, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        for (int i3 = 0; i3 < i2; i3++) {
            i0Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <K, V> void j(h0<K, V> h0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(h0Var.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : h0Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            for (V v : entry.getValue()) {
                objectOutputStream.writeObject(v);
            }
        }
    }

    public static <E> void k(i0<E> i0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(i0Var.entrySet().size());
        for (i0.a<E> aVar : i0Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
