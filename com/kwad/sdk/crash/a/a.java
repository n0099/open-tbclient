package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static boolean a(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return a(arrayList);
    }

    public static boolean a(@NonNull List<StackTraceElement[]> list) {
        for (StackTraceElement[] stackTraceElementArr : list) {
            if (a(stackTraceElementArr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] b2 = d.a().b();
        if (b2 == null || b2.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : b2) {
            z = a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : d.a().c()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z;
    }

    public static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.a.a("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.a.a("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }
}
