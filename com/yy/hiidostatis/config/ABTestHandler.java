package com.yy.hiidostatis.config;

import android.content.Context;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import com.yy.hiidostatis.inner.util.ThreadPool;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ABTestHandler {
    public static final int FALSE = 1;
    public static final String KEY_PREFERENCE_ABTEST = "ab_test_config";
    public static final int TRUE = 2;
    public static ABTestHandler instance = new ABTestHandler();
    public static boolean loaded = false;
    public volatile Map<String, Integer> map = new HashMap();

    public static ABTestHandler getInstance() {
        return instance;
    }

    public static void updateValue(final Context context, final Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.config.ABTestHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ABTestHandler.updateValueInner(context, map);
                }
            });
        }
    }

    public static boolean getAbBoolean(ABNameDefine aBNameDefine) {
        Integer num = getInstance().map.get(aBNameDefine.getName());
        if (num == null) {
            if (aBNameDefine.getDefaultValue() == 2) {
                return true;
            }
        } else if (num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static int getAbInteger(ABNameDefine aBNameDefine) {
        Integer num = getInstance().map.get(aBNameDefine.getName());
        if (num == null) {
            return aBNameDefine.getDefaultValue();
        }
        return num.intValue();
    }

    public static void initInstance(Context context) {
        instance.loadConfig(context);
    }

    public static String parseTest(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("val");
            if (jSONObject2 == null) {
                return null;
            }
            return jSONObject2.getString("action");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private synchronized void loadConfig(Context context) {
        if (loaded) {
            return;
        }
        String string = context.getSharedPreferences(KEY_PREFERENCE_ABTEST, 4).getString(KEY_PREFERENCE_ABTEST, null);
        if (string != null) {
            for (String str : string.split(ParamableElem.DIVIDE_PARAM)) {
                try {
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        this.map.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        loaded = true;
    }

    public static void updateMemoryValue(Context context, Map<String, String> map) {
        if (!loaded) {
            getInstance().loadConfig(context);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            getInstance().map.put(entry.getKey(), Integer.valueOf(Integer.parseInt(entry.getValue())));
        }
    }

    public static void updateValue(final Context context, final String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.config.ABTestHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    String parseTest;
                    HashMap hashMap = new HashMap();
                    for (String str : strArr) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (next.startsWith("hiido_") && (parseTest = ABTestHandler.parseTest(jSONObject.getJSONObject(next))) != null && !parseTest.isEmpty()) {
                                    hashMap.put(next, parseTest);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        ABTestHandler.updateValueInner(context, hashMap);
                    }
                }
            });
        }
    }

    public static void updateValueInner(Context context, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().startsWith("hiido_")) {
                        String[] split = entry.getKey().split("_");
                        sb.append(split[split.length - 1]);
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
                sb.setLength(sb.length() - 1);
                context.getSharedPreferences(KEY_PREFERENCE_ABTEST, 4).edit().putString(KEY_PREFERENCE_ABTEST, sb.toString()).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
