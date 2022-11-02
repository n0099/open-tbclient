package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class TextDrawableHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WeakReference<TextDrawableDelegate> delegate;
    public final TextAppearanceFontCallback fontCallback;
    @Nullable
    public TextAppearance textAppearance;
    public final TextPaint textPaint;
    public float textWidth;
    public boolean textWidthDirty;

    /* loaded from: classes7.dex */
    public interface TextDrawableDelegate {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate textDrawableDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textDrawableDelegate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.textPaint = new TextPaint(1);
        this.fontCallback = new TextAppearanceFontCallback(this) { // from class: com.google.android.material.internal.TextDrawableHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextDrawableHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeI(1048576, this, i3) != null) {
                    return;
                }
                this.this$0.textWidthDirty = true;
                TextDrawableDelegate textDrawableDelegate2 = (TextDrawableDelegate) this.this$0.delegate.get();
                if (textDrawableDelegate2 != null) {
                    textDrawableDelegate2.onTextSizeChange();
                }
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(@NonNull Typeface typeface, boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface, z) == null) && !z) {
                    this.this$0.textWidthDirty = true;
                    TextDrawableDelegate textDrawableDelegate2 = (TextDrawableDelegate) this.this$0.delegate.get();
                    if (textDrawableDelegate2 != null) {
                        textDrawableDelegate2.onTextSizeChange();
                    }
                }
            }
        };
        this.textWidthDirty = true;
        this.delegate = new WeakReference<>(null);
        setDelegate(textDrawableDelegate);
    }

    private float calculateTextWidth(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, charSequence)) == null) {
            if (charSequence == null) {
                return 0.0f;
            }
            return this.textPaint.measureText(charSequence, 0, charSequence.length());
        }
        return invokeL.floatValue;
    }

    public float getTextWidth(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.textWidthDirty) {
                return this.textWidth;
            }
            float calculateTextWidth = calculateTextWidth(str);
            this.textWidth = calculateTextWidth;
            this.textWidthDirty = false;
            return calculateTextWidth;
        }
        return invokeL.floatValue;
    }

    public void setDelegate(@Nullable TextDrawableDelegate textDrawableDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textDrawableDelegate) == null) {
            this.delegate = new WeakReference<>(textDrawableDelegate);
        }
    }

    public void setTextWidthDirty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.textWidthDirty = z;
        }
    }

    public void updateTextPaintDrawState(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
        }
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.textAppearance;
        }
        return (TextAppearance) invokeV.objValue;
    }

    @NonNull
    public TextPaint getTextPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.textPaint;
        }
        return (TextPaint) invokeV.objValue;
    }

    public boolean isTextWidthDirty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.textWidthDirty;
        }
        return invokeV.booleanValue;
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, textAppearance, context) == null) && this.textAppearance != textAppearance) {
            this.textAppearance = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.textPaint, this.fontCallback);
                TextDrawableDelegate textDrawableDelegate = this.delegate.get();
                if (textDrawableDelegate != null) {
                    this.textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }
}
