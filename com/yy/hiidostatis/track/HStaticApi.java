package com.yy.hiidostatis.track;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.inner.util.ThreadPool;
import java.util.Map;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class HStaticApi {
    public static final /* synthetic */ HStaticApi[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HStaticApi instante;
    public transient /* synthetic */ FieldHolder $fh;
    public StatisAPI mStatisAPI;
    public StatisAPI mStatisAPI_3;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-892626240, "Lcom/yy/hiidostatis/track/HStaticApi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-892626240, "Lcom/yy/hiidostatis/track/HStaticApi;");
                return;
            }
        }
        HStaticApi hStaticApi = new HStaticApi("instante", 0);
        instante = hStaticApi;
        $VALUES = new HStaticApi[]{hStaticApi};
    }

    public HStaticApi(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HStaticApi valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (HStaticApi) Enum.valueOf(HStaticApi.class, str) : (HStaticApi) invokeL.objValue;
    }

    public static HStaticApi[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (HStaticApi[]) $VALUES.clone() : (HStaticApi[]) invokeV.objValue;
    }

    public void init(Context context, StatisOption statisOption, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, statisOption, str) == null) {
            this.mStatisAPI = HiidoSDK.instance().createNewStatisApi();
            StatisOption statisOption2 = new StatisOption();
            statisOption2.setAppkey("t2-" + statisOption.getAppkey());
            statisOption2.setAppId(statisOption.getAppId());
            statisOption2.setFrom(statisOption.getFrom());
            statisOption2.setVer(statisOption.getVer());
            this.mStatisAPI.init(context, statisOption2);
            this.mStatisAPI.setAbroad(false);
            this.mStatisAPI_3 = HiidoSDK.instance().createNewStatisApi();
            StatisOption statisOption3 = new StatisOption();
            statisOption3.setAppkey("t3-" + statisOption.getAppkey());
            statisOption3.setAppId(statisOption.getAppId());
            statisOption3.setFrom(statisOption.getFrom());
            statisOption3.setVer(statisOption.getVer());
            this.mStatisAPI_3.init(context, statisOption3);
            this.mStatisAPI_3.setBusinessType(HiidoSDK.instance().getOptions().businessType);
            this.mStatisAPI_3.setAbroad(true);
        }
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, map) == null) {
            ThreadPool.getPool().execute(new Runnable(this, str, str2, str3, map) { // from class: com.yy.hiidostatis.track.HStaticApi.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HStaticApi this$0;
                public final /* synthetic */ String val$name;
                public final /* synthetic */ Map val$prop;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ String val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, map};
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
                    this.val$uid = str;
                    this.val$name = str2;
                    this.val$type = str3;
                    this.val$prop = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mStatisAPI != null) {
                            this.this$0.mStatisAPI.reportReg(this.val$uid, this.val$name, this.val$type, this.val$prop);
                        }
                        if (this.this$0.mStatisAPI_3 != null) {
                            this.this$0.mStatisAPI_3.reportReg(this.val$uid, this.val$name, this.val$type, this.val$prop);
                        }
                    }
                }
            });
        }
    }
}
