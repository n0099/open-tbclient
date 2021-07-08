package d.a.n0.f.i.i;

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
import d.a.n0.f.i.i.d;
import d.a.n0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.n0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49258a;

    /* renamed from: b  reason: collision with root package name */
    public String f49259b;

    /* renamed from: c  reason: collision with root package name */
    public String f49260c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.f.i.i.f f49261d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.f.i.i.c f49262e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.f.i.o.b f49263f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f49264g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.f.i.i.d f49265h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49266i;
    public String j;
    public boolean k;
    public d.a.n0.f.i.k.b l;
    public Map<String, String> m;
    public d.a.n0.f.i.l.f n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49267e;

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
            this.f49267e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49267e.f49265h == null || this.f49267e.f49265h.f() == null || !this.f49267e.n.c(this.f49267e.f49265h.f())) {
                return;
            }
            this.f49267e.n.removeView(this.f49267e.f49265h.f());
        }
    }

    /* renamed from: d.a.n0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1042b implements d.a.n0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49268a;

        public C1042b(b bVar) {
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
            this.f49268a = bVar;
        }

        @Override // d.a.n0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // d.a.n0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f49268a.k) {
                this.f49268a.A(view);
                if (this.f49268a.f49261d != null) {
                    this.f49268a.f49261d.onClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49269a;

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
            this.f49269a = bVar;
        }

        @Override // d.a.n0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f49269a.f49264g == null) {
                return;
            }
            String clickUrl = this.f49269a.f49264g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", d.a.n0.f.i.q.b.b("landingPageLoad", this.f49269a.m));
            } catch (JSONException unused) {
            }
            this.f49269a.n.a(clickUrl, jSONObject);
            d.a.n0.f.i.q.b.g(this.f49269a.f49264g, this.f49269a.f49263f);
            d.a.n0.f.i.q.b.n("lpClick", this.f49269a.m, this.f49269a.f49263f);
            d.a.n0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f49269a.m, this.f49269a.f49263f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f49271f;

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
            this.f49271f = bVar;
            this.f49270e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.f.i.i.c cVar = this.f49271f.f49262e;
                boolean z = cVar.f49278c != cVar.f49280e;
                this.f49271f.x();
                if (this.f49271f.f49265h != null) {
                    this.f49271f.f49265h.e(this.f49271f.f49262e.f49278c);
                    this.f49271f.n.f(this.f49271f.f49265h.f(), new d.a.n0.f.i.i.a(d.a.n0.f.i.r.h.a(this.f49271f.f49262e.f49276a), d.a.n0.f.i.r.h.a(this.f49271f.f49262e.f49277b), d.a.n0.f.i.r.h.a(this.f49271f.f49262e.f49280e), d.a.n0.f.i.r.h.a(this.f49271f.f49262e.f49281f)));
                }
                if (this.f49270e.equals("width") && z && this.f49271f.f49261d != null) {
                    d.a.n0.f.i.i.f fVar = this.f49271f.f49261d;
                    d.a.n0.f.i.i.c cVar2 = this.f49271f.f49262e;
                    fVar.b(cVar2.f49280e, cVar2.f49281f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49272e;

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
            this.f49272e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49272e.f49265h == null || !this.f49272e.n.c(this.f49272e.f49265h.f())) {
                    if (this.f49272e.f49261d != null) {
                        this.f49272e.f49261d.onShow(false);
                        this.f49272e.f49261d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f49272e.f49265h.l();
                if (this.f49272e.f49261d != null) {
                    this.f49272e.f49261d.onShow(true);
                }
                d.a.n0.f.i.q.b.n("showSuccess", this.f49272e.m, this.f49272e.f49263f);
                if (this.f49272e.f49266i) {
                    return;
                }
                this.f49272e.f49266i = true;
                if (this.f49272e.k) {
                    d.a.n0.f.i.q.d.f(this.f49272e.f49264g, this.f49272e.f49263f);
                    return;
                }
                d.a.n0.f.i.q.b.j(this.f49272e.f49264g, this.f49272e.f49263f);
                String str = this.f49272e.f49260c;
                b bVar = this.f49272e;
                d.a.n0.f.i.q.b.f(str, bVar.f49259b, bVar.j, this.f49272e.f49263f);
                d.a.n0.f.i.q.b.n("show", this.f49272e.m, this.f49272e.f49263f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49273a;

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
            this.f49273a = bVar;
        }

        @Override // d.a.n0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f49273a.l == null) {
                    this.f49273a.l = new d.a.n0.f.i.k.b(this.f49273a.f49258a, this.f49273a.f49264g, this.f49273a.f49263f);
                }
                this.f49273a.l.k(str);
                d.a.n0.f.i.m.a.b().b(this.f49273a.f49258a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f49273a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.n0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49274e;

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
            this.f49274e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49274e.f49265h == null) {
                return;
            }
            this.f49274e.f49265h.g();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49275e;

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
            this.f49275e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49275e.f49265h != null) {
                    this.f49275e.n.removeView(this.f49275e.f49265h.f());
                }
                this.f49275e.f49265h = null;
                this.f49275e.f49261d = null;
                this.f49275e.f49264g = null;
                if (this.f49275e.l != null) {
                    this.f49275e.l.i();
                    this.f49275e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, d.a.n0.f.i.i.f fVar, d.a.n0.f.i.l.f fVar2) {
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
        this.f49262e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f49258a = appContext;
        this.f49260c = str;
        this.f49259b = str2;
        this.f49261d = fVar;
        this.n = fVar2;
        this.f49263f = new d.a.n0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f49264g) == null || this.f49262e == null || view == null) {
            return;
        }
        d.a.n0.f.i.q.d.d(adElementInfo, this.f49263f);
        d.a.n0.f.i.q.a aVar = new d.a.n0.f.i.q.a();
        aVar.f49441a = String.valueOf(this.f49262e.f49278c);
        aVar.f49442b = String.valueOf(this.f49262e.f49279d);
        aVar.f49443c = String.valueOf(this.f49262e.f49278c);
        aVar.f49444d = String.valueOf(this.f49262e.f49279d);
        aVar.f49445e = String.valueOf((int) view.getX());
        aVar.f49446f = String.valueOf((int) view.getY());
        aVar.f49447g = String.valueOf((int) view.getX());
        aVar.f49448h = String.valueOf((int) view.getY());
        if (this.f49264g.getActionType() == 2) {
            d.a.n0.f.i.q.d.a(aVar, this.f49264g, this.f49263f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f49264g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.n0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.n0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.n0.f.i.i.d dVar = new d.a.n0.f.i.i.d(this.f49258a, this.f49264g, this.f49259b, this.k);
            this.f49265h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f49265h.k(new C1042b(this));
            } else {
                this.f49265h.j(new c(this));
            }
            this.f49265h.e(this.f49262e.f49278c);
            if (this.n.c(this.f49265h.f())) {
                this.n.removeView(this.f49265h.f());
            }
            if (this.n.d(this.f49265h.f(), new d.a.n0.f.i.i.a(d.a.n0.f.i.r.h.a(this.f49262e.f49276a), d.a.n0.f.i.r.h.a(this.f49262e.f49277b), d.a.n0.f.i.r.h.a(this.f49262e.f49280e), d.a.n0.f.i.r.h.a(this.f49262e.f49281f)))) {
                d.a.n0.f.i.i.f fVar = this.f49261d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            d.a.n0.f.i.i.f fVar2 = this.f49261d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        d.a.n0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.n0.f.i.q.b.n("loadApi", this.m, this.f49263f);
            String appKey = d.a.n0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f49260c);
            bVar.j(this.f49259b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f49262e.f49278c);
            bVar.i(this.f49262e.f49279d);
            d.a.n0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new d.a.n0.f.i.o.f(this.f49258a, h2, 1, z());
            } else {
                dVar = new d.a.n0.f.i.o.d(this.f49258a, h2);
                this.j = dVar.c();
            }
            d.a.n0.f.i.o.a aVar = new d.a.n0.f.i.o.a(this.f49258a, false);
            aVar.k(this);
            aVar.i(dVar, this.f49263f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f49262e = new d.a.n0.f.i.i.c(i2, i3, i4, i5);
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
            d.a.n0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            d.a.n0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // d.a.n0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.a.n0.f.i.i.f fVar = this.f49261d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = d.a.n0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            d.a.n0.f.i.i.f fVar2 = this.f49261d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // d.a.n0.f.i.i.d.e
    public void b() {
        d.a.n0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f49261d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // d.a.n0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f49264g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.n0.f.i.i.d dVar = new d.a.n0.f.i.i.d(this.f49258a);
            this.f49265h = dVar;
            dVar.e(this.f49262e.f49278c);
            if (this.f49265h.f() == null) {
                return;
            }
            if (this.n.c(this.f49265h.f())) {
                this.n.removeView(this.f49265h.f());
            }
            this.n.d(this.f49265h.f(), new d.a.n0.f.i.i.a(d.a.n0.f.i.r.h.a(this.f49262e.f49276a), d.a.n0.f.i.r.h.a(this.f49262e.f49277b), d.a.n0.f.i.r.h.a(this.f49262e.f49280e), d.a.n0.f.i.r.h.a(this.f49262e.f49281f)));
            this.f49265h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        d.a.n0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f49262e) == null) {
            return;
        }
        if (d.a.n0.f.i.r.h.a(cVar.f49278c) < 300) {
            this.f49262e.f49278c = d.a.n0.f.i.r.h.p(300.0f);
        }
        int q = d.a.n0.f.i.m.a.b().q();
        int p = d.a.n0.f.i.m.a.b().p();
        if (d.a.n0.f.i.r.h.a(this.f49262e.f49278c) > q) {
            this.f49262e.f49278c = d.a.n0.f.i.r.h.p(q);
        }
        d.a.n0.f.i.i.c cVar2 = this.f49262e;
        cVar2.f49279d = (int) (cVar2.f49278c / d.a.n0.f.i.i.e.f49295a);
        if (cVar2.f49276a < 0) {
            cVar2.f49276a = 0;
        }
        int p2 = d.a.n0.f.i.r.h.p(q);
        d.a.n0.f.i.i.c cVar3 = this.f49262e;
        int i2 = p2 - cVar3.f49278c;
        if (cVar3.f49276a > i2) {
            cVar3.f49276a = i2;
        }
        d.a.n0.f.i.i.c cVar4 = this.f49262e;
        if (cVar4.f49277b < 0) {
            cVar4.f49277b = 0;
        }
        int p3 = d.a.n0.f.i.r.h.p(p);
        d.a.n0.f.i.i.c cVar5 = this.f49262e;
        int i3 = p3 - cVar5.f49279d;
        if (cVar5.f49277b > i3) {
            cVar5.f49277b = i3;
        }
        d.a.n0.f.i.i.c cVar6 = this.f49262e;
        cVar6.f49280e = cVar6.f49278c;
        cVar6.f49281f = cVar6.f49279d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.n0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f49262e == null) {
                return 2;
            }
            int p = d.a.n0.f.i.r.h.p(d.a.n0.f.i.m.a.b().p());
            int i2 = this.f49262e.f49277b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
