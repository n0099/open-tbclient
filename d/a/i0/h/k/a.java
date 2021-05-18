package d.a.i0.h.k;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.i0.a.l0.h;
@Service
/* loaded from: classes3.dex */
public class a implements h {

    /* renamed from: d.a.i0.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1017a {

        /* renamed from: a  reason: collision with root package name */
        public static String f47240a;

        public static String a() {
            if (TextUtils.isEmpty(f47240a)) {
                f47240a = d.a.i0.a.s2.b.c();
            }
            return f47240a;
        }
    }

    @Override // d.a.i0.a.l0.h
    public String a() {
        return C1017a.a();
    }

    @Override // d.a.i0.a.l0.h
    public d.a.i0.a.l0.a b(String str, d.a.i0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new b(str, bVar, v8ThreadDelegatePolicy);
    }
}
