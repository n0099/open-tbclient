package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tq3 extends hw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public JSONObject g;
    public wq3 h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ tq3 b;

        public a(tq3 tq3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tq3Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sq3.t().I(this.b.g);
                String str = this.b.f;
                switch (str.hashCode()) {
                    case -1261560102:
                        if (str.equals("queryStatus")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -625158317:
                        if (str.equals("deleteDownload")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -234424485:
                        if (str.equals("open_manual")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 900412038:
                        if (str.equals("installApp")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1554935562:
                        if (str.equals("startDownload")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1921860518:
                        if (str.equals("startDownloadFile")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1944785703:
                        if (str.equals("checkPackageExpired")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        this.b.w(this.a);
                        return;
                    case 1:
                        this.b.u(this.a);
                        return;
                    case 2:
                        this.b.t(this.a);
                        return;
                    case 3:
                        this.b.v(this.a);
                        return;
                    case 4:
                        this.b.p(this.a);
                        return;
                    case 5:
                        this.b.q(this.a);
                        return;
                    case 6:
                        this.b.s(this.a);
                        return;
                    case 7:
                        this.b.r(this.a);
                        return;
                    case '\b':
                        this.b.x(this.a);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public tq3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.hw2
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f = bundle.getString("operation", "");
            this.g = hd3.d(bundle.getString("ubc_params", ""));
            JSONObject d = hd3.d(bundle.getString("data", ""));
            if (this.h == null) {
                this.h = new wq3(this);
            }
            sq3.t().H(this.h);
            sq3.m.execute(new a(this, d));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            sq3.t().s(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void q(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("key_download_url");
            String optString2 = jSONObject.optString("key_download_package_name");
            String optString3 = jSONObject.optString("download_params");
            cr3.n().h("manualInstall", new br3(this.g), optString2, optString3, optString);
            sq3.t().L(optString, optString2, optString3);
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            sq3.t().x(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"));
        }
    }

    public final void s(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            sq3.t().p(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optLong(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, 0L));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            sq3.t().y(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void u(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            sq3.t().z(jSONObject.optString("key_download_package_name"));
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            sq3.t().G(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            sq3.t().J(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
        }
    }

    public final void x(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            sq3.t().K(jSONObject.optString("key_download_url"), jSONObject.optString(kq3.b), jSONObject.optString(kq3.c));
        }
    }
}
