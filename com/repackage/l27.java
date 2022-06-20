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
/* loaded from: classes6.dex */
public class l27 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qx5> a;
    public zo4 b;
    public long c;
    public int d;
    public List<nn> e;
    @Nullable
    public Map<String, Object> f;

    public l27() {
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

    public final void c(@NonNull List<ThreadInfo> list) {
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

    public ArrayList<nn> f(op4 op4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, op4Var)) == null) {
            ArrayList<nn> arrayList = new ArrayList<>(this.e);
            l(arrayList, op4Var);
            ArrayList<nn> arrayList2 = new ArrayList<>();
            Iterator<nn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        bq4 bq4Var = new bq4();
                        bq4Var.s = threadData;
                        bq4Var.position = i;
                        bq4Var.a = true;
                        arrayList2.add(bq4Var);
                        bq4 bq4Var2 = new bq4();
                        bq4Var2.s = threadData;
                        bq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            bq4Var2.d = true;
                            bq4Var2.t = imageWidthAndHeight[0];
                            bq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bq4Var2.e = true;
                        } else {
                            bq4Var2.b = true;
                        }
                        arrayList2.add(bq4Var2);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var3 = new bq4();
                            bq4Var3.n = true;
                            bq4Var3.s = threadData;
                            bq4Var3.position = i;
                            arrayList2.add(bq4Var3);
                        }
                        bq4 bq4Var4 = new bq4();
                        bq4Var4.m = true;
                        bq4Var4.s = threadData;
                        bq4Var4.position = i;
                        arrayList2.add(bq4Var4);
                        bq4 bq4Var5 = new bq4();
                        bq4Var5.g = true;
                        bq4Var5.s = threadData;
                        bq4Var5.position = i;
                        arrayList2.add(bq4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        bq4 bq4Var6 = new bq4();
                        bq4Var6.s = threadData;
                        bq4Var6.position = i;
                        bq4Var6.a = true;
                        arrayList2.add(bq4Var6);
                        bq4 bq4Var7 = new bq4();
                        bq4Var7.s = threadData;
                        bq4Var7.position = i;
                        bq4Var7.i = true;
                        arrayList2.add(bq4Var7);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var8 = new bq4();
                            bq4Var8.n = true;
                            bq4Var8.s = threadData;
                            bq4Var8.position = i;
                            arrayList2.add(bq4Var8);
                        }
                        bq4 bq4Var9 = new bq4();
                        bq4Var9.m = true;
                        bq4Var9.s = threadData;
                        bq4Var9.position = i;
                        arrayList2.add(bq4Var9);
                        bq4 bq4Var10 = new bq4();
                        bq4Var10.g = true;
                        bq4Var10.s = threadData;
                        bq4Var10.position = i;
                        arrayList2.add(bq4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (xx5.W(threadData)) {
                        xx5 xx5Var = new xx5(threadData);
                        xx5Var.g = threadData.getTid();
                        arrayList2.add(xx5Var);
                    } else {
                        bq4 bq4Var11 = new bq4();
                        bq4Var11.s = threadData;
                        bq4Var11.position = i;
                        arrayList2.add(bq4Var11);
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
    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public final void j(List<qx5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        qx5 qx5Var = list.get(list.size() - 1);
        if (qx5Var.getThreadData() != null) {
            this.c = ng.g(qx5Var.getThreadData().getTid(), 0L);
        }
    }

    public final void l(ArrayList<nn> arrayList, op4 op4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, op4Var) == null) || op4Var == null || ListUtils.isEmpty(op4Var.h())) {
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
                if (op4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, op4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, op4Var);
        }
    }

    public void n(DataRes dataRes) {
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
                    qx5 qx5Var = null;
                    if (zx5.R(threadData)) {
                        qx5Var = new zx5(threadData);
                    } else if (yx5.W(threadData)) {
                        qx5Var = new yx5();
                        qx5Var.a = threadData;
                    }
                    if (qx5Var != null && qx5Var.isValid()) {
                        qx5Var.L("c10816");
                        this.a.add(qx5Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            zo4 zo4Var = new zo4();
            this.b = zo4Var;
            zo4Var.j(dataRes.page);
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
                    qx5 qx5Var = null;
                    if (threadData.isShareThread) {
                        qx5Var = new yx5();
                        qx5Var.a = threadData;
                    } else if (zx5.R(threadData)) {
                        qx5Var = new zx5(threadData);
                    } else if (yx5.W(threadData)) {
                        qx5Var = new yx5();
                        qx5Var.a = threadData;
                    }
                    if (qx5Var != null && qx5Var.isValid()) {
                        qx5Var.L("c10816");
                        this.a.add(qx5Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            zo4 zo4Var = new zo4();
            this.b = zo4Var;
            zo4Var.j(hotThread.page);
        }
    }

    public l27(int i) {
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
