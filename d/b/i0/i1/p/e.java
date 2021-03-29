package d.b.i0.i1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f56030f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f56031a;

    /* renamed from: b  reason: collision with root package name */
    public String f56032b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f56033c;

    /* renamed from: d  reason: collision with root package name */
    public int f56034d;

    /* renamed from: e  reason: collision with root package name */
    public String f56035e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f56030f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f56031a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f56032b) ? "" : this.f56032b);
        f56030f.put(sb.toString(), this);
    }
}
