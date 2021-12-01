package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkVerController {
    public static /* synthetic */ Interceptable $ic;
    public static boolean mIsShowSdkUpdate;
    public transient /* synthetic */ FieldHolder $fh;
    public IConfigAPI mConfigApi;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-345469679, "Lcom/yy/hiidostatis/defs/controller/SdkVerController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-345469679, "Lcom/yy/hiidostatis/defs/controller/SdkVerController;");
        }
    }

    public SdkVerController(IConfigAPI iConfigAPI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iConfigAPI};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConfigApi = iConfigAPI;
    }

    public void startSdkVerCheck(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || mIsShowSdkUpdate) {
            return;
        }
        if (L.isLogOn()) {
            ThreadPool.getPool().execute(new Runnable(this, context) { // from class: com.yy.hiidostatis.defs.controller.SdkVerController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkVerController this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
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
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            JSONObject sdkVer = this.this$0.mConfigApi.getSdkVer(this.val$context, true);
                            if (sdkVer == null) {
                                return;
                            }
                            if ("1".equals(sdkVer.has("isUpdate") ? sdkVer.getString("isUpdate") : "")) {
                                String string = sdkVer.has("ver") ? sdkVer.getString("ver") : "";
                                String string2 = sdkVer.has("changeLog") ? sdkVer.getString("changeLog") : "";
                                if (Util.empty(string) || Util.empty(string2)) {
                                    return;
                                }
                                L.debug("SdkVerController", "统计SDK有新版本啦，欢迎使用新版本：V%s 。\n更新日志：\n%s", string, string2);
                            }
                        } catch (Throwable th) {
                            L.debug("SdkVerController", "get startSdkVerCheck exception: %s", th);
                        }
                    }
                }
            });
        }
        mIsShowSdkUpdate = true;
    }
}
