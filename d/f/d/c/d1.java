package d.f.d.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.c.s0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes10.dex */
public final class d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Field f73754a;

        public /* synthetic */ b(Field field, a aVar) {
            this(field);
        }

        public void a(T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, t, i2) == null) {
                try {
                    this.f73754a.set(t, Integer.valueOf(i2));
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        public void b(T t, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, obj) == null) {
                try {
                    this.f73754a.set(t, obj);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        public b(Field field) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {field};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73754a = field;
            field.setAccessible(true);
        }
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cls, str)) == null) {
            try {
                return new b<>(cls.getDeclaredField(str), null);
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }
        return (b) invokeLL.objValue;
    }

    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, map, objectInputStream) == null) {
            c(map, objectInputStream, objectInputStream.readInt());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, map, objectInputStream, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                map.put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    public static <K, V> void d(q0<K, V> q0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, q0Var, objectInputStream) == null) {
            e(q0Var, objectInputStream, objectInputStream.readInt());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: d.f.d.c.q0<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(q0<K, V> q0Var, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65540, null, q0Var, objectInputStream, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                Collection collection = q0Var.get(objectInputStream.readObject());
                int readInt = objectInputStream.readInt();
                for (int i4 = 0; i4 < readInt; i4++) {
                    collection.add(objectInputStream.readObject());
                }
            }
        }
    }

    public static <E> void f(s0<E> s0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, s0Var, objectInputStream) == null) {
            g(s0Var, objectInputStream, objectInputStream.readInt());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: d.f.d.c.s0<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(s0<E> s0Var, ObjectInputStream objectInputStream, int i2) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, s0Var, objectInputStream, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                s0Var.add(objectInputStream.readObject(), objectInputStream.readInt());
            }
        }
    }

    public static int h(ObjectInputStream objectInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, objectInputStream)) == null) ? objectInputStream.readInt() : invokeL.intValue;
    }

    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, map, objectOutputStream) == null) {
            objectOutputStream.writeInt(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    public static <K, V> void j(q0<K, V> q0Var, ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, q0Var, objectOutputStream) == null) {
            objectOutputStream.writeInt(q0Var.asMap().size());
            for (Map.Entry<K, Collection<V>> entry : q0Var.asMap().entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeInt(entry.getValue().size());
                for (V v : entry.getValue()) {
                    objectOutputStream.writeObject(v);
                }
            }
        }
    }

    public static <E> void k(s0<E> s0Var, ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, s0Var, objectOutputStream) == null) {
            objectOutputStream.writeInt(s0Var.entrySet().size());
            for (s0.a<E> aVar : s0Var.entrySet()) {
                objectOutputStream.writeObject(aVar.getElement());
                objectOutputStream.writeInt(aVar.getCount());
            }
        }
    }
}
