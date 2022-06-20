package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class mp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ro3 A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public RelativeLayout a;
    public View b;
    public RewardVideoView c;
    public mo3 d;
    public int e;
    public ProgressBar f;
    public LinearLayout g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public eo3 s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public no3 x;
    public boolean y;
    public fo3 z;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public b(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.K();
            int currentPosition = this.a.d.getCurrentPosition();
            mp3 mp3Var = this.a;
            mp3Var.J(mp3Var.e, currentPosition);
            int min = Math.min(currentPosition + 1000, this.a.e);
            this.a.f.setProgress(min / 1000);
            if (min < this.a.e) {
                this.a.r.postDelayed(this.a.C, 100L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public c(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                return;
            }
            if (this.a.c.d()) {
                this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f080e58);
                this.a.c.e(false);
                return;
            }
            this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f080e57);
            this.a.c.e(true);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public d(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.s == null) {
                return;
            }
            this.a.s.e(view2);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public e(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.z == null) {
                return;
            }
            this.a.z.f(view2);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements RewardVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public f(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) this.a.p.getSystemService("audio")).getStreamMinVolume(3) : 0;
                if (i <= streamMinVolume || !this.a.c.d()) {
                    if (i > streamMinVolume || this.a.c.d()) {
                        return;
                    }
                    this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f080e57);
                    this.a.c.e(true);
                    return;
                }
                this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f080e58);
                this.a.c.e(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public g(mp3 mp3Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int n = jo3.b().n();
                if (jo3.b().u(this.a)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.topMargin = this.a.getTop() + n;
                    this.a.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public mp3(Context context, AdElementInfo adElementInfo, no3 no3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, no3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.n = jo3.b().q();
        this.o = jo3.b().p();
        this.w = this.p.getResources();
        this.x = no3Var;
        this.y = lp3.i();
        w();
        this.A = new ro3(this.p);
        x(this.g);
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

    public void E(eo3 eo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eo3Var) == null) {
            this.s = eo3Var;
        }
    }

    public void F(fo3 fo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fo3Var) == null) {
            this.z = fo3Var;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (rewardVideoView = this.c) == null) {
            return;
        }
        rewardVideoView.f(str);
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(this.C, 0L);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f == null) {
            return;
        }
        this.r.removeCallbacksAndMessages(null);
    }

    public final void J(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.y) {
            if (j <= 15000 || i > 15000) {
                this.j.setText(R.string.obfuscated_res_0x7f0f1349);
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i < 5000) {
                this.g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else if (i < 10000) {
                this.g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.i.setVisibility(0);
            }
        }
    }

    public final void K() {
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || (mo3Var = this.d) == null) {
            return;
        }
        this.e = mo3Var.getDuration();
        int min = Math.min(this.q.getRewardTime(), this.e / 1000);
        int skipTime = this.q.getSkipTime();
        int currentPosition = this.d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f134b);
        String string2 = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f134c);
        if (currentPosition <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.e / 1000) - currentPosition)));
        }
        if (currentPosition <= skipTime) {
            this.i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(R.drawable.obfuscated_res_0x7f080e54));
            this.l.setTextColor(this.w.getColor(R.color.obfuscated_res_0x7f060445));
            this.l.setText(this.w.getString(R.string.obfuscated_res_0x7f0f03e3));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(kp3.a(96.0f), kp3.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.g.getTop(), this.w.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07034a), 0);
            this.a.addView(this.l, layoutParams);
            x(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        this.B = true;
        this.g.setVisibility(4);
        this.m.setVisibility(4);
        this.i.setVisibility(4);
        if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
            InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
            this.v = interactiveEndFrameView;
            interactiveEndFrameView.s(this.q, this.a);
            this.a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
            ap3.i(this.q, this.A);
        } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
            RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
            this.u = rewardLoadWebView;
            rewardLoadWebView.b("reward_end_frame_html", this.q, this.x);
            this.a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
            ap3.i(this.q, this.A);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d05ff, (ViewGroup) null);
            this.a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091a69)).setImageUrl(this.q.getIconUrl());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092017)).setText(this.q.getTitle());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09074d)).setText(this.q.getDescription());
            Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f0907e5);
            if (this.q.getActionType() == 1) {
                button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f10f3));
            }
            if (this.q.getActionType() == 2) {
                button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1290));
            }
            inflate.findViewById(R.id.obfuscated_res_0x7f0906b1).setOnClickListener(this.F);
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
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f;
            if (progressBar != null && (mo3Var = this.d) != null) {
                progressBar.setMax(mo3Var.getDuration() / 1000);
                this.f.setVisibility(4);
            }
            if (this.j != null && this.d != null && (adElementInfo = this.q) != null) {
                this.j.setText(String.format(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f134b), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.g.getVisibility() != 0) {
                this.g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, R.anim.obfuscated_res_0x7f0100b1));
                this.m.setVisibility(0);
            }
            mo3 mo3Var2 = this.d;
            if (mo3Var2 != null) {
                J(mo3Var2.getDuration(), this.d.getCurrentPosition());
            }
        }
    }

    public abstract String q();

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public mo3 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (mo3) invokeV.objValue;
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
            this.a.setOnTouchListener(new a(this));
            this.h.setOnClickListener(this.D);
            this.i.setOnClickListener(this.E);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = u();
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.a = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091a6d);
            RewardVideoView rewardVideoView = (RewardVideoView) this.b.findViewById(R.id.obfuscated_res_0x7f09235f);
            this.c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.c.setOnClickListener(this.F);
            }
            this.f = (ProgressBar) this.b.findViewById(R.id.obfuscated_res_0x7f091dfd);
            this.g = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0923ce);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0923cf);
            if (this.c.d()) {
                this.h.setImageResource(R.drawable.obfuscated_res_0x7f080e57);
            }
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090626);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090629);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f09062a);
            this.m = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0902f9);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.b(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091a69)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092017)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09074d)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f0907e5);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f10f3));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1290));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.d = this.c.getPlayer();
            v();
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            view2.post(new g(this, view2));
        }
    }

    public void y() {
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (mo3Var = this.d) == null) {
            return;
        }
        this.e = mo3Var.getDuration();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }
}
