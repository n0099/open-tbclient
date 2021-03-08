package com.sdk.base.module.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes4.dex */
public class PermissionActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static a f7658a;

    public static void a(a aVar) {
        f7658a = aVar;
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
        if (stringArrayExtra == null) {
            finish();
        } else if (f7658a != null) {
            requestPermissions(stringArrayExtra, 1);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (f7658a != null) {
            f7658a.a(strArr, iArr);
        }
        f7658a = null;
        finish();
    }
}
