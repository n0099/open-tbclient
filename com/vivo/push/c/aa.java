package com.vivo.push.c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.sdk.PushMessageCallback;
import java.security.PublicKey;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public abstract class aa extends com.vivo.push.s {
    protected static final Handler b = new Handler(Looper.getMainLooper());
    protected PushMessageCallback c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(com.vivo.push.v vVar) {
        super(vVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.c = pushMessageCallback;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        boolean z = true;
        if (!com.vivo.push.m.a().d()) {
            com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        } else if (publicKey == null) {
            com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.m.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                com.vivo.push.util.m.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.q.a(str.getBytes(HTTP.UTF_8), publicKey, Base64.decode(str2, 0))) {
                    com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify id is success");
                } else {
                    com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify fail srcDigest is " + str);
                    com.vivo.push.util.m.c(this.a, "vertify fail srcDigest is " + str);
                    z = false;
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        } else {
            com.vivo.push.util.m.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
    }
}
