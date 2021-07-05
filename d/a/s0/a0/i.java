package d.a.s0.a0;

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
/* loaded from: classes9.dex */
public class i extends d.a.s0.a0.c<d.a.s0.a0.e0.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater A;
    public View B;
    public View.OnClickListener C;
    public LikeModel D;
    public List<d.a.s0.f1.b.c> E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public HListView x;
    public d.a.s0.f1.b.b y;
    public CardExtendForumItemHolder z;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f57091a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57091a = iVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof d.a.s0.h3.w) && this.f57091a.D.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.f57091a.D.getErrorCode(), this.f57091a.D.getErrorString())) {
                    AntiHelper.u(this.f57091a.b(), this.f57091a.D.getErrorString());
                } else {
                    this.f57091a.k().showToast(this.f57091a.D.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f57092a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57092a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f57092a.N(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f57093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57093a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f57093a.N(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f57094e;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57094e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.forum_add_love) {
                if (ViewHelper.checkUpIsLogin(this.f57094e.l().getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    if (d.a.c.e.p.k.isForumName(str)) {
                        this.f57094e.D.L(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.f57094e.F).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                }
            } else if (view.getTag(R.id.tag_forum_name) != null) {
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (d.a.c.e.p.k.isForumName(str2)) {
                    if (view.getId() == R.id.m_forum_name_textview) {
                        TiebaStatic.log(new StatisticItem(this.f57094e.H).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.f57094e.G).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                    if (!StringUtils.isNull(this.f57094e.I) && !StringUtils.isNull(this.f57094e.J)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57094e.l().getContext()).createCfgForpersonalized(str2, this.f57094e.I, this.f57094e.J)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57094e.l().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
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
        this.K = new b(this, 2001336);
        this.L = new c(this, 2001335);
        HListView hListView = new HListView(b());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        LayoutInflater from = LayoutInflater.from(b());
        this.A = from;
        this.B = from.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.z = new CardExtendForumItemHolder(this.B);
        this.u.addView(this.x);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.x.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        I();
        if (this.y == null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < 10; i4++) {
                arrayList.add(String.valueOf(i4));
            }
            d.a.s0.f1.b.b bVar = new d.a.s0.f1.b.b(b(), R.layout.extend_forum_item, this.z);
            this.y = bVar;
            bVar.d(this.C);
            this.x.setAdapter((ListAdapter) this.y);
        }
        this.m.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.D = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.x.setOnItemClickListener(null);
    }

    public final d.a.s0.a0.e0.g H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.E) > 0) {
                for (d.a.s0.f1.b.c cVar : this.E) {
                    if (cVar != null && (cVar instanceof d.a.s0.a0.e0.g)) {
                        d.a.s0.a0.e0.g gVar = (d.a.s0.a0.e0.g) cVar;
                        if (String.valueOf(gVar.f57062d).equals(str)) {
                            return gVar;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (d.a.s0.a0.e0.g) invokeL.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.C = new d(this);
        }
    }

    public final boolean J(List<d.a.s0.f1.b.c> list, List<d.a.s0.f1.b.c> list2) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i2 < ListUtils.getCount(list)) {
                d.a.s0.f1.b.c cVar = (d.a.s0.f1.b.c) ListUtils.getItem(list, i2);
                d.a.s0.f1.b.c cVar2 = (d.a.s0.f1.b.c) ListUtils.getItem(list2, i2);
                if (cVar != null && (cVar instanceof d.a.s0.a0.e0.g) && cVar2 != null && (cVar2 instanceof d.a.s0.a0.e0.g)) {
                    d.a.s0.a0.e0.g gVar = (d.a.s0.a0.e0.g) cVar;
                    d.a.s0.a0.e0.g gVar2 = (d.a.s0.a0.e0.g) cVar2;
                    if (gVar.f57062d != gVar2.f57062d) {
                        z = false;
                    }
                    if (!gVar.f57060b.equals(gVar2.f57060b)) {
                        z = false;
                    }
                    i2 = gVar.f57061c.equals(gVar2.f57061c) ? i2 + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: K */
    public void m(d.a.s0.a0.e0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            super.u(iVar);
            if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
                int count = ListUtils.getCount(iVar.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(iVar.getDataList());
                    iVar.getDataList().clear();
                    iVar.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.J = iVar.e();
                this.I = iVar.d();
                if (J(iVar.getDataList(), this.E)) {
                    return;
                }
                boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.E);
                this.E = iVar.getDataList();
                if (count <= 0) {
                    l().setVisibility(8);
                    return;
                }
                l().setVisibility(0);
                d.a.s0.f1.b.b bVar = this.y;
                if (bVar != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < this.E.size(); i2++) {
                            arrayList2.add(String.valueOf(i2));
                        }
                        d.a.s0.f1.b.b bVar2 = new d.a.s0.f1.b.b(b(), R.layout.extend_forum_item, this.z);
                        this.y = bVar2;
                        bVar2.c(this.E);
                        this.y.d(this.C);
                        this.x.setAdapter((ListAdapter) this.y);
                        n(k(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    bVar.c(this.E);
                    this.y.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l().setVisibility(8);
        }
    }

    public void L(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || (customMessageListener = this.K) == null || this.L == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.L.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.K);
        MessageManager.getInstance().registerListener(this.L);
    }

    public void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.F = str2;
            this.G = str3;
            this.H = str4;
        }
    }

    public final void N(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            d.a.s0.a0.e0.g H = H(String.valueOf(j));
            if (H != null) {
                H.f57063e = z;
            }
            d.a.s0.f1.b.b bVar = this.y;
            if (bVar != null) {
                bVar.c(this.E);
                this.y.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.s0.a0.c, d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        d.a.s0.f1.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            super.n(tbPageContext, i2);
            if (this.x == null || (bVar = this.y) == null) {
                return;
            }
            bVar.b(i2);
        }
    }

    @Override // d.a.s0.a0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
