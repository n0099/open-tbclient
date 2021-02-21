package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.baidu.fsg.base.router.RouterCallback;
import com.win.opensdk.core.Info;
import java.io.File;
/* loaded from: classes3.dex */
public final class bv {
    public static boolean a(Context context, Info info) {
        PackageInfo bL;
        try {
            String bM = bM(context, info.getOpen());
            File file = new File(bM);
            if (file.exists() && (bL = bL(context, bM)) != null) {
                if (bL.versionCode == info.getDl_vsc()) {
                    return true;
                }
                if (info.getDl_vsc() == 0 && info.getDl_pkg().equals(bL.packageName)) {
                    return true;
                }
                w.iN(context).a(new x(info), bL.packageName, bL.versionCode, 1).eIX();
                file.delete();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static PackageInfo bL(Context context, String str) {
        PackageInfo packageArchiveInfo;
        try {
            packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (packageArchiveInfo != null) {
            return packageArchiveInfo;
        }
        return null;
    }

    public static void a(Info info, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent b2 = b(info, context, str);
                if (b2.getFlags() > 0) {
                    w.iN(context).c(new x(info), str).eIX();
                    context.startActivity(b2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Intent b(Info info, Context context, String str) {
        Uri fromFile;
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            try {
                if (Build.VERSION.SDK_INT == 23) {
                    hG("777", iS(context) + "/win/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            hG("777", str);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setAction("android.intent.action.INSTALL_PACKAGE");
                intent.setFlags(RouterCallback.CODE_ERROR);
                fromFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileProvider", new File(str));
            } else {
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                fromFile = Uri.fromFile(new File(str));
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        } catch (Exception e2) {
            new StringBuilder("错误:").append(e2.getMessage());
            e2.printStackTrace();
            if (info != null) {
                w.iN(context).h(new x(info), str).eIX();
            }
        }
        return intent;
    }

    private static void hG(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean bI(Context context, String str) {
        try {
            return new File(new StringBuilder().append(iS(context)).append(File.separator).append("win").append(File.separator).append(abU(str)).toString()).exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String bM(Context context, String str) {
        try {
            return iS(context) + File.separator + "win" + File.separator + abU(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String abU(String str) {
        String str2;
        String[] split;
        try {
            str2 = str.length() > 250 ? str.substring(0, 250) : str;
            try {
                if (str2.contains("/") && (split = str2.split("/")) != null && split.length > 0) {
                    return split[split.length - 1];
                }
                return str2;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = str;
        }
    }

    public static String iS(Context context) {
        if (iM(context)) {
            return context.getExternalCacheDir().getPath();
        }
        return context.getCacheDir().getPath();
    }

    private static boolean iM(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
