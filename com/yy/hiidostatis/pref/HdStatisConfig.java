package com.yy.hiidostatis.pref;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.message.log.TraceLog;
import java.util.Hashtable;
/* loaded from: classes7.dex */
public class HdStatisConfig extends AbstractConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String META_DATA_KEY_APP_KEY = "HIIDO_APPKEY";
    public static final String META_DATA_KEY_CHANNEL = "HIIDO_CHANNEL";
    public static final String PREF_CPAGE = "PREF_CPAGE";
    public static final String SDK_TYPE = "11";
    public static Hashtable<String, AbstractConfig> table;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppkey;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819322342, "Lcom/yy/hiidostatis/pref/HdStatisConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819322342, "Lcom/yy/hiidostatis/pref/HdStatisConfig;");
                return;
            }
        }
        table = new Hashtable<>();
    }

    public HdStatisConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAppkey = null;
        this.mAppkey = str;
        this.isEncrypt = true;
        this.isEncryptTestServer = false;
        this.testServer = null;
        this.urlConfigServer = "https://config.bigda.com/";
        this.urlLogUpload = "https://config.bigda.com/api/upload";
        this.cacheFileName = "hdstatis_cache_" + str;
        this.sdkVer = "3.5.23";
        setDefaultPrefName("hd_default_pref");
        setActLogNamePre(TraceLog.LOG_FILE_SUB_PATH);
        setActLogUploadUrl(this.urlLogUpload);
    }

    public static AbstractConfig getConfig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null || table.size() > 100) {
                str = "def_appkey";
            } else if (str.length() > 8) {
                str = str.substring(0, 8);
            }
            if (!table.containsKey(str)) {
                table.put(str, new HdStatisConfig(str));
            }
            return table.get(str);
        }
        return (AbstractConfig) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.inner.AbstractConfig
    public String getConfigKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppkey : (String) invokeV.objValue;
    }

    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.testServer = str;
        }
    }
}
