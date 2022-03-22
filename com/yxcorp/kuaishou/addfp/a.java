package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ KWEGIDDFP a;

    public a(KWEGIDDFP kwegiddfp) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kwegiddfp};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.a.mParamContext;
                if (context == null) {
                    responseDfpCallback2 = this.a.mCallBack;
                    responseDfpCallback2.onFailed(-3, "parameter error");
                    return;
                }
                KWEGIDDFP kwegiddfp = this.a;
                context2 = this.a.mParamContext;
                kwegiddfp.mPkgName = context2.getPackageName();
                com.yxcorp.kuaishou.addfp.android.a.a a = com.yxcorp.kuaishou.addfp.android.a.a.a();
                str = this.a.mPkgName;
                a.a(str);
                KWEGIDDFP kwegiddfp2 = this.a;
                responseDfpCallback = this.a.mCallBack;
                kwegiddfp2.getEGid(responseDfpCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
