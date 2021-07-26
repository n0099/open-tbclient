package d.a.p0.s.s;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f53618a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBAlertConfig.a f53619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f53620f;

        public a(TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53619e = aVar;
            this.f53620f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                View.OnClickListener onClickListener = this.f53619e.f12317c;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                View.OnClickListener onClickListener2 = this.f53620f;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f53621a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f53622b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1546311537, "Ld/a/p0/s/s/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1546311537, "Ld/a/p0/s/s/p$b;");
                    return;
                }
            }
            int[] iArr = new int[TBAlertConfig.OperateBtnStyle.values().length];
            f53622b = iArr;
            try {
                iArr[TBAlertConfig.OperateBtnStyle.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53622b[TBAlertConfig.OperateBtnStyle.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f53622b[TBAlertConfig.OperateBtnStyle.FORCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f53622b[TBAlertConfig.OperateBtnStyle.SECONDARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            f53621a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f53621a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f53621a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136803315, "Ld/a/p0/s/s/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136803315, "Ld/a/p0/s/s/p;");
                return;
            }
        }
        f53618a = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public static TextView a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            TextView textView = new TextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
            d2.x(R.dimen.T_X07);
            d2.v(R.color.CAM_X0301);
            d2.y(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0301);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView b(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) ? z ? c(activity) : d(activity) : (TextView) invokeLZ.objValue;
    }

    public static TextView c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(eMTextView);
            d2.x(R.dimen.T_X07);
            d2.u(R.dimen.M_T_X002);
            d2.t(R.color.CAM_X0107);
            d2.y(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(eMTextView);
            d2.x(R.dimen.T_X07);
            d2.u(R.dimen.M_T_X002);
            d2.t(R.color.CAM_X0108);
            d2.y(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            TextView textView = new TextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
            d2.x(R.dimen.T_X07);
            d2.v(R.color.CAM_X0101);
            d2.y(R.string.F_X01);
            d2.n(R.string.J_X07);
            d2.h(R.color.CAM_X0303);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            TextView textView = new TextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
            d2.x(R.dimen.T_X07);
            d2.v(R.color.CAM_X0304);
            d2.y(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0304);
            d2.j(R.string.A_X07);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static View g(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, aVar, onClickListener)) == null) ? h(context, aVar, onClickListener, false) : (View) invokeLLL.objValue;
    }

    public static View h(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, aVar, onClickListener, Boolean.valueOf(z)})) == null) {
            int i2 = b.f53622b[aVar.f12316b.ordinal()];
            if (i2 == 1) {
                f2 = f(context);
            } else if (i2 == 2) {
                f2 = a(context);
            } else if (i2 != 3) {
                f2 = i2 != 4 ? null : j(context);
            } else {
                f2 = e(context);
            }
            f2.setText(aVar.f12315a);
            if (z) {
                d.a.p0.s.u.c.d(f2).x(R.dimen.T_X08);
            }
            f2.setOnClickListener(new a(aVar, onClickListener));
            return f2;
        }
        return (View) invokeCommon.objValue;
    }

    public static View i(@NonNull Context context, @NonNull TBAlertConfig.b bVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, bVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, d.a.d.e.p.l.g(context, R.dimen.M_H_X008), 0, d.a.d.e.p.l.g(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i2 = b.f53621a[bVar.f12318a.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View g2 = g(context, bVar.f12319b, onClickListener);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, f53618a);
                layoutParams.weight = 494.0f;
                linearLayout.addView(g2, layoutParams);
            } else if (i2 == 2) {
                linearLayout.setOrientation(0);
                if (bVar.f12319b.f12315a.length() <= 6 && bVar.f12320c.f12315a.length() <= 6) {
                    z = false;
                }
                View h2 = h(context, bVar.f12319b, onClickListener, z);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, f53618a);
                layoutParams2.setMargins(d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.d.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0);
                layoutParams2.weight = 1.0f;
                linearLayout.addView(h2, layoutParams2);
                View h3 = h(context, bVar.f12320c, onClickListener, z);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, f53618a);
                layoutParams3.setMargins(d.a.d.e.p.l.g(context, R.dimen.M_W_X006) / 2, 0, d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0);
                layoutParams3.weight = 1.0f;
                linearLayout.addView(h3, layoutParams3);
            } else if (i2 == 3) {
                linearLayout.setOrientation(1);
                View g3 = g(context, bVar.f12319b, onClickListener);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, f53618a);
                layoutParams4.setMargins(d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.d.e.p.l.g(context, R.dimen.M_W_X012), d.a.d.e.p.l.g(context, R.dimen.M_H_X005));
                linearLayout.addView(g3, layoutParams4);
                View g4 = g(context, bVar.f12320c, onClickListener);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, f53618a);
                layoutParams5.setMargins(d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.d.e.p.l.g(context, R.dimen.M_W_X012), d.a.d.e.p.l.g(context, R.dimen.M_H_X005));
                linearLayout.addView(g4, layoutParams5);
                View g5 = g(context, bVar.f12321d, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, f53618a);
                layoutParams6.setMargins(d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0, d.a.d.e.p.l.g(context, R.dimen.M_W_X012), 0);
                linearLayout.addView(g5, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public static TextView j(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TextView textView = new TextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
            d2.x(R.dimen.T_X07);
            d2.v(R.color.CAM_X0105);
            d2.y(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0902);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(eMTextView);
            d2.x(R.dimen.T_X05);
            d2.t(R.color.CAM_X0105);
            d2.y(R.string.F_X02);
            eMTextView.setMaxLines(1);
            eMTextView.setSingleLine();
            eMTextView.setGravity(17);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }
}
