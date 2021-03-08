package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    public static String f8139a;

    public static boolean i(Context context, Uri uri) {
        try {
            return j(context, uri);
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
        if ((com.win.opensdk.bp.f(r8) == 1) != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e3, blocks: (B:9:0x0025, B:11:0x002b), top: B:65:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean j(Context context, Uri uri) {
        LinkedList linkedList;
        ArrayList<String> arrayList;
        boolean z;
        PackageManager packageManager;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(268435456);
        try {
            r0 = v.b(context);
        } catch (Exception e) {
        }
        if (arrayList.size() > 0) {
            for (String str : arrayList) {
                if (linkedList.contains(str)) {
                    break;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str) && linkedList.size() > 0) {
            str = (String) linkedList.get(0);
        }
        if (str != null) {
            intent.setPackage(str);
        }
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
        }
        if (packageManager != null) {
            z = !packageManager.queryIntentActivities(intent, 0).isEmpty();
            if (z) {
                context.startActivity(intent);
            }
            return z;
        }
        z = false;
        if (z) {
        }
        return z;
        z = false;
        if (z) {
        }
        return z;
        if (linkedList.size() != 0) {
            str = null;
        } else if (linkedList.size() == 1) {
            str = (String) linkedList.get(0);
        } else {
            arrayList = new ArrayList();
            String b = bp.b(context);
            if (!TextUtils.isEmpty(b)) {
                try {
                    JSONArray jSONArray = new JSONArray(b);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.optString(i));
                        }
                    }
                } catch (JSONException e3) {
                }
            }
            if (arrayList.size() > 0) {
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
                str = (String) linkedList.get(0);
            }
        }
        if (str != null) {
        }
        packageManager = context.getPackageManager();
        if (packageManager != null) {
        }
        z = false;
        if (z) {
        }
        return z;
        linkedList = new LinkedList();
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    linkedList.add(resolveInfo.activityInfo.packageName);
                }
            }
        } catch (Exception e4) {
        }
        if (linkedList.size() != 0) {
        }
        if (str != null) {
        }
        packageManager = context.getPackageManager();
        if (packageManager != null) {
        }
        z = false;
        if (z) {
        }
        return z;
    }

    public static void k(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        uri.getScheme();
        if (ck.a(uri)) {
            intent.setPackage("com.huawei.appmarket");
        } else if (ck.b(uri)) {
            intent.setPackage("com.android.vending");
        } else {
            intent = null;
            try {
                intent = Intent.parseUri(uri.toString(), 1);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
