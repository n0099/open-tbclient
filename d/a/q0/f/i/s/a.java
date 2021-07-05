package d.a.q0.f.i.s;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.InteractiveEndFrameView;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.swan.game.ad.view.RewardVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.r.h;
import d.a.q0.f.i.r.i;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.f.i.o.b A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f52762a;

    /* renamed from: b  reason: collision with root package name */
    public View f52763b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f52764c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.f.i.m.b.c f52765d;

    /* renamed from: e  reason: collision with root package name */
    public int f52766e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f52767f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f52768g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f52769h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52770i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public d.a.q0.f.i.l.c s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public d.a.q0.f.i.n.a x;
    public boolean y;
    public d.a.q0.f.i.l.d z;

    /* renamed from: d.a.q0.f.i.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC1107a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnTouchListenerC1107a(a aVar) {
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
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52771e;

        public b(a aVar) {
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
            this.f52771e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52771e.f52765d == null) {
                return;
            }
            this.f52771e.K();
            int currentPosition = this.f52771e.f52765d.getCurrentPosition();
            a aVar = this.f52771e;
            aVar.J(aVar.f52766e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.f52771e.f52766e);
            this.f52771e.f52767f.setProgress(min / 1000);
            if (min < this.f52771e.f52766e) {
                this.f52771e.r.postDelayed(this.f52771e.C, 100L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52772e;

        public c(a aVar) {
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
            this.f52772e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52772e.f52764c == null) {
                return;
            }
            if (this.f52772e.f52764c.d()) {
                this.f52772e.f52769h.setImageResource(d.a.q0.f.i.d.ng_game_vol_open);
                this.f52772e.f52764c.e(false);
                return;
            }
            this.f52772e.f52769h.setImageResource(d.a.q0.f.i.d.ng_game_vol_close);
            this.f52772e.f52764c.e(true);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52773e;

        public d(a aVar) {
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
            this.f52773e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52773e.s == null) {
                return;
            }
            this.f52773e.s.e(view);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52774e;

        public e(a aVar) {
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
            this.f52774e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52774e.z == null) {
                return;
            }
            this.f52774e.z.f(view);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements RewardVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52775a;

        public f(a aVar) {
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
            this.f52775a = aVar;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.f52775a.p.getSystemService("audio")).getStreamMinVolume(3) : 0;
                if (i2 <= streamMinVolume || !this.f52775a.f52764c.d()) {
                    if (i2 > streamMinVolume || this.f52775a.f52764c.d()) {
                        return;
                    }
                    this.f52775a.f52769h.setImageResource(d.a.q0.f.i.d.ng_game_vol_close);
                    this.f52775a.f52764c.e(true);
                    return;
                }
                this.f52775a.f52769h.setImageResource(d.a.q0.f.i.d.ng_game_vol_open);
                this.f52775a.f52764c.e(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f52776e;

        public g(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52776e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = d.a.q0.f.i.m.a.b().n();
                if (d.a.q0.f.i.m.a.b().u(this.f52776e)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52776e.getLayoutParams();
                    layoutParams.topMargin = this.f52776e.getTop() + n;
                    this.f52776e.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, d.a.q0.f.i.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new Handler();
        this.B = false;
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
        this.p = context;
        this.q = adElementInfo;
        this.n = d.a.q0.f.i.m.a.b().q();
        this.o = d.a.q0.f.i.m.a.b().p();
        this.w = this.p.getResources();
        this.x = aVar;
        this.y = i.i();
        w();
        this.A = new d.a.q0.f.i.o.b(this.p);
        x(this.f52768g);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            I();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m();
            I();
        }
    }

    public abstract void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            H();
        }
    }

    public void E(d.a.q0.f.i.l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void F(d.a.q0.f.i.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.z = dVar;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.f52764c) == null) {
            return;
        }
        rewardVideoView.f(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f52767f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f52767f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) && this.y) {
            if (j <= 15000 || i2 > 15000) {
                this.j.setText(d.a.q0.f.i.g.swangame_game_ad_reward_tip);
                this.f52770i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f52768g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.f52770i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f52768g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.f52770i.setVisibility(8);
            } else {
                this.f52768g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f52770i.setVisibility(0);
            }
        }
    }

    public final void K() {
        d.a.q0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (cVar = this.f52765d) == null) {
            return;
        }
        this.f52766e = cVar.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.f52766e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.f52765d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.p.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_video_time_surplus);
        if (currentPosition <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f52766e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.f52770i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f52770i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(d.a.q0.f.i.d.ng_game_bg_close_ad));
            this.l.setTextColor(this.w.getColor(d.a.q0.f.i.b.close_ad_text_color));
            this.l.setText(this.w.getString(d.a.q0.f.i.g.close_ad_des));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.f52768g.getTop(), this.w.getDimensionPixelSize(d.a.q0.f.i.c.include_land_close_ad_margin), 0);
            this.f52762a.addView(this.l, layoutParams);
            x(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f52762a == null) {
            return;
        }
        this.B = true;
        this.f52768g.setVisibility(4);
        this.m.setVisibility(4);
        this.f52770i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.s(this.q, this.f52762a);
            this.f52762a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            d.a.q0.f.i.q.b.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.b("reward_end_frame_html", this.q, this.x);
            this.f52762a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            d.a.q0.f.i.q.b.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(d.a.q0.f.i.f.ng_game_reward_close_banner, (ViewGroup) null);
            this.f52762a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(d.a.q0.f.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(d.a.q0.f.i.e.title)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(d.a.q0.f.i.e.desc)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(d.a.q0.f.i.e.download);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(d.a.q0.f.i.g.see_detail));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(d.a.q0.f.i.g.swanapp_ad_download_button));
            }
            inflate.findViewById(d.a.q0.f.i.e.content_des).setOnClickListener(this.F);
            button.setOnClickListener(this.F);
        }
        l();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            I();
            RewardLoadWebView rewardLoadWebView = this.t;
            if (rewardLoadWebView != null) {
                rewardLoadWebView.c();
                this.t = null;
            }
            RewardLoadWebView rewardLoadWebView2 = this.u;
            if (rewardLoadWebView2 != null) {
                rewardLoadWebView2.c();
                this.u = null;
            }
            InteractiveEndFrameView interactiveEndFrameView = this.v;
            if (interactiveEndFrameView != null) {
                interactiveEndFrameView.t();
                this.v = null;
            }
        }
    }

    public RewardVideoView.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new f(this) : (RewardVideoView.a) invokeV.objValue;
    }

    public void p() {
        AdElementInfo adElementInfo;
        d.a.q0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f52767f;
            if (progressBar != null && (cVar = this.f52765d) != null) {
                progressBar.setMax(cVar.getDuration() / 1000);
                this.f52767f.setVisibility(4);
            }
            if (this.j != null && this.f52765d != null && (adElementInfo = this.q) != null) {
                this.j.setText(String.format(this.p.getResources().getString(d.a.q0.f.i.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.f52765d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.f52770i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.f52768g.getVisibility() != 0) {
                this.f52768g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, d.a.q0.f.i.a.ng_game_ad_open));
                this.m.setVisibility(0);
            }
            d.a.q0.f.i.m.b.c cVar2 = this.f52765d;
            if (cVar2 != null) {
                J(cVar2.getDuration(), this.f52765d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f52763b : (View) invokeV.objValue;
    }

    public d.a.q0.f.i.m.b.c s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.f52764c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (d.a.q0.f.i.m.b.c) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public abstract View u();

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f52762a.setOnTouchListener(new View$OnTouchListenerC1107a(this));
            this.f52769h.setOnClickListener(this.D);
            this.f52770i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f52763b = u();
            this.f52763b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.f52762a = (RelativeLayout) this.f52763b.findViewById(d.a.q0.f.i.e.reward_relative);
            RewardVideoView rewardVideoView = (RewardVideoView) this.f52763b.findViewById(d.a.q0.f.i.e.video_view);
            this.f52764c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.f52764c.setOnClickListener(this.F);
            }
            this.f52767f = (ProgressBar) this.f52763b.findViewById(d.a.q0.f.i.e.swangame_game_ad_video_progress_horizontal);
            this.f52768g = (LinearLayout) this.f52763b.findViewById(d.a.q0.f.i.e.vol_clo);
            this.f52769h = (ImageView) this.f52763b.findViewById(d.a.q0.f.i.e.volume);
            if (this.f52764c.d()) {
                this.f52769h.setImageResource(d.a.q0.f.i.d.ng_game_vol_close);
            }
            this.f52770i = (TextView) this.f52763b.findViewById(d.a.q0.f.i.e.close_ad);
            this.j = (TextView) this.f52763b.findViewById(d.a.q0.f.i.e.close_ad_header);
            this.k = this.f52763b.findViewById(d.a.q0.f.i.e.close_ad_middle);
            this.m = (RelativeLayout) this.f52763b.findViewById(d.a.q0.f.i.e.banner);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.b(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(d.a.q0.f.i.f.ng_game_reward_banner, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(d.a.q0.f.i.e.reward_icon)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(d.a.q0.f.i.e.title)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(d.a.q0.f.i.e.desc)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(d.a.q0.f.i.e.download);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(d.a.q0.f.i.g.see_detail));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(d.a.q0.f.i.g.swanapp_ad_download_button));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.f52765d = this.f52764c.getPlayer();
            v();
        }
    }

    public final void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            view.post(new g(this, view));
        }
    }

    public void y() {
        d.a.q0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (cVar = this.f52765d) == null) {
            return;
        }
        this.f52766e = cVar.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}
