package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39267a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f39268b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39269c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0517a f39270d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0517a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f39268b = null;
        this.f39269c = false;
        this.f39270d = null;
        if (0 == 0) {
            this.f39268b = new Rect();
        }
    }

    public void a(InterfaceC0517a interfaceC0517a) {
        this.f39270d = interfaceC0517a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f39268b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f39268b.top) - size;
        InterfaceC0517a interfaceC0517a = this.f39270d;
        if (interfaceC0517a != null && size != 0) {
            if (height > 100) {
                interfaceC0517a.a((Math.abs(this.f39268b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0517a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
