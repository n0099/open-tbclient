package d.a.q0.f.j.n;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends d.a.q0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f52854f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f52855g;

    /* renamed from: h  reason: collision with root package name */
    public i f52856h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f52857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f52858f;

        public a(f fVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52858f = fVar;
            this.f52857e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.s().H(this.f52858f.f52855g);
                String str = this.f52858f.f52854f;
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
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -234424485:
                        if (str.equals("open_manual")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 900412038:
                        if (str.equals("installApp")) {
                            c2 = 5;
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
                    case 1944785703:
                        if (str.equals("checkPackageExpired")) {
                            c2 = 6;
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
                        this.f52858f.v(this.f52857e);
                        return;
                    case 1:
                        this.f52858f.t(this.f52857e);
                        return;
                    case 2:
                        this.f52858f.s(this.f52857e);
                        return;
                    case 3:
                        this.f52858f.u(this.f52857e);
                        return;
                    case 4:
                        this.f52858f.o(this.f52857e);
                        return;
                    case 5:
                        this.f52858f.p(this.f52857e);
                        return;
                    case 6:
                        this.f52858f.r(this.f52857e);
                        return;
                    case 7:
                        this.f52858f.q(this.f52857e);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public f() {
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
            this.f52854f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
            this.f52855g = w.d(bundle.getString("ubc_params", ""));
            JSONObject d2 = w.d(bundle.getString("data", ""));
            if (this.f52856h == null) {
                this.f52856h = new i(this);
            }
            e.s().G(this.f52856h);
            e.m.execute(new a(this, d2));
        }
    }

    public final void o(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            e.s().r(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("key_download_url");
            String optString2 = jSONObject.optString("key_download_package_name");
            String optString3 = jSONObject.optString("download_params");
            d.a.q0.f.j.r.b.n().h("manualInstall", new d.a.q0.f.j.r.a(this.f52855g), optString2, optString3, optString);
            e.s().J(optString, optString2, optString3);
        }
    }

    public final void q(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            e.s().w(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"));
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            e.s().o(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optLong(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, 0L));
        }
    }

    public final void s(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            e.s().x(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            e.s().y(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void u(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            e.s().F(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            e.s().I(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }
}
