package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdTypeRecyclerView b;
    public final List<nn> c;
    public CustomMessageListener d;
    public CustomMessageListener e;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vb5 vb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb5Var, Integer.valueOf(i)};
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
            this.a = vb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vb5 vb5Var = this.a;
                vb5Var.c(vb5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vb5 vb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb5Var, Integer.valueOf(i)};
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
            this.a = vb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vb5 vb5Var = this.a;
                vb5Var.c(vb5Var.b, customResponsedMessage);
            }
        }
    }

    public vb5(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = new a(this, 2016488);
        this.e = new b(this, 2016553);
        this.b = bdTypeRecyclerView;
    }

    public final void c(BdTypeRecyclerView bdTypeRecyclerView, CustomResponsedMessage<?> customResponsedMessage) {
        qq4 qq4Var;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bdTypeRecyclerView, customResponsedMessage) == null) || bdTypeRecyclerView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString("liveid");
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(optString2)) {
                int i = 0;
                while (true) {
                    if (i >= bdTypeRecyclerView.getCount()) {
                        break;
                    }
                    nn B = bdTypeRecyclerView.B(i);
                    if (B instanceof nn4) {
                        nn4 nn4Var = (nn4) B;
                        if (nn4Var.getThreadData() != null && nn4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(nn4Var.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = nn4Var.getThreadData().getTid();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<nn> it = this.c.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if ((next instanceof nn4) && (threadData2 = ((nn4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
                it.remove();
            }
        }
        List<nn> data = bdTypeRecyclerView.getData();
        if (ListUtils.isEmpty(data)) {
            return;
        }
        Iterator<nn> it2 = data.iterator();
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (it2.hasNext()) {
            nn next2 = it2.next();
            if ((next2 instanceof qq4) && (threadData = (qq4Var = (qq4) next2).s) != null) {
                if (i2 >= 0) {
                    if (qq4Var.position != i2) {
                        break;
                    }
                    it2.remove();
                    i4 = i5;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = qq4Var.position;
                    it2.remove();
                    i3 = i5;
                }
            }
            i5++;
        }
        if (i3 < i4) {
            bdTypeRecyclerView.E(i3, i4);
        }
    }

    public mb5 d(LoadType loadType, nb5 nb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, nb5Var)) == null) {
            if (nb5Var == null) {
                mb5 mb5Var = new mb5();
                mb5Var.a = null;
                return mb5Var;
            }
            List<ThreadData> f = nb5Var.f();
            List<nn4> e = nb5Var.e();
            nb5Var.h(f);
            fc5.b("response threadList =  " + ListUtils.getCount(f));
            if (!ListUtils.isEmpty(f)) {
                if (loadType == LoadType.REFRESH) {
                    this.c.clear();
                    this.c.addAll(f);
                } else if (loadType == LoadType.PREPEND) {
                    this.c.addAll(0, f);
                } else {
                    this.c.addAll(f);
                }
            }
            ArrayList arrayList = new ArrayList(ListUtils.getCount(this.c) + ListUtils.getCount(e));
            arrayList.addAll(this.c);
            fc5.b("dataList = " + ListUtils.getCount(arrayList));
            fc5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (nn4 nn4Var : e) {
                    gc5.b(arrayList, nn4Var);
                }
            }
            List<nn> d = nb5Var.d(arrayList);
            if (d == null) {
                d = gc5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            fc5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            mb5 mb5Var2 = new mb5();
            mb5Var2.a = d;
            nb5Var.g(mb5Var2);
            return mb5Var2;
        }
        return (mb5) invokeLL.objValue;
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            if (this.a != bdUniqueId) {
                this.d.setTag(bdUniqueId);
                this.e.setTag(bdUniqueId);
                MessageManager.getInstance().unRegisterListener(this.d);
                MessageManager.getInstance().unRegisterListener(this.e);
                MessageManager.getInstance().registerListener(this.d);
                MessageManager.getInstance().registerListener(this.e);
            }
            this.a = bdUniqueId;
        }
    }
}
