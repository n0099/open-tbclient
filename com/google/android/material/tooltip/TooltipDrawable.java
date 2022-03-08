package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    @StyleRes

    /* renamed from: DEFAULT_STYLE */
    public static final int Widget_MaterialComponents_Tooltip = 2131755955;
    @AttrRes
    public static final int DEFAULT_THEME_ATTR = 2130970239;
    public transient /* synthetic */ FieldHolder $fh;
    public int arrowSize;
    @NonNull
    public final View.OnLayoutChangeListener attachedViewLayoutChangeListener;
    @NonNull
    public final Context context;
    @NonNull
    public final Rect displayFrame;
    @Nullable
    public final Paint.FontMetrics fontMetrics;
    public int layoutMargin;
    public int locationOnScreenX;
    public int minHeight;
    public int minWidth;
    public int padding;
    @Nullable
    public CharSequence text;
    @NonNull
    public final TextDrawableHelper textDrawableHelper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1014664274, "Lcom/google/android/material/tooltip/TooltipDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1014664274, "Lcom/google/android/material/tooltip/TooltipDrawable;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fontMetrics = new Paint.FontMetrics();
        this.textDrawableHelper = new TextDrawableHelper(this);
        this.attachedViewLayoutChangeListener = new View.OnLayoutChangeListener(this) { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TooltipDrawable this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)}) == null) {
                    this.this$0.updateLocationOnScreen(view);
                }
            }
        };
        this.displayFrame = new Rect();
        this.context = context;
        this.textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    private float calculatePointerOffset() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
                i2 = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
            } else if (((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
                return 0.0f;
            } else {
                i2 = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
            }
            return i2;
        }
        return invokeV.floatValue;
    }

    private float calculateTextCenterFromBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
            Paint.FontMetrics fontMetrics = this.fontMetrics;
            return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
        }
        return invokeV.floatValue;
    }

    private float calculateTextOriginAndAlignment(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, rect)) == null) ? rect.centerY() - calculateTextCenterFromBaseline() : invokeL.floatValue;
    }

    @NonNull
    public static TooltipDrawable create(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? createFromAttributes(context, null, DEFAULT_THEME_ATTR, Widget_MaterialComponents_Tooltip) : (TooltipDrawable) invokeL.objValue;
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, context, attributeSet, i2, i3)) == null) {
            TooltipDrawable tooltipDrawable = new TooltipDrawable(context, attributeSet, i2, i3);
            tooltipDrawable.loadFromAttributes(attributeSet, i2, i3);
            return tooltipDrawable;
        }
        return (TooltipDrawable) invokeLLII.objValue;
    }

    private EdgeTreatment createMarkerEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            float width = ((float) (getBounds().width() - (this.arrowSize * Math.sqrt(2.0d)))) / 2.0f;
            return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(-calculatePointerOffset(), -width), width));
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    private void drawText(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, canvas) == null) || this.text == null) {
            return;
        }
        Rect bounds = getBounds();
        int calculateTextOriginAndAlignment = (int) calculateTextOriginAndAlignment(bounds);
        if (this.textDrawableHelper.getTextAppearance() != null) {
            this.textDrawableHelper.getTextPaint().drawableState = getState();
            this.textDrawableHelper.updateTextPaintDrawState(this.context);
        }
        CharSequence charSequence = this.text;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), calculateTextOriginAndAlignment, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            CharSequence charSequence = this.text;
            if (charSequence == null) {
                return 0.0f;
            }
            return this.textDrawableHelper.getTextWidth(charSequence.toString());
        }
        return invokeV.floatValue;
    }

    private void loadFromAttributes(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65548, this, attributeSet, i2, i3) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, new int[]{16842804, 16842965, 16842998, 16843071, 16843072, 16843087, R.attr.backgroundTint}, i2, i3, new int[0]);
            this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
            setText(obtainStyledAttributes.getText(5));
            setTextAppearance(MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, 0));
            setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(6, MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, (int) R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153)))));
            setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, (int) R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
            this.padding = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.minWidth = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.minHeight = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.layoutMargin = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocationOnScreen(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, view) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.locationOnScreenX = iArr[0];
            view.getWindowVisibleDisplayFrame(this.displayFrame);
        }
    }

    public void detachView(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.save();
            canvas.translate(calculatePointerOffset(), (float) (-((this.arrowSize * Math.sqrt(2.0d)) - this.arrowSize)));
            super.draw(canvas);
            drawText(canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight) : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) Math.max((this.padding * 2) + getTextWidth(), this.minWidth) : invokeV.intValue;
    }

    public int getLayoutMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.layoutMargin : invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.minHeight : invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.minWidth : invokeV.intValue;
    }

    @Nullable
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.text : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.textDrawableHelper.getTextAppearance() : (TextAppearance) invokeV.objValue;
    }

    public int getTextPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.padding : invokeV.intValue;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            super.onBoundsChange(rect);
            setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iArr)) == null) ? super.onStateChange(iArr) : invokeL.booleanValue;
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            invalidateSelf();
        }
    }

    public void setLayoutMargin(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.layoutMargin = i2;
            invalidateSelf();
        }
    }

    public void setMinHeight(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.minHeight = i2;
            invalidateSelf();
        }
    }

    public void setMinWidth(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.minWidth = i2;
            invalidateSelf();
        }
    }

    public void setRelativeToView(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || view == null) {
            return;
        }
        updateLocationOnScreen(view);
        view.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, charSequence) == null) || TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textAppearance) == null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
        }
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            setTextAppearance(new TextAppearance(this.context, i2));
        }
    }

    public void setTextPadding(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.padding = i2;
            invalidateSelf();
        }
    }

    public void setTextResource(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            setText(this.context.getResources().getString(i2));
        }
    }

    @NonNull
    public static TooltipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, attributeSet)) == null) ? createFromAttributes(context, attributeSet, DEFAULT_THEME_ATTR, Widget_MaterialComponents_Tooltip) : (TooltipDrawable) invokeLL.objValue;
    }
}
