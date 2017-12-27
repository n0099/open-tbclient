package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class c implements d {
    public static List<com.coloros.mcssdk.e.c> j(Context context, Intent intent) {
        int i;
        com.coloros.mcssdk.e.c a;
        if (intent == null) {
            return null;
        }
        try {
            i = Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("type")));
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.b("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        com.coloros.mcssdk.c.c.a("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (d dVar : com.coloros.mcssdk.a.bPw().bPu()) {
            if (dVar != null && (a = dVar.a(context, i, intent)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
}
