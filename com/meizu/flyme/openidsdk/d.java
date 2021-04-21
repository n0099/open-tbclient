package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.k.b.a.a;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r0 == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L15;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        d.k.b.a.d.e("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
            }
        }
        if (z) {
            a g2 = d.k.b.a.d.b().g(intent.getStringExtra("openIdType"));
            if (g2 == null) {
                return;
            }
            g2.e();
        }
    }
}
