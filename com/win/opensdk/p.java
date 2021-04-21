package com.win.opensdk;
/* loaded from: classes7.dex */
public class p implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f40388a;

    public p(q qVar) {
        this.f40388a = qVar;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        r rVar = this.f40388a.f40401b;
        if (rVar != null) {
            rVar.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        r rVar = this.f40388a.f40401b;
        if (rVar != null) {
            rVar.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        r rVar = this.f40388a.f40401b;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        r rVar = this.f40388a.f40401b;
        if (rVar != null) {
            rVar.onLoaded();
        }
    }
}
