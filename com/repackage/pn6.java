package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class pn6 extends ln6 {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public rn6 j;
    public EMTextView k;
    public c l;
    public un6 m;
    public boolean n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn6 a;

        public a(pn6 pn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pn6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-93888965, "Lcom/repackage/pn6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-93888965, "Lcom/repackage/pn6$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.FOLD_TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public MessageRedDotView c;

        public c() {
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

        @NonNull
        public static c a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                c cVar = new c();
                cVar.a = view2;
                cVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091449);
                cVar.c = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f091a6c);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755404103, "Lcom/repackage/pn6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755404103, "Lcom/repackage/pn6;");
                return;
            }
        }
        o = UtilHelper.getDimenPixelSize(R.dimen.tbds204);
        p = UtilHelper.getDimenPixelSize(R.dimen.tbds666);
        q = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
    }

    public pn6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (b.a[logicField.ordinal()] != 1) {
                return (T) super.a(logicField);
            }
            return (T) this.k;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n = z;
            if (z) {
                this.j.p().setVisibility(8);
                this.m.b().setAlpha(0.0f);
                return;
            }
            this.j.p().setVisibility(0);
            this.m.b().setAlpha(1.0f);
        }
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    public void c(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            super.c(f);
            this.j.p().setAlpha(1.0f - f);
            float abs = Math.abs(1.0f - (2.0f * f));
            this.l.a.setAlpha(abs);
            if (this.n) {
                this.m.e(false, this.i);
                this.m.b().setAlpha(f);
            } else {
                this.m.b().setAlpha(abs);
            }
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            int i = o;
            layoutParams.height = (int) (i - ((i - q) * f));
            this.e.requestLayout();
        }
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.l.c.g(String.valueOf(i), false);
                this.l.c.setVisibility(0);
                return;
            }
            this.l.c.setVisibility(8);
        }
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    @Nullable
    public tn6 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (tn6) invokeV.objValue;
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.h(z);
            int i = z ? 8 : 0;
            this.l.a.setVisibility(i);
            this.j.p().setVisibility(this.n ? 8 : i);
        }
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e.getHeight() - q : invokeV.intValue;
    }

    @Override // com.repackage.ln6, com.repackage.nn6
    @Nullable
    public qn6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (qn6) invokeV.objValue;
    }

    @Override // com.repackage.ln6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            WebPManager.setPureDrawable(this.l.b, R.drawable.obfuscated_res_0x7f080610, z ? R.color.CAM_X0101 : R.color.CAM_X0106, null);
            if (this.n) {
                return;
            }
            this.m.e(z, this.i);
        }
    }

    @Override // com.repackage.ln6
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.setFixedHeight(false);
            o();
            p();
            q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0308, (View.OnClickListener) null);
            this.j = new rn6(this.a, frameLayout.findViewById(R.id.obfuscated_res_0x7f090a4b));
            this.k = (EMTextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f0909f7);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = new un6(this.a, (ViewGroup) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0309, (View.OnClickListener) null));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c a2 = c.a((ViewGroup) this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d030a, (View.OnClickListener) null));
            this.l = a2;
            WebPManager.setPureDrawable(a2.b, R.drawable.obfuscated_res_0x7f080610, R.color.white_alpha100, null);
            d(0, false);
            this.l.a.setTag(R.id.obfuscated_res_0x7f09065b, LogicField.MORE_BTN);
            this.l.a.setOnClickListener(new a(this));
        }
    }
}
