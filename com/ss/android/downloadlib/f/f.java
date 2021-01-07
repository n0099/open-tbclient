package com.ss.android.downloadlib.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
/* loaded from: classes4.dex */
public class f {
    public static com.ss.android.downloadlib.a.b.e h(Context context, Uri uri) {
        if (context == null || uri == null || !"market".equals(uri.getScheme())) {
            return new com.ss.android.downloadlib.a.b.e(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!i.a(context, intent)) {
                return new com.ss.android.downloadlib.a.b.e(6, 13);
            }
            String h = com.ss.android.socialbase.downloader.m.g.h();
            if (i.d(context, h) && !com.ss.android.socialbase.downloader.m.g.e()) {
                intent.setPackage(h);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return new com.ss.android.downloadlib.a.b.e(5);
        } catch (Exception e) {
            return new com.ss.android.downloadlib.a.b.e(6, 14);
        }
    }

    public static com.ss.android.downloadlib.a.b.e bA(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.a.b.e(6, 11);
        }
        if (com.ss.android.socialbase.downloader.m.g.e() && i.d(context, "com.sec.android.app.samsungapps")) {
            return bB(context, str);
        }
        return h(context, Uri.parse("market://details?id=" + str));
    }

    private static com.ss.android.downloadlib.a.b.e bB(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.a.b.e(5);
        } catch (Exception e) {
            return new com.ss.android.downloadlib.a.b.e(6, 14);
        }
    }

    public static com.ss.android.downloadlib.a.b.e bC(Context context, String str) {
        Intent bD = i.bD(context, str);
        if (bD == null) {
            return new com.ss.android.downloadlib.a.b.e(4);
        }
        bD.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            context.startActivity(bD);
            return new com.ss.android.downloadlib.a.b.e(3);
        } catch (Exception e) {
            return new com.ss.android.downloadlib.a.b.e(4);
        }
    }

    public static com.ss.android.downloadlib.a.b.e aaQ(String str) {
        return bC(com.ss.android.downloadlib.a.j.a(), str);
    }

    public static com.ss.android.downloadlib.a.b.e aaR(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.a.b.e(2, 21);
        }
        Context a2 = com.ss.android.downloadlib.a.j.a();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        if (i.j(a2, intent)) {
            if (com.ss.android.downloadlib.a.j.i().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.a.j.eGm() != null && com.ss.android.downloadlib.a.j.eGm().a() && Build.VERSION.SDK_INT < 29) {
                TTDelegateActivity.a(str);
            } else if (com.ss.android.downloadlib.a.j.i().optInt("open_url_mode") == 1 && Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT < 29) {
                TTDelegateActivity.a(str);
            } else {
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                try {
                    com.ss.android.downloadlib.a.j.a().startActivity(intent);
                } catch (Exception e) {
                    return new com.ss.android.downloadlib.a.b.e(2);
                }
            }
            return new com.ss.android.downloadlib.a.b.e(1);
        }
        return new com.ss.android.downloadlib.a.b.e(2);
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
