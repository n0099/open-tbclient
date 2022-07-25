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
public class wb5 {
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
        public final /* synthetic */ wb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wb5 wb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb5Var, Integer.valueOf(i)};
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
            this.a = wb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                wb5 wb5Var = this.a;
                wb5Var.c(wb5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wb5 wb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb5Var, Integer.valueOf(i)};
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
            this.a = wb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                wb5 wb5Var = this.a;
                wb5Var.c(wb5Var.b, customResponsedMessage);
            }
        }
    }

    public wb5(BdTypeRecyclerView bdTypeRecyclerView) {
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
        rq4 rq4Var;
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
                    if (B instanceof on4) {
                        on4 on4Var = (on4) B;
                        if (on4Var.getThreadData() != null && on4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(on4Var.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = on4Var.getThreadData().getTid();
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
            if ((next instanceof on4) && (threadData2 = ((on4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
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
            if ((next2 instanceof rq4) && (threadData = (rq4Var = (rq4) next2).s) != null) {
                if (i2 >= 0) {
                    if (rq4Var.position != i2) {
                        break;
                    }
                    it2.remove();
                    i4 = i5;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = rq4Var.position;
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

    public nb5 d(LoadType loadType, ob5 ob5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, ob5Var)) == null) {
            if (ob5Var == null) {
                nb5 nb5Var = new nb5();
                nb5Var.a = null;
                return nb5Var;
            }
            List<ThreadData> f = ob5Var.f();
            List<on4> e = ob5Var.e();
            ob5Var.h(f);
            gc5.b("response threadList =  " + ListUtils.getCount(f));
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
            gc5.b("dataList = " + ListUtils.getCount(arrayList));
            gc5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (on4 on4Var : e) {
                    hc5.b(arrayList, on4Var);
                }
            }
            List<nn> d = ob5Var.d(arrayList);
            if (d == null) {
                d = hc5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            gc5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            nb5 nb5Var2 = new nb5();
            nb5Var2.a = d;
            ob5Var.g(nb5Var2);
            return nb5Var2;
        }
        return (nb5) invokeLL.objValue;
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
