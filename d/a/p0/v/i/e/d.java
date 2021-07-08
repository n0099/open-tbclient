package d.a.p0.v.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.a0.z;
import d.a.p0.h3.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.p0.a0.b<h> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public ViewPager.OnPageChangeListener C;
    public d.a.p0.v.i.d.c D;
    public ForbidParentSwipeBackRelativeLayout m;
    public FrsAlaStageLiveViewPager n;
    public FrsAlaStageLiveViewItemAdapter o;
    public LinearLayout p;
    public IndicatorView q;
    public View r;
    public View s;
    public String t;
    public h u;
    public int v;
    public d.a.p0.v.i.d.a w;
    public d.a.p0.v.i.d.b x;
    public boolean y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64806e;

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
            this.f64806e = dVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64806e.u == null || ListUtils.isEmpty(this.f64806e.u.f57960e) || this.f64806e.u.f57960e.size() <= 1) {
                return;
            }
            if (this.f64806e.f53777f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f64806e.f53777f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f64806e.f53777f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f64806e.f53777f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f64806e.f53777f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f64806e.f53777f.getOrignalPage()).setSwipeBackEnabled(this.f64806e.A);
                } else if (this.f64806e.f53777f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f64806e.f53777f.getOrignalPage()).setSwipeBackEnabled(this.f64806e.A);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64807e;

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
            this.f64807e = dVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 1 || i2 != 0 || (count = this.f64807e.o.getCount()) < 2) {
                return;
            }
            int currentItem = this.f64807e.n.getCurrentItem();
            int i3 = count - 2;
            if (currentItem < 1) {
                this.f64807e.n.setCurrentItem(i3, false);
            } else if (currentItem > i3) {
                this.f64807e.n.setCurrentItem(1, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f64807e.v = i2;
                if (this.f64807e.x == null) {
                    return;
                }
                int a2 = this.f64807e.x.a(i2 + 1);
                this.f64807e.v = a2;
                if (this.f64807e.q != null) {
                    this.f64807e.q.setPosition(this.f64807e.x.c(a2));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.p0.v.i.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64808a;

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
            this.f64808a = dVar;
        }

        @Override // d.a.p0.v.i.d.c
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, b2Var) == null) {
                this.f64808a.F(view, b2Var);
                this.f64808a.A(b2Var);
                d dVar = this.f64808a;
                dVar.G(dVar.f53777f, b2Var);
            }
        }

        @Override // d.a.p0.v.i.d.c
        public void b(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                this.f64808a.F(view, b2Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 1;
        this.y = false;
        this.z = 5;
        this.A = true;
        this.C = new b(this);
        this.D = new c(this);
        this.m = (ForbidParentSwipeBackRelativeLayout) k().findViewById(R.id.layout_root);
        this.r = k().findViewById(R.id.divider_line);
        this.s = k().findViewById(R.id.divider_pager_and_indicator);
        this.n = (FrsAlaStageLiveViewPager) k().findViewById(R.id.frs_stage_live_listview);
        this.p = (LinearLayout) k().findViewById(R.id.frs_stage_indicator_parent);
        this.q = (IndicatorView) k().findViewById(R.id.frs_stage_indicator);
        d.a.p0.v.i.d.a aVar = new d.a.p0.v.i.d.a(tbPageContext, this.m);
        this.w = aVar;
        aVar.d(i());
        this.n.setBackgroundResource(R.drawable.transparent_bg);
        this.n.setOnPageChangeListener(this.C);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.f53777f, i());
        this.o = frsAlaStageLiveViewItemAdapter;
        this.n.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.f53777f.getOrignalPage() instanceof BaseActivity) {
            this.A = ((BaseActivity) this.f53777f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f53777f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.A = ((BaseFragmentActivity) this.f53777f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.m.setSwipeControlInterface(new a(this));
    }

    public final void A(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var.g1() == null || b2Var.g1().user_info == null || b2Var.g1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", b2Var.c0()));
    }

    public final void B() {
        h hVar;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.u) == null || !ListUtils.isEmpty(hVar.f57960e) || (c2 = this.x.c(this.v)) >= this.u.f57960e.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<b2> list = this.u.f57960e;
        if (list != null && list.get(c2) != null) {
            this.u.f57960e.get(c2).P1 = this.B;
        }
        customMessage.setData(this.u.f57960e.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.u.f57960e.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.u.f57960e.get(c2).c0()));
        }
    }

    public final void F(View view, b2 b2Var) {
        CustomMessage customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, b2Var) == null) {
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || this.f53777f == null) {
                return;
            }
            customMessage.setData(b2Var);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void G(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
        if (b2Var.g1() != null && b2Var.g1().user_info != null) {
            alaLiveInfoCoreData.userName = b2Var.g1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        h hVar = this.u;
        if (hVar != null && !ListUtils.isEmpty(hVar.f57960e)) {
            for (b2 b2Var2 : this.u.f57960e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(I(b2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: H */
    public void l(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) || hVar == null || hVar.f57960e == null) {
            return;
        }
        this.u = hVar;
        p(0);
        if (this.x == null) {
            d.a.p0.v.i.d.b bVar = new d.a.p0.v.i.d.b(hVar.f57960e, this.y, this.z);
            this.x = bVar;
            bVar.i(2);
            this.x.h(6);
            this.x.g(1);
        }
        this.x.j(hVar.f57960e);
        this.o.d(this.t);
        this.o.c(this.x.e(), this.D);
        this.n.setCurrentItem(this.x.d(), false);
        if (hVar.f57960e.size() >= 2) {
            this.p.setVisibility(0);
            if (this.q.getCount() != this.x.b()) {
                this.q.setCount(this.x.b());
                this.v = this.x.d();
            }
            this.q.setPosition(this.x.c(this.v));
        } else {
            this.p.setVisibility(8);
        }
        if (hVar.f57960e.size() > 0) {
            this.w.b(hVar.f57960e.get(0), "ala_frs_stage_live_feed_back_type");
        }
        B();
        m(j(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData I(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.t = str;
        }
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.frs_ala_stage_live_layout : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
                this.f53776e = i2;
            }
            this.w.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }
}
