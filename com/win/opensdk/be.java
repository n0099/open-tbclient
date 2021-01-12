package com.win.opensdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public final class be {
    public static String java;

    public static boolean aaC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https");
    }

    public static String iP(Context context) {
        if (context == null) {
            return null;
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static boolean l(Context context, @NonNull Intent intent) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return !packageManager.queryIntentActivities(intent, 0).isEmpty();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static List<String> n(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        LinkedList linkedList = new LinkedList();
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        } catch (Exception e) {
        }
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return linkedList;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            linkedList.add(resolveInfo.activityInfo.packageName);
        }
        return linkedList;
    }

    private static List<String> iW(Context context) {
        ArrayList arrayList = new ArrayList();
        String m67d = az.m67d(context);
        if (!TextUtils.isEmpty(m67d)) {
            try {
                JSONArray jSONArray = new JSONArray(m67d);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                }
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }

    public static void j(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        uri.getScheme();
        if (bf.ai(uri)) {
            intent.setPackage("com.huawei.appmarket");
        } else if (bf.aj(uri)) {
            intent.setPackage("com.android.vending");
        } else {
            intent = bs.aaM(uri.toString());
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static boolean i(Context context, @NonNull Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(268435456);
            String m = m(context, intent);
            if (m != null) {
                intent.setPackage(m);
            }
            boolean l = l(context, intent);
            if (!l) {
                return l;
            }
            context.startActivity(intent);
            return l;
        } catch (Exception e) {
            return false;
        }
    }

    private static String m(Context context, Intent intent) {
        String str;
        try {
            String packageName = context.getPackageName();
            if (az.b(context) == 1) {
                return packageName;
            }
        } catch (Exception e) {
        }
        List<String> n = n(context, intent);
        if (n.size() == 0) {
            return null;
        }
        if (n.size() == 1) {
            return n.get(0);
        }
        List<String> iW = iW(context);
        if (iW.size() > 0) {
            Iterator<String> it = iW.iterator();
            while (it.hasNext()) {
                str = it.next();
                if (n.contains(str)) {
                    break;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str) && n.size() > 0) {
            return n.get(0);
        }
        return str;
    }
}
