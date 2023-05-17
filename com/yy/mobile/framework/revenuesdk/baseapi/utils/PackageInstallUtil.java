package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\u0005J!\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/PackageInstallUtil;", "Landroid/content/Context;", "context", "", "isInstallAlipay", "(Landroid/content/Context;)Z", "isInstallQQ", "isInstallQQLite", "isInstallQZone", "isInstallWechat", "", "packageName", "isInstalled", "(Landroid/content/Context;Ljava/lang/String;)Z", "<init>", "()V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class PackageInstallUtil {
    public static final PackageInstallUtil INSTANCE = new PackageInstallUtil();

    @JvmStatic
    public static final boolean isInstallAlipay(Context context) {
        return isInstalled(context, "com.eg.android.AlipayGphone");
    }

    @JvmStatic
    public static final boolean isInstallQQ(Context context) {
        return isInstalled(context, "com.tencent.mobileqq");
    }

    @JvmStatic
    public static final boolean isInstallQQLite(Context context) {
        return isInstalled(context, Constants.PACKAGE_QQ_SPEED);
    }

    @JvmStatic
    public static final boolean isInstallQZone(Context context) {
        return isInstalled(context, Constants.PACKAGE_QZONE);
    }

    @JvmStatic
    public static final boolean isInstallWechat(Context context) {
        return isInstalled(context, "com.tencent.mm");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isInstalled(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = packageManager.getPackageInfo(str, 256);
                    if (packageInfo != null) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                RLog.error("PackageInstallUtil", "pkg: " + str + ", get packageInfo is null, e=" + e, new Object[0]);
                return false;
            }
        }
        packageInfo = null;
        if (packageInfo != null) {
        }
    }
}
