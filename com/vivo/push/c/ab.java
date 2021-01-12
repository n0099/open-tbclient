package com.vivo.push.c;

import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.sdk.PushMessageCallback;
import java.security.PublicKey;
/* loaded from: classes3.dex */
public abstract class ab extends com.vivo.push.v {

    /* renamed from: b  reason: collision with root package name */
    protected PushMessageCallback f13602b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(com.vivo.push.y yVar) {
        super(yVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.f13602b = pushMessageCallback;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        boolean z = true;
        if (!com.vivo.push.p.a().d()) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        } else if (publicKey == null) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.t.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                } else {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is " + str);
                    com.vivo.push.util.p.c(this.f13709a, "vertify fail srcDigest is " + str);
                    z = false;
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        } else {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
    }
}
