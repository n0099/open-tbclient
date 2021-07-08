package d.a.p0.n1.q;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.d;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f60674a;

    /* renamed from: b  reason: collision with root package name */
    public View f60675b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60676c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f60677d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60678e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f60679f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f60680g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60681h;

    /* renamed from: i  reason: collision with root package name */
    public d f60682i;

    /* renamed from: d.a.p0.n1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1564a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60683a;

        public C1564a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60683a = aVar;
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f60683a.f60676c == null) {
                return;
            }
            if (animation == this.f60683a.f60679f) {
                this.f60683a.f60676c.setVisibility(0);
                this.f60683a.f60676c.setClickable(true);
            } else if (animation == this.f60683a.f60680g) {
                this.f60683a.f60676c.setVisibility(8);
                this.f60683a.f60676c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60681h = true;
        this.f60682i = new C1564a(this);
        this.f60675b = view;
        this.f60678e = context;
        this.f60676c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f60674a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f60677d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60681h = true;
            TextView textView = this.f60676c;
            if (textView != null) {
                textView.clearAnimation();
                this.f60676c.startAnimation(f());
            }
            SkinManager.setImageResource(this.f60674a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f60679f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f60678e, R.anim.fade_in);
                this.f60679f = loadAnimation;
                loadAnimation.setAnimationListener(this.f60682i);
            }
            return this.f60679f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f60680g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f60678e, R.anim.fade_out);
                this.f60680g = loadAnimation;
                loadAnimation.setAnimationListener(this.f60682i);
            }
            return this.f60680g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f60675b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f60676c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f60676c, R.color.CAM_X0106, 1);
            if (this.f60681h) {
                SkinManager.setImageResource(this.f60674a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.f60674a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.f60674a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f60677d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f60674a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i2) == null) || (slidingTabLayout = this.f60677d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f60681h = false;
            TextView textView = this.f60676c;
            if (textView != null) {
                textView.clearAnimation();
                this.f60676c.setVisibility(0);
                this.f60676c.startAnimation(e());
            }
            SkinManager.setImageResource(this.f60674a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
