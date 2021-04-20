package d.b.i0.v3;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.c.e.p.k;
import d.b.h0.r.s.a;
import d.b.i0.v3.a;
import d.b.i0.v3.h;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63258a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f63259b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.v3.a f63260c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63261d;

    /* renamed from: e  reason: collision with root package name */
    public h f63262e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f63263f;

    /* renamed from: g  reason: collision with root package name */
    public int f63264g;

    /* renamed from: h  reason: collision with root package name */
    public String f63265h;
    public String i;
    public int j;
    public String k;
    public int l;
    public d.b.h0.m0.o.a m;
    public boolean n;
    public h.a o;
    public ItemInfo p;

    /* loaded from: classes5.dex */
    public class a implements h.a {
        public a() {
        }

        @Override // d.b.i0.v3.h.a
        public void a(int i) {
            if (i == 1) {
                g.this.f63261d = true;
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.f63262e instanceof d.b.i0.v3.d)) {
                    if (g.this.m == null) {
                        g.this.m = new d.b.h0.m0.o.a("anim_switch_sendthread_maintab");
                    }
                    g.this.m.b();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
            } else if (i == 2) {
                if (g.this.m != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.f63262e instanceof d.b.i0.v3.d)) {
                    g.this.m.c();
                }
                g.this.K();
            } else if (i == 4) {
                g.this.f63261d = false;
                if (g.this.f63260c.f63177a.getParent() == g.this.f63259b && g.this.f63259b != null && g.this.f63260c.f63177a != null && g.this.f63259b.indexOfChild(g.this.f63260c.f63177a) > 0) {
                    g.this.f63259b.removeView(g.this.f63260c.f63177a);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f63267e;

        public b(d.b.h0.r.s.a aVar) {
            this.f63267e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = this.f63267e;
            if (aVar != null) {
                aVar.dismiss();
                d.b.h0.r.d0.b.j().t("commodity_goods_show_first_dialog", true);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", g.this.f63263f.forumId).param("fname", g.this.f63263f.forumName));
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(g gVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f63269a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63270b;

        public d(ForumWriteData forumWriteData, String str) {
            this.f63269a = forumWriteData;
            this.f63270b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.b.c.e.i.a.l().h(false);
            ForumWriteData forumWriteData = this.f63269a;
            if (forumWriteData != null) {
                String str4 = forumWriteData.forumId;
                String str5 = forumWriteData.forumName;
                str3 = forumWriteData.specialForumType;
                str = str4;
                str2 = str5;
            } else {
                str = "0";
                str2 = null;
                str3 = null;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f63270b).param("obj_type", 4));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(g.this.f63258a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteActivityConfig f63272a;

        public e(WriteActivityConfig writeActivityConfig) {
            this.f63272a = writeActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f63272a));
        }
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public static boolean z(Activity activity, WriteActivityConfig writeActivityConfig) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new e(writeActivityConfig));
        return permissionJudgePolicy.startRequestPermission(activity);
    }

    public void A() {
        d.b.i0.v3.a aVar = this.f63260c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void B(boolean z) {
        this.n = z;
    }

    public void C(ForumWriteData forumWriteData) {
        this.f63263f = forumWriteData;
    }

    public void D(ItemInfo itemInfo) {
        this.p = itemInfo;
    }

    public void E(boolean z) {
        d.b.i0.v3.a aVar = this.f63260c;
        if (aVar instanceof a.d) {
            ((a.d) aVar).e(z);
        }
    }

    public void F(String str) {
        this.k = str;
    }

    public void G(int i) {
        d.b.i0.v3.a aVar = this.f63260c;
        if (aVar instanceof a.d) {
            ((a.d) aVar).B.setIconFade(i);
        }
    }

    public void H(String str) {
        if (str == null) {
            str = "";
        }
        this.f63265h = str;
    }

    public void I(int i) {
        this.l = i;
    }

    public void J(boolean z, View view, View view2) {
        AntiData antiData;
        if (this.f63259b == null) {
            return;
        }
        if (this.f63260c.f63177a.getParent() == null) {
            d.b.h0.d0.e.a(this.f63259b).a(this.f63259b, this.f63260c.f63177a, z);
        }
        this.f63262e.a(view, view2);
        this.f63262e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (d.b.c.e.p.j.x()) {
            String p = d.b.h0.r.d0.b.j().p("key_baidu_sim_card_writting_tip", "");
            if (!k.isEmpty(p)) {
                BdToast.c(this.f63258a.getContext(), p).q();
                d.b.h0.r.d0.b.j().C("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f63263f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f63263f.forumId).param("fname", this.f63263f.forumName));
    }

    public final void K() {
        boolean g2 = d.b.h0.r.d0.b.j().g("home_publish_ala_has_showed", false);
        d.b.i0.v3.a aVar = this.f63260c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).e(!g2);
        }
        d.b.h0.r.d0.b.j().t("home_publish_ala_has_showed", true);
    }

    public int j() {
        return this.l;
    }

    public String k() {
        return this.i;
    }

    public String l() {
        return this.f63265h;
    }

    public final boolean m() {
        FrsTabInfoData frsTabInfoData;
        ForumWriteData forumWriteData = this.f63263f;
        if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            for (FrsTabItemData frsTabItemData : this.f63263f.frsTabInfo.tabList) {
                if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void n(boolean z) {
        this.f63262e.b(z);
        if (z) {
            return;
        }
        d.b.i0.v3.a aVar = this.f63260c;
        if (aVar instanceof a.d) {
            ((a.d) aVar).B.h();
        }
    }

    public boolean o() {
        return this.f63261d;
    }

    public void p() {
        if (this.f63260c instanceof a.c) {
            TiebaStatic.log(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK);
            K();
        }
        n(false);
        if (Build.VERSION.SDK_INT < 21) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f63258a.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.f63258a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new c(this));
            aVar.create(this.f63258a).show();
            return;
        }
        y(this.f63258a, this.k, this.f63263f);
    }

    public void q() {
        n(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f63258a.getPageActivity()).setType(0).setForumWriteData(this.f63263f).setFrom(this.i).setTitle(this.f63265h).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.j);
        if (z(this.f63258a.getPageActivity(), statisticFrom)) {
            return;
        }
        statisticFrom.send();
    }

    public void r(String str) {
        n(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 1));
        WriteActivityConfig.newInstance(this.f63258a.getPageActivity()).setType(9).setForumWriteData(this.f63263f).setFrom(this.i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).send();
    }

    public void s(int i) {
        if (this.f63264g != i) {
            this.f63264g = i;
            this.f63260c.c(i);
        }
    }

    public void t() {
        if (!m()) {
            BdToast.i(this.f63258a.getPageActivity(), this.f63258a.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (!this.n) {
            BdToast.i(this.f63258a.getPageActivity(), this.f63258a.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else {
            if (this.f63263f != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f63263f.forumId).param("fname", this.f63263f.forumName));
            }
            n(false);
            if (!d.b.h0.r.d0.b.j().g("commodity_goods_show_first_dialog", false)) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f63258a.getPageActivity());
                aVar.setContentViewSize(2);
                aVar.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.f63258a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(aVar));
                aVar.setContentView(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1).param("fid", this.f63263f.forumId).param("fname", this.f63263f.forumName));
                aVar.create(this.f63258a).show();
                return;
            }
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    public void u() {
        View view = this.f63260c.f63177a;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = this.f63259b;
            if (parent == viewGroup) {
                viewGroup.removeView(this.f63260c.f63177a);
            }
        }
        this.f63262e.d();
    }

    public void v() {
        n(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
        if (this.f63263f == null) {
            this.f63263f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f63263f;
        forumWriteData.mFrom = this.i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        j.d(this.f63258a, "", forumWriteData);
    }

    public void w(String str) {
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
        n(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.f63258a.getPageActivity(), 25048);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.f63263f == null) {
            this.f63263f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f63263f;
        forumWriteData.mFrom = this.i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        writeVoteActivityConfig.setExtraData(forumWriteData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
    }

    public void x() {
        n(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f63258a.getPageActivity()).setType(9).setForumWriteData(this.f63263f).setIsEvaluate(true).setFrom(this.i).setCallFrom("2").setStatisticFrom(this.j);
        ItemInfo itemInfo = this.p;
        if (itemInfo != null) {
            statisticFrom.setScoreItemInfo(new SerializableItemInfo(itemInfo)).setItemIsSchool(this.p.is_school.intValue() == 1).setStarCount(this.p.score.comment_star.intValue());
        }
        statisticFrom.send();
    }

    public void y(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new d(forumWriteData, str));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        int i2 = 0;
        this.f63261d = false;
        this.f63264g = 3;
        this.f63265h = "";
        this.i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.n = false;
        this.o = new a();
        this.f63258a = tbPageContext;
        this.f63259b = viewGroup;
        this.i = str;
        if ("main_tab".equals(str)) {
            i2 = 1;
        } else if ("frs".equals(this.i)) {
            i2 = 2;
        }
        this.j = i2;
        if (i == 2) {
            a.c cVar = new a.c(this.f63258a, this);
            this.f63260c = cVar;
            this.f63262e = new d.b.i0.v3.d(tbPageContext.getPageActivity(), cVar);
        } else if (i == 3) {
            a.b bVar = new a.b(this.f63258a, this);
            this.f63260c = bVar;
            this.f63262e = new f(tbPageContext.getPageActivity(), bVar);
        } else {
            a.d dVar = new a.d(this.f63258a, this);
            this.f63260c = dVar;
            this.f63262e = new d.b.i0.v3.e(tbPageContext.getPageActivity(), dVar);
        }
        s(TbadkCoreApplication.getInst().getSkinType());
        this.f63262e.e(this.o);
    }
}
