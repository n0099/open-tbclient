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
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static b f49445b;

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> f49444a = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f49446c = false;

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            f.d();
            f.f49445b.sendEmptyMessageDelayed(0, 15000L);
        }

        public b(Looper looper) {
            super(looper);
        }
    }

    static {
        b bVar = new b(d.b.h.a.i.b.a("PreferenceQueue").getLooper());
        f49445b = bVar;
        bVar.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void c(String str, String str2, Object obj) {
        if (str == null) {
            return;
        }
        if (!f49444a.containsKey(str)) {
            if (obj == null || str2 == null) {
                return;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, obj);
            f49444a.put(str, concurrentHashMap);
            return;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap2 = f49444a.get(str);
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
            f49444a.put(str, concurrentHashMap3);
        }
    }

    public static void d() {
        int i;
        if (f49446c) {
            return;
        }
        f49446c = true;
        try {
            try {
                Context baseContext = d.b.h.a.b.a().getBaseContext();
                BdLog.a("BdPreferenceQueueWorker", "pending work category: " + f49444a.size());
                for (String str : f49444a.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = f49444a.get(str);
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
            f49446c = false;
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (str == null || (concurrentHashMap = f49444a.get(str)) == null) {
            return;
        }
        concurrentHashMap.clear();
    }

    public static void f() {
        if (f49445b.hasMessages(0)) {
            return;
        }
        f49445b.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void g() {
        Log.d("BdPreferenceQueueWorker", "wait to finish");
        f49445b.removeMessages(0);
        d();
        f();
    }
}
