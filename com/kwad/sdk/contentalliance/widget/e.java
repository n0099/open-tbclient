package com.kwad.sdk.contentalliance.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends GradientDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextPaint f35882a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f35883b;

    /* renamed from: c  reason: collision with root package name */
    public float f35884c;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f35885d;

    /* renamed from: e  reason: collision with root package name */
    public int f35886e;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TextPaint textPaint = new TextPaint(1);
        this.f35882a = textPaint;
        textPaint.setColor(-1);
        this.f35882a.setTextAlign(Paint.Align.CENTER);
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f35882a.setTextSize(f2);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f35882a.setColor(i2);
        }
    }

    public void a(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            this.f35883b = charSequence;
            if (!TextUtils.isEmpty(charSequence)) {
                this.f35884c = this.f35882a.measureText((String) this.f35883b);
            }
            this.f35885d = new StaticLayout(this.f35883b, this.f35882a, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f35886e = i2;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.draw(canvas);
            Rect bounds = getBounds();
            canvas.save();
            int width = bounds.width();
            int i2 = this.f35886e;
            canvas.translate(width >= i2 ? bounds.right - (i2 / 2) : bounds.left + (i2 / 2), bounds.centerY() - (this.f35884c / 2.0f));
            this.f35885d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35886e : invokeV.intValue;
    }
}
