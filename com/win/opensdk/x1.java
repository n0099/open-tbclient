package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f42701a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, uri)) == null) {
            try {
                return c(context, uri);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, Uri uri) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, uri) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            uri.getScheme();
            if (A1.a(uri)) {
                str = "com.huawei.appmarket";
            } else if (!A1.b(uri)) {
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
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:3|(3:4|5|(1:7)(1:70))|(7:9|(1:11)|12|13|(2:15|16)|(1:19)|20)|23|24|25|(3:30|(2:33|31)|34)|36|(2:38|(1:40)(6:41|(3:58|59|(3:61|(3:64|65|62)|66))|43|(2:45|(2:46|(2:48|(2:50|51))(1:52)))(0)|53|(1:57)))|(0)|12|13|(0)|(0)|20) */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d3 A[Catch: Exception -> 0x00de, TRY_LEAVE, TryCatch #0 {Exception -> 0x00de, blocks: (B:54:0x00cd, B:56:0x00d3), top: B:67:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, Uri uri) {
        InterceptResult invokeLL;
        PackageManager packageManager;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, uri)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            String str = null;
            boolean z = false;
            try {
                b2 = z.b(context);
            } catch (Exception unused) {
            }
            if (s1.f(context) == 1) {
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
                    String b3 = s1.b(context);
                    if (!TextUtils.isEmpty(b3)) {
                        try {
                            JSONArray jSONArray = new JSONArray(b3);
                            if (jSONArray.length() > 0) {
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    arrayList.add(jSONArray.optString(i2));
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
        return invokeLL.booleanValue;
    }
}
