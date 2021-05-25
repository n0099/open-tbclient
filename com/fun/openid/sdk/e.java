package com.fun.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.fun.openid.sdk.f;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f30717a;

    /* renamed from: b  reason: collision with root package name */
    public final OnGetOaidListener f30718b;

    /* loaded from: classes6.dex */
    public class a implements f.a {
        public a() {
        }

        public void a(boolean z, String str) {
            OnGetOaidListener onGetOaidListener;
            if (FunOpenIDSdk.isLogEnabled()) {
                Log.e(FunOpenIDSdk.TAG, "==========getOAID 结果 oaid = " + str + ", this = " + this);
            }
            e.this.f30717a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putString("key_oaid", str).apply();
            if (TextUtils.isEmpty(str) && z) {
                int i2 = e.this.f30717a.getSharedPreferences("openid_sdk_oaid_spf", 0).getInt("key_retry_count", 0);
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "==========获取oaid失败 已重试 " + i2 + " 次，最多重试 3 次");
                }
                int i3 = i2 != 0 ? i2 == 1 ? 4 : i2 == 2 ? 6 : 0 : 2;
                if (i2 < 3) {
                    try {
                        if (FunOpenIDSdk.isLogEnabled()) {
                            Log.e(FunOpenIDSdk.TAG, "==========获取oaid失败 " + i3 + " 秒后重试");
                        }
                        TimeUnit.SECONDS.sleep(i3);
                        e.this.f30717a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putInt("key_retry_count", i2 + 1).apply();
                        e.this.a();
                        return;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        onGetOaidListener = e.this.f30718b;
                        if (onGetOaidListener == null) {
                            return;
                        }
                    }
                } else {
                    onGetOaidListener = e.this.f30718b;
                    if (onGetOaidListener == null) {
                        return;
                    }
                }
                onGetOaidListener.onGetOaid(null);
                return;
            }
            OnGetOaidListener onGetOaidListener2 = e.this.f30718b;
            if (onGetOaidListener2 != null) {
                onGetOaidListener2.onGetOaid(str);
            }
        }
    }

    public e(Context context, OnGetOaidListener onGetOaidListener) {
        this.f30717a = context.getApplicationContext();
        this.f30718b = onGetOaidListener;
    }

    public final void a() {
        Context context = this.f30717a;
        a aVar = new a();
        synchronized (i.class) {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            if (i.f30723a == null && !i.f30724b) {
                synchronized (i.class) {
                    if (i.f30723a == null && !i.f30724b) {
                        i.f30723a = b.a();
                        i.f30724b = true;
                    }
                }
            }
            f fVar = i.f30723a;
            if (fVar != null) {
                fVar.a(context, aVar);
            } else {
                aVar.a(false, null);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String string = this.f30717a.getSharedPreferences("openid_sdk_oaid_spf", 0).getString("key_oaid", null);
        if (TextUtils.isEmpty(string)) {
            a();
            return;
        }
        if (FunOpenIDSdk.isLogEnabled()) {
            Log.e(FunOpenIDSdk.TAG, "==========在缓存中查找到oaid，直接返回 oaid = " + string);
        }
        OnGetOaidListener onGetOaidListener = this.f30718b;
        if (onGetOaidListener != null) {
            onGetOaidListener.onGetOaid(string);
        }
    }
}
