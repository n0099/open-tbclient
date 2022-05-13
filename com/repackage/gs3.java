package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gs3 extends uw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;
    public JSONObject h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ gs3 b;

        public a(gs3 gs3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gs3Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sr3.n().G(this.b.h);
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
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -606050596:
                        if (str.equals("resumeAllDownload")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -534830837:
                        if (str.equals("queryAllStatus")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -417021581:
                        if (str.equals("pauseAllDownload")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c = 4;
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
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        this.b.w(this.a);
                        return;
                    case 1:
                        this.b.t(this.a);
                        return;
                    case 2:
                        this.b.s();
                        return;
                    case 3:
                        this.b.r(this.a);
                        return;
                    case 4:
                        this.b.v(this.a);
                        return;
                    case 5:
                        this.b.p(this.a);
                        return;
                    case 6:
                        this.b.u();
                        return;
                    case 7:
                        this.b.q();
                        return;
                    default:
                        this.b.setResult(new ns3(31009, "invalid operation"));
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ms3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs3 a;

        public b(gs3 gs3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs3Var;
        }

        @Override // com.repackage.ms3
        public void a(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, os3Var) == null) {
                this.a.setResult(os3Var);
            }
        }
    }

    public gs3() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(os3 os3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, os3Var) == null) {
            this.d.clear();
            if (os3Var != null) {
                this.d.putString("functionType", os3Var.a());
                this.d.putString("resultData", os3Var.b());
                this.d.putInt("resultStatus", os3Var.c());
                if (os3Var.d()) {
                    if (!TextUtils.equals(this.f, "startDownload")) {
                        us3.a(this.g, this.f, "success", null, new ss3(this.h));
                    }
                } else {
                    us3.a(this.g, this.f, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(os3Var.c()), new ss3(this.h));
                }
            }
            c();
        }
    }

    @Override // com.repackage.uw2
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f = bundle.getString("operation", "");
            this.h = ud3.d(bundle.getString("ubc_params", ""));
            JSONObject d = ud3.d(bundle.getString("data", ""));
            this.g = d.optString("packageName");
            vr3.d.execute(new a(this, d));
        }
    }

    public final void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            sr3.n().m(jSONObject, new b(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sr3.n().u();
        }
    }

    public final void r(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            sr3.n().v(jSONObject, new b(this));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sr3.n().w(new b(this));
        }
    }

    public final void t(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            sr3.n().x(jSONObject, new b(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            sr3.n().D();
        }
    }

    public final void v(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            sr3.n().E(jSONObject, new b(this));
        }
    }

    public final void w(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            sr3.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b(this));
        }
    }
}
