package d.a.q0.a4;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.p0.s.s.a;
import d.a.q0.a4.a;
import d.a.q0.a4.g;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54667a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54668b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a4.a f54669c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54670d;

    /* renamed from: e  reason: collision with root package name */
    public g f54671e;

    /* renamed from: f  reason: collision with root package name */
    public ForumWriteData f54672f;

    /* renamed from: g  reason: collision with root package name */
    public int f54673g;

    /* renamed from: h  reason: collision with root package name */
    public String f54674h;

    /* renamed from: i  reason: collision with root package name */
    public String f54675i;
    public int j;
    public String k;
    public int l;
    public boolean m;
    public g.a n;
    public ItemInfo o;

    /* loaded from: classes7.dex */
    public class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f54676a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54676a = fVar;
        }

        @Override // d.a.q0.a4.g.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    this.f54676a.f54670d = true;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 4) {
                    this.f54676a.f54670d = false;
                    if (this.f54676a.f54669c.f54603a.getParent() == this.f54676a.f54668b && this.f54676a.f54668b != null && this.f54676a.f54669c.f54603a != null && this.f54676a.f54668b.indexOfChild(this.f54676a.f54669c.f54603a) > 0) {
                        this.f54676a.f54668b.removeView(this.f54676a.f54669c.f54603a);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f54677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f54678f;

        public b(f fVar, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54678f = fVar;
            this.f54677e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.p0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f54677e) == null) {
                return;
            }
            aVar.dismiss();
            d.a.p0.s.d0.b.j().t("commodity_goods_show_first_dialog", true);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", this.f54678f.f54672f.forumId).param("fname", this.f54678f.f54672f.forumName));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f54679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f54681c;

        public d(f fVar, ForumWriteData forumWriteData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, forumWriteData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54681c = fVar;
            this.f54679a = forumWriteData;
            this.f54680b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                d.a.d.e.i.a.l().h(false);
                ForumWriteData forumWriteData = this.f54679a;
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
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.f54680b).param("obj_type", 4));
                if (this.f54681c.j != 1) {
                    if (this.f54681c.j == 2) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f54681c.f54667a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IntentConfig f54682a;

        public e(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54682a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f54682a));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (ViewGroup) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean w(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            permissionJudgePolicy.setOnPermissionsGrantedListener(new e(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public void A(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemInfo) == null) {
            this.o = itemInfo;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d.a.q0.a4.a aVar = this.f54669c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).e(z);
            }
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.k = str;
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            d.a.q0.a4.a aVar = this.f54669c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).B.setIconFade(i2);
            }
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.f54674h = str;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.l = i2;
        }
    }

    public void G(boolean z, View view, View view2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), view, view2}) == null) || this.f54668b == null) {
            return;
        }
        if (this.f54669c.f54603a.getParent() == null) {
            d.a.p0.f0.e.a(this.f54668b).a(this.f54668b, this.f54669c.f54603a, z);
        }
        this.f54671e.a(view, view2);
        this.f54671e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (j.x()) {
            String p = d.a.p0.s.d0.b.j().p("key_baidu_sim_card_writting_tip", "");
            if (!k.isEmpty(p)) {
                BdToast.c(this.f54667a.getContext(), p).q();
                d.a.p0.s.d0.b.j().C("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f54672f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f54672f.forumId).param("fname", this.f54672f.forumName));
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54675i : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f54674h : (String) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        FrsTabInfoData frsTabInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ForumWriteData forumWriteData = this.f54672f;
            if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.f54672f.frsTabInfo.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f54671e.b(z);
            if (z) {
                return;
            }
            d.a.q0.a4.a aVar = this.f54669c;
            if (aVar instanceof a.c) {
                ((a.c) aVar).B.h();
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f54670d : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k(false);
            if (Build.VERSION.SDK_INT < 21) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54667a.getPageActivity());
                aVar.setAutoNight(false);
                aVar.setTitle(R.string.prompt);
                aVar.setMessage(this.f54667a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.know, new c(this));
                aVar.create(this.f54667a).show();
                return;
            }
            v(this.f54667a, this.k, this.f54672f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            k(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54667a.getPageActivity(), "", true, true);
            if (this.f54672f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f54672f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f54672f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f54672f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f54672f.frsTabInfo);
                ForumWriteData forumWriteData = this.f54672f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.f54675i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.f54674h);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (w(this.f54667a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            k(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 1));
            WriteActivityConfig.newInstance(this.f54667a.getPageActivity()).setType(9).setForumWriteData(this.f54672f).setFrom(this.f54675i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).send();
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f54673g == i2) {
            return;
        }
        this.f54673g = i2;
        this.f54669c.c(i2);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!j()) {
                BdToast.i(this.f54667a.getPageActivity(), this.f54667a.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            } else if (!this.m) {
                BdToast.i(this.f54667a.getPageActivity(), this.f54667a.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            } else {
                if (this.f54672f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f54672f.forumId).param("fname", this.f54672f.forumName));
                }
                k(false);
                if (!d.a.p0.s.d0.b.j().g("commodity_goods_show_first_dialog", false)) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54667a.getPageActivity());
                    aVar.setContentViewSize(2);
                    aVar.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.f54667a.getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(this, aVar));
                    aVar.setContentView(frsPublishFineGoodsDialogView);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1).param("fid", this.f54672f.forumId).param("fname", this.f54672f.forumName));
                    aVar.create(this.f54667a).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            View view = this.f54669c.f54603a;
            if (view != null) {
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = this.f54668b;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.f54669c.f54603a);
                }
            }
            this.f54671e.d();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            k(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54667a.getPageActivity(), "", true, true);
            if (this.f54672f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f54672f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f54672f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f54672f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f54672f.frsTabInfo);
                ForumWriteData forumWriteData = this.f54672f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.f54675i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.f54674h);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (w(this.f54667a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
            k(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.f54667a.getPageActivity(), 25048);
            writeVoteActivityConfig.setExtraTitle(str);
            if (this.f54672f == null) {
                this.f54672f = new ForumWriteData("0", null, null, null);
            }
            ForumWriteData forumWriteData = this.f54672f;
            forumWriteData.mFrom = this.f54675i;
            forumWriteData.writeCallFrom = "2";
            forumWriteData.statisticFrom = this.j;
            writeVoteActivityConfig.setExtraData(forumWriteData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            k(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.f54667a.getPageActivity()).setType(9).setForumWriteData(this.f54672f).setIsEvaluate(true).setFrom(this.f54675i).setCallFrom("2").setStatisticFrom(this.j);
            ItemInfo itemInfo = this.o;
            if (itemInfo != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(itemInfo)).setItemIsSchool(this.o.is_school.intValue() == 1).setStarCount(this.o.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public void v(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, tbPageContext, str, forumWriteData) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this, forumWriteData, str));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public void x() {
        d.a.q0.a4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (aVar = this.f54669c) == null) {
            return;
        }
        aVar.a();
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.m = z;
        }
    }

    public void z(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, forumWriteData) == null) {
            this.f54672f = forumWriteData;
        }
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i5 = 0;
        this.f54670d = false;
        this.f54673g = 3;
        this.f54674h = "";
        this.f54675i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.n = new a(this);
        this.f54667a = tbPageContext;
        this.f54668b = viewGroup;
        this.f54675i = str;
        if ("main_tab".equals(str)) {
            i5 = 1;
        } else if ("frs".equals(this.f54675i)) {
            i5 = 2;
        }
        this.j = i5;
        if (i2 == 3) {
            a.b bVar = new a.b(this.f54667a, this);
            this.f54669c = bVar;
            this.f54671e = new d.a.q0.a4.e(tbPageContext.getPageActivity(), bVar);
        } else {
            a.c cVar = new a.c(this.f54667a, this);
            this.f54669c = cVar;
            this.f54671e = new d.a.q0.a4.d(tbPageContext.getPageActivity(), cVar);
        }
        p(TbadkCoreApplication.getInst().getSkinType());
        this.f54671e.e(this.n);
    }
}
