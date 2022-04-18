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
public class z37 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xx5> a;
    public pp4 b;
    public long c;
    public int d;
    public List<uo> e;
    @Nullable
    public Map<String, Object> f;

    public z37() {
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

    public ArrayList<uo> g(eq4 eq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eq4Var)) == null) {
            ArrayList<uo> arrayList = new ArrayList<>(this.e);
            m(arrayList, eq4Var);
            ArrayList<uo> arrayList2 = new ArrayList<>();
            Iterator<uo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        qq4 qq4Var = new qq4();
                        qq4Var.s = threadData;
                        qq4Var.position = i;
                        qq4Var.a = true;
                        arrayList2.add(qq4Var);
                        qq4 qq4Var2 = new qq4();
                        qq4Var2.s = threadData;
                        qq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            qq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            qq4Var2.d = true;
                            qq4Var2.t = imageWidthAndHeight[0];
                            qq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            qq4Var2.e = true;
                        } else {
                            qq4Var2.b = true;
                        }
                        arrayList2.add(qq4Var2);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var3 = new qq4();
                            qq4Var3.n = true;
                            qq4Var3.s = threadData;
                            qq4Var3.position = i;
                            arrayList2.add(qq4Var3);
                        }
                        qq4 qq4Var4 = new qq4();
                        qq4Var4.m = true;
                        qq4Var4.s = threadData;
                        qq4Var4.position = i;
                        arrayList2.add(qq4Var4);
                        qq4 qq4Var5 = new qq4();
                        qq4Var5.g = true;
                        qq4Var5.s = threadData;
                        qq4Var5.position = i;
                        arrayList2.add(qq4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        qq4 qq4Var6 = new qq4();
                        qq4Var6.s = threadData;
                        qq4Var6.position = i;
                        qq4Var6.a = true;
                        arrayList2.add(qq4Var6);
                        qq4 qq4Var7 = new qq4();
                        qq4Var7.s = threadData;
                        qq4Var7.position = i;
                        qq4Var7.i = true;
                        arrayList2.add(qq4Var7);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var8 = new qq4();
                            qq4Var8.n = true;
                            qq4Var8.s = threadData;
                            qq4Var8.position = i;
                            arrayList2.add(qq4Var8);
                        }
                        qq4 qq4Var9 = new qq4();
                        qq4Var9.m = true;
                        qq4Var9.s = threadData;
                        qq4Var9.position = i;
                        arrayList2.add(qq4Var9);
                        qq4 qq4Var10 = new qq4();
                        qq4Var10.g = true;
                        qq4Var10.s = threadData;
                        qq4Var10.position = i;
                        arrayList2.add(qq4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (ey5.W(threadData)) {
                        ey5 ey5Var = new ey5(threadData);
                        ey5Var.g = threadData.getTid();
                        arrayList2.add(ey5Var);
                    } else {
                        qq4 qq4Var11 = new qq4();
                        qq4Var11.s = threadData;
                        qq4Var11.position = i;
                        arrayList2.add(qq4Var11);
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

    public final void k(List<xx5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        xx5 xx5Var = list.get(list.size() - 1);
        if (xx5Var.getThreadData() != null) {
            this.c = mg.g(xx5Var.getThreadData().getTid(), 0L);
        }
    }

    public final void m(ArrayList<uo> arrayList, eq4 eq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, eq4Var) == null) || eq4Var == null || ListUtils.isEmpty(eq4Var.i())) {
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
                if (eq4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, eq4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, eq4Var);
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
                    xx5 xx5Var = null;
                    if (gy5.R(threadData)) {
                        xx5Var = new gy5(threadData);
                    } else if (fy5.W(threadData)) {
                        xx5Var = new fy5();
                        xx5Var.a = threadData;
                    }
                    if (xx5Var != null && xx5Var.isValid()) {
                        xx5Var.L("c10816");
                        this.a.add(xx5Var);
                    }
                }
            }
            k(this.a);
            e(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            pp4 pp4Var = new pp4();
            this.b = pp4Var;
            pp4Var.j(dataRes.page);
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
                    xx5 xx5Var = null;
                    if (threadData.isShareThread) {
                        xx5Var = new fy5();
                        xx5Var.a = threadData;
                    } else if (gy5.R(threadData)) {
                        xx5Var = new gy5(threadData);
                    } else if (fy5.W(threadData)) {
                        xx5Var = new fy5();
                        xx5Var.a = threadData;
                    }
                    if (xx5Var != null && xx5Var.isValid()) {
                        xx5Var.L("c10816");
                        this.a.add(xx5Var);
                    }
                }
            }
            k(this.a);
            e(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            pp4 pp4Var = new pp4();
            this.b = pp4Var;
            pp4Var.j(hotThread.page);
        }
    }

    public z37(int i) {
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
