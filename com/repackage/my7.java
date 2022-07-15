package com.repackage;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a68;
import com.repackage.f68;
import com.repackage.gf;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class my7 {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c T;
    public static a68.z U;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoWifiTipLayout A;
    public int B;
    public long C;
    public a68.g0 D;
    public a68.u E;
    public boolean F;
    public Handler G;
    public PbFullScreenFloatingHuajiAninationView H;
    public PbFullScreenFloatingHuajiAninationView.c I;
    public ff J;
    public Bitmap K;
    public boolean L;
    public boolean M;
    public boolean N;
    public a68.d0 O;
    public CustomMessageListener P;
    public int Q;
    public Animation.AnimationListener R;
    public CustomMessageListener S;
    public RelativeLayout a;
    public kx7 b;
    public CustomFrameLayout c;
    public PbFragment d;
    public a68.u e;
    public String f;
    public VideoInfo g;
    public a68 h;
    public s68 i;
    public ky7 j;
    public boolean k;
    public ThreadData l;
    public ThreadData m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public float r;
    public boolean s;
    public boolean t;
    public int u;
    public double v;
    public View w;
    public float x;
    public boolean y;
    public rc0 z;

    /* loaded from: classes6.dex */
    public class a implements f68.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ThreadData c;
        public final /* synthetic */ my7 d;

        public a(my7 my7Var, VideoInfo videoInfo, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var, videoInfo, str, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = my7Var;
            this.a = videoInfo;
            this.b = str;
            this.c = threadData;
        }

        @Override // com.repackage.f68.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.d.C <= 0) {
                    this.d.C = i2;
                }
                McnAdInfo mcnAdInfo = this.a.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a = qc0.b().a(mcnAdInfo.jump_url);
                if (!this.d.y || a || this.d.o) {
                    return;
                }
                boolean z = true;
                boolean z2 = this.d.C >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
                long j = i2;
                if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                    if (this.d.z.c()) {
                        return;
                    }
                    pc0 pc0Var = new pc0();
                    pc0Var.b = mcnAdInfo.card_title;
                    pc0Var.c = mcnAdInfo.button_title;
                    pc0Var.d = mcnAdInfo.jump_url;
                    pc0Var.a = mcnAdInfo.pic_url;
                    pc0Var.f = this.b;
                    pc0Var.e = this.c.getTid();
                    pc0Var.g = 4;
                    if (z2) {
                        this.d.z.f(pc0Var, (ViewGroup) this.d.h.E0());
                    } else {
                        this.d.z.e(pc0Var, (ViewGroup) this.d.h.E0());
                    }
                } else if (this.d.z.c()) {
                    this.d.z.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a68.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a.B > 0) {
                        my7 my7Var = this.a.a;
                        my7Var.M(my7Var.B);
                        my7 my7Var2 = this.a.a;
                        my7Var2.j0(my7Var2.B);
                        this.a.a.B = 0;
                    }
                    this.a.a.F = true;
                }
            }
        }

        public b(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.a.F = false;
                my7 my7Var = this.a;
                my7Var.B = my7Var.P().getHeight();
            }
        }

        @Override // com.repackage.a68.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.a.G.postDelayed(new a(this), 200L);
                this.a.C = -1L;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a68.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public c(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.y
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null || this.a.m == null || StringUtils.isNull(this.a.m.getId())) {
                return;
            }
            this.a.d.r6(this.a.m.getId());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a68.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public d(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.l == null) {
                return;
            }
            this.a.l0(z ? "1" : "2");
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public e(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.a.f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ef {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public f(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.ef
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.a.d.getActivity());
                if (this.a.K == null) {
                    try {
                        this.a.K = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080e5a);
                        imageView.setImageBitmap(this.a.K);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.ef
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements gf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public g(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.gf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J = null;
                if (this.a.K != null && !this.a.K.isRecycled()) {
                    this.a.K.recycle();
                }
                this.a.K = null;
            }
        }

        @Override // com.repackage.gf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements a68.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.a68.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public j(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                my7 my7Var = this.a;
                my7Var.j0(my7Var.P().getHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements a68.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public k(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null || this.a.d.F() == null || this.a.d.F().R1() == null) {
                return;
            }
            PostData j = this.a.d.F().R1().j();
            if (j == null && ListUtils.getCount(this.a.d.F().R1().F()) > 1) {
                j = (PostData) ListUtils.getItem(this.a.d.F().R1().F(), 0);
            }
            fy7.b(this.a.d.F().R1(), j, 1, 1, 4);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public l(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(my7 my7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g == null) {
                return;
            }
            my7 my7Var = this.a;
            my7Var.b0(my7Var.g);
            this.a.h.q0();
            if (this.a.w == null || this.a.w.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.w.getLayoutParams();
            layoutParams.height = this.a.u;
            this.a.w.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public n(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements a68.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public o(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.d0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.a68.d0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v >= 1.0d) {
                    if (!this.a.d.checkUpIsLogin()) {
                        return true;
                    }
                    this.a.d.a6();
                    if (this.a.d.F() != null && this.a.d.F().R1() != null && this.a.d.F().R1().S() != null) {
                        xr7 S = this.a.d.F().R1().S();
                        if (this.a.H == null) {
                            this.a.H = new PbFullScreenFloatingHuajiAninationView(this.a.d.getActivity());
                            this.a.H.setFloatingHuajiAninationListener(this.a.I);
                        }
                        this.a.H.f(!S.d());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(my7 my7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && ni.z()) {
                if (this.a.h != null) {
                    this.a.h.m1();
                }
                if (!ni.x() || this.a.h == null || !this.a.h.R0() || this.a.g == null || this.a.g.video_length.intValue() <= 0 || this.a.g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                double intValue = ((this.a.g.video_length.intValue() * (1.0f - ((this.a.h.B0() * 1.0f) / (this.a.g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    pi.O(this.a.d.getPageContext().getPageActivity(), String.format(this.a.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de3), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements a68.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public q(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, seekBar) == null) {
                this.a.C = -1L;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements a68.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public r(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // com.repackage.a68.b0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.a68.b0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // com.repackage.a68.b0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                                this.a.d.getListView().setSelectionFromTop(0, this.a.Q + ((int) (motionEvent.getY() - this.a.x)));
                            }
                        }
                    }
                    this.a.x = 0.0f;
                    this.a.Q = 0;
                } else {
                    this.a.x = motionEvent.getY();
                    if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                        my7 my7Var = this.a;
                        my7Var.Q = my7Var.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public s(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L = true;
                this.a.A.setVisibility(8);
                this.a.v0();
                TiebaStatic.log("c12618");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements a68.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ my7 b;

        public t(my7 my7Var, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = my7Var;
            this.a = animation;
        }

        @Override // com.repackage.a68.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.b.a0() && this.b.b != null) {
                this.a.setAnimationListener(null);
                this.b.b.p().clearAnimation();
                this.b.t0();
                if (z) {
                    this.a.setAnimationListener(this.b.R);
                    this.b.b.p().startAnimation(this.a);
                }
            }
        }

        @Override // com.repackage.a68.u
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.a0()) {
                this.b.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my7 a;

        public u(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = my7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.S();
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755482874, "Lcom/repackage/my7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755482874, "Lcom/repackage/my7;");
                return;
            }
        }
        T = new h();
        U = new i();
    }

    public my7(PbFragment pbFragment, kx7 kx7Var, VideoInfo videoInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, kx7Var, videoInfo, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
        this.g = null;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.r = 0.0f;
        this.s = false;
        this.t = false;
        this.C = -1L;
        this.D = new k(this);
        this.F = true;
        this.I = new n(this);
        this.M = false;
        this.O = new o(this);
        this.P = new p(this, 2000994);
        this.R = new u(this);
        this.S = new m(this, 2921414);
        this.d = pbFragment;
        this.b = kx7Var;
        this.r = pi.f(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070285);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.P);
        this.S.setTag(pbFragment.getUniqueId());
        this.S.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.S);
        this.z = new rc0(pbFragment.getActivity());
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.N = false;
            if (this.u != P().getHeight()) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(pi.k(this.d.getActivity()), Math.min(this.u, P().getHeight() + i2)));
                this.h.q0();
            }
        } else if (pi.k(this.d.getActivity()) * 0.5625d != P().getHeight()) {
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(pi.k(this.d.getActivity()), (int) Math.max(pi.k(this.d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (pbFragment = this.d) == null) {
            return;
        }
        pbFragment.n5();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a68 a68Var = this.h;
            if (a68Var != null) {
                a68Var.v0();
            }
            CustomFrameLayout customFrameLayout = this.c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            ky7 ky7Var = this.j;
            if (ky7Var != null) {
                ky7Var.k();
            }
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : invokeV.intValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public void S() {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kx7Var = this.b) == null) {
            return;
        }
        kx7Var.r();
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.d.getActivity(), R.anim.obfuscated_res_0x7f010035);
            if (this.e == null) {
                this.e = new t(this, loadAnimation);
            }
            o0(this.e);
            UtilHelper.getLightStatusBarHeight();
            pi.f(this.d.getActivity(), R.dimen.obfuscated_res_0x7f070282);
            this.G = new Handler();
        }
    }

    public void U(VideoInfo videoInfo, ThreadData threadData, String str) {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, threadData, str) == null) || videoInfo == null || (a68Var = this.h) == null || threadData == null) {
            return;
        }
        this.g = videoInfo;
        this.l = threadData;
        this.f = videoInfo.video_url;
        a68Var.T1();
        s68 s68Var = new s68();
        this.i = s68Var;
        s68Var.a = "pb";
        s68Var.c = threadData.getTid();
        s68 s68Var2 = this.i;
        s68Var2.d = str;
        s68Var2.e = TbadkCoreApplication.getCurrentAccount();
        if (threadData.isBjh()) {
            if (!StringUtils.isNull(this.d.u1)) {
                this.i.k = this.d.u1;
            }
            s68 s68Var3 = this.i;
            s68Var3.i = this.d.t1 + "";
        } else {
            this.i.i = this.d.T5();
        }
        zp4 P5 = this.d.P5();
        if (P5 != null) {
            P5.d(this.i);
        }
        s68 s68Var4 = this.i;
        s68Var4.m = videoInfo.video_md5;
        s68 b2 = s68Var4.b();
        b2.a = "6";
        this.C = -1L;
        if (this.h.H0() != null && this.h.H0().getMediaProgressObserver() != null) {
            this.h.H0().getMediaProgressObserver().j(new a(this, videoInfo, str, threadData));
        }
        this.h.H0().setVideoStatData(b2);
        if (this.h.G0()) {
            this.h.q0();
        }
        this.h.o1(this.E);
        this.m = null;
        this.h.J0().setOnDragingListener(T);
        this.h.n1(new b(this));
        this.h.q1(new c(this));
        this.h.s1(new d(this));
        this.h.w1(new e(this));
        this.h.D1(videoInfo.thumbnail_url);
        this.h.H1(this.f, threadData.getTid());
        this.h.h1(str);
        this.h.G1(threadData.getTitle());
        this.h.r1(U);
        this.h.X0();
        this.h.J1();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0886, (ViewGroup) null);
            this.a = relativeLayout;
            this.c = (CustomFrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0917ac);
            int b0 = b0(videoInfo);
            int i2 = 0;
            this.y = ((double) this.u) <= (((double) pi.k(this.d.getActivity())) * 0.5625d) + 5.0d;
            int intValue = videoInfo.video_width.intValue();
            a68 a68Var = new a68(this.d.getPageContext(), this.c, true);
            this.h = a68Var;
            a68Var.z1("2002");
            this.h.I1(this.O);
            this.h.k1(false);
            this.h.E1(this.D);
            this.h.F1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.h.y1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                this.h.i1(false);
            }
            this.h.t1(new r(this));
            if (intValue > 0) {
                if (this.v >= 1.0d) {
                    this.h.x1(false, true);
                } else {
                    this.h.x1(true, false);
                }
                boolean z = ((float) b0) + this.r > ((float) pi.i(this.d.getActivity()));
                this.s = z;
                if (z) {
                    if (this.j == null) {
                        this.j = new ky7(this.d.getPageContext(), this.c);
                    }
                    this.d.O5().o1();
                    this.k = true;
                }
            }
            u0();
            this.w = new View(this.d.getContext());
            this.w.setLayoutParams(new AbsListView.LayoutParams(-1, this.u));
            kx7 kx7Var = this.b;
            if (kx7Var != null && (navigationBar = kx7Var.a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.b.a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.b.a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09125b);
            this.A = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            rc0 rc0Var = this.z;
            if (rc0Var != null) {
                rc0Var.d();
            }
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (P() == null) {
                return false;
            }
            return P().getBottom() > pi.i(P().getContext()) - pi.f(P().getContext(), R.dimen.obfuscated_res_0x7f0702d4);
        }
        return invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.j == null) {
            return;
        }
        if (W()) {
            this.d.O5().o1();
        } else if (this.j.f().getVisibility() == 0) {
            this.d.O5().o1();
            this.k = true;
        } else if (this.k) {
            this.d.O5().D3(false);
            this.k = false;
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.v >= 1.0d : invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? P().getY() >= 0.0f : invokeV.booleanValue;
    }

    public final int b0(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, videoInfo)) == null) {
            if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return pi.k(this.d.getActivity());
            }
            int k2 = pi.k(this.d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.d.getPageContext().getPageActivity());
            int i2 = visibilityRegion.height() <= 0 ? pi.i(this.d.getActivity()) : visibilityRegion.height();
            int i3 = (int) (k2 * 0.5625d);
            int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
            int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
            if (intValue > 0) {
                double d2 = (intValue2 * 1.0d) / intValue;
                this.v = d2;
                if (d2 > 0.5625d) {
                    i3 = Math.min((intValue2 * k2) / intValue, i2);
                }
            }
            this.u = i3;
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            kx7 kx7Var = this.b;
            if (kx7Var != null) {
                kx7Var.v(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.e(i2);
            }
            ky7 ky7Var = this.j;
            if (ky7Var != null) {
                ky7Var.j(i2);
            }
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            this.o = false;
            if (this.h == null || (customFrameLayout = this.c) == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            if (configuration.orientation == 2) {
                rc0 rc0Var = this.z;
                if (rc0Var != null && rc0Var.c()) {
                    this.z.b();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                ff ffVar = this.J;
                if (ffVar != null) {
                    ffVar.d();
                }
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.o = true;
                this.c.setLayoutParams(layoutParams);
                this.d.O5().o1();
                this.k = true;
            } else {
                b0(this.g);
                t0();
                this.o = false;
                this.b.B(true);
            }
            this.h.S0(this.d.getPageContext(), configuration);
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            a68 a68Var = this.h;
            if (a68Var == null) {
                return false;
            }
            return a68Var.b1(i2);
        }
        return invokeI.booleanValue;
    }

    public void f0() {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (a68Var = this.h) == null) {
            return;
        }
        if (a68Var.R0()) {
            this.n = true;
            this.h.T1();
        } else if (this.h.C0() == 3) {
            this.n = false;
        } else if (this.h.C0() != 0 && this.h.C0() != 1) {
            this.n = false;
            this.h.T1();
        } else {
            this.n = true;
            this.h.T1();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public void g0() {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (a68Var = this.h) != null && this.n) {
            a68Var.e1();
        }
    }

    public void h0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, absListView, i2) == null) {
            if (absListView != null && absListView.getChildAt(0) != null) {
                View childAt = absListView.getChildAt(0);
                if (childAt == R()) {
                    int bottom = childAt.getBottom() - P().getBottom();
                    M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
                } else {
                    M((-this.u) + 2);
                }
            }
            if (!W() && this.F) {
                int i3 = this.p;
                if (i3 == 1) {
                    this.M = true;
                    j0(P().getHeight());
                } else if (i3 != 2) {
                    if (i3 == 0) {
                        if (this.M || !"nani_midpage".equals(this.d.T5())) {
                            j0(P().getHeight());
                        }
                    }
                } else {
                    this.M = true;
                    int y = (int) P().getY();
                    if (this.q == y) {
                        j0(P().getHeight());
                    } else {
                        this.q = y;
                        j0(P().getHeight());
                    }
                    if (i2 == 0 && this.t) {
                        this.t = false;
                        this.G.postDelayed(new l(this), 100L);
                    }
                }
            }
        }
    }

    public void i0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048598, this, absListView, i2) == null) || W()) {
            return;
        }
        this.p = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(this), 100L);
        }
        Y();
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            n0(i2);
            Y();
        }
    }

    public void k0(PostData postData, ThreadData threadData, xr7 xr7Var) {
        ky7 ky7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048600, this, postData, threadData, xr7Var) == null) || (ky7Var = this.j) == null) {
            return;
        }
        ky7Var.m(postData, threadData, xr7Var);
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.g == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            h68.e(this.g.video_md5, "", str, this.i, this.h.H0().getPcdnState());
        }
    }

    public void m0() {
        a68 a68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (a68Var = this.h) == null) {
            return;
        }
        a68Var.c1();
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.j == null) {
            return;
        }
        ThreadData threadData = this.l;
        if (threadData != null && threadData.isUgcThreadType()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.u;
        }
        float f2 = this.u - i2;
        float f3 = this.r;
        float f4 = f2 > f3 ? 0.0f : 1.0f - (f2 / f3);
        if (this.N) {
            f4 = 0.0f;
        }
        if (f4 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f4);
    }

    public void o0(a68.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, uVar) == null) {
            this.E = uVar;
        }
    }

    public void p0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) {
            this.m = threadData;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        ky7 ky7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) || (ky7Var = this.j) == null) {
            return;
        }
        ky7Var.o(onClickListener);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.t = true;
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.b == null) {
            return;
        }
        this.b.D(this.d.v0());
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || xt4.k().h("show_video_pb_double_tap_tips", false)) {
            return;
        }
        xt4.k().u("show_video_pb_double_tap_tips", true);
        gf gfVar = new gf();
        gfVar.d(true);
        gfVar.h(false);
        gfVar.k(16908290);
        gfVar.c(153);
        gfVar.i(false);
        gfVar.a(new f(this));
        gfVar.g(new g(this));
        ff b2 = gfVar.b();
        this.J = b2;
        b2.p(this.d.getActivity());
    }

    public void v0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.h == null) {
            return;
        }
        if (ni.x() && !this.L && !dq8.c().d()) {
            this.A.setVisibility(0);
            this.A.setData(this.g);
            TiebaStatic.log("c12622");
            return;
        }
        if (StringUtils.isNull(this.f) && (threadData = this.l) != null && threadData.getThreadVideoInfo() != null) {
            TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.getTid()));
            this.f = this.l.getThreadVideoInfo().video_url;
        }
        a68 a68Var = this.h;
        String str = this.f;
        ThreadData threadData2 = this.l;
        a68Var.M1(str, threadData2 == null ? "" : threadData2.getTid());
        l0("2");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    public void w0(String str) {
        s68 s68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || (s68Var = this.i) == null) {
            return;
        }
        s68Var.d = str;
    }
}
