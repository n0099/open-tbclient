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
/* loaded from: classes3.dex */
public class a extends View implements ap.a {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC1105a f9370a;

    /* renamed from: b  reason: collision with root package name */
    private View f9371b;
    private boolean c;
    private boolean d;
    private boolean e;
    private final ap f;
    private final AtomicBoolean g;

    /* renamed from: com.kwad.sdk.core.page.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1105a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public a(Context context, View view) {
        super(context);
        this.f = new ap(this);
        this.g = new AtomicBoolean(true);
        this.f9371b = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void a() {
        if (!this.g.getAndSet(false) || this.f9370a == null) {
            return;
        }
        this.f9370a.a();
    }

    private void b() {
        if (this.g.getAndSet(true) || this.f9370a == null) {
            return;
        }
        this.f9370a.b();
    }

    private void c() {
        if (this.d) {
            this.f.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    private void d() {
        if (!this.e || this.d) {
            return;
        }
        this.d = true;
        this.f.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_CHECKING");
                if (this.d) {
                    if (!ao.a(this.f9371b, 30, false)) {
                        this.f.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    c();
                    Message obtainMessage = this.f.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 1000;
                    this.f.sendMessageDelayed(obtainMessage, 1000L);
                    return;
                }
                return;
            case 2:
                com.kwad.sdk.core.d.a.a("EmptyView", "handleMsg MSG_SHOWING");
                if (!ao.a(this.f9371b, 30, false)) {
                    if (this.c) {
                        return;
                    }
                    setNeedCheckingShow(true);
                    return;
                }
                if (message.arg1 == 1000 && this.f9370a != null) {
                    this.f9370a.a(this.f9371b);
                }
                this.f.sendEmptyMessageDelayed(2, 500L);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onAttachedToWindow:" + this);
        d();
        this.c = false;
        a();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("EmptyView", "onDetachedFromWindow" + this);
        c();
        this.c = true;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onFinishTemporaryDetach:" + this.f9371b.getParent());
        a();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.a("EmptyView", "onStartTemporaryDetach:" + this.f9371b.getParent());
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
        if (this.f9370a != null) {
            this.f9370a.a(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.a.a("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public void setNeedCheckingShow(boolean z) {
        this.e = z;
        if (!z && this.d) {
            c();
        } else if (!z || this.d) {
        } else {
            d();
        }
    }

    public void setViewCallback(InterfaceC1105a interfaceC1105a) {
        this.f9370a = interfaceC1105a;
    }
}
