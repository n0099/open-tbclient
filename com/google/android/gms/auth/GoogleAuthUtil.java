package com.google.android.gms.auth;

import android.content.ComponentName;
import android.content.Intent;
/* loaded from: classes.dex */
public final class GoogleAuthUtil {
    private static final ComponentName a = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName b = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
    private static final Intent c = new Intent().setComponent(a);
    private static final Intent d = new Intent().setComponent(b);

    private GoogleAuthUtil() {
    }
}
