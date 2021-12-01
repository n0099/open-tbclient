package com.dxmpay.wallet.paysdk.entrance;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.lollipop.json.JSONArray;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class EnterDxmPayServiceAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHECK_PWD_FOR_H5 = "checkPwdForH5";
    public static final String DXM_SERVICE_EXTRA = "serviceExtra";
    public static final String DXM_SERVICE_NAME = "serviceName";
    public static final String ERR_MSG = "参数非法";
    public static final String GET_DXM_PAY_SUPPORT_SERVICE_LIST = "getDxmPaySupportServiceList";
    public static final String OCR_IDCARD_INIT = "ocr_idcard_init";
    public static final String OCR_IDCARD_KEY = "ocr_idcard_key";
    public static final String SERVICE_DATA = "data";
    public static final String SERVICE_DES = "des";
    public static final String SERVICE_STATUS_CODE = "statusCode";
    public static final long SVC_ID_H5_CHECKPWD = 10013;
    public transient /* synthetic */ FieldHolder $fh;

    public EnterDxmPayServiceAction() {
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

    private void a(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, context, str, routerCallback) == null) {
            if (context != null && routerCallback != null && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(DXM_SERVICE_NAME);
                    String optString2 = jSONObject.optString("serviceExtra");
                    String optString3 = jSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, null);
                    StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_ENTER, StatHelper.collectData(optString, optString2));
                    if (!TextUtils.isEmpty(optString3) && 10013 == Long.parseLong(optString3)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(DXM_SERVICE_NAME, CHECK_PWD_FOR_H5);
                        jSONObject2.put("serviceExtra", optString2);
                        a(context, (Object) jSONObject2.toString(), routerCallback);
                        return;
                    } else if (!TextUtils.isEmpty(optString)) {
                        if ("callDXMIDCardOCR".equals(optString)) {
                            errorCallback(5, "没有OCR身份证识别模块", routerCallback);
                            return;
                        } else if ("getDxmPayUserAgent".equals(optString)) {
                            a(optString, 0, BussinessUtils.getUA(context), routerCallback);
                            return;
                        } else if (GET_DXM_PAY_SUPPORT_SERVICE_LIST.equals(optString)) {
                            b(context, optString2, routerCallback);
                            return;
                        } else {
                            a(context, (Object) str, routerCallback);
                            return;
                        }
                    } else {
                        errorCallback(10001, ERR_MSG, routerCallback);
                        return;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    errorCallback(10001, e2.toString(), routerCallback);
                    return;
                }
            }
            errorCallback(10001, ERR_MSG, routerCallback);
        }
    }

    public static String assembleResult(Map<String, Object> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, map, z)) == null) {
            if (map == null) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put(BeanConstants.DXM_OCR_KEY_CNT, new org.json.JSONObject(map));
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeLZ.objValue;
    }

    private void b(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, context, str, routerCallback) == null) {
            if (TextUtils.isEmpty(str)) {
                errorCallback(10001, ERR_MSG, routerCallback);
                return;
            }
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("serviceNameList");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(PreferencesUtil.LEFT_MOUNT);
                    boolean z = false;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String string = optJSONArray.getString(i2);
                        if (TextUtils.isEmpty(string)) {
                            errorCallback(10001, ERR_MSG, routerCallback);
                        } else if (LocalRouter.getInstance(context).isProviderExisted(string)) {
                            sb.append(string);
                            sb.append(",");
                            z = true;
                        }
                    }
                    if (z) {
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(PreferencesUtil.RIGHT_MOUNT);
                        hasDesDataSuccessCallback(GET_DXM_PAY_SUPPORT_SERVICE_LIST, 0, sb.toString(), routerCallback);
                        return;
                    }
                    errorCallback(10009, "不支持该端能力", routerCallback);
                    return;
                }
                errorCallback(10001, ERR_MSG, routerCallback);
            } catch (JSONException e2) {
                e2.printStackTrace();
                errorCallback(10001, e2.getMessage(), routerCallback);
            }
        }
    }

    public static void errorCallback(int i2, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, null, i2, str, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_ERROR, StatHelper.collectData(i2 + "", str));
            if (routerCallback != null) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SERVICE_STATUS_CODE, i2);
                    jSONObject.put("des", str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
                String assembleResult = assembleResult(hashMap, false);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", assembleResult);
                routerCallback.onResult(1, hashMap2);
            }
        }
    }

    public void hasDesDataSuccessCallback(String str, int i2, String str2, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, str, i2, str2, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(str, i2 + "", str2));
            if (routerCallback != null) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SERVICE_STATUS_CODE, i2);
                    jSONObject.put("des", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
                String assembleResult = assembleResult(hashMap, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", assembleResult);
                routerCallback.onResult(0, hashMap2);
            }
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("options") && (hashMap.get("options") instanceof String)) {
                a(context, (String) hashMap.get("options"), routerCallback);
            } else {
                errorCallback(10001, ERR_MSG, routerCallback);
            }
        }
    }

    private void a(Context context, Object obj, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, obj, routerCallback) == null) {
            if (context != null && routerCallback != null && obj != null) {
                LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action(BeanConstants.SDK_ENTER_WALLET_DXM_PAY_SERVICE).data("options", obj), routerCallback);
            } else {
                errorCallback(10001, ERR_MSG, routerCallback);
            }
        }
    }

    private void a(String str, int i2, String str2, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65539, this, str, i2, str2, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(str, i2 + "", str2));
            HashMap hashMap = new HashMap();
            hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
            String assembleResult = assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
