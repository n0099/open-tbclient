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
import com.repackage.jp3;
import com.repackage.vn3;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tn3 implements uo3, vn3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public xn3 d;
    public un3 e;
    public ip3 f;
    public AdElementInfo g;
    public vn3 h;
    public boolean i;
    public String j;
    public boolean k;
    public bo3 l;
    public Map<String, String> m;
    public yo3 n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn3 a;

        public a(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
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
    public class b implements wo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn3 a;

        public b(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
        }

        @Override // com.repackage.wo3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.repackage.wo3
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
    public class c implements so3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn3 a;

        public c(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
        }

        @Override // com.repackage.so3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.g == null) {
                return;
            }
            String clickUrl = this.a.g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", rp3.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            rp3.g(this.a.g, this.a.f);
            rp3.n("lpClick", this.a.m, this.a.f);
            rp3.n("click", this.a.m, this.a.f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tn3 b;

        public d(tn3 tn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                un3 un3Var = this.b.e;
                boolean z = un3Var.c != un3Var.e;
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new sn3(bq3.a(this.b.e.a), bq3.a(this.b.e.b), bq3.a(this.b.e.e), bq3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    xn3 xn3Var = this.b.d;
                    un3 un3Var2 = this.b.e;
                    xn3Var.c(un3Var2.e, un3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn3 a;

        public e(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
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
                rp3.n("showSuccess", this.a.m, this.a.f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    tp3.f(this.a.g, this.a.f);
                    return;
                }
                rp3.j(this.a.g, this.a.f);
                String str = this.a.c;
                tn3 tn3Var = this.a;
                rp3.f(str, tn3Var.b, tn3Var.j, this.a.f);
                rp3.n("show", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements wo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn3 a;

        public f(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
        }

        @Override // com.repackage.wo3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new bo3(this.a.a, this.a.g, this.a.f);
                }
                this.a.l.k(str);
                ap3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // com.repackage.wo3
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
        public final /* synthetic */ tn3 a;

        public g(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
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
        public final /* synthetic */ tn3 a;

        public h(tn3 tn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn3Var;
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

    public tn3(String str, String str2, xn3 xn3Var, yo3 yo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, xn3Var, yo3Var};
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
        this.d = xn3Var;
        this.n = yo3Var;
        this.f = new ip3(appContext);
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
        tp3.d(adElementInfo, this.f);
        qp3 qp3Var = new qp3();
        qp3Var.a = String.valueOf(this.e.c);
        qp3Var.b = String.valueOf(this.e.d);
        qp3Var.c = String.valueOf(this.e.c);
        qp3Var.d = String.valueOf(this.e.d);
        qp3Var.e = String.valueOf((int) view2.getX());
        qp3Var.f = String.valueOf((int) view2.getY());
        qp3Var.g = String.valueOf((int) view2.getX());
        qp3Var.h = String.valueOf((int) view2.getY());
        if (this.g.getActionType() == 2) {
            tp3.a(qp3Var, this.g, this.f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.g;
        if (adElementInfo2 != null) {
            this.n.a(tp3.c(adElementInfo2.getClickUrl(), qp3Var), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xp3.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vn3 vn3Var = new vn3(this.a, this.g, this.b, this.k);
            this.h = vn3Var;
            vn3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new sn3(bq3.a(this.e.a), bq3.a(this.e.b), bq3.a(this.e.e), bq3.a(this.e.f)))) {
                xn3 xn3Var = this.d;
                if (xn3Var != null) {
                    xn3Var.a(true, "");
                    return;
                }
                return;
            }
            xn3 xn3Var2 = this.d;
            if (xn3Var2 != null) {
                xn3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        lp3 kp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            rp3.n("loadApi", this.m, this.f);
            String appKey = ap3.b().getAppKey();
            jp3.b bVar = new jp3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            jp3 h2 = bVar.h();
            if (this.k) {
                kp3Var = new mp3(this.a, h2, 1, z());
            } else {
                kp3Var = new kp3(this.a, h2);
                this.j = kp3Var.c();
            }
            gp3 gp3Var = new gp3(this.a, false);
            gp3Var.k(this);
            gp3Var.i(kp3Var, this.f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new un3(i, i2, i3, i4);
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
            xp3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            xp3.c(new d(this, str));
        }
    }

    @Override // com.repackage.uo3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            xn3 xn3Var = this.d;
            if (xn3Var != null) {
                xn3Var.onError(str);
            }
            String appId = ap3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            xn3 xn3Var2 = this.d;
            if (xn3Var2 != null) {
                xn3Var2.a(false, "");
            }
        }
    }

    @Override // com.repackage.vn3.e
    public void b() {
        xn3 xn3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (xn3Var = this.d) == null) {
            return;
        }
        xn3Var.onClose();
    }

    @Override // com.repackage.uo3
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
            vn3 vn3Var = new vn3(this.a);
            this.h = vn3Var;
            vn3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new sn3(bq3.a(this.e.a), bq3.a(this.e.b), bq3.a(this.e.e), bq3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        un3 un3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (un3Var = this.e) == null) {
            return;
        }
        if (bq3.a(un3Var.c) < 300) {
            this.e.c = bq3.p(300.0f);
        }
        int q = ap3.b().q();
        int p = ap3.b().p();
        if (bq3.a(this.e.c) > q) {
            this.e.c = bq3.p(q);
        }
        un3 un3Var2 = this.e;
        un3Var2.d = (int) (un3Var2.c / wn3.a);
        if (un3Var2.a < 0) {
            un3Var2.a = 0;
        }
        int p2 = bq3.p(q);
        un3 un3Var3 = this.e;
        int i = p2 - un3Var3.c;
        if (un3Var3.a > i) {
            un3Var3.a = i;
        }
        un3 un3Var4 = this.e;
        if (un3Var4.b < 0) {
            un3Var4.b = 0;
        }
        int p3 = bq3.p(p);
        un3 un3Var5 = this.e;
        int i2 = p3 - un3Var5.d;
        if (un3Var5.b > i2) {
            un3Var5.b = i2;
        }
        un3 un3Var6 = this.e;
        un3Var6.e = un3Var6.c;
        un3Var6.f = un3Var6.d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            xp3.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = bq3.p(ap3.b().p());
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
