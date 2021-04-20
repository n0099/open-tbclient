package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes6.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39557a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f39558b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39559c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0532a f39560d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0532a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f39558b = null;
        this.f39559c = false;
        this.f39560d = null;
        if (0 == 0) {
            this.f39558b = new Rect();
        }
    }

    public void a(InterfaceC0532a interfaceC0532a) {
        this.f39560d = interfaceC0532a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f39558b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f39558b.top) - size;
        InterfaceC0532a interfaceC0532a = this.f39560d;
        if (interfaceC0532a != null && size != 0) {
            if (height > 100) {
                interfaceC0532a.a((Math.abs(this.f39558b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0532a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
