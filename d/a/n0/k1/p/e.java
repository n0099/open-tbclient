package d.a.n0.k1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f60446f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f60447a;

    /* renamed from: b  reason: collision with root package name */
    public String f60448b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f60449c;

    /* renamed from: d  reason: collision with root package name */
    public int f60450d;

    /* renamed from: e  reason: collision with root package name */
    public String f60451e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f60446f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f60447a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f60448b) ? "" : this.f60448b);
        f60446f.put(sb.toString(), this);
    }
}
