package d.a.h0.n;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f47584g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f47578a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f47579b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f47580c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f47581d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f47582e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f47583f = "0";

    public final void a(JSONObject jSONObject) {
        this.f47578a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f47578a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f47579b.clear();
        this.f47580c.clear();
        this.f47578a = null;
    }

    public String d() {
        return this.f47583f;
    }

    public JSONArray e() {
        return this.f47578a;
    }

    public final ArrayList f() {
        return this.f47580c;
    }

    public final SparseArray<Integer> g() {
        return this.f47579b;
    }

    public long h() {
        return this.f47582e;
    }

    public long i() {
        return this.f47581d;
    }

    public JSONArray j() {
        return this.f47578a;
    }

    public boolean k() {
        return this.f47578a.length() == 0;
    }

    public boolean l() {
        return this.f47584g;
    }

    public final void m(String str) {
        if (this.f47580c.contains(str)) {
            return;
        }
        this.f47580c.add(str);
    }

    public final void n(int i2, int i3) {
        this.f47579b.put(i2, Integer.valueOf(i3));
    }

    public final void o(long j, long j2) {
        long j3 = this.f47581d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f47581d = j;
        }
        if (j2 > this.f47582e) {
            this.f47582e = j2;
        }
    }

    public void p(String str) {
        this.f47583f = str;
    }

    public void q(boolean z) {
        this.f47584g = z;
    }
}
