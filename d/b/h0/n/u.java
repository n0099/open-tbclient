package d.b.h0.n;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f50052g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f50046a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f50047b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f50048c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f50049d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f50050e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f50051f = "0";

    public final void a(JSONObject jSONObject) {
        this.f50046a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f50046a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f50047b.clear();
        this.f50048c.clear();
        this.f50046a = null;
    }

    public String d() {
        return this.f50051f;
    }

    public JSONArray e() {
        return this.f50046a;
    }

    public final ArrayList f() {
        return this.f50048c;
    }

    public final SparseArray<Integer> g() {
        return this.f50047b;
    }

    public long h() {
        return this.f50050e;
    }

    public long i() {
        return this.f50049d;
    }

    public JSONArray j() {
        return this.f50046a;
    }

    public boolean k() {
        return this.f50046a.length() == 0;
    }

    public boolean l() {
        return this.f50052g;
    }

    public final void m(String str) {
        if (this.f50048c.contains(str)) {
            return;
        }
        this.f50048c.add(str);
    }

    public final void n(int i, int i2) {
        this.f50047b.put(i, Integer.valueOf(i2));
    }

    public final void o(long j, long j2) {
        long j3 = this.f50049d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f50049d = j;
        }
        if (j2 > this.f50050e) {
            this.f50050e = j2;
        }
    }

    public void p(String str) {
        this.f50051f = str;
    }

    public void q(boolean z) {
        this.f50052g = z;
    }
}
