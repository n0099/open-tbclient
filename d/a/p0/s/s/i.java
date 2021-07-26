package d.a.p0.s.s;

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
/* loaded from: classes7.dex */
public class i implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f53568e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f53569f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53570g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53571h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f53572i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public Runnable p;
    public d.a.p0.a.e0.a q;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f53573e;

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
            this.f53573e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53573e.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136803532, "Ld/a/p0/s/s/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136803532, "Ld/a/p0/s/s/i;");
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
        this.f53568e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f53569f = viewGroup;
        this.f53570g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f53569f.findViewById(R.id.toast_btn);
        this.f53571h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f53569f.findViewById(R.id.toast_bg);
        this.f53572i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.f53572i.setDrawCorner(true);
        this.f53572i.setConrers(15);
        this.f53572i.setRadius(d.a.d.e.p.l.g(context, R.dimen.tbds20));
        this.m = d.a.d.e.p.l.g(context, R.dimen.tbds176);
        this.l = d.a.d.e.p.l.g(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f53569f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.j = (WindowManager) this.f53568e.getSystemService("window");
        g();
        this.p = new a(this);
    }

    public static i h(Context context, d.a.p0.a.e0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            i iVar = new i(context);
            iVar.a(aVar);
            return iVar;
        }
        return (i) invokeLL.objValue;
    }

    public final i a(d.a.p0.a.e0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f53568e == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.q = aVar;
            if (d.a.d.e.p.k.isEmpty(aVar.f51814e)) {
                this.f53570g.setText(this.f53568e.getResources().getString(R.string.task_already_finish));
            } else {
                this.f53570g.setText(aVar.f51814e);
            }
            if (d.a.d.e.p.k.isEmpty(aVar.f51815f)) {
                this.f53571h.setText(this.f53568e.getResources().getString(R.string.back));
            } else {
                this.f53571h.setText(aVar.f51815f);
            }
            if (d.a.d.e.p.k.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f53570g, R.color.CAM_X0302, 1);
            } else {
                this.f53570g.setTextColor(d.a.q0.n1.o.k.b.b(aVar.p));
            }
            if (d.a.d.e.p.k.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f53571h, R.color.CAM_X0101, 1);
            } else {
                this.f53571h.setTextColor(d.a.q0.n1.o.k.b.b(aVar.q));
            }
            if (!d.a.d.e.p.k.isEmpty(aVar.o)) {
                this.f53571h.setBackgroundDrawable(b(aVar.o));
            }
            if (!d.a.d.e.p.k.isEmpty(aVar.j)) {
                this.f53572i.M(aVar.j, 10, false);
            }
            int i2 = aVar.f51818i;
            if (i2 > 3) {
                this.o = i2 * 1000;
            }
            this.n = (float) aVar.n;
            i();
            return this;
        }
        return (i) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f53568e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(d.a.d.e.p.l.g(this.f53568e, R.dimen.tbds10));
            gradientDrawable.setColor(d.a.q0.n1.o.k.b.b(str));
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
            this.f53570g.setText(this.f53568e.getResources().getString(R.string.task_already_finish));
            this.f53571h.setText(this.f53568e.getResources().getString(R.string.back));
            SkinManager.setViewTextColor(this.f53570g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f53571h, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (i) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || d.a.d.e.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
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
            if (this.f53568e != null) {
                if (this.f53569f.getWindowToken() != null) {
                    this.j.removeView(this.f53569f);
                }
                d.a.d.e.m.e.a().removeCallbacks(this.p);
            }
            this.f53568e = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.k = layoutParams;
            layoutParams.width = d.a.d.e.p.l.k(this.f53568e) - (this.l * 2);
            this.k.height = d.a.d.e.p.l.g(this.f53568e, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.k;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.new_complete_task_toast;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.k;
            layoutParams.y = this.m;
            layoutParams.alpha = this.n;
        }
    }

    public i j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f53568e != null) {
                this.j.addView(this.f53569f, this.k);
                d.a.d.e.m.e.a().removeCallbacks(this.p);
                d.a.d.e.m.e.a().postDelayed(this.p, this.o);
                if (this.q != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.f51810a).param("obj_type", this.q.f51811b));
                }
            }
            return this;
        }
        return (i) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.p0.a.e0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.q) == null) {
            return;
        }
        int i2 = aVar.f51813d;
        if (i2 == d.a.p0.a.e0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !d.a.d.e.p.k.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i2 == d.a.p0.a.e0.a.E && !d.a.d.e.p.k.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.f51810a).param("obj_type", this.q.f51811b));
    }
}
