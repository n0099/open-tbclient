package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEF_STYLE_RES;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint borderPaint;
    public final Paint clearPaint;
    public final RectF destination;
    public Path maskPath;
    public final RectF maskRect;
    public final Path path;
    public final ShapeAppearancePathProvider pathProvider;
    public final MaterialShapeDrawable shadowDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorStateList strokeColor;
    @Dimension
    public float strokeWidth;

    @TargetApi(21)
    /* loaded from: classes2.dex */
    public class OutlineProvider extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect rect;
        public final /* synthetic */ ShapeableImageView this$0;

        public OutlineProvider(ShapeableImageView shapeableImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shapeableImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = shapeableImageView;
            this.rect = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, outline) == null) || this.this$0.shapeAppearanceModel == null) {
                return;
            }
            this.this$0.destination.round(this.rect);
            this.this$0.shadowDrawable.setBounds(this.rect);
            this.this$0.shadowDrawable.getOutline(outline);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1481047227, "Lcom/google/android/material/imageview/ShapeableImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1481047227, "Lcom/google/android/material/imageview/ShapeableImageView;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShapeableImageView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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

    private void drawStroke(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, canvas) == null) || this.strokeColor == null) {
            return;
        }
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f || colorForState == 0) {
            return;
        }
        this.borderPaint.setColor(colorForState);
        canvas.drawPath(this.path, this.borderPaint);
    }

    private void updateShapeMask(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65544, this, i2, i3) == null) {
            this.destination.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
            this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
            this.maskPath.rewind();
            this.maskPath.addPath(this.path);
            this.maskRect.set(0.0f, 0.0f, i2, i3);
            this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.shapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.strokeColor : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.strokeWidth : invokeV.floatValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            setLayerType(2, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setLayerType(0, null);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawPath(this.maskPath, this.clearPaint);
            drawStroke(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            updateShapeMask(i2, i3);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, shapeAppearanceModel) == null) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.shadowDrawable.setShapeAppearanceModel(shapeAppearanceModel);
            updateShapeMask(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, colorStateList) == null) {
            this.strokeColor = colorStateList;
            invalidate();
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Dimension float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048586, this, f2) == null) || this.strokeWidth == f2) {
            return;
        }
        this.strokeWidth = f2;
        invalidate();
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, DEF_STYLE_RES), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.pathProvider = new ShapeAppearancePathProvider();
        this.path = new Path();
        Context context2 = getContext();
        Paint paint = new Paint();
        this.clearPaint = paint;
        paint.setAntiAlias(true);
        this.clearPaint.setColor(-1);
        this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i2, DEF_STYLE_RES);
        this.strokeColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.borderPaint.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i2, DEF_STYLE_RES).build();
        this.shadowDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider(this));
        }
    }
}
