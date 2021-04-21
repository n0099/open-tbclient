package d.h.b.a;

import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f67066a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f67067b;

    public m(InstallActivity installActivity) {
        this.f67067b = installActivity;
    }

    public void a(com.google.ar.core.p pVar) {
        synchronized (this.f67067b) {
            if (this.f67066a) {
                return;
            }
            InstallActivity.access$402(this.f67067b, pVar);
            int ordinal = pVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    InstallActivity.access$000(this.f67067b, new UnavailableUserDeclinedInstallationException());
                } else if (ordinal == 2) {
                    if (!InstallActivity.access$500(this.f67067b)) {
                        InstallActivity.access$600(this.f67067b);
                    }
                    InstallActivity.access$000(this.f67067b, null);
                }
                this.f67066a = true;
            }
        }
    }

    public void b(Exception exc) {
        synchronized (this.f67067b) {
            if (this.f67066a) {
                return;
            }
            this.f67066a = true;
            InstallActivity.access$402(this.f67067b, com.google.ar.core.p.CANCELLED);
            boolean z = exc instanceof UnavailableException;
            InstallActivity.access$000(this.f67067b, exc);
        }
    }
}
