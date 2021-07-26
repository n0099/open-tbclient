package d.a.q0.g1.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumHorizonalListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.g1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a0.c<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelateForumHorizonalListView x;
    public List<d.a.d.k.e.n> y;
    public TbPageContext<?> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.z = tbPageContext;
        this.x = new RelateForumHorizonalListView(b());
        this.y = new ArrayList();
        this.x.setTag(i());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        v(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        u(false);
    }

    @Override // d.a.q0.a0.c, d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            super.m(tbPageContext, i2);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.l(i2);
            }
        }
    }

    @Override // d.a.q0.a0.b
    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            super.o(bdUniqueId);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView != null) {
                relateForumHorizonalListView.setTag(i());
            }
        }
    }

    @Override // d.a.q0.a0.c, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            RelateForumHorizonalListView relateForumHorizonalListView = this.x;
            if (relateForumHorizonalListView == null || relateForumHorizonalListView.getLastItemView() != view || this.y == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            this.z.sendMessage(new CustomMessage(2002001, new RelateTopicForumActivityConfig(this.z.getPageActivity(), this.y, ((HotTopicActivity) this.z.getOrignalPage()).getHotTopicId())));
        }
    }

    @Override // d.a.q0.a0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.setFrom(str);
            this.x.setFrom(str);
        }
    }

    public final List<d.a.p0.d1.g.a> w(List<d.a.d.k.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (d.a.d.k.e.n nVar : list) {
                if (nVar instanceof RelateForumItemData) {
                    RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                    long j = relateForumItemData.forumId;
                    String str = relateForumItemData.forumName;
                    String str2 = relateForumItemData.forumAvatar;
                    boolean z = relateForumItemData.isLiked;
                    if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        d.a.p0.d1.g.a aVar = new d.a.p0.d1.g.a();
                        aVar.f52308b = str2;
                        aVar.f52310d = j;
                        aVar.f52309c = str;
                        aVar.f52311e = z;
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: x */
    public void l(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            super.t(nVar);
            if (nVar == null) {
                k().setVisibility(8);
                return;
            }
            this.y.clear();
            List<d.a.d.k.e.n> list = nVar.f56991e;
            if (list != null) {
                this.y.addAll(list);
            }
            List<d.a.p0.d1.g.a> w = w(this.y);
            int count = ListUtils.getCount(w);
            if (count <= 0) {
                k().setVisibility(8);
                return;
            }
            k().setVisibility(0);
            if (count > 10) {
                this.x.setData(w.subList(0, 10), j(), true);
            } else {
                this.x.setData(w, j(), false);
            }
            m(j(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
