package com.yy.mobile.framework.revenuesdk.payservice.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class JsonDataParerUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AppPayServiceImpl";
    public transient /* synthetic */ FieldHolder $fh;

    public JsonDataParerUtil() {
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

    public static String getCHOrderId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = "";
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("developerPayload");
                    if (string != null && !string.equals("")) {
                        String string2 = new JSONObject(string).getString("chOrderId");
                        if (string2 != null) {
                            str2 = string2;
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getCHOrderId--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
                }
            }
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , chorderId =%s", str, str2));
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getChOrderidByPayload(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("chOrderId");
                    if (string != null && !string.equals("")) {
                        return string;
                    }
                    RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChOrderidByPayload =null ", new Object[0]));
                    return "";
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad--getChOrderidByPayload data =%s , Exception =%s", str, e2.getMessage()));
                }
            }
            RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChOrderidByPayload data =%s , getPayLoad =%s", str, ""));
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getChallengeExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String str2 = "";
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("riskData");
                    if (string != null && !string.equals("")) {
                        str2 = new JSONObject(string).getString("challengeExtension");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getChallengeExtension--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()));
                }
            }
            RLog.debug("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---getChallengeExtension data =%s , purchaseTime =%s", str, str2));
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getGPOrderId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String str2 = "";
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("orderId");
                    if (string != null) {
                        str2 = string;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPurchaseTime--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
                }
            }
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , orderId =%s", str, str2));
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getPayLoad(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("developerPayload");
                    if (string != null && !string.equals("")) {
                        return string;
                    }
                    RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad =null ", new Object[0]), new Object[0]);
                    return "";
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.warn("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPayLoad--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()));
                }
            }
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , getPayLoad =%s", str, ""));
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getProductId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            String str2 = "";
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("productId");
                    if (string != null) {
                        str2 = string;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --productId--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
                }
            }
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , orderId =%s", str, str2));
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static PurchaseInfo getPurchaseInfoByProductId(String str, List<PurchaseInfo> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, list)) == null) {
            for (PurchaseInfo purchaseInfo : list) {
                try {
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (str == new JSONObject(purchaseInfo.data).optString("productId")) {
                    return purchaseInfo;
                }
            }
            return null;
        }
        return (PurchaseInfo) invokeLL.objValue;
    }

    public static long getPurchaseTime(String str) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str != null) {
                try {
                    j2 = new JSONObject(str).getLong("purchaseTime");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    RLog.error("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser fail --getPurchaseTime--PayCallbackProxy data =%s , Exception =%s", str, e2.getMessage()), new Object[0]);
                }
                RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , purchaseTime =%s", str, Long.valueOf(j2)));
                return j2;
            }
            j2 = 0;
            RLog.info("AppPayServiceImpl", String.format(Locale.ENGLISH, "data parser success ---PayCallbackProxy data =%s , purchaseTime =%s", str, Long.valueOf(j2)));
            return j2;
        }
        return invokeL.longValue;
    }
}
