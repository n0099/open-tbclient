package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    public static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    public static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    @StyleRes

    /* renamed from: DEFAULT_STYLE */
    public static final int obfuscated_res_0x7f10033e = 2131755838;
    @AttrRes
    public static final int DEFAULT_THEME_ATTR = 2130968759;
    public static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WeakReference<View> anchorViewRef;
    @NonNull
    public final Rect badgeBounds;
    public float badgeCenterX;
    public float badgeCenterY;
    public final float badgeRadius;
    public final float badgeWidePadding;
    public final float badgeWithTextRadius;
    @NonNull
    public final WeakReference<Context> contextRef;
    public float cornerRadius;
    @Nullable
    public WeakReference<ViewGroup> customBadgeParentRef;
    public float halfBadgeHeight;
    public float halfBadgeWidth;
    public int maxBadgeNumber;
    @NonNull
    public final SavedState savedState;
    @NonNull
    public final MaterialShapeDrawable shapeDrawable;
    @NonNull
    public final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface BadgeGravity {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(946402834, "Lcom/google/android/material/badge/BadgeDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(946402834, "Lcom/google/android/material/badge/BadgeDrawable;");
        }
    }

    public BadgeDrawable(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        Resources resources = context.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e7);
        this.badgeWidePadding = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e6);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703ea);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        setTextAppearanceResource(R.style.obfuscated_res_0x7f1001fe);
    }

    private void calculateCenterAndBounds(@NonNull Context context, @NonNull Rect rect, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, context, rect, view2) == null) {
            int i = this.savedState.badgeGravity;
            if (i == 8388691 || i == 8388693) {
                this.badgeCenterY = rect.bottom - this.savedState.verticalOffset;
            } else {
                this.badgeCenterY = rect.top + this.savedState.verticalOffset;
            }
            if (getNumber() <= 9) {
                float f = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
                this.cornerRadius = f;
                this.halfBadgeHeight = f;
                this.halfBadgeWidth = f;
            } else {
                float f2 = this.badgeWithTextRadius;
                this.cornerRadius = f2;
                this.halfBadgeHeight = f2;
                this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? R.dimen.obfuscated_res_0x7f0703e8 : R.dimen.obfuscated_res_0x7f0703e5);
            int i2 = this.savedState.badgeGravity;
            if (i2 != 8388659 && i2 != 8388691) {
                this.badgeCenterX = ViewCompat.getLayoutDirection(view2) == 0 ? ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - this.savedState.horizontalOffset : (rect.left - this.halfBadgeWidth) + dimensionPixelSize + this.savedState.horizontalOffset;
            } else {
                this.badgeCenterX = ViewCompat.getLayoutDirection(view2) == 0 ? (rect.left - this.halfBadgeWidth) + dimensionPixelSize + this.savedState.horizontalOffset : ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - this.savedState.horizontalOffset;
            }
        }
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? createFromAttributes(context, null, DEFAULT_THEME_ATTR, obfuscated_res_0x7f10033e) : (BadgeDrawable) invokeL.objValue;
    }

    @NonNull
    public static BadgeDrawable createFromAttributes(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, attributeSet, i, i2)) == null) {
            BadgeDrawable badgeDrawable = new BadgeDrawable(context);
            badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i, i2);
            return badgeDrawable;
        }
        return (BadgeDrawable) invokeLLII.objValue;
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context context, @XmlRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "badge");
            int styleAttribute = parseDrawableXml.getStyleAttribute();
            if (styleAttribute == 0) {
                styleAttribute = obfuscated_res_0x7f10033e;
            }
            return createFromAttributes(context, parseDrawableXml, DEFAULT_THEME_ATTR, styleAttribute);
        }
        return (BadgeDrawable) invokeLI.objValue;
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context context, @NonNull SavedState savedState) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, savedState)) == null) {
            BadgeDrawable badgeDrawable = new BadgeDrawable(context);
            badgeDrawable.restoreFromSavedState(savedState);
            return badgeDrawable;
        }
        return (BadgeDrawable) invokeLL.objValue;
    }

    private void drawText(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            Rect rect = new Rect();
            String badgeText = getBadgeText();
            this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
            canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), this.textDrawableHelper.getTextPaint());
        }
    }

    @NonNull
    private String getBadgeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (getNumber() <= this.maxBadgeNumber) {
                return Integer.toString(getNumber());
            }
            Context context = this.contextRef.get();
            return context == null ? "" : context.getString(R.string.obfuscated_res_0x7f0f0b02, Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        }
        return (String) invokeV.objValue;
    }

    private void loadDefaultStateFromAttributes(Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65545, this, context, attributeSet, i, i2) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400a8, R.attr.obfuscated_res_0x7f0400b6, R.attr.obfuscated_res_0x7f0400b8, R.attr.obfuscated_res_0x7f0402ed, R.attr.obfuscated_res_0x7f04045e, R.attr.obfuscated_res_0x7f040498, R.attr.obfuscated_res_0x7f0406c6}, i, i2, new int[0]);
            setMaxCharacterCount(obtainStyledAttributes.getInt(4, 4));
            if (obtainStyledAttributes.hasValue(5)) {
                setNumber(obtainStyledAttributes.getInt(5, 0));
            }
            setBackgroundColor(readColorFromAttributes(context, obtainStyledAttributes, 0));
            if (obtainStyledAttributes.hasValue(2)) {
                setBadgeTextColor(readColorFromAttributes(context, obtainStyledAttributes, 2));
            }
            setBadgeGravity(obtainStyledAttributes.getInt(1, TOP_END));
            setHorizontalOffset(obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setVerticalOffset(obtainStyledAttributes.getDimensionPixelOffset(6, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public static int readColorFromAttributes(Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, context, typedArray, i)) == null) ? MaterialResources.getColorStateList(context, typedArray, i).getDefaultColor() : invokeLLI.intValue;
    }

    private void restoreFromSavedState(@NonNull SavedState savedState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, savedState) == null) {
            setMaxCharacterCount(savedState.maxCharacterCount);
            if (savedState.number != -1) {
                setNumber(savedState.number);
            }
            setBackgroundColor(savedState.backgroundColor);
            setBadgeTextColor(savedState.badgeTextColor);
            setBadgeGravity(savedState.badgeGravity);
            setHorizontalOffset(savedState.horizontalOffset);
            setVerticalOffset(savedState.verticalOffset);
        }
    }

    private void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, textAppearance) == null) || this.textDrawableHelper.getTextAppearance() == textAppearance || (context = this.contextRef.get()) == null) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(@StyleRes int i) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65549, this, i) == null) || (context = this.contextRef.get()) == null) {
            return;
        }
        setTextAppearance(new TextAppearance(context, i));
    }

    private void updateCenterAndBounds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            Context context = this.contextRef.get();
            WeakReference<View> weakReference = this.anchorViewRef;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (context == null || view2 == null) {
                return;
            }
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view2.getDrawingRect(rect2);
            WeakReference<ViewGroup> weakReference2 = this.customBadgeParentRef;
            ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
            if (viewGroup != null || BadgeUtils.USE_COMPAT_PARENT) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view2.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view2, rect2);
            }
            calculateCenterAndBounds(context, rect2, view2);
            BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
            this.shapeDrawable.setCornerSize(this.cornerRadius);
            if (rect.equals(this.badgeBounds)) {
                return;
            }
            this.shapeDrawable.setBounds(this.badgeBounds);
        }
    }

    private void updateMaxBadgeNumber() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
        }
    }

    public void clearNumber() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.savedState.number = -1;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            drawText(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.savedState.alpha : invokeV.intValue;
    }

    @ColorInt
    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.shapeDrawable.getFillColor().getDefaultColor() : invokeV.intValue;
    }

    public int getBadgeGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.savedState.badgeGravity : invokeV.intValue;
    }

    @ColorInt
    public int getBadgeTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.textDrawableHelper.getTextPaint().getColor() : invokeV.intValue;
    }

    @Nullable
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isVisible()) {
                if (hasNumber()) {
                    if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
                        return null;
                    }
                    if (getNumber() <= this.maxBadgeNumber) {
                        return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), Integer.valueOf(getNumber()));
                    }
                    return context.getString(this.savedState.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(this.maxBadgeNumber));
                }
                return this.savedState.contentDescriptionNumberless;
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getHorizontalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.savedState.horizontalOffset : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.badgeBounds.height() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.badgeBounds.width() : invokeV.intValue;
    }

    public int getMaxCharacterCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.savedState.maxCharacterCount : invokeV.intValue;
    }

    public int getNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (hasNumber()) {
                return this.savedState.number;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @NonNull
    public SavedState getSavedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.savedState : (SavedState) invokeV.objValue;
    }

    public int getVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.savedState.verticalOffset : invokeV.intValue;
    }

    public boolean hasNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.savedState.number != -1 : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, iArr)) == null) ? super.onStateChange(iArr) : invokeL.booleanValue;
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.savedState.alpha = i;
            this.textDrawableHelper.getTextPaint().setAlpha(i);
            invalidateSelf();
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.savedState.backgroundColor = i;
            ColorStateList valueOf = ColorStateList.valueOf(i);
            if (this.shapeDrawable.getFillColor() != valueOf) {
                this.shapeDrawable.setFillColor(valueOf);
                invalidateSelf();
            }
        }
    }

    public void setBadgeGravity(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || this.savedState.badgeGravity == i) {
            return;
        }
        this.savedState.badgeGravity = i;
        WeakReference<View> weakReference = this.anchorViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view2 = this.anchorViewRef.get();
        WeakReference<ViewGroup> weakReference2 = this.customBadgeParentRef;
        updateBadgeCoordinates(view2, weakReference2 != null ? weakReference2.get() : null);
    }

    public void setBadgeTextColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.savedState.badgeTextColor = i;
            if (this.textDrawableHelper.getTextPaint().getColor() != i) {
                this.textDrawableHelper.getTextPaint().setColor(i);
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorFilter) == null) {
        }
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.savedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
        }
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, charSequence) == null) {
            this.savedState.contentDescriptionNumberless = charSequence;
        }
    }

    public void setContentDescriptionQuantityStringsResource(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.savedState.contentDescriptionQuantityStrings = i;
        }
    }

    public void setHorizontalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.savedState.horizontalOffset = i;
            updateCenterAndBounds();
        }
    }

    public void setMaxCharacterCount(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || this.savedState.maxCharacterCount == i) {
            return;
        }
        this.savedState.maxCharacterCount = i;
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public void setNumber(int i) {
        int max;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || this.savedState.number == (max = Math.max(0, i))) {
            return;
        }
        this.savedState.number = max;
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public void setVerticalOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.savedState.verticalOffset = i;
            updateCenterAndBounds();
        }
    }

    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            setVisible(z, false);
        }
    }

    public void updateBadgeCoordinates(@NonNull View view2, @Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, view2, viewGroup) == null) {
            this.anchorViewRef = new WeakReference<>(view2);
            this.customBadgeParentRef = new WeakReference<>(viewGroup);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes4.dex */
    public static final class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int alpha;
        @ColorInt
        public int backgroundColor;
        public int badgeGravity;
        @ColorInt
        public int badgeTextColor;
        @StringRes
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        @Nullable
        public CharSequence contentDescriptionNumberless;
        @PluralsRes
        public int contentDescriptionQuantityStrings;
        @Dimension(unit = 1)
        public int horizontalOffset;
        public int maxCharacterCount;
        public int number;
        @Dimension(unit = 1)
        public int verticalOffset;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-326721994, "Lcom/google/android/material/badge/BadgeDrawable$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-326721994, "Lcom/google/android/material/badge/BadgeDrawable$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.badge.BadgeDrawable.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        public SavedState(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(context, R.style.obfuscated_res_0x7f1001fe).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.obfuscated_res_0x7f0f0aff);
            this.contentDescriptionQuantityStrings = R.plurals.obfuscated;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.obfuscated_res_0x7f0f0b01;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeInt(this.backgroundColor);
                parcel.writeInt(this.badgeTextColor);
                parcel.writeInt(this.alpha);
                parcel.writeInt(this.number);
                parcel.writeInt(this.maxCharacterCount);
                parcel.writeString(this.contentDescriptionNumberless.toString());
                parcel.writeInt(this.contentDescriptionQuantityStrings);
                parcel.writeInt(this.badgeGravity);
                parcel.writeInt(this.horizontalOffset);
                parcel.writeInt(this.verticalOffset);
            }
        }

        public SavedState(@NonNull Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
        }
    }
}
