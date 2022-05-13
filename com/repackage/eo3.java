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
import com.repackage.go3;
import com.repackage.up3;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class eo3 implements fp3, go3.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public io3 d;
    public fo3 e;
    public tp3 f;
    public AdElementInfo g;
    public go3 h;
    public boolean i;
    public String j;
    public boolean k;
    public mo3 l;
    public Map<String, String> m;
    public jp3 n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public a(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
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

    /* loaded from: classes6.dex */
    public class b implements hp3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public b(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
        }

        @Override // com.repackage.hp3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.repackage.hp3
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

    /* loaded from: classes6.dex */
    public class c implements dp3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public c(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
        }

        @Override // com.repackage.dp3
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.g == null) {
                return;
            }
            String clickUrl = this.a.g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", cq3.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            cq3.g(this.a.g, this.a.f);
            cq3.n("lpClick", this.a.m, this.a.f);
            cq3.n("click", this.a.m, this.a.f);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ eo3 b;

        public d(eo3 eo3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo3Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fo3 fo3Var = this.b.e;
                boolean z = fo3Var.c != fo3Var.e;
                this.b.x();
                if (this.b.h != null) {
                    this.b.h.e(this.b.e.c);
                    this.b.n.f(this.b.h.f(), new do3(mq3.a(this.b.e.a), mq3.a(this.b.e.b), mq3.a(this.b.e.e), mq3.a(this.b.e.f)));
                }
                if (this.a.equals("width") && z && this.b.d != null) {
                    io3 io3Var = this.b.d;
                    fo3 fo3Var2 = this.b.e;
                    io3Var.c(fo3Var2.e, fo3Var2.f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public e(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
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
                cq3.n("showSuccess", this.a.m, this.a.f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    eq3.f(this.a.g, this.a.f);
                    return;
                }
                cq3.j(this.a.g, this.a.f);
                String str = this.a.c;
                eo3 eo3Var = this.a;
                cq3.f(str, eo3Var.b, eo3Var.j, this.a.f);
                cq3.n("show", this.a.m, this.a.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements hp3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public f(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
        }

        @Override // com.repackage.hp3
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new mo3(this.a.a, this.a.g, this.a.f);
                }
                this.a.l.k(str);
                lp3.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // com.repackage.hp3
        public void f(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public g(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
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

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;

        public h(eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo3Var;
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

    public eo3(String str, String str2, io3 io3Var, jp3 jp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, io3Var, jp3Var};
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
        this.d = io3Var;
        this.n = jp3Var;
        this.f = new tp3(appContext);
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
        eq3.d(adElementInfo, this.f);
        bq3 bq3Var = new bq3();
        bq3Var.a = String.valueOf(this.e.c);
        bq3Var.b = String.valueOf(this.e.d);
        bq3Var.c = String.valueOf(this.e.c);
        bq3Var.d = String.valueOf(this.e.d);
        bq3Var.e = String.valueOf((int) view2.getX());
        bq3Var.f = String.valueOf((int) view2.getY());
        bq3Var.g = String.valueOf((int) view2.getX());
        bq3Var.h = String.valueOf((int) view2.getY());
        if (this.g.getActionType() == 2) {
            eq3.a(bq3Var, this.g, this.f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.g;
        if (adElementInfo2 != null) {
            this.n.a(eq3.c(adElementInfo2.getClickUrl(), bq3Var), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            iq3.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            go3 go3Var = new go3(this.a, this.g, this.b, this.k);
            this.h = go3Var;
            go3Var.i(this);
            if (this.k) {
                this.h.k(new b(this));
            } else {
                this.h.j(new c(this));
            }
            this.h.e(this.e.c);
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            if (this.n.d(this.h.f(), new do3(mq3.a(this.e.a), mq3.a(this.e.b), mq3.a(this.e.e), mq3.a(this.e.f)))) {
                io3 io3Var = this.d;
                if (io3Var != null) {
                    io3Var.a(true, "");
                    return;
                }
                return;
            }
            io3 io3Var2 = this.d;
            if (io3Var2 != null) {
                io3Var2.onError("3010000");
            }
        }
    }

    public final void D() {
        wp3 vp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cq3.n("loadApi", this.m, this.f);
            String appKey = lp3.b().getAppKey();
            up3.b bVar = new up3.b();
            bVar.m(this.c);
            bVar.j(this.b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.e.c);
            bVar.i(this.e.d);
            up3 h2 = bVar.h();
            if (this.k) {
                vp3Var = new xp3(this.a, h2, 1, z());
            } else {
                vp3Var = new vp3(this.a, h2);
                this.j = vp3Var.c();
            }
            rp3 rp3Var = new rp3(this.a, false);
            rp3Var.k(this);
            rp3Var.i(vp3Var, this.f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.e = new fo3(i, i2, i3, i4);
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
            iq3.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            iq3.c(new d(this, str));
        }
    }

    @Override // com.repackage.fp3
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            io3 io3Var = this.d;
            if (io3Var != null) {
                io3Var.onError(str);
            }
            String appId = lp3.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            io3 io3Var2 = this.d;
            if (io3Var2 != null) {
                io3Var2.a(false, "");
            }
        }
    }

    @Override // com.repackage.go3.e
    public void b() {
        io3 io3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (io3Var = this.d) == null) {
            return;
        }
        io3Var.onClose();
    }

    @Override // com.repackage.fp3
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
            go3 go3Var = new go3(this.a);
            this.h = go3Var;
            go3Var.e(this.e.c);
            if (this.h.f() == null) {
                return;
            }
            if (this.n.c(this.h.f())) {
                this.n.removeView(this.h.f());
            }
            this.n.d(this.h.f(), new do3(mq3.a(this.e.a), mq3.a(this.e.b), mq3.a(this.e.e), mq3.a(this.e.f)));
            this.h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        fo3 fo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fo3Var = this.e) == null) {
            return;
        }
        if (mq3.a(fo3Var.c) < 300) {
            this.e.c = mq3.p(300.0f);
        }
        int q = lp3.b().q();
        int p = lp3.b().p();
        if (mq3.a(this.e.c) > q) {
            this.e.c = mq3.p(q);
        }
        fo3 fo3Var2 = this.e;
        fo3Var2.d = (int) (fo3Var2.c / ho3.a);
        if (fo3Var2.a < 0) {
            fo3Var2.a = 0;
        }
        int p2 = mq3.p(q);
        fo3 fo3Var3 = this.e;
        int i = p2 - fo3Var3.c;
        if (fo3Var3.a > i) {
            fo3Var3.a = i;
        }
        fo3 fo3Var4 = this.e;
        if (fo3Var4.b < 0) {
            fo3Var4.b = 0;
        }
        int p3 = mq3.p(p);
        fo3 fo3Var5 = this.e;
        int i2 = p3 - fo3Var5.d;
        if (fo3Var5.b > i2) {
            fo3Var5.b = i2;
        }
        fo3 fo3Var6 = this.e;
        fo3Var6.e = fo3Var6.c;
        fo3Var6.f = fo3Var6.d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            iq3.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e == null) {
                return 2;
            }
            int p = mq3.p(lp3.b().p());
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
