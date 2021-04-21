package d.b.j0.z;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class d {
    @Nullable
    public static Intent a(Context context, String str, String str2, boolean z, c cVar) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        int i = 0;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        while (true) {
            if (i >= queryIntentActivities.size()) {
                break;
            }
            String str3 = queryIntentActivities.get(i).activityInfo.packageName;
            if (TextUtils.equals(str3, str2)) {
                intent.setPackage(str3);
                break;
            }
            i++;
        }
        if (z && !TextUtils.isEmpty(str2) && TextUtils.isEmpty(intent.getPackage())) {
            if (cVar != null) {
                cVar.onFailed(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
                return null;
            }
            return null;
        }
        return intent;
    }

    public static Intent b(@NonNull Context context, String str, String str2, boolean z, @Nullable c cVar) {
        if (!d(str) && !e(str)) {
            return a(context, str, str2, z, cVar);
        }
        return c(context, str, str2, cVar);
    }

    @Nullable
    public static Intent c(Context context, String str, String str2, c cVar) {
        List<ResolveInfo> queryIntentActivities;
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (parseUri == null) {
                if (cVar != null) {
                    cVar.onFailed(-103);
                }
                return null;
            }
            String str3 = parseUri.getPackage();
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                Set<String> categories = parseUri.getCategories();
                if (categories == null || categories.isEmpty()) {
                    parseUri.addCategory("android.intent.category.LAUNCHER");
                }
                if (parseUri.getComponent() == null && (queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 0)) != null && queryIntentActivities.size() > 0) {
                    parseUri.setComponent(new ComponentName(str3, queryIntentActivities.iterator().next().activityInfo.name));
                }
                return parseUri;
            }
            return context.getPackageManager().getLaunchIntentForPackage(str2);
        } catch (URISyntaxException unused) {
            Intent launchIntentForPackage = TextUtils.isEmpty(str2) ? null : context.getPackageManager().getLaunchIntentForPackage(str2);
            if (launchIntentForPackage == null && cVar != null) {
                cVar.onFailed(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
            }
            return launchIntentForPackage;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android-app:");
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("intent:") || str.startsWith("#Intent;");
    }
}
