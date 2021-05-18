package d.a.i0.a.h0.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import d.a.i0.a.a2.e;
import d.a.i0.a.h;
import d.a.i0.a.p.d.n;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public static class a implements n.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f41790a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f41791b;

        public a(Context context, b bVar) {
            this.f41790a = context;
            this.f41791b = bVar;
        }

        @Override // d.a.i0.a.p.d.n.b
        public void a(boolean z) {
            if (!z) {
                d.a.i0.a.e0.d.b("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                this.f41791b.a(false, this.f41790a.getString(h.aiapps_authenticate_fail));
                return;
            }
            d.a.i0.a.e0.d.b("DeveloperAuthenticateHelper", "Authentication Success");
            this.f41791b.a(true, "");
        }

        @Override // d.a.i0.a.p.d.n.b
        public void b(Exception exc) {
            String str;
            d.a.i0.a.e0.d.c("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
            String message = exc.getMessage();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f41790a.getString(h.aiapps_authenticate_fail));
            if (TextUtils.isEmpty(message)) {
                str = "";
            } else {
                str = "\n" + message;
            }
            sb.append(str);
            this.f41791b.a(false, sb.toString());
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull e eVar, @NonNull Context context, @NonNull b bVar) {
        d.a.i0.a.m.b.b(eVar.D(), new a(context, bVar));
    }

    public static void b(Context context, @StringRes int i2, String str) {
        h.a aVar = new h.a(context);
        aVar.U(i2);
        aVar.x(str);
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.O(d.a.i0.a.h.aiapps_confirm, null);
        aVar.X();
    }

    public static void c(Context context, String str) {
        b(context, d.a.i0.a.h.aiapps_debug_switch_title, str);
    }
}
