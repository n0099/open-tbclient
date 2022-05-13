package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.ala.view.ParentDisallowInterceptHListView;
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
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class jt5 extends uw5<hi8> implements sx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public LinearLayout m;
    public View n;
    public ForbidParentSwipeBackRelativeLayout o;
    public ParentDisallowInterceptHListView p;
    public zs5 q;
    public boolean r;
    public hi8 s;
    public String t;
    public AdapterView.d u;

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.s == null || ListUtils.isEmpty(this.a.s.a) || this.a.s.a.size() <= 1) {
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
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.d {
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

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ThreadData item = this.a.q.getItem(i);
                this.a.v(item);
                jt5 jt5Var = this.a;
                jt5Var.x(jt5Var.b, item);
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
        this.r = true;
        this.u = new b(this);
        this.o = (ForbidParentSwipeBackRelativeLayout) k().findViewById(R.id.obfuscated_res_0x7f0911f9);
        this.i = (ThreadSkinView) k().findViewById(R.id.obfuscated_res_0x7f090be1);
        this.j = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090b36);
        this.k = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090b38);
        this.l = (RelativeLayout) k().findViewById(R.id.obfuscated_res_0x7f090b39);
        this.p = (ParentDisallowInterceptHListView) k().findViewById(R.id.obfuscated_res_0x7f090b37);
        this.m = (LinearLayout) k().findViewById(R.id.obfuscated_res_0x7f090ad3);
        this.n = k().findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.p.setDividerWidth(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e));
        this.p.setBackgroundResource(R.drawable.obfuscated_res_0x7f081221);
        this.p.setOnItemClickListener(this.u);
        this.p.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081221));
        zs5 zs5Var = new zs5(tbPageContext);
        this.q = zs5Var;
        this.p.setAdapter((ListAdapter) zs5Var);
        this.k.setOnClickListener(this);
        if (this.b.getOrignalPage() instanceof BaseActivity) {
            this.r = ((BaseActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.b.getOrignalPage() instanceof BaseFragmentActivity) {
            this.r = ((BaseFragmentActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        }
        this.o.setSwipeControlInterface(new a(this));
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.t = str;
        }
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d02f7 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.o, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 == this.k) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.b.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) || threadData == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(threadData);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.s.a)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.s.a.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void x(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, threadData) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
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
        hi8 hi8Var = this.s;
        if (hi8Var != null && !ListUtils.isEmpty(hi8Var.a)) {
            for (ThreadData threadData2 : this.s.a) {
                alaLiveInfoListCoreData.mLiveInfoList.add(z(threadData2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: y */
    public void l(hi8 hi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, hi8Var) == null) || hi8Var == null) {
            return;
        }
        this.s = hi8Var;
        w();
        this.q.b(hi8Var.a);
        m(j(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData z(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }
}
