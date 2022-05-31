package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.repackage.o84;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ji3 extends m84<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o84.a a;

    public ji3(o84.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // com.repackage.o84.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) && c()) {
            this.a.a(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            if (ci3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onSuccess=" + str);
            }
            if (this.a == null) {
                return;
            }
            ii3 l = ii3.l();
            if (TextUtils.equals(str, "recovery")) {
                if (l.m().b()) {
                    l.m().a();
                    l.d.i(true);
                    wi3 wi3Var = l.d;
                    if (wi3Var instanceof ui3) {
                        ((ui3) wi3Var).j();
                        return;
                    }
                    return;
                }
                this.a.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                return;
            }
            l.m().k();
            wi3 wi3Var2 = l.d;
            if (wi3Var2 instanceof ui3) {
                ui3 ui3Var = (ui3) wi3Var2;
                if (l.k()) {
                    if (l.d.b == 1) {
                        hi3.a(MimeTypes.BASE_TYPE_APPLICATION);
                        this.a.b(str, i);
                        ui3Var.h = 0;
                        return;
                    }
                    int i2 = ui3Var.h;
                    ui3Var.h = i2 + 1;
                    if (i2 < 3) {
                        ui3Var.j();
                        return;
                    }
                    o84.a aVar = this.a;
                    aVar.onFail(new IOException("request fail : " + str));
                    ui3Var.h = 0;
                    return;
                }
                this.a.b(str, i);
                ui3Var.h = 0;
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: d */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        InterceptResult invokeLIL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, response, i, networkStatRecord)) == null) {
            if (response == null || response.body() == null) {
                return "";
            }
            ii3 l = ii3.l();
            if (TextUtils.equals(response.headers().get("Bdtls"), "recovery")) {
                l.m().s(0);
                return "recovery";
            }
            if (l.k()) {
                string = l.d.g(response.body().bytes());
                if (ci3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest parseResponse=" + string);
                }
            } else {
                string = response.body().string();
            }
            a(String.valueOf(response.request().url()), string, networkStatRecord.toUBCJson());
            return string;
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback, com.repackage.o84.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (ci3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onFail = " + exc.getMessage());
            }
            if (c()) {
                this.a.onFail(exc);
            }
        }
    }

    @Override // com.repackage.o84.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c()) {
            this.a.onStart();
        }
    }
}
