package com.yanzhenjie.permission.a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes18.dex */
public final class b implements a {
    @Override // com.yanzhenjie.permission.a.a
    public boolean e(@NonNull Context context, @NonNull String... strArr) {
        return e(context, Arrays.asList(strArr));
    }

    public boolean e(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : list) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (TextUtils.isEmpty(permissionToOp)) {
                return true;
            }
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(permissionToOp, context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }
}
