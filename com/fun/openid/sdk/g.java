package com.fun.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.fun.openid.sdk.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5245a;
    public final c pRe;

    /* loaded from: classes3.dex */
    public class a implements h.a {
        public a() {
        }

        public void a(boolean z, String str) {
            c cVar;
            int i = 2;
            if (b.isLogEnabled()) {
                Log.e("FunOpenIDSdk", "==========getOAID 结果 oaid = " + str + ", this = " + this);
            }
            g.this.f5245a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putString("key_oaid", str).apply();
            if (TextUtils.isEmpty(str) && z) {
                int i2 = g.this.f5245a.getSharedPreferences("openid_sdk_oaid_spf", 0).getInt("key_retry_count", 0);
                if (b.isLogEnabled()) {
                    Log.e("FunOpenIDSdk", "==========获取oaid失败 已重试 " + i2 + " 次，最多重试 3 次");
                }
                if (i2 != 0) {
                    i = i2 == 1 ? 4 : i2 == 2 ? 6 : 0;
                }
                if (i2 < 3) {
                    try {
                        if (b.isLogEnabled()) {
                            Log.e("FunOpenIDSdk", "==========获取oaid失败 " + i + " 秒后重试");
                        }
                        TimeUnit.SECONDS.sleep(i);
                        g.this.f5245a.getSharedPreferences("openid_sdk_oaid_spf", 0).edit().putInt("key_retry_count", i2 + 1).apply();
                        g.this.a();
                        return;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        cVar = g.this.pRe;
                        if (cVar == null) {
                            return;
                        }
                    }
                } else {
                    cVar = g.this.pRe;
                    if (cVar == null) {
                        return;
                    }
                }
                cVar.bc(null);
                return;
            }
            c cVar2 = g.this.pRe;
            if (cVar2 != null) {
                cVar2.bc(str);
            }
        }
    }

    public g(Context context, c cVar) {
        this.f5245a = context.getApplicationContext();
        this.pRe = cVar;
    }

    public final void a() {
        Context context = this.f5245a;
        a aVar = new a();
        synchronized (k.class) {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            if (k.pRi == null && !k.b) {
                synchronized (k.class) {
                    if (k.pRi == null && !k.b) {
                        k.pRi = d.eAG();
                        k.b = true;
                    }
                }
            }
            h hVar = k.pRi;
            if (hVar != null) {
                hVar.a(context, aVar);
            } else {
                aVar.a(false, null);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String string = this.f5245a.getSharedPreferences("openid_sdk_oaid_spf", 0).getString("key_oaid", null);
        if (TextUtils.isEmpty(string)) {
            a();
            return;
        }
        if (b.isLogEnabled()) {
            Log.e("FunOpenIDSdk", "==========在缓存中查找到oaid，直接返回 oaid = " + string);
        }
        c cVar = this.pRe;
        if (cVar != null) {
            cVar.bc(string);
        }
    }
}
