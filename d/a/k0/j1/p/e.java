package d.a.k0.j1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f56577f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f56578a;

    /* renamed from: b  reason: collision with root package name */
    public String f56579b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f56580c;

    /* renamed from: d  reason: collision with root package name */
    public int f56581d;

    /* renamed from: e  reason: collision with root package name */
    public String f56582e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f56577f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56578a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f56579b) ? "" : this.f56579b);
        f56577f.put(sb.toString(), this);
    }
}
