package d.a.n0.a.z1.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.n0;
/* loaded from: classes7.dex */
public class h extends d.a.n0.a.z1.b.b.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48717g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f48718f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f48719a;

        /* renamed from: b  reason: collision with root package name */
        public final h f48720b;

        /* renamed from: c  reason: collision with root package name */
        public Context f48721c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f48722d;

        /* renamed from: e  reason: collision with root package name */
        public int f48723e;

        /* renamed from: d.a.n0.a.z1.b.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1001a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f48724e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48725f;

            public View$OnClickListenerC1001a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f48725f = aVar;
                this.f48724e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48725f.f48720b.e(-1);
                    this.f48725f.f48720b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f48724e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f48725f.f48720b, -1);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48726e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f48727f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f48728g;

            public b(a aVar, int i2, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48728g = aVar;
                this.f48726e = i2;
                this.f48727f = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48728g.f48720b.e(this.f48726e);
                    this.f48728g.f48720b.dismiss();
                    this.f48727f.onClick(this.f48728g.f48720b, this.f48726e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f48729e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48730f;

            public c(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f48730f = aVar;
                this.f48729e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48730f.f48720b.e(-2);
                    this.f48730f.f48720b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f48729e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f48730f.f48720b, -2);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f48731e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48732f;

            public d(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f48732f = aVar;
                this.f48731e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48732f.f48720b.e(-3);
                    this.f48732f.f48720b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f48731e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f48732f.f48720b, -3);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1614838002, "Ld/a/n0/a/z1/b/b/h$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1614838002, "Ld/a/n0/a/z1/b/b/h$a;");
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f48722d = false;
            h h2 = h(context);
            this.f48720b = h2;
            h2.f(this);
            this.f48719a = new b((ViewGroup) this.f48720b.getWindow().getDecorView());
            this.f48721c = context;
            this.f48723e = context.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_btns_height);
        }

        public final void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f48723e);
                layoutParams.addRule(3, d.a.n0.a.f.dialog_message_content);
                this.f48719a.t.setLayoutParams(layoutParams);
            }
        }

        public a B(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, onClickListener)) == null) {
                C(this.f48721c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f48719a.f48738f.setVisibility(8);
                    if (this.f48719a.f48737e.getVisibility() == 0) {
                        this.f48719a.f48741i.setVisibility(8);
                    }
                    return this;
                }
                this.f48719a.f48738f.setVisibility(0);
                if (this.f48719a.f48737e.getVisibility() == 0) {
                    this.f48719a.f48741i.setVisibility(0);
                }
                this.f48719a.f48738f.setText(charSequence);
                this.f48719a.f48738f.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                G(this.f48721c.getResources().getColor(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a E(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        G(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e2) {
                        if (h.f48717g) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (i2 > 0) {
                    D(i2);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a F(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f48719a.y = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a G(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f48719a.x = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a H(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, onClickListener)) == null) {
                I(this.f48721c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.f48719a.f48739g.setVisibility(0);
                if (this.f48719a.f48737e.getVisibility() == 0) {
                    this.f48719a.j.setVisibility(0);
                }
                this.f48719a.f48739g.setText(charSequence);
                this.f48719a.f48739g.setOnClickListener(new d(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a J(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.f48719a.B.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a K(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onCancelListener)) == null) {
                this.f48719a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a L(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onDismissListener)) == null) {
                this.f48719a.m = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a M(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onKeyListener)) == null) {
                this.f48719a.p = onKeyListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, onShowListener)) == null) {
                this.f48719a.n = onShowListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a O(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, onClickListener)) == null) {
                P(this.f48721c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f48719a.f48737e.setVisibility(8);
                    if (this.f48719a.f48738f.getVisibility() == 0) {
                        this.f48719a.f48741i.setVisibility(8);
                    }
                    return this;
                }
                this.f48719a.f48737e.setVisibility(0);
                if (this.f48719a.f48738f.getVisibility() == 0) {
                    this.f48719a.f48741i.setVisibility(0);
                }
                this.f48719a.f48737e.setText(charSequence);
                this.f48719a.f48737e.setOnClickListener(new View$OnClickListenerC1001a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a Q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                S(d().getColor(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a R(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        S(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e2) {
                        if (h.f48717g) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (i2 > 0) {
                    Q(i2);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a S(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                b bVar = this.f48719a;
                bVar.w = i2;
                bVar.f48737e.setTextColor(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a T(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.f48719a.E = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a U(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                this.f48719a.f48734b.setText(this.f48721c.getText(i2));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a V(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f48719a.f48734b.setText(charSequence);
                } else {
                    f(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a W(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
                this.f48719a.o.removeAllViews();
                this.f48719a.o.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f48723e);
                layoutParams.addRule(3, d.a.n0.a.f.dialog_customPanel);
                this.f48719a.t.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public h X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                h c2 = c();
                if (this.f48722d) {
                    c2.getWindow().setType(2003);
                }
                try {
                    c2.show();
                } catch (WindowManager.BadTokenException e2) {
                    if (h.f48717g) {
                        e2.printStackTrace();
                    }
                }
                BdEventBus.Companion.getDefault().post(new d.a.n0.a.z1.b.b.a("show"));
                return c2;
            }
            return (h) invokeV.objValue;
        }

        @Deprecated
        public h Y(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) ? X() : (h) invokeZ.objValue;
        }

        public final void Z() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
                int color = d().getColor(d.a.n0.a.c.aiapps_dialog_title_text_color);
                int color2 = d().getColor(d.a.n0.a.c.aiapps_dialog_btn_text_color);
                int color3 = d().getColor(d.a.n0.a.c.aiapps_dialog_btn_text_color);
                int color4 = d().getColor(d.a.n0.a.c.aiapps_box_dialog_message_text_color);
                int color5 = d().getColor(d.a.n0.a.c.aiapps_dialog_gray);
                RelativeLayout relativeLayout = this.f48719a.r;
                Resources d2 = d();
                int i2 = this.f48719a.C;
                if (i2 == -1) {
                    i2 = d.a.n0.a.e.aiapps_dialog_bg_white;
                }
                relativeLayout.setBackground(d2.getDrawable(i2));
                this.f48719a.f48734b.setTextColor(color);
                this.f48719a.f48735c.setTextColor(color4);
                b bVar = this.f48719a;
                TextView textView = bVar.f48737e;
                int i3 = bVar.w;
                if (i3 != color3) {
                    color3 = i3;
                }
                textView.setTextColor(color3);
                b bVar2 = this.f48719a;
                int i4 = bVar2.x;
                if (i4 != color2) {
                    bVar2.f48738f.setTextColor(i4);
                } else if (bVar2.y != -1) {
                    bVar2.f48738f.setTextColor(d().getColorStateList(this.f48719a.y));
                } else {
                    bVar2.f48738f.setTextColor(color2);
                }
                this.f48719a.f48739g.setTextColor(color2);
                if (this.f48719a.D != -1) {
                    color5 = d().getColor(this.f48719a.D);
                }
                this.f48719a.f48740h.setBackgroundColor(color5);
                this.f48719a.f48741i.setBackgroundColor(color5);
                this.f48719a.j.setBackgroundColor(color5);
                this.f48719a.f48737e.setBackground(d().getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
                this.f48719a.f48738f.setBackground(d().getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
                this.f48719a.f48739g.setBackground(d().getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
                TextView g2 = g();
                if (g2 != null) {
                    g2.setBackground(this.f48719a.E ? d().getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_all_selector) : null);
                }
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (n0.F()) {
                    r(this.f48721c.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_landscape_default_width));
                    z(this.f48721c.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_landscape_content_default_height));
                    return this;
                }
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                ((ViewGroup.MarginLayoutParams) this.f48719a.u.getLayoutParams()).setMargins(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                this.f48720b.setCancelable(this.f48719a.k.booleanValue());
                if (this.f48719a.k.booleanValue()) {
                    this.f48720b.setCanceledOnTouchOutside(false);
                }
                this.f48720b.setOnCancelListener(this.f48719a.l);
                this.f48720b.setOnDismissListener(this.f48719a.m);
                this.f48720b.setOnShowListener(this.f48719a.n);
                DialogInterface.OnKeyListener onKeyListener = this.f48719a.p;
                if (onKeyListener != null) {
                    this.f48720b.setOnKeyListener(onKeyListener);
                }
                Z();
                b bVar = this.f48719a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f48720b, bVar);
                }
                this.f48720b.f(this);
                return this.f48720b;
            }
            return (h) invokeV.objValue;
        }

        public Resources d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f48721c.getResources() : (Resources) invokeV.objValue;
        }

        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f48719a.o : (ViewGroup) invokeV.objValue;
        }

        public a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.f48719a.f48733a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public TextView g() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                TextView textView2 = this.f48719a.f48737e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.f48719a.f48737e;
                    i2 = 1;
                }
                TextView textView3 = this.f48719a.f48738f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.f48719a.f48738f;
                }
                TextView textView4 = this.f48719a.f48739g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.f48719a.f48739g;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public h h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, context)) == null) ? new h(context, d.a.n0.a.i.SwanAppNoTitleDialog) : (h) invokeL.objValue;
        }

        public a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                ViewGroup.LayoutParams layoutParams = this.f48719a.u.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.f48721c.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_content_margin_top), 0, 0);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                this.f48719a.A.setPadding(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.f48719a.t.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public void l(View view, int i2, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048613, this, view, i2, onClickListener) == null) || view == null || onClickListener == null) {
                return;
            }
            view.setOnClickListener(new b(this, i2, onClickListener));
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.f48719a.k = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a n(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, cVar)) == null) {
                this.f48719a.z = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
                this.f48719a.D = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
                b bVar = this.f48719a;
                bVar.C = i2;
                bVar.r.setBackgroundResource(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public void q(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
                this.f48719a.r.getLayoutParams().height = i2;
                this.f48719a.r.requestLayout();
            }
        }

        public void r(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
                this.f48719a.r.getLayoutParams().width = i2;
                this.f48719a.r.requestLayout();
            }
        }

        public a s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i2);
                layoutParams.addRule(2, d.a.n0.a.f.btn_panel);
                this.f48719a.f48740h.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a t(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                if (z) {
                    this.f48719a.f48740h.setVisibility(0);
                } else {
                    this.f48719a.f48740h.setVisibility(8);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a u(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
                this.f48719a.q.setImageResource(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a v(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
                if (this.f48719a.f48736d.getVisibility() != 0) {
                    this.f48719a.f48736d.setVisibility(0);
                }
                this.f48719a.f48735c.setText(this.f48721c.getText(i2));
                A();
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a w(Spanned spanned) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, spanned)) == null) {
                if (this.f48719a.f48736d.getVisibility() != 0) {
                    this.f48719a.f48736d.setVisibility(0);
                }
                if (spanned != null) {
                    this.f48719a.f48735c.setMovementMethod(LinkMovementMethod.getInstance());
                    this.f48719a.f48735c.setText(spanned);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
                if (this.f48719a.f48736d.getVisibility() != 0) {
                    this.f48719a.f48736d.setVisibility(0);
                }
                if (str != null) {
                    this.f48719a.f48735c.setText(str);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                this.f48719a.f48735c.setGravity(3);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
                this.f48719a.a(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f48733a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48734b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f48735c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f48736d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f48737e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f48738f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f48739g;

        /* renamed from: h  reason: collision with root package name */
        public View f48740h;

        /* renamed from: i  reason: collision with root package name */
        public View f48741i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public SwanAppScrollView s;
        public LinearLayout t;
        public View u;
        public ViewGroup v;
        public int w;
        public int x;
        public int y;
        public c z;

        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = Boolean.TRUE;
            this.y = -1;
            this.C = -1;
            this.D = -1;
            this.E = true;
            this.v = viewGroup;
            this.f48733a = (LinearLayout) viewGroup.findViewById(d.a.n0.a.f.title_panel);
            this.f48734b = (TextView) viewGroup.findViewById(d.a.n0.a.f.dialog_title);
            this.f48735c = (TextView) viewGroup.findViewById(d.a.n0.a.f.dialog_message);
            this.f48736d = (LinearLayout) viewGroup.findViewById(d.a.n0.a.f.dialog_message_content);
            this.f48737e = (TextView) viewGroup.findViewById(d.a.n0.a.f.positive_button);
            this.f48738f = (TextView) viewGroup.findViewById(d.a.n0.a.f.negative_button);
            this.f48739g = (TextView) viewGroup.findViewById(d.a.n0.a.f.neutral_button);
            this.f48741i = viewGroup.findViewById(d.a.n0.a.f.divider3);
            this.j = viewGroup.findViewById(d.a.n0.a.f.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(d.a.n0.a.f.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(d.a.n0.a.f.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(d.a.n0.a.f.searchbox_alert_dialog);
            this.f48740h = viewGroup.findViewById(d.a.n0.a.f.divider2);
            this.s = (SwanAppScrollView) viewGroup.findViewById(d.a.n0.a.f.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(d.a.n0.a.f.btn_panel);
            this.u = viewGroup.findViewById(d.a.n0.a.f.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(d.a.n0.a.f.dialog_root);
            this.B = viewGroup.findViewById(d.a.n0.a.f.nightmode_mask);
            if (d.a.n0.a.v2.d.k() || d.a.n0.a.v2.d.l()) {
                int dimensionPixelSize = this.f48735c.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_text_padding);
                this.f48735c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
            if (d.a.n0.t.e.d() && d.a.n0.a.v2.f.d(activity) && d.a.n0.t.e.e(activity)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d.a.n0.t.e.a(activity) * 0.8f), -2);
                layoutParams.gravity = 17;
                this.r.setLayoutParams(layoutParams);
            }
            int color = this.v.getResources().getColor(d.a.n0.a.c.aiapps_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.s.setMaxHeight(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(h hVar, b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-51950833, "Ld/a/n0/a/z1/b/b/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-51950833, "Ld/a/n0/a/z1/b/b/h;");
                return;
            }
        }
        f48717g = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48718f : (a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(d.a.n0.a.g.aiapps_alert_dialog);
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            BdEventBus.Companion.getDefault().post(new d.a.n0.a.z1.b.b.a("hide"));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f48718f = aVar;
        }
    }
}
