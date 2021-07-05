package d.a.t.f.a;

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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static b f70279i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f70280a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f70281b;

    /* renamed from: c  reason: collision with root package name */
    public c f70282c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.t.f.a.k.b f70283d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f70284e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f70285f;

    /* renamed from: g  reason: collision with root package name */
    public j f70286g;

    /* renamed from: h  reason: collision with root package name */
    public Context f70287h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f70288e;

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
            this.f70288e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f70288e;
                bVar.f70282c = new g(bVar.f70287h);
                if (this.f70288e.f70286g != null) {
                    this.f70288e.f70286g.a(this.f70288e.f70282c.a());
                    z = this.f70288e.f70286g.a();
                } else {
                    z = false;
                }
                if (z && this.f70288e.k()) {
                    this.f70288e.m();
                    this.f70288e.o();
                }
                this.f70288e.f70280a = null;
            }
        }
    }

    /* renamed from: d.a.t.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1935b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1935b f70289a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1935b(Context context) {
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
            if (b.f70279i == null) {
                synchronized (b.class) {
                    if (b.f70279i == null) {
                        b unused = b.f70279i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1935b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f70289a == null) {
                    synchronized (b.class) {
                        if (f70289a == null) {
                            f70289a = new C1935b(context);
                        }
                    }
                }
                return f70289a;
            }
            return (C1935b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f70279i.f70284e = new HashMap();
                b.f70279i.f70284e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f70279i.f70284e.put("Content-type", "application/json");
                b.f70279i.f70283d = new d.a.t.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f70279i.f70283d == null) {
                    a();
                }
                return b.f70279i;
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
        this.f70281b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f70287h = context;
        this.f70286g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.t.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f70285f;
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
        d.a.t.f.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            d.a.t.f.a.k.b bVar = this.f70283d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f70284e, this.f70282c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f70286g) == null) {
            return;
        }
        jVar.b(this.f70282c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f70281b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f70281b.get() == 0) {
                    if (this.f70287h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f70281b.set(1);
                    if (this.f70280a == null) {
                        this.f70280a = new Thread(h());
                    }
                    this.f70280a.start();
                }
            }
        }
    }
}
