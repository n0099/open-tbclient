package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.a.g;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.y;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends d implements f {
    public String Lq;
    public long Lr;
    public String Ls;
    public Context mContext;

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return -200;
    }

    private String oo() {
        if (TextUtils.isEmpty(this.Lq)) {
            this.Lq = y.bZ(this.mContext);
        }
        return this.Lq;
    }

    private long op() {
        if (this.Lr == 0) {
            this.Lr = y.ca(this.mContext);
        }
        return this.Lr;
    }

    private String oq() {
        if (TextUtils.isEmpty(this.Ls)) {
            this.Ls = y.cf(this.mContext);
        }
        return this.Ls;
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return f.class;
    }

    @Override // com.kwad.sdk.components.f
    public final String om() {
        if (!com.kwad.sdk.core.config.d.AN() && System.currentTimeMillis() < op() && !TextUtils.isEmpty(oo())) {
            return "";
        }
        return oq();
    }

    @Override // com.kwad.sdk.components.f
    public final g on() {
        return new com.kwad.sdk.core.a.a();
    }

    private void X(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            if (au.usePhoneStateDisable()) {
                jSONObject.put("64", 0);
            }
            if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqQ)) {
                jSONObject.put("64_level", 1);
            }
            KWEGIDDFP.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.f.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                c.d("initGId onSuccess", "deviceInfo：" + str2);
                a.this.ol();
                a.this.ai(str2);
            }
        });
    }

    @Override // com.kwad.sdk.components.f
    public final void aj(String str) {
        if (this.mContext != null && !bg.isNullString(str) && !bg.isEquals(oo(), str)) {
            try {
                this.Lq = str;
                y.W(this.mContext, str);
                KWEGIDDFP.instance().setEgid(this.mContext, str);
            } catch (Throwable th) {
                c.e("EncryptComponentsImpl", "setEGid error : " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(String str) {
        if (this.mContext != null && !bg.isNullString(str) && !bg.isEquals(oq(), str)) {
            this.Ls = str;
            y.af(this.mContext, str);
        }
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        try {
            this.mContext = context;
            X(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.f
    public final void w(long j) {
        if (this.mContext != null && j > 0 && j != op()) {
            this.Lr = j;
            y.d(this.mContext, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol() {
        String cc = y.cc(this.mContext);
        String Lu = bi.Lu();
        if (TextUtils.isEmpty(cc)) {
            y.X(this.mContext, Lu);
        } else if (!TextUtils.equals(cc, Lu)) {
            this.Lq = "";
            this.Lr = 0L;
            this.Ls = "";
            y.W(this.mContext, "");
            y.d(this.mContext, this.Lr);
            y.af(this.mContext, this.Ls);
            y.X(this.mContext, Lu);
        }
    }
}
