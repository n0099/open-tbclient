package d.a.o0.w3;

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
import d.a.n0.r.s.a;
import d.a.o0.w3.a;
import d.a.o0.w3.g;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66580a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f66581b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.w3.a f66582c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66583d;

    /* renamed from: e  reason: collision with root package name */
    public g f66584e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f66585f;

    /* renamed from: g  reason: collision with root package name */
    public int f66586g;

    /* renamed from: h  reason: collision with root package name */
    public String f66587h;

    /* renamed from: i  reason: collision with root package name */
    public String f66588i;
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

        @Override // d.a.o0.w3.g.a
        public void a(int i2) {
            if (i2 == 1) {
                f.this.f66583d = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
            } else if (i2 == 4) {
                f.this.f66583d = false;
                if (f.this.f66582c.f66516a.getParent() == f.this.f66581b && f.this.f66581b != null && f.this.f66582c.f66516a != null && f.this.f66581b.indexOfChild(f.this.f66582c.f66516a) > 0) {
                    f.this.f66581b.removeView(f.this.f66582c.f66516a);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f66590e;

        public b(d.a.n0.r.s.a aVar) {
            this.f66590e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.r.s.a aVar = this.f66590e;
            if (aVar != null) {
                aVar.dismiss();
                d.a.n0.r.d0.b.j().t("commodity_goods_show_first_dialog", true);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", f.this.f66585f.forumId).param("fname", f.this.f66585f.forumName));
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(f fVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f66592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66593b;

        public d(ForumWriteData forumWriteData, String str) {
            this.f66592a = forumWriteData;
            this.f66593b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.a.c.e.i.a.k().g(false);
            ForumWriteData forumWriteData = this.f66592a;
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
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f66593b).param("obj_type", 4));
            if (f.this.j != 1) {
                if (f.this.j == 2) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                }
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(f.this.f66580a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteActivityConfig f66595a;

        public e(WriteActivityConfig writeActivityConfig) {
            this.f66595a = writeActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f66595a));
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
        d.a.o0.w3.a aVar = this.f66582c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).e(z);
        }
    }

    public void C(String str) {
        this.k = str;
    }

    public void D(int i2) {
        d.a.o0.w3.a aVar = this.f66582c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.setIconFade(i2);
        }
    }

    public void E(String str) {
        if (str == null) {
            str = "";
        }
        this.f66587h = str;
    }

    public void F(int i2) {
        this.l = i2;
    }

    public void G(boolean z, View view, View view2) {
        AntiData antiData;
        if (this.f66581b == null) {
            return;
        }
        if (this.f66582c.f66516a.getParent() == null) {
            d.a.n0.d0.e.a(this.f66581b).a(this.f66581b, this.f66582c.f66516a, z);
        }
        this.f66584e.a(view, view2);
        this.f66584e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (j.x()) {
            String p = d.a.n0.r.d0.b.j().p("key_baidu_sim_card_writting_tip", "");
            if (!k.isEmpty(p)) {
                BdToast.c(this.f66580a.getContext(), p).q();
                d.a.n0.r.d0.b.j().C("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f66585f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f66585f.forumId).param("fname", this.f66585f.forumName));
    }

    public int g() {
        return this.l;
    }

    public String h() {
        return this.f66588i;
    }

    public String i() {
        return this.f66587h;
    }

    public final boolean j() {
        FrsTabInfoData frsTabInfoData;
        ForumWriteData forumWriteData = this.f66585f;
        if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            for (FrsTabItemData frsTabItemData : this.f66585f.frsTabInfo.tabList) {
                if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void k(boolean z) {
        this.f66584e.b(z);
        if (z) {
            return;
        }
        d.a.o0.w3.a aVar = this.f66582c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.h();
        }
    }

    public boolean l() {
        return this.f66583d;
    }

    public void m() {
        k(false);
        if (Build.VERSION.SDK_INT < 21) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f66580a.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.f66580a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new c(this));
            aVar.create(this.f66580a).show();
            return;
        }
        v(this.f66580a, this.k, this.f66585f);
    }

    public void n() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f66580a.getPageActivity()).setType(0).setForumWriteData(this.f66585f).setFrom(this.f66588i).setTitle(this.f66587h).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.j);
        if (w(this.f66580a.getPageActivity(), statisticFrom)) {
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
        WriteActivityConfig.newInstance(this.f66580a.getPageActivity()).setType(9).setForumWriteData(this.f66585f).setFrom(this.f66588i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).send();
    }

    public void p(int i2) {
        if (this.f66586g != i2) {
            this.f66586g = i2;
            this.f66582c.c(i2);
        }
    }

    public void q() {
        if (!j()) {
            BdToast.i(this.f66580a.getPageActivity(), this.f66580a.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (!this.m) {
            BdToast.i(this.f66580a.getPageActivity(), this.f66580a.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else {
            if (this.f66585f != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f66585f.forumId).param("fname", this.f66585f.forumName));
            }
            k(false);
            if (!d.a.n0.r.d0.b.j().g("commodity_goods_show_first_dialog", false)) {
                d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f66580a.getPageActivity());
                aVar.setContentViewSize(2);
                aVar.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.f66580a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(aVar));
                aVar.setContentView(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1).param("fid", this.f66585f.forumId).param("fname", this.f66585f.forumName));
                aVar.create(this.f66580a).show();
                return;
            }
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    public void r() {
        View view = this.f66582c.f66516a;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = this.f66581b;
            if (parent == viewGroup) {
                viewGroup.removeView(this.f66582c.f66516a);
            }
        }
        this.f66584e.d();
    }

    public void s() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
        if (this.f66585f == null) {
            this.f66585f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f66585f;
        forumWriteData.mFrom = this.f66588i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        i.d(this.f66580a, "", forumWriteData);
    }

    public void t(String str) {
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
        k(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.f66580a.getPageActivity(), 25048);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.f66585f == null) {
            this.f66585f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f66585f;
        forumWriteData.mFrom = this.f66588i;
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
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f66580a.getPageActivity()).setType(9).setForumWriteData(this.f66585f).setIsEvaluate(true).setFrom(this.f66588i).setCallFrom("2").setStatisticFrom(this.j);
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
        d.a.o0.w3.a aVar = this.f66582c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void y(boolean z) {
        this.m = z;
    }

    public void z(ForumWriteData forumWriteData) {
        this.f66585f = forumWriteData;
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i2) {
        int i3 = 0;
        this.f66583d = false;
        this.f66586g = 3;
        this.f66587h = "";
        this.f66588i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.n = new a();
        this.f66580a = tbPageContext;
        this.f66581b = viewGroup;
        this.f66588i = str;
        if ("main_tab".equals(str)) {
            i3 = 1;
        } else if ("frs".equals(this.f66588i)) {
            i3 = 2;
        }
        this.j = i3;
        if (i2 == 3) {
            a.b bVar = new a.b(this.f66580a, this);
            this.f66582c = bVar;
            this.f66584e = new d.a.o0.w3.e(tbPageContext.getPageActivity(), bVar);
        } else {
            a.c cVar = new a.c(this.f66580a, this);
            this.f66582c = cVar;
            this.f66584e = new d.a.o0.w3.d(tbPageContext.getPageActivity(), cVar);
        }
        p(TbadkCoreApplication.getInst().getSkinType());
        this.f66584e.e(this.n);
    }
}
