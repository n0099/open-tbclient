package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes7.dex */
public class PBBannerView extends FrameLayout implements PBBannerListener, d {

    /* renamed from: a  reason: collision with root package name */
    public Context f40131a;

    /* renamed from: b  reason: collision with root package name */
    public String f40132b;

    /* renamed from: c  reason: collision with root package name */
    public C f40133c;

    /* renamed from: d  reason: collision with root package name */
    public PBBannerListener f40134d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40135e;

    public PBBannerView(Context context) {
        this(context, null);
    }

    public PBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40131a = context;
    }

    public final void a(int i, int i2) {
        if (i == 0) {
            if ((i2 == 0) & hasWindowFocus()) {
                this.f40135e = true;
                return;
            }
        }
        this.f40135e = false;
    }

    public void destroy() {
        try {
            removeAllViews();
            if (this.f40133c != null) {
                this.f40133c.c();
                this.f40133c = null;
            }
        } catch (Exception unused) {
        }
    }

    public String getPid() {
        return this.f40132b;
    }

    public boolean isVisible() {
        return this.f40135e;
    }

    public void load() {
        if (this.f40133c == null) {
            this.f40133c = new C(this.f40131a, this, this.f40132b);
        }
        C c2 = this.f40133c;
        c2.f40025g = this;
        c2.d();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBBannerListener pBBannerListener = this.f40134d;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
        }
    }

    @Override // com.win.opensdk.PBBannerListener
    public void onClosed() {
        PBBannerListener pBBannerListener = this.f40134d;
        if (pBBannerListener != null) {
            pBBannerListener.onClosed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        PBBannerListener pBBannerListener = this.f40134d;
        if (pBBannerListener != null) {
            pBBannerListener.onFail(pBError);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        PBBannerListener pBBannerListener = this.f40134d;
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
        this.f40134d = pBBannerListener;
        return this;
    }

    public PBBannerView setPid(String str) {
        this.f40132b = str;
        return this;
    }
}
