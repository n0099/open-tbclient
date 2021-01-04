package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.aa.b.c;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class d extends FrameLayout implements b, c.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f11969a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11970b;
    private boolean c;
    private e d;
    private ImageView e;
    private ImageView f;
    private final Handler g;
    private f.a h;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, Exception exc);

        void b_();

        void c_();

        void f_();

        void g();

        void g_();

        void h_();

        void i_();
    }

    private void a() {
        if (this.e == null) {
            return;
        }
        if (this.d.c()) {
            this.e.setImageBitmap(g.b(this.f11969a));
        } else {
            this.e.setImageBitmap(g.a(this.f11969a));
        }
    }

    public void a(int i) {
        if (this.c) {
            if (!this.f11970b) {
                this.f11970b = true;
                setVisibility(0);
            }
            a();
            e();
            this.g.sendEmptyMessage(2);
            Message obtainMessage = this.g.obtainMessage(1);
            if (i != 0) {
                this.g.removeMessages(1);
                this.g.sendMessageDelayed(obtainMessage, i);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void a(e eVar) {
        this.d = eVar;
        this.d.a(this.h);
        a();
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void c() {
        if (!this.c || this.d.g() == f.d.ERROR || this.d.g() == f.d.UNINITIALIZED) {
            return;
        }
        a(3000);
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void d() {
        if (this.f11970b) {
            try {
                this.g.removeMessages(2);
                setVisibility(4);
            } catch (IllegalArgumentException e) {
                GDTLogger.d("MediaController already removed");
            }
            this.f11970b = false;
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.b
    public void e() {
        if (this.f == null) {
            return;
        }
        if (this.d.d()) {
            this.f.setImageBitmap(g.d(this.f11969a));
        } else {
            this.f.setImageBitmap(g.c(this.f11969a));
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.c.a
    public void h() {
        if (this.f11970b) {
            c();
        }
    }

    @Override // android.view.View, com.qq.e.comm.plugin.aa.b.b
    public boolean isShown() {
        return this.f11970b;
    }
}
