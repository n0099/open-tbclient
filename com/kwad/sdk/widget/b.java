package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.an;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.widget.base.b {

    /* renamed from: a  reason: collision with root package name */
    public long f37690a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37692c;

    /* renamed from: d  reason: collision with root package name */
    public int f37693d;

    /* renamed from: e  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f37694e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver f37695f;

    /* renamed from: g  reason: collision with root package name */
    public an f37696g;

    public b(@NonNull Context context) {
        super(context);
        this.f37690a = 500L;
        this.f37692c = true;
        b();
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37690a = 500L;
        this.f37692c = true;
        b();
    }

    private void b() {
        this.f37696g = new an(this);
        this.f37693d = ah.h(getContext());
        this.f37692c = d();
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
        if (!this.f37696g.a() || Math.abs(this.f37696g.f37606a.height() - getHeight()) > getHeight() * 0.9f || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.f37696g.f37606a;
        return rect.bottom > 0 && rect.top < this.f37693d;
    }

    private void h() {
        if (this.f37694e == null) {
            this.f37694e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.b.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (b.this.g()) {
                        b.this.a();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f37695f = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f37694e);
            }
        }
    }

    public void a() {
        f();
    }

    public boolean d() {
        return true;
    }

    public void e() {
        if (this.f37692c) {
            c();
        }
    }

    public void f() {
        try {
            if (this.f37694e == null || this.f37695f == null) {
                return;
            }
            this.f37695f.removeOnScrollChangedListener(this.f37694e);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        this.f37691b = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z = true;
        if (this.f37691b || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z = false;
        } else {
            this.f37691b = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z) {
            e();
        }
    }
}
