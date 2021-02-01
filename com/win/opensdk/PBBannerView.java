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
    private Context qiN;
    private ah qiO;
    private PBBannerListener qiP;
    private boolean qiQ;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qiN = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.qiP = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.qiO == null) {
            this.qiO = new ah(this.qiN, this, this.java);
        }
        this.qiO.qiP = this;
        ah ahVar = this.qiO;
        try {
            ahVar.qjZ.set(0);
            ahVar.qiQ = false;
        } catch (Exception e) {
        }
        ahVar.eIP();
    }

    public boolean isVisible() {
        return this.qiQ;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        eg(i, getVisibility());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        eg(getWindowVisibility(), getVisibility());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        eg(getWindowVisibility(), i);
    }

    private void eg(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.qiQ = true;
                return;
            }
        }
        this.qiQ = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.qiP != null) {
            this.qiP.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.qiP != null) {
            this.qiP.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.qiP != null) {
            this.qiP.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.qiP != null) {
            this.qiP.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.qiO != null) {
                ah ahVar = this.qiO;
                try {
                    if (ahVar.qiU != null) {
                        ahVar.qiU.eIP();
                    }
                    if (ahVar.qje != null) {
                        ahVar.qje.eIP();
                    }
                    if (ahVar.qjV != null) {
                        ahVar.qjV.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.qjW != null) {
                        ahVar.qjW.eIQ();
                        ahVar.qjW = null;
                    }
                    if (ahVar.qiP != null) {
                        ahVar.qiP = null;
                    }
                } catch (Exception e) {
                }
                this.qiO = null;
            }
        } catch (Exception e2) {
        }
    }
}
