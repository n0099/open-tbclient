package d.g.b.a;

import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f70045a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f70046b;

    public m(InstallActivity installActivity) {
        this.f70046b = installActivity;
    }

    public void a(com.google.ar.core.p pVar) {
        synchronized (this.f70046b) {
            if (this.f70045a) {
                return;
            }
            InstallActivity.access$402(this.f70046b, pVar);
            int ordinal = pVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    InstallActivity.access$000(this.f70046b, new UnavailableUserDeclinedInstallationException());
                } else if (ordinal == 2) {
                    if (!InstallActivity.access$500(this.f70046b)) {
                        InstallActivity.access$600(this.f70046b);
                    }
                    InstallActivity.access$000(this.f70046b, null);
                }
                this.f70045a = true;
            }
        }
    }

    public void b(Exception exc) {
        synchronized (this.f70046b) {
            if (this.f70045a) {
                return;
            }
            this.f70045a = true;
            InstallActivity.access$402(this.f70046b, com.google.ar.core.p.CANCELLED);
            boolean z = exc instanceof UnavailableException;
            InstallActivity.access$000(this.f70046b, exc);
        }
    }
}
