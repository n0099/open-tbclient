package com.tencent.open.web.security;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends a.C2091a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f76475d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(WebView webView, long j2, String str, String str2) {
        super(webView, j2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, Long.valueOf(j2), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebView) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76475d = str2;
    }

    private void b(String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || (webView = this.f76305a.get()) == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("javascript:");
        stringBuffer.append("if(!!");
        stringBuffer.append(this.f76475d);
        stringBuffer.append("){");
        stringBuffer.append(this.f76475d);
        stringBuffer.append("(");
        stringBuffer.append(str);
        stringBuffer.append(")}");
        String stringBuffer2 = stringBuffer.toString();
        SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
        webView.loadUrl(stringBuffer2);
    }

    @Override // com.tencent.open.a.C2091a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
        }
    }

    @Override // com.tencent.open.a.C2091a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
        }
    }

    @Override // com.tencent.open.a.C2091a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", !com.tencent.open.b.c.f76348a ? -4 : 0);
                jSONObject.put(IAdRequestParam.SN, this.f76306b);
                jSONObject.put("data", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b(jSONObject.toString());
        }
    }
}
