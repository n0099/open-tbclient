package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.bb;
/* loaded from: classes12.dex */
public class PkgDataClearedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_DATA_CLEARED".equals(intent.getAction()) || intent.getData() == null) {
            return;
        }
        String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
        if (TextUtils.isEmpty(encodedSchemeSpecificPart)) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, XMPushService.class);
            intent2.setAction(ax.b);
            intent2.putExtra("data_cleared_pkg_name", encodedSchemeSpecificPart);
            bb.a(context).m559a(intent2);
        } catch (Exception e) {
            b.d("data cleared broadcast error: " + e);
        }
    }
}
