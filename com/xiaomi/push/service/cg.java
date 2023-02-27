package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.push.hr;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.XMPushService;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class cg implements XMPushService.n {
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f971a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a  reason: collision with other field name */
    public static final Map<Integer, Map<String, List<String>>> f970a = new HashMap();

    public cg(Context context) {
        a = context;
    }

    public static ig a(String str, String str2, String str3, String str4) {
        ig igVar = new ig();
        if (str3 != null) {
            igVar.c(str3);
        }
        if (str != null) {
            igVar.b(str);
        }
        if (str2 != null) {
            igVar.a(str2);
        }
        if (str4 != null) {
            igVar.d(str4);
        }
        igVar.a(false);
        return igVar;
    }

    public static void a(Context context, ig igVar) {
        if (f971a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + igVar);
        }
        com.xiaomi.push.aj.a(context).a(new ch(igVar));
    }

    public static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f970a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!com.xiaomi.push.t.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    ig a2 = a(null, bd.a(), hr.NotificationRemoved.f508a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(a, a2);
                }
                f970a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo464a() {
        if (f970a.size() > 0) {
            synchronized (f970a) {
                b();
            }
        }
    }
}
