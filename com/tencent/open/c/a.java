package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36499a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public Rect f36500b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36501c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0466a f36502d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0466a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f36500b = null;
        this.f36501c = false;
        this.f36502d = null;
        if (0 == 0) {
            this.f36500b = new Rect();
        }
    }

    public void a(InterfaceC0466a interfaceC0466a) {
        this.f36502d = interfaceC0466a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f36500b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f36500b.top) - size;
        InterfaceC0466a interfaceC0466a = this.f36502d;
        if (interfaceC0466a != null && size != 0) {
            if (height > 100) {
                interfaceC0466a.a((Math.abs(this.f36500b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0466a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
