package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.b.e;
import com.ss.android.socialbase.downloader.downloader.b;
/* loaded from: classes4.dex */
public class a extends Fragment {
    public void a() {
        try {
            startActivityForResult(eGK(), 1000);
        } catch (Throwable th) {
            try {
                startActivityForResult(b(), 1000);
            } catch (Throwable th2) {
                try {
                    startActivityForResult(c(), 1000);
                } catch (Throwable th3) {
                    startActivityForResult(d(), 1000);
                }
            }
        }
    }

    public Intent b() {
        Context e = e();
        if (e == null) {
            return null;
        }
        String packageName = e.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(e.c)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            } else if (lowerCase.contains(RomUtils.MANUFACTURER_VIVO)) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                    return intent2;
                }
                intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                return intent2;
            } else if (lowerCase.contains(RomUtils.MANUFACTURER_MEIZU) && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e.getPackageName()));
    }

    private Context e() {
        Context eHp = b.eHp();
        if (eHp == null && getActivity() != null && !getActivity().isFinishing()) {
            return getActivity().getApplicationContext();
        }
        return eHp;
    }

    public Intent c() {
        Context e = e();
        if (e == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e.getPackageName()));
    }

    private Intent eGK() {
        Context e = e();
        if (e == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = e.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = e.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (d.a()) {
            d.a(true);
        } else {
            d.a(false);
        }
    }
}
