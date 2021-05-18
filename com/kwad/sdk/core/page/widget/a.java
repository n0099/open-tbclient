package com.kwad.sdk.core.page.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class a extends View implements ao.a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0368a f32568a;

    /* renamed from: b  reason: collision with root package name */
    public View f32569b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32570c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32572e;

    /* renamed from: f  reason: collision with root package name */
    public final ao f32573f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f32574g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0368a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f32573f = new ao(this);
        this.f32574g = new AtomicBoolean(true);
        this.f32569b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0368a interfaceC0368a;
        if (!this.f32574g.getAndSet(false) || (interfaceC0368a = this.f32568a) == null) {
            return;
        }
        interfaceC0368a.a();
    }

    private void b() {
        InterfaceC0368a interfaceC0368a;
        if (this.f32574g.getAndSet(true) || (interfaceC0368a = this.f32568a) == null) {
            return;
        }
        interfaceC0368a.b();
    }

    private void c() {
        if (this.f32571d) {
            this.f32573f.removeCallbacksAndMessages(null);
            this.f32571d = false;
        }
    }

    private void d() {
        if (!this.f32572e || this.f32571d) {
            return;
        }
        this.f32571d = true;
        this.f32573f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        InterfaceC0368a interfaceC0368a;
        int i2 = message.what;
        if (i2 == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f32571d) {
                if (!an.a(this.f32569b, 30, false)) {
                    this.f32573f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f32573f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f32573f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i2 != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!an.a(this.f32569b, 30, false)) {
                if (this.f32570c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0368a = this.f32568a) != null) {
                interfaceC0368a.a(this.f32569b);
            }
            this.f32573f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f32570c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f32570c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f32569b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f32569b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0368a interfaceC0368a = this.f32568a;
        if (interfaceC0368a != null) {
            interfaceC0368a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f32572e = z;
        if (!z && this.f32571d) {
            c();
        } else if (!z || this.f32571d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0368a interfaceC0368a) {
        this.f32568a = interfaceC0368a;
    }
}
