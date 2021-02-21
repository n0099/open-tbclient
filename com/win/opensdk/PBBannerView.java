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
    private Context qjn;
    private ah qjo;
    private PBBannerListener qjp;
    private boolean qjq;

    public PBBannerView(@NonNull Context context) {
        this(context, null);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qjn = context;
    }

    public PBBannerView setPid(String str) {
        this.java = str;
        return this;
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.qjp = pBBannerListener;
        return this;
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        if (this.qjo == null) {
            this.qjo = new ah(this.qjn, this, this.java);
        }
        this.qjo.qjp = this;
        ah ahVar = this.qjo;
        try {
            ahVar.qkz.set(0);
            ahVar.qjq = false;
        } catch (Exception e) {
        }
        ahVar.eIX();
    }

    public boolean isVisible() {
        return this.qjq;
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
                this.qjq = true;
                return;
            }
        }
        this.qjq = false;
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (this.qjp != null) {
            this.qjp.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.qjp != null) {
            this.qjp.onLoaded();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        if (this.qjp != null) {
            this.qjp.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        if (this.qjp != null) {
            this.qjp.onClosed();
        }
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.qjo != null) {
                ah ahVar = this.qjo;
                try {
                    if (ahVar.qju != null) {
                        ahVar.qju.eIX();
                    }
                    if (ahVar.qjE != null) {
                        ahVar.qjE.eIX();
                    }
                    if (ahVar.qkv != null) {
                        ahVar.qkv.removeCallbacksAndMessages(null);
                    }
                    if (ahVar.qkw != null) {
                        ahVar.qkw.eIY();
                        ahVar.qkw = null;
                    }
                    if (ahVar.qjp != null) {
                        ahVar.qjp = null;
                    }
                } catch (Exception e) {
                }
                this.qjo = null;
            }
        } catch (Exception e2) {
        }
    }
}
