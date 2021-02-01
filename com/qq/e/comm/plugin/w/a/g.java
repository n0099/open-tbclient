package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class g {
    private static void a(Context context, com.qq.e.comm.plugin.s.c cVar) {
        String e = cVar.e();
        if (StringUtil.isEmpty(e)) {
            ai.a("[营销组件-电话组件] 获取display兜底号失败", new Object[0]);
            return;
        }
        ai.a("[营销组件-电话组件] 获取display兜底号成功", new Object[0]);
        a(context, e);
    }

    private static void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(T t, Context context, d.a aVar, d.b bVar, d.e eVar) {
        if (t == null || aVar == null || bVar == null || eVar == null) {
            return false;
        }
        com.qq.e.comm.plugin.s.c l = aVar.c.l();
        if (l == null) {
            return false;
        }
        String a2 = d.a((String) null, aVar.f12641a, bVar.f12644b, bVar.d, bVar.i);
        if (StringUtil.isEmpty(a2)) {
            return false;
        }
        Pair<Integer, JSONObject> a3 = d.a(a2, 4000L, aVar, eVar, bVar);
        if (a3 == null || ((Integer) a3.first).intValue() != 200 || a3.second == null) {
            ai.a("[营销组件-电话组件] 点击CGI请求失败", new Object[0]);
            a(context, l);
        } else {
            String optString = ((JSONObject) a3.second).optString("fmcphone");
            if (StringUtil.isEmpty(optString)) {
                ai.a("[营销组件-电话组件] 点击CGI请求成功，获取中间号失败", new Object[0]);
                a(context, l);
            } else {
                ai.a("[营销组件-电话组件] 获取点击CGI中间号成功", new Object[0]);
                a(context, optString);
            }
        }
        return true;
    }

    public static <T> boolean a(T t, d.a aVar, d.b bVar, d.e eVar) {
        com.qq.e.comm.plugin.s.c l;
        if (t == null || aVar == null || bVar == null || eVar == null || (l = aVar.c.l()) == null || StringUtil.isEmpty(l.c())) {
            return false;
        }
        String a2 = d.a((String) null, aVar.f12641a, bVar.f12644b, bVar.d, bVar.i);
        if (StringUtil.isEmpty(a2)) {
            return false;
        }
        d.a(a2, 4000L, aVar, eVar, bVar);
        return true;
    }

    public static <T> boolean b(T t, Context context, d.a aVar, d.b bVar, d.e eVar) {
        com.qq.e.comm.plugin.s.c l;
        if (t == null || aVar == null || bVar == null || eVar == null || (l = aVar.c.l()) == null) {
            return false;
        }
        String d = l.d();
        if (StringUtil.isEmpty(d)) {
            return false;
        }
        String a2 = d.a((String) null, aVar.f12641a, bVar.f12644b, bVar.d, bVar.i);
        if (StringUtil.isEmpty(a2)) {
            return false;
        }
        a.a(context, d, aVar, eVar);
        d.a(a2, 4000L, aVar, eVar, bVar);
        return true;
    }
}
