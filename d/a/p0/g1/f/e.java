package d.a.p0.g1.f;

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
    public TbPageContext<HotTopicActivity> f56504a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56505b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f56506c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56507d;

    /* renamed from: e  reason: collision with root package name */
    public View f56508e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f56509f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56510g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f56511h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f56512i;
    public Animation j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f56514f;

        /* renamed from: d.a.p0.g1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1387a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f56515e;

            public RunnableC1387a(a aVar) {
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
                this.f56515e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56515e.f56514f.m <= 1 || this.f56515e.f56514f.f56506c.getAnimation() == this.f56515e.f56514f.f56512i) {
                    return;
                }
                this.f56515e.f56514f.f56506c.startAnimation(this.f56515e.f56514f.f56512i);
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
            this.f56514f = eVar;
            this.f56513e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56514f.f56506c.getAnimation() == this.f56514f.f56510g) {
                    this.f56514f.f56506c.clearAnimation();
                    return;
                }
                this.f56514f.f56507d.setVisibility(0);
                this.f56514f.f56507d.setText(StringHelper.numFormatOverWan(this.f56513e + 1));
                if (this.f56514f.l) {
                    SkinManager.setImageResource(this.f56514f.f56505b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f56514f.f56505b, R.drawable.candle_gif);
                }
                e eVar = this.f56514f;
                eVar.f56509f = (AnimationDrawable) eVar.f56505b.getDrawable();
                this.f56514f.f56509f.start();
                this.f56514f.f56506c.postDelayed(new RunnableC1387a(this), 2000L);
                ((HotTopicActivity) this.f56514f.f56504a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f56517f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f56518e;

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
                this.f56518e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56518e.f56517f.m <= 1 || this.f56518e.f56517f.f56506c.getAnimation() == this.f56518e.f56517f.f56512i) {
                    return;
                }
                this.f56518e.f56517f.f56506c.startAnimation(this.f56518e.f56517f.f56512i);
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
            this.f56517f = eVar;
            this.f56516e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56517f.f56506c.getAnimation() == this.f56517f.f56510g) {
                    this.f56517f.f56506c.clearAnimation();
                    return;
                }
                this.f56517f.f56507d.setVisibility(0);
                this.f56517f.f56507d.setText(StringHelper.numFormatOverWan(this.f56516e + 1));
                if (this.f56517f.l) {
                    SkinManager.setImageResource(this.f56517f.f56505b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f56517f.f56505b, R.drawable.candle_gif);
                }
                e eVar = this.f56517f;
                eVar.f56509f = (AnimationDrawable) eVar.f56505b.getDrawable();
                this.f56517f.f56509f.start();
                this.f56517f.f56506c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f56517f.f56504a.getOrignalPage()).sendBlessData();
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
        this.f56504a = tbPageContext;
        this.f56505b = (ImageView) view.findViewById(R.id.gif_image);
        this.f56506c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f56507d = (TextView) view.findViewById(R.id.git_desc);
        this.f56508e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f56505b.clearAnimation();
            this.f56506c.clearAnimation();
            Animation animation = this.f56510g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f56511h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f56512i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f56509f;
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
        this.f56506c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f56507d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f56507d.setVisibility(0);
                SkinManager.setImageResource(this.f56505b, R.drawable.bless_gif);
            } else {
                this.f56507d.setVisibility(8);
                SkinManager.setImageResource(this.f56505b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f56507d.getLayoutParams()).setMargins(this.f56504a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f56504a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f56507d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f56507d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f56507d.setVisibility(0);
                SkinManager.setImageResource(this.f56505b, R.drawable.candle_gif);
            } else {
                this.f56507d.setVisibility(8);
                SkinManager.setImageResource(this.f56505b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f56507d.getLayoutParams()).setMargins(this.f56504a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f56504a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f56507d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f56507d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f56506c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f56505b.getDrawable();
            this.f56509f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f56508e.setOnClickListener(new a(this, j));
            this.f56506c.setOnClickListener(new b(this, j));
        }
        this.k = true;
        this.f56510g = AnimationUtils.loadAnimation(this.f56504a.getPageActivity(), R.anim.gifview_rotate);
        this.f56511h = AnimationUtils.loadAnimation(this.f56504a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f56512i = AnimationUtils.loadAnimation(this.f56504a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f56504a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f56505b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f56506c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f56506c.startAnimation(animation2);
                        this.f56509f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f56506c.getAnimation();
                Animation animation4 = this.f56512i;
                if (animation3 != animation4) {
                    this.f56506c.startAnimation(animation4);
                    this.f56509f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f56506c.getAnimation();
                Animation animation6 = this.f56510g;
                if (animation5 != animation6) {
                    this.f56506c.startAnimation(animation6);
                }
            } else if (this.f56506c.getAnimation() == this.f56510g) {
                this.f56506c.startAnimation(this.f56511h);
            }
        }
    }
}
