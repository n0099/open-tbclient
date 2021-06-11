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
    public int f60876e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f60877f;

    /* renamed from: g  reason: collision with root package name */
    public Context f60878g;

    /* renamed from: h  reason: collision with root package name */
    public ShareGridLayout f60879h;

    /* renamed from: i  reason: collision with root package name */
    public ShareItem f60880i;
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
            b.this.f60877f = (ArrayList) customResponsedMessage.getData();
        }
    }

    public b(Context context) {
        this.f60878g = context;
        MessageManager.getInstance().registerListener(this.l);
    }

    public final void b(int i2, int i3, int i4) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f60878g);
        shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107), i4);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f60879h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public final void c(AbsSvgType absSvgType, int i2, int i3) {
        if (absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f60878g);
        shareDialogItemView.setItemIcon(absSvgType, i3);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f60879h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public ShareGridLayout d() {
        if (this.f60879h == null) {
            h();
        }
        return this.f60879h;
    }

    public final void e(int i2) {
        if (i2 == 13) {
            j();
            n(13);
        }
    }

    public final void f(int i2) {
        g gVar = new g(this.f60878g, null);
        ShareItem shareItem = this.f60880i;
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
                if (shareItem.f12658b) {
                    shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                }
                gVar.n(shareItem);
            }
        } else if (i2 == 9) {
            if (z.b(this.f60878g, "com.tencent.mobileqq")) {
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
            Context context = this.f60878g;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i2 == 5) {
            if (z.b(this.f60878g, "com.tencent.mobileqq")) {
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
            Context context2 = this.f60878g;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        } else if (i2 != 7) {
            if (i2 == 10) {
                r(shareItem, 10);
                String o = g.o(shareItem.t, shareItem.K);
                shareItem.t = o;
                d.a.c.e.p.a.a(o);
                l.M(this.f60878g.getApplicationContext(), this.f60878g.getResources().getString(R.string.copy_pb_url_success));
                p(shareItem);
                if (shareItem == null || !shareItem.f12657a) {
                    return;
                }
                q(8, shareItem.C);
            }
        } else {
            try {
                if (!WbSdk.isWbInstall(this.f60878g)) {
                    WbSdk.install(this.f60878g, new AuthInfo(this.f60878g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            o("share_to_sweibo", new Object[0]);
            r(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.f12657a) {
                    if (!StringUtils.isNull(shareItem.r) && !StringUtils.isNull(shareItem.s) && shareItem.r.trim().equals(shareItem.s.trim())) {
                        shareItem.s = "";
                    }
                    shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                }
                gVar.k(shareItem);
            }
        }
    }

    public final void h() {
        ShareGridLayout shareGridLayout = new ShareGridLayout(this.f60878g);
        this.f60879h = shareGridLayout;
        shareGridLayout.setItemParams(m, n);
    }

    public final boolean i(int i2) {
        return i2 == 4 || i2 == 3 || i2 == 9 || i2 == 5 || i2 == 7 || i2 == 10;
    }

    public final void j() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f60878g, 25018);
        selectForumActivityConfig.setForumList(this.f60877f);
        if (this.k) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.f60880i.w);
            selectForumActivityConfig.setMoreForumUrl(this.f60880i.t);
            selectForumActivityConfig.setMoreForumTitle(this.f60880i.r);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        ShareItem.ForwardInfo forwardInfo = this.f60880i.U;
        if (forwardInfo != null) {
            selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.f60880i.U.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.f60880i.U.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.f60880i.T);
        selectForumActivityConfig.setPrivateThread(this.f60876e);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public void l(d.a.n0.l3.a aVar) {
        this.j = aVar;
    }

    public void m(ShareDialogConfig shareDialogConfig, boolean z) {
        this.f60880i = shareDialogConfig.shareItem;
        this.f60877f = shareDialogConfig.mForumList;
        this.f60876e = shareDialogConfig.mPrivateThread;
        this.f60879h.removeAllViews();
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
        if (this.f60880i.a0) {
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

    public final void n(int i2) {
        if (this.f60880i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f60880i.J).param("tid", this.f60880i.K).param("obj_type", i2).param("obj_source", this.f60880i.E).param("obj_param1", this.f60880i.F).param(TiebaStatic.Params.OBJ_PARAM2, this.f60880i.G));
        int i3 = this.f60880i.M;
        int i4 = 0;
        int i5 = i3 == 5 ? 1 : i3 == 6 ? 2 : i3 == 7 ? 3 : i3 == 8 ? 4 : 0;
        int i6 = this.f60880i.E;
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
        TiebaStatic.eventStat(this.f60878g, str, PrefetchEvent.STATE_CLICK, 1, objArr);
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
            } else if (i(num.intValue())) {
                f(num.intValue());
            } else {
                e(num.intValue());
            }
        }
    }

    public final void p(ShareItem shareItem) {
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

    public final void q(int i2, String str) {
        TiebaStatic.eventStat(this.f60878g, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void r(ShareItem shareItem, int i2) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f12658b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f12659c && !shareItem.f12662f) {
            if (shareItem.f12660d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12657a) {
                q(i2, shareItem.C);
            } else if (shareItem.f12661e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f12663g) {
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
