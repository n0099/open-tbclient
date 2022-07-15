package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class nm6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern q;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public RelativeLayout b;
    public BdTypeRecyclerView c;
    public FrameLayout d;
    public PbListView e;
    public mm6 f;
    public BannerView g;
    public uo4 h;
    public boolean i;
    public RelativeLayout j;
    public fi6 k;
    public boolean l;
    public gw8 m;
    public BannerView.b n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes6.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public a(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view2 = viewHolder.itemView) == null) {
                return;
            }
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f090029);
            if (playVoiceBnt != null) {
                playVoiceBnt.k();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f090027);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.p();
            }
            if (view2 instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view2).reset();
            }
            if (this.a.m != null) {
                this.a.m.f(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public b(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.g.i() && !this.a.i && this.a.c != null) {
                this.a.i = true;
                this.a.c.t(this.a.g, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public c(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        public d(nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.removeHeaderView(this.a.j);
                this.a.c.t(this.a.j, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f.l();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(nm6 nm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<nn> j = this.a.f.j();
                if (ListUtils.isEmpty(j)) {
                    return;
                }
                if (!ListUtils.isEmpty(j)) {
                    for (nn nnVar : j) {
                        if (nnVar instanceof qq4) {
                            qq4 qq4Var = (qq4) nnVar;
                            if (qq4Var.t != 0 && (threadData = qq4Var.s) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                qq4Var.t = imageWidthAndHeight[0];
                                qq4Var.u = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                qg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(nm6 nm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.z(str);
                this.a.y(str);
                this.a.f.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152070633, "Lcom/repackage/nm6$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-152070633, "Lcom/repackage/nm6$g;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755464646, "Lcom/repackage/nm6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755464646, "Lcom/repackage/nm6;");
                return;
            }
        }
        q = Pattern.compile("(/p/){1}(\\d+)");
    }

    public nm6(FrsNewAreaFragment frsNewAreaFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.g = null;
        this.i = false;
        this.l = true;
        this.n = new c(this);
        this.o = new e(this, 2921414);
        this.p = new f(this, 2016331);
        this.a = frsNewAreaFragment;
        p(view2);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.l) {
                return false;
            }
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a2a));
            this.e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ld6 ld6Var = new ld6();
            ld6Var.a = 503;
            ld6Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ld6Var));
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.m();
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || z) {
            return;
        }
        ld6 ld6Var = new ld6();
        ld6Var.a = 503;
        ld6Var.b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ld6Var));
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.c.setSelection(i);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
            if (z) {
                this.e.C(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a29));
                BdTypeRecyclerView bdTypeRecyclerView = this.c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.e.b()) {
                    this.e.Q();
                    this.a.b();
                    return;
                }
                this.e.f();
                return;
            }
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a2a));
            this.e.f();
        }
    }

    public void H(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xnVar) == null) {
            this.f.u(xnVar);
        }
    }

    public void I(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.c.setOnScrollListener(onScrollListener);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            sd6 sd6Var = new sd6();
            sd6Var.a = 503;
            sd6Var.c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, sd6Var));
        }
    }

    public void K(ArrayList<nn> arrayList, int i, FrsViewData frsViewData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{arrayList, Integer.valueOf(i), frsViewData, Integer.valueOf(i2)}) == null) {
            ArrayList<nn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                kd6 kd6Var = new kd6();
                ArrayList<nn> arrayList2 = new ArrayList<>();
                arrayList2.add(kd6Var);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> j = j(frsViewData);
                if (ListUtils.isEmpty(j)) {
                    RelativeLayout relativeLayout = this.j;
                    if (relativeLayout != null) {
                        this.c.removeHeaderView(relativeLayout);
                    }
                } else if (this.j != null) {
                    this.c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(j, 0);
                    if (frsViewData != null && this.a.c2() != null && frsTabInfo != null) {
                        this.a.c2().Q(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(j);
                    this.k.j(frsViewData.getForum().getId());
                    if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                        this.k.g(op6.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
                    }
                }
            }
            this.f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.setNextPage(this.e);
            this.e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.Q();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.setNextPage(this.e);
            this.e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.f();
            this.e.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ld6 ld6Var = new ld6();
            ld6Var.a = 503;
            ld6Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ld6Var));
        }
    }

    public final void i() {
        uo4 uo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (uo4Var = this.h) == null) {
            return;
        }
        String d2 = uo4Var.d();
        if (this.h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), d2, false, "frs_banner")));
        } else if (this.h.a() == 2) {
            if (d2.contains("tieba.baidu.com")) {
                Matcher matcher = q.matcher(d2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = g.a[nativePageType.ordinal()];
                if (i == 1) {
                    this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d2});
            if (StringUtils.isNull(d2) || !d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
        } else if (this.h.a() == 4) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(d2, "frs_banner")));
        }
    }

    public final List<FrsTabInfo> j(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                FrsTabInfo next = it.next();
                if (next.tab_id.intValue() == 503) {
                    i = next.tab_type.intValue();
                    break;
                }
            }
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().b) {
                if (frsTabInfo.tab_type.intValue() == i) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public mm6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f : (mm6) invokeV.objValue;
    }

    public BdTypeRecyclerView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.b : (RelativeLayout) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void o(uo4 uo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, uo4Var) == null) && this.g == null) {
            this.g = new BannerView(this.a.getPageContext().getPageActivity());
            this.g.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)));
            this.g.setVisibility(8);
            this.g.setBannerViewClickListener(this.n);
            this.g.setBannerData(uo4Var);
            this.g.setBannerViewEvent(new b(this));
        }
    }

    public final void p(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090aee);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090af0);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.c.setFadingEdgeLength(0);
            this.c.setOverScrollMode(2);
            this.c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.e.p(R.color.transparent);
            this.e.t(pi.f(this.a.getActivity(), R.dimen.tbds182));
            this.e.x();
            this.e.G(R.dimen.tbfontsize33);
            this.e.E(SkinManager.getColor(R.color.CAM_X0107));
            this.e.A(R.color.CAM_X0110);
            this.c.setOnSrollToBottomListener(this.a);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b50);
            this.f = new mm6(this.a, this.c);
            D(false);
            this.j = new RelativeLayout(this.a.getContext());
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new fi6(this.a, this.j);
            this.a.registerListener(this.o);
            this.a.registerListener(this.p);
            if (this.m == null) {
                this.m = new gw8(this.a.getPageContext(), this.c);
            }
        }
    }

    public void q() {
        mm6 mm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (mm6Var = this.f) == null) {
            return;
        }
        mm6Var.l();
    }

    public void r() {
        gw8 gw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (gw8Var = this.m) == null) {
            return;
        }
        gw8Var.c();
    }

    public void s(int i, int i2) {
        gw8 gw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) || (gw8Var = this.m) == null) {
            return;
        }
        gw8Var.d();
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            mm6 mm6Var = this.f;
            if (mm6Var != null) {
                mm6Var.w();
                this.f.l();
                this.f.n(i);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.b);
            BannerView bannerView = this.g;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.e.d(i);
            }
            this.k.h();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f.o();
            this.c.setOnSrollToBottomListener(null);
        }
    }

    public void v(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, forumData, userData) == null) || this.i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        uo4 frsBannerData = forumData.getFrsBannerData();
        this.h = frsBannerData;
        o(frsBannerData);
        this.g.k();
        this.c.removeHeaderView(this.g);
        if (this.h.getType() != 1 || TextUtils.isEmpty(this.h.b())) {
            return;
        }
        this.g.setData(this.a.getPageContext(), this.h.b());
        if (this.h.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f.l();
        }
    }

    public void x() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bannerView = this.g) == null) {
            return;
        }
        this.i = false;
        this.c.removeHeaderView(bannerView);
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || this.a.b2() == null) {
            return;
        }
        this.a.b2().N(str);
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f.j())) {
            return;
        }
        Iterator<nn> it = this.f.j().iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if (next instanceof qi5) {
                qi5 qi5Var = (qi5) next;
                if ((qi5Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) qi5Var.a()).a)) {
                    it.remove();
                }
            }
        }
    }
}
