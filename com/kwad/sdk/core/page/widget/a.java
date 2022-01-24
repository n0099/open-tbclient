package com.kwad.sdk.core.page.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class a extends View implements bc.a {
    public InterfaceC2115a a;

    /* renamed from: b  reason: collision with root package name */
    public View f56044b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56045c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56046d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56047e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f56048f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f56049g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2115a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f56048f = new bc(this);
        this.f56049g = new AtomicBoolean(true);
        this.f56044b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC2115a interfaceC2115a;
        if (!this.f56049g.getAndSet(false) || (interfaceC2115a = this.a) == null) {
            return;
        }
        interfaceC2115a.a();
    }

    private void b() {
        InterfaceC2115a interfaceC2115a;
        if (this.f56049g.getAndSet(true) || (interfaceC2115a = this.a) == null) {
            return;
        }
        interfaceC2115a.b();
    }

    private void c() {
        if (this.f56046d) {
            this.f56048f.removeCallbacksAndMessages(null);
            this.f56046d = false;
        }
    }

    private void d() {
        if (!this.f56047e || this.f56046d) {
            return;
        }
        this.f56046d = true;
        this.f56048f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC2115a interfaceC2115a;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bb.a(this.f56044b, 30, false)) {
                if (this.f56045c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC2115a = this.a) != null) {
                interfaceC2115a.a(this.f56044b);
            }
            this.f56048f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f56046d) {
            if (!bb.a(this.f56044b, 30, false)) {
                this.f56048f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f56048f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f56048f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f56045c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f56045c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f56044b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f56044b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC2115a interfaceC2115a = this.a;
        if (interfaceC2115a != null) {
            interfaceC2115a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f56047e = z;
        if (!z && this.f56046d) {
            c();
        } else if (!z || this.f56046d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC2115a interfaceC2115a) {
        this.a = interfaceC2115a;
    }
}
