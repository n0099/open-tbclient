package com.google.android.gms.internal;

import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ea extends FrameLayout {
    private String[] a;
    private final ImageView b;
    private final TextView c;

    public void a(int i, float f) {
        this.c.setTextSize(i, f);
    }

    public void a(Uri uri) {
        this.b.setImageURI(uri);
    }

    public void a(String[] strArr) {
        this.a = strArr;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measureText;
        int size = View.MeasureSpec.getSize(i);
        Paint paint = new Paint();
        paint.setTextSize(this.c.getTextSize());
        paint.setTypeface(this.c.getTypeface());
        int length = this.a != null ? this.a.length : 0;
        int i3 = 0;
        String str = null;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.a[i4] != null && (measureText = (int) paint.measureText(this.a[i4])) <= size && measureText >= i3) {
                str = this.a[i4];
                i3 = measureText;
            }
        }
        if (str == null || !str.equals(this.c.getText())) {
            this.c.setText(str);
        }
        super.onMeasure(i, i2);
    }

    public void setGravity(int i) {
        this.c.setGravity(i);
    }

    public void setTextColor(int i) {
        this.c.setTextColor(i);
    }
}
