package org.acra.collector;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {
    public static String a(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : Settings.System.class.getFields()) {
            if (!field.isAnnotationPresent(Deprecated.class) && field.getType() == String.class) {
                try {
                    String string = Settings.System.getString(context.getContentResolver(), (String) field.get(null));
                    if (string != null) {
                        sb.append(field.getName()).append("=").append((Object) string).append("\n");
                    }
                } catch (IllegalAccessException e) {
                    Log.w(org.acra.a.a, "Error : ", e);
                } catch (IllegalArgumentException e2) {
                    Log.w(org.acra.a.a, "Error : ", e2);
                }
            }
        }
        return sb.toString();
    }

    public static String b(Context context) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : Settings.Secure.class.getFields()) {
            if (!field.isAnnotationPresent(Deprecated.class) && field.getType() == String.class && a(field)) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), (String) field.get(null));
                    if (string != null) {
                        sb.append(field.getName()).append("=").append((Object) string).append("\n");
                    }
                } catch (IllegalAccessException e) {
                    Log.w(org.acra.a.a, "Error : ", e);
                } catch (IllegalArgumentException e2) {
                    Log.w(org.acra.a.a, "Error : ", e2);
                }
            }
        }
        return sb.toString();
    }

    private static boolean a(Field field) {
        return (field == null || field.getName().startsWith("WIFI_AP")) ? false : true;
    }
}
