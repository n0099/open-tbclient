package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tg5;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
/* loaded from: classes6.dex */
public class ir8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ArrayList<TransmitForumData> b;
    public Context c;
    public View d;
    public hr8 e;
    public ShareItem f;
    public gr8 g;
    public View.OnClickListener h;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public boolean k;
    public tg5 l;
    public kr8 m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    @NonNull
    public b55 r;
    @Nullable
    public a55 s;
    public CustomMessageListener t;
    public tg5.b u;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ir8 ir8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir8Var, Integer.valueOf(i)};
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
            this.a = ir8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.a.b = (ArrayList) customResponsedMessage.getData();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tg5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir8 a;

        public b(ir8 ir8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir8Var;
        }

        @Override // com.repackage.tg5.b
        public void a(boolean z) {
            ShareDialogItemView shareDialogItemView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (shareDialogItemView = (ShareDialogItemView) this.a.d.findViewWithTag(16)) == null) {
                return;
            }
            shareDialogItemView.c(z ? R.drawable.obfuscated_res_0x7f08098a : R.drawable.obfuscated_res_0x7f080989, SkinManager.getColor(R.color.CAM_X0107));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608734, "Lcom/repackage/ir8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608734, "Lcom/repackage/ir8;");
                return;
            }
        }
        v = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        w = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public ir8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = false;
        this.r = (b55) w45.c(b55.a);
        this.s = null;
        this.t = new a(this, 2016563);
        this.u = new b(this);
        this.c = context;
        MessageManager.getInstance().registerListener(this.t);
    }

    public final void A(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, shareItem, i) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.a) {
                z(i, shareItem.C);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.E);
                param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            g(i, i2, SkinManager.getColor(R.color.CAM_X0107), i3, i4);
        }
    }

    public final void d(int i, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, SkinManager.getColor(R.color.CAM_X0107), i3);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.a(i4, shareDialogItemView);
        }
    }

    public final void e(AbsSvgType absSvgType, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048579, this, absSvgType, i, i2, i3) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        hr8 hr8Var = this.e;
        shareDialogItemView.a();
        hr8Var.a(i3, shareDialogItemView);
    }

    public final void f(AbsSvgType absSvgType, int i, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{absSvgType, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        shareDialogItemView.a();
        MaskView.c(shareDialogItemView, z);
        this.e.a(i3, shareDialogItemView);
    }

    public final void g(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.c);
            shareDialogItemView.setItemIcon(i2, i3, i4);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            hr8 hr8Var = this.e;
            shareDialogItemView.a();
            hr8Var.a(i5, shareDialogItemView);
        }
    }

    @NonNull
    public a55 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.s == null) {
                this.s = this.r.b(j());
            }
            return (a55) Objects.requireNonNull(this.s);
        }
        return (a55) invokeV.objValue;
    }

    public MarkData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f.K);
            markData.setPostId(this.f.X);
            markData.setTime(date.getTime());
            markData.setId(this.f.K);
            markData.setFloor(1);
            markData.setForumId(this.f.J);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    @NonNull
    public final TbPageContext j() {
        InterceptResult invokeV;
        TbPageContext<BaseFragmentActivity> pageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = this.c;
            if (context instanceof BaseActivity) {
                pageContext = ((BaseActivity) context).getPageContext();
            } else {
                pageContext = context instanceof BaseFragmentActivity ? ((BaseFragmentActivity) context).getPageContext() : null;
            }
            return (TbPageContext) Objects.requireNonNull(pageContext);
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final BdUniqueId k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getUniqueId();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeL.objValue;
    }

    public View l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (this.d == null) {
                if (z) {
                    this.e = new ShareScrollableLayout(this.c);
                } else {
                    this.e = new ShareGridLayout(this.c);
                }
                this.e.setItemParams(v, w);
                this.d = this.e.getView();
            }
            return this.d;
        }
        return (View) invokeZ.objValue;
    }

    public final void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && i == 13) {
            s();
            w(13);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            sy4 sy4Var = new sy4(this.c, null);
            ShareItem shareItem = this.f;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            if (i == 4) {
                x("share_to_weixin", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, ThirdPartyUtil.TYPE_WEIXIN);
                A(shareItem, 4);
                if (shareItem != null) {
                    sy4Var.t(shareItem);
                }
            } else if (i == 3) {
                x("share_to_pyq", new Object[0]);
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "pyq");
                A(shareItem, 3);
                if (shareItem != null) {
                    if (shareItem.b) {
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    sy4Var.u(shareItem);
                }
            } else if (i == 9) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, LoginConstants.QQ_LOGIN);
                if (zj8.b(this.c, "com.tencent.mobileqq")) {
                    x("share_to_qq_friend", new Object[0]);
                    A(shareItem, 9);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        sy4Var.o(shareItem);
                    }
                } else {
                    Context context = this.c;
                    BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f1130)).q();
                }
            } else if (i == 5) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "qqzone");
                if (zj8.b(this.c, "com.tencent.mobileqq")) {
                    x("share_to_qzone", new Object[0]);
                    A(shareItem, 5);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        sy4Var.p(shareItem);
                    }
                } else {
                    Context context2 = this.c;
                    BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f1130)).q();
                }
            } else if (i == 7) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "weibo");
                try {
                    if (!WbSdk.isWbInstall(this.c)) {
                        WbSdk.install(this.c, new AuthInfo(this.c, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
                x("share_to_sweibo", new Object[0]);
                A(shareItem, 7);
                if (shareItem != null) {
                    if (!shareItem.a) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    sy4Var.r(shareItem);
                }
            } else if (i == 10) {
                statisticItem.param(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                A(shareItem, 10);
                String v2 = sy4.v(shareItem.t, shareItem.K, UtilHelper.isVideoThread(shareItem.M));
                shareItem.t = v2;
                di.a(v2);
                oi.N(this.c.getApplicationContext(), this.c.getResources().getString(R.string.obfuscated_res_0x7f0f043f));
                y(shareItem);
                if (shareItem != null && shareItem.a) {
                    z(8, shareItem.C);
                }
            }
            if (shareItem.E != 8 || shareItem.U <= 0) {
                return;
            }
            statisticItem.param("obj_type", "2");
            statisticItem.param("room_id", shareItem.U);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10 : invokeI.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            gr8 gr8Var = this.g;
            if (gr8Var != null) {
                gr8Var.a(view2);
            }
            if (view2.getTag() instanceof Integer) {
                Integer num = (Integer) view2.getTag();
                if (!mi.z() && num.intValue() != 10) {
                    oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                } else if (num.intValue() == 14) {
                    View.OnClickListener onClickListener2 = this.h;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view2);
                    }
                } else if (num.intValue() == 16) {
                    if (ViewHelper.checkUpIsLogin(this.c)) {
                        if (this.l.f()) {
                            this.l.e();
                        } else {
                            this.l.d();
                        }
                    }
                } else if (num.intValue() == 17) {
                    if (ViewHelper.checkUpIsLogin(this.c)) {
                        if (this.m == null && (runTask = MessageManager.getInstance().runTask(2921343, kr8.class, this.c)) != null) {
                            this.m = (kr8) runTask.getData();
                        }
                        kr8 kr8Var = this.m;
                        if (kr8Var != null) {
                            kr8Var.b(k(this.c));
                            this.m.a(this.f.X);
                        }
                    }
                } else {
                    if (num.intValue() == 18) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.TRUE));
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_IMMERSION_VIDEO_SHARE_DIALOG_MUSK_CLiCK);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        ShareItem shareItem = this.f;
                        if (shareItem != null) {
                            statisticItem.param("tid", shareItem.K);
                            statisticItem.param("fid", this.f.J);
                            statisticItem.param("fname", this.f.p);
                        }
                        TiebaStatic.log(statisticItem);
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.f.K);
                        statisticItem2.param("fid", this.f.J);
                        statisticItem2.param("fname", this.f.p);
                        statisticItem2.param("obj_source", 4);
                        TiebaStatic.log(statisticItem2);
                    } else if (num.intValue() == 19) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921607, Boolean.FALSE));
                    } else if (num.intValue() == 20) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        ShareItem shareItem2 = this.f;
                        String str = shareItem2.Z;
                        String str2 = shareItem2.a0;
                        String str3 = shareItem2.X;
                        String str4 = shareItem2.Y;
                        Context context = this.c;
                        ShareItem shareItem3 = this.f;
                        new ForbidActivityConfig(context, shareItem3.J, shareItem3.p, shareItem3.K, currentAccount, str, str2, str3, str4).start();
                    } else if (num.intValue() == 21) {
                        a55 h = h();
                        ShareItem shareItem4 = this.f;
                        h.b(shareItem4.J, shareItem4.p, shareItem4.K, this.o);
                    } else if (num.intValue() == 22) {
                        a55 h2 = h();
                        ShareItem shareItem5 = this.f;
                        h2.a(shareItem5.J, shareItem5.p, shareItem5.K, this.p);
                    } else if (num.intValue() == 23) {
                        if (ViewHelper.checkUpIsLogin(this.c) && (onClickListener = this.j) != null) {
                            onClickListener.onClick(view2);
                            return;
                        }
                        return;
                    }
                    if (num.intValue() == 14) {
                        View.OnClickListener onClickListener3 = this.h;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view2);
                        }
                    } else if (num.intValue() == 15) {
                        View.OnClickListener onClickListener4 = this.i;
                        if (onClickListener4 != null) {
                            onClickListener4.onClick(view2);
                        }
                    } else if (o(num.intValue())) {
                        n(num.intValue());
                    } else {
                        m(num.intValue());
                    }
                }
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!"frs".equals(this.n) || this.f == null) {
                return false;
            }
            return (hd6.g() || r()) && hd6.d(hd6.a()) && StringHelper.equals(this.f.J, hd6.c());
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ShareItem shareItem = this.f;
            return shareItem != null && shareItem.G == 11;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.c, 25018);
            selectForumActivityConfig.setIsShare(true);
            selectForumActivityConfig.setForumList(this.b);
            if (this.k) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f.w);
                selectForumActivityConfig.setMoreForumUrl(this.f.t);
                selectForumActivityConfig.setMoreForumTitle(this.f.r);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f.W;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f.W.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f.W.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f.T);
            selectForumActivityConfig.setPrivateThread(this.a);
            if (!StringUtils.isNull(this.q)) {
                selectForumActivityConfig.setTopicId(this.q);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public void u(gr8 gr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gr8Var) == null) {
            this.g = gr8Var;
        }
    }

    public void v(ShareDialogConfig shareDialogConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, shareDialogConfig, z) == null) {
            this.f = shareDialogConfig.shareItem;
            this.b = shareDialogConfig.mForumList;
            this.a = shareDialogConfig.mPrivateThread;
            this.h = shareDialogConfig.disLikeListener;
            this.i = shareDialogConfig.closeAdListener;
            this.j = shareDialogConfig.heatingListener;
            this.q = shareDialogConfig.topicId;
            this.e.removeAllViews();
            this.k = shareDialogConfig.mShowMoreForumShare;
            this.n = shareDialogConfig.getPrePage();
            this.o = shareDialogConfig.isMadeTop;
            this.p = shareDialogConfig.isAddedGood;
            if (this.k) {
                e(new SvgMaskType(R.drawable.obfuscated_res_0x7f080827), R.string.obfuscated_res_0x7f0f1150, 4, 0);
                e(new SvgMaskType(R.drawable.obfuscated_res_0x7f080823), R.string.obfuscated_res_0x7f0f1157, 3, 0);
                e(new SvgMaskType(R.drawable.obfuscated_res_0x7f080824), R.string.obfuscated_res_0x7f0f112f, 9, 0);
                e(new SvgMaskType(R.drawable.obfuscated_res_0x7f080825), R.string.obfuscated_res_0x7f0f1133, 5, 0);
                e(new SvgMaskType(R.drawable.obfuscated_res_0x7f080828), R.string.obfuscated_res_0x7f0f113e, 7, 0);
                c(R.string.obfuscated_res_0x7f0f0acf, R.drawable.obfuscated_res_0x7f080992, 13, 0);
                return;
            }
            if (this.f.f0) {
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080827), R.string.obfuscated_res_0x7f0f1150, 4, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080823), R.string.obfuscated_res_0x7f0f1157, 3, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080824), R.string.obfuscated_res_0x7f0f112f, 9, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080825), R.string.obfuscated_res_0x7f0f1133, 5, shareDialogConfig.isShowNovelMask(), 0);
                f(new SvgMaskType(R.drawable.obfuscated_res_0x7f080828), R.string.obfuscated_res_0x7f0f113e, 7, shareDialogConfig.isShowNovelMask(), 0);
                d(R.string.obfuscated_res_0x7f0f1118, R.drawable.obfuscated_res_0x7f08098b, 10, shareDialogConfig.isShowNovelMask(), 1);
            }
            boolean isPrePagePersonalPage = shareDialogConfig.isPrePagePersonalPage();
            boolean z2 = shareDialogConfig.isHost;
            if (shareDialogConfig.isFromImmersionVideo) {
                if (!isPrePagePersonalPage && p()) {
                    c(R.string.obfuscated_res_0x7f0f06a2, R.drawable.obfuscated_res_0x7f080955, 18, 1);
                }
                if (shareDialogConfig.isCollected) {
                    g(R.string.obfuscated_res_0x7f0f0a81, R.drawable.obfuscated_res_0x7f08098a, 0, 16, 1);
                } else {
                    c(R.string.obfuscated_res_0x7f0f0a81, R.drawable.obfuscated_res_0x7f080989, 16, 1);
                }
                if (!z2) {
                    c(R.string.obfuscated_res_0x7f0f0fa9, R.drawable.obfuscated_res_0x7f080995, 17, 1);
                } else if (isPrePagePersonalPage) {
                    c(R.string.obfuscated_res_0x7f0f0495, R.drawable.obfuscated_res_0x7f08098c, 19, 1);
                }
            }
            if (shareDialogConfig.showDisLike && !isPrePagePersonalPage) {
                c(R.string.obfuscated_res_0x7f0f0c77, R.drawable.obfuscated_res_0x7f080996, 14, 1);
            }
            if (this.f.g0) {
                c(R.string.obfuscated_res_0x7f0f03e9, R.drawable.obfuscated_res_0x7f080996, 15, 1);
            }
            if (shareDialogConfig.showHeating) {
                c(shareDialogConfig.isSelfHeating ? R.string.obfuscated_res_0x7f0f081c : R.string.obfuscated_res_0x7f0f081d, R.drawable.obfuscated_res_0x7f080990, 23, 1);
            }
            if (z) {
                c(R.string.obfuscated_res_0x7f0f0acf, R.drawable.obfuscated_res_0x7f080992, 13, 1);
            }
            if (shareDialogConfig.isFromImmersionVideo) {
                tg5 tg5Var = new tg5(this.c);
                this.l = tg5Var;
                tg5Var.i(this.u);
                this.l.g(shareDialogConfig.isCollected);
                this.l.h(i());
            }
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || this.f == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f.J).param("tid", this.f.K).param("obj_type", i).param("obj_source", this.f.E).param("obj_param1", this.f.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f.G));
        int i2 = this.f.M;
        int i3 = 0;
        int i4 = i2 == 5 ? 1 : i2 == 6 ? 2 : i2 == 7 ? 3 : i2 == 8 ? 4 : 0;
        int i5 = this.f.E;
        if (i5 == 4) {
            i3 = 1;
        } else if (i5 == 3) {
            i3 = 2;
        } else if (i5 == 8) {
            i3 = 3;
        } else if (i5 == 6) {
            i3 = 4;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TRANSFER_BTN_CLICK).param("obj_locate", i != 11 ? 1 : 2).param("obj_source", i3).param("obj_type", i4));
    }

    public final void x(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.c, str, "click", 1, objArr);
        }
    }

    public final void y(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i = shareItem.F;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.F;
                if (i2 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i2 == 3) {
                    int i3 = shareItem.M;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void z(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i, str) == null) {
            TiebaStatic.eventStat(this.c, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }
}
