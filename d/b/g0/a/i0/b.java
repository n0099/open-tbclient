package d.b.g0.a.i0;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.b.g0.g.i.e;
import d.b.g0.g.i.i;
/* loaded from: classes3.dex */
public class b implements i {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static String f44615a;

        public static String a() {
            if (TextUtils.isEmpty(f44615a)) {
                f44615a = d.b.g0.a.g2.b.c();
            }
            return f44615a;
        }
    }

    @Override // d.b.g0.g.i.i
    public d.b.g0.g.i.a a(String str, d.b.g0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // d.b.g0.g.i.i
    public String b() {
        return a.a();
    }
}
