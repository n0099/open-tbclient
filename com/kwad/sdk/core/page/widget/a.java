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
    public InterfaceC0389a f33956a;

    /* renamed from: b  reason: collision with root package name */
    public View f33957b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33958c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33959d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33960e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f33961f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f33962g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0389a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f33961f = new ap(this);
        this.f33962g = new AtomicBoolean(true);
        this.f33957b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0389a interfaceC0389a;
        if (!this.f33962g.getAndSet(false) || (interfaceC0389a = this.f33956a) == null) {
            return;
        }
        interfaceC0389a.a();
    }

    private void b() {
        InterfaceC0389a interfaceC0389a;
        if (this.f33962g.getAndSet(true) || (interfaceC0389a = this.f33956a) == null) {
            return;
        }
        interfaceC0389a.b();
    }

    private void c() {
        if (this.f33959d) {
            this.f33961f.removeCallbacksAndMessages(null);
            this.f33959d = false;
        }
    }

    private void d() {
        if (!this.f33960e || this.f33959d) {
            return;
        }
        this.f33959d = true;
        this.f33961f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0389a interfaceC0389a;
        int i = message.what;
        if (i == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f33959d) {
                if (!ao.a(this.f33957b, 30, false)) {
                    this.f33961f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f33961f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f33961f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f33957b, 30, false)) {
                if (this.f33958c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0389a = this.f33956a) != null) {
                interfaceC0389a.a(this.f33957b);
            }
            this.f33961f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f33958c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f33958c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f33957b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f33957b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0389a interfaceC0389a = this.f33956a;
        if (interfaceC0389a != null) {
            interfaceC0389a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f33960e = z;
        if (!z && this.f33959d) {
            c();
        } else if (!z || this.f33959d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0389a interfaceC0389a) {
        this.f33956a = interfaceC0389a;
    }
}
