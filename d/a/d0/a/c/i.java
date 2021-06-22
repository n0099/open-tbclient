package d.a.d0.a.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import java.util.List;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43389a = d.a.d0.a.b.a.f43374a.get().s();

    public static boolean a(@NonNull Context context, @NonNull String str) {
        ResolveInfo next;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            try {
                context.startActivity(intent2);
                z = true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        if (f43389a && !z) {
            Log.e("OpenAppUtil", "openAppByPkgName: " + str + "  failed");
        }
        return z;
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        intent.setPackage(queryIntentActivities.get(0).activityInfo.packageName);
        try {
            context.startActivity(intent);
            if (f43389a) {
                Log.e("OpenAppUtil", "openAppByScheme success, match scheme size: " + queryIntentActivities.size());
                return true;
            }
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
