package d.a.f0.b;

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
import d.a.f0.a.c.g;
import d.a.f0.b.g.h;
import d.a.f0.b.g.j;
import d.a.f0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f42730a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.b.c f42731b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f42732c;

    /* renamed from: d  reason: collision with root package name */
    public int f42733d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f42734e;

    /* renamed from: d.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0597a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42735e;

        public RunnableC0597a(a aVar) {
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
            this.f42735e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42735e.f42734e = true;
                g.f42727a.e("Afd", "执行超时回调");
                h l = d.a.f0.b.g.f.l();
                if (this.f42735e.f42731b == null) {
                    return;
                }
                if (l == null) {
                    this.f42735e.f42731b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f42735e.f42731b.b(l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.b.a f42736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f42737b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f42738c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f42739d;

        public b(a aVar, d.a.f0.a.b.a aVar2, long j, long j2) {
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
            this.f42739d = aVar;
            this.f42736a = aVar2;
            this.f42737b = j;
            this.f42738c = j2;
        }

        @Override // d.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f42727a;
                gVar.e("Afd", "update接口 " + th.getMessage());
                this.f42739d.k(this.f42736a, this.f42737b, this.f42738c, th.getMessage(), "update");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f42739d.k(this.f42736a, this.f42737b, this.f42738c, "200", "update");
                try {
                    d.a.f0.b.g.a.b(str, this.f42736a.l());
                } catch (ParseError e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.b.a f42740a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f42741b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f42742c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.b.c f42743d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42744e;

        public c(a aVar, d.a.f0.a.b.a aVar2, long j, long j2, d.a.f0.b.c cVar) {
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
            this.f42744e = aVar;
            this.f42740a = aVar2;
            this.f42741b = j;
            this.f42742c = j2;
            this.f42743d = cVar;
        }

        @Override // d.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f42727a;
                gVar.e("Afd", "query接口 " + th.getMessage());
                this.f42744e.k(this.f42740a, this.f42741b, this.f42742c, th.getMessage(), "query");
                if (!this.f42744e.f42734e) {
                    if (this.f42744e.f42730a != null) {
                        this.f42744e.f42730a.removeCallbacksAndMessages(null);
                        this.f42744e.f42730a.post(this.f42744e.f42732c);
                        return;
                    }
                    return;
                }
                g gVar2 = g.f42727a;
                StringBuilder sb = new StringBuilder();
                sb.append("query接口 error 超时：");
                sb.append(System.currentTimeMillis() - this.f42741b);
                sb.append(" cause : ");
                sb.append(th);
                gVar2.e("Afd", sb.toString() == null ? "unknow" : th.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f42744e.k(this.f42740a, this.f42741b, this.f42742c, "200", "query");
                if (!this.f42744e.f42734e) {
                    this.f42744e.f42730a.removeCallbacksAndMessages(null);
                    try {
                        List<h> b2 = d.a.f0.b.g.a.b(str, this.f42740a.l());
                        if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                            this.f42743d.b(b2.get(0));
                        } else {
                            this.f42743d.a(new Throwable("no ad"));
                        }
                        return;
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.f42743d.a(e2);
                        return;
                    }
                }
                g gVar = g.f42727a;
                gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f42741b));
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
        this.f42730a = new Handler(Looper.getMainLooper());
        this.f42732c = new RunnableC0597a(this);
        this.f42733d = 5000;
        this.f42734e = false;
    }

    public final void g(Request.c cVar, d.a.f0.a.b.a aVar) {
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
            cVar.j("nt", String.valueOf(new d.a.f0.d.a.f(aVar.o()).d()));
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

    public final void h(Request.c cVar, String str, d.a.f0.a.b.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cVar, str, aVar, Long.valueOf(j)}) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.APP_KEY, "cmd");
                jSONObject.put("v", str);
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                List<h> p = d.a.f0.b.g.f.p();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                if (p != null && p.size() > 0) {
                    for (h hVar : p) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(Config.APP_KEY, hVar.f42786c);
                        if (!TextUtils.isEmpty(hVar.f42786c)) {
                            int e2 = d.a.f0.b.g.f.e(hVar);
                            Log.e("Afd", "onAdSuccess: " + e2);
                            if (e2 == 0) {
                                arrayList.add(hVar.f42786c);
                            }
                        }
                        jSONObject3.put(r.f7788a, String.valueOf(hVar.w));
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

    public final Request.c i(d.a.f0.a.b.a aVar, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, Long.valueOf(j)})) == null) {
            String a2 = d.a.f0.a.a.a.a();
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

    public void j(d.a.f0.a.b.a aVar, d.a.f0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, cVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.f0.b.g.c.a(String.valueOf(currentTimeMillis));
            Request.c i2 = i(aVar, "query", aVar.l(), currentTimeMillis);
            i2.o(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new c(this, aVar, currentTimeMillis, currentTimeMillis2, cVar));
            this.f42731b = cVar;
            this.f42734e = false;
            int t = aVar.t() - d.a.f0.b.g.g.f();
            this.f42733d = t;
            Handler handler = this.f42730a;
            if (handler != null) {
                handler.postDelayed(this.f42732c, t);
            }
        }
    }

    public final void k(d.a.f0.a.b.a aVar, long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            Als.f(String.valueOf(j), aVar.l(), str, j2 - j, System.currentTimeMillis() - j2, str2);
        }
    }

    public void l(d.a.f0.a.b.a aVar) {
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
