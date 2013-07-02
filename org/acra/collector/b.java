package org.acra.collector;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class b {
    private static SparseArray a = new SparseArray();
    private static SparseArray b = new SparseArray();
    private static SparseArray c = new SparseArray();
    private static SparseArray d = new SparseArray();
    private static SparseArray e = new SparseArray();
    private static SparseArray f = new SparseArray();
    private static SparseArray g = new SparseArray();
    private static SparseArray h = new SparseArray();
    private static SparseArray i = new SparseArray();
    private static final HashMap j = new HashMap();

    static {
        Field[] fields;
        j.put("HARDKEYBOARDHIDDEN_", a);
        j.put("KEYBOARD_", b);
        j.put("KEYBOARDHIDDEN_", c);
        j.put("NAVIGATION_", d);
        j.put("NAVIGATIONHIDDEN_", e);
        j.put("ORIENTATION_", f);
        j.put("SCREENLAYOUT_", g);
        j.put("TOUCHSCREEN_", h);
        j.put("UI_MODE_", i);
        for (Field field : Configuration.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                String name = field.getName();
                try {
                    if (name.startsWith("HARDKEYBOARDHIDDEN_")) {
                        a.put(field.getInt(null), name);
                    } else if (name.startsWith("KEYBOARD_")) {
                        b.put(field.getInt(null), name);
                    } else if (name.startsWith("KEYBOARDHIDDEN_")) {
                        c.put(field.getInt(null), name);
                    } else if (name.startsWith("NAVIGATION_")) {
                        d.put(field.getInt(null), name);
                    } else if (name.startsWith("NAVIGATIONHIDDEN_")) {
                        e.put(field.getInt(null), name);
                    } else if (name.startsWith("ORIENTATION_")) {
                        f.put(field.getInt(null), name);
                    } else if (name.startsWith("SCREENLAYOUT_")) {
                        g.put(field.getInt(null), name);
                    } else if (name.startsWith("TOUCHSCREEN_")) {
                        h.put(field.getInt(null), name);
                    } else if (name.startsWith("UI_MODE_")) {
                        i.put(field.getInt(null), name);
                    }
                } catch (IllegalAccessException e2) {
                    Log.w(org.acra.a.a, "Error while inspecting device configuration: ", e2);
                } catch (IllegalArgumentException e3) {
                    Log.w(org.acra.a.a, "Error while inspecting device configuration: ", e3);
                }
            }
        }
    }

    public static String a(Configuration configuration) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : configuration.getClass().getFields()) {
            try {
                if (!Modifier.isStatic(field.getModifiers())) {
                    sb.append(field.getName()).append('=');
                    if (field.getType().equals(Integer.TYPE)) {
                        sb.append(a(configuration, field));
                    } else if (field.get(configuration) != null) {
                        sb.append(field.get(configuration).toString());
                    }
                    sb.append('\n');
                }
            } catch (IllegalAccessException e2) {
                Log.e(org.acra.a.a, "Error while inspecting device configuration: ", e2);
            } catch (IllegalArgumentException e3) {
                Log.e(org.acra.a.a, "Error while inspecting device configuration: ", e3);
            }
        }
        return sb.toString();
    }

    private static String a(Configuration configuration, Field field) {
        String name = field.getName();
        if (name.equals("mcc") || name.equals("mnc")) {
            return Integer.toString(field.getInt(configuration));
        }
        if (name.equals("uiMode")) {
            return a((SparseArray) j.get("UI_MODE_"), field.getInt(configuration));
        }
        if (name.equals("screenLayout")) {
            return a((SparseArray) j.get("SCREENLAYOUT_"), field.getInt(configuration));
        }
        SparseArray sparseArray = (SparseArray) j.get(name.toUpperCase() + '_');
        if (sparseArray == null) {
            return Integer.toString(field.getInt(configuration));
        }
        String str = (String) sparseArray.get(field.getInt(configuration));
        if (str == null) {
            return Integer.toString(field.getInt(configuration));
        }
        return str;
    }

    private static String a(SparseArray sparseArray, int i2) {
        int i3;
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i5);
                if (((String) sparseArray.get(keyAt)).endsWith("_MASK") && (i3 = i2 & keyAt) > 0) {
                    if (sb.length() > 0) {
                        sb.append('+');
                    }
                    sb.append((String) sparseArray.get(i3));
                }
                i4 = i5 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    public static String a(Context context) {
        try {
            return a(context.getResources().getConfiguration());
        } catch (RuntimeException e2) {
            Log.w(org.acra.a.a, "Couldn't retrieve CrashConfiguration for : " + context.getPackageName(), e2);
            return "Couldn't retrieve crash config";
        }
    }
}
