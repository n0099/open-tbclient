package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardExtendForumItemHolder;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iz5 extends cz5<l06> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public HListView t;
    public m47 u;
    public CardExtendForumItemHolder v;
    public View w;
    public View.OnClickListener x;
    public LikeModel y;
    public List<n47> z;

    /* loaded from: classes6.dex */
    public class a extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz5 a;

        public a(iz5 iz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz5Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof ck8) && this.a.y.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.a.y.getErrorCode(), this.a.y.getErrorString())) {
                    AntiHelper.u(this.a.getContext(), this.a.y.getErrorString());
                } else {
                    this.a.g().showToast(this.a.y.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(iz5 iz5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz5Var, Integer.valueOf(i)};
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
            this.a = iz5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(iz5 iz5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz5Var, Integer.valueOf(i)};
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
            this.a = iz5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz5 a;

        public d(iz5 iz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f090a2b) {
                if (ViewHelper.checkUpIsLogin(this.a.h().getContext())) {
                    String str = (String) view2.getTag(R.id.obfuscated_res_0x7f091ffa);
                    String valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f091ff9));
                    if (pi.isForumName(str)) {
                        this.a.y.Q(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.a.A).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, mz5.e()));
                    }
                }
            } else if (view2.getTag(R.id.obfuscated_res_0x7f091ffa) != null) {
                String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f091ffa);
                String valueOf2 = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f091ff9));
                if (pi.isForumName(str2)) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091451) {
                        TiebaStatic.log(new StatisticItem(this.a.C).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, mz5.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.a.B).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, mz5.e()));
                    }
                    if (!StringUtils.isNull(this.a.D) && !StringUtils.isNull(this.a.E)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.h().getContext()).createCfgForpersonalized(str2, this.a.D, this.a.E)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.h().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iz5(TbPageContext<?> tbPageContext) {
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
        this.F = new b(this, 2001336);
        this.G = new c(this, 2001335);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().a != null && TbadkCoreApplication.getInst().getPersonalizeViewData().a.getParent() == null) {
            this.w = TbadkCoreApplication.getInst().getPersonalizeViewData().a;
        } else {
            this.w = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0278, (ViewGroup) null);
        }
        this.v = new CardExtendForumItemHolder(this.w);
        this.q.addView(this.t);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080cc2);
        this.t.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0);
        C();
        if (this.u == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            m47 m47Var = new m47(getContext(), R.layout.obfuscated_res_0x7f0d0278, this.v);
            this.u = m47Var;
            m47Var.d(this.x);
            this.t.setAdapter((ListAdapter) this.u);
        }
        this.i.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.y = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.t.setOnItemClickListener(null);
    }

    public final k06 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.z) > 0) {
                for (n47 n47Var : this.z) {
                    if (n47Var != null && (n47Var instanceof k06)) {
                        k06 k06Var = (k06) n47Var;
                        if (String.valueOf(k06Var.d).equals(str)) {
                            return k06Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (k06) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = new d(this);
        }
    }

    public final boolean D(List<n47> list, List<n47> list2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i < ListUtils.getCount(list)) {
                n47 n47Var = (n47) ListUtils.getItem(list, i);
                n47 n47Var2 = (n47) ListUtils.getItem(list2, i);
                if (n47Var != null && (n47Var instanceof k06) && n47Var2 != null && (n47Var2 instanceof k06)) {
                    k06 k06Var = (k06) n47Var;
                    k06 k06Var2 = (k06) n47Var2;
                    if (k06Var.d != k06Var2.d) {
                        z = false;
                    }
                    if (!k06Var.b.equals(k06Var2.b)) {
                        z = false;
                    }
                    i = k06Var.c.equals(k06Var2.c) ? i + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cz5
    /* renamed from: E */
    public void t(l06 l06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l06Var) == null) {
            super.i(l06Var);
            if (l06Var != null && ListUtils.getCount(l06Var.getDataList()) > 0) {
                int count = ListUtils.getCount(l06Var.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(l06Var.getDataList());
                    l06Var.getDataList().clear();
                    l06Var.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.E = l06Var.h();
                this.D = l06Var.f();
                if (D(l06Var.getDataList(), this.z)) {
                    return;
                }
                boolean z = ListUtils.getCount(l06Var.getDataList()) != ListUtils.getCount(this.z);
                this.z = l06Var.getDataList();
                if (count <= 0) {
                    h().setVisibility(8);
                    return;
                }
                h().setVisibility(0);
                m47 m47Var = this.u;
                if (m47Var != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < this.z.size(); i++) {
                            arrayList2.add(String.valueOf(i));
                        }
                        m47 m47Var2 = new m47(getContext(), R.layout.obfuscated_res_0x7f0d0278, this.v);
                        this.u = m47Var2;
                        m47Var2.c(this.z);
                        this.u.d(this.x);
                        this.t.setAdapter((ListAdapter) this.u);
                        j(g(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    m47Var.c(this.z);
                    this.u.notifyDataSetChanged();
                    return;
                }
                return;
            }
            h().setVisibility(8);
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || (customMessageListener = this.F) == null || this.G == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.G.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.F);
        MessageManager.getInstance().registerListener(this.G);
    }

    public void G(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.A = str2;
            this.B = str3;
            this.C = str4;
        }
    }

    public final void H(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            k06 B = B(String.valueOf(j));
            if (B != null) {
                B.e = z;
            }
            m47 m47Var = this.u;
            if (m47Var != null) {
                m47Var.c(this.z);
                this.u.notifyDataSetChanged();
            }
        }
    }

    @Override // com.repackage.cz5, com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        m47 m47Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            super.j(tbPageContext, i);
            if (this.t == null || (m47Var = this.u) == null) {
                return;
            }
            m47Var.b(i);
        }
    }

    @Override // com.repackage.bz5
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
