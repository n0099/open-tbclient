package d.g.b.a;

import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66919a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66920b;

    public m(InstallActivity installActivity) {
        this.f66920b = installActivity;
    }

    public void a(com.google.ar.core.p pVar) {
        synchronized (this.f66920b) {
            if (this.f66919a) {
                return;
            }
            InstallActivity.access$402(this.f66920b, pVar);
            int ordinal = pVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    InstallActivity.access$000(this.f66920b, new UnavailableUserDeclinedInstallationException());
                } else if (ordinal == 2) {
                    if (!InstallActivity.access$500(this.f66920b)) {
                        InstallActivity.access$600(this.f66920b);
                    }
                    InstallActivity.access$000(this.f66920b, null);
                }
                this.f66919a = true;
            }
        }
    }

    public void b(Exception exc) {
        synchronized (this.f66920b) {
            if (this.f66919a) {
                return;
            }
            this.f66919a = true;
            InstallActivity.access$402(this.f66920b, com.google.ar.core.p.CANCELLED);
            boolean z = exc instanceof UnavailableException;
            InstallActivity.access$000(this.f66920b, exc);
        }
    }
}
