package d.a.h0.a.e0.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.h0.a.h;
import d.a.h0.a.p.c.e;
import d.a.h0.a.q1.b.b.g;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f41934b;

        public a(Context context, b bVar) {
            this.f41933a = context;
            this.f41934b = bVar;
        }

        @Override // d.a.h0.a.p.c.e.a
        public void a(Exception exc) {
            String str;
            d.a.h0.a.c0.c.c("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
            String message = exc.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f41933a.getString(h.aiapps_authenticate_fail));
            if (TextUtils.isEmpty(message)) {
                str = "";
            } else {
                str = "\n" + message;
            }
            sb.append(str);
            this.f41934b.a(false, sb.toString());
        }

        @Override // d.a.h0.a.p.c.e.a
        public void b(boolean z) {
            if (!z) {
                d.a.h0.a.c0.c.b("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                this.f41934b.a(false, this.f41933a.getString(h.aiapps_authenticate_fail));
                return;
            }
            d.a.h0.a.c0.c.b("DeveloperAuthenticateHelper", "Authentication Success");
            this.f41934b.a(true, "");
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull d.a.h0.a.r1.e eVar, @NonNull Context context, @NonNull b bVar) {
        d.a.h0.a.m.b.b(eVar.B(), new a(context, bVar));
    }

    public static void b(Context context, String str) {
        g.a aVar = new g.a(context);
        aVar.V(context.getString(h.aiapps_debug_switch_title));
        aVar.y(str);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.O(h.aiapps_confirm, null);
        aVar.X();
    }
}
