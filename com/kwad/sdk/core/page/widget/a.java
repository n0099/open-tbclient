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
/* loaded from: classes7.dex */
public class a extends View implements bc.a {
    public InterfaceC1965a a;

    /* renamed from: b  reason: collision with root package name */
    public View f39674b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39675c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39676d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39677e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f39678f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f39679g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1965a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f39678f = new bc(this);
        this.f39679g = new AtomicBoolean(true);
        this.f39674b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC1965a interfaceC1965a;
        if (!this.f39679g.getAndSet(false) || (interfaceC1965a = this.a) == null) {
            return;
        }
        interfaceC1965a.a();
    }

    private void b() {
        InterfaceC1965a interfaceC1965a;
        if (this.f39679g.getAndSet(true) || (interfaceC1965a = this.a) == null) {
            return;
        }
        interfaceC1965a.b();
    }

    private void c() {
        if (this.f39676d) {
            this.f39678f.removeCallbacksAndMessages(null);
            this.f39676d = false;
        }
    }

    private void d() {
        if (!this.f39677e || this.f39676d) {
            return;
        }
        this.f39676d = true;
        this.f39678f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        InterfaceC1965a interfaceC1965a;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!bb.a(this.f39674b, 30, false)) {
                if (this.f39675c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC1965a = this.a) != null) {
                interfaceC1965a.a(this.f39674b);
            }
            this.f39678f.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
        if (this.f39676d) {
            if (!bb.a(this.f39674b, 30, false)) {
                this.f39678f.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            c();
            Message obtainMessage = this.f39678f.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.f39678f.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f39675c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f39675c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f39674b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f39674b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC1965a interfaceC1965a = this.a;
        if (interfaceC1965a != null) {
            interfaceC1965a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f39677e = z;
        if (!z && this.f39676d) {
            c();
        } else if (!z || this.f39676d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC1965a interfaceC1965a) {
        this.a = interfaceC1965a;
    }
}
