package d.a.n0.l3;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.s.g.g;
import d.a.n0.e3.z;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b implements View.OnClickListener {
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    public static final int n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);

    /* renamed from: e  reason: collision with root package name */
    public int f57187e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f57188f;

    /* renamed from: g  reason: collision with root package name */
    public Context f57189g;

    /* renamed from: h  reason: collision with root package name */
    public ShareGridLayout f57190h;

    /* renamed from: i  reason: collision with root package name */
    public ShareItem f57191i;
    public d.a.n0.l3.a j;
    public boolean k = false;
    public CustomMessageListener l = new a(2016563);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            b.this.f57188f = (ArrayList) customResponsedMessage.getData();
        }
    }

    public b(Context context) {
        this.f57189g = context;
        MessageManager.getInstance().registerListener(this.l);
    }

    public final void b(int i2, int i3, int i4) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f57189g);
        shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107), i4);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f57190h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public final void c(AbsSvgType absSvgType, int i2, int i3) {
        if (absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f57189g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f57190h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public ShareGridLayout d() {
        if (this.f57190h == null) {
            g();
        }
        return this.f57190h;
    }

    public final void e(int i2) {
        if (i2 == 13) {
            i();
            m(13);
        }
    }

    public final void f(int i2) {
        g gVar = new g(this.f57189g, null);
        ShareItem shareItem = this.f57191i;
        if (i2 == 4) {
            n("share_to_weixin", new Object[0]);
            q(shareItem, 4);
            if (shareItem != null) {
                gVar.m(shareItem);
            }
        } else if (i2 == 3) {
            n("share_to_pyq", new Object[0]);
            q(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.f12596b) {
                    shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                }
                gVar.n(shareItem);
            }
        } else if (i2 == 9) {
            if (z.b(this.f57189g, "com.tencent.mobileqq")) {
                n("share_to_qq_friend", new Object[0]);
                q(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                        shareItem.s = "";
                    }
                    gVar.h(shareItem);
                    return;
                }
                return;
            }
            Context context = this.f57189g;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i2 == 5) {
            if (z.b(this.f57189g, "com.tencent.mobileqq")) {
                n("share_to_qzone", new Object[0]);
                q(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                        shareItem.s = "";
                    }
                    gVar.i(shareItem);
                    return;
                }
                return;
            }
            Context context2 = this.f57189g;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        } else if (i2 != 7) {
            if (i2 == 10) {
                q(shareItem, 10);
                String o = g.o(shareItem.t, shareItem.K);
                shareItem.t = o;
                d.a.c.e.p.a.a(o);
                l.M(this.f57189g.getApplicationContext(), this.f57189g.getResources().getString(R.string.copy_pb_url_success));
                o(shareItem);
                if (shareItem == null || !shareItem.f12595a) {
                    return;
                }
                p(8, shareItem.C);
            }
        } else {
            try {
                if (!WbSdk.isWbInstall(this.f57189g)) {
                    WbSdk.install(this.f57189g, new AuthInfo(this.f57189g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            n("share_to_sweibo", new Object[0]);
            q(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.f12595a) {
                    if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                        shareItem.s = "";
                    }
                    shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                }
                gVar.k(shareItem);
            }
        }
    }

    public final void g() {
        ShareGridLayout shareGridLayout = new ShareGridLayout(this.f57189g);
        this.f57190h = shareGridLayout;
        shareGridLayout.setItemParams(m, n);
    }

    public final boolean h(int i2) {
        return i2 == 4 || i2 == 3 || i2 == 9 || i2 == 5 || i2 == 7 || i2 == 10;
    }

    public final void i() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f57189g, 25018);
        selectForumActivityConfig.setForumList(this.f57188f);
        if (this.k) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.f57191i.w);
            selectForumActivityConfig.setMoreForumUrl(this.f57191i.t);
            selectForumActivityConfig.setMoreForumTitle(this.f57191i.r);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        ShareItem.ForwardInfo forwardInfo = this.f57191i.U;
        if (forwardInfo != null) {
            selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.f57191i.U.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f57191i.U.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.f57191i.T);
        selectForumActivityConfig.setPrivateThread(this.f57187e);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
    }

    public void j() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public void k(d.a.n0.l3.a aVar) {
        this.j = aVar;
    }

    public void l(ShareDialogConfig shareDialogConfig, boolean z) {
        this.f57191i = shareDialogConfig.shareItem;
        this.f57188f = shareDialogConfig.mForumList;
        this.f57187e = shareDialogConfig.mPrivateThread;
        this.f57190h.removeAllViews();
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
        if (this.f57191i.a0) {
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

    public final void m(int i2) {
        if (this.f57191i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f57191i.J).param("tid", this.f57191i.K).param("obj_type", i2).param("obj_source", this.f57191i.E).param("obj_param1", this.f57191i.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f57191i.G));
        int i3 = this.f57191i.M;
        int i4 = 0;
        int i5 = i3 == 5 ? 1 : i3 == 6 ? 2 : i3 == 7 ? 3 : i3 == 8 ? 4 : 0;
        int i6 = this.f57191i.E;
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

    public final void n(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f57189g, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    public final void o(ShareItem shareItem) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.l3.a aVar = this.j;
        if (aVar != null) {
            aVar.a(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.z() && num.intValue() != 10) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (h(num.intValue())) {
                f(num.intValue());
            } else {
                e(num.intValue());
            }
        }
    }

    public final void p(int i2, String str) {
        TiebaStatic.eventStat(this.f57189g, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void q(ShareItem shareItem, int i2) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f12596b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f12597c && !shareItem.f12600f) {
            if (shareItem.f12598d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12595a) {
                p(i2, shareItem.C);
            } else if (shareItem.f12599e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f12601g) {
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
