package d.a.s0.o3;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.s.g.g;
import d.a.s0.h3.z;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f64333e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f64334f;

    /* renamed from: g  reason: collision with root package name */
    public Context f64335g;

    /* renamed from: h  reason: collision with root package name */
    public ShareGridLayout f64336h;

    /* renamed from: i  reason: collision with root package name */
    public ShareItem f64337i;
    public d.a.s0.o3.a j;
    public boolean k;
    public CustomMessageListener l;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64338a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64338a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.f64338a.f64334f = (ArrayList) customResponsedMessage.getData();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630866761, "Ld/a/s0/o3/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-630866761, "Ld/a/s0/o3/b;");
                return;
            }
        }
        m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = new a(this, 2016563);
        this.f64335g = context;
        MessageManager.getInstance().registerListener(this.l);
    }

    public final void b(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f64335g);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107), i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareGridLayout shareGridLayout = this.f64336h;
            shareDialogItemView.a();
            shareGridLayout.addView(shareDialogItemView);
        }
    }

    public final void c(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f64335g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f64336h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public ShareGridLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f64336h == null) {
                h();
            }
            return this.f64336h;
        }
        return (ShareGridLayout) invokeV.objValue;
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && i2 == 13) {
            j();
            n(13);
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            g gVar = new g(this.f64335g, null);
            ShareItem shareItem = this.f64337i;
            if (i2 == 4) {
                o("share_to_weixin", new Object[0]);
                r(shareItem, 4);
                if (shareItem != null) {
                    gVar.m(shareItem);
                }
            } else if (i2 == 3) {
                o("share_to_pyq", new Object[0]);
                r(shareItem, 3);
                if (shareItem != null) {
                    if (shareItem.f12822b) {
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.n(shareItem);
                }
            } else if (i2 == 9) {
                if (z.b(this.f64335g, "com.tencent.mobileqq")) {
                    o("share_to_qq_friend", new Object[0]);
                    r(shareItem, 9);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.h(shareItem);
                        return;
                    }
                    return;
                }
                Context context = this.f64335g;
                BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
            } else if (i2 == 5) {
                if (z.b(this.f64335g, "com.tencent.mobileqq")) {
                    o("share_to_qzone", new Object[0]);
                    r(shareItem, 5);
                    if (shareItem != null) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        gVar.i(shareItem);
                        return;
                    }
                    return;
                }
                Context context2 = this.f64335g;
                BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
            } else if (i2 != 7) {
                if (i2 == 10) {
                    r(shareItem, 10);
                    String o = g.o(shareItem.t, shareItem.K);
                    shareItem.t = o;
                    d.a.c.e.p.a.a(o);
                    l.M(this.f64335g.getApplicationContext(), this.f64335g.getResources().getString(R.string.copy_pb_url_success));
                    p(shareItem);
                    if (shareItem == null || !shareItem.f12821a) {
                        return;
                    }
                    q(8, shareItem.C);
                }
            } else {
                try {
                    if (!WbSdk.isWbInstall(this.f64335g)) {
                        WbSdk.install(this.f64335g, new AuthInfo(this.f64335g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                o("share_to_sweibo", new Object[0]);
                r(shareItem, 7);
                if (shareItem != null) {
                    if (!shareItem.f12821a) {
                        if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                            shareItem.s = "";
                        }
                        shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                    }
                    gVar.k(shareItem);
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ShareGridLayout shareGridLayout = new ShareGridLayout(this.f64335g);
            this.f64336h = shareGridLayout;
            shareGridLayout.setItemParams(m, n);
        }
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == 4 || i2 == 3 || i2 == 9 || i2 == 5 || i2 == 7 || i2 == 10 : invokeI.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f64335g, 25018);
            selectForumActivityConfig.setForumList(this.f64334f);
            if (this.k) {
                selectForumActivityConfig.setFrom(4);
                selectForumActivityConfig.setMoreForumImg(this.f64337i.w);
                selectForumActivityConfig.setMoreForumUrl(this.f64337i.t);
                selectForumActivityConfig.setMoreForumTitle(this.f64337i.r);
            } else {
                selectForumActivityConfig.setFrom(2);
            }
            ShareItem.ForwardInfo forwardInfo = this.f64337i.U;
            if (forwardInfo != null) {
                selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
                selectForumActivityConfig.setTransmitOriginThreadComment(this.f64337i.U.transmitOriginThreadComment);
                selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f64337i.U.transmitThreadAuthorNameShow);
            }
            selectForumActivityConfig.setOriginalThread(this.f64337i.T);
            selectForumActivityConfig.setPrivateThread(this.f64333e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void l(d.a.s0.o3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void m(ShareDialogConfig shareDialogConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, shareDialogConfig, z) == null) {
            this.f64337i = shareDialogConfig.shareItem;
            this.f64334f = shareDialogConfig.mForumList;
            this.f64333e = shareDialogConfig.mPrivateThread;
            this.f64336h.removeAllViews();
            boolean z2 = shareDialogConfig.mShowMoreForumShare;
            this.k = z2;
            if (z2) {
                c(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
                c(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
                c(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
                c(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
                c(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
                b(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
                return;
            }
            if (this.f64337i.a0) {
                c(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
                c(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
                c(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
                c(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
                c(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
                b(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10);
            }
            if (z) {
                b(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
            }
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.f64337i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f64337i.J).param("tid", this.f64337i.K).param("obj_type", i2).param("obj_source", this.f64337i.E).param("obj_param1", this.f64337i.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f64337i.G));
        int i3 = this.f64337i.M;
        int i4 = 0;
        int i5 = i3 == 5 ? 1 : i3 == 6 ? 2 : i3 == 7 ? 3 : i3 == 8 ? 4 : 0;
        int i6 = this.f64337i.E;
        if (i6 == 4) {
            i4 = 1;
        } else if (i6 == 3) {
            i4 = 2;
        } else if (i6 == 8) {
            i4 = 3;
        } else if (i6 == 6) {
            i4 = 4;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TRANSFER_BTN_CLICK).param("obj_locate", i2 != 11 ? 1 : 2).param("obj_source", i4).param("obj_type", i5));
    }

    public final void o(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.f64335g, str, PrefetchEvent.STATE_CLICK, 1, objArr);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            d.a.s0.o3.a aVar = this.j;
            if (aVar != null) {
                aVar.a(view);
            }
            if (view.getTag() instanceof Integer) {
                Integer num = (Integer) view.getTag();
                if (!j.z() && num.intValue() != 10) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (i(num.intValue())) {
                    f(num.intValue());
                } else {
                    e(num.intValue());
                }
            }
        }
    }

    public final void p(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.F;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.F;
                if (i3 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i3 == 3) {
                    int i4 = shareItem.M;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f64335g, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void r(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f12822b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f12823c && !shareItem.f12826f) {
            if (shareItem.f12824d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12821a) {
                q(i2, shareItem.C);
            } else if (shareItem.f12825e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f12827g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                param.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }
}
