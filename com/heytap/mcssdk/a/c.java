package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public abstract class c implements d {
    public static List<Message> a(Context context, Intent intent) {
        int i;
        Message a2;
        if (intent == null) {
            return null;
        }
        try {
            i = Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("type")));
        } catch (Exception e) {
            LogUtil.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        LogUtil.d("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (d dVar : PushManager.getInstance().getParsers()) {
            if (dVar != null && (a2 = dVar.a(context, i, intent)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public abstract Message a(Intent intent);
}
