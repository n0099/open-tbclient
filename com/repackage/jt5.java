package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jt5 extends rw5<ej8> implements px5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForbidParentSwipeBackRelativeLayout i;
    public FrsAlaStageLiveViewPager j;
    public FrsAlaStageLiveViewItemAdapter k;
    public LinearLayout l;
    public IndicatorView m;
    public View n;
    public View o;
    public String p;
    public ej8 q;
    public int r;
    public dt5 s;
    public et5 t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public ViewPager.OnPageChangeListener y;
    public ft5 z;

    /* loaded from: classes6.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;

        public a(jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt5Var;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.q == null || ListUtils.isEmpty(this.a.q.a) || this.a.q.a.size() <= 1) {
                return;
            }
            if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.w);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.w);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;

        public b(jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt5Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i == 1 || i != 0 || (count = this.a.k.getCount()) < 2) {
                return;
            }
            int currentItem = this.a.j.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.a.j.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.a.j.setCurrentItem(1, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.r = i;
                if (this.a.t == null) {
                    return;
                }
                int a = this.a.t.a(i + 1);
                this.a.r = a;
                if (this.a.m != null) {
                    this.a.m.setPosition(this.a.t.c(a));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ft5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt5 a;

        public c(jt5 jt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt5Var;
        }

        @Override // com.repackage.ft5
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, threadData) == null) {
                this.a.D(view2, threadData);
                this.a.B(threadData);
                jt5 jt5Var = this.a;
                jt5Var.E(jt5Var.b, threadData);
            }
        }

        @Override // com.repackage.ft5
        public void b(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.a.D(view2, threadData);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 1;
        this.u = false;
        this.v = 5;
        this.w = true;
        this.y = new b(this);
        this.z = new c(this);
        this.i = (ForbidParentSwipeBackRelativeLayout) k().findViewById(R.id.obfuscated_res_0x7f0911ea);
        this.n = k().findViewById(R.id.obfuscated_res_0x7f0907fd);
        this.o = k().findViewById(R.id.obfuscated_res_0x7f090809);
        this.j = (FrsAlaStageLiveViewPager) k().findViewById(R.id.obfuscated_res_0x7f090be6);
        this.l = (LinearLayout) k().findViewById(R.id.obfuscated_res_0x7f090be5);
        this.m = (IndicatorView) k().findViewById(R.id.obfuscated_res_0x7f090be4);
        dt5 dt5Var = new dt5(tbPageContext, this.i);
        this.s = dt5Var;
        dt5Var.d(i());
        this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f081207);
        this.j.setOnPageChangeListener(this.y);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.b, i());
        this.k = frsAlaStageLiveViewItemAdapter;
        this.j.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.b.getOrignalPage() instanceof BaseActivity) {
            this.w = ((BaseActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.b.getOrignalPage() instanceof BaseFragmentActivity) {
            this.w = ((BaseFragmentActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        }
        this.i.setSwipeControlInterface(new a(this));
    }

    public final void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().user_info == null || threadData.getThreadAlaInfo().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12805").param("tid", threadData.getId()));
    }

    public final void C() {
        ej8 ej8Var;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ej8Var = this.q) == null || !ListUtils.isEmpty(ej8Var.a) || (c2 = this.t.c(this.r)) >= this.q.a.size() || c2 < 0) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        List<ThreadData> list = this.q.a;
        if (list != null && list.get(c2) != null) {
            this.q.a.get(c2).statFloor = this.x;
        }
        customMessage.setData(this.q.a.get(c2));
        MessageManager.getInstance().sendMessage(customMessage);
        if (this.q.a.get(c2) != null) {
            TiebaStatic.log(new StatisticItem("c12804").param("tid", this.q.a.get(c2).getId()));
        }
    }

    public final void D(View view2, ThreadData threadData) {
        CustomMessage customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, threadData) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0911ea) {
                customMessage = new CustomMessage(2921018);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09054b && view2.getId() != R.id.obfuscated_res_0x7f090547) {
                customMessage = view2.getId() == R.id.obfuscated_res_0x7f0922fc ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || this.b == null) {
                return;
            }
            customMessage.setData(threadData);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void E(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, threadData) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null) {
            alaLiveInfoCoreData.userName = threadData.getThreadAlaInfo().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        ej8 ej8Var = this.q;
        if (ej8Var != null && !ListUtils.isEmpty(ej8Var.a)) {
            for (ThreadData threadData2 : this.q.a) {
                alaLiveInfoListCoreData.mLiveInfoList.add(G(threadData2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.p)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: F */
    public void l(ej8 ej8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ej8Var) == null) || ej8Var == null || ej8Var.a == null) {
            return;
        }
        this.q = ej8Var;
        p(0);
        if (this.t == null) {
            et5 et5Var = new et5(ej8Var.a, this.u, this.v);
            this.t = et5Var;
            et5Var.i(2);
            this.t.h(6);
            this.t.g(1);
        }
        this.t.j(ej8Var.a);
        this.k.d(this.p);
        this.k.c(this.t.e(), this.z);
        this.j.setCurrentItem(this.t.d(), false);
        if (ej8Var.a.size() >= 2) {
            this.l.setVisibility(0);
            if (this.m.getCount() != this.t.b()) {
                this.m.setCount(this.t.b());
                this.r = this.t.d();
            }
            this.m.setPosition(this.t.c(this.r));
        } else {
            this.l.setVisibility(8);
        }
        if (ej8Var.a.size() > 0) {
            this.s.b(ej8Var.a.get(0), "ala_frs_stage_live_feed_back_type");
        }
        C();
        m(j(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData G(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.repackage.px5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d0303 : invokeV.intValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
                this.a = i;
            }
            this.s.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    @Override // com.repackage.px5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }
}
