package org.acra.collector;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public static int a() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (IllegalAccessException e) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (IllegalArgumentException e2) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NoSuchFieldException e3) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (SecurityException e4) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    public static String b() {
        Field field = Context.class.getField("DROPBOX_SERVICE");
        if (field != null) {
            return (String) field.get(null);
        }
        return null;
    }
}
