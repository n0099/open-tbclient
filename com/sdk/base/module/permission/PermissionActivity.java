package com.sdk.base.module.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class PermissionActivity extends Activity {
    private static a a;

    public static void a(a aVar) {
        a = aVar;
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
        if (stringArrayExtra == null) {
            finish();
        } else if (a != null) {
            requestPermissions(stringArrayExtra, 1);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (a != null) {
            a.a(strArr, iArr);
        }
        a = null;
        finish();
    }
}
