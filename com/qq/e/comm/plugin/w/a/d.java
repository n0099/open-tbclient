package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.baidu.mobstat.Config;
import com.kwai.video.player.NativeErrorCode;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.j;
import com.qq.e.comm.plugin.w.a.b;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f12637a = new AtomicInteger();

    /* renamed from: com.qq.e.comm.plugin.w.a.d$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass1 implements com.qq.e.comm.plugin.t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f12638a;

        AnonymousClass1(j jVar) {
            this.f12638a = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // com.qq.e.comm.plugin.t.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
            JSONObject jSONObject;
            String d;
            int e = fVar.e();
            if (e == 200) {
                try {
                    d = fVar.d();
                } catch (JSONException e2) {
                    jSONObject = null;
                } catch (Throwable th) {
                    jSONObject = null;
                }
                if (!StringUtil.isEmpty(d)) {
                    jSONObject = new JSONObject(d);
                    if (jSONObject != null) {
                        try {
                            jSONObject = jSONObject.optJSONObject("data");
                        } catch (JSONException e3) {
                            GDTLogger.e("JSONExceptionWhileParseClickADResponse");
                            e = -5001;
                            if (this.f12638a == null) {
                            }
                        } catch (Throwable th2) {
                            GDTLogger.e("JSONExceptionWhileParseClickADResponse");
                            e = NativeErrorCode.EKS_AVERROR_EIO;
                            if (this.f12638a == null) {
                            }
                        }
                    }
                    if (this.f12638a == null) {
                        this.f12638a.a(new Pair(Integer.valueOf(e), jSONObject));
                        return;
                    }
                    return;
                }
            }
            jSONObject = null;
            if (this.f12638a == null) {
            }
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(Exception exc) {
            if (this.f12638a != null) {
                this.f12638a.a(new Pair(-1, null));
            }
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.d$2  reason: invalid class name */
    /* loaded from: classes15.dex */
    static final class AnonymousClass2 implements j<Pair<Integer, JSONObject>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exchanger f12639a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f12640b;

        AnonymousClass2(Exchanger exchanger, long j) {
            this.f12639a = exchanger;
            this.f12640b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.qq.e.comm.plugin.util.j
        public void a(Pair<Integer, JSONObject> pair) {
            try {
                this.f12639a.exchange(pair, this.f12640b, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                GDTLogger.e("ExceptionWhileDoClickADSync", e);
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f12641a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12642b;
        public final com.qq.e.comm.plugin.s.a c;

        public a(JSONObject jSONObject, String str) {
            this(jSONObject, str, null);
        }

        public a(JSONObject jSONObject, String str, com.qq.e.comm.plugin.s.a aVar) {
            this.f12641a = jSONObject;
            this.f12642b = str;
            this.c = aVar;
        }

        public String toString() {
            return "ADParam [adInfo=" + this.f12641a + ", clickURL=" + this.f12642b + "]";
        }
    }

    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public int f12644b;
        public c c;
        public String d;
        public boolean e;
        public boolean f;
        public boolean g;
        public com.qq.e.comm.plugin.ad.f h;
        public int i;
        private boolean l;
        public boolean k = true;
        private boolean m = false;

        /* renamed from: a  reason: collision with root package name */
        public int f12643a = 0;
        public int j = 0;

        public b(int i, c cVar) {
            this.f12644b = i;
            this.c = cVar;
        }

        public b a(int i) {
            this.f12643a = i;
            return this;
        }

        public b a(com.qq.e.comm.plugin.ad.f fVar) {
            this.h = fVar;
            return this;
        }

        public b a(String str) {
            this.d = str;
            return this;
        }

        public b a(boolean z) {
            this.l = z;
            return this;
        }

        public boolean a() {
            return this.l;
        }

        public b b(int i) {
            switch (i) {
                case 1:
                    this.e = true;
                    this.f = true;
                    this.g = true;
                    break;
                case 2:
                    this.e = false;
                    this.f = false;
                    this.g = false;
                    break;
                default:
                    this.e = false;
                    this.f = false;
                    this.g = true;
                    break;
            }
            return this;
        }

        public b b(boolean z) {
            this.m = z;
            return this;
        }

        public boolean b() {
            return this.m;
        }

        public b c(int i) {
            this.j = i;
            return this;
        }
    }

    /* loaded from: classes15.dex */
    public enum c {
        InnerBrowser,
        SysBrowser
    }

    /* renamed from: com.qq.e.comm.plugin.w.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class RunnableC1212d<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final T f12647a;

        /* renamed from: b  reason: collision with root package name */
        private final a f12648b;
        private final b c;
        private final e d;
        private com.qq.e.comm.plugin.y.c e = new com.qq.e.comm.plugin.y.c();

        public RunnableC1212d(T t, a aVar, b bVar, e eVar) {
            this.f12647a = t;
            this.f12648b = aVar;
            this.c = bVar;
            this.d = eVar;
            this.e.a(eVar.c);
            if (aVar.f12641a != null) {
                this.e.b(aVar.f12641a.optString(Config.CELL_LOCATION));
                this.e.c(aVar.f12641a.optString("traceid"));
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE, INVOKE]}, finally: {[INVOKE, INVOKE, INVOKE, CONSTRUCTOR, CONST_STR, IGET, INVOKE, INVOKE, CONST_STR, INVOKE, INVOKE, IGET, INVOKE, IF, INVOKE, IF] complete} */
        @Override // java.lang.Runnable
        public void run() {
            Context context;
            try {
                d.a().incrementAndGet();
                if (this.f12647a instanceof View) {
                    Context context2 = ((View) this.f12647a).getRootView().getContext();
                    if (this.c.i <= 0) {
                        this.c.i = com.qq.e.comm.plugin.ad.a.a().b((View) this.f12647a);
                    }
                    ai.b("gdt_tag_p", "DoClickRunable : viewIdentifier = %d", Integer.valueOf(this.c.i));
                    context = context2;
                } else if (this.f12647a instanceof com.qq.e.comm.plugin.ab.h) {
                    Context context3 = ((com.qq.e.comm.plugin.ab.h) this.f12647a).a().getRootView().getContext();
                    if (this.c.i <= 0) {
                        this.c.i = com.qq.e.comm.plugin.ad.a.a().b(((com.qq.e.comm.plugin.ab.h) this.f12647a).a());
                    }
                    ai.b("gdt_tag_p", "DoClickRunable(IWebView) : viewIdentifier = %d", Integer.valueOf(this.c.i));
                    context = context3;
                } else {
                    context = null;
                }
                boolean z = (this.f12648b.c instanceof com.qq.e.comm.plugin.s.f) && ((com.qq.e.comm.plugin.s.f) this.f12648b.c).ap().booleanValue();
                if (z || com.qq.e.comm.plugin.util.b.c(this.f12648b.f12641a)) {
                    if (!((Boolean) i.a(this.f12647a, this.f12648b, this.c, this.d, (i.a) null).second).booleanValue() && z) {
                        h.a(this.f12647a, context, this.f12648b, this.c, this.d);
                    }
                } else if (this.c.f12644b == 18) {
                    d.a(this.f12648b, this.c);
                } else if (this.c.f12644b == 1 && com.qq.e.comm.plugin.util.d.a(this.f12648b.f12641a)) {
                    f.a(this.f12647a, context, this.f12648b, this.c, this.d);
                } else if (this.c.f12644b == 0) {
                    h.a(this.f12647a, context, this.f12648b, this.c, this.d);
                } else if (36 == this.c.f12644b) {
                    d.a(context, this.f12648b, this.c, this.d);
                } else if (45 == this.c.f12644b) {
                    d.b(this.f12648b, this.c);
                } else if (this.c.f12644b == 9001) {
                    g.a(this.f12647a, context, this.f12648b, this.c, this.d);
                } else if (this.c.f12644b == 9000) {
                    g.a(this.f12647a, this.f12648b, this.c, this.d);
                } else if (this.c.f12644b == 9002) {
                    g.b(this.f12647a, context, this.f12648b, this.c, this.d);
                } else {
                    d.c(this.f12648b, this.c);
                }
            } catch (Throwable th) {
                try {
                    GDTLogger.e("UnknowExceptinWhileProcessingClick", th);
                    d.a().decrementAndGet();
                    Stack<b.a> a2 = com.qq.e.comm.plugin.w.a.b.a();
                    if (a2 == null || a2.isEmpty()) {
                        return;
                    }
                    com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                    dVar.a("adParam", this.f12648b.toString());
                    dVar.a("stack", a2.toString());
                    u.a(90012, 0, this.e, dVar);
                } finally {
                    d.a().decrementAndGet();
                    Stack<b.a> a3 = com.qq.e.comm.plugin.w.a.b.a();
                    if (a3 != null && !a3.isEmpty()) {
                        com.qq.e.comm.plugin.y.d dVar2 = new com.qq.e.comm.plugin.y.d();
                        dVar2.a("adParam", this.f12648b.toString());
                        dVar2.a("stack", a3.toString());
                        u.a(90012, 0, this.e, dVar2);
                    }
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12649a;

        /* renamed from: b  reason: collision with root package name */
        public final com.qq.e.comm.plugin.ad.e f12650b;
        public final String c;

        public e(String str, com.qq.e.comm.plugin.ad.e eVar, String str2) {
            this.f12649a = str;
            this.f12650b = eVar;
            this.c = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<Integer, JSONObject> a(String str, long j, a aVar, e eVar, b bVar) {
        return (Pair) gdtadv.getobjresult(41, 1, str, Long.valueOf(j), aVar, eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, JSONObject jSONObject, int i, String str2, int i2) {
        return (String) gdtadv.getobjresult(42, 1, str, jSONObject, Integer.valueOf(i), str2, Integer.valueOf(i2));
    }

    static String a(String str, JSONObject jSONObject, int i, String str2, int i2, int i3) {
        return (String) gdtadv.getobjresult(43, 1, str, jSONObject, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String a(String str, JSONObject jSONObject, String str2, int i) {
        return (String) gdtadv.getobjresult(44, 1, str, jSONObject, str2, Integer.valueOf(i));
    }

    static /* synthetic */ AtomicInteger a() {
        return (AtomicInteger) gdtadv.getobjresult(45, 1, new Object[0]);
    }

    public static <T> void a(T t) {
        gdtadv.getVresult(46, 1, t);
    }

    public static <T> void a(T t, a aVar, e eVar, b bVar) {
        gdtadv.getVresult(47, 1, t, aVar, eVar, bVar);
    }

    public static void a(String str, com.qq.e.comm.plugin.s.a aVar, j<Pair<Integer, JSONObject>> jVar) {
        gdtadv.getVresult(48, 1, str, aVar, jVar);
    }

    public static void a(String str, JSONObject jSONObject, e eVar, b bVar, Map<String, Object> map) {
        gdtadv.getVresult(49, 1, str, jSONObject, eVar, bVar, map);
    }

    static /* synthetic */ boolean a(Context context, a aVar, b bVar, e eVar) {
        return gdtadv.getZresult(50, 1, context, aVar, bVar, eVar);
    }

    static /* synthetic */ boolean a(a aVar, b bVar) {
        return gdtadv.getZresult(51, 1, aVar, bVar);
    }

    public static <T> void b(T t) {
        gdtadv.getVresult(52, 1, t);
    }

    private static boolean b(Context context, a aVar, b bVar, e eVar) {
        return gdtadv.getZresult(53, 1, context, aVar, bVar, eVar);
    }

    static /* synthetic */ boolean b(a aVar, b bVar) {
        return gdtadv.getZresult(54, 1, aVar, bVar);
    }

    public static <T> void c(T t) {
        gdtadv.getVresult(55, 1, t);
    }

    static /* synthetic */ boolean c(a aVar, b bVar) {
        return gdtadv.getZresult(56, 1, aVar, bVar);
    }

    private static boolean d(a aVar, b bVar) {
        return gdtadv.getZresult(57, 1, aVar, bVar);
    }

    private static boolean e(a aVar, b bVar) {
        return gdtadv.getZresult(58, 1, aVar, bVar);
    }

    private static boolean f(a aVar, b bVar) {
        return gdtadv.getZresult(59, 1, aVar, bVar);
    }
}
