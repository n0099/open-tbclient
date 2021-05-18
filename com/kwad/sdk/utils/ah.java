package com.kwad.sdk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    public static Class f34095a;

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (f34095a == null) {
                f34095a = Class.forName("android.os.SystemProperties");
            }
            Method declaredMethod = f34095a.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
            return null;
        }
    }

    public static String a(String str) {
        Object a2 = a("get", new Class[]{String.class}, new Object[]{str});
        return a2 instanceof String ? (String) a2 : b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                try {
                    str2 = bufferedReader.readLine();
                } catch (IOException e2) {
                    e = e2;
                    com.kwad.sdk.core.d.a.a(e);
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused2) {
            return str2;
        }
    }
}
