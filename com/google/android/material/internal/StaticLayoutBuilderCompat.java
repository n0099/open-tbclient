package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public final class StaticLayoutBuilderCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    public static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    public static final String TEXT_DIR_CLASS_LTR = "LTR";
    public static final String TEXT_DIR_CLASS_RTL = "RTL";
    @Nullable
    public static Constructor<StaticLayout> constructor;
    public static boolean initialized;
    @Nullable
    public static Object textDirection;
    public transient /* synthetic */ FieldHolder $fh;
    public Layout.Alignment alignment;
    @Nullable
    public TextUtils.TruncateAt ellipsize;
    public int end;
    public boolean includePad;
    public boolean isRtl;
    public int maxLines;
    public final TextPaint paint;
    public CharSequence source;
    public int start;
    public final int width;

    /* loaded from: classes6.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charSequence, textPaint, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i;
        this.start = 0;
        this.end = charSequence.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || initialized) {
            return;
        }
        try {
            boolean z = this.isRtl && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                textDirection = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                String str = this.isRtl ? TEXT_DIR_CLASS_RTL : TEXT_DIR_CLASS_LTR;
                Class<?> loadClass = classLoader.loadClass(TEXT_DIR_CLASS);
                Class<?> loadClass2 = classLoader.loadClass(TEXT_DIRS_CLASS);
                textDirection = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            constructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
            initialized = true;
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, charSequence, textPaint, i)) == null) ? new StaticLayoutBuilderCompat(charSequence, textPaint, i) : (StaticLayoutBuilderCompat) invokeLLI.objValue;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.source == null) {
                this.source = "";
            }
            int max = Math.max(0, this.width);
            CharSequence charSequence = this.source;
            if (this.maxLines == 1) {
                charSequence = TextUtils.ellipsize(charSequence, this.paint, max, this.ellipsize);
            }
            this.end = Math.min(charSequence.length(), this.end);
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.isRtl) {
                    this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.start, this.end, this.paint, max);
                obtain.setAlignment(this.alignment);
                obtain.setIncludePad(this.includePad);
                obtain.setTextDirection(this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
                TextUtils.TruncateAt truncateAt = this.ellipsize;
                if (truncateAt != null) {
                    obtain.setEllipsize(truncateAt);
                }
                obtain.setMaxLines(this.maxLines);
                return obtain.build();
            }
            createConstructorWithReflection();
            try {
                return (StaticLayout) ((Constructor) Preconditions.checkNotNull(constructor)).newInstance(charSequence, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(max), this.alignment, Preconditions.checkNotNull(textDirection), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines));
            } catch (Exception e2) {
                throw new StaticLayoutBuilderCompatException(e2);
            }
        }
        return (StaticLayout) invokeV.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment alignment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alignment)) == null) {
            this.alignment = alignment;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeL.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, truncateAt)) == null) {
            this.ellipsize = truncateAt;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeL.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.end = i;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeI.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.includePad = z;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeZ.objValue;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.isRtl = z;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeZ.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.maxLines = i;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeI.objValue;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.start = i;
            return this;
        }
        return (StaticLayoutBuilderCompat) invokeI.objValue;
    }
}
