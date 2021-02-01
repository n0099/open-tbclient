package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes15.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13408a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private Rect f13409b;
    private boolean c;
    private InterfaceC1269a d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1269a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f13409b = null;
        this.c = false;
        this.d = null;
        if (this.f13409b == null) {
            this.f13409b = new Rect();
        }
    }

    public void a(InterfaceC1269a interfaceC1269a) {
        this.d = interfaceC1269a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f13409b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f13409b.top) - size;
        if (this.d != null && size != 0) {
            if (height > 100) {
                this.d.a((Math.abs(this.f13409b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                this.d.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
