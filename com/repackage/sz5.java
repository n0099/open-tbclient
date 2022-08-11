package com.repackage;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadViewAndCommentInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rz5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class sz5 extends bz5<CardPersonDynamicThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TbImageView B;
    public ImageView C;
    public LinearLayout D;
    public TextView E;
    public LinearLayout F;
    public LinearLayout G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TBLottieAnimationView K;
    public TextView L;
    public TextView M;
    public OriginalThreadCardView N;
    public View O;
    public View P;
    public ThreadCardBottomOpSegmentLayout Q;
    public boolean R;
    public boolean S;
    public EMTextView T;
    public View.OnClickListener U;
    public rz5.j V;
    public final View.OnClickListener W;
    public final View.OnClickListener X;
    public TbImageView.g Y;
    public PlayVoiceBntNew i;
    public ThreadViewAndCommentInfoLayout j;
    public View k;
    public int l;
    public CardPersonDynamicThreadData m;
    public TbPageContext<?> n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public rz5 v;
    public TextView w;
    public TextView x;
    public ConstrainImageGroup y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public a(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.B != null) {
                this.a.B.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public b(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.m);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardPersonDynamicThreadData a;
        public final /* synthetic */ sz5 b;

        public c(sz5 sz5Var, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var, cardPersonDynamicThreadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz5Var;
            this.a = cardPersonDynamicThreadData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.n == null) {
                return;
            }
            if (this.b.v == null) {
                sz5 sz5Var = this.b;
                sz5Var.v = new rz5(sz5Var.n);
                this.b.v.o();
                this.b.v.s(this.b.V);
            }
            this.b.v.n(this.b.m, this.a.H == 1);
            this.b.v.u();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ sz5 c;

        public d(sz5 sz5Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz5Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.repackage.bh5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.c.L();
                } else {
                    this.c.U(view2, this.a, i, this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends pw8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 b;

        public e(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz5Var;
        }

        @Override // com.repackage.pw8
        public void a(TextPaint textPaint, boolean z) {
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, textPaint, z) == null) {
                if (z) {
                    color = this.b.c.getResources().getColor(R.color.CAM_X0304);
                } else {
                    color = this.b.c.getResources().getColor(R.color.CAM_X0302);
                }
                textPaint.setColor(color);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || this.b.m == null || StringUtils.isNull(this.b.m.h)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.c).createNormalCfg(this.b.m.h, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public f(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e() != null) {
                    this.a.e().a(view2, this.a.m);
                }
                if (this.a.m.k != 60) {
                    if ((this.a.m.k != 40 || this.a.m.n != 2) && !this.a.S) {
                        if (this.a.m.k != 40) {
                            if (!this.a.m.p.isShareThread || this.a.m.p.originalThreadData.k != 40) {
                                this.a.L();
                                return;
                            }
                            sz5 sz5Var = this.a;
                            sz5Var.M(sz5Var.m.p.originalThreadData.f);
                            return;
                        }
                        sz5 sz5Var2 = this.a;
                        sz5Var2.M(sz5Var2.m.b);
                        return;
                    }
                    BdToast b = BdToast.b(this.a.getContext(), this.a.getContext().getString(R.string.obfuscated_res_0x7f0f150a));
                    b.f(BdToast.ToastIcon.FAILURE);
                    b.h();
                    return;
                }
                TiebaStatic.log(TbadkCoreStatisticKey.MY_THREAD_SHARE_LIVE);
                if (this.a.m.p.getThreadAlaInfo().live_status != 1) {
                    this.a.N();
                } else {
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(sz5 sz5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var, Integer.valueOf(i)};
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
            this.a = sz5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.a.m == null || this.a.m.b == null || this.a.w == null || this.a.x == null || !((String) customResponsedMessage.getData()).equals(this.a.m.b) || this.a.H()) {
                return;
            }
            mz5.l(this.a.w, this.a.m.b, R.color.CAM_X0105, R.color.CAM_X0109);
            mz5.l(this.a.x, this.a.m.b, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements rz5.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public h(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // com.repackage.rz5.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.S(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public i(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                b06<CardPersonDynamicThreadData> e = this.a.e();
                if (e != null) {
                    view2.setTag("1");
                    e.a(view2, this.a.m);
                }
                this.a.L();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz5 a;

        public j(sz5 sz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b06<CardPersonDynamicThreadData> e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (e = this.a.e()) == null) {
                return;
            }
            view2.setTag("2");
            e.a(view2, this.a.m);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz5(TbPageContext<?> tbPageContext) {
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
        this.l = 3;
        this.z = true;
        new e(this);
        this.U = new f(this);
        new g(this, 2001390);
        this.V = new h(this);
        this.W = new i(this);
        this.X = new j(this);
        this.Y = new a(this);
        View h2 = h();
        this.k = h2;
        this.n = tbPageContext;
        this.o = (TextView) h2.findViewById(R.id.obfuscated_res_0x7f09266c);
        this.p = (LinearLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0912b9);
        this.q = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f091526);
        this.r = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f090758);
        this.s = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f091ec9);
        this.M = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f092529);
        this.t = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f09238f);
        this.u = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f090ff8);
        this.w = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f092163);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.k.findViewById(R.id.obfuscated_res_0x7f0904f4);
        this.i = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(this.X);
        TextView textView = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f092133);
        this.x = textView;
        textView.setVisibility(8);
        this.y = (ConstrainImageGroup) this.k.findViewById(R.id.obfuscated_res_0x7f0904f5);
        this.y.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.y.setChildClickListener(this.W);
        yg5 yg5Var = new yg5(3);
        yg5Var.d(1.0d);
        this.y.setImageProcessor(yg5Var);
        this.A = this.k.findViewById(R.id.obfuscated_res_0x7f09216e);
        this.B = (TbImageView) this.k.findViewById(R.id.obfuscated_res_0x7f09216c);
        this.C = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f09213b);
        this.j = (ThreadViewAndCommentInfoLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0904f6);
        this.G = (LinearLayout) this.k.findViewById(R.id.obfuscated_res_0x7f09084b);
        this.H = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0924b6);
        this.I = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0924f1);
        this.J = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0902dd);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.k.findViewById(R.id.obfuscated_res_0x7f090221);
        this.K = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.K, R.raw.obfuscated_res_0x7f110007);
        this.L = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f09097b);
        this.D = (LinearLayout) this.k.findViewById(R.id.obfuscated_res_0x7f091e66);
        this.E = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f091e67);
        LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0913bf);
        this.F = linearLayout;
        linearLayout.setVisibility(8);
        this.N = (OriginalThreadCardView) this.k.findViewById(R.id.obfuscated_res_0x7f09172b);
        this.O = this.k.findViewById(R.id.obfuscated_res_0x7f0907ff);
        this.P = this.k.findViewById(R.id.obfuscated_res_0x7f090800);
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = (ThreadCardBottomOpSegmentLayout) this.k.findViewById(R.id.obfuscated_res_0x7f090570);
        this.Q = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.hideDisagree();
        if (this.Q.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Q.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.Q.setLayoutParams(layoutParams);
        }
        this.Q.setOnClickListener(this.U);
        this.Q.setReplyTimeVisible(false);
        this.Q.setShowPraiseNum(true);
        this.Q.setNeedAddPraiseIcon(true);
        this.Q.setNeedAddReplyIcon(true);
        this.Q.setShareVisible(true);
        this.Q.setIsBarViewVisible(false);
        this.Q.setFrom(13);
        lo4 lo4Var = new lo4();
        lo4Var.b = 8;
        lo4Var.h = 3;
        this.Q.setAgreeStatisticData(lo4Var);
        this.Q.setShareReportFrom(6);
        this.Q.setStType("person_page");
        this.Q.setForumAfterClickListener(new b(this));
        this.T = (EMTextView) this.k.findViewById(R.id.obfuscated_res_0x7f0923bc);
    }

    public final void G(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cardPersonDynamicThreadData) == null) || cardPersonDynamicThreadData == null) {
            return;
        }
        if (!this.R && !this.S) {
            this.Q.setCommentClickable(true);
            this.Q.setAgreeClickable(true);
            this.Q.setShareClickable(true);
            this.N.setClickable(true);
            this.u.setClickable(true);
        } else {
            this.Q.setCommentClickable(false);
            this.Q.setAgreeClickable(false);
            this.Q.setShareClickable(false);
            this.N.setClickable(false);
            this.u.setClickable(false);
        }
        this.Q.setCommentNumEnable(true);
        if (cardPersonDynamicThreadData.k == 60) {
            this.Q.setCommentNumEnable(false);
        }
        CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.B;
        if (multipleForumArr != null) {
            this.Q.setMultiForumCount(multipleForumArr.length);
        }
        ThreadData threadData = cardPersonDynamicThreadData.p;
        if (threadData != null) {
            this.Q.setForumId(String.valueOf(threadData.getFid()));
        }
        this.Q.setData(cardPersonDynamicThreadData.p);
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m.F : invokeV.booleanValue;
    }

    public void J() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cardPersonDynamicThreadData = this.m) == null || (threadData = cardPersonDynamicThreadData.p) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (!oi.z()) {
            qi.N(this.n.getPageActivity(), R.string.obfuscated_res_0x7f0f0c75);
            return;
        }
        if (!H()) {
            mz5.a(this.m.b);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(this.m.p.getThreadAlaInfo());
        if (this.m.p.getThreadAlaInfo().user_info != null) {
            alaLiveInfoCoreData.userName = this.m.p.getThreadAlaInfo().user_info.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.n.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, "", false, "")));
    }

    public final void K() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cardPersonDynamicThreadData = this.m) == null || (threadData = cardPersonDynamicThreadData.p) == null || (originalThreadInfo = threadData.originalThreadData) == null) {
            return;
        }
        if (originalThreadInfo.k == 40) {
            M(originalThreadInfo.f);
        } else {
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.n.getPageActivity()).createCfgForPersonCenter(originalThreadInfo.f, null, "person_page", 18005);
            createCfgForPersonCenter.setStartFrom(this.h);
            createCfgForPersonCenter.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "3").param("tid", this.m.b).param("obj_param1", this.m.F ? 1 : 2));
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.m == null) {
            return;
        }
        if (!H()) {
            mz5.a(this.m.b);
            mz5.l(this.w, this.m.b, R.color.CAM_X0105, R.color.CAM_X0109);
            mz5.l(this.x, this.m.b, R.color.CAM_X0107, R.color.CAM_X0109);
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.n.getPageActivity());
        if (this.m.k == 40) {
            pbActivityConfig.setVideo_source("profile");
        }
        pbActivityConfig.createFromThreadCfg(this.m.p, null, "person_page", 18005, true, false, false);
        pbActivityConfig.setForumId(String.valueOf(this.m.p.getFid()));
        pbActivityConfig.setForumName(this.m.p.getForum_name());
        pbActivityConfig.setStartFrom(this.h);
        pbActivityConfig.setIsShareThread(this.m.p.isShareThread);
        pbActivityConfig.setThreadData(this.m.p);
        pbActivityConfig.setIsPrivacy(this.m.o);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        ThreadData threadData = this.m.p;
        if (threadData == null || !threadData.isShareThread) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12943").param("obj_type", "2").param("tid", this.m.b).param("obj_param1", this.m.F ? 1 : 2));
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.m == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = str;
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(getContext(), arrayList, null, VideoRecommentPlayActivityConfig.FROM_MY_THREADS);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public final void N() {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cardPersonDynamicThreadData = this.m) == null || (threadData = cardPersonDynamicThreadData.p) == null || threadData.getThreadAlaInfo() == null || this.m.p.getThreadAlaInfo().share_info == null) {
            return;
        }
        if (!H()) {
            mz5.a(this.m.b);
        }
        if (this.m.p.getThreadAlaInfo().share_info.record_tid <= 0) {
            J();
            return;
        }
        String valueOf = String.valueOf(this.m.p.getThreadAlaInfo().share_info.record_tid);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.n.getPageActivity());
        pbActivityConfig.setVideo_source("profile");
        pbActivityConfig.setStartFrom(this.h);
        pbActivityConfig.setThreadData(this.m.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPersonCenter(valueOf, valueOf, "person_page", 18005)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e9  */
    @Override // com.repackage.bz5
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cardPersonDynamicThreadData) == null) {
            if (cardPersonDynamicThreadData == null) {
                if (h() != null) {
                    h().setVisibility(8);
                    return;
                }
                return;
            }
            this.m = cardPersonDynamicThreadData;
            if (h() != null) {
                h().setVisibility(0);
                h().setOnClickListener(this.U);
            }
            this.o.setVisibility(cardPersonDynamicThreadData.D ? 0 : 8);
            this.p.setVisibility(cardPersonDynamicThreadData.C ? 0 : 4);
            this.O.setVisibility(cardPersonDynamicThreadData.C ? 0 : 8);
            this.P.setVisibility(cardPersonDynamicThreadData.C ? 8 : 0);
            if (cardPersonDynamicThreadData.E) {
                this.O.setVisibility(8);
                this.P.setVisibility(8);
            }
            this.R = cardPersonDynamicThreadData.k == 40 && cardPersonDynamicThreadData.n == 2;
            T(cardPersonDynamicThreadData);
            ThreadData threadData = cardPersonDynamicThreadData.p;
            if (threadData != null) {
                this.S = threadData.isShareThread && cardPersonDynamicThreadData.n == 2;
            }
            this.o.setText(cardPersonDynamicThreadData.r);
            this.q.setText(cardPersonDynamicThreadData.s);
            this.r.setText(cardPersonDynamicThreadData.t);
            CardPersonDynamicThreadData.MultipleForum[] multipleForumArr = cardPersonDynamicThreadData.B;
            if (multipleForumArr != null && multipleForumArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    CardPersonDynamicThreadData.MultipleForum[] multipleForumArr2 = cardPersonDynamicThreadData.B;
                    if (i2 >= multipleForumArr2.length) {
                        break;
                    }
                    sb.append(StringHelper.cutChineseAndEnglishWithSuffix(multipleForumArr2[i2].forum_name, 14, StringHelper.STRING_MORE));
                    if (i2 < cardPersonDynamicThreadData.B.length - 1) {
                        sb.append("吧、");
                    } else if (sb.lastIndexOf(this.c.getString(R.string.obfuscated_res_0x7f0f065a)) != sb.length() - 1) {
                        sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f065a));
                    }
                    i2++;
                }
                String sb2 = sb.toString();
                if (sb2.trim().length() > 0) {
                    this.s.setText(sb2);
                    this.s.setVisibility(0);
                } else {
                    this.s.setText(R.string.obfuscated_res_0x7f0f0e4d);
                }
            } else {
                this.s.setText(R.string.obfuscated_res_0x7f0f0e4d);
            }
            this.T.setVisibility(8);
            if (cardPersonDynamicThreadData.F) {
                int i3 = cardPersonDynamicThreadData.q;
                if (i3 == 3) {
                    this.t.setVisibility(8);
                } else if (i3 == 1) {
                    this.t.setVisibility(0);
                }
                S(cardPersonDynamicThreadData.o);
                if (cardPersonDynamicThreadData.H == 1) {
                    this.t.setVisibility(8);
                    this.T.setVisibility(0);
                }
                this.u.setVisibility(0);
                this.u.setOnClickListener(new c(this, cardPersonDynamicThreadData));
            } else {
                this.t.setVisibility(8);
                this.u.setVisibility(8);
            }
            VoiceData.VoiceModel[] voiceModelArr = cardPersonDynamicThreadData.z;
            if (voiceModelArr != null && voiceModelArr.length > 0) {
                this.i.setVisibility(0);
                V(true);
                VoiceData.VoiceModel voiceModel = voiceModelArr[0];
                this.i.setVoiceModel(voiceModel);
                this.i.setTag(voiceModel);
                this.i.e();
                if (voiceModel != null) {
                    this.i.m(voiceModel.voice_status.intValue());
                }
                this.i.o();
            } else {
                this.i.setVisibility(8);
                V(false);
            }
            MediaData[] mediaDataArr = cardPersonDynamicThreadData.x;
            SkinManager.setBackgroundResource(this.D, R.color.transparent);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.D.setVisibility(0);
            this.A.setVisibility(8);
            this.L.setVisibility(8);
            this.G.setVisibility(8);
            this.J.setVisibility(8);
            this.K.cancelAnimation();
            this.K.setVisibility(8);
            long j2 = cardPersonDynamicThreadData.k;
            if (j2 == 36) {
                this.y.setVisibility(8);
            } else {
                if (j2 != 40) {
                    long j3 = this.m.k;
                    if (j3 != 50) {
                        if (j3 != 60 && j3 != 49) {
                            if (rn4.c().g() && mediaDataArr.length > 0) {
                                LinkedList linkedList = new LinkedList();
                                ThreadData threadData2 = cardPersonDynamicThreadData.p;
                                for (MediaData mediaData : mediaDataArr) {
                                    if (mediaData != null && mediaData.getType() == 3) {
                                        linkedList.add(mediaData);
                                    }
                                }
                                if (ListUtils.getCount(linkedList) > 0) {
                                    this.y.setVisibility(0);
                                    this.y.setFromCDN(this.z);
                                    this.y.setSingleImageRatio(0.67d);
                                    this.y.setImageClickListener(new d(this, linkedList, threadData2));
                                    this.y.setImageMediaList(linkedList);
                                } else {
                                    this.y.setVisibility(8);
                                }
                            } else {
                                this.y.setVisibility(8);
                            }
                            this.D.setVisibility(8);
                        } else {
                            this.y.setVisibility(8);
                            if (this.m.p.getThreadAlaInfo() != null && this.m.p.getThreadAlaInfo().user_info != null) {
                                CardPersonDynamicThreadData cardPersonDynamicThreadData2 = this.m;
                                if (cardPersonDynamicThreadData2.k == 60) {
                                    String str = cardPersonDynamicThreadData2.p.getThreadAlaInfo().user_info.user_name;
                                    if (if5.d(str) > 14) {
                                        str = if5.n(str, 14) + StringHelper.STRING_MORE;
                                    }
                                    this.E.setText(mz5.d(str + ":", this.m.p.getTitle()));
                                    this.E.setVisibility(0);
                                    if (rn4.c().g()) {
                                        this.A.setVisibility(0);
                                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                                        int width = this.A.getWidth();
                                        if (width == 0 || width > qi.k(this.c)) {
                                            width = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702de);
                                        }
                                        layoutParams.height = (width * 9) / 16;
                                        this.A.setLayoutParams(layoutParams);
                                        if (this.m.p.getThreadAlaInfo() != null) {
                                            this.B.setPlaceHolder(3);
                                            this.B.setEvent(this.Y);
                                            this.B.K(cardPersonDynamicThreadData.p.getThreadAlaInfo().cover, 10, false);
                                            this.C.setVisibility(8);
                                            this.K.setVisibility(0);
                                            this.K.playAnimation();
                                            SkinManager.setBackgroundResource(this.D, R.color.CAM_X0205);
                                            this.J.setVisibility(0);
                                            this.J.setText(String.format(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0200), StringHelper.numFormatOverWan(this.m.p.getThreadAlaInfo().audience_count)));
                                            this.Q.getCommentContainer().setOnClickListener(this.U);
                                        } else {
                                            this.Q.getCommentContainer().setOnClickListener(this.Q);
                                        }
                                    }
                                }
                            }
                            this.E.setVisibility(8);
                            if (rn4.c().g()) {
                            }
                        }
                    }
                }
                this.y.setVisibility(8);
                if (rn4.c().g()) {
                    this.A.setVisibility(0);
                    this.C.setVisibility(0);
                    this.C.setImageResource(R.drawable.obfuscated_res_0x7f0808dc);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                    int width2 = this.A.getWidth();
                    if (width2 == 0 || width2 > qi.k(this.c)) {
                        width2 = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0702f1);
                    }
                    layoutParams2.height = (int) (width2 * 0.5625d);
                    this.A.setLayoutParams(layoutParams2);
                    if (this.m.y != null) {
                        this.B.setPlaceHolder(3);
                        this.B.setEvent(this.Y);
                        this.B.K(this.m.y.thumbnail_url, 17, false);
                        if (this.R) {
                            this.L.setVisibility(0);
                            this.L.setText(String.format(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f152e), new Object[0]));
                        } else {
                            this.G.setVisibility(0);
                            this.H.setText(StringHelper.stringForVideoTime(this.m.y.video_duration.intValue() * 1000));
                            this.I.setText(String.format(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0e87), StringHelper.numFormatOverWan(this.m.y.play_count.intValue())));
                        }
                    }
                }
            }
            ThreadData threadData3 = cardPersonDynamicThreadData.p;
            if (threadData3 != null && threadData3.originalThreadData != null) {
                this.N.setVisibility(0);
                this.N.i(cardPersonDynamicThreadData.p.originalThreadData);
                this.N.setOnClickListener(this);
                this.i.setVisibility(8);
                this.y.setVisibility(8);
                this.D.setVisibility(8);
                if (this.S) {
                    this.M.setVisibility(0);
                } else {
                    this.M.setVisibility(8);
                }
            } else {
                this.N.setVisibility(8);
                this.M.setVisibility(8);
            }
            R();
            G(cardPersonDynamicThreadData);
        }
    }

    public void P(fg<TbImageView> fgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fgVar) == null) || (constrainImageGroup = this.y) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(fgVar);
    }

    public void Q(fg<ConstrainImageLayout> fgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fgVar) == null) || (constrainImageGroup = this.y) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(fgVar);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.i.setClickable(true);
            int childCount = this.y.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.y.getChildAt(i2);
                if (childAt != null) {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public final void S(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (textView = this.t) == null) {
            return;
        }
        if (z) {
            textView.setText(R.string.obfuscated_res_0x7f0f0eef);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_card_privacy);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.t.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0f31);
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_card_open);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.t.setCompoundDrawables(drawable2, null, null, null);
    }

    public final boolean T(CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cardPersonDynamicThreadData)) == null) {
            if (cardPersonDynamicThreadData == null || (threadData = cardPersonDynamicThreadData.p) == null) {
                return false;
            }
            SpannableStringBuilder parseTitleOrAbstractForFrs = threadData.parseTitleOrAbstractForFrs(false, true, this.R);
            if (parseTitleOrAbstractForFrs != null && !StringUtils.isNull(parseTitleOrAbstractForFrs.toString())) {
                this.w.setVisibility(0);
                this.w.setOnTouchListener(new rw8(parseTitleOrAbstractForFrs));
                this.w.setText(parseTitleOrAbstractForFrs);
                if (!H()) {
                    mz5.l(this.w, cardPersonDynamicThreadData.b, R.color.CAM_X0105, R.color.CAM_X0109);
                }
            } else {
                this.w.setVisibility(8);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void U(View view2, List<MediaData> list, int i2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048589, this, view2, list, i2, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                qi.N(this.n.getPageActivity(), R.string.obfuscated_res_0x7f0f0ea0);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (mediaData != null && !StringUtils.isNull(mediaData.getPicUrl())) {
                    arrayList.add(mediaData.getPicUrl());
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.z ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = og.g(threadData.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getPicUrl(), imageUrlData);
                }
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.y(arrayList);
            builder.C(i2);
            builder.A(threadData.getForum_name());
            builder.z(String.valueOf(threadData.getFid()));
            builder.P(threadData.getTid());
            builder.D(this.z);
            builder.K(arrayList.size() > 0 ? arrayList.get(0) : "");
            builder.G(true);
            builder.x(concurrentHashMap);
            builder.I(true);
            builder.O(threadData);
            builder.N(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig w = builder.w(this.n.getPageActivity());
            w.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, w));
        }
    }

    public final void V(boolean z) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (constrainImageGroup = this.y) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) constrainImageGroup.getLayoutParams();
        if (z) {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds37);
        } else {
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        }
        this.y.setLayoutParams(layoutParams);
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a9 : invokeV.intValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, tbPageContext, i2) == null) {
            if (this.l != i2) {
                SkinManager.setLottieAnimation(this.K, R.raw.obfuscated_res_0x7f110007);
                SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0109);
                if (this.u != null) {
                    this.u.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_personalba_more24_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS));
                }
                SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0106);
                rz5 rz5Var = this.v;
                if (rz5Var != null) {
                    rz5Var.r();
                }
                this.j.b();
                this.Q.onChangeSkinType();
                SkinManager.setBackgroundColor(this.O, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.P, R.color.CAM_X0205);
                SkinManager.setBackgroundColor(this.E, R.color.CAM_X0205);
                OriginalThreadCardView originalThreadCardView = this.N;
                if (originalThreadCardView != null) {
                    originalThreadCardView.s();
                }
                ms4 d2 = ms4.d(this.T);
                d2.v(R.color.CAM_X0109);
                d2.A(R.string.F_X01);
            }
            this.l = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && view2 == this.N) {
            K();
        }
    }
}
