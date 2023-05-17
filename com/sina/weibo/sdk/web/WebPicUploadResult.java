package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class WebPicUploadResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
    public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
    public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String picId;

    public WebPicUploadResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.code = -2;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.code;
        }
        return invokeV.intValue;
    }

    public String getPicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.picId;
        }
        return (String) invokeV.objValue;
    }

    public static WebPicUploadResult parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            WebPicUploadResult webPicUploadResult = new WebPicUploadResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                webPicUploadResult.code = jSONObject.optInt("code", -2);
                webPicUploadResult.picId = jSONObject.optString("data", "");
            } catch (JSONException unused) {
            }
            return webPicUploadResult;
        }
        return (WebPicUploadResult) invokeL.objValue;
    }
}
