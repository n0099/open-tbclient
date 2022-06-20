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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconData;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mv7;
import com.repackage.xw5;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes6.dex */
public class mv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public TiePlusEventController D;
    public xf5 E;
    public int F;
    public PbFragment a;
    public tr7 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public zy5 e;
    public RelativeLayout f;
    public ImageView g;
    public et7 h;
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
    public LinearLayout s;
    public LinearLayout t;
    public ClickableHeaderImageView u;
    public PbFirstFloorUserLikeButton v;
    public PbFirstFloorMessageButton w;
    public su7 x;
    public e y;
    public TextView z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ mv7 b;

        public a(mv7 mv7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mv7Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.b.t.getMeasuredWidth();
                int measuredWidth2 = this.b.z.getMeasuredWidth();
                int measuredWidth3 = this.b.C.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.b.B.setVisibility(8);
                    this.b.A.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.b.A.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ mv7 b;

        public b(mv7 mv7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mv7Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.E.q(TiePlusStat.StatType.CLICK);
                this.b.D.o(this.b.E);
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
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(mv7 mv7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var, view2};
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
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv7 a;

        public d(mv7 mv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv7Var;
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
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ mv7 d;

        public e(@NonNull mv7 mv7Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mv7Var;
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
                xt4 xt4Var = new xt4();
                xt4Var.r(R.color.CAM_X0302);
                this.b.setConfig(xt4Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.fv7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            mv7.e.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!ni.A()) {
                pi.N(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0c37);
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

    public mv7(PbFragment pbFragment, tr7 tr7Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, tr7Var, onClickListener};
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
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = 0;
        this.a = pbFragment;
        this.b = tr7Var;
        this.c = onClickListener;
        s();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.h.g(z);
        }
    }

    public void B(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rq7Var) == null) {
            if (rq7Var != null && rq7Var.r0()) {
                int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c8);
                int paddingBottom = this.i.getPaddingBottom();
                if (rq7Var.g0()) {
                    f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (rq7Var != null && !rq7Var.O().isVideoThreadType() && rq7Var.g0() && (!StringUtils.isNull(rq7Var.O().getTitle()) || rq7Var.O().getSpan_str() != null)) {
                f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f2, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void D(int i, rq7 rq7Var, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), rq7Var, postData, onClickListener}) == null) {
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
                        this.p.setOnClickListener(this.a.N().d.d);
                    }
                    int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.h(tShowInfoNew, 3, f, f, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(q(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f091e99, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f091ea1, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (rq7Var.g0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.f0()) {
                    fr4 d2 = fr4.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f0337);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02f2);
                    this.l.setVisibility(0);
                    fr4 d3 = fr4.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02f3);
                    this.l.setVisibility(0);
                    fr4 d4 = fr4.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Y()), "yyyy"))) {
                    this.z.setText(StringHelper.getFormatTimeShort(postData.Y()));
                } else {
                    this.z.setText(StringHelper.getFormatTime(postData.Y()));
                }
                if (rq7Var.g0()) {
                    this.A.setVisibility(8);
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo);
                    } else {
                        this.C.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo2);
                    } else {
                        this.C.setVisibility(8);
                    }
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    mz4 N = postData.N();
                    String o = o(postData);
                    if (!TextUtils.isEmpty(o)) {
                        this.A.setVisibility(0);
                        this.A.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14f5) + o);
                    } else if (N != null && !TextUtils.isEmpty(N.b()) && !TextUtils.isEmpty(N.b().trim())) {
                        this.A.setVisibility(0);
                        this.A.setText(N.b());
                    } else {
                        this.A.setVisibility(8);
                    }
                    if (N != null && !TextUtils.isEmpty(N.a()) && TextUtils.isEmpty(o)) {
                        this.B.setText(N.a());
                        this.B.setVisibility(0);
                        this.t.post(new a(this, (int) this.B.getPaint().measureText(N.a(), 0, N.a().length())));
                    } else {
                        this.B.setVisibility(8);
                    }
                }
                if (rq7Var.O().getAuthor() == null || rq7Var.O().getAuthor().getAlaInfo() == null || rq7Var.O().getAuthor().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    E(rq7Var);
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
                ClickableHeaderImageView clickableHeaderImageView = this.u;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.n.getHeadView().setUserId(s.getUserId());
                this.n.getHeadView().setUserName(s.getUserName());
                this.n.getHeadView().setTid(postData.J());
                this.n.getHeadView().setFid(rq7Var != null ? rq7Var.m() : "");
                this.n.getHeadView().setFName(rq7Var.n());
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
                    this.k.setText(tp7.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f091e70, tp7.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (rq7Var != null) {
                this.h.f(rq7Var.O());
            }
        }
    }

    public final void E(rq7 rq7Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, rq7Var) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && rq7Var != null && rq7Var.O() != null && rq7Var.O().getAuthor() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", rq7Var.m());
            statisticItem.param("fname", rq7Var.n());
            statisticItem.param("obj_param1", rq7Var.O().getAuthor().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", rq7Var.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (rq7Var.O().getAuthor().getAlaInfo() != null) {
                AlaInfoData alaInfo = rq7Var.O().getAuthor().getAlaInfo();
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
        this.o.post(new d(this));
    }

    public void F(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, postData, z) == null) {
            if (this.a.v0()) {
                this.F = 0;
                if (postData != null && postData.s() != null) {
                    this.F = postData.s().getLevel_id();
                }
                if (this.F > 0 && !z) {
                    this.m.setVisibility(0);
                    t(this.m);
                    if (postData != null && postData.s() != null) {
                        I(postData);
                    }
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            if (postData == null || postData.s() == null) {
                return;
            }
            I(postData);
        }
    }

    public void G(rq7 rq7Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048582, this, rq7Var, postData, z) == null) || rq7Var == null || postData == null) {
            return;
        }
        if (3 != rq7Var.g()) {
            this.v.setVisibility(0);
            t(this.v);
        }
        if (z) {
            this.v.setVisibility(8);
            if (rq7Var != null && rq7Var.O() != null && rq7Var.O().getBaijiahaoData() != null && rq7Var.O().getBaijiahaoData().oriUgcType == 3) {
                this.y.g(8);
            } else {
                this.y.g(0);
            }
            this.y.a(rq7Var.Q());
            this.y.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e5f), StringHelper.numberUniformFormatExtra(rq7Var.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned()) {
            this.y.g(8);
        } else {
            this.v.setVisibility(8);
            this.y.g(8);
        }
        if (rq7Var.i || 3 == rq7Var.g()) {
            this.v.setVisibility(8);
        }
    }

    public void H(rq7 rq7Var, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, rq7Var, postData) == null) || postData == null || this.a == null || postData.m0 == null || rq7Var.O() == null || rq7Var.O().getAuthor() == null) {
            return;
        }
        MetaData author = rq7Var.O().getAuthor();
        this.D = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent o = TiePlusHelper.o(postData.m0);
        if (o == null || o.tiebaplus_info == null) {
            return;
        }
        xf5 c2 = xf5.c(o.type.intValue(), o.tiebaplus_info, rq7Var.O());
        this.E = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.E.q(TiePlusStat.StatType.EXPOSE);
        this.D.o(this.E);
        this.w.setVisibility(0);
        this.w.setOnClickListener(new b(this, author));
    }

    public final void I(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        MetaData s = postData.s();
        ArrayList<IconData> iconInfo = s.getIconInfo();
        UserIconBox userIconBox = this.q;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.obfuscated_res_0x7f091e99, s.getUserId());
            if (this.a.N() != null) {
                this.q.setOnClickListener(this.a.N().d.c);
            }
            int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.q.g(iconInfo, 4, f, f, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.q.setAutoChangedStyle(true);
            t(this.q);
        }
    }

    public void j(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f);
    }

    public void k(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, bdTypeListView, i) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f, i);
    }

    public void l(rq7 rq7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{rq7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (rq7Var != null && rq7Var.j) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f27);
                this.g.setVisibility(0);
                t(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f66);
                this.g.setVisibility(0);
                t(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f64);
                this.g.setVisibility(0);
                t(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f65);
                this.g.setVisibility(0);
                t(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void m() {
        zy5 zy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (zy5Var = this.e) == null) {
            return;
        }
        zy5Var.I();
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h.e() : (TextView) invokeV.objValue;
    }

    public final String o(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return null;
            }
            return postData.s().getIpAddress();
        }
        return (String) invokeL.objValue;
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new xw5.a(str));
            return xw5.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05e5, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0916fd);
            this.g = imageView;
            imageView.getLayoutParams().height = tu7.g();
            et7 et7Var = new et7(this.a.getBaseFragmentActivity(), this.f);
            this.h = et7Var;
            et7Var.a();
            et7 et7Var2 = this.h;
            et7Var2.d(et7Var2.e(), this.c);
            this.i = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09169f);
            this.j = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f0916fa);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09169e);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909b8);
            this.m = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090dbb);
            this.r = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09169b);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d9);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f09169c);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091cdc);
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091cdd);
            this.s = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09169d);
            this.t = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091679);
            this.v = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f0916af);
            this.w = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f0916b6);
            this.y = new e(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09171d), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f09171e));
            this.z = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916a5);
            this.A = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916a3);
            this.B = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916a1);
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916a2);
        }
    }

    public final void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new c(this, view2));
            ofInt.start();
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.w;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i);
            }
            TextView textView = this.A;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.z;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            e eVar = this.y;
            if (eVar != null) {
                eVar.e(i);
            }
            TextView textView3 = this.C;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.B;
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

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            zy5 zy5Var = this.e;
            if (zy5Var != null) {
                zy5Var.I();
            }
            ColumnLayout columnLayout = this.i;
            if (columnLayout != null && this.u != null) {
                columnLayout.removeView(this.r);
                this.u = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void w(rq7 rq7Var, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{rq7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || rq7Var == null || postData == null) {
            return;
        }
        String Q = rq7Var != null ? rq7Var.Q() : "";
        int i = tu7.i(rq7Var);
        if (z && postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
        }
        if (this.x == null) {
            ThreadData O = rq7Var.O();
            int i2 = 1;
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i2 = 4;
                } else if (O.isBJHVideoThreadType()) {
                    i2 = 6;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i2 = 7;
                } else if (O.isBJHNormalThreadType()) {
                    i2 = 5;
                } else if (O.isVideoWorksInfo()) {
                    i2 = 8;
                }
            }
            su7 su7Var = new su7(this.a.getPageContext(), this.v, i2);
            this.x = su7Var;
            su7Var.l(this.a.getUniqueId());
            this.x.v(O);
        }
        if (postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
            this.x.n(postData.s());
            this.x.x(Q);
        }
        su7 su7Var2 = this.x;
        su7Var2.p = z2;
        su7Var2.w(i);
    }

    public void x(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f);
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void z(PostData postData, rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, postData, rq7Var) == null) || postData == null || rq7Var == null) {
            return;
        }
        if (postData.R() != null) {
            this.j.setData(this.a.getPageContext(), rq7Var.F().get(0).R(), xh8.a("PB", "c0132", rq7Var.l().getId(), rq7Var.l().getName(), rq7Var.O().getId(), this.a.f6() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }
}
