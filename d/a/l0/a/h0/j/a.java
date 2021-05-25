package d.a.l0.a.h0.j;

import android.net.Uri;
import android.util.Log;
import d.a.l0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42203a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f42204b;

    static {
        HashSet hashSet = new HashSet();
        f42204b = hashSet;
        hashSet.add("https");
        f42204b.add("http");
        f42204b.add("sms");
        f42204b.add("tel");
    }

    @Override // d.a.l0.a.h0.j.d
    public void a(String str) {
    }

    @Override // d.a.l0.a.h0.j.d
    public void b(int i2) {
    }

    @Override // d.a.l0.a.h0.j.d
    public boolean c(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = f42204b.contains(parse.getScheme());
        if (f42203a) {
            StringBuilder sb = new StringBuilder();
            sb.append(contains ? "legal schemes : " : "illegal schemes : ");
            sb.append(parse.getScheme());
            Log.d("WebViewWidgetListener", sb.toString());
        }
        return !contains;
    }

    @Override // d.a.l0.a.h0.j.d
    public void d(int i2, String str, String str2) {
    }

    @Override // d.a.l0.a.h0.j.d
    public void e(String str) {
    }

    @Override // d.a.l0.a.h0.j.d
    public void goBack() {
    }
}
