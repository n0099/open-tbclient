package d.g.b.a;

import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65481a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f65482b;

    public m(InstallActivity installActivity) {
        this.f65482b = installActivity;
    }

    public void a(com.google.ar.core.p pVar) {
        synchronized (this.f65482b) {
            if (this.f65481a) {
                return;
            }
            InstallActivity.access$402(this.f65482b, pVar);
            int ordinal = pVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    InstallActivity.access$000(this.f65482b, new UnavailableUserDeclinedInstallationException());
                } else if (ordinal == 2) {
                    if (!InstallActivity.access$500(this.f65482b)) {
                        InstallActivity.access$600(this.f65482b);
                    }
                    InstallActivity.access$000(this.f65482b, null);
                }
                this.f65481a = true;
            }
        }
    }

    public void b(Exception exc) {
        synchronized (this.f65482b) {
            if (this.f65481a) {
                return;
            }
            this.f65481a = true;
            InstallActivity.access$402(this.f65482b, com.google.ar.core.p.CANCELLED);
            boolean z = exc instanceof UnavailableException;
            InstallActivity.access$000(this.f65482b, exc);
        }
    }
}
