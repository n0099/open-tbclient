package d.a.n0.d1.c;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.z0;
import d.a.m0.r.q.z1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends a2 {
    public List<d.a.n0.z.e0.b> G3;
    public z0 H3;
    public long I3;
    public int J3;
    public List<d.a.c.j.e.n> K3 = new ArrayList();

    public d() {
        this.J3 = 1;
        this.J3 = 1;
    }

    public final void C4(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            a2 a2Var = new a2();
            a2Var.U2(threadInfo);
            a2Var.L1();
            this.K3.add(a2Var);
        }
    }

    public ArrayList<d.a.c.j.e.n> D4(o1 o1Var) {
        ArrayList<d.a.c.j.e.n> arrayList = new ArrayList<>(this.K3);
        F4(arrayList, o1Var);
        ArrayList<d.a.c.j.e.n> arrayList2 = new ArrayList<>();
        Iterator<d.a.c.j.e.n> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.J2) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i2;
                    z1Var.f50197e = true;
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i2;
                    if (a2Var.R1()) {
                        z1Var2.j = true;
                    } else if (a2Var.Z2() == 1) {
                        z1Var2.f50200h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.Z2() >= 2) {
                        z1Var2.f50201i = true;
                    } else {
                        z1Var2.f50198f = true;
                    }
                    arrayList2.add(z1Var2);
                    if (a2Var.z0() != null) {
                        z1 z1Var3 = new z1();
                        z1Var3.r = true;
                        z1Var3.w = a2Var;
                        z1Var3.position = i2;
                        arrayList2.add(z1Var3);
                    }
                    z1 z1Var4 = new z1();
                    z1Var4.q = true;
                    z1Var4.w = a2Var;
                    z1Var4.position = i2;
                    arrayList2.add(z1Var4);
                    z1 z1Var5 = new z1();
                    z1Var5.k = true;
                    z1Var5.w = a2Var;
                    z1Var5.position = i2;
                    arrayList2.add(z1Var5);
                } else if (a2Var.getType() == a2.g3) {
                    z1 z1Var6 = new z1();
                    z1Var6.w = a2Var;
                    z1Var6.position = i2;
                    z1Var6.f50197e = true;
                    arrayList2.add(z1Var6);
                    z1 z1Var7 = new z1();
                    z1Var7.w = a2Var;
                    z1Var7.position = i2;
                    z1Var7.m = true;
                    arrayList2.add(z1Var7);
                    if (a2Var.z0() != null) {
                        z1 z1Var8 = new z1();
                        z1Var8.r = true;
                        z1Var8.w = a2Var;
                        z1Var8.position = i2;
                        arrayList2.add(z1Var8);
                    }
                    z1 z1Var9 = new z1();
                    z1Var9.q = true;
                    z1Var9.w = a2Var;
                    z1Var9.position = i2;
                    arrayList2.add(z1Var9);
                    z1 z1Var10 = new z1();
                    z1Var10.k = true;
                    z1Var10.w = a2Var;
                    z1Var10.position = i2;
                    arrayList2.add(z1Var10);
                } else if (a2Var.getType() == a2.Y2 && a2Var.Q1()) {
                    a2Var.position = i2;
                    arrayList2.add(a2Var);
                } else if (d.a.n0.z.e0.j.i0(a2Var)) {
                    d.a.n0.z.e0.j jVar = new d.a.n0.z.e0.j(a2Var);
                    jVar.l = a2Var.y1();
                    arrayList2.add(jVar);
                } else {
                    z1 z1Var11 = new z1();
                    z1Var11.w = a2Var;
                    z1Var11.position = i2;
                    arrayList2.add(z1Var11);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i2;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i2++;
        }
        d.a.m0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public final void E4(List<d.a.n0.z.e0.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.a.n0.z.e0.b bVar = list.get(list.size() - 1);
        if (bVar.m() != null) {
            this.I3 = d.a.c.e.m.b.f(bVar.m().y1(), 0L);
        }
    }

    public final void F4(ArrayList<d.a.c.j.e.n> arrayList, o1 o1Var) {
        if (o1Var == null || ListUtils.isEmpty(o1Var.B())) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (arrayList.get(i2) instanceof a2) {
                if (o1Var.floorPosition == i3) {
                    ListUtils.add(arrayList, i2, o1Var);
                    break;
                }
                i3++;
            }
            i2++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, o1Var);
        }
    }

    public void G4(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            this.G3 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.U2(threadInfo);
                    a2Var.d4(5);
                    d.a.n0.z.e0.b bVar = null;
                    if (d.a.n0.z.e0.l.d0(a2Var)) {
                        bVar = new d.a.n0.z.e0.l(a2Var);
                    } else if (d.a.n0.z.e0.k.i0(a2Var)) {
                        bVar = new d.a.n0.z.e0.k();
                        bVar.f63459e = a2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.X("c10816");
                        this.G3.add(bVar);
                    }
                }
            }
            E4(this.G3);
            C4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            z0 z0Var = new z0();
            this.H3 = z0Var;
            z0Var.j(dataRes.page);
        }
    }

    public void H4(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.G3 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.U2(threadInfo);
                    a2Var.d4(5);
                    d.a.n0.z.e0.b bVar = null;
                    if (a2Var.t1) {
                        bVar = new d.a.n0.z.e0.k();
                        bVar.f63459e = a2Var;
                    } else if (d.a.n0.z.e0.l.d0(a2Var)) {
                        bVar = new d.a.n0.z.e0.l(a2Var);
                    } else if (d.a.n0.z.e0.k.i0(a2Var)) {
                        bVar = new d.a.n0.z.e0.k();
                        bVar.f63459e = a2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.X("c10816");
                        this.G3.add(bVar);
                    }
                }
            }
            E4(this.G3);
            C4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            z0 z0Var = new z0();
            this.H3 = z0Var;
            z0Var.j(hotThread.page);
        }
    }

    public d(int i2) {
        this.J3 = 1;
        this.J3 = i2;
    }
}
