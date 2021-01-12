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
    private Context pYI;
    private ah pYJ;
    private PBBannerListener pYK;
    private boolean pYL;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pYI = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.pYK = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.pYJ == null) {
            this.pYJ = new ah(this.pYI, this, this.java);
        }
        this.pYJ.pYK = this;
        ah ahVar = this.pYJ;
        try {
            ahVar.pZU.set(0);
            ahVar.pYL = false;
        } catch (Exception e) {
        }
        ahVar.eGz();
    }

    public boolean isVisible() {
        return this.pYL;
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
                this.pYL = true;
                return;
            }
        }
        this.pYL = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.pYK != null) {
            this.pYK.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.pYK != null) {
            this.pYK.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.pYK != null) {
            this.pYK.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.pYK != null) {
            this.pYK.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.pYJ != null) {
                ah ahVar = this.pYJ;
                try {
                    if (ahVar.pYP != null) {
                        ahVar.pYP.eGz();
                    }
                    if (ahVar.pYZ != null) {
                        ahVar.pYZ.eGz();
                    }
                    if (ahVar.pZQ != null) {
                        ahVar.pZQ.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.pZR != null) {
                        ahVar.pZR.eGA();
                        ahVar.pZR = null;
                    }
                    if (ahVar.pYK != null) {
                        ahVar.pYK = null;
                    }
                } catch (Exception e) {
                }
                this.pYJ = null;
            }
        } catch (Exception e2) {
        }
    }
}
