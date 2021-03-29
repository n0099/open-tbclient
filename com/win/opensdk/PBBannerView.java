package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class PBBannerView extends FrameLayout implements PBBannerListener, d {

    /* renamed from: a  reason: collision with root package name */
    public Context f39747a;

    /* renamed from: b  reason: collision with root package name */
    public String f39748b;

    /* renamed from: c  reason: collision with root package name */
    public C f39749c;

    /* renamed from: d  reason: collision with root package name */
    public PBBannerListener f39750d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39751e;

    public PBBannerView(Context context) {
        this(context, null);
    }

    public PBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39747a = context;
    }

    public final void a(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.f39751e = true;
                return;
            }
        }
        this.f39751e = false;
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.f39749c != null) {
                this.f39749c.c();
                this.f39749c = null;
            }
        } catch (Exception unused) {
        }
    }

    public String getPid() {
        return this.f39748b;
    }

    public boolean isVisible() {
        return this.f39751e;
    }

    public void load() {
        if (this.f39749c == null) {
            this.f39749c = new C(this.f39747a, this, this.f39748b);
        }
        C c2 = this.f39749c;
        c2.f39641g = this;
        c2.d();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBBannerListener pBBannerListener = this.f39750d;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        PBBannerListener pBBannerListener = this.f39750d;
        if (pBBannerListener != null) {
            pBBannerListener.onClosed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBBannerListener pBBannerListener = this.f39750d;
        if (pBBannerListener != null) {
            pBBannerListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBBannerListener pBBannerListener = this.f39750d;
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
        this.f39750d = pBBannerListener;
        return this;
    }

    public PBBannerView setPid(String str) {
        this.f39748b = str;
        return this;
    }
}
