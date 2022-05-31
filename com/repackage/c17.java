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
/* loaded from: classes5.dex */
public class c17 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rw5> a;
    public po4 b;
    public long c;
    public int d;
    public List<jn> e;
    @Nullable
    public Map<String, Object> f;

    public c17() {
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

    public ArrayList<jn> g(ep4 ep4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ep4Var)) == null) {
            ArrayList<jn> arrayList = new ArrayList<>(this.e);
            m(arrayList, ep4Var);
            ArrayList<jn> arrayList2 = new ArrayList<>();
            Iterator<jn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        rp4 rp4Var = new rp4();
                        rp4Var.s = threadData;
                        rp4Var.position = i;
                        rp4Var.a = true;
                        arrayList2.add(rp4Var);
                        rp4 rp4Var2 = new rp4();
                        rp4Var2.s = threadData;
                        rp4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rp4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rp4Var2.d = true;
                            rp4Var2.t = imageWidthAndHeight[0];
                            rp4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rp4Var2.e = true;
                        } else {
                            rp4Var2.b = true;
                        }
                        arrayList2.add(rp4Var2);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var3 = new rp4();
                            rp4Var3.n = true;
                            rp4Var3.s = threadData;
                            rp4Var3.position = i;
                            arrayList2.add(rp4Var3);
                        }
                        rp4 rp4Var4 = new rp4();
                        rp4Var4.m = true;
                        rp4Var4.s = threadData;
                        rp4Var4.position = i;
                        arrayList2.add(rp4Var4);
                        rp4 rp4Var5 = new rp4();
                        rp4Var5.g = true;
                        rp4Var5.s = threadData;
                        rp4Var5.position = i;
                        arrayList2.add(rp4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        rp4 rp4Var6 = new rp4();
                        rp4Var6.s = threadData;
                        rp4Var6.position = i;
                        rp4Var6.a = true;
                        arrayList2.add(rp4Var6);
                        rp4 rp4Var7 = new rp4();
                        rp4Var7.s = threadData;
                        rp4Var7.position = i;
                        rp4Var7.i = true;
                        arrayList2.add(rp4Var7);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var8 = new rp4();
                            rp4Var8.n = true;
                            rp4Var8.s = threadData;
                            rp4Var8.position = i;
                            arrayList2.add(rp4Var8);
                        }
                        rp4 rp4Var9 = new rp4();
                        rp4Var9.m = true;
                        rp4Var9.s = threadData;
                        rp4Var9.position = i;
                        arrayList2.add(rp4Var9);
                        rp4 rp4Var10 = new rp4();
                        rp4Var10.g = true;
                        rp4Var10.s = threadData;
                        rp4Var10.position = i;
                        arrayList2.add(rp4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (yw5.W(threadData)) {
                        yw5 yw5Var = new yw5(threadData);
                        yw5Var.g = threadData.getTid();
                        arrayList2.add(yw5Var);
                    } else {
                        rp4 rp4Var11 = new rp4();
                        rp4Var11.s = threadData;
                        rp4Var11.position = i;
                        arrayList2.add(rp4Var11);
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

    public final void k(List<rw5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        rw5 rw5Var = list.get(list.size() - 1);
        if (rw5Var.getThreadData() != null) {
            this.c = jg.g(rw5Var.getThreadData().getTid(), 0L);
        }
    }

    public final void m(ArrayList<jn> arrayList, ep4 ep4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, ep4Var) == null) || ep4Var == null || ListUtils.isEmpty(ep4Var.i())) {
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
                if (ep4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, ep4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, ep4Var);
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
                    rw5 rw5Var = null;
                    if (ax5.R(threadData)) {
                        rw5Var = new ax5(threadData);
                    } else if (zw5.W(threadData)) {
                        rw5Var = new zw5();
                        rw5Var.a = threadData;
                    }
                    if (rw5Var != null && rw5Var.isValid()) {
                        rw5Var.L("c10816");
                        this.a.add(rw5Var);
                    }
                }
            }
            k(this.a);
            e(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            po4 po4Var = new po4();
            this.b = po4Var;
            po4Var.j(dataRes.page);
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
                    rw5 rw5Var = null;
                    if (threadData.isShareThread) {
                        rw5Var = new zw5();
                        rw5Var.a = threadData;
                    } else if (ax5.R(threadData)) {
                        rw5Var = new ax5(threadData);
                    } else if (zw5.W(threadData)) {
                        rw5Var = new zw5();
                        rw5Var.a = threadData;
                    }
                    if (rw5Var != null && rw5Var.isValid()) {
                        rw5Var.L("c10816");
                        this.a.add(rw5Var);
                    }
                }
            }
            k(this.a);
            e(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            po4 po4Var = new po4();
            this.b = po4Var;
            po4Var.j(hotThread.page);
        }
    }

    public c17(int i) {
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
