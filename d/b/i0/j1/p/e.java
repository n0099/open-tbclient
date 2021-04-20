package d.b.i0.j1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f57477f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public long f57478a;

    /* renamed from: b  reason: collision with root package name */
    public String f57479b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f57480c;

    /* renamed from: d  reason: collision with root package name */
    public int f57481d;

    /* renamed from: e  reason: collision with root package name */
    public String f57482e;

    public static e a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        return f57477f.get(sb.toString());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f57478a);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.f57479b) ? "" : this.f57479b);
        f57477f.put(sb.toString(), this);
    }
}
