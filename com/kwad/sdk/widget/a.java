package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.an;
/* loaded from: classes3.dex */
public class a extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private long f10853a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10854b;
    private boolean c;
    private int d;
    private ViewTreeObserver.OnScrollChangedListener e;
    private ViewTreeObserver f;
    private an g;
    private InterfaceC1154a h;

    /* renamed from: com.kwad.sdk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1154a {
        void a();
    }

    public a(@NonNull Context context) {
        super(context);
        this.f10853a = 500L;
        this.c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10853a = 500L;
        this.c = true;
        b();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10853a = 500L;
        this.c = true;
        b();
    }

    private void b() {
        this.g = new an(this);
        this.d = ah.h(getContext());
        this.c = i();
    }

    private void c() {
        if (d()) {
            a();
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.g.a() && ((float) Math.abs(this.g.f10806a.height() - getHeight())) <= ((float) getHeight()) * 0.9f && getHeight() > 0 && getWidth() > 0 && this.g.f10806a.bottom > 0 && this.g.f10806a.top < this.d;
    }

    private void e() {
        if (this.e == null) {
            this.e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.a.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (a.this.d()) {
                        a.this.a();
                    }
                }
            };
            this.f = getViewTreeObserver();
            if (this.f != null) {
                this.f.addOnScrollChangedListener(this.e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        k();
        if (this.h != null) {
            this.h.a();
        }
    }

    protected boolean i() {
        return true;
    }

    protected void j() {
        if (this.c) {
            c();
        }
    }

    protected void k() {
        try {
            if (this.e != null && this.f != null && this.f.isAlive()) {
                this.f.removeOnScrollChangedListener(this.e);
            }
            this.e = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public void l() {
        k();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
        this.f10854b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f10854b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f10854b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            j();
        }
    }

    public void setVisibleListener(InterfaceC1154a interfaceC1154a) {
        this.h = interfaceC1154a;
    }
}
