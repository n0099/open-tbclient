package d.a.q0.g1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.QualityThreadItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.q0.g1.c.m;
/* loaded from: classes8.dex */
public class i extends d.a.d.k.e.a<m, QualityThreadItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public HotTopicActivity n;
    public b o;
    public w p;

    /* loaded from: classes8.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f56867e;

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
            this.f56867e = iVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && nVar != null && (nVar instanceof m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                this.f56867e.g0((m) nVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f56868e;

        /* renamed from: f  reason: collision with root package name */
        public String f56869f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f56870g;

        public b(i iVar) {
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
            this.f56870g = iVar;
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.f56868e = str;
                this.f56869f = str2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && d.a.d.e.p.k.isForumName(this.f56868e)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f56870g.f42341e).createNormalCfg(this.f56868e, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new StatisticItem("c10523").param("fid", this.f56869f));
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new b(this, null);
        this.p = new a(this);
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        l0(i2, view, viewGroup, mVar, qualityThreadItemHolder);
        return view;
    }

    public final void g0(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null || mVar.b()) {
            return;
        }
        String valueOf = String.valueOf(mVar.f56987g);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.n.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.n), "hot_topic")));
        TiebaStatic.log(new StatisticItem("c10522").param("tid", valueOf).param("obj_id", this.n.getHotTopicId()));
    }

    public final void i0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, qualityThreadItemHolder, mVar) == null) || qualityThreadItemHolder == null || mVar == null) {
            return;
        }
        if (mVar.b()) {
            qualityThreadItemHolder.f17180c.setVisibility(0);
            qualityThreadItemHolder.f17181d.setVisibility(0);
            qualityThreadItemHolder.f17183f.setVisibility(8);
            qualityThreadItemHolder.f17182e.setVisibility(8);
            qualityThreadItemHolder.f17181d.setText(mVar.f56986f.trim());
            SkinManager.setBackgroundColor(qualityThreadItemHolder.a(), R.color.CAM_X0201);
            return;
        }
        qualityThreadItemHolder.f17180c.setVisibility(8);
        qualityThreadItemHolder.f17181d.setVisibility(8);
        qualityThreadItemHolder.f17183f.setVisibility(0);
        qualityThreadItemHolder.f17182e.setVisibility(0);
        qualityThreadItemHolder.f17184g.M(mVar.o, 10, false);
        qualityThreadItemHolder.f17185h.setText(mVar.f56988h.trim());
        qualityThreadItemHolder.f17186i.setText(mVar.j.trim());
        qualityThreadItemHolder.j.setText(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}));
        qualityThreadItemHolder.k.setText(StringHelper.numberUniformFormat(mVar.k));
        qualityThreadItemHolder.l.setText(StringHelper.numFormatOver10000(mVar.f56989i));
        m0(qualityThreadItemHolder, mVar);
    }

    public final void j0(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, qualityThreadItemHolder, view) == null) || qualityThreadItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || qualityThreadItemHolder.f17178a == skinType) {
            return;
        }
        qualityThreadItemHolder.f17178a = skinType;
        SkinManager.setBackgroundResource(qualityThreadItemHolder.a(), R.drawable.list_item_selector);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f17181d, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f17185h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.f17186i, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f17183f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.f17180c, R.color.CAM_X0204);
        qualityThreadItemHolder.f17184g.setImageDrawable(null);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: k0 */
    public QualityThreadItemHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new QualityThreadItemHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.hot_topic_quality_item, viewGroup, false)) : (QualityThreadItemHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mVar, qualityThreadItemHolder})) == null) {
            if (mVar != null && qualityThreadItemHolder != null) {
                j0(qualityThreadItemHolder, view);
                i0(qualityThreadItemHolder, mVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, qualityThreadItemHolder, mVar) == null) || qualityThreadItemHolder == null || mVar == null || this.n == null) {
            return;
        }
        a0(this.p);
        this.o.a(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}), String.valueOf(mVar.m));
        qualityThreadItemHolder.j.setOnClickListener(this.o);
    }
}
