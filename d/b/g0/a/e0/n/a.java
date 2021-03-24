package d.b.g0.a.e0.n;

import android.net.Uri;
import android.util.Log;
import d.b.g0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44096a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f44097b;

    static {
        HashSet hashSet = new HashSet();
        f44097b = hashSet;
        hashSet.add("https");
        f44097b.add("http");
        f44097b.add("sms");
        f44097b.add("tel");
    }

    @Override // d.b.g0.a.e0.n.d
    public void a(String str) {
    }

    @Override // d.b.g0.a.e0.n.d
    public boolean b(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = f44097b.contains(parse.getScheme());
        if (f44096a) {
            StringBuilder sb = new StringBuilder();
            sb.append(contains ? "legal schemes : " : "illegal schemes : ");
            sb.append(parse.getScheme());
            Log.d("WebViewWidgetListener", sb.toString());
        }
        return !contains;
    }

    @Override // d.b.g0.a.e0.n.d
    public void c(int i, String str, String str2) {
    }

    @Override // d.b.g0.a.e0.n.d
    public void d(String str) {
    }

    @Override // d.b.g0.a.e0.n.d
    public void goBack() {
    }
}
