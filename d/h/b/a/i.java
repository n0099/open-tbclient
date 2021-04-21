package d.h.b.a;

import android.view.View;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class i implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f67052e;

    public i(InstallActivity installActivity) {
        this.f67052e = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f67052e.animateToSpinner();
        this.f67052e.startInstaller();
    }
}
