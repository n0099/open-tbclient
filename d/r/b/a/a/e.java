package d.r.b.a.a;

import android.content.Context;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67642a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public final <T> T a(Class<T> cls, int i2, int i3, String str, String str2, String str3, String str4, boolean z, boolean z2, d.r.b.a.a.f.c.d dVar, Context context, IReporter iReporter, d.r.b.a.a.f.f.b bVar) {
            try {
                return (T) cls.getClassLoader().loadClass(cls.getCanonicalName() + "$$Binder").getMethod("coCreateInstance", Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE, d.r.b.a.a.f.c.d.class, Context.class, IReporter.class, d.r.b.a.a.f.f.b.class).invoke(null, Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), dVar, context, iReporter, bVar);
            } catch (Exception e2) {
                d.r.b.a.a.f.d.d.h("ServiceInstanceCreater", "newInstance Service fail, " + e2);
                return null;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
