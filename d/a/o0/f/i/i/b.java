package d.a.o0.f.i.i;

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
import d.a.o0.f.i.i.d;
import d.a.o0.f.i.o.c;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.o0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49762a;

    /* renamed from: b  reason: collision with root package name */
    public String f49763b;

    /* renamed from: c  reason: collision with root package name */
    public String f49764c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.f.i.i.f f49765d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.f.i.i.c f49766e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.f.i.o.b f49767f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f49768g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.f.i.i.d f49769h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49770i;
    public String j;
    public boolean k;
    public d.a.o0.f.i.k.b l;
    public Map<String, String> m;
    public d.a.o0.f.i.l.f n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49771e;

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
            this.f49771e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49771e.f49769h == null || this.f49771e.f49769h.f() == null || !this.f49771e.n.c(this.f49771e.f49769h.f())) {
                return;
            }
            this.f49771e.n.removeView(this.f49771e.f49769h.f());
        }
    }

    /* renamed from: d.a.o0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1051b implements d.a.o0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49772a;

        public C1051b(b bVar) {
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
            this.f49772a = bVar;
        }

        @Override // d.a.o0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // d.a.o0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f49772a.k) {
                this.f49772a.A(view);
                if (this.f49772a.f49765d != null) {
                    this.f49772a.f49765d.onClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49773a;

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
            this.f49773a = bVar;
        }

        @Override // d.a.o0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f49773a.f49768g == null) {
                return;
            }
            String clickUrl = this.f49773a.f49768g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", d.a.o0.f.i.q.b.b("landingPageLoad", this.f49773a.m));
            } catch (JSONException unused) {
            }
            this.f49773a.n.a(clickUrl, jSONObject);
            d.a.o0.f.i.q.b.g(this.f49773a.f49768g, this.f49773a.f49767f);
            d.a.o0.f.i.q.b.n("lpClick", this.f49773a.m, this.f49773a.f49767f);
            d.a.o0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f49773a.m, this.f49773a.f49767f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f49775f;

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
            this.f49775f = bVar;
            this.f49774e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.f.i.i.c cVar = this.f49775f.f49766e;
                boolean z = cVar.f49782c != cVar.f49784e;
                this.f49775f.x();
                if (this.f49775f.f49769h != null) {
                    this.f49775f.f49769h.e(this.f49775f.f49766e.f49782c);
                    this.f49775f.n.f(this.f49775f.f49769h.f(), new d.a.o0.f.i.i.a(d.a.o0.f.i.r.h.a(this.f49775f.f49766e.f49780a), d.a.o0.f.i.r.h.a(this.f49775f.f49766e.f49781b), d.a.o0.f.i.r.h.a(this.f49775f.f49766e.f49784e), d.a.o0.f.i.r.h.a(this.f49775f.f49766e.f49785f)));
                }
                if (this.f49774e.equals("width") && z && this.f49775f.f49765d != null) {
                    d.a.o0.f.i.i.f fVar = this.f49775f.f49765d;
                    d.a.o0.f.i.i.c cVar2 = this.f49775f.f49766e;
                    fVar.b(cVar2.f49784e, cVar2.f49785f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49776e;

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
            this.f49776e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49776e.f49769h == null || !this.f49776e.n.c(this.f49776e.f49769h.f())) {
                    if (this.f49776e.f49765d != null) {
                        this.f49776e.f49765d.onShow(false);
                        this.f49776e.f49765d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f49776e.f49769h.l();
                if (this.f49776e.f49765d != null) {
                    this.f49776e.f49765d.onShow(true);
                }
                d.a.o0.f.i.q.b.n("showSuccess", this.f49776e.m, this.f49776e.f49767f);
                if (this.f49776e.f49770i) {
                    return;
                }
                this.f49776e.f49770i = true;
                if (this.f49776e.k) {
                    d.a.o0.f.i.q.d.f(this.f49776e.f49768g, this.f49776e.f49767f);
                    return;
                }
                d.a.o0.f.i.q.b.j(this.f49776e.f49768g, this.f49776e.f49767f);
                String str = this.f49776e.f49764c;
                b bVar = this.f49776e;
                d.a.o0.f.i.q.b.f(str, bVar.f49763b, bVar.j, this.f49776e.f49767f);
                d.a.o0.f.i.q.b.n("show", this.f49776e.m, this.f49776e.f49767f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49777a;

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
            this.f49777a = bVar;
        }

        @Override // d.a.o0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f49777a.l == null) {
                    this.f49777a.l = new d.a.o0.f.i.k.b(this.f49777a.f49762a, this.f49777a.f49768g, this.f49777a.f49767f);
                }
                this.f49777a.l.k(str);
                d.a.o0.f.i.m.a.b().b(this.f49777a.f49762a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f49777a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // d.a.o0.f.i.l.d
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
        public final /* synthetic */ b f49778e;

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
            this.f49778e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49778e.f49769h == null) {
                return;
            }
            this.f49778e.f49769h.g();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49779e;

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
            this.f49779e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49779e.f49769h != null) {
                    this.f49779e.n.removeView(this.f49779e.f49769h.f());
                }
                this.f49779e.f49769h = null;
                this.f49779e.f49765d = null;
                this.f49779e.f49768g = null;
                if (this.f49779e.l != null) {
                    this.f49779e.l.i();
                    this.f49779e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, d.a.o0.f.i.i.f fVar, d.a.o0.f.i.l.f fVar2) {
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
        this.f49766e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f49762a = appContext;
        this.f49764c = str;
        this.f49763b = str2;
        this.f49765d = fVar;
        this.n = fVar2;
        this.f49767f = new d.a.o0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f49768g) == null || this.f49766e == null || view == null) {
            return;
        }
        d.a.o0.f.i.q.d.d(adElementInfo, this.f49767f);
        d.a.o0.f.i.q.a aVar = new d.a.o0.f.i.q.a();
        aVar.f49945a = String.valueOf(this.f49766e.f49782c);
        aVar.f49946b = String.valueOf(this.f49766e.f49783d);
        aVar.f49947c = String.valueOf(this.f49766e.f49782c);
        aVar.f49948d = String.valueOf(this.f49766e.f49783d);
        aVar.f49949e = String.valueOf((int) view.getX());
        aVar.f49950f = String.valueOf((int) view.getY());
        aVar.f49951g = String.valueOf((int) view.getX());
        aVar.f49952h = String.valueOf((int) view.getY());
        if (this.f49768g.getActionType() == 2) {
            d.a.o0.f.i.q.d.a(aVar, this.f49768g, this.f49767f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f49768g;
        if (adElementInfo2 != null) {
            this.n.a(d.a.o0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.o0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.o0.f.i.i.d dVar = new d.a.o0.f.i.i.d(this.f49762a, this.f49768g, this.f49763b, this.k);
            this.f49769h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f49769h.k(new C1051b(this));
            } else {
                this.f49769h.j(new c(this));
            }
            this.f49769h.e(this.f49766e.f49782c);
            if (this.n.c(this.f49769h.f())) {
                this.n.removeView(this.f49769h.f());
            }
            if (this.n.d(this.f49769h.f(), new d.a.o0.f.i.i.a(d.a.o0.f.i.r.h.a(this.f49766e.f49780a), d.a.o0.f.i.r.h.a(this.f49766e.f49781b), d.a.o0.f.i.r.h.a(this.f49766e.f49784e), d.a.o0.f.i.r.h.a(this.f49766e.f49785f)))) {
                d.a.o0.f.i.i.f fVar = this.f49765d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            d.a.o0.f.i.i.f fVar2 = this.f49765d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        d.a.o0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.o0.f.i.q.b.n("loadApi", this.m, this.f49767f);
            String appKey = d.a.o0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f49764c);
            bVar.j(this.f49763b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f49766e.f49782c);
            bVar.i(this.f49766e.f49783d);
            d.a.o0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new d.a.o0.f.i.o.f(this.f49762a, h2, 1, z());
            } else {
                dVar = new d.a.o0.f.i.o.d(this.f49762a, h2);
                this.j = dVar.c();
            }
            d.a.o0.f.i.o.a aVar = new d.a.o0.f.i.o.a(this.f49762a, false);
            aVar.k(this);
            aVar.i(dVar, this.f49767f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f49766e = new d.a.o0.f.i.i.c(i2, i3, i4, i5);
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
            d.a.o0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            d.a.o0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // d.a.o0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            d.a.o0.f.i.i.f fVar = this.f49765d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = d.a.o0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            d.a.o0.f.i.i.f fVar2 = this.f49765d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // d.a.o0.f.i.i.d.e
    public void b() {
        d.a.o0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f49765d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // d.a.o0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f49768g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.o0.f.i.i.d dVar = new d.a.o0.f.i.i.d(this.f49762a);
            this.f49769h = dVar;
            dVar.e(this.f49766e.f49782c);
            if (this.f49769h.f() == null) {
                return;
            }
            if (this.n.c(this.f49769h.f())) {
                this.n.removeView(this.f49769h.f());
            }
            this.n.d(this.f49769h.f(), new d.a.o0.f.i.i.a(d.a.o0.f.i.r.h.a(this.f49766e.f49780a), d.a.o0.f.i.r.h.a(this.f49766e.f49781b), d.a.o0.f.i.r.h.a(this.f49766e.f49784e), d.a.o0.f.i.r.h.a(this.f49766e.f49785f)));
            this.f49769h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        d.a.o0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f49766e) == null) {
            return;
        }
        if (d.a.o0.f.i.r.h.a(cVar.f49782c) < 300) {
            this.f49766e.f49782c = d.a.o0.f.i.r.h.p(300.0f);
        }
        int q = d.a.o0.f.i.m.a.b().q();
        int p = d.a.o0.f.i.m.a.b().p();
        if (d.a.o0.f.i.r.h.a(this.f49766e.f49782c) > q) {
            this.f49766e.f49782c = d.a.o0.f.i.r.h.p(q);
        }
        d.a.o0.f.i.i.c cVar2 = this.f49766e;
        cVar2.f49783d = (int) (cVar2.f49782c / d.a.o0.f.i.i.e.f49799a);
        if (cVar2.f49780a < 0) {
            cVar2.f49780a = 0;
        }
        int p2 = d.a.o0.f.i.r.h.p(q);
        d.a.o0.f.i.i.c cVar3 = this.f49766e;
        int i2 = p2 - cVar3.f49782c;
        if (cVar3.f49780a > i2) {
            cVar3.f49780a = i2;
        }
        d.a.o0.f.i.i.c cVar4 = this.f49766e;
        if (cVar4.f49781b < 0) {
            cVar4.f49781b = 0;
        }
        int p3 = d.a.o0.f.i.r.h.p(p);
        d.a.o0.f.i.i.c cVar5 = this.f49766e;
        int i3 = p3 - cVar5.f49783d;
        if (cVar5.f49781b > i3) {
            cVar5.f49781b = i3;
        }
        d.a.o0.f.i.i.c cVar6 = this.f49766e;
        cVar6.f49784e = cVar6.f49782c;
        cVar6.f49785f = cVar6.f49783d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.o0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f49766e == null) {
                return 2;
            }
            int p = d.a.o0.f.i.r.h.p(d.a.o0.f.i.m.a.b().p());
            int i2 = this.f49766e.f49781b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
