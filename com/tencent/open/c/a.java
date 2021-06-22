package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40210a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f40211b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40212c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0521a f40213d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0521a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f40211b = null;
        this.f40212c = false;
        this.f40213d = null;
        if (0 == 0) {
            this.f40211b = new Rect();
        }
    }

    public void a(InterfaceC0521a interfaceC0521a) {
        this.f40213d = interfaceC0521a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f40211b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f40211b.top) - size;
        InterfaceC0521a interfaceC0521a = this.f40213d;
        if (interfaceC0521a != null && size != 0) {
            if (height > 100) {
                interfaceC0521a.a((Math.abs(this.f40211b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0521a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
