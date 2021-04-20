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
/* loaded from: classes6.dex */
public class a extends View implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0404a f34246a;

    /* renamed from: b  reason: collision with root package name */
    public View f34247b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34248c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34250e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f34251f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f34252g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0404a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f34251f = new ap(this);
        this.f34252g = new AtomicBoolean(true);
        this.f34247b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0404a interfaceC0404a;
        if (!this.f34252g.getAndSet(false) || (interfaceC0404a = this.f34246a) == null) {
            return;
        }
        interfaceC0404a.a();
    }

    private void b() {
        InterfaceC0404a interfaceC0404a;
        if (this.f34252g.getAndSet(true) || (interfaceC0404a = this.f34246a) == null) {
            return;
        }
        interfaceC0404a.b();
    }

    private void c() {
        if (this.f34249d) {
            this.f34251f.removeCallbacksAndMessages(null);
            this.f34249d = false;
        }
    }

    private void d() {
        if (!this.f34250e || this.f34249d) {
            return;
        }
        this.f34249d = true;
        this.f34251f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0404a interfaceC0404a;
        int i = message.what;
        if (i == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f34249d) {
                if (!ao.a(this.f34247b, 30, false)) {
                    this.f34251f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f34251f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f34251f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f34247b, 30, false)) {
                if (this.f34248c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0404a = this.f34246a) != null) {
                interfaceC0404a.a(this.f34247b);
            }
            this.f34251f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f34248c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f34248c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f34247b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f34247b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0404a interfaceC0404a = this.f34246a;
        if (interfaceC0404a != null) {
            interfaceC0404a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f34250e = z;
        if (!z && this.f34249d) {
            c();
        } else if (!z || this.f34249d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0404a interfaceC0404a) {
        this.f34246a = interfaceC0404a;
    }
}
