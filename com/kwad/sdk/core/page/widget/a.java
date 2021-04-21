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
    public InterfaceC0407a f34341a;

    /* renamed from: b  reason: collision with root package name */
    public View f34342b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34343c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34344d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34345e;

    /* renamed from: f  reason: collision with root package name */
    public final ap f34346f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f34347g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0407a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f34346f = new ap(this);
        this.f34347g = new AtomicBoolean(true);
        this.f34342b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        InterfaceC0407a interfaceC0407a;
        if (!this.f34347g.getAndSet(false) || (interfaceC0407a = this.f34341a) == null) {
            return;
        }
        interfaceC0407a.a();
    }

    private void b() {
        InterfaceC0407a interfaceC0407a;
        if (this.f34347g.getAndSet(true) || (interfaceC0407a = this.f34341a) == null) {
            return;
        }
        interfaceC0407a.b();
    }

    private void c() {
        if (this.f34344d) {
            this.f34346f.removeCallbacksAndMessages(null);
            this.f34344d = false;
        }
    }

    private void d() {
        if (!this.f34345e || this.f34344d) {
            return;
        }
        this.f34344d = true;
        this.f34346f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        InterfaceC0407a interfaceC0407a;
        int i = message.what;
        if (i == 1) {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
            if (this.f34344d) {
                if (!ao.a(this.f34342b, 30, false)) {
                    this.f34346f.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                c();
                Message obtainMessage = this.f34346f.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.f34346f.sendMessageDelayed(obtainMessage, 1000L);
            }
        } else if (i != 2) {
        } else {
            com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
            if (!ao.a(this.f34342b, 30, false)) {
                if (this.f34343c) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (interfaceC0407a = this.f34341a) != null) {
                interfaceC0407a.a(this.f34342b);
            }
            this.f34346f.sendEmptyMessageDelayed(2, 500L);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.f34343c = false;
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.f34343c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f34342b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f34342b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0407a interfaceC0407a = this.f34341a;
        if (interfaceC0407a != null) {
            interfaceC0407a.a(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.f34345e = z;
        if (!z && this.f34344d) {
            c();
        } else if (!z || this.f34344d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC0407a interfaceC0407a) {
        this.f34341a = interfaceC0407a;
    }
}
