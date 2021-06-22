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
/* loaded from: classes7.dex */
public class a extends View implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0393a f34687a;

    /* renamed from: b  reason: collision with root package name */
    public View f34688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34689c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34690d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34691e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f34692f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f34693g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0393a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f34692f = new ap(this);
        this.f34693g = new AtomicBoolean(true);
        this.f34688b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0393a interfaceC0393a;
        if (!this.f34693g.getAndSet(false) || (interfaceC0393a = this.f34687a) == null) {
            return;
        }
        interfaceC0393a.a();
    }

    private void b() {
        InterfaceC0393a interfaceC0393a;
        if (this.f34693g.getAndSet(true) || (interfaceC0393a = this.f34687a) == null) {
            return;
        }
        interfaceC0393a.b();
    }

    private void c() {
        if (this.f34690d) {
            this.f34692f.removeCallbacksAndMessages(null);
            this.f34690d = false;
        }
    }

    private void d() {
        if (!this.f34691e || this.f34690d) {
            return;
        }
        this.f34690d = true;
        this.f34692f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0393a interfaceC0393a;
        int i2 = message.what;
        if (i2 == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f34690d) {
                if (!ao.a(this.f34688b, 30, false)) {
                    this.f34692f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f34692f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f34692f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i2 != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f34688b, 30, false)) {
                if (this.f34689c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0393a = this.f34687a) != null) {
                interfaceC0393a.a(this.f34688b);
            }
            this.f34692f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f34689c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f34689c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f34688b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f34688b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0393a interfaceC0393a = this.f34687a;
        if (interfaceC0393a != null) {
            interfaceC0393a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f34691e = z;
        if (!z && this.f34690d) {
            c();
        } else if (!z || this.f34690d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0393a interfaceC0393a) {
        this.f34687a = interfaceC0393a;
    }
}
