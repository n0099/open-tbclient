package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import b.e.a.g.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.paysdk.PayUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EbpayHttpRequestInterceptor() {
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

    @Override // com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor
    public void a(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = "intercept. X_BAIDU_IE = " + dVar.d();
            dVar.a().e("X_BAIDU_IE", dVar.d());
            dVar.a().e("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wims", "");
                jSONObject.put("wmip", PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
                jSONObject.put("wloc", PayUtils.encrypt("phone_number", PhoneUtils.getGPSLocation(context)));
                jSONObject.put("wssn", "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            dVar.a().e("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes())));
            b(stringBuffer);
            if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
                stringBuffer.append(";");
                stringBuffer.append("token=");
                stringBuffer.append(AccountManager.getInstance(context).getBfbToken());
            }
            dVar.a().e("Cookie", stringBuffer.toString());
        }
    }

    public final void b(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stringBuffer) == null) {
            stringBuffer.append("OPENBDUSS=");
            stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
            String str = "setToken():" + ((Object) stringBuffer);
        }
    }
}
