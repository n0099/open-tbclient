package d.b.d.b.a;

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
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.b.d.b.h.h;
import d.b.d.b.h.i;
import d.b.d.b.l;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f65817a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65818b = true;

    /* renamed from: c  reason: collision with root package name */
    public static int f65819c;

    /* renamed from: d  reason: collision with root package name */
    public static List<d> f65820d;

    /* renamed from: g  reason: collision with root package name */
    public static long f65823g;

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f65824h;

    /* renamed from: i  reason: collision with root package name */
    public static long f65825i;
    public static long j;
    public static Handler k;
    public static int l;
    public static boolean m;

    /* renamed from: e  reason: collision with root package name */
    public static volatile AtomicLong f65821e = new AtomicLong(-1);

    /* renamed from: f  reason: collision with root package name */
    public static long f65822f = 100;
    public static volatile String n = null;
    public static volatile boolean o = false;
    public static int p = -1;
    public static long q = -1;
    public static long r = -1;
    public static int s = -1;
    public static MessageQueue t = null;
    public static Field u = null;
    public static Field v = null;

    /* loaded from: classes6.dex */
    public static class a implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            int i2;
            if (g.f65818b) {
                String unused = g.n = str;
                if (!g.m) {
                    boolean unused2 = g.m = true;
                    int unused3 = g.p = Process.myTid();
                    g.I();
                }
                g.q = g.f65821e.get();
                if (g.r == -1) {
                    return;
                }
                long j = g.q - g.r;
                if (j > 0) {
                    if (j == 1) {
                        if (g.l > 1) {
                            i2 = 7;
                        } else {
                            i2 = g.l == 1 ? 3 : 0;
                        }
                    } else if (g.l > 1) {
                        i2 = 5;
                    } else {
                        i2 = g.l == 1 ? 6 : 1;
                    }
                    long J = g.J();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (!g.o) {
                        g.o(g.H(), J - g.f65825i, uptimeMillis - g.j, j, i2, g.l, null);
                    }
                    long unused4 = g.f65825i = J;
                    long unused5 = g.j = uptimeMillis;
                    int unused6 = g.l = 1;
                    return;
                }
                g.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            int i2;
            g.r = g.f65821e.get();
            if (g.q <= 0) {
                return;
            }
            long j = g.r - g.q;
            if (j <= 0) {
                return;
            }
            long J = g.J();
            long uptimeMillis = SystemClock.uptimeMillis();
            int i3 = (j > 1L ? 1 : (j == 1L ? 0 : -1));
            if (i3 == 0 && g.l > 1) {
                i2 = 9;
            } else if (i3 == 0 && g.l == 1) {
                i2 = 2;
            } else if (i3 <= 0 || g.l <= 1) {
                i2 = (i3 <= 0 || g.l != 1) ? 0 : 8;
            } else {
                i2 = 4;
            }
            if (!g.o) {
                g.o(g.H(), J - g.f65825i, uptimeMillis - g.j, j, i2, g.l, str);
            }
            long unused = g.f65825i = J;
            long unused2 = g.j = uptimeMillis;
            int unused3 = g.l = 0;
            g.q = -1L;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long j;
            g.f65821e.set((SystemClock.uptimeMillis() - g.f65823g) / g.f65822f);
            long uptimeMillis = (SystemClock.uptimeMillis() - g.f65823g) % g.f65822f;
            if (uptimeMillis >= 95) {
                g.f65821e.incrementAndGet();
                j = g.f65822f << 1;
            } else {
                j = g.f65822f;
            }
            g.k.postDelayed(this, j - uptimeMillis);
        }
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f65826a;

        /* renamed from: b  reason: collision with root package name */
        public int f65827b;

        /* renamed from: c  reason: collision with root package name */
        public long f65828c;

        /* renamed from: d  reason: collision with root package name */
        public long f65829d;

        /* renamed from: e  reason: collision with root package name */
        public long f65830e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65831f;

        /* renamed from: g  reason: collision with root package name */
        public String f65832g;

        public String toString() {
            int i2 = this.f65827b;
            if (i2 == 0) {
                return "[[[ IDLE  ]]] cost " + this.f65828c + " tick , mDuration：" + this.f65829d + ",cpuTime:" + this.f65830e;
            } else if (i2 == 1) {
                return "[[[ Long IDLE  ]]] cost " + this.f65828c + " tick , mDuration：" + this.f65829d + ",cpuTime:" + this.f65830e;
            } else if (i2 == 2) {
                return "[[[  1 msg  ]]] cost " + this.f65828c + " tick , mDuration：" + this.f65829d + ",cpuTime:" + this.f65830e + ", msg:" + this.f65832g;
            } else if (i2 == 3) {
                return "[[[ 1 msg + IDLE  ]]] cost " + this.f65828c + " tick , mDuration：" + this.f65829d + ",cpuTime:" + this.f65830e;
            } else if (i2 == 4) {
                return "[[[ " + (this.f65826a - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.f65828c - 1) + "tick ,, mDuration：" + this.f65829d + "cpuTime:" + this.f65830e + " msg:" + this.f65832g;
            } else if (i2 == 5) {
                return "[[[ " + this.f65826a + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.f65828c - 1) + " ticks, , mDuration：" + this.f65829d + "cpuTime:" + this.f65830e;
            } else if (i2 == 6) {
                return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.f65828c - 1) + ", , mDuration：" + this.f65829d + "cpuTime:" + this.f65830e;
            } else if (i2 == 7) {
                return "[[[ " + this.f65826a + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.f65829d + " cost cpuTime:" + this.f65830e;
            } else if (i2 == 8) {
                return "[[[ 1 msgs ]]] cost " + this.f65828c + " ticks , mDuration：" + this.f65829d + " cost cpuTime:" + this.f65830e + " msg:" + this.f65832g;
            } else if (i2 == 9) {
                return "[[[ " + this.f65826a + " msgs ]]] cost 1 tick , mDuration：" + this.f65829d + " cost cpuTime:" + this.f65830e;
            } else {
                return "=========   UNKNOW =========  Type:" + this.f65827b + " cost ticks " + this.f65828c + " msgs:" + this.f65826a;
            }
        }
    }

    public static d H() {
        int size = f65820d.size();
        int i2 = f65819c;
        if (size == i2) {
            int i3 = (s + 1) % i2;
            s = i3;
            return f65820d.get(i3);
        }
        d dVar = new d();
        f65820d.add(dVar);
        s++;
        return dVar;
    }

    public static void I() {
        f65824h = i.a();
        f65823g = SystemClock.uptimeMillis();
        k = new Handler(f65824h.getLooper());
        h.a(8L);
        k.postDelayed(new c(), f65822f);
    }

    public static long J() {
        return d.b.d.b.h.d.a(p);
    }

    public static Message b(Message message) {
        Field field = v;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                v = declaredField;
                declaredField.setAccessible(true);
                Message message2 = (Message) v.get(message);
                if (f65817a) {
                    Log.i("LooperMonitor", "[getNextMessage] success get next msg :" + message2);
                }
                return message2;
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(message);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Message c(MessageQueue messageQueue) {
        Field field = u;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                u = declaredField;
                declaredField.setAccessible(true);
                return (Message) u.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static JSONArray e(int i2, long j2) {
        MessageQueue r2 = r();
        JSONArray jSONArray = new JSONArray();
        if (r2 == null) {
            return jSONArray;
        }
        synchronized (r2) {
            Message c2 = c(r2);
            if (c2 == null) {
                return jSONArray;
            }
            int i3 = 0;
            int i4 = 0;
            while (c2 != null && i3 < i2) {
                i3++;
                i4++;
                JSONObject g2 = g(c2, j2);
                try {
                    g2.put("id", i4);
                } catch (JSONException unused) {
                }
                jSONArray.put(g2);
                c2 = b(c2);
            }
            return jSONArray;
        }
    }

    public static JSONObject f(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", n);
            jSONObject.put("currentMessageCost", s());
            jSONObject.put("currentMessageCpu", J() - f65825i);
            jSONObject.put("currentTick", f65821e.get());
        } catch (Throwable th) {
            l.k.b(th);
        }
        return jSONObject;
    }

    public static JSONObject g(Message message, long j2) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j2);
            if (message.getCallback() != null) {
                jSONObject.put("callback", message.getCallback());
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
        return jSONObject;
    }

    public static void h() {
        h.a(4L);
        d.b.d.b.h.g.a().h();
        d.b.d.b.h.g.a().i(new a());
        d.b.d.b.h.g.a().d(new b());
        f65825i = J();
        j = SystemClock.uptimeMillis();
    }

    public static void i(int i2, int i3) {
        if (f65818b) {
            if (i2 > 10) {
                f65819c = i2;
            }
            if (i3 > 10) {
                f65822f = i3;
            }
            f65820d = new ArrayList();
            h();
            c(r());
        }
    }

    public static JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        List<d> q2 = q();
        if (q2 == null) {
            return jSONArray;
        }
        int i2 = 0;
        for (d dVar : q2) {
            if (dVar != null) {
                i2++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", dVar.f65832g);
                    jSONObject.put("cpuDuration", dVar.f65830e);
                    jSONObject.put("duration", dVar.f65829d);
                    jSONObject.put("tick", dVar.f65828c);
                    jSONObject.put("type", dVar.f65827b);
                    jSONObject.put("count", dVar.f65826a);
                    jSONObject.put("id", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static void o(d dVar, long j2, long j3, long j4, int i2, int i3, String str) {
        dVar.f65830e = j2;
        dVar.f65828c = j4;
        dVar.f65829d = j3;
        dVar.f65831f = false;
        dVar.f65826a = i3;
        if (str != null) {
            dVar.f65832g = str;
        }
        dVar.f65827b = i2;
    }

    public static List<d> q() {
        if (f65820d == null) {
            return null;
        }
        o = true;
        ArrayList arrayList = new ArrayList();
        if (f65820d.size() == f65819c) {
            for (int i2 = s; i2 < f65820d.size(); i2++) {
                arrayList.add(f65820d.get(i2));
            }
            for (int i3 = 0; i3 < s; i3++) {
                arrayList.add(f65820d.get(i3));
            }
        } else {
            arrayList.addAll(f65820d);
        }
        o = false;
        return arrayList;
    }

    public static MessageQueue r() {
        if (t == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                t = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                t = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    t = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return t;
    }

    public static long s() {
        long uptimeMillis;
        long j2;
        long j3;
        if (q < 0) {
            uptimeMillis = SystemClock.uptimeMillis() - f65823g;
            j2 = r;
            j3 = f65822f;
        } else {
            uptimeMillis = SystemClock.uptimeMillis() - f65823g;
            j2 = q;
            j3 = f65822f;
        }
        return uptimeMillis - (j2 * j3);
    }

    public static /* synthetic */ int x() {
        int i2 = l;
        l = i2 + 1;
        return i2;
    }
}
