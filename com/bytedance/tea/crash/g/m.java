package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class m {
    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    @NonNull
    public static String a(@NonNull Throwable th) {
        String str;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (r(th)) {
                a(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
        } catch (Exception e) {
            str = "";
        } finally {
            printWriter.close();
        }
        return str;
    }

    @Nullable
    public static JSONObject a(String str) {
        Thread key;
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                String name = entry.getKey().getName();
                if (!b(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        z = jSONArray2.length() > 0;
                    } else {
                        z = true;
                    }
                    if (z) {
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean b(String str) {
        Set<String> a2 = e.a();
        if (a2.contains(str)) {
            return true;
        }
        for (String str2 : a2) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable th2) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f7669a;

        a(PrintWriter printWriter) {
            this.f7669a = printWriter;
        }

        Object a() {
            return this.f7669a;
        }

        void a(Object obj) {
            this.f7669a.println(obj);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th != null && printWriter != null) {
            a aVar = new a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.a(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (i2 > 256) {
                        aVar.a("\t... skip " + (stackTrace.length - i2) + " lines");
                        break;
                    }
                    aVar.a("\tat " + stackTraceElement);
                    i2++;
                    i++;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        a(th2, aVar, stackTrace, "Suppressed: ", "\t", newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    a(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int min = Math.min(stackTrace.length, 256);
        int i = min - 1;
        for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i >= 0 && min2 >= 0 && stackTrace[i].equals(stackTraceElementArr[min2]); min2--) {
            i--;
        }
        int i2 = (min - 1) - i;
        aVar.a(str2 + str + th);
        for (int i3 = 0; i3 <= i; i3++) {
            aVar.a(str2 + "\tat " + stackTrace[i3]);
        }
        if (min < stackTrace.length) {
            aVar.a("\t... skip " + (stackTrace.length - min) + " lines");
        }
        if (i2 != 0) {
            aVar.a(str2 + "\t... " + i2 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean r(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
