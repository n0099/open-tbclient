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
    public InterfaceC2092a a;

    /* renamed from: b  reason: collision with root package name */
    public View f58199b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58200c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58201d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58202e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f58203f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f58204g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2092a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f58203f = new bc(this);
        this.f58204g = new AtomicBoolean(true);
        this.f58199b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC2092a interfaceC2092a;
        if (!this.f58204g.getAndSet(false) || (interfaceC2092a = this.a) == null) {
            return;
        }
        interfaceC2092a.a();
    }

    private void b() {
        InterfaceC2092a interfaceC2092a;
        if (this.f58204g.getAndSet(true) || (interfaceC2092a = this.a) == null) {
            return;
        }
        interfaceC2092a.b();
    }

    private void c() {
        if (this.f58201d) {
            this.f58203f.removeCallbacksAndMessages(null);
            this.f58201d = false;
        }
    }

    private void d() {
        if (!this.f58202e || this.f58201d) {
            return;
        }
        this.f58201d = true;
        this.f58203f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC2092a interfaceC2092a;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (!bb.a(this.f58199b, 30, false)) {
                if (this.f58200c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC2092a = this.a) != null) {
                interfaceC2092a.a(this.f58199b);
            }
            this.f58203f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f58201d) {
            if (!bb.a(this.f58199b, 30, false)) {
                this.f58203f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f58203f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f58203f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f58200c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f58200c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f58199b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f58199b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC2092a interfaceC2092a = this.a;
        if (interfaceC2092a != null) {
            interfaceC2092a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f58202e = z;
        if (!z && this.f58201d) {
            c();
        } else if (!z || this.f58201d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC2092a interfaceC2092a) {
        this.a = interfaceC2092a;
    }
}
