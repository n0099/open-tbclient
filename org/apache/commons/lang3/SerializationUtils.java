package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SerializationUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<String, Class<?>> primitiveTypes;
        public transient /* synthetic */ FieldHolder $fh;
        public final ClassLoader classLoader;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1118696715, "Lorg/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1118696715, "Lorg/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream;");
                    return;
                }
            }
            HashMap hashMap = new HashMap();
            primitiveTypes = hashMap;
            hashMap.put("byte", Byte.TYPE);
            primitiveTypes.put("short", Short.TYPE);
            primitiveTypes.put("int", Integer.TYPE);
            primitiveTypes.put("long", Long.TYPE);
            primitiveTypes.put(ShaderParams.VALUE_TYPE_FLOAT, Float.TYPE);
            primitiveTypes.put("double", Double.TYPE);
            primitiveTypes.put("boolean", Boolean.TYPE);
            primitiveTypes.put("char", Character.TYPE);
            primitiveTypes.put("void", Void.TYPE);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.classLoader = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectStreamClass)) == null) {
                String name = objectStreamClass.getName();
                try {
                    try {
                        return Class.forName(name, false, this.classLoader);
                    } catch (ClassNotFoundException unused) {
                        return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
                    }
                } catch (ClassNotFoundException e2) {
                    Class<?> cls = primitiveTypes.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw e2;
                }
            }
            return (Class) invokeL.objValue;
        }
    }

    public SerializationUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T extends Serializable> T clone(T t) {
        InterceptResult invokeL;
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, t)) != null) {
            return (T) invokeL.objValue;
        }
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream2 = null;
        if (t == null) {
            return null;
        }
        try {
            try {
                classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), t.getClass().getClassLoader());
            } catch (Throwable th) {
                th = th;
            }
            try {
                T t2 = (T) classLoaderAwareObjectInputStream.readObject();
                try {
                    classLoaderAwareObjectInputStream.close();
                    return t2;
                } catch (IOException e2) {
                    throw new SerializationException("IOException on closing cloned object data InputStream.", e2);
                }
            } catch (IOException e3) {
                e = e3;
                throw new SerializationException("IOException while reading cloned object data", e);
            } catch (ClassNotFoundException e4) {
                e = e4;
                throw new SerializationException("ClassNotFoundException while reading cloned object data", e);
            } catch (Throwable th2) {
                th = th2;
                classLoaderAwareObjectInputStream2 = classLoaderAwareObjectInputStream;
                if (classLoaderAwareObjectInputStream2 != null) {
                    try {
                        classLoaderAwareObjectInputStream2.close();
                    } catch (IOException e5) {
                        throw new SerializationException("IOException on closing cloned object data InputStream.", e5);
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (ClassNotFoundException e7) {
            e = e7;
        }
    }

    public static <T> T deserialize(InputStream inputStream) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            if (inputStream != null) {
                ObjectInputStream objectInputStream2 = null;
                try {
                    try {
                        objectInputStream = new ObjectInputStream(inputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                }
                try {
                    T t = (T) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused) {
                    }
                    return t;
                } catch (IOException e4) {
                    e = e4;
                    throw new SerializationException(e);
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    throw new SerializationException(e);
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        return (T) invokeL.objValue;
    }

    public static <T extends Serializable> T roundtrip(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? (T) deserialize(serialize(t)) : (T) invokeL.objValue;
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, serializable, outputStream) == null) {
            if (outputStream != null) {
                ObjectOutputStream objectOutputStream2 = null;
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(outputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    objectOutputStream.writeObject(serializable);
                    try {
                        objectOutputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } catch (IOException e3) {
                    e = e3;
                    throw new SerializationException(e);
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
    }

    public static byte[] serialize(Serializable serializable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, serializable)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            serialize(serializable, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static <T> T deserialize(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null) {
                return (T) deserialize(new ByteArrayInputStream(bArr));
            }
            throw new IllegalArgumentException("The byte[] must not be null");
        }
        return (T) invokeL.objValue;
    }
}
