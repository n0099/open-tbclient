package d.b.g0.n;

import android.util.SparseArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f49723g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f49717a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f49718b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f49719c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f49720d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f49721e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f49722f = "0";

    public final void a(JSONObject jSONObject) {
        this.f49717a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f49717a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f49718b.clear();
        this.f49719c.clear();
        this.f49717a = null;
    }

    public String d() {
        return this.f49722f;
    }

    public JSONArray e() {
        return this.f49717a;
    }

    public final ArrayList f() {
        return this.f49719c;
    }

    public final SparseArray<Integer> g() {
        return this.f49718b;
    }

    public long h() {
        return this.f49721e;
    }

    public long i() {
        return this.f49720d;
    }

    public JSONArray j() {
        return this.f49717a;
    }

    public boolean k() {
        return this.f49717a.length() == 0;
    }

    public boolean l() {
        return this.f49723g;
    }

    public final void m(String str) {
        if (this.f49719c.contains(str)) {
            return;
        }
        this.f49719c.add(str);
    }

    public final void n(int i, int i2) {
        this.f49718b.put(i, Integer.valueOf(i2));
    }

    public final void o(long j, long j2) {
        long j3 = this.f49720d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f49720d = j;
        }
        if (j2 > this.f49721e) {
            this.f49721e = j2;
        }
    }

    public void p(String str) {
        this.f49722f = str;
    }

    public void q(boolean z) {
        this.f49723g = z;
    }
}
