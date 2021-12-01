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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final f f63937f;

    /* renamed from: g  reason: collision with root package name */
    public static final i.r.b f63938g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<i.r.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f63939b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<h> f63940c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<i.r.a> f63941d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<g> f63942e;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        f63937f = new f();
        f63938g = new a();
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
        this.a = new AtomicReference<>();
        this.f63939b = new AtomicReference<>();
        this.f63940c = new AtomicReference<>();
        this.f63941d = new AtomicReference<>();
        this.f63942e = new AtomicReference<>();
    }

    @Deprecated
    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f63937f : (f) invokeV.objValue;
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
            if (this.f63941d.get() == null) {
                Object e2 = e(i.r.a.class, System.getProperties());
                if (e2 == null) {
                    this.f63941d.compareAndSet(null, new b(this));
                } else {
                    this.f63941d.compareAndSet(null, (i.r.a) e2);
                }
            }
            return this.f63941d.get();
        }
        return (i.r.a) invokeV.objValue;
    }

    public i.r.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.get() == null) {
                Object e2 = e(i.r.b.class, System.getProperties());
                if (e2 == null) {
                    this.a.compareAndSet(null, f63938g);
                } else {
                    this.a.compareAndSet(null, (i.r.b) e2);
                }
            }
            return this.a.get();
        }
        return (i.r.b) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f63939b.get() == null) {
                Object e2 = e(d.class, System.getProperties());
                if (e2 == null) {
                    this.f63939b.compareAndSet(null, e.f());
                } else {
                    this.f63939b.compareAndSet(null, (d) e2);
                }
            }
            return this.f63939b.get();
        }
        return (d) invokeV.objValue;
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f63942e.get() == null) {
                Object e2 = e(g.class, System.getProperties());
                if (e2 == null) {
                    this.f63942e.compareAndSet(null, g.h());
                } else {
                    this.f63942e.compareAndSet(null, (g) e2);
                }
            }
            return this.f63942e.get();
        }
        return (g) invokeV.objValue;
    }

    public h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f63940c.get() == null) {
                Object e2 = e(h.class, System.getProperties());
                if (e2 == null) {
                    this.f63940c.compareAndSet(null, i.e());
                } else {
                    this.f63940c.compareAndSet(null, (h) e2);
                }
            }
            return this.f63940c.get();
        }
        return (h) invokeV.objValue;
    }
}
