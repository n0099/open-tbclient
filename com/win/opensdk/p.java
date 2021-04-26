package com.win.opensdk;
/* loaded from: classes6.dex */
public class p implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f37917a;

    public p(q qVar) {
        this.f37917a = qVar;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        r rVar = this.f37917a.f37921b;
        if (rVar != null) {
            rVar.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        r rVar = this.f37917a.f37921b;
        if (rVar != null) {
            rVar.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        r rVar = this.f37917a.f37921b;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        r rVar = this.f37917a.f37921b;
        if (rVar != null) {
            rVar.onLoaded();
        }
    }
}
