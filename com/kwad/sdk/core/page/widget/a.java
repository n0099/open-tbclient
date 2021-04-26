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
    public InterfaceC0381a f33323a;

    /* renamed from: b  reason: collision with root package name */
    public View f33324b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33326d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33327e;

    /* renamed from: f  reason: collision with root package name */
    public final ao f33328f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f33329g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0381a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f33328f = new ao(this);
        this.f33329g = new AtomicBoolean(true);
        this.f33324b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0381a interfaceC0381a;
        if (!this.f33329g.getAndSet(false) || (interfaceC0381a = this.f33323a) == null) {
            return;
        }
        interfaceC0381a.a();
    }

    private void b() {
        InterfaceC0381a interfaceC0381a;
        if (this.f33329g.getAndSet(true) || (interfaceC0381a = this.f33323a) == null) {
            return;
        }
        interfaceC0381a.b();
    }

    private void c() {
        if (this.f33326d) {
            this.f33328f.removeCallbacksAndMessages(null);
            this.f33326d = false;
        }
    }

    private void d() {
        if (!this.f33327e || this.f33326d) {
            return;
        }
        this.f33326d = true;
        this.f33328f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        InterfaceC0381a interfaceC0381a;
        int i2 = message.what;
        if (i2 == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f33326d) {
                if (!an.a(this.f33324b, 30, false)) {
                    this.f33328f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f33328f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f33328f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i2 != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!an.a(this.f33324b, 30, false)) {
                if (this.f33325c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0381a = this.f33323a) != null) {
                interfaceC0381a.a(this.f33324b);
            }
            this.f33328f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f33325c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f33325c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f33324b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f33324b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0381a interfaceC0381a = this.f33323a;
        if (interfaceC0381a != null) {
            interfaceC0381a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i2);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f33327e = z;
        if (!z && this.f33326d) {
            c();
        } else if (!z || this.f33326d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0381a interfaceC0381a) {
        this.f33323a = interfaceC0381a;
    }
}
