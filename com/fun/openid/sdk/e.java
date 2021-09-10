package com.fun.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f70029a;

    /* renamed from: b  reason: collision with root package name */
    public final OnGetOaidListener f70030b;

    public e(Context context, OnGetOaidListener onGetOaidListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onGetOaidListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70029a = context.getApplicationContext();
        this.f70030b = onGetOaidListener;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = this.f70029a;
            f.a aVar = new f.a() { // from class: c.g.a.a.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.fun.openid.sdk.f.a
                public final void a(boolean z, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, str) == null) {
                        e.this.a(z, str);
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
                if (i.f70032a == null && !i.f70033b) {
                    synchronized (i.class) {
                        if (i.f70032a == null && !i.f70033b) {
                            i.f70032a = b.a();
                            i.f70033b = true;
                        }
                    }
                }
                f fVar = i.f70032a;
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
            String string = this.f70029a.getSharedPreferences("openid_sdk_oaid_spf", 0).getString("key_oaid", null);
            if (TextUtils.isEmpty(string)) {
                a();
                return;
            }
            if (FunOpenIDSdk.isLogEnabled()) {
                String str = "==========在缓存中查找到oaid，直接返回 oaid = " + string;
            }
            OnGetOaidListener onGetOaidListener = this.f70030b;
            if (onGetOaidListener != null) {
                onGetOaidListener.onGetOaid(string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        OnGetOaidListener onGetOaidListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65537, this, z, str) == null) {
            if (FunOpenIDSdk.isLogEnabled()) {
                String str2 = "==========getOAID 结果 oaid = " + str + ", this = " + this;
            }
            this.f70029a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putString("key_oaid", str).apply();
            if (TextUtils.isEmpty(str) && z) {
                int i2 = this.f70029a.getSharedPreferences("openid_sdk_oaid_spf", 0).getInt("key_retry_count", 0);
                if (FunOpenIDSdk.isLogEnabled()) {
                    String str3 = "==========获取oaid失败 已重试 " + i2 + " 次，最多重试 3 次";
                }
                int i3 = i2 != 0 ? i2 == 1 ? 4 : i2 == 2 ? 6 : 0 : 2;
                if (i2 < 3) {
                    try {
                        if (FunOpenIDSdk.isLogEnabled()) {
                            String str4 = "==========获取oaid失败 " + i3 + " 秒后重试";
                        }
                        TimeUnit.SECONDS.sleep(i3);
                        this.f70029a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putInt("key_retry_count", i2 + 1).apply();
                        a();
                        return;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        onGetOaidListener = this.f70030b;
                        if (onGetOaidListener == null) {
                            return;
                        }
                    }
                } else {
                    onGetOaidListener = this.f70030b;
                    if (onGetOaidListener == null) {
                        return;
                    }
                }
                str = null;
            } else {
                onGetOaidListener = this.f70030b;
                if (onGetOaidListener == null) {
                    return;
                }
            }
            onGetOaidListener.onGetOaid(str);
        }
    }
}
