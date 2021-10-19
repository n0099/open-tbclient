package tv.athena.revenue.payui.view.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import j.a.a.e.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b(\u0010.J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0014J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001e¨\u0006/"}, d2 = {"Ltv/athena/revenue/payui/view/banner/RoundImageView;", "Landroid/widget/ImageView;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "drawBottomLeft", "drawBottomRight", "drawTopLeft", "drawTopRight", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "bottomLeft", "setBottomLeftRadius", "(I)V", "bottomRight", "setBottomRightRadius", "cornerRadius", "setRadius", "topLeft", "setTopLeftRadius", "topRight", "setTopRightRadius", "mBottomLeft", "I", "mBottomRight", "Landroid/graphics/Paint;", "mImagePaint", "Landroid/graphics/Paint;", "mRoundPaint", "mTopToLeft", "mTopToRight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public final class RoundImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f80357e;

    /* renamed from: f  reason: collision with root package name */
    public int f80358f;

    /* renamed from: g  reason: collision with root package name */
    public int f80359g;

    /* renamed from: h  reason: collision with root package name */
    public int f80360h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f80361i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f80362j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f80359g <= 0) {
            return;
        }
        int height = getHeight();
        Path path = new Path();
        float f2 = height;
        path.moveTo(0.0f, f2 - this.f80359g);
        path.lineTo(0.0f, f2);
        path.lineTo(this.f80359g, f2);
        float f3 = 2;
        int i2 = this.f80359g;
        path.arcTo(new RectF(0.0f, f2 - (i2 * f3), i2 * f3, f2), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f80361i);
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f80360h <= 0) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f2 = width;
        float f3 = height;
        path.moveTo(f2 - this.f80360h, f3);
        path.lineTo(f2, f3);
        path.lineTo(f2, f3 - this.f80360h);
        float f4 = 2;
        int i2 = this.f80360h;
        path.arcTo(new RectF(f2 - (i2 * f4), f3 - (f4 * i2), f2, f3), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f80361i);
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.f80357e <= 0) {
            return;
        }
        Path path = new Path();
        path.moveTo(0.0f, this.f80357e);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f80357e, 0.0f);
        int i2 = this.f80357e;
        float f2 = 2;
        path.arcTo(new RectF(0.0f, 0.0f, i2 * f2, i2 * f2), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f80361i);
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || this.f80358f <= 0) {
            return;
        }
        int width = getWidth();
        Path path = new Path();
        float f2 = width;
        path.moveTo(f2 - this.f80358f, 0.0f);
        path.lineTo(f2, 0.0f);
        path.lineTo(f2, this.f80358f);
        float f3 = 2;
        int i2 = this.f80358f;
        path.arcTo(new RectF(f2 - (i2 * f3), 0.0f, f2, i2 * f3), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f80361i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (canvas != null) {
                canvas.saveLayer(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f80362j, 31);
            }
            super.draw(canvas);
            if (canvas == null) {
                Intrinsics.throwNpe();
            }
            c(canvas);
            d(canvas);
            a(canvas);
            b(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public final void setBottomLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f80359g = i2;
            invalidate();
        }
    }

    public final void setBottomRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f80360h = i2;
            invalidate();
        }
    }

    public final void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f80357e = i2;
            this.f80358f = i2;
            this.f80359g = i2;
            this.f80360h = i2;
            invalidate();
        }
    }

    public final void setTopLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f80357e = i2;
            invalidate();
        }
    }

    public final void setTopRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f80358f = i2;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f80361i = new Paint();
        this.f80362j = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.PayUi_RoundImageView, i2, 0);
        this.f80357e = obtainStyledAttributes.getDimensionPixelSize(h.PayUi_RoundImageView_payUiTopLeftRadius, 0);
        this.f80358f = obtainStyledAttributes.getDimensionPixelSize(h.PayUi_RoundImageView_payUiTopRightRadius, 0);
        this.f80359g = obtainStyledAttributes.getDimensionPixelSize(h.PayUi_RoundImageView_payUiBottomLeftRadius, 0);
        this.f80360h = obtainStyledAttributes.getDimensionPixelSize(h.PayUi_RoundImageView_payUiBottomRightRadius, 0);
        obtainStyledAttributes.recycle();
        this.f80361i.setColor(-1);
        this.f80361i.setAntiAlias(true);
        this.f80361i.setStyle(Paint.Style.FILL);
        this.f80361i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f80362j.setXfermode(null);
    }
}
