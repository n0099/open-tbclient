package d.a.m0.a.h0.j;

import android.net.Uri;
import android.util.Log;
import d.a.m0.a.k;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45987a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45988b;

    static {
        HashSet hashSet = new HashSet();
        f45988b = hashSet;
        hashSet.add("https");
        f45988b.add("http");
        f45988b.add("sms");
        f45988b.add("tel");
    }

    @Override // d.a.m0.a.h0.j.d
    public void a(String str) {
    }

    @Override // d.a.m0.a.h0.j.d
    public void b(int i2) {
    }

    @Override // d.a.m0.a.h0.j.d
    public boolean c(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return true;
        }
        boolean contains = f45988b.contains(parse.getScheme());
        if (f45987a) {
            StringBuilder sb = new StringBuilder();
            sb.append(contains ? "legal schemes : " : "illegal schemes : ");
            sb.append(parse.getScheme());
            Log.d("WebViewWidgetListener", sb.toString());
        }
        return !contains;
    }

    @Override // d.a.m0.a.h0.j.d
    public void d(int i2, String str, String str2) {
    }

    @Override // d.a.m0.a.h0.j.d
    public void e(String str) {
    }

    @Override // d.a.m0.a.h0.j.d
    public void goBack() {
    }
}
