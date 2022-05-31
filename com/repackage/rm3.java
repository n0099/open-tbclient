package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ho3;
import com.repackage.tm3;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rm3 implements sn3, tm3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public vm3 d;
    public sm3 e;
    public go3 f;
    public AdElementInfo g;
    public tm3 h;
    public boolean i;
    public String j;
    public boolean k;
    public zm3 l;
    public Map<String, String> m;
    public wn3 n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public a(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null || this.a.h.f() == null || !this.a.n.c(this.a.h.f())) {
                return;
            }
            this.a.n.removeView(this.a.h.f());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements un3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public b(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // com.repackage.un3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.repackage.un3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && this.a.k) {
                this.a.A(view2);
                if (this.a.d != null) {
                    this.a.d.onClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public c(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // com.repackage.qn3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.g == null) {
                return;
            }
            String clickUrl = this.a.g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", po3.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            po3.g(this.a.g, this.a.f);
            po3.n("lpClick", this.a.m, this.a.f);
            po3.n("click", this.a.m, this.a.f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rm3 b;

        public d(rm3 rm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rm3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sm3 sm3Var = this.b.e;
                boolean z = sm3Var.c != sm3Var.e;
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new qm3(zo3.a(this.b.e.a), zo3.a(this.b.e.b), zo3.a(this.b.e.e), zo3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    vm3 vm3Var = this.b.d;
                    sm3 sm3Var2 = this.b.e;
                    vm3Var.c(sm3Var2.e, sm3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public e(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h == null || !this.a.n.c(this.a.h.f())) {
                    if (this.a.d != null) {
                        this.a.d.b(false);
                        this.a.d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.a.h.l();
                if (this.a.d != null) {
                    this.a.d.b(true);
                }
                po3.n("showSuccess", this.a.m, this.a.f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    ro3.f(this.a.g, this.a.f);
                    return;
                }
                po3.j(this.a.g, this.a.f);
                String str = this.a.c;
                rm3 rm3Var = this.a;
                po3.f(str, rm3Var.b, rm3Var.j, this.a.f);
                po3.n("show", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements un3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public f(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // com.repackage.un3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new zm3(this.a.a, this.a.g, this.a.f);
                }
                this.a.l.k(str);
                yn3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // com.repackage.un3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public g(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            this.a.h.g();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;

        public h(rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h != null) {
                    this.a.n.removeView(this.a.h.f());
                }
                this.a.h = null;
                this.a.d = null;
                this.a.g = null;
                if (this.a.l != null) {
                    this.a.l.i();
                    this.a.l = null;
                }
            }
        }
    }

    public rm3(String str, String str2, vm3 vm3Var, wn3 wn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, vm3Var, wn3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.c = str;
        this.b = str2;
        this.d = vm3Var;
        this.n = wn3Var;
        this.f = new go3(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view2) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !this.k || (adElementInfo = this.g) == null || this.e == null || view2 == null) {
            return;
        }
        ro3.d(adElementInfo, this.f);
        oo3 oo3Var = new oo3();
        oo3Var.a = String.valueOf(this.e.c);
        oo3Var.b = String.valueOf(this.e.d);
        oo3Var.c = String.valueOf(this.e.c);
        oo3Var.d = String.valueOf(this.e.d);
        oo3Var.e = String.valueOf((int) view2.getX());
        oo3Var.f = String.valueOf((int) view2.getY());
        oo3Var.g = String.valueOf((int) view2.getX());
        oo3Var.h = String.valueOf((int) view2.getY());
        if (this.g.getActionType() == 2) {
            ro3.a(oo3Var, this.g, this.f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.g;
        if (adElementInfo2 != null) {
            this.n.a(ro3.c(adElementInfo2.getClickUrl(), oo3Var), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            vo3.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tm3 tm3Var = new tm3(this.a, this.g, this.b, this.k);
            this.h = tm3Var;
            tm3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new qm3(zo3.a(this.e.a), zo3.a(this.e.b), zo3.a(this.e.e), zo3.a(this.e.f)))) {
                vm3 vm3Var = this.d;
                if (vm3Var != null) {
                    vm3Var.a(true, "");
                    return;
                }
                return;
            }
            vm3 vm3Var2 = this.d;
            if (vm3Var2 != null) {
                vm3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        jo3 io3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            po3.n("loadApi", this.m, this.f);
            String appKey = yn3.b().getAppKey();
            ho3.b bVar = new ho3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            ho3 h2 = bVar.h();
            if (this.k) {
                io3Var = new ko3(this.a, h2, 1, z());
            } else {
                io3Var = new io3(this.a, h2);
                this.j = io3Var.c();
            }
            eo3 eo3Var = new eo3(this.a, false);
            eo3Var.k(this);
            eo3Var.i(io3Var, this.f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new sm3(i, i2, i3, i4);
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
            vo3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            vo3.c(new d(this, str));
        }
    }

    @Override // com.repackage.sn3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            vm3 vm3Var = this.d;
            if (vm3Var != null) {
                vm3Var.onError(str);
            }
            String appId = yn3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            vm3 vm3Var2 = this.d;
            if (vm3Var2 != null) {
                vm3Var2.a(false, "");
            }
        }
    }

    @Override // com.repackage.tm3.e
    public void b() {
        vm3 vm3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (vm3Var = this.d) == null) {
            return;
        }
        vm3Var.onClose();
    }

    @Override // com.repackage.sn3
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            tm3 tm3Var = new tm3(this.a);
            this.h = tm3Var;
            tm3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new qm3(zo3.a(this.e.a), zo3.a(this.e.b), zo3.a(this.e.e), zo3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        sm3 sm3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (sm3Var = this.e) == null) {
            return;
        }
        if (zo3.a(sm3Var.c) < 300) {
            this.e.c = zo3.p(300.0f);
        }
        int q = yn3.b().q();
        int p = yn3.b().p();
        if (zo3.a(this.e.c) > q) {
            this.e.c = zo3.p(q);
        }
        sm3 sm3Var2 = this.e;
        sm3Var2.d = (int) (sm3Var2.c / um3.a);
        if (sm3Var2.a < 0) {
            sm3Var2.a = 0;
        }
        int p2 = zo3.p(q);
        sm3 sm3Var3 = this.e;
        int i = p2 - sm3Var3.c;
        if (sm3Var3.a > i) {
            sm3Var3.a = i;
        }
        sm3 sm3Var4 = this.e;
        if (sm3Var4.b < 0) {
            sm3Var4.b = 0;
        }
        int p3 = zo3.p(p);
        sm3 sm3Var5 = this.e;
        int i2 = p3 - sm3Var5.d;
        if (sm3Var5.b > i2) {
            sm3Var5.b = i2;
        }
        sm3 sm3Var6 = this.e;
        sm3Var6.e = sm3Var6.c;
        sm3Var6.f = sm3Var6.d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            vo3.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = zo3.p(yn3.b().p());
            int i = this.e.b;
            int i2 = p / 3;
            if (i < i2) {
                return 1;
            }
            return i < i2 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
