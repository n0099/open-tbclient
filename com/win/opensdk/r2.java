package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class r2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40313a;

    public r2(CloseParentView closeParentView) {
        this.f40313a = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s2 s2Var = this.f40313a.f40373g;
        if (s2Var != null) {
            ((t) s2Var).f40319a.finish();
        }
    }
}
