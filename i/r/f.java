package i.r;

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
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final f f79269f;

    /* renamed from: g  reason: collision with root package name */
    public static final i.r.b f79270g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<i.r.b> f79271a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f79272b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<h> f79273c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<i.r.a> f79274d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<g> f79275e;

    /* loaded from: classes10.dex */
    public static class a extends i.r.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
    }

    /* loaded from: classes10.dex */
    public class b extends i.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1783713924, "Li/r/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1783713924, "Li/r/f;");
                return;
            }
        }
        f79269f = new f();
        f79270g = new a();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f79271a = new AtomicReference<>();
        this.f79272b = new AtomicReference<>();
        this.f79273c = new AtomicReference<>();
        this.f79274d = new AtomicReference<>();
        this.f79275e = new AtomicReference<>();
    }

    @Deprecated
    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f79269f : (f) invokeV.objValue;
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
                } catch (ClassCastException e2) {
                    throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(simpleName + " implementation class not found: " + property, e3);
                } catch (IllegalAccessException e4) {
                    throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e5);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public i.r.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f79274d.get() == null) {
                Object e2 = e(i.r.a.class, System.getProperties());
                if (e2 == null) {
                    this.f79274d.compareAndSet(null, new b(this));
                } else {
                    this.f79274d.compareAndSet(null, (i.r.a) e2);
                }
            }
            return this.f79274d.get();
        }
        return (i.r.a) invokeV.objValue;
    }

    public i.r.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f79271a.get() == null) {
                Object e2 = e(i.r.b.class, System.getProperties());
                if (e2 == null) {
                    this.f79271a.compareAndSet(null, f79270g);
                } else {
                    this.f79271a.compareAndSet(null, (i.r.b) e2);
                }
            }
            return this.f79271a.get();
        }
        return (i.r.b) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f79272b.get() == null) {
                Object e2 = e(d.class, System.getProperties());
                if (e2 == null) {
                    this.f79272b.compareAndSet(null, e.f());
                } else {
                    this.f79272b.compareAndSet(null, (d) e2);
                }
            }
            return this.f79272b.get();
        }
        return (d) invokeV.objValue;
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f79275e.get() == null) {
                Object e2 = e(g.class, System.getProperties());
                if (e2 == null) {
                    this.f79275e.compareAndSet(null, g.h());
                } else {
                    this.f79275e.compareAndSet(null, (g) e2);
                }
            }
            return this.f79275e.get();
        }
        return (g) invokeV.objValue;
    }

    public h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f79273c.get() == null) {
                Object e2 = e(h.class, System.getProperties());
                if (e2 == null) {
                    this.f79273c.compareAndSet(null, i.e());
                } else {
                    this.f79273c.compareAndSet(null, (h) e2);
                }
            }
            return this.f79273c.get();
        }
        return (h) invokeV.objValue;
    }
}
