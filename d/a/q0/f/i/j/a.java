package d.a.q0.f.i.j;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.d;
import d.a.q0.f.i.e;
import d.a.q0.f.i.f;
import d.a.q0.f.i.h;
/* loaded from: classes8.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public C1095a f52606e;

    /* renamed from: d.a.q0.f.i.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1095a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f52607a;

        /* renamed from: b  reason: collision with root package name */
        public final a f52608b;

        /* renamed from: c  reason: collision with root package name */
        public Context f52609c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52610d;

        /* renamed from: e  reason: collision with root package name */
        public int f52611e;

        /* renamed from: d.a.q0.f.i.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1096a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f52612e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1095a f52613f;

            public View$OnClickListenerC1096a(C1095a c1095a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1095a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52613f = c1095a;
                this.f52612e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f52613f.f52608b.b(-1);
                    this.f52613f.f52608b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f52612e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f52613f.f52608b, -1);
                    }
                }
            }
        }

        /* renamed from: d.a.q0.f.i.j.a$a$b */
        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f52614e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1095a f52615f;

            public b(C1095a c1095a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1095a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52615f = c1095a;
                this.f52614e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f52615f.f52608b.b(-2);
                    this.f52615f.f52608b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f52614e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f52615f.f52608b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1904670748, "Ld/a/q0/f/i/j/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1904670748, "Ld/a/q0/f/i/j/a$a;");
            }
        }

        public C1095a(Context context) {
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
            this.f52607a = null;
            this.f52610d = false;
            a e2 = e(context);
            this.f52608b = e2;
            e2.c(this);
            this.f52609c = context;
            this.f52611e = context.getResources().getDimensionPixelSize(d.a.q0.f.i.c.swan_ad_dialog_btns_height);
            if (this.f52608b.getWindow() != null) {
                this.f52607a = new b((ViewGroup) this.f52608b.getWindow().getDecorView());
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f52608b.setCancelable(this.f52607a.k.booleanValue());
                if (this.f52607a.k.booleanValue()) {
                    this.f52608b.setCanceledOnTouchOutside(false);
                }
                this.f52608b.setOnCancelListener(this.f52607a.l);
                this.f52608b.setOnDismissListener(this.f52607a.m);
                this.f52608b.setOnShowListener(this.f52607a.n);
                DialogInterface.OnKeyListener onKeyListener = this.f52607a.p;
                if (onKeyListener != null) {
                    this.f52608b.setOnKeyListener(onKeyListener);
                }
                q();
                b bVar = this.f52607a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f52608b, bVar);
                }
                this.f52608b.c(this);
                return this.f52608b;
            }
            return (a) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52609c.getResources() : (Resources) invokeV.objValue;
        }

        public C1095a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f52607a.f52616a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (C1095a) invokeZ.objValue;
        }

        public TextView d() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView2 = this.f52607a.f52620e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.f52607a.f52620e;
                    i2 = 1;
                }
                TextView textView3 = this.f52607a.f52621f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.f52607a.f52621f;
                }
                TextView textView4 = this.f52607a.f52622g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.f52607a.f52622g;
                }
                if (i2 != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public a e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new a(context, h.AdNoTitleDialog) : (a) invokeL.objValue;
        }

        public C1095a f(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048581, this, i2, i3, i4, i5)) == null) {
                this.f52607a.A.setPadding(i2, i3, i4, i5);
                return this;
            }
            return (C1095a) invokeIIII.objValue;
        }

        public C1095a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (this.f52607a.f52619d.getVisibility() != 0) {
                    this.f52607a.f52619d.setVisibility(0);
                }
                if (str != null) {
                    this.f52607a.f52618c.setText(str);
                    h();
                }
                return this;
            }
            return (C1095a) invokeL.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f52611e);
                layoutParams.addRule(3, e.dialog_message_content);
                this.f52607a.t.setLayoutParams(layoutParams);
            }
        }

        public C1095a i(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, onClickListener)) == null) {
                j(this.f52609c.getText(i2), onClickListener);
                return this;
            }
            return (C1095a) invokeIL.objValue;
        }

        public C1095a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f52607a.f52621f.setVisibility(8);
                    if (this.f52607a.f52620e.getVisibility() == 0) {
                        this.f52607a.f52624i.setVisibility(8);
                    }
                    return this;
                }
                this.f52607a.f52621f.setVisibility(0);
                if (this.f52607a.f52620e.getVisibility() == 0) {
                    this.f52607a.f52624i.setVisibility(0);
                }
                this.f52607a.f52621f.setText(charSequence);
                this.f52607a.f52621f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (C1095a) invokeLL.objValue;
        }

        public C1095a k(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                this.f52607a.m = onDismissListener;
                return this;
            }
            return (C1095a) invokeL.objValue;
        }

        public C1095a l(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, onClickListener)) == null) {
                m(this.f52609c.getText(i2), onClickListener);
                return this;
            }
            return (C1095a) invokeIL.objValue;
        }

        public C1095a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f52607a.f52620e.setVisibility(8);
                    if (this.f52607a.f52621f.getVisibility() == 0) {
                        this.f52607a.f52624i.setVisibility(8);
                    }
                    return this;
                }
                this.f52607a.f52620e.setVisibility(0);
                if (this.f52607a.f52621f.getVisibility() == 0) {
                    this.f52607a.f52624i.setVisibility(0);
                }
                this.f52607a.f52620e.setText(charSequence);
                this.f52607a.f52620e.setOnClickListener(new View$OnClickListenerC1096a(this, onClickListener));
                return this;
            }
            return (C1095a) invokeLL.objValue;
        }

        public C1095a n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                o(b().getColor(i2));
                return this;
            }
            return (C1095a) invokeI.objValue;
        }

        public C1095a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                b bVar = this.f52607a;
                bVar.w = i2;
                bVar.f52620e.setTextColor(i2);
                return this;
            }
            return (C1095a) invokeI.objValue;
        }

        public a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                a a2 = a();
                if (this.f52610d && a2.getWindow() != null) {
                    a2.getWindow().setType(2003);
                }
                try {
                    a2.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a2;
            }
            return (a) invokeV.objValue;
        }

        public final void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                int color = b().getColor(d.a.q0.f.i.b.swan_ad_dialog_title_text_color);
                int color2 = b().getColor(d.a.q0.f.i.b.swan_ad_dialog_btn_text_color);
                int color3 = b().getColor(d.a.q0.f.i.b.swan_ad_dialog_btn_text_color);
                int color4 = b().getColor(d.a.q0.f.i.b.swan_ad_box_dialog_message_text_color);
                int color5 = b().getColor(d.a.q0.f.i.b.swan_ad_dialog_gray);
                RelativeLayout relativeLayout = this.f52607a.r;
                Resources b2 = b();
                int i2 = this.f52607a.C;
                if (i2 == -1) {
                    i2 = d.swan_ad_dialog_bg_white;
                }
                relativeLayout.setBackground(b2.getDrawable(i2));
                this.f52607a.f52617b.setTextColor(color);
                this.f52607a.f52618c.setTextColor(color4);
                b bVar = this.f52607a;
                TextView textView = bVar.f52620e;
                int i3 = bVar.w;
                if (i3 != color3) {
                    color3 = i3;
                }
                textView.setTextColor(color3);
                b bVar2 = this.f52607a;
                int i4 = bVar2.x;
                if (i4 != color2) {
                    bVar2.f52621f.setTextColor(i4);
                } else if (bVar2.y != -1) {
                    bVar2.f52621f.setTextColor(b().getColorStateList(this.f52607a.y));
                } else {
                    bVar2.f52621f.setTextColor(color2);
                }
                this.f52607a.f52622g.setTextColor(color2);
                if (this.f52607a.D != -1) {
                    color5 = b().getColor(this.f52607a.D);
                }
                this.f52607a.f52623h.setBackgroundColor(color5);
                this.f52607a.f52624i.setBackgroundColor(color5);
                this.f52607a.j.setBackgroundColor(color5);
                this.f52607a.f52620e.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_right_selector));
                this.f52607a.f52621f.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_left_selector));
                this.f52607a.f52622g.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector));
                TextView d2 = d();
                if (d2 != null) {
                    d2.setBackground(this.f52607a.E ? b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector) : null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f52616a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52617b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52618c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f52619d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52620e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52621f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f52622g;

        /* renamed from: h  reason: collision with root package name */
        public View f52623h;

        /* renamed from: i  reason: collision with root package name */
        public View f52624i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public AdScrollView s;
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
            this.f52616a = (LinearLayout) viewGroup.findViewById(e.title_panel);
            this.f52617b = (TextView) viewGroup.findViewById(e.dialog_title);
            this.f52618c = (TextView) viewGroup.findViewById(e.dialog_message);
            this.f52619d = (LinearLayout) viewGroup.findViewById(e.dialog_message_content);
            this.f52620e = (TextView) viewGroup.findViewById(e.positive_button);
            this.f52621f = (TextView) viewGroup.findViewById(e.negative_button);
            this.f52622g = (TextView) viewGroup.findViewById(e.neutral_button);
            this.f52624i = viewGroup.findViewById(e.divider3);
            this.j = viewGroup.findViewById(e.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(e.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(e.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(e.searchbox_alert_dialog);
            this.f52623h = viewGroup.findViewById(e.divider2);
            this.s = (AdScrollView) viewGroup.findViewById(e.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(e.btn_panel);
            this.u = viewGroup.findViewById(e.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(e.dialog_root);
            this.B = viewGroup.findViewById(e.nightmode_mask);
            int color = this.v.getResources().getColor(d.a.q0.f.i.b.swan_ad_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(a aVar, b bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(f.ng_game_alert_dialog);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void c(C1095a c1095a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1095a) == null) {
            this.f52606e = c1095a;
        }
    }

    public void d(String str) {
        C1095a c1095a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (c1095a = this.f52606e) == null) {
            return;
        }
        c1095a.g(str);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
        }
    }
}
