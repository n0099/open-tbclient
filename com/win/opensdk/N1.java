package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class N1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f36889a;

    public N1(CloseParentView closeParentView) {
        this.f36889a = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        O1 o1 = this.f36889a.f37151g;
        if (o1 != null) {
            ((t) o1).f37121a.finish();
        }
    }
}
