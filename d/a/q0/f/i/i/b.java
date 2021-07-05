package d.a.q0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.i.d;
import d.a.q0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements d.a.q0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52560a;

    /* renamed from: b  reason: collision with root package name */
    public String f52561b;

    /* renamed from: c  reason: collision with root package name */
    public String f52562c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.f.i.i.f f52563d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.f.i.i.c f52564e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.f.i.o.b f52565f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f52566g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.f.i.i.d f52567h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52568i;
    public String j;
    public boolean k;
    public d.a.q0.f.i.k.b l;
    public Map<String, String> m;
    public d.a.q0.f.i.l.f n;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52569e;

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
            this.f52569e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52569e.f52567h == null || this.f52569e.f52567h.f() == null || !this.f52569e.n.c(this.f52569e.f52567h.f())) {
                return;
            }
            this.f52569e.n.removeView(this.f52569e.f52567h.f());
        }
    }

    /* renamed from: d.a.q0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1093b implements d.a.q0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52570a;

        public C1093b(b bVar) {
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
            this.f52570a = bVar;
        }

        @Override // d.a.q0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // d.a.q0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f52570a.k) {
                this.f52570a.A(view);
                if (this.f52570a.f52563d != null) {
                    this.f52570a.f52563d.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52571a;

        public c(b bVar) {
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
            this.f52571a = bVar;
        }

        @Override // d.a.q0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f52571a.f52566g == null) {
                return;
            }
            String clickUrl = this.f52571a.f52566g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", d.a.q0.f.i.q.b.b("landingPageLoad", this.f52571a.m));
            } catch (JSONException unused) {
            }
            this.f52571a.n.a(clickUrl, jSONObject);
            d.a.q0.f.i.q.b.g(this.f52571a.f52566g, this.f52571a.f52565f);
            d.a.q0.f.i.q.b.n("lpClick", this.f52571a.m, this.f52571a.f52565f);
            d.a.q0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f52571a.m, this.f52571a.f52565f);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f52573f;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52573f = bVar;
            this.f52572e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.f.i.i.c cVar = this.f52573f.f52564e;
                boolean z = cVar.f52580c != cVar.f52582e;
                this.f52573f.x();
                if (this.f52573f.f52567h != null) {
                    this.f52573f.f52567h.e(this.f52573f.f52564e.f52580c);
                    this.f52573f.n.f(this.f52573f.f52567h.f(), new d.a.q0.f.i.i.a(d.a.q0.f.i.r.h.a(this.f52573f.f52564e.f52578a), d.a.q0.f.i.r.h.a(this.f52573f.f52564e.f52579b), d.a.q0.f.i.r.h.a(this.f52573f.f52564e.f52582e), d.a.q0.f.i.r.h.a(this.f52573f.f52564e.f52583f)));
                }
                if (this.f52572e.equals("width") && z && this.f52573f.f52563d != null) {
                    d.a.q0.f.i.i.f fVar = this.f52573f.f52563d;
                    d.a.q0.f.i.i.c cVar2 = this.f52573f.f52564e;
                    fVar.b(cVar2.f52582e, cVar2.f52583f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52574e;

        public e(b bVar) {
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
            this.f52574e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52574e.f52567h == null || !this.f52574e.n.c(this.f52574e.f52567h.f())) {
                    if (this.f52574e.f52563d != null) {
                        this.f52574e.f52563d.onShow(false);
                        this.f52574e.f52563d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f52574e.f52567h.l();
                if (this.f52574e.f52563d != null) {
                    this.f52574e.f52563d.onShow(true);
                }
                d.a.q0.f.i.q.b.n("showSuccess", this.f52574e.m, this.f52574e.f52565f);
                if (this.f52574e.f52568i) {
                    return;
                }
                this.f52574e.f52568i = true;
                if (this.f52574e.k) {
                    d.a.q0.f.i.q.d.f(this.f52574e.f52566g, this.f52574e.f52565f);
                    return;
                }
                d.a.q0.f.i.q.b.j(this.f52574e.f52566g, this.f52574e.f52565f);
                String str = this.f52574e.f52562c;
                b bVar = this.f52574e;
                d.a.q0.f.i.q.b.f(str, bVar.f52561b, bVar.j, this.f52574e.f52565f);
                d.a.q0.f.i.q.b.n("show", this.f52574e.m, this.f52574e.f52565f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f52575a;

        public f(b bVar) {
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
            this.f52575a = bVar;
        }

        @Override // d.a.q0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f52575a.l == null) {
                    this.f52575a.l = new d.a.q0.f.i.k.b(this.f52575a.f52560a, this.f52575a.f52566g, this.f52575a.f52565f);
                }
                this.f52575a.l.k(str);
                d.a.q0.f.i.m.a.b().b(this.f52575a.f52560a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f52575a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.q0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52576e;

        public g(b bVar) {
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
            this.f52576e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52576e.f52567h == null) {
                return;
            }
            this.f52576e.f52567h.g();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52577e;

        public h(b bVar) {
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
            this.f52577e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52577e.f52567h != null) {
                    this.f52577e.n.removeView(this.f52577e.f52567h.f());
                }
                this.f52577e.f52567h = null;
                this.f52577e.f52563d = null;
                this.f52577e.f52566g = null;
                if (this.f52577e.l != null) {
                    this.f52577e.l.i();
                    this.f52577e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, d.a.q0.f.i.i.f fVar, d.a.q0.f.i.l.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar, fVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52564e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f52560a = appContext;
        this.f52562c = str;
        this.f52561b = str2;
        this.f52563d = fVar;
        this.n = fVar2;
        this.f52565f = new d.a.q0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f52566g) == null || this.f52564e == null || view == null) {
            return;
        }
        d.a.q0.f.i.q.d.d(adElementInfo, this.f52565f);
        d.a.q0.f.i.q.a aVar = new d.a.q0.f.i.q.a();
        aVar.f52743a = String.valueOf(this.f52564e.f52580c);
        aVar.f52744b = String.valueOf(this.f52564e.f52581d);
        aVar.f52745c = String.valueOf(this.f52564e.f52580c);
        aVar.f52746d = String.valueOf(this.f52564e.f52581d);
        aVar.f52747e = String.valueOf((int) view.getX());
        aVar.f52748f = String.valueOf((int) view.getY());
        aVar.f52749g = String.valueOf((int) view.getX());
        aVar.f52750h = String.valueOf((int) view.getY());
        if (this.f52566g.getActionType() == 2) {
            d.a.q0.f.i.q.d.a(aVar, this.f52566g, this.f52565f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f52566g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.q0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.f.i.i.d dVar = new d.a.q0.f.i.i.d(this.f52560a, this.f52566g, this.f52561b, this.k);
            this.f52567h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f52567h.k(new C1093b(this));
            } else {
                this.f52567h.j(new c(this));
            }
            this.f52567h.e(this.f52564e.f52580c);
            if (this.n.c(this.f52567h.f())) {
                this.n.removeView(this.f52567h.f());
            }
            if (this.n.d(this.f52567h.f(), new d.a.q0.f.i.i.a(d.a.q0.f.i.r.h.a(this.f52564e.f52578a), d.a.q0.f.i.r.h.a(this.f52564e.f52579b), d.a.q0.f.i.r.h.a(this.f52564e.f52582e), d.a.q0.f.i.r.h.a(this.f52564e.f52583f)))) {
                d.a.q0.f.i.i.f fVar = this.f52563d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            d.a.q0.f.i.i.f fVar2 = this.f52563d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        d.a.q0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.f.i.q.b.n("loadApi", this.m, this.f52565f);
            String appKey = d.a.q0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f52562c);
            bVar.j(this.f52561b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f52564e.f52580c);
            bVar.i(this.f52564e.f52581d);
            d.a.q0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new d.a.q0.f.i.o.f(this.f52560a, h2, 1, z());
            } else {
                dVar = new d.a.q0.f.i.o.d(this.f52560a, h2);
                this.j = dVar.c();
            }
            d.a.q0.f.i.o.a aVar = new d.a.q0.f.i.o.a(this.f52560a, false);
            aVar.k(this);
            aVar.i(dVar, this.f52565f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f52564e = new d.a.q0.f.i.i.c(i2, i3, i4, i5);
            x();
        }
    }

    public void F(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.m = map;
        }
    }

    public void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            d.a.q0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            d.a.q0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // d.a.q0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.a.q0.f.i.i.f fVar = this.f52563d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = d.a.q0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            d.a.q0.f.i.i.f fVar2 = this.f52563d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // d.a.q0.f.i.i.d.e
    public void b() {
        d.a.q0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f52563d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // d.a.q0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f52566g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.q0.f.i.i.d dVar = new d.a.q0.f.i.i.d(this.f52560a);
            this.f52567h = dVar;
            dVar.e(this.f52564e.f52580c);
            if (this.f52567h.f() == null) {
                return;
            }
            if (this.n.c(this.f52567h.f())) {
                this.n.removeView(this.f52567h.f());
            }
            this.n.d(this.f52567h.f(), new d.a.q0.f.i.i.a(d.a.q0.f.i.r.h.a(this.f52564e.f52578a), d.a.q0.f.i.r.h.a(this.f52564e.f52579b), d.a.q0.f.i.r.h.a(this.f52564e.f52582e), d.a.q0.f.i.r.h.a(this.f52564e.f52583f)));
            this.f52567h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        d.a.q0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f52564e) == null) {
            return;
        }
        if (d.a.q0.f.i.r.h.a(cVar.f52580c) < 300) {
            this.f52564e.f52580c = d.a.q0.f.i.r.h.p(300.0f);
        }
        int q = d.a.q0.f.i.m.a.b().q();
        int p = d.a.q0.f.i.m.a.b().p();
        if (d.a.q0.f.i.r.h.a(this.f52564e.f52580c) > q) {
            this.f52564e.f52580c = d.a.q0.f.i.r.h.p(q);
        }
        d.a.q0.f.i.i.c cVar2 = this.f52564e;
        cVar2.f52581d = (int) (cVar2.f52580c / d.a.q0.f.i.i.e.f52597a);
        if (cVar2.f52578a < 0) {
            cVar2.f52578a = 0;
        }
        int p2 = d.a.q0.f.i.r.h.p(q);
        d.a.q0.f.i.i.c cVar3 = this.f52564e;
        int i2 = p2 - cVar3.f52580c;
        if (cVar3.f52578a > i2) {
            cVar3.f52578a = i2;
        }
        d.a.q0.f.i.i.c cVar4 = this.f52564e;
        if (cVar4.f52579b < 0) {
            cVar4.f52579b = 0;
        }
        int p3 = d.a.q0.f.i.r.h.p(p);
        d.a.q0.f.i.i.c cVar5 = this.f52564e;
        int i3 = p3 - cVar5.f52581d;
        if (cVar5.f52579b > i3) {
            cVar5.f52579b = i3;
        }
        d.a.q0.f.i.i.c cVar6 = this.f52564e;
        cVar6.f52582e = cVar6.f52580c;
        cVar6.f52583f = cVar6.f52581d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.q0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f52564e == null) {
                return 2;
            }
            int p = d.a.q0.f.i.r.h.p(d.a.q0.f.i.m.a.b().p());
            int i2 = this.f52564e.f52579b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
