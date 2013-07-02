package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l {
    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        treeMap.put("default", PreferenceManager.getDefaultSharedPreferences(context));
        String[] b = org.acra.a.d().b();
        if (b != null) {
            for (String str : b) {
                treeMap.put(str, context.getSharedPreferences(str, 0));
            }
        }
        for (String str2 : treeMap.keySet()) {
            sb.append(str2).append("\n");
            SharedPreferences sharedPreferences = (SharedPreferences) treeMap.get(str2);
            if (sharedPreferences != null) {
                Map<String, ?> all = sharedPreferences.getAll();
                if (all != null && all.size() > 0) {
                    for (String str3 : all.keySet()) {
                        if (!a(str3)) {
                            if (all.get(str3) != null) {
                                sb.append(str3).append("=").append(all.get(str3).toString()).append("\n");
                            } else {
                                sb.append(str3).append("=").append("null\n");
                            }
                        }
                    }
                } else {
                    sb.append("empty\n");
                }
            } else {
                sb.append("null\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean a(String str) {
        String[] H = org.acra.a.d().H();
        if (0 < H.length) {
            return str.matches(H[0]);
        }
        return false;
    }
}
