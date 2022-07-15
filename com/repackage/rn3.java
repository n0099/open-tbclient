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
import com.repackage.hp3;
import com.repackage.tn3;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rn3 implements so3, tn3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public vn3 d;
    public sn3 e;
    public gp3 f;
    public AdElementInfo g;
    public tn3 h;
    public boolean i;
    public String j;
    public boolean k;
    public zn3 l;
    public Map<String, String> m;
    public wo3 n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;

        public a(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
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
    public class b implements uo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;

        public b(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
        }

        @Override // com.repackage.uo3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.repackage.uo3
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
    public class c implements qo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;

        public c(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
        }

        @Override // com.repackage.qo3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.g == null) {
                return;
            }
            String clickUrl = this.a.g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", pp3.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            pp3.g(this.a.g, this.a.f);
            pp3.n("lpClick", this.a.m, this.a.f);
            pp3.n("click", this.a.m, this.a.f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rn3 b;

        public d(rn3 rn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rn3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sn3 sn3Var = this.b.e;
                boolean z = sn3Var.c != sn3Var.e;
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new qn3(zp3.a(this.b.e.a), zp3.a(this.b.e.b), zp3.a(this.b.e.e), zp3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    vn3 vn3Var = this.b.d;
                    sn3 sn3Var2 = this.b.e;
                    vn3Var.c(sn3Var2.e, sn3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;

        public e(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
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
                pp3.n("showSuccess", this.a.m, this.a.f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    rp3.f(this.a.g, this.a.f);
                    return;
                }
                pp3.j(this.a.g, this.a.f);
                String str = this.a.c;
                rn3 rn3Var = this.a;
                pp3.f(str, rn3Var.b, rn3Var.j, this.a.f);
                pp3.n("show", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements uo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;

        public f(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
        }

        @Override // com.repackage.uo3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new zn3(this.a.a, this.a.g, this.a.f);
                }
                this.a.l.k(str);
                yo3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // com.repackage.uo3
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
        public final /* synthetic */ rn3 a;

        public g(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
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
        public final /* synthetic */ rn3 a;

        public h(rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
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

    public rn3(String str, String str2, vn3 vn3Var, wo3 wo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, vn3Var, wo3Var};
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
        this.d = vn3Var;
        this.n = wo3Var;
        this.f = new gp3(appContext);
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
        rp3.d(adElementInfo, this.f);
        op3 op3Var = new op3();
        op3Var.a = String.valueOf(this.e.c);
        op3Var.b = String.valueOf(this.e.d);
        op3Var.c = String.valueOf(this.e.c);
        op3Var.d = String.valueOf(this.e.d);
        op3Var.e = String.valueOf((int) view2.getX());
        op3Var.f = String.valueOf((int) view2.getY());
        op3Var.g = String.valueOf((int) view2.getX());
        op3Var.h = String.valueOf((int) view2.getY());
        if (this.g.getActionType() == 2) {
            rp3.a(op3Var, this.g, this.f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.g;
        if (adElementInfo2 != null) {
            this.n.a(rp3.c(adElementInfo2.getClickUrl(), op3Var), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            vp3.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tn3 tn3Var = new tn3(this.a, this.g, this.b, this.k);
            this.h = tn3Var;
            tn3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new qn3(zp3.a(this.e.a), zp3.a(this.e.b), zp3.a(this.e.e), zp3.a(this.e.f)))) {
                vn3 vn3Var = this.d;
                if (vn3Var != null) {
                    vn3Var.a(true, "");
                    return;
                }
                return;
            }
            vn3 vn3Var2 = this.d;
            if (vn3Var2 != null) {
                vn3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        jp3 ip3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pp3.n("loadApi", this.m, this.f);
            String appKey = yo3.b().getAppKey();
            hp3.b bVar = new hp3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            hp3 h2 = bVar.h();
            if (this.k) {
                ip3Var = new kp3(this.a, h2, 1, z());
            } else {
                ip3Var = new ip3(this.a, h2);
                this.j = ip3Var.c();
            }
            ep3 ep3Var = new ep3(this.a, false);
            ep3Var.k(this);
            ep3Var.i(ip3Var, this.f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new sn3(i, i2, i3, i4);
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
            vp3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            vp3.c(new d(this, str));
        }
    }

    @Override // com.repackage.so3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            vn3 vn3Var = this.d;
            if (vn3Var != null) {
                vn3Var.onError(str);
            }
            String appId = yo3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            vn3 vn3Var2 = this.d;
            if (vn3Var2 != null) {
                vn3Var2.a(false, "");
            }
        }
    }

    @Override // com.repackage.tn3.e
    public void b() {
        vn3 vn3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (vn3Var = this.d) == null) {
            return;
        }
        vn3Var.onClose();
    }

    @Override // com.repackage.so3
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
            tn3 tn3Var = new tn3(this.a);
            this.h = tn3Var;
            tn3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new qn3(zp3.a(this.e.a), zp3.a(this.e.b), zp3.a(this.e.e), zp3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        sn3 sn3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (sn3Var = this.e) == null) {
            return;
        }
        if (zp3.a(sn3Var.c) < 300) {
            this.e.c = zp3.p(300.0f);
        }
        int k = yo3.b().k();
        int j = yo3.b().j();
        if (zp3.a(this.e.c) > k) {
            this.e.c = zp3.p(k);
        }
        sn3 sn3Var2 = this.e;
        sn3Var2.d = (int) (sn3Var2.c / un3.a);
        if (sn3Var2.a < 0) {
            sn3Var2.a = 0;
        }
        int p = zp3.p(k);
        sn3 sn3Var3 = this.e;
        int i = p - sn3Var3.c;
        if (sn3Var3.a > i) {
            sn3Var3.a = i;
        }
        sn3 sn3Var4 = this.e;
        if (sn3Var4.b < 0) {
            sn3Var4.b = 0;
        }
        int p2 = zp3.p(j);
        sn3 sn3Var5 = this.e;
        int i2 = p2 - sn3Var5.d;
        if (sn3Var5.b > i2) {
            sn3Var5.b = i2;
        }
        sn3 sn3Var6 = this.e;
        sn3Var6.e = sn3Var6.c;
        sn3Var6.f = sn3Var6.d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            vp3.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = zp3.p(yo3.b().j());
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
