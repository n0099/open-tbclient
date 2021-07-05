package d.a.r0.r.s;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f56169e;

    /* renamed from: f  reason: collision with root package name */
    public View f56170f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f56171g;

    /* renamed from: h  reason: collision with root package name */
    public View f56172h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56173i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Drawable s;
    public View.OnClickListener t;
    public final Runnable u;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f56174e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56174e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56174e.e();
            }
        }
    }

    public g(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 1.0f;
        this.o = 5000;
        this.u = new a(this);
        if (activity == null) {
            return;
        }
        this.f56169e = activity;
        this.r = d.a.c.e.p.l.g(activity, R.dimen.tbds114);
        this.p = d.a.c.e.p.l.g(activity, R.dimen.tbds84);
        this.q = d.a.c.e.p.l.g(activity, R.dimen.tbds44);
        this.m = d.a.c.e.p.l.g(activity, R.dimen.tbds222);
        this.l = d.a.c.e.p.l.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f56171g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f56172h = inflate.findViewById(R.id.background);
        this.f56173i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f56170f = inflate;
        this.f56172h.setBackgroundDrawable(b());
        this.f56173i.setMaxLines(1);
        this.f56173i.setGravity(17);
        this.f56173i.setTextSize(0, d.a.c.e.p.l.g(activity, R.dimen.tbfontsize40));
        this.f56173i.setTextColor(this.f56169e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f56173i;
        int i4 = this.q;
        textView.setPadding(i4, 0, i4, 0);
        this.j = (WindowManager) this.f56169e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.a.c.e.p.l.k(this.f56169e) - (this.l * 2);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.height = this.r;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.ToastAnimation;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.k.alpha = this.n;
    }

    public static g f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            g gVar = new g(activity);
            gVar.a(str);
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f56169e != null && !TextUtils.isEmpty(str)) {
                String e2 = j0.e(str, 34);
                int t = d.a.c.e.p.l.t(this.f56173i.getPaint(), e2);
                ViewGroup.LayoutParams layoutParams = this.f56171g.getLayoutParams();
                layoutParams.width = t + (this.q * 2);
                this.f56171g.setLayoutParams(layoutParams);
                this.f56173i.setText(e2);
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.s == null) {
                this.s = c();
            }
            return this.s;
        }
        return (Drawable) invokeV.objValue;
    }

    public final GradientDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{d.a.s0.n1.o.k.b.b("#FF722B"), d.a.s0.n1.o.k.b.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.p);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m + UtilHelper.getNavigationBarHeight(this.f56169e) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.u);
            if (this.f56170f.getWindowToken() != null) {
                this.j.removeView(this.f56170f);
            }
        }
    }

    public g g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 > 0) {
                this.o = i2 * 1000;
            }
            return this;
        }
        return (g) invokeI.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.f56171g.setTag(obj);
            this.f56171g.setOnClickListener(this);
        }
    }

    public g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.u);
            View view = this.f56170f;
            if (view != null && view.getWindowToken() != null) {
                this.j.removeView(this.f56170f);
            }
            this.j.addView(this.f56170f, this.k);
            d.a.c.e.m.e.a().postDelayed(this.u, this.o);
            return this;
        }
        return (g) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            View.OnClickListener onClickListener = this.t;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            e();
        }
    }
}
