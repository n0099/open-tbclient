package d.a.q0.u0.o2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.s0;
import d.a.p0.s.s.a;
import d.a.q0.u0.f2.a.c;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class d implements d.a.q0.u0.m1.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64034a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f64035b;

    /* renamed from: c  reason: collision with root package name */
    public l f64036c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.p3.d f64037d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.u0.f2.a.c f64038e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f64039f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a4.f f64040g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f64041h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f64042i;
    public final d.a.d.e.l.c<d.a.d.k.d.a> j;

    /* loaded from: classes8.dex */
    public class a implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64043a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64043a = dVar;
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.f64043a.B(1);
                } else if (z) {
                    this.f64043a.B(0);
                } else if (i2 != 502) {
                    this.f64043a.B(-1);
                } else {
                    this.f64043a.n();
                }
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64044e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64044e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !DialogLoginHelper.checkUpIsLogin(new s0(this.f64044e.f64034a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(this.f64044e.f64034a.getPageContext().getPageActivity()) || this.f64044e.f64037d.c() || this.f64044e.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.f64044e.f64036c != null) {
                this.f64044e.f64036c.i();
            }
            if (this.f64044e.f64034a.K2().H(502) == null || this.f64044e.f64034a.K2().z() == null) {
                this.f64044e.B(-1);
            } else {
                this.f64044e.f64038e.i(this.f64044e.f64034a.h(), this.f64044e.f64034a.K2().z().f16137a);
            }
            this.f64044e.j();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64045a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64045a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.f64045a.w();
                    return;
                }
                this.f64045a.f64039f.setImageDrawable(null);
                aVar.h(this.f64045a.f64039f);
            }
        }
    }

    /* renamed from: d.a.q0.u0.o2.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1711d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1711d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f64046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f64047f;

        public e(d dVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64047f = dVar;
            this.f64046e = blockPopInfoData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f64047f.f64034a.getPageContext(), new String[]{this.f64046e.ahead_url});
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64041h = new a(this);
        this.f64042i = new b(this);
        this.j = new c(this);
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.f64034a = frsFragment;
        this.f64035b = noPressedRelativeLayout;
        this.f64037d = new d.a.q0.p3.d(frsFragment.getPageContext());
        d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(frsFragment.getPageContext());
        this.f64038e = cVar;
        cVar.j(this.f64041h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData l0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f64039f == null) {
            return;
        }
        l();
        this.f64039f.setVisibility(z ? 0 : 8);
        if (!z || !TbadkCoreApplication.isLogin() || (l0 = this.f64034a.l0()) == null || l0.postTopic == null || l0.getForum() == null || StringUtils.isNull(l0.getForum().getId()) || StringUtils.isNull(l0.postTopic.recom_title) || StringUtils.isNull(l0.postTopic.recom_topic) || !d.a.q0.u0.o.a.d().c(l0.getForum().getId(), l0.postTopic.uniq_topicid.longValue())) {
            return;
        }
        z(this.f64039f, l0);
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f64040g == null) {
                d.a.q0.a4.f fVar = new d.a.q0.a4.f(this.f64034a.getPageContext(), this.f64035b, "frs");
                this.f64040g = fVar;
                fVar.C("2");
                ItemInfo itemInfo = this.f64034a.l0().itemInfo;
                this.f64040g.B((itemInfo == null || itemInfo.id.intValue() <= 0 || d.a.d.e.p.k.isEmpty(itemInfo.name)) ? false : true);
            }
            this.f64040g.E(m());
            if (this.f64034a.l0().getAnti() != null) {
                this.f64040g.y(this.f64034a.l0().getAnti().getCanGoods());
            }
            ForumWriteData z2 = this.f64034a.z2();
            z2.setDefaultZone(i2);
            this.f64040g.z(z2);
            this.f64040g.A(this.f64034a.l0().itemInfo);
            this.f64040g.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            FrsFragment frsFragment = this.f64034a;
            if (frsFragment != null && frsFragment.l0() != null) {
                this.f64040g.A(this.f64034a.l0().itemInfo);
            }
            this.f64040g.G(false, null, this.f64039f);
            this.f64034a.O2().setAlpha(0);
            FrsFragment frsFragment2 = this.f64034a;
            if (frsFragment2 == null || frsFragment2.l0() == null || this.f64034a.l0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f64034a.h()).param("fname", this.f64034a.g()).param("obj_param1", this.f64034a.l0().itemInfo.name));
        }
    }

    public void C() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ovalActionButton = this.f64039f) == null) {
            return;
        }
        ovalActionButton.performClick();
    }

    @Override // d.a.q0.u0.m1.e.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f64037d.c() || k()) ? false : true : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.f64034a;
            if (frsFragment != null) {
                d.a.p0.l0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData l0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.f64034a;
            if (frsFragment == null || (l0 = frsFragment.l0()) == null) {
                return false;
            }
            if (ViewHelper.checkUpIsLogin(this.f64034a.getPageContext().getPageActivity())) {
                AntiData anti = l0.getAnti();
                return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsViewData l0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.f64034a;
            if (frsFragment != null && (l0 = frsFragment.l0()) != null && (activityConfig = l0.activityConfig) != null && activityConfig.type.intValue() == 2) {
                if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                    q(activityConfig.night_addthread_icon);
                    return true;
                } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                    q(activityConfig.addthread_icon);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String m() {
        InterceptResult invokeV;
        FrsViewData l0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsFragment frsFragment = this.f64034a;
            return (frsFragment == null || (l0 = frsFragment.l0()) == null || (activityConfig = l0.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public final void n() {
        FrsFragment frsFragment;
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (frsFragment = this.f64034a) == null || frsFragment.l0() == null || (forum = this.f64034a.l0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f64034a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.q0.a4.f fVar = this.f64040g;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.q0.a4.f fVar = this.f64040g;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            d.a.d.e.l.d.h().m(str, 10, this.j, this.f64034a.getUniqueId());
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.q0.a4.f fVar = this.f64040g;
            if (fVar != null) {
                fVar.r();
            }
            l lVar = this.f64036c;
            if (lVar != null) {
                lVar.i();
            }
        }
    }

    public void s() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (lVar = this.f64036c) == null) {
            return;
        }
        lVar.i();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void u(int i2) {
        d.a.q0.a4.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (fVar = this.f64040g) == null) {
            return;
        }
        fVar.p(i2);
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            d.a.q0.a4.f fVar = this.f64040g;
            if (fVar == null || !fVar.l()) {
                return false;
            }
            this.f64040g.k(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f64039f.setImageResource(0);
        }
    }

    public void x(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        this.f64039f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.f64042i);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i2, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.f64034a.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
            if (i2 == 1 || i2 == 2) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f64034a.getPageContext().getPageActivity());
                aVar.setMessage(StringHelper.getFixedText(string, 50, true));
                aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.f64034a.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1711d(this));
                if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                    aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
                }
                aVar.create(this.f64034a.getPageContext()).show();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void z(View view, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, view, frsViewData) == null) || this.f64034a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f64036c == null) {
            this.f64036c = new l(this.f64034a.getActivity(), this);
        }
        this.f64036c.i();
        this.f64036c.j(view, frsViewData);
    }
}
