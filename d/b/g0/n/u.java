package d.b.g0.n;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f49330g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f49324a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f49325b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f49326c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f49327d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f49328e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f49329f = "0";

    public final void a(JSONObject jSONObject) {
        this.f49324a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f49324a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f49325b.clear();
        this.f49326c.clear();
        this.f49324a = null;
    }

    public String d() {
        return this.f49329f;
    }

    public JSONArray e() {
        return this.f49324a;
    }

    public final ArrayList f() {
        return this.f49326c;
    }

    public final SparseArray<Integer> g() {
        return this.f49325b;
    }

    public long h() {
        return this.f49328e;
    }

    public long i() {
        return this.f49327d;
    }

    public JSONArray j() {
        return this.f49324a;
    }

    public boolean k() {
        return this.f49324a.length() == 0;
    }

    public boolean l() {
        return this.f49330g;
    }

    public final void m(String str) {
        if (this.f49326c.contains(str)) {
            return;
        }
        this.f49326c.add(str);
    }

    public final void n(int i, int i2) {
        this.f49325b.put(i, Integer.valueOf(i2));
    }

    public final void o(long j, long j2) {
        long j3 = this.f49327d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f49327d = j;
        }
        if (j2 > this.f49328e) {
            this.f49328e = j2;
        }
    }

    public void p(String str) {
        this.f49329f = str;
    }

    public void q(boolean z) {
        this.f49330g = z;
    }
}
