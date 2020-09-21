package com.yanzhenjie.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
@RequiresApi(api = 23)
/* loaded from: classes8.dex */
public final class PermissionActivity extends Activity {
    private static a ouL;

    /* loaded from: classes8.dex */
    interface a {
        void X(@NonNull String[] strArr);
    }

    public static void a(Context context, String[] strArr, a aVar) {
        ouL = aVar;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("KEY_INPUT_PERMISSIONS", strArr);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        aA(this);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
        if (stringArrayExtra != null && ouL != null) {
            requestPermissions(stringArrayExtra, 1);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (ouL != null) {
            ouL.X(strArr);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ouL = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void aA(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }
}
