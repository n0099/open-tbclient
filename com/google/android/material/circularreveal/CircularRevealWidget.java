package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;
/* loaded from: classes2.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static /* synthetic */ Interceptable $ic;
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL;
        public transient /* synthetic */ FieldHolder $fh;
        public final RevealInfo revealInfo;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(174091573, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealEvaluator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(174091573, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealEvaluator;");
                    return;
                }
            }
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.revealInfo = new RevealInfo((AnonymousClass1) null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        @NonNull
        public RevealInfo evaluate(float f2, @NonNull RevealInfo revealInfo, @NonNull RevealInfo revealInfo2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), revealInfo, revealInfo2})) == null) {
                this.revealInfo.set(MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f2), MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f2), MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f2));
                return this.revealInfo;
            }
            return (RevealInfo) invokeCommon.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static /* synthetic */ Interceptable $ic;
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1472069789, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealProperty;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1472069789, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealProperty;");
                    return;
                }
            }
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Class) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        @Nullable
        public RevealInfo get(@NonNull CircularRevealWidget circularRevealWidget) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, circularRevealWidget)) == null) ? circularRevealWidget.getRevealInfo() : (RevealInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @Nullable RevealInfo revealInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, circularRevealWidget, revealInfo) == null) {
                circularRevealWidget.setRevealInfo(revealInfo);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-603291104, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealScrimColorProperty;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-603291104, "Lcom/google/android/material/circularreveal/CircularRevealWidget$CircularRevealScrimColorProperty;");
                    return;
                }
            }
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Class) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        @NonNull
        public Integer get(@NonNull CircularRevealWidget circularRevealWidget) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, circularRevealWidget)) == null) ? Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor()) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, circularRevealWidget, num) == null) {
                circularRevealWidget.setCircularRevealScrimColor(num.intValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class RevealInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public float centerX;
        public float centerY;
        public float radius;

        public /* synthetic */ RevealInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean isInvalid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.radius == Float.MAX_VALUE : invokeV.booleanValue;
        }

        public void set(float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.centerX = f2;
                this.centerY = f3;
                this.radius = f4;
            }
        }

        public RevealInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public RevealInfo(float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }

        public void set(@NonNull RevealInfo revealInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, revealInfo) == null) {
                set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RevealInfo(@NonNull RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {revealInfo};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable RevealInfo revealInfo);
}
