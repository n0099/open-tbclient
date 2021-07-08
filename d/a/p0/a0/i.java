package d.a.p0.a0;

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
/* loaded from: classes7.dex */
public class i extends d.a.p0.a0.c<d.a.p0.a0.e0.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater A;
    public View B;
    public View.OnClickListener C;
    public LikeModel D;
    public List<d.a.p0.f1.b.c> E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public HListView x;
    public d.a.p0.f1.b.b y;
    public CardExtendForumItemHolder z;

    /* loaded from: classes7.dex */
    public class a extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f53836a;

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
            this.f53836a = iVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof d.a.p0.h3.w) && this.f53836a.D.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.f53836a.D.getErrorCode(), this.f53836a.D.getErrorString())) {
                    AntiHelper.u(this.f53836a.b(), this.f53836a.D.getErrorString());
                } else {
                    this.f53836a.j().showToast(this.f53836a.D.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f53837a;

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
            this.f53837a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f53837a.M(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f53838a;

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
            this.f53838a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f53838a.M(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f53839e;

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
            this.f53839e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.forum_add_love) {
                if (ViewHelper.checkUpIsLogin(this.f53839e.k().getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    if (d.a.c.e.p.k.isForumName(str)) {
                        this.f53839e.D.L(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.f53839e.F).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                }
            } else if (view.getTag(R.id.tag_forum_name) != null) {
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (d.a.c.e.p.k.isForumName(str2)) {
                    if (view.getId() == R.id.m_forum_name_textview) {
                        TiebaStatic.log(new StatisticItem(this.f53839e.H).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.f53839e.G).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                    if (!StringUtils.isNull(this.f53839e.I) && !StringUtils.isNull(this.f53839e.J)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53839e.k().getContext()).createCfgForpersonalized(str2, this.f53839e.I, this.f53839e.J)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f53839e.k().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
        H();
        if (this.y == null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < 10; i4++) {
                arrayList.add(String.valueOf(i4));
            }
            d.a.p0.f1.b.b bVar = new d.a.p0.f1.b.b(b(), R.layout.extend_forum_item, this.z);
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

    public final d.a.p0.a0.e0.g G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.E) > 0) {
                for (d.a.p0.f1.b.c cVar : this.E) {
                    if (cVar != null && (cVar instanceof d.a.p0.a0.e0.g)) {
                        d.a.p0.a0.e0.g gVar = (d.a.p0.a0.e0.g) cVar;
                        if (String.valueOf(gVar.f53807d).equals(str)) {
                            return gVar;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (d.a.p0.a0.e0.g) invokeL.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.C = new d(this);
        }
    }

    public final boolean I(List<d.a.p0.f1.b.c> list, List<d.a.p0.f1.b.c> list2) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i2 < ListUtils.getCount(list)) {
                d.a.p0.f1.b.c cVar = (d.a.p0.f1.b.c) ListUtils.getItem(list, i2);
                d.a.p0.f1.b.c cVar2 = (d.a.p0.f1.b.c) ListUtils.getItem(list2, i2);
                if (cVar != null && (cVar instanceof d.a.p0.a0.e0.g) && cVar2 != null && (cVar2 instanceof d.a.p0.a0.e0.g)) {
                    d.a.p0.a0.e0.g gVar = (d.a.p0.a0.e0.g) cVar;
                    d.a.p0.a0.e0.g gVar2 = (d.a.p0.a0.e0.g) cVar2;
                    if (gVar.f53807d != gVar2.f53807d) {
                        z = false;
                    }
                    if (!gVar.f53805b.equals(gVar2.f53805b)) {
                        z = false;
                    }
                    i2 = gVar.f53806c.equals(gVar2.f53806c) ? i2 + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: J */
    public void l(d.a.p0.a0.e0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            super.t(iVar);
            if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
                int count = ListUtils.getCount(iVar.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(iVar.getDataList());
                    iVar.getDataList().clear();
                    iVar.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.J = iVar.e();
                this.I = iVar.d();
                if (I(iVar.getDataList(), this.E)) {
                    return;
                }
                boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.E);
                this.E = iVar.getDataList();
                if (count <= 0) {
                    k().setVisibility(8);
                    return;
                }
                k().setVisibility(0);
                d.a.p0.f1.b.b bVar = this.y;
                if (bVar != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < this.E.size(); i2++) {
                            arrayList2.add(String.valueOf(i2));
                        }
                        d.a.p0.f1.b.b bVar2 = new d.a.p0.f1.b.b(b(), R.layout.extend_forum_item, this.z);
                        this.y = bVar2;
                        bVar2.c(this.E);
                        this.y.d(this.C);
                        this.x.setAdapter((ListAdapter) this.y);
                        m(j(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    bVar.c(this.E);
                    this.y.notifyDataSetChanged();
                    return;
                }
                return;
            }
            k().setVisibility(8);
        }
    }

    public void K(BdUniqueId bdUniqueId) {
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

    public void L(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.F = str2;
            this.G = str3;
            this.H = str4;
        }
    }

    public final void M(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            d.a.p0.a0.e0.g G = G(String.valueOf(j));
            if (G != null) {
                G.f53808e = z;
            }
            d.a.p0.f1.b.b bVar = this.y;
            if (bVar != null) {
                bVar.c(this.E);
                this.y.notifyDataSetChanged();
            }
        }
    }

    @Override // d.a.p0.a0.c, d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        d.a.p0.f1.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            super.m(tbPageContext, i2);
            if (this.x == null || (bVar = this.y) == null) {
                return;
            }
            bVar.b(i2);
        }
    }

    @Override // d.a.p0.a0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
