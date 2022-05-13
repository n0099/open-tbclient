package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m11;
/* loaded from: classes7.dex */
public class v41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public BubblePosition e;
    public boolean f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(24172737, "Lcom/repackage/v41$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(24172737, "Lcom/repackage/v41$a;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            a = iArr;
            try {
                iArr[BubblePosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubblePosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubblePosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubblePosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v41() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0.0f;
        this.d = true;
        this.e = BubblePosition.INVALID;
        this.f = true;
    }

    public int[] a(d51 d51Var, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, d51Var, iArr, bubblePosition)) == null) {
            if (d51Var == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = d51Var.a.getContext();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = d51Var.b.getMeasuredWidth();
            int measuredHeight = d51Var.b.getMeasuredHeight();
            int measuredWidth2 = d51Var.a.getMeasuredWidth();
            int measuredHeight2 = d51Var.a.getMeasuredHeight();
            float f = this.f ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i3 = measuredHeight / 2;
                    if (i3 >= i2) {
                        iArr2[1] = m11.c.a(context, f);
                    } else if (i3 >= measuredHeight2 - i2) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - m11.c.a(context, f);
                    } else {
                        iArr2[1] = iArr[1] - (d51Var.b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - d51Var.b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i4 = measuredWidth / 2;
                if (i4 >= i) {
                    iArr2[0] = m11.c.a(context, f);
                } else if (i4 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - m11.c.a(context, f);
                } else {
                    iArr2[0] = iArr[0] - (d51Var.b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - d51Var.b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d51Var)) == null) {
            if (!d51Var.i()) {
                return BubblePosition.INVALID;
            }
            if (this.d) {
                if (n(d51Var)) {
                    return BubblePosition.UP;
                }
                if (j(d51Var)) {
                    return BubblePosition.DOWN;
                }
                if (k(d51Var)) {
                    return BubblePosition.LEFT;
                }
                if (m(d51Var)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(d51Var, this.e)) {
                return this.e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final int c(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d51Var)) == null) ? (d51Var.a.getMeasuredHeight() - g(d51Var)[1]) - (d51Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int d(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d51Var)) == null) ? g(d51Var)[0] + (d51Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int e(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d51Var)) == null) ? (d51Var.a.getMeasuredWidth() - g(d51Var)[0]) - (d51Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public final int f(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d51Var)) == null) ? g(d51Var)[1] + (d51Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int[] g(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d51Var)) == null) {
            int[] iArr = new int[2];
            d51Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            d51Var.a.getLocationOnScreen(iArr2);
            return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
        }
        return (int[]) invokeL.objValue;
    }

    public final int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (this.f) {
                return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704b9);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704b7);
        }
        return invokeL.intValue;
    }

    public int[] i(BubblePosition bubblePosition, d51 d51Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, d51Var)) == null) {
            if (bubblePosition == null || d51Var == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            d51Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            d51Var.a.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (d51Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - m11.c.a(d51Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (d51Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + d51Var.c.getMeasuredHeight() + m11.c.a(d51Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (d51Var.i.getMeasuredWidth() / 2)) - m11.c.a(d51Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (d51Var.c.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + d51Var.c.getMeasuredWidth() + m11.c.a(d51Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (d51Var.c.getMeasuredHeight() / 2);
            }
            int[] a2 = a(d51Var, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    d51Var.g.setY(((iArr3[1] - a2[1]) - Math.max(d51Var.j.getMeasuredHeight() / 2, d51Var.k.getMeasuredHeight() / 2)) + this.c);
                }
            } else {
                d51Var.g.setX(((iArr3[0] - a2[0]) - Math.max(d51Var.i.getMeasuredWidth() / 2, d51Var.h.getMeasuredWidth() / 2)) + this.c);
            }
            return a2;
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean j(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, d51Var)) == null) ? d51Var.b.getMeasuredHeight() + m11.c.a(d51Var.c.getContext(), this.b) <= (d51Var.a.getMeasuredHeight() - d51Var.c.getMeasuredHeight()) - g(d51Var)[1] && p(d51Var) : invokeL.booleanValue;
    }

    public final boolean k(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, d51Var)) == null) ? d51Var.b.getMeasuredWidth() + m11.c.a(d51Var.c.getContext(), this.b) <= g(d51Var)[0] && o(d51Var) : invokeL.booleanValue;
    }

    public final boolean l(d51 d51Var, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, d51Var, bubblePosition)) == null) {
            int i = a.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return m(d51Var);
                    }
                    return k(d51Var);
                }
                return j(d51Var);
            }
            return n(d51Var);
        }
        return invokeLL.booleanValue;
    }

    public final boolean m(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, d51Var)) == null) ? d51Var.b.getMeasuredWidth() + m11.c.a(d51Var.c.getContext(), this.b) <= (d51Var.a.getMeasuredWidth() - d51Var.c.getMeasuredWidth()) - g(d51Var)[0] && o(d51Var) : invokeL.booleanValue;
    }

    public final boolean n(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, d51Var)) == null) ? d51Var.b.getMeasuredHeight() + m11.c.a(d51Var.c.getContext(), this.b) <= g(d51Var)[1] && p(d51Var) : invokeL.booleanValue;
    }

    public final boolean o(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, d51Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = d51Var.c.getContext();
            int a2 = m11.c.a(context, f) + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704b7) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704b1) / 2);
            return a2 <= f(d51Var) && a2 <= c(d51Var);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(d51 d51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, d51Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = d51Var.c.getContext();
            int a2 = m11.c.a(context, f) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c0) / 2);
            return a2 <= d(d51Var) && a2 <= e(d51Var);
        }
        return invokeL.booleanValue;
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.b = f;
        }
    }
}
