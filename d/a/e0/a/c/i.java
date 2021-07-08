package d.a.e0.a.c;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42224a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1049525003, "Ld/a/e0/a/c/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1049525003, "Ld/a/e0/a/c/i;");
                return;
            }
        }
        f42224a = d.a.e0.a.b.a.f42209a.get().s();
    }

    public static boolean a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
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
            if (f42224a && !z) {
                Log.e("OpenAppUtil", "openAppByPkgName: " + str + "  failed");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
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
                if (f42224a) {
                    Log.e("OpenAppUtil", "openAppByScheme success, match scheme size: " + queryIntentActivities.size());
                    return true;
                }
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
