package d.a.h0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.Request;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import d.a.h0.a.c.g;
import d.a.h0.b.g.h;
import d.a.h0.b.g.j;
import d.a.h0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f45578a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.b.c f45579b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f45580c;

    /* renamed from: d  reason: collision with root package name */
    public int f45581d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f45582e;

    /* renamed from: d.a.h0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0639a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45583e;

        public RunnableC0639a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45583e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45583e.f45582e = true;
                g.f45575a.e("Afd", "执行超时回调");
                h l = d.a.h0.b.g.f.l();
                if (this.f45583e.f45579b == null) {
                    return;
                }
                if (l == null) {
                    this.f45583e.f45579b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f45583e.f45579b.b(l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b.a f45584a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f45585b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f45586c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f45587d;

        public b(a aVar, d.a.h0.a.b.a aVar2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45587d = aVar;
            this.f45584a = aVar2;
            this.f45585b = j;
            this.f45586c = j2;
        }

        @Override // d.a.h0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f45575a;
                gVar.e("Afd", "update接口 " + th.getMessage());
                this.f45587d.k(this.f45584a, this.f45585b, this.f45586c, th.getMessage(), "update");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f45587d.k(this.f45584a, this.f45585b, this.f45586c, "200", "update");
                try {
                    d.a.h0.b.g.a.b(str, this.f45584a.l());
                } catch (ParseError e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b.a f45588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f45589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f45590c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.b.c f45591d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45592e;

        public c(a aVar, d.a.h0.a.b.a aVar2, long j, long j2, d.a.h0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j), Long.valueOf(j2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45592e = aVar;
            this.f45588a = aVar2;
            this.f45589b = j;
            this.f45590c = j2;
            this.f45591d = cVar;
        }

        @Override // d.a.h0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f45575a;
                gVar.e("Afd", "query接口 " + th.getMessage());
                this.f45592e.k(this.f45588a, this.f45589b, this.f45590c, th.getMessage(), "query");
                if (!this.f45592e.f45582e) {
                    if (this.f45592e.f45578a != null) {
                        this.f45592e.f45578a.removeCallbacksAndMessages(null);
                        this.f45592e.f45578a.post(this.f45592e.f45580c);
                        return;
                    }
                    return;
                }
                g gVar2 = g.f45575a;
                StringBuilder sb = new StringBuilder();
                sb.append("query接口 error 超时：");
                sb.append(System.currentTimeMillis() - this.f45589b);
                sb.append(" cause : ");
                sb.append(th);
                gVar2.e("Afd", sb.toString() == null ? "unknow" : th.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f45592e.k(this.f45588a, this.f45589b, this.f45590c, "200", "query");
                if (!this.f45592e.f45582e) {
                    this.f45592e.f45578a.removeCallbacksAndMessages(null);
                    try {
                        List<h> b2 = d.a.h0.b.g.a.b(str, this.f45588a.l());
                        if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                            this.f45591d.b(b2.get(0));
                        } else {
                            this.f45591d.a(new Throwable("no ad"));
                        }
                        return;
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.f45591d.a(e2);
                        return;
                    }
                }
                g gVar = g.f45575a;
                gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f45589b));
            }
        }
    }

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
                return;
            }
        }
        this.f45578a = new Handler(Looper.getMainLooper());
        this.f45580c = new RunnableC0639a(this);
        this.f45581d = 5000;
        this.f45582e = false;
    }

    public final void g(Request.c cVar, d.a.h0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, aVar) == null) {
            cVar.j("ver", aVar.D());
            cVar.j("sv", "1.0");
            cVar.j("uid", aVar.w());
            cVar.j("bdid", aVar.k());
            cVar.j("cuid", aVar.f());
            cVar.j(SearchJsBridge.COOKIE_MOD, aVar.q());
            cVar.j(SearchJsBridge.COOKIE_OV, aVar.g());
            cVar.j("imei", aVar.C());
            cVar.j("ua", aVar.n());
            cVar.j("fmt", "json");
            cVar.j("coot", aVar.j());
            if (aVar.x() != null && aVar.x().length > 1) {
                cVar.j("lgt", aVar.x()[0]);
                cVar.j(SuggestAddrField.KEY_LAT, aVar.x()[1]);
            }
            cVar.j("apna", aVar.i());
            cVar.j("eid", aVar.y());
            cVar.j("st", "1");
            cVar.j("ot", "2");
            cVar.j("nt", String.valueOf(new d.a.h0.d.a.f(aVar.o()).d()));
            cVar.j(Config.EXCEPTION_CRASH_TYPE, "2");
            cVar.j("is_https", "1");
            cVar.j(IAdRequestParam.ANDROID_ID, aVar.a());
            cVar.j("from", aVar.from());
            cVar.j("cfrom", aVar.b());
            cVar.k("User-Agent", aVar.h());
            if (TextUtils.isEmpty(aVar.m())) {
                return;
            }
            cVar.j("oaid", aVar.m());
        }
    }

    public final void h(Request.c cVar, String str, d.a.h0.a.b.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cVar, str, aVar, Long.valueOf(j)}) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.APP_KEY, "cmd");
                jSONObject.put("v", str);
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                List<h> p = d.a.h0.b.g.f.p();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                if (p != null && p.size() > 0) {
                    for (h hVar : p) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(Config.APP_KEY, hVar.f45634c);
                        if (!TextUtils.isEmpty(hVar.f45634c)) {
                            int e2 = d.a.h0.b.g.f.e(hVar);
                            Log.e("Afd", "onAdSuccess: " + e2);
                            if (e2 == 0) {
                                arrayList.add(hVar.f45634c);
                            }
                        }
                        jSONObject3.put(r.f7745a, String.valueOf(hVar.w));
                        jSONArray2.put(jSONObject3);
                    }
                }
                jSONObject2.put("d", jSONArray2);
                jSONObject2.put("s", j.b());
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(Config.APP_KEY, Constants.KEYS.AD_INFO);
                jSONObject4.put("v", jSONObject2.toString());
                jSONArray.put(jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(Config.APP_KEY, "ukey");
                jSONObject5.put("v", TextUtils.join(",", arrayList));
                jSONArray.put(jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(Config.APP_KEY, "logid");
                jSONObject6.put("v", String.valueOf(j));
                jSONArray.put(jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(Config.APP_KEY, "uid");
                jSONObject7.put("v", aVar.w());
                jSONArray.put(jSONObject7);
                cVar.j("ext", jSONArray.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final Request.c i(d.a.h0.a.b.a aVar, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, Long.valueOf(j)})) == null) {
            String a2 = d.a.h0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            Request.c cVar = new Request.c(aVar.o(), sb.toString());
            cVar.j("ac", "3");
            cVar.j("pid", str2);
            cVar.j("product_id ", aVar.p());
            g(cVar, aVar);
            h(cVar, str, aVar, j);
            return cVar;
        }
        return (Request.c) invokeCommon.objValue;
    }

    public void j(d.a.h0.a.b.a aVar, d.a.h0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, cVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.h0.b.g.c.a(String.valueOf(currentTimeMillis));
            Request.c i2 = i(aVar, "query", aVar.l(), currentTimeMillis);
            i2.o(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new c(this, aVar, currentTimeMillis, currentTimeMillis2, cVar));
            this.f45579b = cVar;
            this.f45582e = false;
            int t = aVar.t() - d.a.h0.b.g.g.e();
            this.f45581d = t;
            Handler handler = this.f45578a;
            if (handler != null) {
                handler.postDelayed(this.f45580c, t);
            }
        }
    }

    public final void k(d.a.h0.a.b.a aVar, long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            Als.f(String.valueOf(j), aVar.l(), str, j2 - j, System.currentTimeMillis() - j2, str2);
        }
    }

    public void l(d.a.h0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Request.c i2 = i(aVar, "update", aVar.l(), currentTimeMillis);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new b(this, aVar, currentTimeMillis, currentTimeMillis2));
        }
    }
}
