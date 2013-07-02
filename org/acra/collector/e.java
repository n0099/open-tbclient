package org.acra.collector;

import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import com.baidu.browser.explorer.BdWebErrorView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e {
    private static final String[] a = {"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};

    public static String a(Context context, String[] strArr) {
        try {
            String b = a.b();
            if (b == null) {
                return "N/A";
            }
            Object systemService = context.getSystemService(b);
            Method method = systemService.getClass().getMethod("getNextEntry", String.class, Long.TYPE);
            if (method == null) {
                return "";
            }
            Time time = new Time();
            time.setToNow();
            time.minute -= org.acra.a.d().g();
            time.normalize(false);
            long millis = time.toMillis(false);
            ArrayList<String> arrayList = new ArrayList();
            if (org.acra.a.d().m()) {
                arrayList.addAll(Arrays.asList(a));
            }
            if (strArr != null && strArr.length > 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            if (arrayList.isEmpty()) {
                return "No tag configured for collection.";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append("Tag: ").append(str).append('\n');
                Object invoke = method.invoke(systemService, str, Long.valueOf(millis));
                if (invoke == null) {
                    sb.append("Nothing.").append('\n');
                } else {
                    Method method2 = invoke.getClass().getMethod("getText", Integer.TYPE);
                    Method method3 = invoke.getClass().getMethod("getTimeMillis", null);
                    Method method4 = invoke.getClass().getMethod("close", null);
                    while (invoke != null) {
                        long longValue = ((Long) method3.invoke(invoke, null)).longValue();
                        time.set(longValue);
                        sb.append("@").append(time.format2445()).append('\n');
                        String str2 = (String) method2.invoke(invoke, Integer.valueOf((int) BdWebErrorView.ERROR_CODE_500));
                        if (str2 != null) {
                            sb.append("Text: ").append(str2).append('\n');
                        } else {
                            sb.append("Not Text!").append('\n');
                        }
                        method4.invoke(invoke, null);
                        invoke = method.invoke(systemService, str, Long.valueOf(longValue));
                    }
                }
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        } catch (IllegalArgumentException e2) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        } catch (NoSuchFieldException e3) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        } catch (NoSuchMethodException e4) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        } catch (SecurityException e5) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        } catch (InvocationTargetException e6) {
            Log.i(org.acra.a.a, "DropBoxManager not available.");
            return "N/A";
        }
    }
}
