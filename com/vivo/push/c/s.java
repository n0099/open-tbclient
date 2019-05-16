package com.vivo.push.c;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class s extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Intent parseUri;
        String str;
        boolean z = true;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        UPSNotificationMessage a = com.vivo.push.util.n.a(pVar.f());
        boolean equals = this.a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.e()));
            hashMap.put("platform", this.a.getPackageName());
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.m.d("OnNotificationArrivedTask", "notification is clicked by skip type[" + a.getSkipType() + "]");
            switch (a.getSkipType()) {
                case 1:
                    new Thread(new x(this, this.a)).start();
                    b.post(new t(this, a));
                    return;
                case 2:
                    String skipContent = a.getSkipContent();
                    if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                        z = false;
                    }
                    if (z) {
                        Uri parse = Uri.parse(skipContent);
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.setFlags(268435456);
                        try {
                            this.a.startActivity(intent);
                        } catch (Exception e) {
                            com.vivo.push.util.m.a("OnNotificationArrivedTask", "startActivity error : " + parse);
                        }
                    } else {
                        com.vivo.push.util.m.a("OnNotificationArrivedTask", "url not legal");
                    }
                    b.post(new u(this, a));
                    return;
                case 3:
                    b.post(new v(this, a));
                    return;
                case 4:
                    String skipContent2 = a.getSkipContent();
                    try {
                        parseUri = Intent.parseUri(skipContent2, 1);
                        str = parseUri.getPackage();
                    } catch (Exception e2) {
                        com.vivo.push.util.m.a("OnNotificationArrivedTask", "open activity error : " + skipContent2, e2);
                    }
                    if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                        com.vivo.push.util.m.a("OnNotificationArrivedTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                        com.vivo.push.util.m.a("OnNotificationArrivedTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    parseUri.setPackage(this.a.getPackageName());
                    parseUri.addFlags(268435456);
                    this.a.startActivity(parseUri);
                    b.post(new w(this, a));
                    return;
                default:
                    com.vivo.push.util.m.a("OnNotificationArrivedTask", "illegitmacy skip type error : " + a.getSkipType());
                    return;
            }
        }
        com.vivo.push.util.m.a("OnNotificationArrivedTask", "notify is " + a + " ; isMatch is " + equals);
    }
}
