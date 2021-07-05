package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a extends GradientDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Drawable f36755a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f36756b;

    /* renamed from: c  reason: collision with root package name */
    public float f36757c;

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f36757c = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (this.f36757c == 0.0f) {
                this.f36756b.setBounds(getBounds());
                this.f36756b.draw(canvas);
            } else {
                if (this.f36755a.getBounds().width() != getBounds().width()) {
                    this.f36755a.setBounds(getBounds());
                }
                if (this.f36756b.getBounds().width() != getBounds().width()) {
                    this.f36756b.setBounds(getBounds());
                }
                canvas.save();
                int width = (int) (getBounds().width() * this.f36757c);
                canvas.clipRect(0, 0, width, getBounds().height());
                this.f36755a.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
                this.f36756b.draw(canvas);
                canvas.restore();
            }
            super.draw(canvas);
        }
    }
}
