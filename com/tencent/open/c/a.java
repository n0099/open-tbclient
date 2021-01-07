package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes4.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13706a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private Rect f13707b;
    private boolean c;
    private InterfaceC1282a d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1282a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f13707b = null;
        this.c = false;
        this.d = null;
        if (this.f13707b == null) {
            this.f13707b = new Rect();
        }
    }

    public void a(InterfaceC1282a interfaceC1282a) {
        this.d = interfaceC1282a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f13707b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f13707b.top) - size;
        if (this.d != null && size != 0) {
            if (height > 100) {
                this.d.a((Math.abs(this.f13707b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                this.d.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
