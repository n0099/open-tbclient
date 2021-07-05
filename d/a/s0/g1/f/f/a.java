package d.a.s0.g1.f.f;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f59777a;

    /* renamed from: b  reason: collision with root package name */
    public View f59778b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59779c;

    /* renamed from: d  reason: collision with root package name */
    public View f59780d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f59781e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59782f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f59783g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f59784h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59785i;
    public Animation.AnimationListener j;

    /* renamed from: d.a.s0.g1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class animation.Animation$AnimationListenerC1434a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59786a;

        public animation.Animation$AnimationListenerC1434a(a aVar) {
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
            this.f59786a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f59786a.f59779c == null) {
                return;
            }
            if (animation == this.f59786a.f59783g) {
                this.f59786a.f59779c.setVisibility(0);
                this.f59786a.f59779c.setClickable(true);
            } else if (animation == this.f59786a.f59784h) {
                this.f59786a.f59779c.setVisibility(8);
                this.f59786a.f59779c.setClickable(false);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
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
        this.f59785i = true;
        this.j = new animation.Animation$AnimationListenerC1434a(this);
        this.f59782f = context;
        this.f59778b = view;
        this.f59779c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f59780d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f59777a = imageView;
        imageView.setContentDescription("展开");
        this.f59781e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59785i = true;
            TextView textView = this.f59779c;
            if (textView != null) {
                textView.clearAnimation();
                this.f59779c.startAnimation(f());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
            this.f59781e.setDrawBottomLine(true);
            this.f59780d.setVisibility(0);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f59783g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f59782f, R.anim.fade_in);
                this.f59783g = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f59783g;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f59784h == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f59782f, R.anim.fade_out);
                this.f59784h = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f59784h;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f59778b, R.color.common_color_10274);
            SkinManager.setBackgroundColor(this.f59779c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f59779c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f59780d, R.color.CAM_X0204);
            if (this.f59785i) {
                if (1 != i2 && 4 != i2) {
                    this.f59777a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                    this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
                } else {
                    this.f59777a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                    this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
                }
            } else if (1 != i2 && 4 != i2) {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
            } else {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
            }
            SlidingTabLayout slidingTabLayout = this.f59781e;
            if (slidingTabLayout != null) {
                slidingTabLayout.j(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f59777a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) || (slidingTabLayout = this.f59781e) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager);
    }

    public void j(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f59778b) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f59785i = false;
            TextView textView = this.f59779c;
            if (textView != null) {
                textView.clearAnimation();
                this.f59779c.setVisibility(0);
                this.f59779c.startAnimation(e());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
            } else {
                this.f59777a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
                this.f59777a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
            }
            this.f59781e.setDrawBottomLine(false);
            this.f59780d.setVisibility(8);
        }
    }
}
