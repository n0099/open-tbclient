package d.b.i0.j3;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.s.g.g;
import d.b.i0.c3.z;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b implements View.OnClickListener {
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    public static final int n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);

    /* renamed from: e  reason: collision with root package name */
    public int f56407e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f56408f;

    /* renamed from: g  reason: collision with root package name */
    public Context f56409g;

    /* renamed from: h  reason: collision with root package name */
    public ShareGridLayout f56410h;
    public ShareItem i;
    public d.b.i0.j3.a j;
    public boolean k = false;
    public CustomMessageListener l = new a(2016563);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            b.this.f56408f = (ArrayList) customResponsedMessage.getData();
        }
    }

    public b(Context context) {
        this.f56409g = context;
        MessageManager.getInstance().registerListener(this.l);
    }

    public final void b(int i, int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f56409g);
        shareDialogItemView.setItemIcon(i2, SkinManager.getColor(R.color.CAM_X0107), i3);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f56410h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public final void c(AbsSvgType absSvgType, int i, int i2) {
        if (absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f56409g);
        shareDialogItemView.setItemIcon(absSvgType, i2);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        ShareGridLayout shareGridLayout = this.f56410h;
        shareDialogItemView.a();
        shareGridLayout.addView(shareDialogItemView);
    }

    public ShareGridLayout d() {
        if (this.f56410h == null) {
            h();
        }
        return this.f56410h;
    }

    public final void e(int i) {
        if (i == 13) {
            j();
            n(13);
        }
    }

    public final void f(int i) {
        g gVar = new g(this.f56409g, null);
        ShareItem shareItem = this.i;
        if (i == 4) {
            o("share_to_weixin", new Object[0]);
            r(shareItem, 4);
            if (shareItem != null) {
                gVar.m(shareItem);
            }
        } else if (i == 3) {
            o("share_to_pyq", new Object[0]);
            r(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.f13713b) {
                    shareItem.s = "【" + shareItem.r + "】 " + shareItem.s;
                }
                gVar.n(shareItem);
            }
        } else if (i == 9) {
            if (z.b(this.f56409g, "com.tencent.mobileqq")) {
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
            Context context = this.f56409g;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i == 5) {
            if (z.b(this.f56409g, "com.tencent.mobileqq")) {
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
            Context context2 = this.f56409g;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        } else if (i != 7) {
            if (i == 10) {
                r(shareItem, 10);
                String o = g.o(shareItem.t, shareItem.J);
                shareItem.t = o;
                d.b.b.e.p.a.a(o);
                l.L(this.f56409g.getApplicationContext(), this.f56409g.getResources().getString(R.string.copy_pb_url_success));
                p(shareItem);
                if (shareItem == null || !shareItem.f13712a) {
                    return;
                }
                q(8, shareItem.B);
            }
        } else {
            try {
                if (!WbSdk.isWbInstall(this.f56409g)) {
                    WbSdk.install(this.f56409g, new AuthInfo(this.f56409g, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            o("share_to_sweibo", new Object[0]);
            r(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.f13712a) {
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
        ShareGridLayout shareGridLayout = new ShareGridLayout(this.f56409g);
        this.f56410h = shareGridLayout;
        shareGridLayout.setItemParams(m, n);
    }

    public final boolean i(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    public final void j() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f56409g, 25018);
        selectForumActivityConfig.setForumList(this.f56408f);
        if (this.k) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.i.w);
            selectForumActivityConfig.setMoreForumUrl(this.i.t);
            selectForumActivityConfig.setMoreForumTitle(this.i.r);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        ShareItem.ForwardInfo forwardInfo = this.i.T;
        if (forwardInfo != null) {
            selectForumActivityConfig.setBaijiahaoData(forwardInfo.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.i.T.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.i.T.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.i.S);
        selectForumActivityConfig.setPrivateThread(this.f56407e);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public void l(d.b.i0.j3.a aVar) {
        this.j = aVar;
    }

    public void m(ShareDialogConfig shareDialogConfig, boolean z) {
        this.i = shareDialogConfig.shareItem;
        this.f56408f = shareDialogConfig.mForumList;
        this.f56407e = shareDialogConfig.mPrivateThread;
        this.f56410h.removeAllViews();
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
        if (this.i.Y) {
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

    public final void n(int i) {
        if (this.i == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.i.I).param("tid", this.i.J).param("obj_type", i).param("obj_source", this.i.D).param("obj_param1", this.i.E));
        int i2 = this.i.L;
        int i3 = 0;
        int i4 = i2 == 5 ? 1 : i2 == 6 ? 2 : i2 == 7 ? 3 : i2 == 8 ? 4 : 0;
        int i5 = this.i.D;
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

    public final void o(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f56409g, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.j3.a aVar = this.j;
        if (aVar != null) {
            aVar.a(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.z() && num.intValue() != 10) {
                l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (i(num.intValue())) {
                f(num.intValue());
            } else {
                e(num.intValue());
            }
        }
    }

    public final void p(ShareItem shareItem) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
        int i = shareItem.E;
        if (i != 0) {
            param.param("obj_param1", i);
            int i2 = shareItem.E;
            if (i2 == 2) {
                param.param("fid", shareItem.I);
            } else if (i2 == 3) {
                int i3 = shareItem.L;
                if (i3 != 0) {
                    param.param("obj_type", i3);
                }
                param.param("tid", shareItem.J).param("fid", shareItem.I);
            }
        }
        param.param("obj_locate", 9);
        TiebaStatic.log(param);
    }

    public final void q(int i, String str) {
        TiebaStatic.eventStat(this.f56409g, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void r(ShareItem shareItem, int i) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f13713b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i));
        } else if (!shareItem.f13714c && !shareItem.f13717f) {
            if (shareItem.f13715d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.f13712a) {
                q(i, shareItem.B);
            } else if (shareItem.f13716e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.f13718g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.D);
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.D).param("obj_param1", shareItem.E).param("fid", shareItem.I).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.F));
        }
    }
}
