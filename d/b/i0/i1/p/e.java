package d.b.i0.i1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f56029f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f56030a;

    /* renamed from: b  reason: collision with root package name */
    public String f56031b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f56032c;

    /* renamed from: d  reason: collision with root package name */
    public int f56033d;

    /* renamed from: e  reason: collision with root package name */
    public String f56034e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f56029f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56030a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f56031b) ? "" : this.f56031b);
        f56029f.put(sb.toString(), this);
    }
}
