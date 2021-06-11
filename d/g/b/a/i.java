package d.g.b.a;

import android.view.View;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class i implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f69927e;

    public i(InstallActivity installActivity) {
        this.f69927e = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f69927e.animateToSpinner();
        this.f69927e.startInstaller();
    }
}
