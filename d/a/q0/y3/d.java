package d.a.q0.y3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.t.c.l0;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f67150a;

    /* renamed from: b  reason: collision with root package name */
    public View f67151b;

    /* renamed from: c  reason: collision with root package name */
    public View f67152c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67153d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67154e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f67155f;

    /* renamed from: g  reason: collision with root package name */
    public g f67156g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.y3.a f67157h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.y3.c f67158i;
    public int j;
    public boolean k;
    public Runnable l;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67159e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67159e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67159e.f67156g == null) {
                return;
            }
            this.f67159e.f67156g.onError();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67160e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67160e = dVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f67160e.l);
                if (this.f67160e.f67156g != null) {
                    this.f67160e.k = false;
                    this.f67160e.f67156g.onError();
                    return true;
                }
                return true;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67161e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67161e = dVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f67161e.l);
                if (this.f67161e.f67156g != null) {
                    this.f67161e.k = false;
                    this.f67161e.f67156g.onSkip();
                }
            }
        }
    }

    /* renamed from: d.a.q0.y3.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1863d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67162e;

        /* renamed from: d.a.q0.y3.d$d$a */
        /* loaded from: classes8.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1863d f67163e;

            public a(C1863d c1863d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1863d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67163e = c1863d;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        this.f67163e.f67162e.l();
                        return false;
                    }
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        public C1863d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67162e = dVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f67162e.l);
                this.f67162e.f67155f.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnInfoListener(new a(this));
                this.f67162e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67164e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67164e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f67164e.l);
                if (this.f67164e.f67156g != null) {
                    this.f67164e.k = false;
                    this.f67164e.f67156g.onSkip();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f67166f;

        public f(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67166f = dVar;
            this.f67165e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12945"));
                if (k.isEmpty(this.f67165e)) {
                    return;
                }
                this.f67166f.k = false;
                this.f67166f.f67156g.onSkip();
                UrlManager.getInstance().dealOneLink(this.f67166f.f67150a.getPageContext(), new String[]{this.f67165e});
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = true;
        this.l = new a(this);
        this.f67150a = logoActivity;
        this.f67157h = new d.a.q0.y3.a();
        this.f67158i = new d.a.q0.y3.c();
        this.j = 0;
    }

    public boolean h() {
        InterceptResult invokeV;
        d.a.q0.y3.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (d.a.p0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f67157h) != null && this.f67158i != null && aVar.b() && this.f67158i.l();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d.a.p0.s.d0.b.j().k("key_video_splash_switch", 0) == 1) {
                return;
            }
            d.a.q0.y3.c cVar = this.f67158i;
            if (cVar != null) {
                cVar.g();
            }
            d.a.p0.s.d0.b.j().w("key_video_splash_last_show_time", 0L);
        }
    }

    public final View j(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            View inflate = LayoutInflater.from(this.f67150a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f67150a) * d2)));
            ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
            this.f67155f = scaleVideoView;
            scaleVideoView.setOnErrorListener(new b(this));
            this.f67155f.setOnCompletionListener(new c(this));
            this.f67155f.setOnPreparedListener(new C1863d(this));
            TextView textView = (TextView) inflate.findViewById(R.id.skip);
            this.f67154e = textView;
            textView.setOnClickListener(new e(this));
            String p = d.a.p0.s.d0.b.j().p("key_video_splash_config", "");
            l0 l0Var = new l0();
            l0Var.g(p);
            String c2 = l0Var.c();
            View findViewById = inflate.findViewById(R.id.tip_container);
            this.f67152c = findViewById;
            findViewById.setOnClickListener(new f(this, c2));
            this.f67153d = (TextView) inflate.findViewById(R.id.tip_text);
            String b2 = l0Var.b();
            if (k.isEmpty(b2)) {
                b2 = this.f67150a.getString(R.string.video_splash_tip_default);
            }
            this.f67153d.setText(b2);
            s();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.f67151b == null) {
                this.f67151b = j(d2);
            }
            return this.f67151b;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scaleVideoView = this.f67155f) == null) {
            return;
        }
        scaleVideoView.setBackgroundResource(0);
    }

    public final void m() {
        d.a.q0.y3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.f67158i) == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f67155f.setVideoPath(this.f67158i.i());
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.l);
        }
    }

    public void o() {
        ScaleVideoView scaleVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (scaleVideoView = this.f67155f) == null) {
            return;
        }
        this.j = scaleVideoView.getCurrentPosition();
        this.f67155f.stopPlayback();
        if (this.k) {
            s();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            ScaleVideoView scaleVideoView = this.f67155f;
            if (scaleVideoView != null) {
                scaleVideoView.resume();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.q0.y3.a aVar = this.f67157h;
            if (aVar != null) {
                aVar.g(System.currentTimeMillis());
            }
            int i2 = this.j;
            if (i2 >= 0) {
                this.f67155f.seekTo(i2);
            }
            this.f67155f.start();
        }
    }

    public void r(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f67156g = gVar;
        }
    }

    public final void s() {
        d.a.q0.y3.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (cVar = this.f67158i) != null && cVar.l()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f67158i.i());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (this.f67155f != null) {
                    this.f67155f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ScaleVideoView scaleVideoView = this.f67155f;
                if (scaleVideoView != null) {
                    scaleVideoView.setBackgroundColor(this.f67150a.getResources().getColor(R.color.CAM_X0101));
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TiebaStatic.log(new StatisticItem("c12944"));
            d.a.d.e.m.e.a().postDelayed(this.l, 1000L);
            m();
        }
    }
}
