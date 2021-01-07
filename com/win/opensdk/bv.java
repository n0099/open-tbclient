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
/* loaded from: classes4.dex */
public final class bv {
    public static boolean a(Context context, Info info) {
        PackageInfo bN;
        try {
            String bO = bO(context, info.getOpen());
            File file = new File(bO);
            if (file.exists() && (bN = bN(context, bO)) != null) {
                if (bN.versionCode == info.getDl_vsc()) {
                    return true;
                }
                if (info.getDl_vsc() == 0 && info.getDl_pkg().equals(bN.packageName)) {
                    return true;
                }
                w.iM(context).a(new x(info), bN.packageName, bN.versionCode, 1).eKp();
                file.delete();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static PackageInfo bN(Context context, String str) {
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
                    w.iM(context).c(new x(info), str).eKp();
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
                    hy("777", iR(context) + "/win/");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            hy("777", str);
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
                w.iM(context).h(new x(info), str).eKp();
            }
        }
        return intent;
    }

    private static void hy(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean bK(Context context, String str) {
        try {
            return new File(new StringBuilder().append(iR(context)).append(File.separator).append("win").append(File.separator).append(abO(str)).toString()).exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String bO(Context context, String str) {
        try {
            return iR(context) + File.separator + "win" + File.separator + abO(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String abO(String str) {
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

    public static String iR(Context context) {
        if (iL(context)) {
            return context.getExternalCacheDir().getPath();
        }
        return context.getCacheDir().getPath();
    }

    private static boolean iL(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
