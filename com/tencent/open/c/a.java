package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39652a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f39653b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39654c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0535a f39655d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0535a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f39653b = null;
        this.f39654c = false;
        this.f39655d = null;
        if (0 == 0) {
            this.f39653b = new Rect();
        }
    }

    public void a(InterfaceC0535a interfaceC0535a) {
        this.f39655d = interfaceC0535a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f39653b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f39653b.top) - size;
        InterfaceC0535a interfaceC0535a = this.f39655d;
        if (interfaceC0535a != null && size != 0) {
            if (height > 100) {
                interfaceC0535a.a((Math.abs(this.f39653b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0535a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
