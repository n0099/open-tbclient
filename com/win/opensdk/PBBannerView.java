package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class PBBannerView extends FrameLayout implements PBBannerListener {
    private String java;
    private Context pYJ;
    private ah pYK;
    private PBBannerListener pYL;
    private boolean pYM;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pYJ = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.pYL = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.pYK == null) {
            this.pYK = new ah(this.pYJ, this, this.java);
        }
        this.pYK.pYL = this;
        ah ahVar = this.pYK;
        try {
            ahVar.pZV.set(0);
            ahVar.pYM = false;
        } catch (Exception e) {
        }
        ahVar.eGz();
    }

    public boolean isVisible() {
        return this.pYM;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ej(i, getVisibility());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ej(getWindowVisibility(), getVisibility());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        ej(getWindowVisibility(), i);
    }

    private void ej(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.pYM = true;
                return;
            }
        }
        this.pYM = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.pYL != null) {
            this.pYL.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.pYL != null) {
            this.pYL.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.pYL != null) {
            this.pYL.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.pYL != null) {
            this.pYL.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.pYK != null) {
                ah ahVar = this.pYK;
                try {
                    if (ahVar.pYQ != null) {
                        ahVar.pYQ.eGz();
                    }
                    if (ahVar.pZa != null) {
                        ahVar.pZa.eGz();
                    }
                    if (ahVar.pZR != null) {
                        ahVar.pZR.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.pZS != null) {
                        ahVar.pZS.eGA();
                        ahVar.pZS = null;
                    }
                    if (ahVar.pYL != null) {
                        ahVar.pYL = null;
                    }
                } catch (Exception e) {
                }
                this.pYK = null;
            }
        } catch (Exception e2) {
        }
    }
}
