package d.a.s0.v.i.e;

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
import d.a.r0.r.q.b2;
import d.a.s0.a0.z;
import d.a.s0.h3.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.s0.a0.b<h> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public ViewPager.OnPageChangeListener C;
    public d.a.s0.v.i.d.c D;
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
    public d.a.s0.v.i.d.a w;
    public d.a.s0.v.i.d.b x;
    public boolean y;
    public int z;

    /* loaded from: classes9.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68024e;

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
            this.f68024e = dVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f68024e.u == null || ListUtils.isEmpty(this.f68024e.u.f61204e) || this.f68024e.u.f61204e.size() <= 1) {
                return;
            }
            if (this.f68024e.f57032f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f68024e.f57032f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f68024e.f57032f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f68024e.f57032f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f68024e.f57032f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f68024e.f57032f.getOrignalPage()).setSwipeBackEnabled(this.f68024e.A);
                } else if (this.f68024e.f57032f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f68024e.f57032f.getOrignalPage()).setSwipeBackEnabled(this.f68024e.A);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68025e;

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
            this.f68025e = dVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 1 || i2 != 0 || (count = this.f68025e.o.getCount()) < 2) {
                return;
            }
            int currentItem = this.f68025e.n.getCurrentItem();
            int i3 = count - 2;
            if (currentItem < 1) {
                this.f68025e.n.setCurrentItem(i3, false);
            } else if (currentItem > i3) {
                this.f68025e.n.setCurrentItem(1, false);
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
                this.f68025e.v = i2;
                if (this.f68025e.x == null) {
                    return;
                }
                int a2 = this.f68025e.x.a(i2 + 1);
                this.f68025e.v = a2;
                if (this.f68025e.q != null) {
                    this.f68025e.q.setPosition(this.f68025e.x.c(a2));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.s0.v.i.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f68026a;

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
            this.f68026a = dVar;
        }

        @Override // d.a.s0.v.i.d.c
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, b2Var) == null) {
                this.f68026a.G(view, b2Var);
                this.f68026a.B(b2Var);
                d dVar = this.f68026a;
                dVar.H(dVar.f57032f, b2Var);
            }
        }

        @Override // d.a.s0.v.i.d.c
        public void b(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                this.f68026a.G(view, b2Var);
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
        this.m = (ForbidParentSwipeBackRelativeLayout) l().findViewById(R.id.layout_root);
        this.r = l().findViewById(R.id.divider_line);
        this.s = l().findViewById(R.id.divider_pager_and_indicator);
        this.n = (FrsAlaStageLiveViewPager) l().findViewById(R.id.frs_stage_live_listview);
        this.p = (LinearLayout) l().findViewById(R.id.frs_stage_indicator_parent);
        this.q = (IndicatorView) l().findViewById(R.id.frs_stage_indicator);
        d.a.s0.v.i.d.a aVar = new d.a.s0.v.i.d.a(tbPageContext, this.m);
        this.w = aVar;
        aVar.d(j());
        this.n.setBackgroundResource(R.drawable.transparent_bg);
        this.n.setOnPageChangeListener(this.C);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.f57032f, j());
        this.o = frsAlaStageLiveViewItemAdapter;
        this.n.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.f57032f.getOrignalPage() instanceof BaseActivity) {
            this.A = ((BaseActivity) this.f57032f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f57032f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.A = ((BaseFragmentActivity) this.f57032f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.m.setSwipeControlInterface(new a(this));
    }

    public final void B(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var.g1() == null || b2Var.g1().user_info == null || b2Var.g1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", b2Var.c0()));
    }

    public final void F() {
        h hVar;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.u) == null || !ListUtils.isEmpty(hVar.f61204e) || (c2 = this.x.c(this.v)) >= this.u.f61204e.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<b2> list = this.u.f61204e;
        if (list != null && list.get(c2) != null) {
            this.u.f61204e.get(c2).P1 = this.B;
        }
        customMessage.setData(this.u.f61204e.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.u.f61204e.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.u.f61204e.get(c2).c0()));
        }
    }

    public final void G(View view, b2 b2Var) {
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
            if (customMessage == null || this.f57032f == null) {
                return;
            }
            customMessage.setData(b2Var);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void H(TbPageContext<?> tbPageContext, b2 b2Var) {
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
        if (hVar != null && !ListUtils.isEmpty(hVar.f61204e)) {
            for (b2 b2Var2 : this.u.f61204e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(J(b2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: I */
    public void m(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) || hVar == null || hVar.f61204e == null) {
            return;
        }
        this.u = hVar;
        q(0);
        if (this.x == null) {
            d.a.s0.v.i.d.b bVar = new d.a.s0.v.i.d.b(hVar.f61204e, this.y, this.z);
            this.x = bVar;
            bVar.i(2);
            this.x.h(6);
            this.x.g(1);
        }
        this.x.j(hVar.f61204e);
        this.o.g(this.t);
        this.o.f(this.x.e(), this.D);
        this.n.setCurrentItem(this.x.d(), false);
        if (hVar.f61204e.size() >= 2) {
            this.p.setVisibility(0);
            if (this.q.getCount() != this.x.b()) {
                this.q.setCount(this.x.b());
                this.v = this.x.d();
            }
            this.q.setPosition(this.x.c(this.v));
        } else {
            this.p.setVisibility(8);
        }
        if (hVar.f61204e.size() > 0) {
            this.w.b(hVar.f61204e.get(0), "ala_frs_stage_live_feed_back_type");
        }
        F();
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData J(b2 b2Var) {
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

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.t = str;
        }
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.frs_ala_stage_live_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i2) == null) {
            if (this.f57031e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
                this.f57031e = i2;
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

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }
}
