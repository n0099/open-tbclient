package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.util.ak;
/* loaded from: classes3.dex */
public class k extends ImageView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f12163a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ad.g f12164b;
    private r c;
    private View.OnClickListener d;

    public k(Context context, String str, com.qq.e.comm.plugin.ad.g gVar) {
        super(context);
        this.f12163a = str;
        this.f12164b = gVar;
        this.c = new r(getContext());
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setOnClickListener(this);
        setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void a(int i, int i2) {
        a(i, i2, false);
    }

    public void a(int i, int i2, boolean z) {
        Context context = getContext();
        if (context instanceof Activity) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 112), ak.a(getContext(), 90));
            layoutParams.topMargin = ak.a(getContext(), i2 - 90);
            layoutParams.leftMargin = ak.a(getContext(), i);
            ((ViewGroup) ((Activity) context).getWindow().getDecorView()).addView(this, layoutParams);
            com.qq.e.comm.plugin.p.a.a().a(this.f12163a, this);
        }
        setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        a(onClickListener, (r) null);
    }

    public void a(View.OnClickListener onClickListener, r rVar) {
        this.d = onClickListener;
        if (rVar != null) {
            this.c = rVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null || !this.c.a()) {
            return;
        }
        this.d.onClick(view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12164b != null) {
            this.f12164b.a(motionEvent, true);
        }
        this.c.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
