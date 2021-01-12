package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ar;
/* loaded from: classes3.dex */
public class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        return c(context).putExtra("recover", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context, c cVar) {
        return c(context).putExtra("gdt_apkdownload_task", cVar.u());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(Intent intent) {
        return intent.getBundleExtra("gdt_apkdownload_task");
    }

    public static void a(Intent intent, boolean z) {
        intent.putExtra("trigger_by_notify_bar", z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context) {
        return c(context).putExtra("repair", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Intent intent) {
        return intent.getBooleanExtra("repair", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, ar.f());
        intent.putExtra("GDT_APPID", GDTADManager.getInstance().getAppStatus().getAPPID());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Intent intent) {
        return intent.getBooleanExtra("recover", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Intent intent) {
        return intent.getBooleanExtra("trigger_by_notify_bar", false);
    }
}
