package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
/* loaded from: classes7.dex */
public class c extends TextView {
    public c(Context context) {
        super(context);
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 3 && (drawable = compoundDrawables[2]) != null) {
            float measureText = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
            setPadding(0, 0, (int) (getWidth() - measureText), 0);
            canvas.translate((getWidth() - measureText) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
