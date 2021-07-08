package d.a.p0.g1.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.a1;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.p1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d extends b2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d.a.p0.a0.e0.b> L3;
    public a1 M3;
    public long N3;
    public int O3;
    public List<d.a.c.k.e.n> P3;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.O3 = 1;
        this.P3 = new ArrayList();
        this.O3 = 1;
    }

    public final void r4(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                b2 b2Var = new b2();
                b2Var.I2(threadInfo);
                b2Var.z1();
                this.P3.add(b2Var);
            }
        }
    }

    public ArrayList<d.a.c.k.e.n> s4(p1 p1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p1Var)) == null) {
            ArrayList<d.a.c.k.e.n> arrayList = new ArrayList<>(this.P3);
            u4(arrayList, p1Var);
            ArrayList<d.a.c.k.e.n> arrayList2 = new ArrayList<>();
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d.a.c.k.e.n next = it.next();
                if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2) {
                        a2 a2Var = new a2();
                        a2Var.w = b2Var;
                        a2Var.position = i2;
                        a2Var.f52563e = true;
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.w = b2Var;
                        a2Var2.position = i2;
                        if (b2Var.F1()) {
                            a2Var2.j = true;
                        } else if (b2Var.N2() == 1) {
                            a2Var2.f52566h = true;
                            a2Var2.x = d0[0];
                            a2Var2.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var2.f52567i = true;
                        } else {
                            a2Var2.f52564f = true;
                        }
                        arrayList2.add(a2Var2);
                        if (b2Var.n0() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.r = true;
                            a2Var3.w = b2Var;
                            a2Var3.position = i2;
                            arrayList2.add(a2Var3);
                        }
                        a2 a2Var4 = new a2();
                        a2Var4.q = true;
                        a2Var4.w = b2Var;
                        a2Var4.position = i2;
                        arrayList2.add(a2Var4);
                        a2 a2Var5 = new a2();
                        a2Var5.k = true;
                        a2Var5.w = b2Var;
                        a2Var5.position = i2;
                        arrayList2.add(a2Var5);
                    } else if (b2Var.getType() == b2.l3) {
                        a2 a2Var6 = new a2();
                        a2Var6.w = b2Var;
                        a2Var6.position = i2;
                        a2Var6.f52563e = true;
                        arrayList2.add(a2Var6);
                        a2 a2Var7 = new a2();
                        a2Var7.w = b2Var;
                        a2Var7.position = i2;
                        a2Var7.m = true;
                        arrayList2.add(a2Var7);
                        if (b2Var.n0() != null) {
                            a2 a2Var8 = new a2();
                            a2Var8.r = true;
                            a2Var8.w = b2Var;
                            a2Var8.position = i2;
                            arrayList2.add(a2Var8);
                        }
                        a2 a2Var9 = new a2();
                        a2Var9.q = true;
                        a2Var9.w = b2Var;
                        a2Var9.position = i2;
                        arrayList2.add(a2Var9);
                        a2 a2Var10 = new a2();
                        a2Var10.k = true;
                        a2Var10.w = b2Var;
                        a2Var10.position = i2;
                        arrayList2.add(a2Var10);
                    } else if (b2Var.getType() == b2.d3 && b2Var.E1()) {
                        b2Var.position = i2;
                        arrayList2.add(b2Var);
                    } else if (d.a.p0.a0.e0.j.W(b2Var)) {
                        d.a.p0.a0.e0.j jVar = new d.a.p0.a0.e0.j(b2Var);
                        jVar.l = b2Var.n1();
                        arrayList2.add(jVar);
                    } else {
                        a2 a2Var11 = new a2();
                        a2Var11.w = b2Var;
                        a2Var11.position = i2;
                        arrayList2.add(a2Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            d.a.o0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void t4(List<d.a.p0.a0.e0.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        d.a.p0.a0.e0.b bVar = list.get(list.size() - 1);
        if (bVar.getThreadData() != null) {
            this.N3 = d.a.c.e.m.b.f(bVar.getThreadData().n1(), 0L);
        }
    }

    public final void u4(ArrayList<d.a.c.k.e.n> arrayList, p1 p1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, arrayList, p1Var) == null) || p1Var == null || ListUtils.isEmpty(p1Var.e())) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (arrayList.get(i2) instanceof b2) {
                if (p1Var.floorPosition == i3) {
                    ListUtils.add(arrayList, i2, p1Var);
                    break;
                }
                i3++;
            }
            i2++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, p1Var);
        }
    }

    public void v4(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            this.L3 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    b2 b2Var = new b2();
                    b2Var.I2(threadInfo);
                    b2Var.S3(5);
                    d.a.p0.a0.e0.b bVar = null;
                    if (d.a.p0.a0.e0.l.R(b2Var)) {
                        bVar = new d.a.p0.a0.e0.l(b2Var);
                    } else if (d.a.p0.a0.e0.k.W(b2Var)) {
                        bVar = new d.a.p0.a0.e0.k();
                        bVar.f53795e = b2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.L("c10816");
                        this.L3.add(bVar);
                    }
                }
            }
            t4(this.L3);
            r4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            a1 a1Var = new a1();
            this.M3 = a1Var;
            a1Var.j(dataRes.page);
        }
    }

    public void w4(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, hotThread) == null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.L3 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    b2 b2Var = new b2();
                    b2Var.I2(threadInfo);
                    b2Var.S3(5);
                    d.a.p0.a0.e0.b bVar = null;
                    if (b2Var.v1) {
                        bVar = new d.a.p0.a0.e0.k();
                        bVar.f53795e = b2Var;
                    } else if (d.a.p0.a0.e0.l.R(b2Var)) {
                        bVar = new d.a.p0.a0.e0.l(b2Var);
                    } else if (d.a.p0.a0.e0.k.W(b2Var)) {
                        bVar = new d.a.p0.a0.e0.k();
                        bVar.f53795e = b2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.L("c10816");
                        this.L3.add(bVar);
                    }
                }
            }
            t4(this.L3);
            r4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            a1 a1Var = new a1();
            this.M3 = a1Var;
            a1Var.j(hotThread.page);
        }
    }

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.O3 = 1;
        this.P3 = new ArrayList();
        this.O3 = i2;
    }
}
