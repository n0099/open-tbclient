package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q80 extends p80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* loaded from: classes6.dex */
    public interface a {
        void onFailure(int i, String str);

        void onResponse(String str);
    }

    public q80(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = aVar;
    }

    @Override // com.repackage.r80.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.r80.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int a2 = w80.a(this.a);
            if (a2 == 1) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else if (a2 == 2) {
                return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/rest/5.0/generate_lcm_token";
            } else if (w80.b(this.a)) {
                return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
            } else {
                return "https://pim.baidu.com/rest/5.0/generate_lcm_token";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.r80.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.repackage.r80.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                JSONObject jSONObject = (JSONObject) v80.c(this.a, true);
                return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.repackage.r80.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.b.onFailure(i, str);
        }
    }

    @Override // com.repackage.r80.d
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(bArr));
                y80.a("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
                int optInt = jSONObject2.optInt("error_code", -1);
                String optString = jSONObject2.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                q70.h(this.a).g(601110).c("token_end", System.currentTimeMillis()).b("connect_state", 1).d("P2", jSONObject2.toString()).d("con_err_code", "P2");
                if (optInt == 0) {
                    z80.r(this.a, jSONObject2.optBoolean("bddns_enable", false));
                    String optString2 = jSONObject2.optString("token");
                    JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                    if (!TextUtils.isEmpty(optString2) && jSONArray != null && jSONArray.length() >= 1) {
                        z80.x(this.a, jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                            z80.w(this.a, jSONObject3.optString(ProbeTB.PROTOCOL) + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i);
                        }
                        z80.t(this.a, jSONObject2.optInt("ipv6_strategy", 3));
                        this.b.onResponse(optString2);
                        z80.z(this.a, optString2);
                        try {
                            String optString3 = jSONObject2.optString("client_log_config", "");
                            if (TextUtils.isEmpty(optString3)) {
                                return;
                            }
                            JSONObject jSONObject4 = new JSONObject(optString3);
                            w70.j(this.a, jSONObject4.optInt("client_upload_log_switch", 0));
                            JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                            if (jSONArray2 != null && jSONArray2.length() > 0) {
                                for (int i2 = 0; i2 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i2)) != null; i2++) {
                                    w70.i(this.a, jSONObject.optInt("id", 0), jSONObject.optInt("switch", 0));
                                }
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            a aVar = this.b;
                            aVar.onFailure(10001, "Json Exception" + e);
                            y80.b("GetTokenRequest", "Json Exception");
                            return;
                        }
                    }
                    this.b.onFailure(10002, "token or protocol is empty");
                    q70.h(this.a).g(601110).c("flow_end_time", System.currentTimeMillis()).e();
                    return;
                }
                this.b.onFailure(optInt, optString);
            } catch (JSONException e2) {
                a aVar2 = this.b;
                aVar2.onFailure(10001, "parse response exception ：" + e2);
            }
        }
    }
}
