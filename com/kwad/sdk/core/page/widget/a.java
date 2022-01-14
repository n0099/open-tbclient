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
    public InterfaceC2109a a;

    /* renamed from: b  reason: collision with root package name */
    public View f55999b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56000c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56001d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56002e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f56003f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f56004g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2109a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f56003f = new bc(this);
        this.f56004g = new AtomicBoolean(true);
        this.f55999b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC2109a interfaceC2109a;
        if (!this.f56004g.getAndSet(false) || (interfaceC2109a = this.a) == null) {
            return;
        }
        interfaceC2109a.a();
    }

    private void b() {
        InterfaceC2109a interfaceC2109a;
        if (this.f56004g.getAndSet(true) || (interfaceC2109a = this.a) == null) {
            return;
        }
        interfaceC2109a.b();
    }

    private void c() {
        if (this.f56001d) {
            this.f56003f.removeCallbacksAndMessages(null);
            this.f56001d = false;
        }
    }

    private void d() {
        if (!this.f56002e || this.f56001d) {
            return;
        }
        this.f56001d = true;
        this.f56003f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC2109a interfaceC2109a;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bb.a(this.f55999b, 30, false)) {
                if (this.f56000c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC2109a = this.a) != null) {
                interfaceC2109a.a(this.f55999b);
            }
            this.f56003f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f56001d) {
            if (!bb.a(this.f55999b, 30, false)) {
                this.f56003f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f56003f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f56003f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f56000c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f56000c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f55999b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f55999b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC2109a interfaceC2109a = this.a;
        if (interfaceC2109a != null) {
            interfaceC2109a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f56002e = z;
        if (!z && this.f56001d) {
            c();
        } else if (!z || this.f56001d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC2109a interfaceC2109a) {
        this.a = interfaceC2109a;
    }
}
