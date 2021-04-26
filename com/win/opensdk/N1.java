package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class N1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f37715a;

    public N1(CloseParentView closeParentView) {
        this.f37715a = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        O1 o1 = this.f37715a.f37977g;
        if (o1 != null) {
            ((t) o1).f37947a.finish();
        }
    }
}
