package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r2 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (android.text.TextUtils.equals(r7.getStringExtra("openIdPackage"), r6.getPackageName()) != false) goto L8;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        e.a("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
                z = false;
            }
        }
        if (z) {
            a ZY = e.eDp().ZY(intent.getStringExtra("openIdType"));
            if (ZY != null) {
                ZY.b();
            }
        }
    }
}
