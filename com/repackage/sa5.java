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
public class sa5 {
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
        public final /* synthetic */ sa5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sa5 sa5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa5Var, Integer.valueOf(i)};
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
            this.a = sa5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                sa5 sa5Var = this.a;
                sa5Var.c(sa5Var.b, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sa5 sa5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa5Var, Integer.valueOf(i)};
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
            this.a = sa5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                sa5 sa5Var = this.a;
                sa5Var.c(sa5Var.b, customResponsedMessage);
            }
        }
    }

    public sa5(BdTypeRecyclerView bdTypeRecyclerView) {
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
        bq4 bq4Var;
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
                    nn C = bdTypeRecyclerView.C(i);
                    if (C instanceof ym4) {
                        ym4 ym4Var = (ym4) C;
                        if (ym4Var.getThreadData() != null && ym4Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(ym4Var.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = ym4Var.getThreadData().getTid();
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
            if ((next instanceof ym4) && (threadData2 = ((ym4) next).getThreadData()) != null && !TextUtils.isEmpty(threadData2.getTid()) && optString.equals(threadData2.getTid())) {
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
            if ((next2 instanceof bq4) && (threadData = (bq4Var = (bq4) next2).s) != null) {
                if (i2 >= 0) {
                    if (bq4Var.position != i2) {
                        break;
                    }
                    it2.remove();
                    i4 = i5;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = bq4Var.position;
                    it2.remove();
                    i3 = i5;
                }
            }
            i5++;
        }
        if (i3 < i4) {
            bdTypeRecyclerView.F(i3, i4);
        }
    }

    public ja5 d(LoadType loadType, ka5 ka5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadType, ka5Var)) == null) {
            if (ka5Var == null) {
                ja5 ja5Var = new ja5();
                ja5Var.a = null;
                return ja5Var;
            }
            List<ThreadData> f = ka5Var.f();
            List<ym4> e = ka5Var.e();
            ka5Var.h(f);
            cb5.b("response threadList =  " + ListUtils.getCount(f));
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
            cb5.b("dataList = " + ListUtils.getCount(arrayList));
            cb5.b("floorList = " + ListUtils.getCount(e));
            if (!ListUtils.isEmpty(e)) {
                for (ym4 ym4Var : e) {
                    db5.b(arrayList, ym4Var);
                }
            }
            List<nn> d = ka5Var.d(arrayList);
            if (d == null) {
                d = db5.a(arrayList);
            }
            int count = ListUtils.getCount(d);
            int count2 = ListUtils.getCount(f);
            cb5.b("addThreadCount=" + count2 + ",resultThreadList=" + count);
            ja5 ja5Var2 = new ja5();
            ja5Var2.a = d;
            ka5Var.g(ja5Var2);
            return ja5Var2;
        }
        return (ja5) invokeLL.objValue;
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
