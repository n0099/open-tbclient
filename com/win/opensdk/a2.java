package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class a2 {

    /* renamed from: a  reason: collision with root package name */
    public static String f40250a;

    public static boolean a(Context context, Uri uri) {
        try {
            return c(context, uri);
        } catch (Exception unused) {
            return false;
        }
    }

    public static void b(Context context, Uri uri) {
        String str;
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        uri.getScheme();
        if (d2.a(uri)) {
            str = "com.huawei.appmarket";
        } else if (!d2.b(uri)) {
            intent = null;
            try {
                intent = Intent.parseUri(uri.toString(), 1);
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
        } else {
            str = "com.android.vending";
        }
        intent.setPackage(str);
        context.startActivity(intent);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(3:2|3|(1:5)(1:68))|(7:7|(1:9)|10|11|(2:13|14)|(1:17)|18)|21|22|23|(3:28|(2:31|29)|32)|34|(2:36|(1:38)(6:39|(3:56|57|(3:59|(3:62|63|60)|64))|41|(2:43|(2:44|(2:46|(2:48|49))(1:50)))(0)|51|(1:55)))|(0)|10|11|(0)|(0)|18) */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf A[Catch: Exception -> 0x00da, TRY_LEAVE, TryCatch #1 {Exception -> 0x00da, blocks: (B:52:0x00c9, B:54:0x00cf), top: B:63:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, Uri uri) {
        PackageManager packageManager;
        String b2;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        String str = null;
        boolean z = false;
        try {
            b2 = G.b(context);
        } catch (Exception unused) {
        }
        if (V1.f(context) == 1) {
            str = b2;
            if (str != null) {
                intent.setPackage(str);
            }
            packageManager = context.getPackageManager();
            if (packageManager != null) {
                z = !packageManager.queryIntentActivities(intent, 0).isEmpty();
            }
            if (z) {
                context.startActivity(intent);
            }
            return z;
        }
        LinkedList linkedList = new LinkedList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                linkedList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (linkedList.size() != 0) {
            if (linkedList.size() == 1) {
                str = (String) linkedList.get(0);
            } else {
                ArrayList arrayList = new ArrayList();
                String b3 = V1.b(context);
                if (!TextUtils.isEmpty(b3)) {
                    try {
                        JSONArray jSONArray = new JSONArray(b3);
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                arrayList.add(jSONArray.optString(i));
                            }
                        }
                    } catch (JSONException unused2) {
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (linkedList.contains(str2)) {
                            str = str2;
                            break;
                        }
                    }
                }
                if (TextUtils.isEmpty(str) && linkedList.size() > 0) {
                    str = (String) linkedList.get(0);
                }
            }
        }
        if (str != null) {
        }
        packageManager = context.getPackageManager();
        if (packageManager != null) {
        }
        if (z) {
        }
        return z;
    }
}
