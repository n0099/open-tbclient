package d.a.j0.j1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f55870f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f55871a;

    /* renamed from: b  reason: collision with root package name */
    public String f55872b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f55873c;

    /* renamed from: d  reason: collision with root package name */
    public int f55874d;

    /* renamed from: e  reason: collision with root package name */
    public String f55875e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f55870f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f55871a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f55872b) ? "" : this.f55872b);
        f55870f.put(sb.toString(), this);
    }
}
