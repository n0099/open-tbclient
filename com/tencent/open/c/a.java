package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40107a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f40108b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40109c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0518a f40110d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0518a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f40108b = null;
        this.f40109c = false;
        this.f40110d = null;
        if (0 == 0) {
            this.f40108b = new Rect();
        }
    }

    public void a(InterfaceC0518a interfaceC0518a) {
        this.f40110d = interfaceC0518a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f40108b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f40108b.top) - size;
        InterfaceC0518a interfaceC0518a = this.f40110d;
        if (interfaceC0518a != null && size != 0) {
            if (height > 100) {
                interfaceC0518a.a((Math.abs(this.f40108b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0518a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
