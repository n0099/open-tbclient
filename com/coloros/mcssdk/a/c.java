package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class c implements d {
    public static List<Message> a(Context context, Intent intent) {
        int i;
        Message a;
        if (intent == null) {
            return null;
        }
        try {
            i = Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra("type")));
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.b("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        com.coloros.mcssdk.c.d.a("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (d dVar : PushManager.getInstance().getParsers()) {
            if (dVar != null && (a = dVar.a(context, i, intent)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public abstract Message a(Intent intent);
}
