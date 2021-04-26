package d.a.j0.v3;

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
import d.a.i0.r.s.a;
import d.a.j0.v3.a;
import d.a.j0.v3.g;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61909a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f61910b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.v3.a f61911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61912d;

    /* renamed from: e  reason: collision with root package name */
    public g f61913e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f61914f;

    /* renamed from: g  reason: collision with root package name */
    public int f61915g;

    /* renamed from: h  reason: collision with root package name */
    public String f61916h;

    /* renamed from: i  reason: collision with root package name */
    public String f61917i;
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

        @Override // d.a.j0.v3.g.a
        public void a(int i2) {
            if (i2 == 1) {
                f.this.f61912d = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
            } else if (i2 == 4) {
                f.this.f61912d = false;
                if (f.this.f61911c.f61845a.getParent() == f.this.f61910b && f.this.f61910b != null && f.this.f61911c.f61845a != null && f.this.f61910b.indexOfChild(f.this.f61911c.f61845a) > 0) {
                    f.this.f61910b.removeView(f.this.f61911c.f61845a);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f61919e;

        public b(d.a.i0.r.s.a aVar) {
            this.f61919e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.i0.r.s.a aVar = this.f61919e;
            if (aVar != null) {
                aVar.dismiss();
                d.a.i0.r.d0.b.j().t("commodity_goods_show_first_dialog", true);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", f.this.f61914f.forumId).param("fname", f.this.f61914f.forumName));
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c(f fVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f61921a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61922b;

        public d(ForumWriteData forumWriteData, String str) {
            this.f61921a = forumWriteData;
            this.f61922b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.a.c.e.i.a.l().h(false);
            ForumWriteData forumWriteData = this.f61921a;
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
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f61922b).param("obj_type", 4));
            if (f.this.j != 1) {
                if (f.this.j == 2) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                }
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(f.this.f61909a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteActivityConfig f61924a;

        public e(WriteActivityConfig writeActivityConfig) {
            this.f61924a = writeActivityConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f61924a));
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
        d.a.j0.v3.a aVar = this.f61911c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).e(z);
        }
    }

    public void C(String str) {
        this.k = str;
    }

    public void D(int i2) {
        d.a.j0.v3.a aVar = this.f61911c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.setIconFade(i2);
        }
    }

    public void E(String str) {
        if (str == null) {
            str = "";
        }
        this.f61916h = str;
    }

    public void F(int i2) {
        this.l = i2;
    }

    public void G(boolean z, View view, View view2) {
        AntiData antiData;
        if (this.f61910b == null) {
            return;
        }
        if (this.f61911c.f61845a.getParent() == null) {
            d.a.i0.d0.e.a(this.f61910b).a(this.f61910b, this.f61911c.f61845a, z);
        }
        this.f61913e.a(view, view2);
        this.f61913e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (j.x()) {
            String p = d.a.i0.r.d0.b.j().p("key_baidu_sim_card_writting_tip", "");
            if (!k.isEmpty(p)) {
                BdToast.c(this.f61909a.getContext(), p).q();
                d.a.i0.r.d0.b.j().C("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f61914f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f61914f.forumId).param("fname", this.f61914f.forumName));
    }

    public int g() {
        return this.l;
    }

    public String h() {
        return this.f61917i;
    }

    public String i() {
        return this.f61916h;
    }

    public final boolean j() {
        FrsTabInfoData frsTabInfoData;
        ForumWriteData forumWriteData = this.f61914f;
        if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            for (FrsTabItemData frsTabItemData : this.f61914f.frsTabInfo.tabList) {
                if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void k(boolean z) {
        this.f61913e.b(z);
        if (z) {
            return;
        }
        d.a.j0.v3.a aVar = this.f61911c;
        if (aVar instanceof a.c) {
            ((a.c) aVar).B.h();
        }
    }

    public boolean l() {
        return this.f61912d;
    }

    public void m() {
        k(false);
        if (Build.VERSION.SDK_INT < 21) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f61909a.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.f61909a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new c(this));
            aVar.create(this.f61909a).show();
            return;
        }
        v(this.f61909a, this.k, this.f61914f);
    }

    public void n() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f61909a.getPageActivity()).setType(0).setForumWriteData(this.f61914f).setFrom(this.f61917i).setTitle(this.f61916h).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.j);
        if (w(this.f61909a.getPageActivity(), statisticFrom)) {
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
        WriteActivityConfig.newInstance(this.f61909a.getPageActivity()).setType(9).setForumWriteData(this.f61914f).setFrom(this.f61917i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).send();
    }

    public void p(int i2) {
        if (this.f61915g != i2) {
            this.f61915g = i2;
            this.f61911c.c(i2);
        }
    }

    public void q() {
        if (!j()) {
            BdToast.i(this.f61909a.getPageActivity(), this.f61909a.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (!this.m) {
            BdToast.i(this.f61909a.getPageActivity(), this.f61909a.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else {
            if (this.f61914f != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f61914f.forumId).param("fname", this.f61914f.forumName));
            }
            k(false);
            if (!d.a.i0.r.d0.b.j().g("commodity_goods_show_first_dialog", false)) {
                d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f61909a.getPageActivity());
                aVar.setContentViewSize(2);
                aVar.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.f61909a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(aVar));
                aVar.setContentView(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1).param("fid", this.f61914f.forumId).param("fname", this.f61914f.forumName));
                aVar.create(this.f61909a).show();
                return;
            }
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    public void r() {
        View view = this.f61911c.f61845a;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = this.f61910b;
            if (parent == viewGroup) {
                viewGroup.removeView(this.f61911c.f61845a);
            }
        }
        this.f61913e.d();
    }

    public void s() {
        k(false);
        if (WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
        if (this.f61914f == null) {
            this.f61914f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f61914f;
        forumWriteData.mFrom = this.f61917i;
        forumWriteData.writeCallFrom = "2";
        forumWriteData.statisticFrom = this.j;
        i.d(this.f61909a, "", forumWriteData);
    }

    public void t(String str) {
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
        k(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.f61909a.getPageActivity(), 25048);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.f61914f == null) {
            this.f61914f = new ForumWriteData("0", null, null, null);
        }
        ForumWriteData forumWriteData = this.f61914f;
        forumWriteData.mFrom = this.f61917i;
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
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f61909a.getPageActivity()).setType(9).setForumWriteData(this.f61914f).setIsEvaluate(true).setFrom(this.f61917i).setCallFrom("2").setStatisticFrom(this.j);
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
        d.a.j0.v3.a aVar = this.f61911c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void y(boolean z) {
        this.m = z;
    }

    public void z(ForumWriteData forumWriteData) {
        this.f61914f = forumWriteData;
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i2) {
        int i3 = 0;
        this.f61912d = false;
        this.f61915g = 3;
        this.f61916h = "";
        this.f61917i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.n = new a();
        this.f61909a = tbPageContext;
        this.f61910b = viewGroup;
        this.f61917i = str;
        if ("main_tab".equals(str)) {
            i3 = 1;
        } else if ("frs".equals(this.f61917i)) {
            i3 = 2;
        }
        this.j = i3;
        if (i2 == 3) {
            a.b bVar = new a.b(this.f61909a, this);
            this.f61911c = bVar;
            this.f61913e = new d.a.j0.v3.e(tbPageContext.getPageActivity(), bVar);
        } else {
            a.c cVar = new a.c(this.f61909a, this);
            this.f61911c = cVar;
            this.f61913e = new d.a.j0.v3.d(tbPageContext.getPageActivity(), cVar);
        }
        p(TbadkCoreApplication.getInst().getSkinType());
        this.f61913e.e(this.n);
    }
}
