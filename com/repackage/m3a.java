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
public class m3a {
    public static /* synthetic */ Interceptable $ic;
    public static final m3a f;
    public static final i3a g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<i3a> a;
    public final AtomicReference<k3a> b;
    public final AtomicReference<o3a> c;
    public final AtomicReference<h3a> d;
    public final AtomicReference<n3a> e;

    /* loaded from: classes6.dex */
    public static class a extends i3a {
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
    public class b extends h3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(m3a m3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m3aVar};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755548842, "Lcom/repackage/m3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755548842, "Lcom/repackage/m3a;");
                return;
            }
        }
        f = new m3a();
        g = new a();
    }

    public m3a() {
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
    public static m3a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f : (m3a) invokeV.objValue;
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

    public h3a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d.get() == null) {
                Object e = e(h3a.class, System.getProperties());
                if (e == null) {
                    this.d.compareAndSet(null, new b(this));
                } else {
                    this.d.compareAndSet(null, (h3a) e);
                }
            }
            return this.d.get();
        }
        return (h3a) invokeV.objValue;
    }

    public i3a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e = e(i3a.class, System.getProperties());
                if (e == null) {
                    this.a.compareAndSet(null, g);
                } else {
                    this.a.compareAndSet(null, (i3a) e);
                }
            }
            return this.a.get();
        }
        return (i3a) invokeV.objValue;
    }

    public k3a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.get() == null) {
                Object e = e(k3a.class, System.getProperties());
                if (e == null) {
                    this.b.compareAndSet(null, l3a.f());
                } else {
                    this.b.compareAndSet(null, (k3a) e);
                }
            }
            return this.b.get();
        }
        return (k3a) invokeV.objValue;
    }

    public n3a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e.get() == null) {
                Object e = e(n3a.class, System.getProperties());
                if (e == null) {
                    this.e.compareAndSet(null, n3a.h());
                } else {
                    this.e.compareAndSet(null, (n3a) e);
                }
            }
            return this.e.get();
        }
        return (n3a) invokeV.objValue;
    }

    public o3a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.get() == null) {
                Object e = e(o3a.class, System.getProperties());
                if (e == null) {
                    this.c.compareAndSet(null, p3a.e());
                } else {
                    this.c.compareAndSet(null, (o3a) e);
                }
            }
            return this.c.get();
        }
        return (o3a) invokeV.objValue;
    }
}
