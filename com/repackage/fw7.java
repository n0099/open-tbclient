package com.repackage;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fw7;
import com.repackage.ux5;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes6.dex */
public class fw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TiePlusEventController F;
    public ah5 G;
    public int H;
    public int I;
    public String J;
    public PbFragment a;
    public ls7 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public wz5 e;
    public RelativeLayout f;
    public ImageView g;
    public wt7 h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public HeadPendantView n;
    public TBLottieAnimationView o;
    public UserIconBox p;
    public UserIconBox q;
    public FrameLayout r;
    public HeadCustomImageView s;
    public VirtualImageStatusTip t;
    public LinearLayout u;
    public LinearLayout v;
    public ClickableHeaderImageView w;
    public PbFirstFloorUserLikeButton x;
    public PbFirstFloorMessageButton y;
    public kv7 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fw7 b;

        public a(fw7 fw7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.b.v.getMeasuredWidth();
                int measuredWidth2 = this.b.B.getMeasuredWidth();
                int measuredWidth3 = this.b.E.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.b.D.setVisibility(8);
                    this.b.C.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.b.C.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ fw7 b;

        public b(fw7 fw7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.w(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ jr7 b;
        public final /* synthetic */ fw7 c;

        public c(fw7 fw7Var, MetaData metaData, jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, metaData, jr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw7Var;
            this.a = metaData;
            this.b = jr7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.w(this.a);
                pv7.a(pv7.a, this.b.Q(), pv7.b, this.c.I, this.c.J);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ fw7 b;

        public d(fw7 fw7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw7Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.G.q(TiePlusStat.StatType.CLICK);
                this.b.F.o(this.b.G);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(ng.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.u(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public e(fw7 fw7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, view2};
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw7 a;

        public f(fw7 fw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ fw7 d;

        public g(@NonNull fw7 fw7Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw7Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fw7Var;
            this.a = textView;
            this.b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c = str;
            }
        }

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? TiebaPlusConfigData.DEFAULT : tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                vu4 vu4Var = new vu4();
                vu4Var.r(R.color.CAM_X0302);
                this.b.setConfig(vu4Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.yv7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            fw7.g.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!ni.A()) {
                pi.N(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0c17);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.l(i);
                } else {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setText(charSequence.toString());
                } else {
                    this.a.setText(charSequence);
                }
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setVisibility(i);
                    this.a.setVisibility(8);
                    return;
                }
                this.b.setVisibility(8);
                this.a.setVisibility(i);
            }
        }
    }

    public fw7(PbFragment pbFragment, ls7 ls7Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ls7Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.f = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.r = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.H = 0;
        this.I = 0;
        this.J = null;
        this.a = pbFragment;
        this.b = ls7Var;
        this.c = onClickListener;
        v();
    }

    public void A(jr7 jr7Var, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jr7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || jr7Var == null || postData == null) {
            return;
        }
        String Q = jr7Var != null ? jr7Var.Q() : "";
        int j = lv7.j(jr7Var);
        if (z && postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
        }
        if (this.z == null) {
            ThreadData O = jr7Var.O();
            int i = 1;
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i = 4;
                } else if (O.isBJHVideoThreadType()) {
                    i = 6;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i = 7;
                } else if (O.isBJHNormalThreadType()) {
                    i = 5;
                } else if (O.isVideoWorksInfo()) {
                    i = 8;
                }
            }
            kv7 kv7Var = new kv7(this.a.getPageContext(), this.x, i);
            this.z = kv7Var;
            kv7Var.l(this.a.getUniqueId());
            this.z.v(O);
        }
        if (postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
            this.z.n(postData.s());
            this.z.x(Q);
        }
        kv7 kv7Var2 = this.z;
        kv7Var2.p = z2;
        kv7Var2.w(j);
    }

    public void B(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f);
    }

    public final void C(jr7 jr7Var, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jr7Var, postData) == null) {
            MetaData s = postData.s();
            HeadCustomImageView headCustomImageView = this.s;
            if (headCustomImageView == null || this.t == null) {
                return;
            }
            headCustomImageView.setVisibility(0);
            if (postData.c0() != null) {
                FrameLayout frameLayout = this.r;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                this.s.d(s);
                VirtualImageCustomFigure c0 = postData.c0();
                this.s.setHeadImageViewResource(c0.getFigureUrl());
                this.s.setHeadImageBackgroundColorResource(c0.getBackgroundValue());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(c0.getBackGroundType())) {
                    str = c0.getBackgroundValue();
                } else {
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(c0.getBackGroundType())) {
                        this.s.setHeadImageBackgroundResource(c0.getBackgroundValue());
                    }
                    str = "#7F66FE";
                }
                PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.x;
                if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    this.x.setLayoutParams(marginLayoutParams);
                }
                if (postData.d0() != null && !TextUtils.isEmpty(postData.d0().b())) {
                    z05 d0 = postData.d0();
                    this.t.setData(d0.b(), d0.a(), str);
                    this.t.setVisibility(0);
                    LinearLayout linearLayout = this.u;
                    if (linearLayout != null && linearLayout.getVisibility() == 0 && (this.u.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
                        marginLayoutParams2.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.topMargin, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.bottomMargin);
                        this.u.setLayoutParams(marginLayoutParams2);
                    }
                    LinearLayout linearLayout2 = this.v;
                    if (linearLayout2 != null && linearLayout2.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams3.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams3);
                    }
                    this.t.setNotNeedAnimate();
                    this.I = pv7.d;
                    this.J = this.t.getData();
                } else {
                    this.I = pv7.e;
                    this.t.setVisibility(8);
                    LinearLayout linearLayout3 = this.u;
                    if (linearLayout3 != null && linearLayout3.getVisibility() == 0 && (this.u.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
                        marginLayoutParams4.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams4.bottomMargin);
                        this.u.setLayoutParams(marginLayoutParams4);
                    }
                    LinearLayout linearLayout4 = this.v;
                    if (linearLayout4 != null && linearLayout4.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams5.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams5.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams5);
                    }
                }
                this.s.setBigWidthAndHeight(pi.f(TbadkApplication.getInst(), R.dimen.tbds110), pi.f(TbadkApplication.getInst(), R.dimen.tbds144));
            }
            this.t.setOnClickListener(new b(this, s));
            this.s.setOnClickListener(new c(this, s, jr7Var));
            pv7.a(2, jr7Var.Q(), pv7.b, this.I, this.J);
        }
    }

    public void D(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void E(PostData postData, jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, postData, jr7Var) == null) || postData == null || jr7Var == null) {
            return;
        }
        if (postData.R() != null) {
            this.j.setData(this.a.getPageContext(), jr7Var.F().get(0).R(), ti8.a("PB", "c0132", jr7Var.l().getId(), jr7Var.l().getName(), jr7Var.O().getId(), this.a.g6() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h.g(z);
        }
    }

    public void G(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jr7Var) == null) {
            if (jr7Var != null && jr7Var.r0()) {
                int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c5);
                int paddingBottom = this.i.getPaddingBottom();
                if (jr7Var.g0()) {
                    f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (jr7Var != null && !jr7Var.O().isVideoThreadType() && jr7Var.g0() && (!StringUtils.isNull(jr7Var.O().getTitle()) || jr7Var.O().getSpan_str() != null)) {
                f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void I(int i, jr7 jr7Var, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), jr7Var, postData, onClickListener}) == null) {
            if (postData != null && postData.s() != null) {
                MetaData s = postData.s();
                String string = s.getName_show() == null ? StringUtils.string(s.getUserName()) : StringUtils.string(s.getName_show());
                if ((!StringUtils.isNull(postData.s().getSealPrefix()) ? oi.byteLength(s.getSealPrefix()) + 2 : 0) > 0) {
                    if (oi.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    }
                } else if (oi.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = s.getTShowInfoNew();
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.N() != null) {
                        this.p.setOnClickListener(this.a.N().d.e);
                    }
                    int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.h(tShowInfoNew, 3, f2, f2, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(t(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f091f41, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f091f49, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (jr7Var.g0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.h0()) {
                    vr4 d2 = vr4.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f033b);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02f6);
                    this.l.setVisibility(0);
                    vr4 d3 = vr4.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02f7);
                    this.l.setVisibility(0);
                    vr4 d4 = vr4.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Y()), "yyyy"))) {
                    this.B.setText(StringHelper.getFormatTimeShort(postData.Y()));
                } else {
                    this.B.setText(StringHelper.getFormatTime(postData.Y()));
                }
                if (jr7Var.g0()) {
                    this.C.setVisibility(8);
                    if (this.v.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.v.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.E.setVisibility(0);
                        this.E.setText(authInfo);
                    } else {
                        this.E.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.E.setVisibility(0);
                        this.E.setText(authInfo2);
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (this.v.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.v.getLayoutParams())).rightMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    o05 N = postData.N();
                    String r = r(postData);
                    if (!TextUtils.isEmpty(r)) {
                        this.C.setVisibility(0);
                        this.C.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f149d) + r);
                    } else if (N != null && !TextUtils.isEmpty(N.b()) && !TextUtils.isEmpty(N.b().trim())) {
                        this.C.setVisibility(0);
                        this.C.setText(N.b());
                    } else {
                        this.C.setVisibility(8);
                    }
                    if (N != null && !TextUtils.isEmpty(N.a()) && TextUtils.isEmpty(r)) {
                        this.D.setText(N.a());
                        this.D.setVisibility(0);
                        this.v.post(new a(this, (int) this.D.getPaint().measureText(N.a(), 0, N.a().length())));
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (postData.c0() != null) {
                        C(jr7Var, postData);
                    }
                }
                if (jr7Var.O().getAuthor() == null || jr7Var.O().getAuthor().getAlaInfo() == null || jr7Var.O().getAuthor().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    J(jr7Var);
                    z = true;
                }
                this.n.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.n.j(s, 4);
                    this.n.setIsclearmode(false);
                } else {
                    this.n.setIsclearmode(true);
                }
                this.n.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.w;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.n.getHeadView().setUserId(s.getUserId());
                this.n.getHeadView().setUserName(s.getUserName());
                this.n.getHeadView().setTid(postData.J());
                this.n.getHeadView().setFid(jr7Var != null ? jr7Var.m() : "");
                this.n.getHeadView().setFName(jr7Var.n());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.l(s.getAvater());
                } else {
                    this.n.n(s);
                    this.n.setIsNeedAlpAnima(true);
                }
                String name_show = s.getName_show();
                String userName = s.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(lq7.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f091f18, lq7.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (jr7Var != null) {
                this.h.f(jr7Var.O());
            }
        }
    }

    public final void J(jr7 jr7Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jr7Var) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && jr7Var != null && jr7Var.O() != null && jr7Var.O().getAuthor() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", jr7Var.m());
            statisticItem.param("fname", jr7Var.n());
            statisticItem.param("obj_param1", jr7Var.O().getAuthor().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", jr7Var.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (jr7Var.O().getAuthor().getAlaInfo() != null) {
                AlaInfoData alaInfo = jr7Var.O().getAuthor().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.o.setVisibility(0);
        this.o.setSpeed(0.8f);
        this.o.loop(true);
        this.o.post(new f(this));
    }

    public void K(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, postData, z) == null) {
            if (this.a.v0()) {
                this.H = 0;
                if (postData != null && postData.s() != null) {
                    this.H = postData.s().getLevel_id();
                }
                if (this.H > 0 && !z) {
                    this.m.setVisibility(0);
                    x(this.m);
                    if (postData != null && postData.s() != null) {
                        N(postData);
                    }
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.H));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            if (postData == null || postData.s() == null) {
                return;
            }
            N(postData);
        }
    }

    public void L(jr7 jr7Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048587, this, jr7Var, postData, z) == null) || jr7Var == null || postData == null) {
            return;
        }
        if (3 != jr7Var.g()) {
            this.x.setVisibility(0);
            x(this.x);
        }
        if (z) {
            this.x.setVisibility(8);
            if (jr7Var != null && jr7Var.O() != null && jr7Var.O().getBaijiahaoData() != null && jr7Var.O().getBaijiahaoData().oriUgcType == 3) {
                this.A.g(8);
            } else {
                this.A.g(0);
            }
            this.A.a(jr7Var.Q());
            this.A.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e3f), StringHelper.numberUniformFormatExtra(jr7Var.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned()) {
            this.A.g(8);
        } else {
            this.x.setVisibility(8);
            this.A.g(8);
        }
        if (jr7Var.i || 3 == jr7Var.g()) {
            this.x.setVisibility(8);
        }
    }

    public void M(jr7 jr7Var, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jr7Var, postData) == null) || postData == null || this.a == null || postData.g0 == null || jr7Var.O() == null || jr7Var.O().getAuthor() == null) {
            return;
        }
        MetaData author = jr7Var.O().getAuthor();
        this.F = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent o = TiePlusHelper.o(postData.g0);
        if (o == null || o.tiebaplus_info == null) {
            return;
        }
        ah5 c2 = ah5.c(o.type.intValue(), o.tiebaplus_info, jr7Var.O());
        this.G = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.G.q(TiePlusStat.StatType.EXPOSE);
        this.F.o(this.G);
        this.y.setVisibility(0);
        this.y.setOnClickListener(new d(this, author));
    }

    public final void N(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        MetaData s = postData.s();
        ArrayList<IconData> iconInfo = s.getIconInfo();
        UserIconBox userIconBox = this.q;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.obfuscated_res_0x7f091f41, s.getUserId());
            if (this.a.N() != null) {
                this.q.setOnClickListener(this.a.N().d.c);
            }
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.q.g(iconInfo, 4, f2, f2, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.q.setAutoChangedStyle(true);
            x(this.q);
        }
    }

    public void m(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f);
    }

    public void n(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, bdTypeListView, i) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f, i);
    }

    public void o(jr7 jr7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{jr7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (jr7Var != null && jr7Var.j) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080ead);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080eed);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080eeb);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080eec);
                this.g.setVisibility(0);
                x(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void p() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (wz5Var = this.e) == null) {
            return;
        }
        wz5Var.I();
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h.e() : (TextView) invokeV.objValue;
    }

    public final String r(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return null;
            }
            return postData.s().getIpAddress();
        }
        return (String) invokeL.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ux5.a(str));
            return ux5.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d060b, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091781);
            this.g = imageView;
            imageView.getLayoutParams().height = lv7.h();
            wt7 wt7Var = new wt7(this.a.getBaseFragmentActivity(), this.f);
            this.h = wt7Var;
            wt7Var.a();
            wt7 wt7Var2 = this.h;
            wt7Var2.d(wt7Var2.e(), this.c);
            this.i = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091723);
            this.j = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f09177e);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091722);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909b8);
            this.m = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090dc2);
            this.r = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09171f);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090719);
            this.s = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.t = (VirtualImageStatusTip) this.f.findViewById(R.id.obfuscated_res_0x7f092479);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f09175d);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091720);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091d85);
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091d86);
            this.u = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091721);
            this.v = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0916fd);
            this.x = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091733);
            this.y = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f09173a);
            this.A = new g(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917a1), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f0917a2));
            this.B = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091729);
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091727);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091725);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091726);
        }
    }

    public final void w(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, metaData) == null) {
            String str2 = null;
            if (metaData != null) {
                str2 = metaData.getUserId();
                str = metaData.getUserName();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), str2, str)));
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new e(this, view2));
            ofInt.start();
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.H));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.x;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.y;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i);
            }
            TextView textView = this.C;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.B;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            g gVar = this.A;
            if (gVar != null) {
                gVar.e(i);
            }
            TextView textView3 = this.E;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.D;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            UserIconBox userIconBox = this.q;
            if (userIconBox != null) {
                userIconBox.i(i);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            wz5 wz5Var = this.e;
            if (wz5Var != null) {
                wz5Var.I();
            }
            ColumnLayout columnLayout = this.i;
            if (columnLayout != null && this.w != null) {
                columnLayout.removeView(this.r);
                this.w = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }
}
