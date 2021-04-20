package d.b.p.f.a;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import d.b.p.g.d.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public a f65072a;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f65073a;

        /* renamed from: b  reason: collision with root package name */
        public a.C1765a f65074b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65075c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65076d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65077e;

        /* renamed from: f  reason: collision with root package name */
        public long f65078f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f65079g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f65080h;
        public long i;

        public a(o oVar, Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.f65074b = new d.b.p.g.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            this.f65080h = jSONObject;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
            if (e() != false) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean b() {
            n();
            o();
            boolean g2 = d.b.p.b.d(this.f65073a).g();
            boolean z = false;
            if (this.f65075c && g2) {
                if (this.f65079g == null) {
                    return true;
                }
                if (!f()) {
                }
                z = true;
                return z;
            }
            return false;
        }

        public final boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            try {
                jSONArray = m.a(jSONObject.optJSONArray("sids"), "pkg");
                try {
                    jSONArray2 = m.a(jSONObject2.optJSONArray("sids"), "pkg");
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONArray = null;
            }
            return o.b(jSONArray, jSONArray2) || m.b(jSONObject, jSONObject2, "oid") || m.b(jSONObject, jSONObject2, "gaid") || m.b(jSONObject, jSONObject2, "iid") || m.b(jSONObject, jSONObject2, "adrid") || m.b(jSONObject, jSONObject2, "aid");
        }

        public void d(JSONObject jSONObject) {
            this.f65079g = jSONObject;
            k();
        }

        public final synchronized boolean e() {
            if (this.f65079g == null) {
                return true;
            }
            if (this.f65080h != null) {
                return c(this.f65079g, this.f65080h);
            }
            throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
        }

        public final boolean f() {
            return Math.abs(System.currentTimeMillis() - this.i) / 1000 > this.f65078f;
        }

        public final long g() {
            JSONObject jSONObject = this.f65079g;
            if (jSONObject == null) {
                return 0L;
            }
            return jSONObject.optLong("ctime", 0L);
        }

        public final void h() {
            try {
                this.f65079g = n.a(this.f65074b.g("cs.dat", true));
                this.i = g();
            } catch (Exception unused) {
                this.i = 0L;
            }
        }

        public final void i() {
            try {
                JSONObject a2 = n.a(this.f65074b.g("ct.dat", true));
                if (a2 == null) {
                    this.f65078f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                } else {
                    this.f65078f = a2.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                }
            } catch (Exception unused) {
                this.f65078f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
            }
        }

        public final void j() {
            try {
                JSONObject a2 = n.a(this.f65074b.g("ci.dat", true));
                if (a2 == null) {
                    this.f65075c = true;
                } else {
                    this.f65075c = a2.optBoolean("isOn", true);
                }
            } catch (Exception unused) {
                this.f65075c = true;
            }
        }

        public final boolean k() {
            try {
                this.f65074b.i("cs.dat", this.f65079g.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean l() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isOn", this.f65075c);
                this.f65074b.i("ci.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("TIME_OUT", this.f65078f);
                this.f65074b.i("ct.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final synchronized void n() {
            boolean z = true;
            if (this.f65076d) {
                this.f65076d = !l();
            }
            if (this.f65077e) {
                if (m()) {
                    z = false;
                }
                this.f65077e = z;
            }
        }

        public final void o() {
            h();
            i();
            j();
        }
    }

    public o(Context context) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.f65072a == null) {
            this.f65072a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean b(JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            JSONObject optJSONObject2 = jSONArray2.optJSONObject(i);
            if (m.b(optJSONObject, optJSONObject2, "pkg") || m.b(optJSONObject, optJSONObject2, "aid") || m.c(optJSONObject, optJSONObject2, "priority")) {
                return true;
            }
        }
        return false;
    }

    @Override // d.b.p.f.a.j
    public j a(JSONObject jSONObject) {
        this.f65072a.a(jSONObject);
        return this;
    }

    @Override // d.b.p.f.a.j
    public boolean a() {
        return this.f65072a.b();
    }

    @Override // d.b.p.f.a.j
    public void b(JSONObject jSONObject) {
        this.f65072a.d(jSONObject);
    }
}
