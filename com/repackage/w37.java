package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class w37 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<vx5> a;
    public qp4 b;
    public long c;
    public int d;
    public List<uo> e;
    @Nullable
    public Map<String, Object> f;

    public w37() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = 1;
    }

    public final void e(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                this.e.add(threadData);
            }
        }
    }

    public ArrayList<uo> g(fq4 fq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fq4Var)) == null) {
            ArrayList<uo> arrayList = new ArrayList<>(this.e);
            m(arrayList, fq4Var);
            ArrayList<uo> arrayList2 = new ArrayList<>();
            Iterator<uo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        rq4 rq4Var = new rq4();
                        rq4Var.s = threadData;
                        rq4Var.position = i;
                        rq4Var.a = true;
                        arrayList2.add(rq4Var);
                        rq4 rq4Var2 = new rq4();
                        rq4Var2.s = threadData;
                        rq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rq4Var2.d = true;
                            rq4Var2.t = imageWidthAndHeight[0];
                            rq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rq4Var2.e = true;
                        } else {
                            rq4Var2.b = true;
                        }
                        arrayList2.add(rq4Var2);
                        if (threadData.getItem() != null) {
                            rq4 rq4Var3 = new rq4();
                            rq4Var3.n = true;
                            rq4Var3.s = threadData;
                            rq4Var3.position = i;
                            arrayList2.add(rq4Var3);
                        }
                        rq4 rq4Var4 = new rq4();
                        rq4Var4.m = true;
                        rq4Var4.s = threadData;
                        rq4Var4.position = i;
                        arrayList2.add(rq4Var4);
                        rq4 rq4Var5 = new rq4();
                        rq4Var5.g = true;
                        rq4Var5.s = threadData;
                        rq4Var5.position = i;
                        arrayList2.add(rq4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        rq4 rq4Var6 = new rq4();
                        rq4Var6.s = threadData;
                        rq4Var6.position = i;
                        rq4Var6.a = true;
                        arrayList2.add(rq4Var6);
                        rq4 rq4Var7 = new rq4();
                        rq4Var7.s = threadData;
                        rq4Var7.position = i;
                        rq4Var7.i = true;
                        arrayList2.add(rq4Var7);
                        if (threadData.getItem() != null) {
                            rq4 rq4Var8 = new rq4();
                            rq4Var8.n = true;
                            rq4Var8.s = threadData;
                            rq4Var8.position = i;
                            arrayList2.add(rq4Var8);
                        }
                        rq4 rq4Var9 = new rq4();
                        rq4Var9.m = true;
                        rq4Var9.s = threadData;
                        rq4Var9.position = i;
                        arrayList2.add(rq4Var9);
                        rq4 rq4Var10 = new rq4();
                        rq4Var10.g = true;
                        rq4Var10.s = threadData;
                        rq4Var10.position = i;
                        arrayList2.add(rq4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (cy5.W(threadData)) {
                        cy5 cy5Var = new cy5(threadData);
                        cy5Var.g = threadData.getTid();
                        arrayList2.add(cy5Var);
                    } else {
                        rq4 rq4Var11 = new rq4();
                        rq4Var11.s = threadData;
                        rq4Var11.position = i;
                        arrayList2.add(rq4Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public final void k(List<vx5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        vx5 vx5Var = list.get(list.size() - 1);
        if (vx5Var.getThreadData() != null) {
            this.c = mg.g(vx5Var.getThreadData().getTid(), 0L);
        }
    }

    public final void m(ArrayList<uo> arrayList, fq4 fq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, fq4Var) == null) || fq4Var == null || ListUtils.isEmpty(fq4Var.i())) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (arrayList.get(i) instanceof ThreadData) {
                if (fq4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, fq4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, fq4Var);
        }
    }

    public void q(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f = DataExt.toMap(dataRes);
        if (dataRes.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    vx5 vx5Var = null;
                    if (ey5.R(threadData)) {
                        vx5Var = new ey5(threadData);
                    } else if (dy5.W(threadData)) {
                        vx5Var = new dy5();
                        vx5Var.a = threadData;
                    }
                    if (vx5Var != null && vx5Var.isValid()) {
                        vx5Var.L("c10816");
                        this.a.add(vx5Var);
                    }
                }
            }
            k(this.a);
            e(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            qp4 qp4Var = new qp4();
            this.b = qp4Var;
            qp4Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    vx5 vx5Var = null;
                    if (threadData.isShareThread) {
                        vx5Var = new dy5();
                        vx5Var.a = threadData;
                    } else if (ey5.R(threadData)) {
                        vx5Var = new ey5(threadData);
                    } else if (dy5.W(threadData)) {
                        vx5Var = new dy5();
                        vx5Var.a = threadData;
                    }
                    if (vx5Var != null && vx5Var.isValid()) {
                        vx5Var.L("c10816");
                        this.a.add(vx5Var);
                    }
                }
            }
            k(this.a);
            e(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            qp4 qp4Var = new qp4();
            this.b = qp4Var;
            qp4Var.j(hotThread.page);
        }
    }

    public w37(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = i;
    }
}
