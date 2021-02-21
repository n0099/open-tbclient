package com.bytedance.tea.crash.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.bytedance.tea.crash.e.h;
import com.bytedance.tea.crash.g.j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private static int e;
    private static List<a> f;
    private static long i;
    private static HandlerThread j;
    private static long k;
    private static long l;
    private static int n;
    private static boolean o;
    private static Handler pwb;
    private static boolean c = false;
    private static boolean d = true;
    private static volatile AtomicLong g = new AtomicLong(-1);
    private static long h = 100;
    private static volatile String p = null;
    private static volatile boolean q = false;
    private static int r = -1;

    /* renamed from: a  reason: collision with root package name */
    public static long f7616a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static long f7617b = -1;
    private static int s = -1;
    private static MessageQueue pwc = null;
    private static Field pwd = null;
    private static Field pwe = null;

    static /* synthetic */ int j() {
        int i2 = n;
        n = i2 + 1;
        return i2;
    }

    public static void a(int i2, int i3) {
        if (d) {
            if (i2 > 10) {
                e = i2;
            }
            if (i3 > 10) {
                h = i3;
            }
            f = new ArrayList();
            a();
            a(eqX());
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f7618a;

        /* renamed from: b  reason: collision with root package name */
        public int f7619b;
        public long c;
        public long d;
        public long e;
        public boolean f;
        public String g;

        public String toString() {
            if (this.f7619b == 0) {
                return "[[[ IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            }
            if (this.f7619b == 1) {
                return "[[[ Long IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            }
            if (this.f7619b == 2) {
                return "[[[  1 msg  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e + ", msg:" + this.g;
            }
            if (this.f7619b == 3) {
                return "[[[ 1 msg + IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            }
            if (this.f7619b == 4) {
                return "[[[ " + (this.f7618a - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.c - 1) + "tick ,, mDuration：" + this.d + "cpuTime:" + this.e + " msg:" + this.g;
            }
            if (this.f7619b == 5) {
                return "[[[ " + this.f7618a + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.c - 1) + " ticks, , mDuration：" + this.d + "cpuTime:" + this.e;
            }
            if (this.f7619b == 6) {
                return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.c - 1) + ", , mDuration：" + this.d + "cpuTime:" + this.e;
            }
            if (this.f7619b == 7) {
                return "[[[ " + this.f7618a + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
            }
            if (this.f7619b == 8) {
                return "[[[ 1 msgs ]]] cost " + this.c + " ticks , mDuration：" + this.d + " cost cpuTime:" + this.e + " msg:" + this.g;
            }
            if (this.f7619b == 9) {
                return "[[[ " + this.f7618a + " msgs ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
            }
            return "=========   UNKNOW =========  Type:" + this.f7619b + " cost ticks " + this.c + " msgs:" + this.f7618a;
        }
    }

    public static void a() {
        com.bytedance.tea.crash.e.g.a(4L);
        com.bytedance.tea.crash.e.f.erh().b();
        com.bytedance.tea.crash.e.f.erh().b(new Printer() { // from class: com.bytedance.tea.crash.a.g.1
            @Override // android.util.Printer
            public void println(String str) {
                int i2;
                if (g.d) {
                    String unused = g.p = str;
                    if (!g.o) {
                        boolean unused2 = g.o = true;
                        int unused3 = g.r = Process.myTid();
                        g.u();
                    }
                    g.f7616a = g.g.get();
                    if (g.f7617b != -1) {
                        long j2 = g.f7616a - g.f7617b;
                        if (j2 <= 0) {
                            g.j();
                            return;
                        }
                        if (j2 == 1) {
                            if (g.n <= 1) {
                                if (g.n == 1) {
                                    i2 = 3;
                                } else {
                                    i2 = 0;
                                }
                            } else {
                                i2 = 7;
                            }
                        } else if (g.n <= 1) {
                            if (g.n == 1) {
                                i2 = 6;
                            } else {
                                i2 = 1;
                            }
                        } else {
                            i2 = 5;
                        }
                        long eqY = g.eqY();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (!g.q) {
                            g.a(g.eqW(), eqY - g.k, uptimeMillis - g.l, j2, i2, g.n, null);
                        }
                        long unused4 = g.k = eqY;
                        long unused5 = g.l = uptimeMillis;
                        int unused6 = g.n = 1;
                    }
                }
            }
        });
        com.bytedance.tea.crash.e.f.erh().a(new Printer() { // from class: com.bytedance.tea.crash.a.g.2
            @Override // android.util.Printer
            public void println(String str) {
                g.f7617b = g.g.get();
                if (g.f7616a > 0) {
                    long j2 = g.f7617b - g.f7616a;
                    if (j2 > 0) {
                        long eqY = g.eqY();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        int i2 = 0;
                        if (j2 == 1 && g.n > 1) {
                            i2 = 9;
                        } else if (j2 == 1 && g.n == 1) {
                            i2 = 2;
                        } else if (j2 > 1 && g.n > 1) {
                            i2 = 4;
                        } else if (j2 > 1 && g.n == 1) {
                            i2 = 8;
                        }
                        if (!g.q) {
                            g.a(g.eqW(), eqY - g.k, uptimeMillis - g.l, j2, i2, g.n, str);
                        }
                        long unused = g.k = eqY;
                        long unused2 = g.l = uptimeMillis;
                        int unused3 = g.n = 0;
                        g.f7616a = -1L;
                    }
                }
            }
        });
        k = eqY();
        l = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a eqW() {
        if (f.size() == e) {
            s = (s + 1) % e;
            return f.get(s);
        }
        a aVar = new a();
        f.add(aVar);
        s++;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar, long j2, long j3, long j4, int i2, int i3, String str) {
        aVar.e = j2;
        aVar.c = j4;
        aVar.d = j3;
        aVar.f = false;
        aVar.f7618a = i3;
        if (str != null) {
            aVar.g = str;
        }
        aVar.f7619b = i2;
    }

    public static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        List<a> c2 = c();
        if (c2 == null) {
            return jSONArray;
        }
        int i2 = 0;
        for (a aVar : c2) {
            if (aVar != null) {
                i2++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", aVar.g);
                    jSONObject.put("cpuDuration", aVar.e);
                    jSONObject.put("duration", aVar.d);
                    jSONObject.put("tick", aVar.c);
                    jSONObject.put("type", aVar.f7619b);
                    jSONObject.put("count", aVar.f7618a);
                    jSONObject.put("id", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static List<a> c() {
        if (f == null) {
            return null;
        }
        q = true;
        ArrayList arrayList = new ArrayList();
        if (f.size() == e) {
            int i2 = s;
            while (true) {
                int i3 = i2;
                if (i3 >= f.size()) {
                    break;
                }
                arrayList.add(f.get(i3));
                i2 = i3 + 1;
            }
            for (int i4 = 0; i4 < s; i4++) {
                arrayList.add(f.get(i4));
            }
        } else {
            arrayList.addAll(f);
        }
        q = false;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u() {
        j = h.a();
        i = SystemClock.uptimeMillis();
        pwb = new Handler(j.getLooper());
        com.bytedance.tea.crash.e.g.a(8L);
        pwb.postDelayed(new Runnable() { // from class: com.bytedance.tea.crash.a.g.3
            @Override // java.lang.Runnable
            public void run() {
                long j2;
                g.g.set((SystemClock.uptimeMillis() - g.i) / g.h);
                long uptimeMillis = (SystemClock.uptimeMillis() - g.i) % g.h;
                if (uptimeMillis >= 95) {
                    g.g.incrementAndGet();
                    j2 = (g.h << 1) - uptimeMillis;
                } else {
                    j2 = g.h - uptimeMillis;
                }
                g.pwb.postDelayed(this, j2);
            }
        }, h);
    }

    public static MessageQueue eqX() {
        if (pwc == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                pwc = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                pwc = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    pwc = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return pwc;
    }

    private static Message a(MessageQueue messageQueue) {
        if (pwd == null) {
            try {
                pwd = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                pwd.setAccessible(true);
                return (Message) pwd.get(messageQueue);
            } catch (Exception e2) {
                return null;
            }
        }
        try {
            return (Message) pwd.get(messageQueue);
        } catch (Exception e3) {
            return null;
        }
    }

    public static JSONArray E(int i2, long j2) {
        MessageQueue eqX = eqX();
        JSONArray jSONArray = new JSONArray();
        if (eqX != null) {
            synchronized (eqX) {
                Message a2 = a(eqX);
                if (a2 != null) {
                    int i3 = 0;
                    int i4 = 0;
                    while (a2 != null && i4 < i2) {
                        i4++;
                        i3++;
                        JSONObject a3 = a(a2, j2);
                        try {
                            a3.put("id", i3);
                        } catch (JSONException e2) {
                        }
                        jSONArray.put(a3);
                        a2 = W(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long eqY() {
        return com.bytedance.tea.crash.e.c.a(r);
    }

    public static JSONObject iw(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", p);
            jSONObject.put("currentMessageCost", e());
            jSONObject.put("currentMessageCpu", eqY() - k);
            jSONObject.put("currentTick", g.get());
        } catch (Throwable th) {
            j.a(th);
        }
        return jSONObject;
    }

    private static JSONObject a(Message message, long j2) {
        JSONObject jSONObject = new JSONObject();
        if (message != null) {
            try {
                jSONObject.put("when", message.getWhen() - j2);
                if (message.getCallback() != null) {
                    jSONObject.put(BuyTBeanActivityConfig.CALLBACK, message.getCallback());
                }
                jSONObject.put("what", message.what);
                if (message.getTarget() != null) {
                    jSONObject.put("target", message.getTarget());
                } else {
                    jSONObject.put("barrier", message.arg1);
                }
                jSONObject.put("arg1", message.arg1);
                jSONObject.put("arg2", message.arg2);
                if (message.obj != null) {
                    jSONObject.put("obj", message.obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static long e() {
        return f7616a < 0 ? (SystemClock.uptimeMillis() - i) - (f7617b * h) : (SystemClock.uptimeMillis() - i) - (f7616a * h);
    }

    private static Message W(Message message) {
        if (pwe == null) {
            try {
                pwe = Class.forName("android.os.Message").getDeclaredField(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                pwe.setAccessible(true);
                Message message2 = (Message) pwe.get(message);
                if (c) {
                    Log.i("LooperMonitor", "[getNextMessage] success get next msg :" + message2);
                    return message2;
                }
                return message2;
            } catch (Exception e2) {
                return null;
            }
        }
        try {
            return (Message) pwe.get(message);
        } catch (Exception e3) {
            return null;
        }
    }
}
