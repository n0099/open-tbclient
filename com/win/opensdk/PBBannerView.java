package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes14.dex */
public class PBBannerView extends FrameLayout implements PBBannerListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f8099a;
    public String b;
    public l c;
    public PBBannerListener d;
    public boolean e;

    public PBBannerView(Context context) {
        this(context, null);
    }

    public PBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8099a = context;
    }

    public final void a(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.e = true;
                return;
            }
        }
        this.e = false;
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.c != null) {
                this.c.c();
                this.c = null;
            }
        } catch (Exception e) {
        }
    }

    public String getPid() {
        return this.b;
    }

    public boolean isVisible() {
        return this.e;
    }

    public void load() {
        if (this.c == null) {
            this.c = new l(this.f8099a, this, this.b);
        }
        l lVar = this.c;
        lVar.qkl = this;
        lVar.d();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBBannerListener pBBannerListener = this.d;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        PBBannerListener pBBannerListener = this.d;
        if (pBBannerListener != null) {
            pBBannerListener.onClosed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBBannerListener pBBannerListener = this.d;
        if (pBBannerListener != null) {
            pBBannerListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBBannerListener pBBannerListener = this.d;
        if (pBBannerListener != null) {
            pBBannerListener.onLoaded();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        a(getWindowVisibility(), i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(getWindowVisibility(), getVisibility());
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i, getVisibility());
    }

    public PBBannerView setListener(PBBannerListener pBBannerListener) {
        this.d = pBBannerListener;
        return this;
    }

    public PBBannerView setPid(String str) {
        this.b = str;
        return this;
    }
}
