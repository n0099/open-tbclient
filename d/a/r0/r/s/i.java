package d.a.r0.r.s;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56185e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f56186f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56187g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56188h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f56189i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public Runnable p;
    public d.a.r0.a.e0.a q;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f56190e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56190e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56190e.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485374313, "Ld/a/r0/r/s/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-485374313, "Ld/a/r0/r/s/i;");
                return;
            }
        }
        r = R.drawable.shape_new_complete_toast_bg;
    }

    public i(Context context) {
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
        this.n = 1.0f;
        this.o = 3000;
        if (context == null) {
            return;
        }
        this.f56185e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f56186f = viewGroup;
        this.f56187g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f56186f.findViewById(R.id.toast_btn);
        this.f56188h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f56186f.findViewById(R.id.toast_bg);
        this.f56189i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.f56189i.setDrawCorner(true);
        this.f56189i.setConrers(15);
        this.f56189i.setRadius(d.a.c.e.p.l.g(context, R.dimen.tbds20));
        this.m = d.a.c.e.p.l.g(context, R.dimen.tbds176);
        this.l = d.a.c.e.p.l.g(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f56186f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.j = (WindowManager) this.f56185e.getSystemService("window");
        h();
        this.p = new a(this);
    }

    public static i i(Context context, d.a.r0.a.e0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            i iVar = new i(context);
            iVar.a(aVar);
            return iVar;
        }
        return (i) invokeLL.objValue;
    }

    public final i a(d.a.r0.a.e0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f56185e == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.q = aVar;
            if (d.a.c.e.p.k.isEmpty(aVar.f54608e)) {
                this.f56187g.setText(this.f56185e.getResources().getString(R.string.task_already_finish));
            } else {
                this.f56187g.setText(aVar.f54608e);
            }
            if (d.a.c.e.p.k.isEmpty(aVar.f54609f)) {
                this.f56188h.setText(this.f56185e.getResources().getString(R.string.back));
            } else {
                this.f56188h.setText(aVar.f54609f);
            }
            if (d.a.c.e.p.k.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f56187g, R.color.CAM_X0302, 1);
            } else {
                this.f56187g.setTextColor(d.a.s0.n1.o.k.b.b(aVar.p));
            }
            if (d.a.c.e.p.k.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f56188h, R.color.CAM_X0101, 1);
            } else {
                this.f56188h.setTextColor(d.a.s0.n1.o.k.b.b(aVar.q));
            }
            if (!d.a.c.e.p.k.isEmpty(aVar.o)) {
                this.f56188h.setBackgroundDrawable(b(aVar.o));
            }
            if (!d.a.c.e.p.k.isEmpty(aVar.j)) {
                this.f56189i.M(aVar.j, 10, false);
            }
            int i2 = aVar.f54612i;
            if (i2 > 3) {
                this.o = i2 * 1000;
            }
            this.n = (float) aVar.n;
            j();
            return this;
        }
        return (i) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f56185e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(d.a.c.e.p.l.g(this.f56185e, R.dimen.tbds10));
            gradientDrawable.setColor(d.a.s0.n1.o.k.b.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f56187g.setText(this.f56185e.getResources().getString(R.string.task_already_finish));
            this.f56188h.setText(this.f56185e.getResources().getString(R.string.back));
            SkinManager.setViewTextColor(this.f56187g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f56188h, R.color.CAM_X0101, 1);
            j();
            return this;
        }
        return (i) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || d.a.c.e.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(e2, new String[]{str});
    }

    public final TbPageContext e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f56185e != null) {
                if (this.f56186f.getWindowToken() != null) {
                    this.j.removeView(this.f56186f);
                }
                d.a.c.e.m.e.a().removeCallbacks(this.p);
            }
            this.f56185e = null;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.k = layoutParams;
            layoutParams.width = d.a.c.e.p.l.k(this.f56185e) - (this.l * 2);
            this.k.height = d.a.c.e.p.l.g(this.f56185e, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.k;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.new_complete_task_toast;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.k;
            layoutParams.y = this.m;
            layoutParams.alpha = this.n;
        }
    }

    public i k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f56185e != null) {
                this.j.addView(this.f56186f, this.k);
                d.a.c.e.m.e.a().removeCallbacks(this.p);
                d.a.c.e.m.e.a().postDelayed(this.p, this.o);
                if (this.q != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.f54604a).param("obj_type", this.q.f54605b));
                }
            }
            return this;
        }
        return (i) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.r0.a.e0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.q) == null) {
            return;
        }
        int i2 = aVar.f54607d;
        if (i2 == d.a.r0.a.e0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !d.a.c.e.p.k.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i2 == d.a.r0.a.e0.a.E && !d.a.c.e.p.k.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.f54604a).param("obj_type", this.q.f54605b));
    }
}
