package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class a {
    public static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] wA = d.wz().wA();
        if (wA == null || wA.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : wA) {
            z = a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : d.wz().wB()) {
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
                com.kwad.sdk.core.e.b.d("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.e.b.d("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean i(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return u(arrayList);
    }

    public static boolean u(@NonNull List<StackTraceElement[]> list) {
        for (StackTraceElement[] stackTraceElementArr : list) {
            if (a(stackTraceElementArr)) {
                return true;
            }
        }
        return false;
    }
}
