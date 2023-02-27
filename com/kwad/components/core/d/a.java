package com.kwad.components.core.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.a.h;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.w;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
/* loaded from: classes8.dex */
public class a extends d implements f {
    public String Et;
    public long Eu;
    public String Ev;
    public Context mContext;

    private void ai(Context context) {
        b.i("EncryptComponentsImpl", "初次获取Gid: initGId");
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.d.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                b.e("EncryptComponentsImpl", "初次获取Gid: initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                b.d("SDKPrivateSafetyData", "deviceInfo：" + str2);
                a.this.am(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(String str) {
        if (this.mContext == null || ax.dT(str) || ax.V(nf(), str)) {
            return;
        }
        this.Ev = str;
        w.K(this.mContext, str);
    }

    private void na() {
        String co = w.co(this.mContext);
        String AE = az.AE();
        if (TextUtils.isEmpty(co)) {
            w.E(this.mContext, AE);
        } else if (TextUtils.equals(co, AE)) {
        } else {
            this.Et = "";
            this.Eu = 0L;
            this.Ev = "";
            w.D(this.mContext, "");
            w.f(this.mContext, this.Eu);
            w.K(this.mContext, this.Ev);
            w.E(this.mContext, AE);
        }
    }

    private String nd() {
        if (TextUtils.isEmpty(this.Et)) {
            this.Et = w.cl(this.mContext);
        }
        return this.Et;
    }

    private long ne() {
        if (this.Eu == 0) {
            this.Eu = w.cm(this.mContext);
        }
        return this.Eu;
    }

    private String nf() {
        if (TextUtils.isEmpty(this.Ev)) {
            this.Ev = w.cp(this.mContext);
        }
        return this.Ev;
    }

    @Override // com.kwad.sdk.components.f
    public final void an(String str) {
        if (this.mContext == null || ax.dT(str) || ax.V(nd(), str)) {
            return;
        }
        try {
            this.Et = str;
            w.D(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return f.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        try {
            this.mContext = context;
            na();
            ai(context);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.f
    public final void m(long j) {
        if (this.mContext == null || j <= 0 || j == ne()) {
            return;
        }
        this.Eu = j;
        w.f(this.mContext, j);
    }

    @Override // com.kwad.sdk.components.f
    public final String nb() {
        return (com.kwad.sdk.core.config.d.rW() || System.currentTimeMillis() >= ne() || TextUtils.isEmpty(nd())) ? nf() : "";
    }

    @Override // com.kwad.sdk.components.f
    public final h nc() {
        return new com.kwad.sdk.core.a.a();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        return -200;
    }
}
