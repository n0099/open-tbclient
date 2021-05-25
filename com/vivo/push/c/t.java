package com.vivo.push.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.tencent.connect.common.Constants;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class t extends ab {
    public t(com.vivo.push.y yVar) {
        super(yVar);
    }

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

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.r rVar = (com.vivo.push.b.r) yVar;
        InsideNotificationItem f2 = rVar.f();
        if (f2 == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a2 = com.vivo.push.util.q.a(f2);
        boolean equals = this.f36752a.getPackageName().equals(rVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f36752a);
        }
        if (equals) {
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(rVar.e()));
            hashMap.put(Constants.PARAM_PLATFORM, this.f36752a.getPackageName());
            Context context = this.f36752a;
            String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a2.getSkipType() + "]");
            int skipType = a2.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new y(this, this.f36752a, a2.getParams())).start();
                com.vivo.push.w.b(new u(this, a2));
                return;
            } else if (skipType == 2) {
                String skipContent = a2.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    b(intent, a2.getParams());
                    try {
                        this.f36752a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : " + parse);
                    }
                } else {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                }
                com.vivo.push.w.b(new v(this, a2));
                return;
            } else if (skipType == 3) {
                com.vivo.push.w.b(new w(this, a2));
                return;
            } else if (skipType != 4) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a2.getSkipType());
                return;
            } else {
                String skipContent2 = a2.getSkipContent();
                try {
                    parseUri = Intent.parseUri(skipContent2, 1);
                    str = parseUri.getPackage();
                } catch (Exception e2) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : " + skipContent2, e2);
                }
                if (!TextUtils.isEmpty(str) && !this.f36752a.getPackageName().equals(str)) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.f36752a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.f36752a.getPackageName().equals(packageName)) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.f36752a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                parseUri.setPackage(this.f36752a.getPackageName());
                parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                b(parseUri, a2.getParams());
                this.f36752a.startActivity(parseUri);
                com.vivo.push.w.b(new x(this, a2));
                return;
            }
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a2 + " ; isMatch is " + equals);
    }
}
