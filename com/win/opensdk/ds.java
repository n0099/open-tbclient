package com.win.opensdk;
/* loaded from: classes14.dex */
public class ds implements az {
    public final /* synthetic */ ay qlV;

    public ds(ay ayVar) {
        this.qlV = ayVar;
    }

    @Override // com.win.opensdk.az
    public void b(boolean z, long j) {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.b(z, j);
        }
    }

    @Override // com.win.opensdk.az
    public void bb(String str) {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.bb(str);
        }
    }

    @Override // com.win.opensdk.az
    public void ht() {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.ht();
        }
    }

    @Override // com.win.opensdk.az
    public void hu() {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.hu();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.onClicked();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        az azVar = this.qlV.qkW;
        if (azVar != null) {
            azVar.onLoaded();
        }
    }
}
