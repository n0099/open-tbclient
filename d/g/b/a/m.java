package d.g.b.a;

import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66074a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66075b;

    public m(InstallActivity installActivity) {
        this.f66075b = installActivity;
    }

    public void a(com.google.ar.core.p pVar) {
        synchronized (this.f66075b) {
            if (this.f66074a) {
                return;
            }
            InstallActivity.access$402(this.f66075b, pVar);
            int ordinal = pVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    InstallActivity.access$000(this.f66075b, new UnavailableUserDeclinedInstallationException());
                } else if (ordinal == 2) {
                    if (!InstallActivity.access$500(this.f66075b)) {
                        InstallActivity.access$600(this.f66075b);
                    }
                    InstallActivity.access$000(this.f66075b, null);
                }
                this.f66074a = true;
            }
        }
    }

    public void b(Exception exc) {
        synchronized (this.f66075b) {
            if (this.f66074a) {
                return;
            }
            this.f66074a = true;
            InstallActivity.access$402(this.f66075b, com.google.ar.core.p.CANCELLED);
            boolean z = exc instanceof UnavailableException;
            InstallActivity.access$000(this.f66075b, exc);
        }
    }
}
