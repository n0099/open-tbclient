package com.dxmpay.apollon.utils.support;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class ViewHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static float A(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) ? view.getX() : invokeL.floatValue;
        }

        public static float B(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) ? view.getY() : invokeL.floatValue;
        }

        public static float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) ? view.getAlpha() : invokeL.floatValue;
        }

        public static void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65539, null, view, f2) == null) {
                view.setAlpha(f2);
            }
        }

        public static void c(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, view, i2) == null) {
                view.setScrollX(i2);
            }
        }

        public static float d(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view)) == null) ? view.getPivotX() : invokeL.floatValue;
        }

        public static void e(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65542, null, view, f2) == null) {
                view.setPivotX(f2);
            }
        }

        public static void f(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65543, null, view, i2) == null) {
                view.setScrollY(i2);
            }
        }

        public static float g(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) ? view.getPivotY() : invokeL.floatValue;
        }

        public static void h(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65545, null, view, f2) == null) {
                view.setPivotY(f2);
            }
        }

        public static float i(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) ? view.getRotation() : invokeL.floatValue;
        }

        public static void j(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65547, null, view, f2) == null) {
                view.setRotation(f2);
            }
        }

        public static float k(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) ? view.getRotationX() : invokeL.floatValue;
        }

        public static void l(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65549, null, view, f2) == null) {
                view.setRotationX(f2);
            }
        }

        public static float m(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) ? view.getRotationY() : invokeL.floatValue;
        }

        public static void n(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65551, null, view, f2) == null) {
                view.setRotationY(f2);
            }
        }

        public static float o(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view)) == null) ? view.getScaleX() : invokeL.floatValue;
        }

        public static void p(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65553, null, view, f2) == null) {
                view.setScaleX(f2);
            }
        }

        public static float q(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, view)) == null) ? view.getScaleY() : invokeL.floatValue;
        }

        public static void r(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65555, null, view, f2) == null) {
                view.setScaleY(f2);
            }
        }

        public static float s(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, view)) == null) ? view.getScrollX() : invokeL.floatValue;
        }

        public static void t(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65557, null, view, f2) == null) {
                view.setTranslationX(f2);
            }
        }

        public static float u(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, view)) == null) ? view.getScrollY() : invokeL.floatValue;
        }

        public static void v(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65559, null, view, f2) == null) {
                view.setTranslationY(f2);
            }
        }

        public static float w(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, view)) == null) ? view.getTranslationX() : invokeL.floatValue;
        }

        public static void x(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65561, null, view, f2) == null) {
                view.setX(f2);
            }
        }

        public static float y(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, view)) == null) ? view.getTranslationY() : invokeL.floatValue;
        }

        public static void z(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65563, null, view, f2) == null) {
                view.setY(f2);
            }
        }
    }

    public ViewHelper() {
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

    public static ArrayList<View> a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (!(view instanceof ViewGroup)) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(view);
                return arrayList;
            }
            ArrayList<View> arrayList2 = new ArrayList<>();
            arrayList2.add(view);
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(a(childAt));
                arrayList2.addAll(arrayList3);
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void b(ArrayList<View> arrayList, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65538, null, arrayList, view, z) == null) || arrayList == null || arrayList.size() <= 0 || view == null) {
            return;
        }
        ArrayList<View> a2 = a(view);
        for (int i2 = 1; i2 < a2.size(); i2++) {
            View view2 = a2.get(i2);
            if (view2 != null && arrayList.contains(view2)) {
                arrayList.remove(view2);
            }
        }
        if (z && arrayList.contains(view)) {
            arrayList.remove(view);
        }
    }

    public static void c(ArrayList<View> arrayList, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, arrayList, view, z) == null) || arrayList == null || arrayList.size() <= 0 || view == null) {
            return;
        }
        View view2 = (View) view.getParent();
        if (view2 != null) {
            arrayList.remove(view2);
            c(arrayList, view2, true);
        }
        if (z && arrayList.contains(view)) {
            arrayList.remove(view);
        }
    }

    public static float getAlpha(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : a.a(view) : invokeL.floatValue;
    }

    public static float getPivotX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : a.d(view) : invokeL.floatValue;
    }

    public static float getPivotY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : a.g(view) : invokeL.floatValue;
    }

    public static float getRotation(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotation() : a.i(view) : invokeL.floatValue;
    }

    public static float getRotationX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationX() : a.k(view) : invokeL.floatValue;
    }

    public static float getRotationY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getRotationY() : a.m(view) : invokeL.floatValue;
    }

    public static float getScaleX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : a.o(view) : invokeL.floatValue;
    }

    public static float getScaleY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : a.q(view) : invokeL.floatValue;
    }

    public static float getScrollX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollX() : a.s(view) : invokeL.floatValue;
    }

    public static float getScrollY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScrollY() : a.u(view) : invokeL.floatValue;
    }

    public static float getTranslationX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationX() : a.w(view) : invokeL.floatValue;
    }

    public static float getTranslationY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getTranslationY() : a.y(view) : invokeL.floatValue;
    }

    public static float getX(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : a.A(view) : invokeL.floatValue;
    }

    public static float getY(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, view)) == null) ? AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : a.B(view) : invokeL.floatValue;
    }

    public static void setAlpha(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65554, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setAlpha(f2);
            } else {
                a.b(view, f2);
            }
        }
    }

    public static void setAlphaPartly(View view, float f2, View... viewArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{view, Float.valueOf(f2), viewArr}) == null) || view == null) {
            return;
        }
        if (viewArr != null && viewArr.length > 0 && (view instanceof ViewGroup)) {
            ArrayList<View> a2 = a(view);
            if (a2 != null && a2.size() > 0) {
                for (View view2 : viewArr) {
                    c(a2, view2, true);
                }
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    View view3 = a2.get(i2);
                    if ((view3 instanceof ViewGroup) && ((ViewGroup) view3).getChildCount() > 0) {
                        b(a2, view3, false);
                    }
                }
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    View view4 = a2.get(i3);
                    if (view4 != null) {
                        setAlpha(view4, f2);
                    }
                }
                return;
            }
            setAlpha(view, f2);
            return;
        }
        setAlpha(view, f2);
    }

    public static void setPivotX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65556, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setPivotX(f2);
            } else {
                a.e(view, f2);
            }
        }
    }

    public static void setPivotY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65557, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setPivotY(f2);
            } else {
                a.h(view, f2);
            }
        }
    }

    public static void setRotation(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65558, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setRotation(f2);
            } else {
                a.j(view, f2);
            }
        }
    }

    public static void setRotationX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65559, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setRotationX(f2);
            } else {
                a.l(view, f2);
            }
        }
    }

    public static void setRotationY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65560, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setRotationY(f2);
            } else {
                a.n(view, f2);
            }
        }
    }

    public static void setScaleX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65561, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setScaleX(f2);
            } else {
                a.p(view, f2);
            }
        }
    }

    public static void setScaleY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65562, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setScaleY(f2);
            } else {
                a.r(view, f2);
            }
        }
    }

    public static void setScrollX(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65563, null, view, i2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setScrollX(i2);
            } else {
                a.c(view, i2);
            }
        }
    }

    public static void setScrollY(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65564, null, view, i2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setScrollY(i2);
            } else {
                a.f(view, i2);
            }
        }
    }

    public static void setTranslationX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65565, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setTranslationX(f2);
            } else {
                a.t(view, f2);
            }
        }
    }

    public static void setTranslationY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65566, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setTranslationY(f2);
            } else {
                a.v(view, f2);
            }
        }
    }

    public static void setX(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65567, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setX(f2);
            } else {
                a.x(view, f2);
            }
        }
    }

    public static void setY(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65568, null, view, f2) == null) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).setY(f2);
            } else {
                a.z(view, f2);
            }
        }
    }
}
