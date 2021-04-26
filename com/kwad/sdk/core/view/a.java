package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f33613a;

    public a(@NonNull Context context) {
        super(context);
        this.f33613a = new AtomicBoolean(true);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33613a = new AtomicBoolean(true);
    }

    private void c() {
        if (this.f33613a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("BasePvView", "onViewAttached");
            a();
        }
    }

    private void d() {
        if (this.f33613a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("BasePvView", "onViewDetached");
        b();
    }

    public abstract void a();

    public abstract void b();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
    }
}
