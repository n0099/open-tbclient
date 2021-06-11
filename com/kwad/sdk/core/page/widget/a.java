package com.kwad.sdk.core.page.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class a extends View implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0390a f34589a;

    /* renamed from: b  reason: collision with root package name */
    public View f34590b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34591c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34592d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34593e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f34594f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f34595g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0390a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f34594f = new ap(this);
        this.f34595g = new AtomicBoolean(true);
        this.f34590b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0390a interfaceC0390a;
        if (!this.f34595g.getAndSet(false) || (interfaceC0390a = this.f34589a) == null) {
            return;
        }
        interfaceC0390a.a();
    }

    private void b() {
        InterfaceC0390a interfaceC0390a;
        if (this.f34595g.getAndSet(true) || (interfaceC0390a = this.f34589a) == null) {
            return;
        }
        interfaceC0390a.b();
    }

    private void c() {
        if (this.f34592d) {
            this.f34594f.removeCallbacksAndMessages(null);
            this.f34592d = false;
        }
    }

    private void d() {
        if (!this.f34593e || this.f34592d) {
            return;
        }
        this.f34592d = true;
        this.f34594f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0390a interfaceC0390a;
        int i2 = message.what;
        if (i2 == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f34592d) {
                if (!ao.a(this.f34590b, 30, false)) {
                    this.f34594f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f34594f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f34594f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i2 != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f34590b, 30, false)) {
                if (this.f34591c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0390a = this.f34589a) != null) {
                interfaceC0390a.a(this.f34590b);
            }
            this.f34594f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f34591c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f34591c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f34590b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f34590b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0390a interfaceC0390a = this.f34589a;
        if (interfaceC0390a != null) {
            interfaceC0390a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f34593e = z;
        if (!z && this.f34592d) {
            c();
        } else if (!z || this.f34592d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0390a interfaceC0390a) {
        this.f34589a = interfaceC0390a;
    }
}
