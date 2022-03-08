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
/* loaded from: classes8.dex */
public class a extends View implements bc.a {
    public InterfaceC2104a a;

    /* renamed from: b  reason: collision with root package name */
    public View f54561b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54562c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54563d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54564e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f54565f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f54566g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2104a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f54565f = new bc(this);
        this.f54566g = new AtomicBoolean(true);
        this.f54561b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC2104a interfaceC2104a;
        if (!this.f54566g.getAndSet(false) || (interfaceC2104a = this.a) == null) {
            return;
        }
        interfaceC2104a.a();
    }

    private void b() {
        InterfaceC2104a interfaceC2104a;
        if (this.f54566g.getAndSet(true) || (interfaceC2104a = this.a) == null) {
            return;
        }
        interfaceC2104a.b();
    }

    private void c() {
        if (this.f54563d) {
            this.f54565f.removeCallbacksAndMessages(null);
            this.f54563d = false;
        }
    }

    private void d() {
        if (!this.f54564e || this.f54563d) {
            return;
        }
        this.f54563d = true;
        this.f54565f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC2104a interfaceC2104a;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bb.a(this.f54561b, 30, false)) {
                if (this.f54562c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC2104a = this.a) != null) {
                interfaceC2104a.a(this.f54561b);
            }
            this.f54565f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f54563d) {
            if (!bb.a(this.f54561b, 30, false)) {
                this.f54565f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f54565f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f54565f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f54562c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f54562c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f54561b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f54561b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC2104a interfaceC2104a = this.a;
        if (interfaceC2104a != null) {
            interfaceC2104a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f54564e = z;
        if (!z && this.f54563d) {
            c();
        } else if (!z || this.f54563d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC2104a interfaceC2104a) {
        this.a = interfaceC2104a;
    }
}
