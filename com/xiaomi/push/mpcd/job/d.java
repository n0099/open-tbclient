package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends g {
    public d(Context context, int i) {
        super(context, i);
    }

    private String f() {
        Bundle extras;
        StringBuilder sb = new StringBuilder();
        try {
            Intent registerReceiver = this.d.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 20;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        return f();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.Battery;
    }
}
