package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class PBBannerView extends FrameLayout implements PBBannerListener {
    private String java;
    private Context qbB;
    private ah qbC;
    private PBBannerListener qbD;
    private boolean qbE;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qbB = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.qbD = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.qbC == null) {
            this.qbC = new ah(this.qbB, this, this.java);
        }
        this.qbC.qbD = this;
        ah ahVar = this.qbC;
        try {
            ahVar.qcN.set(0);
            ahVar.qbE = false;
        } catch (Exception e) {
        }
        ahVar.eJL();
    }

    public boolean isVisible() {
        return this.qbE;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        eh(i, getVisibility());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        eh(getWindowVisibility(), getVisibility());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        eh(getWindowVisibility(), i);
    }

    private void eh(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.qbE = true;
                return;
            }
        }
        this.qbE = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.qbD != null) {
            this.qbD.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.qbD != null) {
            this.qbD.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.qbD != null) {
            this.qbD.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.qbD != null) {
            this.qbD.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.qbC != null) {
                ah ahVar = this.qbC;
                try {
                    if (ahVar.qbI != null) {
                        ahVar.qbI.eJL();
                    }
                    if (ahVar.qbS != null) {
                        ahVar.qbS.eJL();
                    }
                    if (ahVar.qcJ != null) {
                        ahVar.qcJ.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.qcK != null) {
                        ahVar.qcK.eJM();
                        ahVar.qcK = null;
                    }
                    if (ahVar.qbD != null) {
                        ahVar.qbD = null;
                    }
                } catch (Exception e) {
                }
                this.qbC = null;
            }
        } catch (Exception e2) {
        }
    }
}
