package com.vivo.push.c;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
final class t extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        Intent parseUri;
        String str;
        boolean z = true;
        com.vivo.push.b.r rVar = (com.vivo.push.b.r) yVar;
        InsideNotificationItem f = rVar.f();
        if (f == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a2 = com.vivo.push.util.q.a(f);
        boolean equals = this.f4714a.getPackageName().equals(rVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f4714a);
        }
        if (equals) {
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put(Message.MESSAGE_ID, String.valueOf(rVar.e()));
            hashMap.put("platform", this.f4714a.getPackageName());
            String b = com.vivo.push.util.z.b(this.f4714a, this.f4714a.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a2.getSkipType() + "]");
            switch (a2.getSkipType()) {
                case 1:
                    new Thread(new y(this, this.f4714a, a2.getParams())).start();
                    com.vivo.push.w.b(new u(this, a2));
                    return;
                case 2:
                    String skipContent = a2.getSkipContent();
                    if (!skipContent.startsWith("http://") && !skipContent.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                        z = false;
                    }
                    if (z) {
                        Uri parse = Uri.parse(skipContent);
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.setFlags(268435456);
                        b(intent, a2.getParams());
                        try {
                            this.f4714a.startActivity(intent);
                        } catch (Exception e) {
                            com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : " + parse);
                        }
                    } else {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                    }
                    com.vivo.push.w.b(new v(this, a2));
                    return;
                case 3:
                    com.vivo.push.w.b(new w(this, a2));
                    return;
                case 4:
                    String skipContent2 = a2.getSkipContent();
                    try {
                        parseUri = Intent.parseUri(skipContent2, 1);
                        str = parseUri.getPackage();
                    } catch (Exception e2) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : " + skipContent2, e2);
                    }
                    if (!TextUtils.isEmpty(str) && !this.f4714a.getPackageName().equals(str)) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f4714a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !this.f4714a.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f4714a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                        return;
                    }
                    parseUri.setPackage(this.f4714a.getPackageName());
                    parseUri.addFlags(268435456);
                    b(parseUri, a2.getParams());
                    this.f4714a.startActivity(parseUri);
                    com.vivo.push.w.b(new x(this, a2));
                    return;
                default:
                    com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a2.getSkipType());
                    return;
            }
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a2 + " ; isMatch is " + equals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }
}
