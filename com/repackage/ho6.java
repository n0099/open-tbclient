package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public class ho6 extends do6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public no6 d;
    public oo6 e;
    public ro6 f;
    public qo6 g;
    public c h;
    public View.OnClickListener i;
    public View j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ho6 d;

        public a(ho6 ho6Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho6Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ho6Var;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.a).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.b));
                UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{this.c});
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-321998652, "Lcom/repackage/ho6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-321998652, "Lcom/repackage/ho6$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LogicField.SPEED_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LogicField.SERVICE_AREA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LogicField.TOP_AREA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LogicField.ROUND_CORNER_STYLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LogicField.TOP_DIVIDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[LogicField.BANNER_AND_BOTTOM_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public TextView c;
        public ImageView d;

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
                cVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09244e);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092445);
                cVar.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092443);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public ho6() {
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

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T, java.util.ArrayList] */
    @Override // com.repackage.do6, com.repackage.fo6, com.repackage.no6
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = b.a[logicField.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return (T) super.a(logicField);
                }
                return (T) this.d.a(logicField);
            }
            ?? r0 = (T) new ArrayList();
            r0.add(this.f.a(logicField));
            r0.add(this.g.a(logicField));
            return r0;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.repackage.do6, com.repackage.fo6
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.b(z);
            h().b(z);
            if (z) {
                this.j.setVisibility(0);
                this.e.p().setVisibility(0);
                this.d = this.e;
                this.f.b().setVisibility(0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.e.p().setVisibility(8);
                no6 k = h().k();
                uc5.b(k);
                this.d = k;
                this.f.b().setVisibility(8);
            }
            d(this.i);
        }
    }

    @Override // com.repackage.no6
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean z2 = z || hd6.d(hd6.a());
            this.d.c(z2);
            this.f.c(z2);
            this.g.c(z2);
        }
    }

    @Override // com.repackage.no6
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.i = onClickListener;
            this.d.d(onClickListener);
            this.f.d(onClickListener);
            this.g.d(onClickListener);
        }
    }

    @Override // com.repackage.do6, com.repackage.fo6
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeElement) == null) {
            super.e(themeElement);
            this.h.c.setTextColor(zi8.e(themeElement.common_color));
        }
    }

    @Override // com.repackage.do6, com.repackage.no6
    public void g(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            this.d.g(i, str);
        }
    }

    @Override // com.repackage.fo6
    public void i(@Nullable Integer num, @Nullable Integer num2, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, num, num2, z) == null) {
            if (!z && num != null && num2 != null) {
                String b2 = this.a.b();
                String a2 = this.a.a();
                int i = 1;
                if (num.intValue() == 2) {
                    this.h.c.setText(R.string.obfuscated_res_0x7f0f1426);
                    this.h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + b2 + "&nomenu=1";
                    i = 2;
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    this.h.c.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f1425), num2));
                    this.h.a.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + b2 + "&fn=" + a2 + "&nomenu=1";
                } else {
                    this.h.a.setVisibility(8);
                    str = "";
                    i = 0;
                }
                this.h.a.setOnClickListener(new a(this, b2, i, str));
                return;
            }
            this.h.a.setVisibility(8);
        }
    }

    @Override // com.repackage.do6, com.repackage.no6
    public void j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.d.j(j, j2);
        }
    }

    @Override // com.repackage.do6, com.repackage.no6
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.d.k(str, str2);
        }
    }

    @Override // com.repackage.do6, com.repackage.no6
    public void l(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, logicField, i) == null) {
            this.d.l(logicField, i);
        }
    }

    @Override // com.repackage.fo6
    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h.a : (View) invokeV.objValue;
    }

    @Override // com.repackage.do6, com.repackage.fo6
    public int n(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, logicField)) == null) {
            switch (b.a[logicField.ordinal()]) {
                case 4:
                case 5:
                case 6:
                case 7:
                    return 8;
                case 8:
                    return 0;
                default:
                    return super.n(logicField);
            }
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.do6
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p();
            q();
            b(false);
            r();
        }
    }

    @Override // com.repackage.do6, com.repackage.no6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d.onChangeSkinType(i);
            wr4 d = wr4.d(this.h.a);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0201);
            wr4.d(this.h.b).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.h.d, R.drawable.icon_arrow12_white, R.color.common_color_10060, null);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.findViewById(R.id.obfuscated_res_0x7f090b46).setVisibility(8);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f090b3d);
            this.j = findViewById;
            wr4.d(findViewById).p(new int[]{R.color.black_alpha0, R.color.black_alpha30}, Direction.TOP);
            this.e = new oo6(this.a, findViewById.findViewById(R.id.obfuscated_res_0x7f090a54));
            this.f = new ro6(this.a, findViewById.findViewById(R.id.obfuscated_res_0x7f090a5d));
            qo6 g = h().g();
            this.g = g;
            uc5.b(g);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c a2 = c.a(this.c.findViewById(R.id.obfuscated_res_0x7f092448));
            this.h = a2;
            a2.a.setVisibility(8);
        }
    }
}
