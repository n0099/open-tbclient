package d.a.h.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.browser.core.util.BdLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static b f41022b;

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> f41021a = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f41023c = false;

    /* loaded from: classes.dex */
    public static class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            f.d();
            f.f41022b.sendEmptyMessageDelayed(0, 15000L);
        }

        public b(Looper looper) {
            super(looper);
        }
    }

    static {
        b bVar = new b(d.a.h.a.i.b.a("PreferenceQueue").getLooper());
        f41022b = bVar;
        bVar.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void c(String str, String str2, Object obj) {
        if (str == null) {
            return;
        }
        if (!f41021a.containsKey(str)) {
            if (obj == null || str2 == null) {
                return;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, obj);
            f41021a.put(str, concurrentHashMap);
            return;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap2 = f41021a.get(str);
        if (concurrentHashMap2 != null) {
            if (obj != null) {
                concurrentHashMap2.put(str2, obj);
            } else {
                concurrentHashMap2.remove(str2);
            }
        } else if (obj == null || str2 == null) {
        } else {
            ConcurrentHashMap<String, Object> concurrentHashMap3 = new ConcurrentHashMap<>();
            concurrentHashMap3.put(str2, obj);
            f41021a.put(str, concurrentHashMap3);
        }
    }

    public static void d() {
        int i2;
        if (f41023c) {
            return;
        }
        f41023c = true;
        try {
            try {
                Context baseContext = d.a.h.a.b.a().getBaseContext();
                BdLog.a("BdPreferenceQueueWorker", "pending work category: " + f41021a.size());
                for (String str : f41021a.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = f41021a.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                        i2 = 0;
                    } else {
                        SharedPreferences.Editor edit = baseContext.getSharedPreferences(str, 0).edit();
                        i2 = 0;
                        for (String str2 : concurrentHashMap.keySet()) {
                            Object obj = concurrentHashMap.get(str2);
                            if (obj != null) {
                                if (obj instanceof Integer) {
                                    edit.putInt(str2, ((Integer) obj).intValue());
                                } else if (obj instanceof Long) {
                                    edit.putLong(str2, ((Long) obj).longValue());
                                } else if (obj instanceof Float) {
                                    edit.putFloat(str2, ((Float) obj).floatValue());
                                } else if (obj instanceof Boolean) {
                                    edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                                } else if (obj instanceof String) {
                                    edit.putString(str2, (String) obj);
                                } else if (obj instanceof Set) {
                                    edit.putStringSet(str2, (Set) obj);
                                }
                                i2++;
                            }
                        }
                        edit.commit();
                    }
                    concurrentHashMap.clear();
                    if (i2 > 0) {
                        BdLog.a("BdPreferenceQueueWorker", str + ".xml " + i2 + " items have been wroten");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            f41023c = false;
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (str == null || (concurrentHashMap = f41021a.get(str)) == null) {
            return;
        }
        concurrentHashMap.clear();
    }

    public static void f() {
        if (f41022b.hasMessages(0)) {
            return;
        }
        f41022b.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void g() {
        Log.d("BdPreferenceQueueWorker", "wait to finish");
        f41022b.removeMessages(0);
        d();
        f();
    }
}
