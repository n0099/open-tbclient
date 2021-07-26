package d.a.o0.f.i.j;

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
import d.a.o0.f.i.d;
import d.a.o0.f.i.e;
import d.a.o0.f.i.f;
import d.a.o0.f.i.h;
/* loaded from: classes7.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public C1053a f49808e;

    /* renamed from: d.a.o0.f.i.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1053a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f49809a;

        /* renamed from: b  reason: collision with root package name */
        public final a f49810b;

        /* renamed from: c  reason: collision with root package name */
        public Context f49811c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49812d;

        /* renamed from: e  reason: collision with root package name */
        public int f49813e;

        /* renamed from: d.a.o0.f.i.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1054a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49814e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1053a f49815f;

            public View$OnClickListenerC1054a(C1053a c1053a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1053a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49815f = c1053a;
                this.f49814e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f49815f.f49810b.b(-1);
                    this.f49815f.f49810b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f49814e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f49815f.f49810b, -1);
                    }
                }
            }
        }

        /* renamed from: d.a.o0.f.i.j.a$a$b */
        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49816e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1053a f49817f;

            public b(C1053a c1053a, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1053a, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49817f = c1053a;
                this.f49816e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f49817f.f49810b.b(-2);
                    this.f49817f.f49810b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f49816e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f49817f.f49810b, -2);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1803490534, "Ld/a/o0/f/i/j/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1803490534, "Ld/a/o0/f/i/j/a$a;");
            }
        }

        public C1053a(Context context) {
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
            this.f49809a = null;
            this.f49812d = false;
            a e2 = e(context);
            this.f49810b = e2;
            e2.c(this);
            this.f49811c = context;
            this.f49813e = context.getResources().getDimensionPixelSize(d.a.o0.f.i.c.swan_ad_dialog_btns_height);
            if (this.f49810b.getWindow() != null) {
                this.f49809a = new b((ViewGroup) this.f49810b.getWindow().getDecorView());
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f49810b.setCancelable(this.f49809a.k.booleanValue());
                if (this.f49809a.k.booleanValue()) {
                    this.f49810b.setCanceledOnTouchOutside(false);
                }
                this.f49810b.setOnCancelListener(this.f49809a.l);
                this.f49810b.setOnDismissListener(this.f49809a.m);
                this.f49810b.setOnShowListener(this.f49809a.n);
                DialogInterface.OnKeyListener onKeyListener = this.f49809a.p;
                if (onKeyListener != null) {
                    this.f49810b.setOnKeyListener(onKeyListener);
                }
                q();
                b bVar = this.f49809a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.f49810b, bVar);
                }
                this.f49810b.c(this);
                return this.f49810b;
            }
            return (a) invokeV.objValue;
        }

        public Resources b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49811c.getResources() : (Resources) invokeV.objValue;
        }

        public C1053a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f49809a.f49818a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (C1053a) invokeZ.objValue;
        }

        public TextView d() {
            InterceptResult invokeV;
            int i2;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView2 = this.f49809a.f49822e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i2 = 0;
                    textView = null;
                } else {
                    textView = this.f49809a.f49822e;
                    i2 = 1;
                }
                TextView textView3 = this.f49809a.f49823f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i2++;
                    textView = this.f49809a.f49823f;
                }
                TextView textView4 = this.f49809a.f49824g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i2++;
                    textView = this.f49809a.f49824g;
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

        public C1053a f(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048581, this, i2, i3, i4, i5)) == null) {
                this.f49809a.A.setPadding(i2, i3, i4, i5);
                return this;
            }
            return (C1053a) invokeIIII.objValue;
        }

        public C1053a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (this.f49809a.f49821d.getVisibility() != 0) {
                    this.f49809a.f49821d.setVisibility(0);
                }
                if (str != null) {
                    this.f49809a.f49820c.setText(str);
                    h();
                }
                return this;
            }
            return (C1053a) invokeL.objValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f49813e);
                layoutParams.addRule(3, e.dialog_message_content);
                this.f49809a.t.setLayoutParams(layoutParams);
            }
        }

        public C1053a i(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, onClickListener)) == null) {
                j(this.f49811c.getText(i2), onClickListener);
                return this;
            }
            return (C1053a) invokeIL.objValue;
        }

        public C1053a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f49809a.f49823f.setVisibility(8);
                    if (this.f49809a.f49822e.getVisibility() == 0) {
                        this.f49809a.f49826i.setVisibility(8);
                    }
                    return this;
                }
                this.f49809a.f49823f.setVisibility(0);
                if (this.f49809a.f49822e.getVisibility() == 0) {
                    this.f49809a.f49826i.setVisibility(0);
                }
                this.f49809a.f49823f.setText(charSequence);
                this.f49809a.f49823f.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (C1053a) invokeLL.objValue;
        }

        public C1053a k(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                this.f49809a.m = onDismissListener;
                return this;
            }
            return (C1053a) invokeL.objValue;
        }

        public C1053a l(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, onClickListener)) == null) {
                m(this.f49811c.getText(i2), onClickListener);
                return this;
            }
            return (C1053a) invokeIL.objValue;
        }

        public C1053a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f49809a.f49822e.setVisibility(8);
                    if (this.f49809a.f49823f.getVisibility() == 0) {
                        this.f49809a.f49826i.setVisibility(8);
                    }
                    return this;
                }
                this.f49809a.f49822e.setVisibility(0);
                if (this.f49809a.f49823f.getVisibility() == 0) {
                    this.f49809a.f49826i.setVisibility(0);
                }
                this.f49809a.f49822e.setText(charSequence);
                this.f49809a.f49822e.setOnClickListener(new View$OnClickListenerC1054a(this, onClickListener));
                return this;
            }
            return (C1053a) invokeLL.objValue;
        }

        public C1053a n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                o(b().getColor(i2));
                return this;
            }
            return (C1053a) invokeI.objValue;
        }

        public C1053a o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                b bVar = this.f49809a;
                bVar.w = i2;
                bVar.f49822e.setTextColor(i2);
                return this;
            }
            return (C1053a) invokeI.objValue;
        }

        public a p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                a a2 = a();
                if (this.f49812d && a2.getWindow() != null) {
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
                int color = b().getColor(d.a.o0.f.i.b.swan_ad_dialog_title_text_color);
                int color2 = b().getColor(d.a.o0.f.i.b.swan_ad_dialog_btn_text_color);
                int color3 = b().getColor(d.a.o0.f.i.b.swan_ad_dialog_btn_text_color);
                int color4 = b().getColor(d.a.o0.f.i.b.swan_ad_box_dialog_message_text_color);
                int color5 = b().getColor(d.a.o0.f.i.b.swan_ad_dialog_gray);
                RelativeLayout relativeLayout = this.f49809a.r;
                Resources b2 = b();
                int i2 = this.f49809a.C;
                if (i2 == -1) {
                    i2 = d.swan_ad_dialog_bg_white;
                }
                relativeLayout.setBackground(b2.getDrawable(i2));
                this.f49809a.f49819b.setTextColor(color);
                this.f49809a.f49820c.setTextColor(color4);
                b bVar = this.f49809a;
                TextView textView = bVar.f49822e;
                int i3 = bVar.w;
                if (i3 != color3) {
                    color3 = i3;
                }
                textView.setTextColor(color3);
                b bVar2 = this.f49809a;
                int i4 = bVar2.x;
                if (i4 != color2) {
                    bVar2.f49823f.setTextColor(i4);
                } else if (bVar2.y != -1) {
                    bVar2.f49823f.setTextColor(b().getColorStateList(this.f49809a.y));
                } else {
                    bVar2.f49823f.setTextColor(color2);
                }
                this.f49809a.f49824g.setTextColor(color2);
                if (this.f49809a.D != -1) {
                    color5 = b().getColor(this.f49809a.D);
                }
                this.f49809a.f49825h.setBackgroundColor(color5);
                this.f49809a.f49826i.setBackgroundColor(color5);
                this.f49809a.j.setBackgroundColor(color5);
                this.f49809a.f49822e.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_right_selector));
                this.f49809a.f49823f.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_left_selector));
                this.f49809a.f49824g.setBackground(b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector));
                TextView d2 = d();
                if (d2 != null) {
                    d2.setBackground(this.f49809a.E ? b().getDrawable(d.swan_ad_alertdialog_button_day_bg_all_selector) : null);
                }
            }
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
        public LinearLayout f49818a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49819b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49820c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f49821d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f49822e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f49823f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f49824g;

        /* renamed from: h  reason: collision with root package name */
        public View f49825h;

        /* renamed from: i  reason: collision with root package name */
        public View f49826i;
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
            this.f49818a = (LinearLayout) viewGroup.findViewById(e.title_panel);
            this.f49819b = (TextView) viewGroup.findViewById(e.dialog_title);
            this.f49820c = (TextView) viewGroup.findViewById(e.dialog_message);
            this.f49821d = (LinearLayout) viewGroup.findViewById(e.dialog_message_content);
            this.f49822e = (TextView) viewGroup.findViewById(e.positive_button);
            this.f49823f = (TextView) viewGroup.findViewById(e.negative_button);
            this.f49824g = (TextView) viewGroup.findViewById(e.neutral_button);
            this.f49826i = viewGroup.findViewById(e.divider3);
            this.j = viewGroup.findViewById(e.divider4);
            this.o = (FrameLayout) viewGroup.findViewById(e.dialog_custom_content);
            this.q = (ImageView) viewGroup.findViewById(e.dialog_icon);
            this.r = (RelativeLayout) viewGroup.findViewById(e.searchbox_alert_dialog);
            this.f49825h = viewGroup.findViewById(e.divider2);
            this.s = (AdScrollView) viewGroup.findViewById(e.message_scrollview);
            this.t = (LinearLayout) viewGroup.findViewById(e.btn_panel);
            this.u = viewGroup.findViewById(e.dialog_customPanel);
            this.A = (FrameLayout) viewGroup.findViewById(e.dialog_root);
            this.B = viewGroup.findViewById(e.nightmode_mask);
            int color = this.v.getResources().getColor(d.a.o0.f.i.b.swan_ad_dialog_btn_text_color);
            this.w = color;
            this.x = color;
        }
    }

    /* loaded from: classes7.dex */
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

    public void c(C1053a c1053a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1053a) == null) {
            this.f49808e = c1053a;
        }
    }

    public void d(String str) {
        C1053a c1053a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (c1053a = this.f49808e) == null) {
            return;
        }
        c1053a.g(str);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
        }
    }
}
