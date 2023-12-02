package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class a extends KSFrameLayout {
    public final DialogFragment Lh;
    public final View Li;
    public a.C0644a Lj;

    public a(@NonNull Context context, DialogFragment dialogFragment, a.C0644a c0644a) {
        super(context);
        this.Lh = dialogFragment;
        this.Lj = c0644a;
        l.inflate(context, R.layout.obfuscated_res_0x7f0d0510, this);
        this.Li = findViewById(R.id.obfuscated_res_0x7f09149b);
    }

    public static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c og() {
        c cVar = new c();
        cVar.Lh = this.Lh;
        cVar.Lj = this.Lj;
        return cVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        Presenter af = af();
        af.G(this.Li);
        af.k(og());
    }
}
