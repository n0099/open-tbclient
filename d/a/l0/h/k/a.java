package d.a.l0.h.k;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.l0.a.l0.h;
@Service
/* loaded from: classes3.dex */
public class a implements h {

    /* renamed from: d.a.l0.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1028a {

        /* renamed from: a  reason: collision with root package name */
        public static String f47416a;

        public static String a() {
            if (TextUtils.isEmpty(f47416a)) {
                f47416a = d.a.l0.a.s2.b.c();
            }
            return f47416a;
        }
    }

    @Override // d.a.l0.a.l0.h
    public String a() {
        return C1028a.a();
    }

    @Override // d.a.l0.a.l0.h
    public d.a.l0.a.l0.a b(String str, d.a.l0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new b(str, bVar, v8ThreadDelegatePolicy);
    }
}
