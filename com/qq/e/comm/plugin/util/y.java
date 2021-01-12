package com.qq.e.comm.plugin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f12599a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f12600b = null;

    public static String a() {
        String str;
        try {
            Context appContext = GDTADManager.getInstance().getAppContext();
            String string = GDTADManager.getInstance().getSM().getString("markets");
            if (StringUtil.isEmpty(string)) {
                str = "";
            } else if (f12600b != null && f12600b.equals(string)) {
                GDTLogger.d("Cache hit");
                str = f12599a;
            } else if (appContext == null || StringUtil.isEmpty(string)) {
                str = "";
            } else {
                str = a(appContext, a(string.split(",")));
                f12599a = str;
                f12600b = string;
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String a(Context context, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (com.qq.e.comm.plugin.a.e.a.a(context, entry.getValue())) {
                sb.append(",").append(entry.getKey());
            }
        }
        return sb.length() > 1 ? sb.substring(1) : "";
    }

    @SuppressLint({"UseSparseArrays"})
    private static Map<Integer, String> a(String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            if (!StringUtil.isEmpty(str)) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(Integer.valueOf(Integer.parseInt(split[0])), split[1]);
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return hashMap;
    }
}
