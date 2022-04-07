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
/* loaded from: classes5.dex */
public class a extends View implements bc.a {
    public InterfaceC0305a a;
    public View b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final bc f;
    public final AtomicBoolean g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0305a {
        void a();

        void a(View view2);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view2) {
        super(context);
        this.f = new bc(this);
        this.g = new AtomicBoolean(true);
        this.b = view2;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0305a interfaceC0305a;
        if (!this.g.getAndSet(false) || (interfaceC0305a = this.a) == null) {
            return;
        }
        interfaceC0305a.a();
    }

    private void b() {
        InterfaceC0305a interfaceC0305a;
        if (this.g.getAndSet(true) || (interfaceC0305a = this.a) == null) {
            return;
        }
        interfaceC0305a.b();
    }

    private void c() {
        if (this.d) {
            this.f.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    private void d() {
        if (!this.e || this.d) {
            return;
        }
        this.d = true;
        this.f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC0305a interfaceC0305a;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bb.a(this.b, 30, false)) {
                if (this.c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0305a = this.a) != null) {
                interfaceC0305a.a(this.b);
            }
            this.f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.d) {
            if (!bb.a(this.b, 30, false)) {
                this.f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0305a interfaceC0305a = this.a;
        if (interfaceC0305a != null) {
            interfaceC0305a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.e = z;
        if (!z && this.d) {
            c();
        } else if (!z || this.d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0305a interfaceC0305a) {
        this.a = interfaceC0305a;
    }
}
