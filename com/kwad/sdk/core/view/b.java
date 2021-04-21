package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f34639a;

    public b(@NonNull Context context) {
        super(context);
        this.f34639a = new AtomicBoolean(true);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34639a = new AtomicBoolean(true);
    }

    private void c() {
        if (this.f34639a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("BasePvView", "onViewAttached");
            a();
        }
    }

    private void d() {
        if (this.f34639a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("BasePvView", "onViewDetached");
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
