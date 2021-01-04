package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes4.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13705a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private Rect f13706b;
    private boolean c;
    private InterfaceC1241a d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1241a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f13706b = null;
        this.c = false;
        this.d = null;
        if (this.f13706b == null) {
            this.f13706b = new Rect();
        }
    }

    public void a(InterfaceC1241a interfaceC1241a) {
        this.d = interfaceC1241a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f13706b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f13706b.top) - size;
        if (this.d != null && size != 0) {
            if (height > 100) {
                this.d.a((Math.abs(this.f13706b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                this.d.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
