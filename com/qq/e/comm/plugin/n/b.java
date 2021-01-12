package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.plugin.ac.i;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ap;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class b extends RelativeLayout implements View.OnClickListener, g {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.s.a f12230a;

    /* renamed from: b  reason: collision with root package name */
    private a f12231b;
    private com.qq.e.comm.plugin.ad.g c;
    private boolean d;
    private boolean e;
    private r f;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, com.qq.e.comm.plugin.s.a aVar) {
        super(context);
        this.d = false;
        this.f12230a = aVar;
        d();
        this.f = new r(context);
    }

    private void d() {
        if (this.f12230a == null) {
            this.d = true;
        }
        setBackgroundDrawable(ap.a(ak.a(getContext(), 15), -1, 240));
        com.qq.e.comm.plugin.ac.j jVar = new com.qq.e.comm.plugin.ac.j(getContext());
        jVar.a(ak.a(getContext(), 15));
        jVar.setId(2131755010);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 56), ak.a(getContext(), 56));
        layoutParams.addRule(15, -1);
        layoutParams.addRule(9, -1);
        layoutParams.leftMargin = ak.a(getContext(), 11);
        layoutParams.rightMargin = ak.a(getContext(), 7);
        final com.qq.e.comm.plugin.y.c e = e();
        final com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        dVar.a("url", this.f12230a.p());
        final long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.p.a.a().a(this.f12230a.p(), jVar, new com.qq.e.comm.plugin.p.b() { // from class: com.qq.e.comm.plugin.n.b.1
            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, int i, Exception exc) {
                u.a(1130006, i, e, dVar);
            }

            @Override // com.qq.e.comm.plugin.p.b
            public void a(String str, ImageView imageView, com.qq.e.comm.plugin.p.e eVar) {
                u.a(1130007, 0, e, dVar);
                com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(2030011).b(System.currentTimeMillis() - currentTimeMillis);
                b2.a(e);
                u.a(b2);
            }
        });
        addView(jVar, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setId(2131755011);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, 2131755010);
        layoutParams2.addRule(0, 2131755012);
        layoutParams2.addRule(6, 2131755010);
        layoutParams2.topMargin = ak.a(getContext(), 5);
        if (!this.f12230a.v()) {
            textView.setText(this.f12230a.n());
        } else if (this.f12230a.z() != null) {
            textView.setText(this.f12230a.z().i());
        } else {
            textView.setText(this.f12230a.n());
        }
        addView(textView, layoutParams2);
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView2.setTextSize(2, 14.0f);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(this.f12230a.i());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, 2131755010);
        layoutParams3.addRule(0, 2131755012);
        layoutParams3.addRule(3, 2131755011);
        layoutParams3.topMargin = ak.a(getContext(), 5);
        addView(textView2, layoutParams3);
        com.qq.e.comm.plugin.ac.j jVar2 = new com.qq.e.comm.plugin.ac.j(getContext());
        jVar2.a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, ak.a(getContext(), 15), ak.a(getContext(), 15), 0.0f, 0.0f});
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ak.a(getContext(), 39), ak.a(getContext(), 18));
        layoutParams4.addRule(11, -1);
        layoutParams4.addRule(12, -1);
        com.qq.e.comm.plugin.util.g.a(jVar2, this.f12230a.C());
        addView(jVar2, layoutParams4);
        int a2 = ak.a(getContext(), 82);
        int a3 = ak.a(getContext(), 32);
        boolean z = com.qq.e.comm.plugin.util.b.a(getContext(), this.f12230a) || !this.f12230a.v();
        String ad = this.f12230a.ad();
        String str = (TextUtils.isEmpty(ad) || !z) ? "查看" : ad;
        com.qq.e.comm.plugin.ac.i a4 = new i.a().a(this.f12230a).b(a2).c(a3).d(16).e(-1).f(-1).a(a3 / 2).a((TextUtils.isEmpty(ad) || !z) ? new String[]{"打开", "下载", "下载中", "安装", "打开"} : new String[]{str, str, "下载中", "安装", str}).a(getContext());
        a4.setId(2131755012);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams5.addRule(11, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.rightMargin = ak.a(getContext(), 10);
        layoutParams5.leftMargin = ak.a(getContext(), 7);
        addView(a4, layoutParams5);
        setOnClickListener(this);
        setVisibility(8);
    }

    private com.qq.e.comm.plugin.y.c e() {
        com.qq.e.comm.plugin.y.c cVar = new com.qq.e.comm.plugin.y.c();
        cVar.b(this.f12230a.m());
        cVar.a(this.f12230a.B());
        cVar.c(this.f12230a.H());
        return cVar;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a() {
        if (this.d) {
            GDTLogger.d("BottomCard show, data exception!");
            return;
        }
        setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        startAnimation(translateAnimation);
        this.e = true;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(ViewGroup viewGroup, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (getParent() == null) {
            if (z) {
                layoutParams = new RelativeLayout.LayoutParams(ak.a(getContext(), 358), ak.a(getContext(), 80));
                layoutParams.addRule(11, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = ak.a(getContext(), 8);
                layoutParams.rightMargin = ak.a(getContext(), 8);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, ak.a(getContext(), 80));
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                layoutParams.leftMargin = ak.a(getContext(), 8);
                layoutParams.bottomMargin = ak.a(getContext(), 8);
                layoutParams.rightMargin = ak.a(getContext(), 8);
            }
            viewGroup.addView(this, layoutParams);
        }
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(com.qq.e.comm.plugin.ad.g gVar) {
        this.c = gVar;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void a(a aVar) {
        this.f12231b = aVar;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public boolean b() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.n.g
    public void c() {
        clearAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f.a() && this.f12231b != null) {
            this.f12231b.a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c != null) {
            this.c.a(motionEvent, true);
        }
        this.f.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
