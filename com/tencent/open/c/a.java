package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes6.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f37254a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f37255b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37256c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0479a f37257d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0479a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f37255b = null;
        this.f37256c = false;
        this.f37257d = null;
        if (0 == 0) {
            this.f37255b = new Rect();
        }
    }

    public void a(InterfaceC0479a interfaceC0479a) {
        this.f37257d = interfaceC0479a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f37255b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f37255b.top) - size;
        InterfaceC0479a interfaceC0479a = this.f37257d;
        if (interfaceC0479a != null && size != 0) {
            if (height > 100) {
                interfaceC0479a.a((Math.abs(this.f37255b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0479a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
