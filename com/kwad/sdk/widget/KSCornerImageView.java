package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.sdk.widget.i;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class KSCornerImageView extends ImageView {
    public i a;

    public KSCornerImageView(Context context) {
        super(context);
        a(context, null, 0);
    }

    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KSCornerImageView(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        i.a aVar = new i.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ksad_bottomLeftCorner, R.attr.ksad_leftTopCorner, R.attr.ksad_rightBottomCorner, R.attr.ksad_topRightCorner});
        aVar.a(obtainStyledAttributes.getBoolean(1, true));
        aVar.b(obtainStyledAttributes.getBoolean(3, true));
        aVar.c(obtainStyledAttributes.getBoolean(2, true));
        aVar.d(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        i iVar = new i(aVar);
        this.a = iVar;
        iVar.a(context, attributeSet);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.a.c(canvas);
        super.dispatchDraw(canvas);
        this.a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.a.a(canvas);
        super.draw(canvas);
        this.a.b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a.a(i2, i3);
    }

    public void setRadius(float f2) {
        this.a.a(f2);
        postInvalidate();
    }
}
