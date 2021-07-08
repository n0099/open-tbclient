package d.a.p0.v.d.f.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.z0.o0;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class f extends d.a.p0.v.d.f.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f64576f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f64577g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f64578h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f64579i;
    public TextView j;
    public VideoInfo k;
    public String l;
    public String m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnErrorListener o;
    public TbCyberVideoView.h p;

    /* loaded from: classes8.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64580e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64580e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64580e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64581e;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64581e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64581e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f64582e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64582e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f64582e.f64559d.f64511b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = this.f64582e;
            urlManager.dealOneLink(fVar.f64558c, new String[]{fVar.f64559d.f64511b}, true);
            d.a.p0.v.d.d.a c2 = d.a.p0.v.d.d.a.c();
            f fVar2 = this.f64582e;
            c2.f("c12909", fVar2.f64559d.f64514e, 2, fVar2.m, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
    }

    @Override // d.a.p0.v.d.f.f.a
    public void b(d.a.p0.v.d.f.c.a aVar) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            if (!ListUtils.isEmpty(this.f64559d.f64512c) && this.f64559d.f64512c.get(0) != null) {
                this.k = this.f64559d.f64512c.get(0).l1();
                this.m = this.f64559d.f64512c.get(0).c0();
            }
            VideoInfo videoInfo = this.k;
            if (videoInfo != null) {
                this.f64579i.M(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.f64559d.f64512c.get(0).b1())) {
                    title = this.f64559d.f64512c.get(0).b1().toString();
                } else {
                    title = this.f64559d.f64512c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.j.setText(title);
                }
                this.l = this.k.video_url;
                d.a.p0.v.d.d.a.c().f("c12908", this.f64559d.f64514e, 2, this.m, null);
            }
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64576f : (View) invokeV.objValue;
    }

    @Override // d.a.p0.v.d.f.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64576f = LayoutInflater.from(this.f64558c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
            this.f64576f.setLayoutParams(new FrameLayout.LayoutParams(this.f64556a, this.f64557b));
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f64576f.findViewById(R.id.video_view);
            this.f64577g = tbCyberVideoView;
            tbCyberVideoView.setOnPreparedListener(this.n);
            this.f64577g.setOnErrorListener(this.o);
            this.f64577g.setOnSurfaceDestroyedListener(this.p);
            this.f64577g.setOnCompletionListener(new d(this));
            this.f64577g.setStageType(null);
            this.f64578h = (ImageView) this.f64576f.findViewById(R.id.video_play_btn);
            TbImageView tbImageView = (TbImageView) this.f64576f.findViewById(R.id.video_cover_img);
            this.f64579i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f64579i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.j = (TextView) this.f64576f.findViewById(R.id.video_title);
            this.f64576f.setOnClickListener(new e(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public boolean f(d.a.p0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 2 != aVar.f64513d || TextUtils.isEmpty(aVar.f64510a)) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.p0.v.d.f.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64576f.getLayoutParams();
            layoutParams.width = this.f64556a;
            layoutParams.height = this.f64557b;
            this.f64576f.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbCyberVideoView = this.f64577g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        this.f64577g.I();
        this.f64577g = null;
    }

    @Override // d.a.p0.v.d.f.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f64577g;
            if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
                this.f64578h.setVisibility(0);
                this.f64577g.pause();
            }
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f64577g;
            if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                this.f64578h.setVisibility(8);
                this.f64577g.start();
            }
        }
    }

    @Override // d.a.p0.v.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbCyberVideoView = this.f64577g) == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f64579i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !o0.b(1, this.l)) {
            return;
        }
        this.f64577g.setVideoPath(this.l);
        this.f64577g.setLooping(true);
    }

    @Override // d.a.p0.v.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbCyberVideoView = this.f64577g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.p0.v.d.d.a.c().f("c12910", this.f64559d.f64514e, 2, this.m, null);
            this.f64579i.setVisibility(8);
            this.f64578h.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f64577g;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(0.0f, 0.0f);
                try {
                    this.f64577g.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
