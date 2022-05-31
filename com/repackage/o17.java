package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wm> a;

    public o17(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        fb6 fb6Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921336, fb6.class, tbPageContext);
        if (runTask != null && (fb6Var = (fb6) runTask.getData()) != null) {
            this.a.add(fb6Var);
        }
        this.a.add(new p17(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC));
        this.a.add(new n17(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC_VIDEO));
        bdTypeRecyclerView.a(this.a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        for (wm wmVar : this.a) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).j0(tbPageTag);
            }
        }
    }
}
