package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
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
/* loaded from: classes7.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(RevealInfo revealInfo);

    /* loaded from: classes7.dex */
    public class CircularRevealEvaluator implements TypeEvaluator {
        public static /* synthetic */ Interceptable $ic;
        public static final TypeEvaluator CIRCULAR_REVEAL;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.revealInfo = new RevealInfo((AnonymousClass1) null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public RevealInfo evaluate(float f, RevealInfo revealInfo, RevealInfo revealInfo2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), revealInfo, revealInfo2})) == null) {
                this.revealInfo.set(MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f), MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f), MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f));
                return this.revealInfo;
            }
            return (RevealInfo) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class CircularRevealProperty extends Property {
        public static /* synthetic */ Interceptable $ic;
        public static final Property CIRCULAR_REVEAL;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public RevealInfo get(CircularRevealWidget circularRevealWidget) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, circularRevealWidget)) == null) {
                return circularRevealWidget.getRevealInfo();
            }
            return (RevealInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, circularRevealWidget, revealInfo) == null) {
                circularRevealWidget.setRevealInfo(revealInfo);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class CircularRevealScrimColorProperty extends Property {
        public static /* synthetic */ Interceptable $ic;
        public static final Property CIRCULAR_REVEAL_SCRIM_COLOR;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public Integer get(CircularRevealWidget circularRevealWidget) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, circularRevealWidget)) == null) {
                return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(CircularRevealWidget circularRevealWidget, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, circularRevealWidget, num) == null) {
                circularRevealWidget.setCircularRevealScrimColor(num.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class RevealInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public float centerX;
        public float centerY;
        public float radius;

        public RevealInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isInvalid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.radius == Float.MAX_VALUE) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public RevealInfo(float f, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.centerX = f;
            this.centerY = f2;
            this.radius = f3;
        }

        public /* synthetic */ RevealInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void set(RevealInfo revealInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, revealInfo) == null) {
                set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RevealInfo(RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {revealInfo};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Float) objArr2[0]).floatValue(), ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public void set(float f, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.centerX = f;
                this.centerY = f2;
                this.radius = f3;
            }
        }
    }
}
