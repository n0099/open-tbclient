package com.fun.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final OnGetOaidListener b;

    public e(Context context, OnGetOaidListener onGetOaidListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGetOaidListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = onGetOaidListener;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = this.a;
            f.a aVar = new f.a() { // from class: com.repackage.hi9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.fun.openid.sdk.f.a
                public final void a(boolean z, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, str) == null) {
                        com.fun.openid.sdk.e.this.a(z, str);
                    }
                }
            };
            synchronized (i.class) {
                if (context == null) {
                    throw new RuntimeException("Context is null");
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                if (i.a == null && !i.b) {
                    synchronized (i.class) {
                        if (i.a == null && !i.b) {
                            i.a = b.a();
                            i.b = true;
                        }
                    }
                }
                f fVar = i.a;
                if (fVar != null) {
                    fVar.a(context, aVar);
                } else {
                    aVar.a(false, null);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        OnGetOaidListener onGetOaidListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65537, this, z, str) == null) {
            if (FunOpenIDSdk.isLogEnabled()) {
                Log.e(FunOpenIDSdk.TAG, "==========getOAID 结果 oaid = " + str + ", this = " + this);
            }
            if (TextUtils.isEmpty(str) && z) {
                int i = this.a.getSharedPreferences("openid_sdk_oaid_spf", 0).getInt("key_retry_count", 0);
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "==========获取oaid失败 已重试 " + i + " 次，最多重试 3 次");
                }
                int i2 = i != 0 ? i == 1 ? 4 : i == 2 ? 6 : 0 : 2;
                if (i < 3) {
                    try {
                        if (FunOpenIDSdk.isLogEnabled()) {
                            Log.e(FunOpenIDSdk.TAG, "==========获取oaid失败 " + i2 + " 秒后重试");
                        }
                        TimeUnit.SECONDS.sleep(i2);
                        this.a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putInt("key_retry_count", i + 1).apply();
                        a();
                        return;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        onGetOaidListener = this.b;
                        if (onGetOaidListener == null) {
                            return;
                        }
                    }
                } else {
                    onGetOaidListener = this.b;
                    if (onGetOaidListener == null) {
                        return;
                    }
                }
                str = null;
            } else {
                onGetOaidListener = this.b;
                if (onGetOaidListener == null) {
                    return;
                }
            }
            onGetOaidListener.onGetOaid(str);
        }
    }
}
