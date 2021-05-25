package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36428a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f36429b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36430c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0467a f36431d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0467a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f36429b = null;
        this.f36430c = false;
        this.f36431d = null;
        if (0 == 0) {
            this.f36429b = new Rect();
        }
    }

    public void a(InterfaceC0467a interfaceC0467a) {
        this.f36431d = interfaceC0467a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f36429b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f36429b.top) - size;
        InterfaceC0467a interfaceC0467a = this.f36431d;
        if (interfaceC0467a != null && size != 0) {
            if (height > 100) {
                interfaceC0467a.a((Math.abs(this.f36429b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0467a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
