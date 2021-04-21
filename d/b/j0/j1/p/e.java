package d.b.j0.j1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f57898f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f57899a;

    /* renamed from: b  reason: collision with root package name */
    public String f57900b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f57901c;

    /* renamed from: d  reason: collision with root package name */
    public int f57902d;

    /* renamed from: e  reason: collision with root package name */
    public String f57903e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f57898f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f57899a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f57900b) ? "" : this.f57900b);
        f57898f.put(sb.toString(), this);
    }
}
