package d.b.g0.a.e0.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.h;
import d.b.g0.a.p.c.e;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f43915b;

        public a(Context context, b bVar) {
            this.f43914a = context;
            this.f43915b = bVar;
        }

        @Override // d.b.g0.a.p.c.e.a
        public void a(boolean z) {
            if (!z) {
                d.b.g0.a.c0.c.b("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                this.f43915b.a(false, this.f43914a.getString(h.aiapps_authenticate_fail));
                return;
            }
            d.b.g0.a.c0.c.b("DeveloperAuthenticateHelper", "Authentication Success");
            this.f43915b.a(true, "");
        }

        @Override // d.b.g0.a.p.c.e.a
        public void b(Exception exc) {
            String str;
            d.b.g0.a.c0.c.c("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
            String message = exc.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f43914a.getString(h.aiapps_authenticate_fail));
            if (TextUtils.isEmpty(message)) {
                str = "";
            } else {
                str = "\n" + message;
            }
            sb.append(str);
            this.f43915b.a(false, sb.toString());
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull d.b.g0.a.r1.e eVar, @NonNull Context context, @NonNull b bVar) {
        d.b.g0.a.m.b.b(eVar.B(), new a(context, bVar));
    }

    public static void b(Context context, String str) {
        g.a aVar = new g.a(context);
        aVar.V(context.getString(h.aiapps_debug_switch_title));
        aVar.y(str);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.O(h.aiapps_confirm, null);
        aVar.X();
    }
}
