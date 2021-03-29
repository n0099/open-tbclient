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
    public InterfaceC0390a f33957a;

    /* renamed from: b  reason: collision with root package name */
    public View f33958b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33959c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33961e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f33962f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f33963g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0390a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f33962f = new ap(this);
        this.f33963g = new AtomicBoolean(true);
        this.f33958b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0390a interfaceC0390a;
        if (!this.f33963g.getAndSet(false) || (interfaceC0390a = this.f33957a) == null) {
            return;
        }
        interfaceC0390a.a();
    }

    private void b() {
        InterfaceC0390a interfaceC0390a;
        if (this.f33963g.getAndSet(true) || (interfaceC0390a = this.f33957a) == null) {
            return;
        }
        interfaceC0390a.b();
    }

    private void c() {
        if (this.f33960d) {
            this.f33962f.removeCallbacksAndMessages(null);
            this.f33960d = false;
        }
    }

    private void d() {
        if (!this.f33961e || this.f33960d) {
            return;
        }
        this.f33960d = true;
        this.f33962f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0390a interfaceC0390a;
        int i = message.what;
        if (i == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f33960d) {
                if (!ao.a(this.f33958b, 30, false)) {
                    this.f33962f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f33962f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f33962f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f33958b, 30, false)) {
                if (this.f33959c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0390a = this.f33957a) != null) {
                interfaceC0390a.a(this.f33958b);
            }
            this.f33962f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f33959c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f33959c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f33958b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f33958b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0390a interfaceC0390a = this.f33957a;
        if (interfaceC0390a != null) {
            interfaceC0390a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f33961e = z;
        if (!z && this.f33960d) {
            c();
        } else if (!z || this.f33960d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0390a interfaceC0390a) {
        this.f33957a = interfaceC0390a;
    }
}
