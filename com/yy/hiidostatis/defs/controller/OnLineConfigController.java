package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.defs.interf.IOnLineConfigListener;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class OnLineConfigController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREF_KEY_ONLINE_CONFIG_DATA = "PREF_KEY_ONLINE_CONFIG_DATA";
    public static Preference preference;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFinishUpdateConfig;
    public IConfigAPI mConfigAPI;
    public IOnLineConfigListener onLineConfigListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1123778245, "Lcom/yy/hiidostatis/defs/controller/OnLineConfigController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1123778245, "Lcom/yy/hiidostatis/defs/controller/OnLineConfigController;");
                return;
            }
        }
        preference = new Preference("hd_online_config_pref", true);
    }

    public boolean isFinishUpdateConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isFinishUpdateConfig;
        }
        return invokeV.booleanValue;
    }

    public OnLineConfigController(IConfigAPI iConfigAPI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iConfigAPI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isFinishUpdateConfig = false;
        this.mConfigAPI = iConfigAPI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getOnlineParamsJSON(Context context) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            String prefString = preference.getPrefString(context, PREF_KEY_ONLINE_CONFIG_DATA, "");
            if (Util.empty(prefString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(prefString);
            if (!(jSONObject.get("onlineParams") instanceof JSONObject)) {
                return null;
            }
            return jSONObject.getJSONObject("onlineParams");
        }
        return (JSONObject) invokeL.objValue;
    }

    public void setOnLineConfigListener(IOnLineConfigListener iOnLineConfigListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOnLineConfigListener) == null) {
            this.onLineConfigListener = iOnLineConfigListener;
        }
    }

    public void updateOnlineConfigs(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            this.isFinishUpdateConfig = false;
            ThreadPool.getPool().execute(new Runnable(this, context, str) { // from class: com.yy.hiidostatis.defs.controller.OnLineConfigController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OnLineConfigController this$0;
                public final /* synthetic */ String val$appKey;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$appKey = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = null;
                        try {
                            String onlineConfigs = this.this$0.mConfigAPI.getOnlineConfigs(this.val$context, this.val$appKey);
                            L.debug("OnLineConfigController", "the online config data is %s", onlineConfigs);
                            if (onlineConfigs != null && onlineConfigs.length() > 0) {
                                OnLineConfigController.preference.setPrefString(this.val$context, OnLineConfigController.PREF_KEY_ONLINE_CONFIG_DATA, onlineConfigs);
                            }
                            this.this$0.isFinishUpdateConfig = true;
                        } catch (Throwable th) {
                            try {
                                L.debug("OnLineConfigController", "updateOnlineConfigs error! %s", th);
                                this.this$0.isFinishUpdateConfig = true;
                                if (this.this$0.onLineConfigListener == null) {
                                    return;
                                }
                                try {
                                    jSONObject = this.this$0.getOnlineParamsJSON(this.val$context);
                                } catch (JSONException e) {
                                    L.debug(this, "get getOnlineParamsJSON error! %s", e);
                                }
                                if (jSONObject == null) {
                                    jSONObject = new JSONObject();
                                }
                                L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                            } catch (Throwable th2) {
                                this.this$0.isFinishUpdateConfig = true;
                                if (this.this$0.onLineConfigListener != null) {
                                    try {
                                        jSONObject = this.this$0.getOnlineParamsJSON(this.val$context);
                                    } catch (JSONException e2) {
                                        L.debug(this, "get getOnlineParamsJSON error! %s", e2);
                                    }
                                    if (jSONObject == null) {
                                        jSONObject = new JSONObject();
                                    }
                                    L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                                    this.this$0.onLineConfigListener.onDataReceived(jSONObject);
                                }
                                throw th2;
                            }
                        }
                        if (this.this$0.onLineConfigListener == null) {
                            return;
                        }
                        try {
                            jSONObject = this.this$0.getOnlineParamsJSON(this.val$context);
                        } catch (JSONException e3) {
                            L.debug(this, "get getOnlineParamsJSON error! %s", e3);
                        }
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                        this.this$0.onLineConfigListener.onDataReceived(jSONObject);
                    }
                }
            });
        }
    }

    public String getOnlineConfigParams(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            try {
                JSONObject onlineParamsJSON = getOnlineParamsJSON(context);
                if (onlineParamsJSON == null || !onlineParamsJSON.has(str)) {
                    return "";
                }
                return onlineParamsJSON.getString(str);
            } catch (Throwable th) {
                L.debug("OnLineConfigController", "getOnlineConfigParams error! %s", th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
