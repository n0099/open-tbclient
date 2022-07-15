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
import com.repackage.o94;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jj3 extends m94<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o94.a a;

    public jj3(o94.a aVar) {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.repackage.o94.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) && a()) {
            this.a.b(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: c */
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            if (cj3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onSuccess=" + str);
            }
            if (this.a == null) {
                return;
            }
            ij3 l = ij3.l();
            if (TextUtils.equals(str, "recovery")) {
                if (l.m().b()) {
                    l.m().a();
                    l.d.i(true);
                    wj3 wj3Var = l.d;
                    if (wj3Var instanceof uj3) {
                        ((uj3) wj3Var).j();
                        return;
                    }
                    return;
                }
                this.a.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                return;
            }
            l.m().k();
            wj3 wj3Var2 = l.d;
            if (wj3Var2 instanceof uj3) {
                uj3 uj3Var = (uj3) wj3Var2;
                if (l.k()) {
                    if (l.d.b == 1) {
                        hj3.a(MimeTypes.BASE_TYPE_APPLICATION);
                        this.a.c(str, i);
                        uj3Var.h = 0;
                        return;
                    }
                    int i2 = uj3Var.h;
                    uj3Var.h = i2 + 1;
                    if (i2 < 3) {
                        uj3Var.j();
                        return;
                    }
                    o94.a aVar = this.a;
                    aVar.onFail(new IOException("request fail : " + str));
                    uj3Var.h = 0;
                    return;
                }
                this.a.c(str, i);
                uj3Var.h = 0;
            }
        }
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
            ij3 l = ij3.l();
            if (TextUtils.equals(response.headers().get("Bdtls"), "recovery")) {
                l.m().s(0);
                return "recovery";
            }
            if (l.k()) {
                string = l.d.g(response.body().bytes());
                if (cj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest parseResponse=" + string);
                }
            } else {
                string = response.body().string();
            }
            b(String.valueOf(response.request().url()), string, networkStatRecord.toUBCJson());
            return string;
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback, com.repackage.o94.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (cj3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onFail = " + exc.getMessage());
            }
            if (a()) {
                this.a.onFail(exc);
            }
        }
    }

    @Override // com.repackage.o94.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && a()) {
            this.a.onStart();
        }
    }
}
