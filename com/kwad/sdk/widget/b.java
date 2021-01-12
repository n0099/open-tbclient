package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.an;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.feed.widget.base.b {

    /* renamed from: a  reason: collision with root package name */
    private long f10854a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10855b;
    private boolean c;
    private int d;
    private ViewTreeObserver.OnScrollChangedListener e;
    private ViewTreeObserver f;
    private an g;

    public b(@NonNull Context context) {
        super(context);
        this.f10854a = 500L;
        this.c = true;
        b();
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10854a = 500L;
        this.c = true;
        b();
    }

    private void b() {
        this.g = new an(this);
        this.d = ah.h(getContext());
        this.c = d();
    }

    private void c() {
        if (g()) {
            a();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.g.a() && ((float) Math.abs(this.g.f10804a.height() - getHeight())) <= ((float) getHeight()) * 0.9f && getHeight() > 0 && getWidth() > 0 && this.g.f10804a.bottom > 0 && this.g.f10804a.top < this.d;
    }

    private void h() {
        if (this.e == null) {
            this.e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.b.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (b.this.g()) {
                        b.this.a();
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
        f();
    }

    protected boolean d() {
        return true;
    }

    protected void e() {
        if (this.c) {
            c();
        }
    }

    protected void f() {
        try {
            if (this.e == null || this.f == null) {
                return;
            }
            this.f.removeOnScrollChangedListener(this.e);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        this.f10855b = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.f10855b || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.f10855b = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            e();
        }
    }
}
