package d.a.s.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static b f67815i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f67816a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f67817b;

    /* renamed from: c  reason: collision with root package name */
    public c f67818c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s.f.a.k.b f67819d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f67820e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f67821f;

    /* renamed from: g  reason: collision with root package name */
    public j f67822g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67823h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67824e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67824e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f67824e;
                bVar.f67818c = new g(bVar.f67823h);
                if (this.f67824e.f67822g != null) {
                    this.f67824e.f67822g.a(this.f67824e.f67818c.a());
                    z = this.f67824e.f67822g.a();
                } else {
                    z = false;
                }
                if (z && this.f67824e.k()) {
                    this.f67824e.m();
                    this.f67824e.o();
                }
                this.f67824e.f67816a = null;
            }
        }
    }

    /* renamed from: d.a.s.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1902b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1902b f67825a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1902b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f67815i == null) {
                synchronized (b.class) {
                    if (b.f67815i == null) {
                        b unused = b.f67815i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1902b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f67825a == null) {
                    synchronized (b.class) {
                        if (f67825a == null) {
                            f67825a = new C1902b(context);
                        }
                    }
                }
                return f67825a;
            }
            return (C1902b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f67815i.f67820e = new HashMap();
                b.f67815i.f67820e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f67815i.f67820e.put("Content-type", "application/json");
                b.f67815i.f67819d = new d.a.s.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f67815i.f67819d == null) {
                    a();
                }
                return b.f67815i;
            }
            return (b) invokeV.objValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67817b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f67823h = context;
        this.f67822g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.s.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f67821f;
            return hashMap == null ? str : q.b(str, hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final Runnable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (Runnable) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        d.a.s.f.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            d.a.s.f.a.k.b bVar = this.f67819d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f67820e, this.f67818c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f67822g) == null) {
            return;
        }
        jVar.b(this.f67818c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f67817b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f67817b.get() == 0) {
                    if (this.f67823h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f67817b.set(1);
                    if (this.f67816a == null) {
                        this.f67816a = new Thread(h());
                    }
                    this.f67816a.start();
                }
            }
        }
    }
}
