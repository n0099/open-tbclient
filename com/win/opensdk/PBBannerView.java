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
    private Context qdj;
    private ah qdk;
    private PBBannerListener qdl;
    private boolean qdm;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qdj = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.qdl = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.qdk == null) {
            this.qdk = new ah(this.qdj, this, this.java);
        }
        this.qdk.qdl = this;
        ah ahVar = this.qdk;
        try {
            ahVar.qev.set(0);
            ahVar.qdm = false;
        } catch (Exception e) {
        }
        ahVar.eKp();
    }

    public boolean isVisible() {
        return this.qdm;
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
                this.qdm = true;
                return;
            }
        }
        this.qdm = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.qdl != null) {
            this.qdl.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.qdl != null) {
            this.qdl.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.qdl != null) {
            this.qdl.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.qdl != null) {
            this.qdl.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.qdk != null) {
                ah ahVar = this.qdk;
                try {
                    if (ahVar.qdq != null) {
                        ahVar.qdq.eKp();
                    }
                    if (ahVar.qdA != null) {
                        ahVar.qdA.eKp();
                    }
                    if (ahVar.qer != null) {
                        ahVar.qer.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.qes != null) {
                        ahVar.qes.eKq();
                        ahVar.qes = null;
                    }
                    if (ahVar.qdl != null) {
                        ahVar.qdl = null;
                    }
                } catch (Exception e) {
                }
                this.qdk = null;
            }
        } catch (Exception e2) {
        }
    }
}
