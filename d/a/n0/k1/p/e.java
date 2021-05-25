package d.a.n0.k1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f56757f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f56758a;

    /* renamed from: b  reason: collision with root package name */
    public String f56759b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f56760c;

    /* renamed from: d  reason: collision with root package name */
    public int f56761d;

    /* renamed from: e  reason: collision with root package name */
    public String f56762e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f56757f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56758a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f56759b) ? "" : this.f56759b);
        f56757f.put(sb.toString(), this);
    }
}
