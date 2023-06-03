package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes10.dex */
public class a extends RelativeLayout {
    public static final String a = a.class.getName();
    public Rect b;
    public boolean c;
    public InterfaceC0764a d;

    /* renamed from: com.tencent.open.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0764a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        if (0 == 0) {
            this.b = new Rect();
        }
    }

    public void a(InterfaceC0764a interfaceC0764a) {
        this.d = interfaceC0764a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0764a interfaceC0764a = this.d;
        if (interfaceC0764a != null && size != 0) {
            if (height > 100) {
                interfaceC0764a.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0764a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
