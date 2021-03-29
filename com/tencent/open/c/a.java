package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39268a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f39269b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39270c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0518a f39271d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0518a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f39269b = null;
        this.f39270c = false;
        this.f39271d = null;
        if (0 == 0) {
            this.f39269b = new Rect();
        }
    }

    public void a(InterfaceC0518a interfaceC0518a) {
        this.f39271d = interfaceC0518a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f39269b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f39269b.top) - size;
        InterfaceC0518a interfaceC0518a = this.f39271d;
        if (interfaceC0518a != null && size != 0) {
            if (height > 100) {
                interfaceC0518a.a((Math.abs(this.f39269b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0518a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
