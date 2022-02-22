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
/* loaded from: classes4.dex */
public class a extends View implements bc.a {
    public InterfaceC2125a a;

    /* renamed from: b  reason: collision with root package name */
    public View f56211b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56212c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56213d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56214e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f56215f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f56216g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2125a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f56215f = new bc(this);
        this.f56216g = new AtomicBoolean(true);
        this.f56211b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC2125a interfaceC2125a;
        if (!this.f56216g.getAndSet(false) || (interfaceC2125a = this.a) == null) {
            return;
        }
        interfaceC2125a.a();
    }

    private void b() {
        InterfaceC2125a interfaceC2125a;
        if (this.f56216g.getAndSet(true) || (interfaceC2125a = this.a) == null) {
            return;
        }
        interfaceC2125a.b();
    }

    private void c() {
        if (this.f56213d) {
            this.f56215f.removeCallbacksAndMessages(null);
            this.f56213d = false;
        }
    }

    private void d() {
        if (!this.f56214e || this.f56213d) {
            return;
        }
        this.f56213d = true;
        this.f56215f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC2125a interfaceC2125a;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bb.a(this.f56211b, 30, false)) {
                if (this.f56212c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC2125a = this.a) != null) {
                interfaceC2125a.a(this.f56211b);
            }
            this.f56215f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f56213d) {
            if (!bb.a(this.f56211b, 30, false)) {
                this.f56215f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f56215f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f56215f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f56212c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f56212c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f56211b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f56211b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC2125a interfaceC2125a = this.a;
        if (interfaceC2125a != null) {
            interfaceC2125a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f56214e = z;
        if (!z && this.f56213d) {
            c();
        } else if (!z || this.f56213d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC2125a interfaceC2125a) {
        this.a = interfaceC2125a;
    }
}
