package d.a.r.f.a;

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
    public static b f67137i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread f67138a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f67139b;

    /* renamed from: c  reason: collision with root package name */
    public c f67140c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.r.f.a.k.b f67141d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f67142e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f67143f;

    /* renamed from: g  reason: collision with root package name */
    public j f67144g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67145h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67146e;

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
            this.f67146e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f67146e;
                bVar.f67140c = new g(bVar.f67145h);
                if (this.f67146e.f67144g != null) {
                    this.f67146e.f67144g.a(this.f67146e.f67140c.a());
                    z = this.f67146e.f67144g.a();
                } else {
                    z = false;
                }
                if (z && this.f67146e.k()) {
                    this.f67146e.m();
                    this.f67146e.o();
                }
                this.f67146e.f67138a = null;
            }
        }
    }

    /* renamed from: d.a.r.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1897b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1897b f67147a;
        public transient /* synthetic */ FieldHolder $fh;

        public C1897b(Context context) {
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
            if (b.f67137i == null) {
                synchronized (b.class) {
                    if (b.f67137i == null) {
                        b unused = b.f67137i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1897b c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (f67147a == null) {
                    synchronized (b.class) {
                        if (f67147a == null) {
                            f67147a = new C1897b(context);
                        }
                    }
                }
                return f67147a;
            }
            return (C1897b) invokeL.objValue;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.f67137i.f67142e = new HashMap();
                b.f67137i.f67142e.put(BOSTokenRequest.CHARSET, "utf-8");
                b.f67137i.f67142e.put("Content-type", "application/json");
                b.f67137i.f67141d = new d.a.r.f.a.r.a();
            }
        }

        public b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (b.f67137i.f67141d == null) {
                    a();
                }
                return b.f67137i;
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
        this.f67139b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f67145h = context;
        this.f67144g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.r.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("url should not be empty");
            }
            HashMap<String, String> hashMap = this.f67143f;
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
        d.a.r.f.a.k.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String e2 = e("https://mbd.baidu.com/store");
            d.a.r.f.a.k.b bVar = this.f67141d;
            JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f67142e, this.f67140c.a()));
            return a3 != null && a3.optInt("errno", -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f67144g) == null) {
            return;
        }
        jVar.b(this.f67140c.a());
    }

    public final void o() {
        AtomicInteger atomicInteger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (atomicInteger = this.f67139b) == null) {
            return;
        }
        atomicInteger.set(2);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (b.class) {
                if (this.f67139b.get() == 0) {
                    if (this.f67145h == null) {
                        throw new NullPointerException("context should not be null");
                    }
                    this.f67139b.set(1);
                    if (this.f67138a == null) {
                        this.f67138a = new Thread(h());
                    }
                    this.f67138a.start();
                }
            }
        }
    }
}
