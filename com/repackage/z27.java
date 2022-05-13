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
public class z27 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yx5> a;
    public aq4 b;
    public long c;
    public int d;
    public List<ro> e;
    @Nullable
    public Map<String, Object> f;

    public z27() {
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

    public ArrayList<ro> g(pq4 pq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pq4Var)) == null) {
            ArrayList<ro> arrayList = new ArrayList<>(this.e);
            m(arrayList, pq4Var);
            ArrayList<ro> arrayList2 = new ArrayList<>();
            Iterator<ro> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ro next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        br4 br4Var = new br4();
                        br4Var.s = threadData;
                        br4Var.position = i;
                        br4Var.a = true;
                        arrayList2.add(br4Var);
                        br4 br4Var2 = new br4();
                        br4Var2.s = threadData;
                        br4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            br4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            br4Var2.d = true;
                            br4Var2.t = imageWidthAndHeight[0];
                            br4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            br4Var2.e = true;
                        } else {
                            br4Var2.b = true;
                        }
                        arrayList2.add(br4Var2);
                        if (threadData.getItem() != null) {
                            br4 br4Var3 = new br4();
                            br4Var3.n = true;
                            br4Var3.s = threadData;
                            br4Var3.position = i;
                            arrayList2.add(br4Var3);
                        }
                        br4 br4Var4 = new br4();
                        br4Var4.m = true;
                        br4Var4.s = threadData;
                        br4Var4.position = i;
                        arrayList2.add(br4Var4);
                        br4 br4Var5 = new br4();
                        br4Var5.g = true;
                        br4Var5.s = threadData;
                        br4Var5.position = i;
                        arrayList2.add(br4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        br4 br4Var6 = new br4();
                        br4Var6.s = threadData;
                        br4Var6.position = i;
                        br4Var6.a = true;
                        arrayList2.add(br4Var6);
                        br4 br4Var7 = new br4();
                        br4Var7.s = threadData;
                        br4Var7.position = i;
                        br4Var7.i = true;
                        arrayList2.add(br4Var7);
                        if (threadData.getItem() != null) {
                            br4 br4Var8 = new br4();
                            br4Var8.n = true;
                            br4Var8.s = threadData;
                            br4Var8.position = i;
                            arrayList2.add(br4Var8);
                        }
                        br4 br4Var9 = new br4();
                        br4Var9.m = true;
                        br4Var9.s = threadData;
                        br4Var9.position = i;
                        arrayList2.add(br4Var9);
                        br4 br4Var10 = new br4();
                        br4Var10.g = true;
                        br4Var10.s = threadData;
                        br4Var10.position = i;
                        arrayList2.add(br4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (fy5.W(threadData)) {
                        fy5 fy5Var = new fy5(threadData);
                        fy5Var.g = threadData.getTid();
                        arrayList2.add(fy5Var);
                    } else {
                        br4 br4Var11 = new br4();
                        br4Var11.s = threadData;
                        br4Var11.position = i;
                        arrayList2.add(br4Var11);
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

    public final void k(List<yx5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        yx5 yx5Var = list.get(list.size() - 1);
        if (yx5Var.getThreadData() != null) {
            this.c = kg.g(yx5Var.getThreadData().getTid(), 0L);
        }
    }

    public final void m(ArrayList<ro> arrayList, pq4 pq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, pq4Var) == null) || pq4Var == null || ListUtils.isEmpty(pq4Var.i())) {
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
                if (pq4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, pq4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, pq4Var);
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
                    yx5 yx5Var = null;
                    if (hy5.R(threadData)) {
                        yx5Var = new hy5(threadData);
                    } else if (gy5.W(threadData)) {
                        yx5Var = new gy5();
                        yx5Var.a = threadData;
                    }
                    if (yx5Var != null && yx5Var.isValid()) {
                        yx5Var.L("c10816");
                        this.a.add(yx5Var);
                    }
                }
            }
            k(this.a);
            e(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            aq4 aq4Var = new aq4();
            this.b = aq4Var;
            aq4Var.j(dataRes.page);
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
                    yx5 yx5Var = null;
                    if (threadData.isShareThread) {
                        yx5Var = new gy5();
                        yx5Var.a = threadData;
                    } else if (hy5.R(threadData)) {
                        yx5Var = new hy5(threadData);
                    } else if (gy5.W(threadData)) {
                        yx5Var = new gy5();
                        yx5Var.a = threadData;
                    }
                    if (yx5Var != null && yx5Var.isValid()) {
                        yx5Var.L("c10816");
                        this.a.add(yx5Var);
                    }
                }
            }
            k(this.a);
            e(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            aq4 aq4Var = new aq4();
            this.b = aq4Var;
            aq4Var.j(hotThread.page);
        }
    }

    public z27(int i) {
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
