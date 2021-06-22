package d.a.o0.k1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f60571f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f60572a;

    /* renamed from: b  reason: collision with root package name */
    public String f60573b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f60574c;

    /* renamed from: d  reason: collision with root package name */
    public int f60575d;

    /* renamed from: e  reason: collision with root package name */
    public String f60576e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f60571f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f60572a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f60573b) ? "" : this.f60573b);
        f60571f.put(sb.toString(), this);
    }
}
