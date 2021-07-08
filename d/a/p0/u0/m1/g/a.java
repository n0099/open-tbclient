package d.a.p0.u0.m1.g;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.o0.z0.c0;
import d.a.o0.z0.o0;
import d.a.p0.a0.z;
import d.a.p0.n2.f;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends d.a.p0.a0.b<b2> implements z, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> A;
    public RelativeLayout B;
    public LinearLayout C;
    public TextView D;
    public TbImageView E;
    public ImageView F;
    public TbCyberVideoView G;
    public TextView H;
    public View I;
    public d.a.p0.n2.m J;
    public b2 K;
    public View L;
    public TextView M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public String R;
    public d.a.p0.n2.f S;
    public Animation T;
    public d.a.p0.u0.o2.i U;
    public TbImageView V;
    public String W;
    public String X;
    public String Y;
    public View Z;
    public boolean a0;
    public int b0;
    public Handler c0;
    public CyberPlayerManager.OnPreparedListener i0;
    public CyberPlayerManager.OnInfoListener j0;
    public CyberPlayerManager.OnCompletionListener k0;
    public CyberPlayerManager.OnErrorListener l0;
    public ThreadCommentAndPraiseInfoLayout m;
    public VideoLoadingProgressView.c m0;
    public ThreadSourceShareAndPraiseLayout n;
    public String n0;
    public ThreadUserInfoLayout o;
    public TbImageView.f o0;
    public ThreadGodReplyLayout p;
    public ViewTreeObserver.OnGlobalLayoutListener p0;
    public HeadPendantClickableView q;
    public Runnable q0;
    public View r;
    public Runnable r0;
    public TextView s;
    public TbCyberVideoView.h s0;
    public FrameLayout t;
    public View.OnClickListener t0;
    public LinearLayout u;
    public final View.OnClickListener u0;
    public ThreadSkinView v;
    public final View.OnClickListener v0;
    public TextView w;
    public f.b w0;
    public LinearLayout x;
    public Animation.AnimationListener x0;
    public View y;
    public TextView z;

    /* renamed from: d.a.p0.u0.m1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1691a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63179a;

        public C1691a(a aVar) {
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
            this.f63179a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f63179a.E != null) {
                this.f63179a.E.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63180e;

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
            this.f63180e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.f63180e.t) == null || frameLayout.getLayoutParams() == null || this.f63180e.t.getVisibility() == 8) {
                return;
            }
            this.f63180e.t.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.f63180e.t.getLayoutParams();
            if (this.f63180e.t.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (this.f63180e.t.getWidth() * 0.5625d);
            this.f63180e.t.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b2 f63181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f63182f;

        public c(a aVar, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63182f = aVar;
            this.f63181e = b2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f63182f.A != null) {
                    this.f63182f.f53777f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f63182f.f53777f.getContext(), "", this.f63181e.x1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.o0.b1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "2"));
            }
        }

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63183e;

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
            this.f63183e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63183e.G == null || this.f63183e.G.isPlaying()) {
                return;
            }
            this.f63183e.d0(true, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63184e;

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
            this.f63184e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63184e.Z();
                this.f63184e.d0(true, 4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63185e;

        public g(a aVar) {
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
            this.f63185e = aVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63185e.stopPlay();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63186e;

        public h(a aVar) {
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
            this.f63186e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63186e.K == null || StringUtils.isNull(this.f63186e.K.W())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63186e.A.getPageActivity()).createNormalCfg(this.f63186e.K.W(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            if (this.f63186e.v0 != null) {
                this.f63186e.v0.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63187e;

        public i(a aVar) {
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
            this.f63187e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63187e.h() == null) {
                return;
            }
            this.f63187e.h().a(view, this.f63187e.K);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63188e;

        public j(a aVar) {
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
            this.f63188e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63188e.K == null || this.f63188e.h() == null) {
                return;
            }
            this.f63188e.h().a(view, this.f63188e.K);
        }
    }

    /* loaded from: classes8.dex */
    public class k extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63189a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63189a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 202) {
                    this.f63189a.P();
                } else if (i2 != 203) {
                } else {
                    this.f63189a.O();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63190a;

        public l(a aVar) {
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
            this.f63190a = aVar;
        }

        @Override // d.a.p0.n2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63190a.b0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63191a;

        public m(a aVar) {
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
            this.f63191a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.f63191a.P == 3 && this.f63191a.E != null) {
                this.f63191a.E.setVisibility(8);
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

    /* loaded from: classes8.dex */
    public class n implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63192e;

        public n(a aVar) {
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
            this.f63192e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f63192e.G != null) {
                    this.f63192e.G.setVolume(0.0f, 0.0f);
                }
                this.f63192e.i0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63193e;

        public o(a aVar) {
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
            this.f63193e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (i2 == 3) {
                    this.f63193e.d0(false, 3);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class p implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63194e;

        public p(a aVar) {
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
            this.f63194e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63194e.G.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63195e;

        public q(a aVar) {
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
            this.f63195e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f63195e.Z();
                this.f63195e.d0(true, 4);
                this.f63195e.Q = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class r implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63196a;

        public r(a aVar) {
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
            this.f63196a = aVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63196a.i0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63197e;

        public s(a aVar) {
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
            this.f63197e = aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (frameLayout = this.f63197e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f63197e.p0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (frameLayout = this.f63197e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.f63197e.p0);
        }
    }

    /* loaded from: classes8.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63198e;

        public t(a aVar) {
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
            this.f63198e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.f63198e.m) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes8.dex */
    public class u implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63199a;

        public u(a aVar) {
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
            this.f63199a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f63199a.Z == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.f63199a.Z, z ? R.color.CAM_X0201 : R.color.transparent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.N = 3;
        this.O = 0;
        this.P = 1;
        this.Q = false;
        this.c0 = new k(this, Looper.getMainLooper());
        this.i0 = new n(this);
        this.j0 = new o(this);
        this.k0 = new p(this);
        this.l0 = new q(this);
        this.m0 = new r(this);
        this.o0 = new C1691a(this);
        this.p0 = new b(this);
        this.q0 = new e(this);
        this.r0 = new f(this);
        this.s0 = new g(this);
        this.t0 = new h(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new m(this);
        o(bdUniqueId);
        this.l = 3;
        this.A = tbPageContext;
        View k2 = k();
        this.y = k2.findViewById(R.id.divider_line);
        this.B = (RelativeLayout) k2.findViewById(R.id.layout_root);
        this.V = (TbImageView) k2.findViewById(R.id.frs_normal_item_star_view);
        this.C = (LinearLayout) k2.findViewById(R.id.video_card_content_layout);
        this.B.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) this.B.findViewById(R.id.card_home_page_video_user_pendant_header);
        this.q = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.q.getHeadView().setIsRound(true);
            this.q.getHeadView().setDrawBorder(false);
            this.q.getHeadView().setDefaultResource(17170445);
            this.q.getHeadView().setRadius(d.a.c.e.p.l.g(this.A.getPageActivity(), R.dimen.ds70));
        }
        this.q.setHasPendantStyle();
        if (this.q.getPendantView() != null) {
            this.q.getPendantView().setIsRound(true);
            this.q.getPendantView().setDrawBorder(false);
        }
        TextView textView = (TextView) k2.findViewById(R.id.thread_info_bar_name);
        this.s = textView;
        textView.setVisibility(8);
        this.s.setOnClickListener(this.t0);
        d.a.p0.n2.m mVar = new d.a.p0.n2.m((ViewGroup) k2.findViewById(R.id.auto_video_loading_container));
        this.J = mVar;
        mVar.f(this.m0);
        this.D = (TextView) k2.findViewById(R.id.text_title);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k2.findViewById(R.id.text_bottom);
        this.m = threadCommentAndPraiseInfoLayout;
        threadCommentAndPraiseInfoLayout.setForumAfterClickListener(this.v0);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) k2.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.o = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.r = k2.findViewById(R.id.divider_below_reply_number_layout);
        if (this.m.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
        }
        this.m.setOnClickListener(this);
        this.m.setReplyTimeVisible(false);
        this.m.setShowPraiseNum(true);
        this.m.setNeedAddPraiseIcon(true);
        this.m.setNeedAddReplyIcon(true);
        this.m.setIsBarViewVisible(false);
        this.m.setShareVisible(true);
        this.m.setShareReportFrom(1);
        this.m.setStType("frs_page");
        this.m.setFrom(2);
        this.m.R = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k2.findViewById(R.id.text_bottom_threaad);
        this.n = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12605f.setOnClickListener(this);
        this.n.setFrom(2);
        this.n.setShareReportFrom(1);
        this.n.setSourceFromForPb(3);
        this.n.setStType("frs_page");
        this.n.setHideBarName(true);
        FrameLayout frameLayout = (FrameLayout) k2.findViewById(R.id.frame_video);
        this.t = frameLayout;
        frameLayout.setOnClickListener(this);
        this.t.addOnAttachStateChangeListener(new s(this));
        TbImageView tbImageView = (TbImageView) k2.findViewById(R.id.image_video);
        this.E = tbImageView;
        tbImageView.setPageId(i());
        this.E.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setEvent(this.o0);
        this.E.setGifIconSupport(false);
        this.F = (ImageView) k2.findViewById(R.id.image_video_play);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(b());
        this.G = tbCyberVideoView;
        tbCyberVideoView.setStageType("2003");
        c0();
        this.G.setContinuePlayEnable(true);
        this.G.setOnPreparedListener(this.i0);
        this.G.setOnCompletionListener(this.k0);
        this.G.setOnErrorListener(this.l0);
        this.G.setOnInfoListener(this.j0);
        this.G.setOnSurfaceDestroyedListener(this.s0);
        d.a.p0.n2.f fVar = new d.a.p0.n2.f();
        this.S = fVar;
        fVar.l(this.G);
        this.S.i(this.w0);
        this.L = k2.findViewById(R.id.auto_video_black_mask);
        this.H = (TextView) k2.findViewById(R.id.auto_video_error_tips);
        this.I = k2.findViewById(R.id.auto_video_error_background);
        this.u = (LinearLayout) k2.findViewById(R.id.video_card_content_layout);
        this.v = (ThreadSkinView) k2.findViewById(R.id.frs_thread_skin);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.A.getPageActivity(), R.anim.fade_out_video_cover);
        this.T = loadAnimation;
        loadAnimation.setAnimationListener(this.x0);
        this.w = (TextView) k2.findViewById(R.id.text_video_duration);
        this.M = (TextView) k2.findViewById(R.id.text_video_play_count);
        this.x = (LinearLayout) k2.findViewById(R.id.duration_container);
        d.a.p0.u0.o2.i iVar = new d.a.p0.u0.o2.i(tbPageContext, this.B);
        this.U = iVar;
        iVar.d(i());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) k2.findViewById(R.id.card_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        View findViewById = k2.findViewById(R.id.thread_multi_del_mask_view);
        this.Z = findViewById;
        findViewById.setOnClickListener(new t(this));
        this.m.setOnSelectStatusChangeListener(new u(this));
        this.z = (TextView) k2.findViewById(R.id.nani_video_icon);
    }

    public int J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? d.a.p0.o.d.c().b(this.X, i2) : invokeI.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.K == null) {
            return;
        }
        String str = this.b0 == 501 ? "frs_tab" : "frs";
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K);
        arrayList.add(videoItemData);
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f53777f.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
        if (this.K.J() != null) {
            videoPlayActivityConfig.setNid(this.K.J().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (k().getX() + L().getX() + this.u.getX());
            videoCardViewInfo.cardViewY = (int) (k().getY() + L().getY() + this.u.getY());
            videoCardViewInfo.cardViewWidth = L().getWidth();
            videoCardViewInfo.cardViewHeight = L().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.A.getPageActivity(), this.b0 == 501 ? "frs_tab" : "frs", this.K.n1(), d.a.p0.a0.m.g(), "", videoSerializeVideoThreadInfo);
            if (this.K.J() != null) {
                videoMiddlePageActivityConfig.setNid(this.K.J().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (k().getParent() == null) {
                stopPlay();
                return;
            }
            this.c0.removeMessages(203);
            int currentPosition = this.G.getCurrentPosition();
            if (currentPosition != this.O) {
                this.O = currentPosition;
                d0(false, 3);
            } else {
                d0(false, 2);
            }
            this.c0.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c0.removeMessages(202);
            if (this.G.getCurrentPosition() > 0) {
                d0(false, 3);
                this.c0.sendEmptyMessageDelayed(203, 3000L);
                return;
            }
            this.c0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (this.K != null) {
                StatisticItem statisticItem = new StatisticItem("c11100");
                statisticItem.param("tid", this.K.c0());
                statisticItem.param("fid", this.K.Q() + "");
                TiebaStatic.log(statisticItem);
            }
            if (h() != null) {
                h().a(view, this.K);
            }
            if (view == this.t) {
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.L(this.A.getPageActivity(), R.string.no_network_guide);
                } else {
                    N();
                }
            }
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (h() != null) {
                h().a(view, this.K);
            }
            if (!d.a.c.e.p.j.z()) {
                d.a.c.e.p.l.L(this.A.getPageActivity(), R.string.no_network_guide);
            } else {
                M();
            }
        }
    }

    public final void S(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            b2 b2Var = this.K;
            if (b2Var != null) {
                if (b2Var.N1()) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).param("fid", String.valueOf(this.K.Q())).param("obj_type", 2));
                } else {
                    StatisticItem statisticItem = new StatisticItem("c11100");
                    statisticItem.param("tid", this.K.c0());
                    statisticItem.param("fid", this.K.Q() + "");
                    TiebaStatic.log(statisticItem);
                }
                if (this.K.H() != null && this.K.H().getGodUserData() != null && this.K.H().getGodUserData().getType() == 2) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", this.K.c0()));
                }
            }
            if (h() != null) {
                h().a(view, this.K);
            }
            b2 b2Var2 = this.K;
            if (b2Var2 != null) {
                d.a.p0.a0.m.a(b2Var2.c0());
                SkinManager.setViewTextColor(this.D, R.color.CAM_X0109, 1);
                c0.b(this.K.c0());
                String str = null;
                String valueOf = String.valueOf(this.K.Q());
                OriginalForumInfo originalForumInfo = this.K.F1;
                if (originalForumInfo != null) {
                    valueOf = originalForumInfo.id;
                    str = valueOf;
                }
                String str2 = "floor5";
                if (this.K.p0() > 0 && d.a.p0.h3.n0.e.c()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.A.getPageActivity()).createHistoryCfg(this.K.n1(), String.valueOf(this.K.p0()), false, true, "frs_page");
                    if (this.b0 == 501) {
                        str2 = "frs_tab";
                    } else if (!this.K.N1()) {
                        str2 = "frs";
                    }
                    createHistoryCfg.setVideo_source(str2);
                    createHistoryCfg.setFromSmartFrs(this.K.k2());
                    createHistoryCfg.setSmartFrsPosition(this.K.a1());
                    createHistoryCfg.setForumId(valueOf);
                    createHistoryCfg.setFromForumId(str);
                    createHistoryCfg.setStartFrom(this.l);
                    if (view == this.p) {
                        createHistoryCfg.setJumpGodReply(true);
                    }
                    this.A.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.A.getPageActivity()).createFromThreadCfg(this.K, this.n0, "frs_page", 18003, true, false, false);
                if (this.b0 == 501) {
                    str2 = "frs_tab";
                } else if (!this.K.N1()) {
                    str2 = "frs";
                }
                createFromThreadCfg.setVideo_source(str2);
                createFromThreadCfg.setFromSmartFrs(this.K.k2());
                createFromThreadCfg.setSmartFrsPosition(this.K.a1());
                createFromThreadCfg.setForumId(valueOf);
                createFromThreadCfg.setFromForumId(str);
                createFromThreadCfg.setStartFrom(this.l);
                if (view == this.p) {
                    createFromThreadCfg.setJumpGodReply(true);
                }
                this.A.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            }
        }
    }

    public final void T() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a0();
            Z();
            if (this.E == null || this.t == null || this.G == null) {
                return;
            }
            if (d.a.o0.r.k.c().g() && (b2Var = this.K) != null && b2Var.l1() != null) {
                this.t.setVisibility(0);
                this.E.setPlaceHolder(3);
                this.E.M(this.K.l1().thumbnail_url, 10, false);
                stopPlay();
                String str = this.K.l1().video_url;
                this.R = str;
                if (StringUtils.isNull(str)) {
                    d0(true, 4);
                    TiebaStatic.log(new StatisticItem("c12026").param("tid", this.K.c0()));
                }
                this.G.setThreadDataForStatistic(this.K);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: W */
    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b2Var) == null) {
            this.K = b2Var;
            X();
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b2 b2Var = this.K;
            if (b2Var != null && b2Var.H() != null) {
                this.B.setVisibility(0);
                this.B.setOnClickListener(this);
                T();
                if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.Y)) {
                    this.K.a4(this.W, this.Y);
                }
                boolean z = true;
                this.K.J2(false, true);
                SpannableStringBuilder b1 = this.K.b1();
                if (this.K.d() && !StringUtils.isNull(this.K.n1())) {
                    String str = d.a.o0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.n1();
                    b1.append((CharSequence) this.K.e(new d(this, 2, str, str)));
                }
                this.D.setOnTouchListener(new d.a.p0.z3.i(b1));
                this.D.setText(b1);
                this.U.a(this.K);
                h0(this.K);
                this.o.j(this.K);
                if (this.o.getHeaderImg() != null) {
                    if (this.o.getIsSimpleThread()) {
                        this.o.getHeaderImg().setVisibility(8);
                        this.q.setVisibility(8);
                    } else if (this.K.H() != null && this.K.H().getPendantData() != null && !StringUtils.isNull(this.K.H().getPendantData().a())) {
                        this.o.getHeaderImg().setVisibility(4);
                        this.q.setVisibility(0);
                        this.q.setData(this.K);
                    } else {
                        this.q.setVisibility(8);
                        this.o.getHeaderImg().setVisibility(0);
                        this.o.getHeaderImg().setData(this.K);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.m.setLayoutParams(layoutParams);
                this.o.setUserAfterClickListener(this.u0);
                g0(J(1));
                this.w.setText(StringHelper.stringForVideoTime(this.K.l1().video_duration.intValue() * 1000));
                this.M.setText(String.format(this.A.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.l1().play_count.intValue())));
                this.p.setData(this.K.p1());
                this.p.k();
                if (d.a.p0.a0.m.k(this.K.c0())) {
                    SkinManager.setViewTextColor(this.D, R.color.CAM_X0109, 1);
                    d.a.p0.a0.m.l(this.p.getGodReplyContent(), this.K.c0(), R.color.CAM_X0106, R.color.CAM_X0109);
                } else {
                    SkinManager.setViewTextColor(this.D, R.color.CAM_X0105, 1);
                }
                b2 b2Var2 = this.K;
                if ((b2Var2 == null || b2Var2.l1() == null || this.K.l1().is_vertical.intValue() != 1) ? false : false) {
                    this.z.setVisibility(0);
                } else {
                    this.z.setVisibility(8);
                }
                if ((d.a.p0.u0.b.e().g() || d.a.p0.u0.a.h().j()) && this.m.isInFrsAllThread()) {
                    this.Z.setVisibility(0);
                    if (!this.K.Z1() && !this.K.a2() && !this.K.o2()) {
                        this.Z.setBackgroundResource(R.color.transparent);
                    } else {
                        SkinManager.setBackgroundColor(this.Z, R.color.CAM_X0201);
                    }
                } else {
                    this.Z.setVisibility(8);
                }
                m(this.A, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.B.setVisibility(8);
        }
    }

    public void Y(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || bdUniqueId == null || this.m == null || (threadUserInfoLayout = this.o) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c0.removeMessages(202);
            this.c0.removeMessages(203);
        }
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.n0 = str;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.q0);
            d.a.c.e.m.e.a().removeCallbacks(this.r0);
        }
    }

    public final void b0() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (b2Var = this.K) == null || b2Var.l1() == null) {
            return;
        }
        String str = this.K.N1() ? "floor5" : "frs";
        if (this.b0 == 501) {
            str = "frs_tab";
        }
        d.a.p0.n2.o oVar = new d.a.p0.n2.o();
        oVar.f60809a = str;
        oVar.f60811c = this.K.n1();
        oVar.f60812d = this.K.Q() + "";
        oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
        b2 b2Var2 = this.K;
        oVar.f60814f = b2Var2.T0;
        String str2 = b2Var2.V0;
        oVar.l = str2;
        oVar.f60815g = str2;
        oVar.f60816h = b2Var2.U0;
        oVar.f60817i = "";
        oVar.m = b2Var2.l1().video_md5;
        d.a.p0.n2.h.e(this.K.l1().video_md5, "", "1", oVar, this.G.getPcdnState());
    }

    public final void c0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (tbCyberVideoView = this.G) != null && tbCyberVideoView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.t.addView(this.G.getView(), 0);
            this.G.getView().setLayoutParams(layoutParams);
        }
    }

    public final void d0(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.F == null || this.E == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.P != i2) {
            this.P = i2;
            d.a.c.e.m.e.a().removeCallbacks(this.r0);
            d.a.c.e.m.e.a().removeCallbacks(this.q0);
            if (i2 == 2) {
                this.F.setVisibility(8);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.x.setVisibility(0);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(this.r0, 60000L);
            } else if (i2 == 3) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.x.setVisibility(8);
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                b2 b2Var = this.K;
                if (b2Var == null || b2Var.l1() == null) {
                    return;
                }
                this.K.l1().video_length.intValue();
                this.K.l1().video_duration.intValue();
                this.K.n1();
            } else if (i2 == 4) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                d.a.c.e.m.e.a().postDelayed(this.q0, 2000L);
            } else {
                this.F.setVisibility(0);
                this.x.setVisibility(0);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
        }
    }

    public void f0(d.a.p0.n2.o oVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, oVar) == null) || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.setVideoStatData(oVar);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? R.layout.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public void g0(int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (b2Var = this.K) == null) {
            return;
        }
        if (i2 == 1) {
            this.m.setVisibility(8);
            this.n.g(this.K);
            this.r.setVisibility(8);
            return;
        }
        this.m.setData(b2Var);
        this.r.setVisibility(8);
        this.n.setVisibility(8);
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void h0(b2 b2Var) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, b2Var) == null) || (tbImageView = this.V) == null) {
            return;
        }
        if (b2Var == null) {
            tbImageView.setVisibility(8);
        } else if (!StringUtils.isNull(b2Var.w1)) {
            d.a.p0.u0.o2.i iVar = this.U;
            if (iVar != null && iVar.b() && (this.V.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
                layoutParams.rightMargin = d.a.c.e.p.l.g(this.A.getContext(), R.dimen.tbds106);
                this.V.setLayoutParams(layoutParams);
            }
            this.V.setVisibility(0);
            this.V.setImageDrawable(null);
            this.V.M(b2Var.w1, 10, false);
            this.V.setOnClickListener(new c(this, b2Var));
        } else {
            this.V.setVisibility(8);
        }
    }

    public final void i0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (tbCyberVideoView = this.G) != null && this.Q) {
            try {
                tbCyberVideoView.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, tbPageContext, i2) == null) || this.N == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.B, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.F, R.drawable.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.M, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.I, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        if (this.H != null) {
            this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.n;
        if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
            this.n.f();
        }
        this.m.onChangeSkinType();
        this.N = i2;
        this.o.h();
        HeadPendantClickableView headPendantClickableView = this.q;
        if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.q.getHeadView() instanceof TbImageView)) {
            this.q.getHeadView().setPlaceHolder(1);
        }
        this.E.setPlaceHolder(3);
        this.U.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            if (view != this.B && view != this.m.getCommentNumView() && view != this.C) {
                if (view == this.t) {
                    b2 b2Var = this.K;
                    boolean z = false;
                    if (b2Var != null && b2Var.l1() != null && this.K.l1().is_vertical.intValue() == 1) {
                        z = true;
                    }
                    if (z) {
                        R(view);
                    } else if (UtilHelper.isGotoVideoMiddlePage()) {
                        Q(this.t);
                    } else {
                        S(this.t);
                    }
                } else {
                    ThreadGodReplyLayout threadGodReplyLayout = this.p;
                    if (view == threadGodReplyLayout) {
                        S(threadGodReplyLayout);
                    }
                }
            } else {
                S(this.B);
            }
            b2 b2Var2 = this.K;
            if (b2Var2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, b2Var2));
            }
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.l = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.m;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.R = i2;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.o;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.X = str;
        }
    }

    public void startPlay() {
        b2 b2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.Q || (b2Var = this.K) == null || b2Var.l1() == null || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        if (o0.d()) {
            if (this.a0 || d.a.o0.r.d0.b.j().k("auto_play_video_frs", 0) == 1) {
                d0(true, 2);
                if (StringUtils.isNull(this.R)) {
                    TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "frs").param("tid", this.K.c0()));
                    this.R = this.K.l1().video_url;
                }
                this.Q = true;
                this.G.setVideoPath(this.R, this.K.c0());
                d.a.p0.n2.f fVar = this.S;
                if (fVar != null) {
                    fVar.m();
                }
                b0();
            }
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            a0();
            Z();
            d0(true, 1);
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                d.a.p0.n2.f fVar = this.S;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.Q = false;
        }
    }
}
