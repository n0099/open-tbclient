package d.a.n0.w3;

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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.m0.r.s.a;
import d.a.n0.w3.a;
import d.a.n0.w3.g;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66455a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f66456b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.w3.a f66457c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66458d;

    /* renamed from: e  reason: collision with root package name */
    public g f66459e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f66460f;

    /* renamed from: g  reason: collision with root package name */
    public int f66461g;

    /* renamed from: h  reason: collision with root package name */
    public String f66462h;

    /* renamed from: i  reason: collision with root package name */
    public String f66463i;
    public int j;
    public String k;
    public int l;
    public boolean m;
    public g.a n;
    public ItemInfo o;

    /* loaded from: classes5.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // d.a.n0.w3.g.a
        public void a(int i2) {
            if (i2 == 1) {
                f.this.f66458d = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
            } else if (i2 == 4) {
                f.this.f66458d = false;
                if (f.this.f66457c.f66391a.getParent() == f.this.f66456b && f.this.f66456b != null && f.this.f66457c.f66391a != null && f.this.f66456b.indexOfChild(f.this.f66457c.f66391a) > 0) {
                    f.this.f66456b.removeView(f.this.f66457c.f66391a);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f66465e;

        public b(d.a.m0.r.s.a aVar) {
            this.f66465e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.r.s.a aVar = this.f66465e;
            if (aVar != null) {
                aVar.dismiss();
                d.a.m0.r.d0.b.j().t("commodity_goods_show_first_dialog", true);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", f.this.f66460f.forumId).param("fname", f.this.f66460f.forumName));
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(f fVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f66467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66468b;

        public d(ForumWriteData forumWriteData, String str) {
            this.f66467a = forumWriteData;
            this.f66468b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.a.c.e.i.a.l().h(false);
            ForumWriteData forumWriteData = this.f66467a;
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
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f66468b).param("obj_type", 4));
            if (f.this.j != 1) {
                if (f.this.j == 2) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                }
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(f.this.f66455a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteActivityConfig f66470a;

        public e(WriteActivityConfig writeActivityConfig) {
            this.f66470a = writeActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f66470a));
        }
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public static boolean w(Activity activity, WriteActivityConfig writeActivityConfig) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new e(writeActivityConfig));
        return permissionJudgePolicy.startRequestPermission(activity);
    }

    public void A(ItemInfo itemInfo) {
        this.o = itemInfo;
    }

    public void B(boolean z) {
        d.a.n0.w3.a aVar = this.f66457c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).e(z);
        }
    }

    public void C(String str) {
        this.k = str;
    }

    public void D(int i2) {
        d.a.n0.w3.a aVar = this.f66457c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.setIconFade(i2);
        }
    }

    public void E(String str) {
        if (str == null) {
            str = "";
        }
        this.f66462h = str;
    }

    public void F(int i2) {
        this.l = i2;
    }

    public void G(boolean z, View view, View view2) {
        AntiData antiData;
        if (this.f66456b == null) {
            return;
        }
        if (this.f66457c.f66391a.getParent() == null) {
            d.a.m0.d0.e.a(this.f66456b).a(this.f66456b, this.f66457c.f66391a, z);
        }
        this.f66459e.a(view, view2);
        this.f66459e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (j.x()) {
            String p = d.a.m0.r.d0.b.j().p("key_baidu_sim_card_writting_tip", "");
            if (!k.isEmpty(p)) {
                BdToast.c(this.f66455a.getContext(), p).q();
                d.a.m0.r.d0.b.j().C("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f66460f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f66460f.forumId).param("fname", this.f66460f.forumName));
    }

    public int g() {
        return this.l;
    }

    public String h() {
        return this.f66463i;
    }

    public String i() {
        return this.f66462h;
    }

    public final boolean j() {
        FrsTabInfoData frsTabInfoData;
        ForumWriteData forumWriteData = this.f66460f;
        if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            for (FrsTabItemData frsTabItemData : this.f66460f.frsTabInfo.tabList) {
                if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void k(boolean z) {
        this.f66459e.b(z);
        if (z) {
            return;
        }
        d.a.n0.w3.a aVar = this.f66457c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.h();
        }
    }

    public boolean l() {
        return this.f66458d;
    }

    public void m() {
        k(false);
        if (Build.VERSION.SDK_INT < 21) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66455a.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.f66455a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new c(this));
            aVar.create(this.f66455a).show();
            return;
        }
        v(this.f66455a, this.k, this.f66460f);
    }

    public void n() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f66455a.getPageActivity()).setType(0).setForumWriteData(this.f66460f).setFrom(this.f66463i).setTitle(this.f66462h).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.j);
        if (w(this.f66455a.getPageActivity(), statisticFrom)) {
            return;
        }
        statisticFrom.send();
    }

    public void o(String str) {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 1));
        WriteActivityConfig.newInstance(this.f66455a.getPageActivity()).setType(9).setForumWriteData(this.f66460f).setFrom(this.f66463i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).send();
    }

    public void p(int i2) {
        if (this.f66461g != i2) {
            this.f66461g = i2;
            this.f66457c.c(i2);
        }
    }

    public void q() {
        if (!j()) {
            BdToast.i(this.f66455a.getPageActivity(), this.f66455a.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (!this.m) {
            BdToast.i(this.f66455a.getPageActivity(), this.f66455a.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else {
            if (this.f66460f != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f66460f.forumId).param("fname", this.f66460f.forumName));
            }
            k(false);
            if (!d.a.m0.r.d0.b.j().g("commodity_goods_show_first_dialog", false)) {
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66455a.getPageActivity());
                aVar.setContentViewSize(2);
                aVar.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.f66455a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(aVar));
                aVar.setContentView(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1).param("fid", this.f66460f.forumId).param("fname", this.f66460f.forumName));
                aVar.create(this.f66455a).show();
                return;
            }
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    public void r() {
        View view = this.f66457c.f66391a;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = this.f66456b;
            if (parent == viewGroup) {
                viewGroup.removeView(this.f66457c.f66391a);
            }
        }
        this.f66459e.d();
    }

    public void s() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
        if (this.f66460f == null) {
            this.f66460f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f66460f;
        forumWriteData.mFrom = this.f66463i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        i.d(this.f66455a, "", forumWriteData);
    }

    public void t(String str) {
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
        k(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.f66455a.getPageActivity(), 25048);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.f66460f == null) {
            this.f66460f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f66460f;
        forumWriteData.mFrom = this.f66463i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        writeVoteActivityConfig.setExtraData(forumWriteData);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
    }

    public void u() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f66455a.getPageActivity()).setType(9).setForumWriteData(this.f66460f).setIsEvaluate(true).setFrom(this.f66463i).setCallFrom("2").setStatisticFrom(this.j);
        ItemInfo itemInfo = this.o;
        if (itemInfo != null) {
            statisticFrom.setScoreItemInfo(new SerializableItemInfo(itemInfo)).setItemIsSchool(this.o.is_school.intValue() == 1).setStarCount(this.o.score.comment_star.intValue());
        }
        statisticFrom.send();
    }

    public void v(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
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

    public void x() {
        d.a.n0.w3.a aVar = this.f66457c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void y(boolean z) {
        this.m = z;
    }

    public void z(ForumWriteData forumWriteData) {
        this.f66460f = forumWriteData;
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i2) {
        int i3 = 0;
        this.f66458d = false;
        this.f66461g = 3;
        this.f66462h = "";
        this.f66463i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.n = new a();
        this.f66455a = tbPageContext;
        this.f66456b = viewGroup;
        this.f66463i = str;
        if ("main_tab".equals(str)) {
            i3 = 1;
        } else if ("frs".equals(this.f66463i)) {
            i3 = 2;
        }
        this.j = i3;
        if (i2 == 3) {
            a.b bVar = new a.b(this.f66455a, this);
            this.f66457c = bVar;
            this.f66459e = new d.a.n0.w3.e(tbPageContext.getPageActivity(), bVar);
        } else {
            a.c cVar = new a.c(this.f66455a, this);
            this.f66457c = cVar;
            this.f66459e = new d.a.n0.w3.d(tbPageContext.getPageActivity(), cVar);
        }
        p(TbadkCoreApplication.getInst().getSkinType());
        this.f66459e.e(this.n);
    }
}
