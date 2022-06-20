package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class hz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final hz9 f;
    public static final dz9 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<dz9> a;
    public final AtomicReference<fz9> b;
    public final AtomicReference<jz9> c;
    public final AtomicReference<cz9> d;
    public final AtomicReference<iz9> e;

    /* loaded from: classes6.dex */
    public static class a extends dz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends cz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(hz9 hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755630806, "Lcom/repackage/hz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755630806, "Lcom/repackage/hz9;");
                return;
            }
        }
        f = new hz9();
        g = new a();
    }

    public hz9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicReference<>();
        this.b = new AtomicReference<>();
        this.c = new AtomicReference<>();
        this.d = new AtomicReference<>();
        this.e = new AtomicReference<>();
    }

    @Deprecated
    public static hz9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f : (hz9) invokeV.objValue;
    }

    public static Object e(Class<?> cls, Properties properties) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, properties)) == null) {
            Properties properties2 = (Properties) properties.clone();
            String simpleName = cls.getSimpleName();
            String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
            if (property == null) {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                        String property2 = properties2.getProperty(str);
                        if (property2 == null) {
                            throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                        }
                        property = property2;
                    }
                }
            }
            if (property != null) {
                try {
                    return Class.forName(property).asSubclass(cls).newInstance();
                } catch (ClassCastException e) {
                    throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e);
                } catch (ClassNotFoundException e2) {
                    throw new IllegalStateException(simpleName + " implementation class not found: " + property, e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e3);
                } catch (InstantiationException e4) {
                    throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e4);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public cz9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.get() == null) {
                Object e = e(cz9.class, System.getProperties());
                if (e == null) {
                    this.d.compareAndSet(null, new b(this));
                } else {
                    this.d.compareAndSet(null, (cz9) e);
                }
            }
            return this.d.get();
        }
        return (cz9) invokeV.objValue;
    }

    public dz9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e = e(dz9.class, System.getProperties());
                if (e == null) {
                    this.a.compareAndSet(null, g);
                } else {
                    this.a.compareAndSet(null, (dz9) e);
                }
            }
            return this.a.get();
        }
        return (dz9) invokeV.objValue;
    }

    public fz9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.get() == null) {
                Object e = e(fz9.class, System.getProperties());
                if (e == null) {
                    this.b.compareAndSet(null, gz9.f());
                } else {
                    this.b.compareAndSet(null, (fz9) e);
                }
            }
            return this.b.get();
        }
        return (fz9) invokeV.objValue;
    }

    public iz9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e.get() == null) {
                Object e = e(iz9.class, System.getProperties());
                if (e == null) {
                    this.e.compareAndSet(null, iz9.h());
                } else {
                    this.e.compareAndSet(null, (iz9) e);
                }
            }
            return this.e.get();
        }
        return (iz9) invokeV.objValue;
    }

    public jz9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.get() == null) {
                Object e = e(jz9.class, System.getProperties());
                if (e == null) {
                    this.c.compareAndSet(null, kz9.e());
                } else {
                    this.c.compareAndSet(null, (jz9) e);
                }
            }
            return this.c.get();
        }
        return (jz9) invokeV.objValue;
    }
}
