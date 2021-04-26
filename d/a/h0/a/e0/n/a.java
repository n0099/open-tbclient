package d.a.h0.a.e0.n;

import android.net.Uri;
import android.util.Log;
import d.a.h0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42117a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f42118b;

    static {
        HashSet hashSet = new HashSet();
        f42118b = hashSet;
        hashSet.add("https");
        f42118b.add("http");
        f42118b.add("sms");
        f42118b.add("tel");
    }

    @Override // d.a.h0.a.e0.n.d
    public void a(String str) {
    }

    @Override // d.a.h0.a.e0.n.d
    public boolean b(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = f42118b.contains(parse.getScheme());
        if (f42117a) {
            StringBuilder sb = new StringBuilder();
            sb.append(contains ? "legal schemes : " : "illegal schemes : ");
            sb.append(parse.getScheme());
            Log.d("WebViewWidgetListener", sb.toString());
        }
        return !contains;
    }

    @Override // d.a.h0.a.e0.n.d
    public void c(int i2, String str, String str2) {
    }

    @Override // d.a.h0.a.e0.n.d
    public void d(String str) {
    }

    @Override // d.a.h0.a.e0.n.d
    public void goBack() {
    }
}
