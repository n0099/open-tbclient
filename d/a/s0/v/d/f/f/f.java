package d.a.s0.v.d.f.f;

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
import d.a.r0.z0.o0;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class f extends d.a.s0.v.d.f.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f67794f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f67795g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f67796h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f67797i;
    public TextView j;
    public VideoInfo k;
    public String l;
    public String m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnErrorListener o;
    public TbCyberVideoView.g p;

    /* loaded from: classes9.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67798e;

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
            this.f67798e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67798e.q();
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class c implements TbCyberVideoView.g {
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

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67799e;

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
            this.f67799e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67799e.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67800e;

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
            this.f67800e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f67800e.f67777d.f67729b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = this.f67800e;
            urlManager.dealOneLink(fVar.f67776c, new String[]{fVar.f67777d.f67729b}, true);
            d.a.s0.v.d.d.a c2 = d.a.s0.v.d.d.a.c();
            f fVar2 = this.f67800e;
            c2.f("c12909", fVar2.f67777d.f67732e, 2, fVar2.m, null);
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

    @Override // d.a.s0.v.d.f.f.a
    public void b(d.a.s0.v.d.f.c.a aVar) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            if (!ListUtils.isEmpty(this.f67777d.f67730c) && this.f67777d.f67730c.get(0) != null) {
                this.k = this.f67777d.f67730c.get(0).l1();
                this.m = this.f67777d.f67730c.get(0).c0();
            }
            VideoInfo videoInfo = this.k;
            if (videoInfo != null) {
                this.f67797i.M(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.f67777d.f67730c.get(0).b1())) {
                    title = this.f67777d.f67730c.get(0).b1().toString();
                } else {
                    title = this.f67777d.f67730c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.j.setText(title);
                }
                this.l = this.k.video_url;
                d.a.s0.v.d.d.a.c().f("c12908", this.f67777d.f67732e, 2, this.m, null);
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67794f : (View) invokeV.objValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67794f = LayoutInflater.from(this.f67776c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
            this.f67794f.setLayoutParams(new FrameLayout.LayoutParams(this.f67774a, this.f67775b));
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f67794f.findViewById(R.id.video_view);
            this.f67795g = tbCyberVideoView;
            tbCyberVideoView.setOnPreparedListener(this.n);
            this.f67795g.setOnErrorListener(this.o);
            this.f67795g.setOnSurfaceDestroyedListener(this.p);
            this.f67795g.setOnCompletionListener(new d(this));
            this.f67795g.setStageType(null);
            this.f67796h = (ImageView) this.f67794f.findViewById(R.id.video_play_btn);
            TbImageView tbImageView = (TbImageView) this.f67794f.findViewById(R.id.video_cover_img);
            this.f67797i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f67797i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.j = (TextView) this.f67794f.findViewById(R.id.video_title);
            this.f67794f.setOnClickListener(new e(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public boolean f(d.a.s0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 2 != aVar.f67731d || TextUtils.isEmpty(aVar.f67728a)) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f67794f.getLayoutParams();
            layoutParams.width = this.f67774a;
            layoutParams.height = this.f67775b;
            this.f67794f.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbCyberVideoView = this.f67795g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        this.f67795g.G();
        this.f67795g = null;
    }

    @Override // d.a.s0.v.d.f.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f67795g;
            if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
                this.f67796h.setVisibility(0);
                this.f67795g.pause();
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f67795g;
            if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                this.f67796h.setVisibility(8);
                this.f67795g.start();
            }
        }
    }

    @Override // d.a.s0.v.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbCyberVideoView = this.f67795g) == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f67797i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !o0.b(1, this.l)) {
            return;
        }
        this.f67795g.setVideoPath(this.l);
        this.f67795g.setLooping(true);
    }

    @Override // d.a.s0.v.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbCyberVideoView = this.f67795g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.s0.v.d.d.a.c().f("c12910", this.f67777d.f67732e, 2, this.m, null);
            this.f67797i.setVisibility(8);
            this.f67796h.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f67795g;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(0.0f, 0.0f);
                try {
                    this.f67795g.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
