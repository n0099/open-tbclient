package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class dv extends dx {
    public dv(Context context, int i) {
        super(context, i);
    }

    private String b() {
        Bundle extras;
        StringBuilder sb = new StringBuilder();
        try {
            Intent registerReceiver = this.f249a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && (extras = registerReceiver.getExtras()) != null) {
                Set<String> keySet = extras.keySet();
                JSONObject jSONObject = new JSONObject();
                if (keySet != null && keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject.put(str, String.valueOf(extras.get(str)));
                            } catch (Exception e) {
                            }
                        }
                    }
                    sb.append(jSONObject);
                }
            }
        } catch (Exception e2) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 20;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hi mo152a() {
        return hi.Battery;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo152a() {
        return b();
    }
}
