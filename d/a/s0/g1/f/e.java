package d.a.s0.g1.f;

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
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f59762a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59763b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59764c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59765d;

    /* renamed from: e  reason: collision with root package name */
    public View f59766e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f59767f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f59768g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f59769h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f59770i;
    public Animation j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f59771e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f59772f;

        /* renamed from: d.a.s0.g1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1433a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f59773e;

            public RunnableC1433a(a aVar) {
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
                this.f59773e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59773e.f59772f.m <= 1 || this.f59773e.f59772f.f59764c.getAnimation() == this.f59773e.f59772f.f59770i) {
                    return;
                }
                this.f59773e.f59772f.f59764c.startAnimation(this.f59773e.f59772f.f59770i);
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
            this.f59772f = eVar;
            this.f59771e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59772f.f59764c.getAnimation() == this.f59772f.f59768g) {
                    this.f59772f.f59764c.clearAnimation();
                    return;
                }
                this.f59772f.f59765d.setVisibility(0);
                this.f59772f.f59765d.setText(StringHelper.numFormatOverWan(this.f59771e + 1));
                if (this.f59772f.l) {
                    SkinManager.setImageResource(this.f59772f.f59763b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f59772f.f59763b, R.drawable.candle_gif);
                }
                e eVar = this.f59772f;
                eVar.f59767f = (AnimationDrawable) eVar.f59763b.getDrawable();
                this.f59772f.f59767f.start();
                this.f59772f.f59764c.postDelayed(new RunnableC1433a(this), 2000L);
                ((HotTopicActivity) this.f59772f.f59762a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f59774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f59775f;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f59776e;

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
                this.f59776e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59776e.f59775f.m <= 1 || this.f59776e.f59775f.f59764c.getAnimation() == this.f59776e.f59775f.f59770i) {
                    return;
                }
                this.f59776e.f59775f.f59764c.startAnimation(this.f59776e.f59775f.f59770i);
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
            this.f59775f = eVar;
            this.f59774e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59775f.f59764c.getAnimation() == this.f59775f.f59768g) {
                    this.f59775f.f59764c.clearAnimation();
                    return;
                }
                this.f59775f.f59765d.setVisibility(0);
                this.f59775f.f59765d.setText(StringHelper.numFormatOverWan(this.f59774e + 1));
                if (this.f59775f.l) {
                    SkinManager.setImageResource(this.f59775f.f59763b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f59775f.f59763b, R.drawable.candle_gif);
                }
                e eVar = this.f59775f;
                eVar.f59767f = (AnimationDrawable) eVar.f59763b.getDrawable();
                this.f59775f.f59767f.start();
                this.f59775f.f59764c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f59775f.f59762a.getOrignalPage()).sendBlessData();
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
        this.f59762a = tbPageContext;
        this.f59763b = (ImageView) view.findViewById(R.id.gif_image);
        this.f59764c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f59765d = (TextView) view.findViewById(R.id.git_desc);
        this.f59766e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59763b.clearAnimation();
            this.f59764c.clearAnimation();
            Animation animation = this.f59768g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f59769h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f59770i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f59767f;
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
        this.f59764c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f59765d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f59765d.setVisibility(0);
                SkinManager.setImageResource(this.f59763b, R.drawable.bless_gif);
            } else {
                this.f59765d.setVisibility(8);
                SkinManager.setImageResource(this.f59763b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f59765d.getLayoutParams()).setMargins(this.f59762a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f59762a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f59765d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f59765d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f59765d.setVisibility(0);
                SkinManager.setImageResource(this.f59763b, R.drawable.candle_gif);
            } else {
                this.f59765d.setVisibility(8);
                SkinManager.setImageResource(this.f59763b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f59765d.getLayoutParams()).setMargins(this.f59762a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f59762a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f59765d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f59765d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f59764c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f59763b.getDrawable();
            this.f59767f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f59766e.setOnClickListener(new a(this, j));
            this.f59764c.setOnClickListener(new b(this, j));
        }
        this.k = true;
        this.f59768g = AnimationUtils.loadAnimation(this.f59762a.getPageActivity(), R.anim.gifview_rotate);
        this.f59769h = AnimationUtils.loadAnimation(this.f59762a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f59770i = AnimationUtils.loadAnimation(this.f59762a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f59762a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f59763b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f59764c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f59764c.startAnimation(animation2);
                        this.f59767f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f59764c.getAnimation();
                Animation animation4 = this.f59770i;
                if (animation3 != animation4) {
                    this.f59764c.startAnimation(animation4);
                    this.f59767f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f59764c.getAnimation();
                Animation animation6 = this.f59768g;
                if (animation5 != animation6) {
                    this.f59764c.startAnimation(animation6);
                }
            } else if (this.f59764c.getAnimation() == this.f59768g) {
                this.f59764c.startAnimation(this.f59769h);
            }
        }
    }
}
