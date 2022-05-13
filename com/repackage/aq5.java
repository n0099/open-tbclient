package com.repackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import com.repackage.uo5;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aq5 extends uw5<vo5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public ImageView B;
    public RotateAnimation C;
    public ObjectAnimator D;
    public int E;
    public List<uo5.a> F;
    public String G;
    public rq8 H;
    public View i;
    public LinearLayout j;
    public HeadImageView k;
    public ImageView l;
    public TextView m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public LinearLayout q;
    public ImageView r;
    public TextView s;
    public LinearLayout t;
    public ImageView u;
    public TextView v;
    public LinearLayout w;
    public ImageView x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq5 a;

        public a(aq5 aq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq5Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.a.t();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ll4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaPersonCenterActivityConfig a;

        public b(aq5 aq5Var, AlaPersonCenterActivityConfig alaPersonCenterActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq5Var, alaPersonCenterActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaPersonCenterActivityConfig;
        }

        @Override // com.repackage.ll4
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }

        @Override // com.repackage.ll4
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(aq5 aq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public d(aq5 aq5Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq5Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                gf.n().j(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = -1;
        this.F = new ArrayList();
        u();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.k.setVisibility(8);
            this.A.clearAnimation();
            ObjectAnimator objectAnimator = this.D;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e8 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(this.o, R.drawable.super_entrance_ranklist_bg_selector);
            SkinManager.setImageResource(this.r, R.drawable.super_entrance_discuss_bg_selector);
            SkinManager.setImageResource(this.u, R.drawable.super_entrance_person_bg_selector);
            SkinManager.setImageResource(this.x, R.drawable.super_entrance_start_recorder_bg_selector);
            SkinManager.setImageResource(this.B, R.drawable.pic_live_tab_quan);
            if (8 == this.A.getVisibility()) {
                this.l.setVisibility(0);
                this.B.setVisibility(8);
                SkinManager.setBackgroundResource(this.l, R.drawable.super_entrance_follow_bg_selector);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.j) {
                if (ViewHelper.checkUpIsLogin(this.c)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(j().getPageActivity())));
                }
                StatisticItem statisticItem = new StatisticItem("c13552");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (view2 == this.n) {
                if (StringUtils.isNull(this.G)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.G});
                StatisticItem statisticItem2 = new StatisticItem("c13553");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            } else if (view2 == this.q) {
                String str = "http://tieba.baidu.com/f?kw=百度直播";
                String q = iu4.k().q("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
                if (!StringUtils.isNull(q) && q.startsWith("http")) {
                    str = q;
                }
                if (!str.contains("?")) {
                    str = str + "?default_tab_id=1&call_from=15";
                } else if (!str.contains("&default_tab_id=")) {
                    str = str + "&default_tab_id=1&call_from=15";
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{str}, true);
                StatisticItem statisticItem3 = new StatisticItem("c13554");
                TiebaStaticHelper.addYYParam(statisticItem3);
                TiebaStatic.log(statisticItem3);
            } else if (view2 == this.t) {
                if (ViewHelper.checkUpIsLogin(this.c)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true))));
                }
                StatisticItem statisticItem4 = new StatisticItem("c13555");
                TiebaStaticHelper.addYYParam(statisticItem4);
                TiebaStatic.log(statisticItem4);
            } else if (view2 == this.w) {
                y();
                TiebaStatic.log("c13617");
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || ListUtils.isEmpty(this.F)) {
            return;
        }
        this.E++;
        int size = this.F.size();
        int i = this.E;
        if (size > i) {
            this.k.K(this.F.get(i).a, 12, false);
        } else if (this.F.size() > 0) {
            this.E = 0;
            this.k.K(this.F.get(0).a, 12, false);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View k = k();
            this.i = k;
            this.j = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0908ea);
            this.n = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0908f4);
            this.q = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0908e7);
            this.t = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0908f0);
            this.A = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908ef);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0908f7);
            HeadImageView headImageView = (HeadImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908ee);
            this.k = headImageView;
            headImageView.setIsRound(true);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setDefaultResource(17170445);
            this.k.setDefaultBgResource(17170445);
            this.B = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908eb);
            this.l = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908ec);
            this.o = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f6);
            this.r = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908e9);
            this.u = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f2);
            this.x = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f9);
            this.m = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0908ed);
            this.p = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f5);
            this.s = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0908e8);
            this.v = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f1);
            this.y = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f8);
            this.z = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0908f3);
            this.j.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.w.setOnClickListener(this);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.C = rotateAnimation;
            rotateAnimation.setDuration(6000L);
            this.C.setRepeatMode(1);
            this.C.setRepeatCount(-1);
            this.C.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.k, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
            this.D = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            this.D.setTarget(this.k);
            this.D.setRepeatCount(-1);
            this.D.setRepeatMode(1);
            this.D.setDuration(2000L);
            this.D.addListener(new a(this));
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void v(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (imageView = this.z) == null) {
            return;
        }
        if (z) {
            if (!iu4.k().h(iu4.o("square_live_publish_live_has_showed"), false)) {
                iu4.k().u(iu4.o("square_live_publish_live_has_showed"), true);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: w */
    public void l(vo5 vo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vo5Var) == null) {
            this.t.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.w.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.w.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            if (vo5Var != null && vo5Var.a != null) {
                if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                    StatisticItem statisticItem = new StatisticItem("c13550");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13549");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem("c13547");
                TiebaStaticHelper.addYYParam(statisticItem3);
                TiebaStatic.log(statisticItem3);
                StatisticItem statisticItem4 = new StatisticItem("c13546");
                TiebaStaticHelper.addYYParam(statisticItem4);
                TiebaStatic.log(statisticItem4);
                uo5 uo5Var = vo5Var.a;
                this.G = uo5Var.c;
                if (uo5Var.a && !ListUtils.isEmpty(uo5Var.b)) {
                    ArrayList<uo5.a> arrayList = vo5Var.a.b;
                    this.F = arrayList;
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    z();
                    t();
                    return;
                }
                A();
                return;
            }
            A();
        }
    }

    public final void x(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                nr4 nr4Var = new nr4(j().getPageActivity());
                nr4Var.setAutoNight(false);
                nr4Var.setTitle(R.string.obfuscated_res_0x7f0f0f0a);
                nr4Var.setMessage(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f04e7));
                nr4Var.setTitleShowCenter(true);
                nr4Var.setMessageShowCenter(true);
                nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0988, new c(this));
                nr4Var.create(j()).show();
            } else if (ViewHelper.checkUpIsLogin(j().getPageActivity())) {
                if (this.H == null) {
                    this.H = new rq8(j());
                }
                if (this.H.d()) {
                    return;
                }
                iu4.k().u(iu4.o("square_live_publish_live_has_showed"), true);
                this.z.setVisibility(8);
                x(j());
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setVisibility(8);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.k.setVisibility(0);
            this.A.clearAnimation();
            RotateAnimation rotateAnimation = this.C;
            if (rotateAnimation != null) {
                this.A.startAnimation(rotateAnimation);
            }
            ObjectAnimator objectAnimator = this.D;
            if (objectAnimator != null) {
                if (objectAnimator.isRunning()) {
                    this.D.cancel();
                }
                this.D.start();
            }
        }
    }
}
