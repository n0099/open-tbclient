package d.a.q0.g1.f;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f57048a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57049b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f57050c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57051d;

    /* renamed from: e  reason: collision with root package name */
    public View f57052e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f57053f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f57054g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f57055h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f57056i;
    public Animation j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f57057e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f57058f;

        /* renamed from: d.a.q0.g1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1396a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f57059e;

            public RunnableC1396a(a aVar) {
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
                this.f57059e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57059e.f57058f.m <= 1 || this.f57059e.f57058f.f57050c.getAnimation() == this.f57059e.f57058f.f57056i) {
                    return;
                }
                this.f57059e.f57058f.f57050c.startAnimation(this.f57059e.f57058f.f57056i);
            }
        }

        public a(e eVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57058f = eVar;
            this.f57057e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57058f.f57050c.getAnimation() == this.f57058f.f57054g) {
                    this.f57058f.f57050c.clearAnimation();
                    return;
                }
                this.f57058f.f57051d.setVisibility(0);
                this.f57058f.f57051d.setText(StringHelper.numFormatOverWan(this.f57057e + 1));
                if (this.f57058f.l) {
                    SkinManager.setImageResource(this.f57058f.f57049b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f57058f.f57049b, R.drawable.candle_gif);
                }
                e eVar = this.f57058f;
                eVar.f57053f = (AnimationDrawable) eVar.f57049b.getDrawable();
                this.f57058f.f57053f.start();
                this.f57058f.f57050c.postDelayed(new RunnableC1396a(this), 2000L);
                ((HotTopicActivity) this.f57058f.f57048a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f57060e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f57061f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f57062e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57062e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57062e.f57061f.m <= 1 || this.f57062e.f57061f.f57050c.getAnimation() == this.f57062e.f57061f.f57056i) {
                    return;
                }
                this.f57062e.f57061f.f57050c.startAnimation(this.f57062e.f57061f.f57056i);
            }
        }

        public b(e eVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57061f = eVar;
            this.f57060e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57061f.f57050c.getAnimation() == this.f57061f.f57054g) {
                    this.f57061f.f57050c.clearAnimation();
                    return;
                }
                this.f57061f.f57051d.setVisibility(0);
                this.f57061f.f57051d.setText(StringHelper.numFormatOverWan(this.f57060e + 1));
                if (this.f57061f.l) {
                    SkinManager.setImageResource(this.f57061f.f57049b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f57061f.f57049b, R.drawable.candle_gif);
                }
                e eVar = this.f57061f;
                eVar.f57053f = (AnimationDrawable) eVar.f57049b.getDrawable();
                this.f57061f.f57053f.start();
                this.f57061f.f57050c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f57061f.f57048a.getOrignalPage()).sendBlessData();
            }
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = false;
        this.m = -1;
        this.f57048a = tbPageContext;
        this.f57049b = (ImageView) view.findViewById(R.id.gif_image);
        this.f57050c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f57051d = (TextView) view.findViewById(R.id.git_desc);
        this.f57052e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57049b.clearAnimation();
            this.f57050c.clearAnimation();
            Animation animation = this.f57054g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f57055h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f57056i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f57053f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i3)}) == null) || this.k) {
            return;
        }
        this.f57050c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f57051d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f57051d.setVisibility(0);
                SkinManager.setImageResource(this.f57049b, R.drawable.bless_gif);
            } else {
                this.f57051d.setVisibility(8);
                SkinManager.setImageResource(this.f57049b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f57051d.getLayoutParams()).setMargins(this.f57048a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f57048a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f57051d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f57051d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f57051d.setVisibility(0);
                SkinManager.setImageResource(this.f57049b, R.drawable.candle_gif);
            } else {
                this.f57051d.setVisibility(8);
                SkinManager.setImageResource(this.f57049b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f57051d.getLayoutParams()).setMargins(this.f57048a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f57048a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f57051d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f57051d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f57050c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f57049b.getDrawable();
            this.f57053f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f57052e.setOnClickListener(new a(this, j));
            this.f57050c.setOnClickListener(new b(this, j));
        }
        this.k = true;
        this.f57054g = AnimationUtils.loadAnimation(this.f57048a.getPageActivity(), R.anim.gifview_rotate);
        this.f57055h = AnimationUtils.loadAnimation(this.f57048a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f57056i = AnimationUtils.loadAnimation(this.f57048a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f57048a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f57049b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f57050c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f57050c.startAnimation(animation2);
                        this.f57053f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f57050c.getAnimation();
                Animation animation4 = this.f57056i;
                if (animation3 != animation4) {
                    this.f57050c.startAnimation(animation4);
                    this.f57053f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f57050c.getAnimation();
                Animation animation6 = this.f57054g;
                if (animation5 != animation6) {
                    this.f57050c.startAnimation(animation6);
                }
            } else if (this.f57050c.getAnimation() == this.f57054g) {
                this.f57050c.startAnimation(this.f57055h);
            }
        }
    }
}
