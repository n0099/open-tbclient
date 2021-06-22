package d.a.m0.r;

import android.util.SparseIntArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f52269g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f52263a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseIntArray f52264b = new SparseIntArray();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f52265c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f52266d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f52267e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f52268f = "0";

    public final void a(JSONObject jSONObject) {
        this.f52263a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f52263a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f52264b.clear();
        this.f52265c.clear();
        this.f52263a = null;
    }

    public boolean d() {
        return this.f52263a.length() == 0;
    }

    public final void e(String str) {
        if (this.f52265c.contains(str)) {
            return;
        }
        this.f52265c.add(str);
    }

    public final void f(int i2, int i3) {
        this.f52264b.put(i2, i3);
    }

    public final void g(long j, long j2) {
        long j3 = this.f52266d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f52266d = j;
        }
        if (j2 > this.f52267e) {
            this.f52267e = j2;
        }
    }
}
