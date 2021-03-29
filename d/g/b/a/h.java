package d.g.b.a;

import android.view.View;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public final class h implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66059e;

    public h(InstallActivity installActivity) {
        this.f66059e = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f66059e.finishWithFailure(new UnavailableUserDeclinedInstallationException());
    }
}
