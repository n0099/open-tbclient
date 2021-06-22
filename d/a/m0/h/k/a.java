package d.a.m0.h.k;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.m0.a.l0.h;
@Service
/* loaded from: classes3.dex */
public class a implements h {

    /* renamed from: d.a.m0.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1087a {

        /* renamed from: a  reason: collision with root package name */
        public static String f51198a;

        public static String a() {
            if (TextUtils.isEmpty(f51198a)) {
                f51198a = d.a.m0.a.s2.b.c();
            }
            return f51198a;
        }
    }

    @Override // d.a.m0.a.l0.h
    public String a() {
        return C1087a.a();
    }

    @Override // d.a.m0.a.l0.h
    public d.a.m0.a.l0.a b(String str, d.a.m0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new b(str, bVar, v8ThreadDelegatePolicy);
    }
}
