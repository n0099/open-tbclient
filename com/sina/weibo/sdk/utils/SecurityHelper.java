package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes6.dex */
public class SecurityHelper {
    public static boolean checkResponseAppLegal(Context context, WbAppInfo wbAppInfo, Intent intent) {
        if ((wbAppInfo == null || wbAppInfo.getSupportVersion() > 10352) && wbAppInfo != null) {
            String stringExtra = intent != null ? intent.getStringExtra(WBConstants.Base.APP_PKG) : null;
            return (stringExtra == null || intent.getStringExtra(WBConstants.TRAN) == null || !ApiUtils.validateWeiboSign(context, stringExtra)) ? false : true;
        }
        return true;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr != null && str != null) {
            for (Signature signature : signatureArr) {
                if (str.equals(MD5.hexdigest(signature.toByteArray()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, WBConstants.WEIBO_SIGN);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
