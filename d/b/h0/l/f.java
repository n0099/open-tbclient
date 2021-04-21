package d.b.h0.l;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49610a = b().isDebug();

    /* loaded from: classes3.dex */
    public static class a implements d.b.h0.l.a {
        @Override // d.b.h0.l.a
        public String a() {
            return "";
        }
    }

    @Inject(force = false)
    public static d.b.h0.l.a a() {
        return new a();
    }

    @Inject
    public static b b() {
        return d.b.h0.a.w0.b.b.a();
    }
}
