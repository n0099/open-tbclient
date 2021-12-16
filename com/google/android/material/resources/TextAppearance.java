package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class TextAppearance {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TextAppearance";
    public static final int TYPEFACE_MONOSPACE = 3;
    public static final int TYPEFACE_SANS = 1;
    public static final int TYPEFACE_SERIF = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public Typeface font;
    @Nullable
    public final String fontFamily;
    @FontRes
    public final int fontFamilyResourceId;
    public boolean fontResolved;
    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    @Nullable
    public final ColorStateList textColor;
    @Nullable
    public final ColorStateList textColorHint;
    @Nullable
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context context, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontResolved = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void createFallbackFont() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.font == null && (str = this.fontFamily) != null) {
                this.font = Typeface.create(str, this.textStyle);
            }
            if (this.font == null) {
                int i2 = this.typeface;
                if (i2 == 1) {
                    this.font = Typeface.SANS_SERIF;
                } else if (i2 == 2) {
                    this.font = Typeface.SERIF;
                } else if (i2 != 3) {
                    this.font = Typeface.DEFAULT;
                } else {
                    this.font = Typeface.MONOSPACE;
                }
                this.font = Typeface.create(this.font, this.textStyle);
            }
        }
    }

    public Typeface getFallbackFont() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            createFallbackFont();
            return this.font;
        }
        return (Typeface) invokeV.objValue;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.fontResolved) {
                return this.font;
            }
            if (!context.isRestricted()) {
                try {
                    Typeface font = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                    this.font = font;
                    if (font != null) {
                        this.font = Typeface.create(font, this.textStyle);
                    }
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                } catch (Exception unused2) {
                    String str = "Error loading font " + this.fontFamily;
                }
            }
            createFallbackFont();
            this.fontResolved = true;
            return this.font;
        }
        return (Typeface) invokeL.objValue;
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, textAppearanceFontCallback) == null) {
            if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
                getFont(context);
            } else {
                createFallbackFont();
            }
            if (this.fontFamilyResourceId == 0) {
                this.fontResolved = true;
            }
            if (this.fontResolved) {
                textAppearanceFontCallback.onFontRetrieved(this.font, true);
                return;
            }
            try {
                ResourcesCompat.getFont(context, this.fontFamilyResourceId, new ResourcesCompat.FontCallback(this, textAppearanceFontCallback) { // from class: com.google.android.material.resources.TextAppearance.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TextAppearance this$0;
                    public final /* synthetic */ TextAppearanceFontCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, textAppearanceFontCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = textAppearanceFontCallback;
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.this$0.fontResolved = true;
                            this.val$callback.onFontRetrievalFailed(i2);
                        }
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrieved(@NonNull Typeface typeface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface) == null) {
                            TextAppearance textAppearance = this.this$0;
                            textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                            this.this$0.fontResolved = true;
                            this.val$callback.onFontRetrieved(this.this$0.font, false);
                        }
                    }
                }, null);
            } catch (Resources.NotFoundException unused) {
                this.fontResolved = true;
                textAppearanceFontCallback.onFontRetrievalFailed(1);
            } catch (Exception unused2) {
                String str = "Error loading font " + this.fontFamily;
                this.fontResolved = true;
                textAppearanceFontCallback.onFontRetrievalFailed(-3);
            }
        }
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, textPaint, textAppearanceFontCallback) == null) {
            updateMeasureState(context, textPaint, textAppearanceFontCallback);
            ColorStateList colorStateList = this.textColor;
            textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
            float f2 = this.shadowRadius;
            float f3 = this.shadowDx;
            float f4 = this.shadowDy;
            ColorStateList colorStateList2 = this.shadowColor;
            textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
        }
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, textPaint, textAppearanceFontCallback) == null) {
            if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
                updateTextPaintMeasureState(textPaint, getFont(context));
            } else {
                getFontAsync(context, textPaint, textAppearanceFontCallback);
            }
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, textPaint, typeface) == null) {
            textPaint.setTypeface(typeface);
            int i2 = (~typeface.getStyle()) & this.textStyle;
            textPaint.setFakeBoldText((i2 & 1) != 0);
            textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            textPaint.setTextSize(this.textSize);
        }
    }

    public void getFontAsync(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, textPaint, textAppearanceFontCallback) == null) {
            updateTextPaintMeasureState(textPaint, getFallbackFont());
            getFontAsync(context, new TextAppearanceFontCallback(this, textPaint, textAppearanceFontCallback) { // from class: com.google.android.material.resources.TextAppearance.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TextAppearance this$0;
                public final /* synthetic */ TextAppearanceFontCallback val$callback;
                public final /* synthetic */ TextPaint val$textPaint;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, textPaint, textAppearanceFontCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$textPaint = textPaint;
                    this.val$callback = textAppearanceFontCallback;
                }

                @Override // com.google.android.material.resources.TextAppearanceFontCallback
                public void onFontRetrievalFailed(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.val$callback.onFontRetrievalFailed(i2);
                    }
                }

                @Override // com.google.android.material.resources.TextAppearanceFontCallback
                public void onFontRetrieved(@NonNull Typeface typeface, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface, z) == null) {
                        this.this$0.updateTextPaintMeasureState(this.val$textPaint, typeface);
                        this.val$callback.onFontRetrieved(typeface, z);
                    }
                }
            });
        }
    }
}
