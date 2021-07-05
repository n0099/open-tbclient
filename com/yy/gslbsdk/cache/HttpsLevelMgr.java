package com.yy.gslbsdk.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.control.SwitchController;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class HttpsLevelMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpsLevelMgr";
    public static HttpsLevelMgr sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1131890507, "Lcom/yy/gslbsdk/cache/HttpsLevelMgr;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1131890507, "Lcom/yy/gslbsdk/cache/HttpsLevelMgr;");
        }
    }

    public HttpsLevelMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HttpsLevelMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new HttpsLevelMgr();
            }
            return sInstance;
        }
        return (HttpsLevelMgr) invokeV.objValue;
    }

    public String[] request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = GlobalTools.ACCOUNT_ID;
            if (str == null) {
                str = "";
            }
            String str2 = GlobalTools.APP_DEV_ID;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = GlobalTools.APP_LOCALIZE_CODE;
            String str4 = str3 != null ? str3 : "";
            String identity = DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT);
            HashMap hashMap = new HashMap();
            hashMap.put("host", GlobalTools.HTTPDNS_SERVER_HOST);
            hashMap.put("p", "a");
            hashMap.put("devid", str2);
            hashMap.put("gslbid", identity);
            hashMap.put("appid", str);
            hashMap.put("version", "2.2.18-lianyun");
            boolean z = true;
            if (GlobalTools.IS_TEST_ENV && !GlobalTools.HTTPDNS_SERVER_HOST.equals(GlobalTools.HTTPDNS_HOST_TEST)) {
                z = false;
            }
            if (z) {
                return HTTPMgr.postSniHttps("https://" + GlobalTools.HTTPDNS_SERVER_HOST + "/https_level?appid=" + str + "&usercfg=" + str4, GlobalTools.HTTPDNS_SERVER_HOST, null, hashMap);
            }
            return HTTPMgr.postHttp("http://" + GlobalTools.HTTPDNS_SERVER_HOST + "/https_level?appid=" + str + "&usercfg=" + str4, null, hashMap);
        }
        return (String[]) invokeV.objValue;
    }

    public int response(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || str.length() < 1) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("s") != 0) {
                    SwitchController.getInstance().deal(1);
                    return 3;
                }
                int i2 = jSONObject.getInt("level");
                SwitchController.getInstance().deal(i2);
                if (i2 >= 0 && 2 >= i2) {
                    setHttpsLevel(i2);
                    return 0;
                }
                return 3;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return 3;
            }
        }
        return invokeL.intValue;
    }

    public void setHttpsLevel(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 0 || i2 > 2 || i2 <= GlobalTools.HTTPS_LEVEL) {
            return;
        }
        GlobalTools.HTTPS_LEVEL = i2;
    }

    public int update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadInfo threadInfo = new ThreadInfo("HttpsLevelUpdate");
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this) { // from class: com.yy.gslbsdk.cache.HttpsLevelMgr.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpsLevelMgr this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        String[] request = this.this$0.request();
                        if (request == null) {
                            SwitchController.getInstance().deal(1);
                        } else {
                            this.this$0.response(request[1]);
                        }
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
            return 0;
        }
        return invokeV.intValue;
    }
}
