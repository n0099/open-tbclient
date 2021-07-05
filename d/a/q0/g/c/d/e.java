package d.a.q0.g.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends d.a.q0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f52949f;

    /* renamed from: g  reason: collision with root package name */
    public String f52950g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f52951h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f52952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f52953f;

        public a(e eVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52953f = eVar;
            this.f52952e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.g.c.a.n().G(this.f52953f.f52951h);
                String str = this.f52953f.f52949f;
                switch (str.hashCode()) {
                    case -1261560102:
                        if (str.equals("queryStatus")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -625158317:
                        if (str.equals("deleteDownload")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -606050596:
                        if (str.equals("resumeAllDownload")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -534830837:
                        if (str.equals("queryAllStatus")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -417021581:
                        if (str.equals("pauseAllDownload")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1554935562:
                        if (str.equals("startDownload")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        this.f52953f.w(this.f52952e);
                        return;
                    case 1:
                        this.f52953f.t(this.f52952e);
                        return;
                    case 2:
                        this.f52953f.s();
                        return;
                    case 3:
                        this.f52953f.r(this.f52952e);
                        return;
                    case 4:
                        this.f52953f.v(this.f52952e);
                        return;
                    case 5:
                        this.f52953f.p(this.f52952e);
                        return;
                    case 6:
                        this.f52953f.u();
                        return;
                    case 7:
                        this.f52953f.q();
                        return;
                    default:
                        this.f52953f.x(new d.a.q0.g.c.g.a(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f52954a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52954a = eVar;
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f52954a.x(bVar);
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f52949f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.f52951h = w.d(bundle.getString("ubc_params", ""));
            JSONObject d2 = w.d(bundle.getString("data", ""));
            this.f52950g = d2.optString("packageName");
            d.a.q0.g.c.c.b.f52916d.execute(new a(this, d2));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            d.a.q0.g.c.a.n().m(jSONObject, new b(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.g.c.a.n().u();
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            d.a.q0.g.c.a.n().v(jSONObject, new b(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.q0.g.c.a.n().w(new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            d.a.q0.g.c.a.n().x(jSONObject, new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.g.c.a.n().D();
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            d.a.q0.g.c.a.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            d.a.q0.g.c.a.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }

    public final void x(d.a.q0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f51200d.clear();
            if (bVar != null) {
                this.f51200d.putString("functionType", bVar.a());
                this.f51200d.putString("resultData", bVar.b());
                this.f51200d.putInt(l.f1990a, bVar.c());
                if (bVar.d()) {
                    if (!TextUtils.equals(this.f52949f, "startDownload")) {
                        d.a.q0.g.c.i.c.a(this.f52950g, this.f52949f, "success", null, new d.a.q0.g.c.i.a(this.f52951h));
                    }
                } else {
                    d.a.q0.g.c.i.c.a(this.f52950g, this.f52949f, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.q0.g.c.i.a(this.f52951h));
                }
            }
            c();
        }
    }
}
