package d.b.q.f.a;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import d.b.q.g.d.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public a f64378a;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f64379a;

        /* renamed from: b  reason: collision with root package name */
        public a.C1753a f64380b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64381c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64382d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64383e;

        /* renamed from: f  reason: collision with root package name */
        public long f64384f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f64385g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f64386h;
        public long i;

        public a(o oVar, Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.f64380b = new d.b.q.g.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            this.f64386h = jSONObject;
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
            boolean g2 = d.b.q.b.d(this.f64379a).g();
            boolean z = false;
            if (this.f64381c && g2) {
                if (this.f64385g == null) {
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
            this.f64385g = jSONObject;
            k();
        }

        public final synchronized boolean e() {
            if (this.f64385g == null) {
                return true;
            }
            if (this.f64386h != null) {
                return c(this.f64385g, this.f64386h);
            }
            throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
        }

        public final boolean f() {
            return Math.abs(System.currentTimeMillis() - this.i) / 1000 > this.f64384f;
        }

        public final long g() {
            JSONObject jSONObject = this.f64385g;
            if (jSONObject == null) {
                return 0L;
            }
            return jSONObject.optLong("ctime", 0L);
        }

        public final void h() {
            try {
                this.f64385g = n.a(this.f64380b.g("cs.dat", true));
                this.i = g();
            } catch (Exception unused) {
                this.i = 0L;
            }
        }

        public final void i() {
            try {
                JSONObject a2 = n.a(this.f64380b.g("ct.dat", true));
                if (a2 == null) {
                    this.f64384f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                } else {
                    this.f64384f = a2.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                }
            } catch (Exception unused) {
                this.f64384f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
            }
        }

        public final void j() {
            try {
                JSONObject a2 = n.a(this.f64380b.g("ci.dat", true));
                if (a2 == null) {
                    this.f64381c = true;
                } else {
                    this.f64381c = a2.optBoolean("isOn", true);
                }
            } catch (Exception unused) {
                this.f64381c = true;
            }
        }

        public final boolean k() {
            try {
                this.f64380b.i("cs.dat", this.f64385g.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean l() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isOn", this.f64381c);
                this.f64380b.i("ci.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("TIME_OUT", this.f64384f);
                this.f64380b.i("ct.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final synchronized void n() {
            boolean z = true;
            if (this.f64382d) {
                this.f64382d = !l();
            }
            if (this.f64383e) {
                if (m()) {
                    z = false;
                }
                this.f64383e = z;
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
        if (this.f64378a == null) {
            this.f64378a = new a(this, context.getApplicationContext());
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

    @Override // d.b.q.f.a.j
    public j a(JSONObject jSONObject) {
        this.f64378a.a(jSONObject);
        return this;
    }

    @Override // d.b.q.f.a.j
    public boolean a() {
        return this.f64378a.b();
    }

    @Override // d.b.q.f.a.j
    public void b(JSONObject jSONObject) {
        this.f64378a.d(jSONObject);
    }
}
