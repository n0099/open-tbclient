package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.f;
/* loaded from: classes9.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ KWEGIDDFP a;

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
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.a.mParamContext;
                if (context == null) {
                    responseDfpCallback2 = this.a.mCallBack;
                    responseDfpCallback2.onFailed(-3, "parameter error");
                    return;
                }
                unused = this.a.mParamContext;
                int i = f.c;
                if (Build.VERSION.SDK_INT >= 28) {
                    f.a();
                }
                KWEGIDDFP kwegiddfp = this.a;
                context2 = kwegiddfp.mParamContext;
                kwegiddfp.mPkgName = context2.getPackageName();
                c c = c.c();
                str = this.a.mPkgName;
                c.b(str);
                KWEGIDDFP kwegiddfp2 = this.a;
                responseDfpCallback = kwegiddfp2.mCallBack;
                kwegiddfp2.getEGid(responseDfpCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
