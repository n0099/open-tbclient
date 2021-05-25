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
    public InterfaceC0369a f32497a;

    /* renamed from: b  reason: collision with root package name */
    public View f32498b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32499c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32500d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32501e;

    /* renamed from: f  reason: collision with root package name */
    public final ao f32502f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f32503g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0369a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f32502f = new ao(this);
        this.f32503g = new AtomicBoolean(true);
        this.f32498b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0369a interfaceC0369a;
        if (!this.f32503g.getAndSet(false) || (interfaceC0369a = this.f32497a) == null) {
            return;
        }
        interfaceC0369a.a();
    }

    private void b() {
        InterfaceC0369a interfaceC0369a;
        if (this.f32503g.getAndSet(true) || (interfaceC0369a = this.f32497a) == null) {
            return;
        }
        interfaceC0369a.b();
    }

    private void c() {
        if (this.f32500d) {
            this.f32502f.removeCallbacksAndMessages(null);
            this.f32500d = false;
        }
    }

    private void d() {
        if (!this.f32501e || this.f32500d) {
            return;
        }
        this.f32500d = true;
        this.f32502f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        InterfaceC0369a interfaceC0369a;
        int i2 = message.what;
        if (i2 == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f32500d) {
                if (!an.a(this.f32498b, 30, false)) {
                    this.f32502f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f32502f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f32502f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i2 != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!an.a(this.f32498b, 30, false)) {
                if (this.f32499c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0369a = this.f32497a) != null) {
                interfaceC0369a.a(this.f32498b);
            }
            this.f32502f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f32499c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f32499c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f32498b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f32498b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0369a interfaceC0369a = this.f32497a;
        if (interfaceC0369a != null) {
            interfaceC0369a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f32501e = z;
        if (!z && this.f32500d) {
            c();
        } else if (!z || this.f32500d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0369a interfaceC0369a) {
        this.f32497a = interfaceC0369a;
    }
}
