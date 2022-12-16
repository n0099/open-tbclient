package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CommandMessage extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_KEY = "appKey";
    public static final String APP_SECRET = "appSecret";
    public static final String CODE = "code";
    public static final int COMMANAD_NOTIFICATION_ALLOWANCE = 12313;
    public static final String COMMAND = "command";
    public static final int COMMAND_BASE = 12288;
    public static final int COMMAND_CLEAR_ALL_NOTIFICATION = 12305;
    public static final int COMMAND_CLEAR_NOTIFICATION = 12304;
    public static final int COMMAND_CLEAR_NOTIFICATION_TYPE = 12308;
    public static final int COMMAND_CLEAR_PKG_NOTIFICATION = 12311;
    public static final int COMMAND_GET_ACCOUNTS = 12302;
    public static final int COMMAND_GET_ALIAS = 12293;
    public static final int COMMAND_GET_NOTIFICATION_STATUS = 12309;
    public static final int COMMAND_GET_PUSH_STATUS = 12306;
    public static final int COMMAND_GET_TAGS = 12296;
    public static final int COMMAND_PAUSE_PUSH = 12299;
    public static final int COMMAND_REGISTER = 12289;
    public static final int COMMAND_RESUME_PUSH = 12300;
    public static final int COMMAND_SEND_INSTANT_ACK = 12312;
    public static final int COMMAND_SET_ACCOUNTS = 12301;
    public static final int COMMAND_SET_ALIAS = 12292;
    public static final int COMMAND_SET_NOTIFICATION_SETTINGS = 12310;
    public static final int COMMAND_SET_NOTIFICATION_TYPE = 12307;
    public static final int COMMAND_SET_PUSH_TIME = 12298;
    public static final int COMMAND_SET_TAGS = 12295;
    public static final int COMMAND_STATISTIC = 12291;
    public static final int COMMAND_UNREGISTER = 12290;
    public static final int COMMAND_UNSET_ACCOUNTS = 12303;
    public static final int COMMAND_UNSET_ALIAS = 12294;
    public static final int COMMAND_UNSET_TAGS = 12297;
    public static final String PARAMS = "params";
    public static final String REGISTER_ID = "registerID";
    public static final String SDK_VERSION = "sdkVersion";
    public static final String SPLITTER = "&";
    public static final String TYPE_ALIAS = "alias";
    public static final String TYPE_NULL = null;
    public static final String TYPE_TAGS = "tags";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppKey;
    public String mAppSecret;
    public int mCommand;
    public String mContent;
    public String mParams;
    public String mRegisterID;
    public int mResponseCode;
    public String mSdkVersion;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1645489705, "Lcom/heytap/mcssdk/mode/CommandMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1645489705, "Lcom/heytap/mcssdk/mode/CommandMessage;");
        }
    }

    public CommandMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResponseCode = -2;
    }

    public static List<String> parseToList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("&");
            if (split.length > 0) {
                arrayList = new ArrayList();
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static <T> String parseToString(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            StringBuilder sb = new StringBuilder();
            for (T t : list) {
                sb.append(t);
                sb.append("&");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<SubscribeResult> parseToSubscribeResultList(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4)) == null) {
            ArrayList arrayList2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
                arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        SubscribeResult subscribeResult = new SubscribeResult();
                        subscribeResult.setContent(jSONObject.getString(str4));
                        subscribeResult.setSubscribeId(jSONObject.getString(str3));
                        arrayList.add(subscribeResult);
                    } catch (JSONException e) {
                        e = e;
                        arrayList2 = arrayList;
                        e.printStackTrace();
                        arrayList = arrayList2;
                        LogUtil.d("parseToSubscribeResultList--" + arrayList);
                        return arrayList;
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            LogUtil.d("parseToSubscribeResultList--" + arrayList);
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppKey : (String) invokeV.objValue;
    }

    public String getAppSecret() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAppSecret : (String) invokeV.objValue;
    }

    public int getCommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCommand : invokeV.intValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContent : (String) invokeV.objValue;
    }

    public String getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mParams : (String) invokeV.objValue;
    }

    public String getRegisterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRegisterID : (String) invokeV.objValue;
    }

    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mResponseCode : invokeV.intValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSdkVersion : (String) invokeV.objValue;
    }

    @Override // com.heytap.mcssdk.mode.Message
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 4105;
        }
        return invokeV.intValue;
    }

    public void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mAppKey = str;
        }
    }

    public void setAppSecret(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mAppSecret = str;
        }
    }

    public void setCommand(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mCommand = i;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mContent = str;
        }
    }

    public void setParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mParams = str;
        }
    }

    public void setRegisterID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mRegisterID = str;
        }
    }

    public void setResponseCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mResponseCode = i;
        }
    }

    public void setSdkVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mSdkVersion = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "CommandMessage{, mRegisterID='" + this.mRegisterID + "', mSdkVersion='" + this.mSdkVersion + "', mCommand=" + this.mCommand + ", mContent='" + this.mContent + "', mResponseCode=" + this.mResponseCode + '}';
        }
        return (String) invokeV.objValue;
    }
}
