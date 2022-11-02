package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
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
/* loaded from: classes7.dex */
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

    public TextAppearance(@NonNull Context context, @StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontResolved = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(0, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 3);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, 4);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
        this.textStyle = obtainStyledAttributes.getInt(2, 0);
        this.typeface = obtainStyledAttributes.getInt(1, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, 12, 10);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(14, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, 6);
        this.shadowDx = obtainStyledAttributes.getFloat(7, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(9, 0.0f);
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
                int i = this.typeface;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            this.font = Typeface.DEFAULT;
                        } else {
                            this.font = Typeface.MONOSPACE;
                        }
                    } else {
                        this.font = Typeface.SERIF;
                    }
                } else {
                    this.font = Typeface.SANS_SERIF;
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
                } catch (Exception e) {
                    Log.d(TAG, "Error loading font " + this.fontFamily, e);
                }
            }
            createFallbackFont();
            this.fontResolved = true;
            return this.font;
        }
        return (Typeface) invokeL.objValue;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                public void onFontRetrievalFailed(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.val$callback.onFontRetrievalFailed(i);
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = textAppearanceFontCallback;
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeI(1048576, this, i) != null) {
                            return;
                        }
                        this.this$0.fontResolved = true;
                        this.val$callback.onFontRetrievalFailed(i);
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
            } catch (Exception e) {
                Log.d(TAG, "Error loading font " + this.fontFamily, e);
                this.fontResolved = true;
                textAppearanceFontCallback.onFontRetrievalFailed(-3);
            }
        }
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, textPaint, textAppearanceFontCallback) == null) {
            updateMeasureState(context, textPaint, textAppearanceFontCallback);
            ColorStateList colorStateList = this.textColor;
            if (colorStateList != null) {
                i = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
            } else {
                i = -16777216;
            }
            textPaint.setColor(i);
            float f = this.shadowRadius;
            float f2 = this.shadowDx;
            float f3 = this.shadowDy;
            ColorStateList colorStateList2 = this.shadowColor;
            if (colorStateList2 != null) {
                i2 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
            } else {
                i2 = 0;
            }
            textPaint.setShadowLayer(f, f2, f3, i2);
        }
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, textPaint, typeface) == null) {
            textPaint.setTypeface(typeface);
            int i = (~typeface.getStyle()) & this.textStyle;
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            textPaint.setFakeBoldText(z);
            if ((i & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint.setTextSkewX(f);
            textPaint.setTextSize(this.textSize);
        }
    }
}
