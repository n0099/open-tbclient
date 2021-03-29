package d.b.h.a;

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
    public static b f49446b;

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> f49445a = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f49447c = false;

    /* loaded from: classes.dex */
    public static class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            f.d();
            f.f49446b.sendEmptyMessageDelayed(0, 15000L);
        }

        public b(Looper looper) {
            super(looper);
        }
    }

    static {
        b bVar = new b(d.b.h.a.i.b.a("PreferenceQueue").getLooper());
        f49446b = bVar;
        bVar.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void c(String str, String str2, Object obj) {
        if (str == null) {
            return;
        }
        if (!f49445a.containsKey(str)) {
            if (obj == null || str2 == null) {
                return;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, obj);
            f49445a.put(str, concurrentHashMap);
            return;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap2 = f49445a.get(str);
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
            f49445a.put(str, concurrentHashMap3);
        }
    }

    public static void d() {
        int i;
        if (f49447c) {
            return;
        }
        f49447c = true;
        try {
            try {
                Context baseContext = d.b.h.a.b.a().getBaseContext();
                BdLog.a("BdPreferenceQueueWorker", "pending work category: " + f49445a.size());
                for (String str : f49445a.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = f49445a.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                        i = 0;
                    } else {
                        SharedPreferences.Editor edit = baseContext.getSharedPreferences(str, 0).edit();
                        i = 0;
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
                                i++;
                            }
                        }
                        edit.commit();
                    }
                    concurrentHashMap.clear();
                    if (i > 0) {
                        BdLog.a("BdPreferenceQueueWorker", str + ".xml " + i + " items have been wroten");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            f49447c = false;
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (str == null || (concurrentHashMap = f49445a.get(str)) == null) {
            return;
        }
        concurrentHashMap.clear();
    }

    public static void f() {
        if (f49446b.hasMessages(0)) {
            return;
        }
        f49446b.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void g() {
        Log.d("BdPreferenceQueueWorker", "wait to finish");
        f49446b.removeMessages(0);
        d();
        f();
    }
}
