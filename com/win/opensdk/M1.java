package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class M1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f37708a;

    public M1(CloseParentView closeParentView) {
        this.f37708a = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f37708a.a();
    }
}
