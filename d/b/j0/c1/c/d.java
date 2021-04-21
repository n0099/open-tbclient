package d.b.j0.c1.c;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.o1;
import d.b.i0.r.q.z0;
import d.b.i0.r.q.z1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends a2 {
    public List<d.b.j0.x.e0.b> E3;
    public z0 F3;
    public long G3;
    public int H3;
    public List<d.b.c.j.e.n> I3 = new ArrayList();

    public d() {
        this.H3 = 1;
        this.H3 = 1;
    }

    public ArrayList<d.b.c.j.e.n> A4(o1 o1Var) {
        ArrayList<d.b.c.j.e.n> arrayList = new ArrayList<>(this.I3);
        C4(arrayList, o1Var);
        ArrayList<d.b.c.j.e.n> arrayList2 = new ArrayList<>();
        Iterator<d.b.c.j.e.n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            d.b.c.j.e.n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.H2) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i;
                    z1Var.f51697e = true;
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i;
                    if (a2Var.P1()) {
                        z1Var2.j = true;
                    } else if (a2Var.W2() == 1) {
                        z1Var2.f51700h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.W2() >= 2) {
                        z1Var2.i = true;
                    } else {
                        z1Var2.f51698f = true;
                    }
                    arrayList2.add(z1Var2);
                    if (a2Var.y0() != null) {
                        z1 z1Var3 = new z1();
                        z1Var3.r = true;
                        z1Var3.w = a2Var;
                        z1Var3.position = i;
                        arrayList2.add(z1Var3);
                    }
                    z1 z1Var4 = new z1();
                    z1Var4.q = true;
                    z1Var4.w = a2Var;
                    z1Var4.position = i;
                    arrayList2.add(z1Var4);
                    z1 z1Var5 = new z1();
                    z1Var5.k = true;
                    z1Var5.w = a2Var;
                    z1Var5.position = i;
                    arrayList2.add(z1Var5);
                } else if (a2Var.getType() == a2.e3) {
                    z1 z1Var6 = new z1();
                    z1Var6.w = a2Var;
                    z1Var6.position = i;
                    z1Var6.f51697e = true;
                    arrayList2.add(z1Var6);
                    z1 z1Var7 = new z1();
                    z1Var7.w = a2Var;
                    z1Var7.position = i;
                    z1Var7.m = true;
                    arrayList2.add(z1Var7);
                    if (a2Var.y0() != null) {
                        z1 z1Var8 = new z1();
                        z1Var8.r = true;
                        z1Var8.w = a2Var;
                        z1Var8.position = i;
                        arrayList2.add(z1Var8);
                    }
                    z1 z1Var9 = new z1();
                    z1Var9.q = true;
                    z1Var9.w = a2Var;
                    z1Var9.position = i;
                    arrayList2.add(z1Var9);
                    z1 z1Var10 = new z1();
                    z1Var10.k = true;
                    z1Var10.w = a2Var;
                    z1Var10.position = i;
                    arrayList2.add(z1Var10);
                } else if (a2Var.getType() == a2.W2 && a2Var.O1()) {
                    a2Var.position = i;
                    arrayList2.add(a2Var);
                } else if (d.b.j0.x.e0.j.i0(a2Var)) {
                    d.b.j0.x.e0.j jVar = new d.b.j0.x.e0.j(a2Var);
                    jVar.l = a2Var.w1();
                    arrayList2.add(jVar);
                } else {
                    z1 z1Var11 = new z1();
                    z1Var11.w = a2Var;
                    z1Var11.position = i;
                    arrayList2.add(z1Var11);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i++;
        }
        d.b.i0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public final void B4(List<d.b.j0.x.e0.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.b.j0.x.e0.b bVar = list.get(list.size() - 1);
        if (bVar.n() != null) {
            this.G3 = d.b.c.e.m.b.f(bVar.n().w1(), 0L);
        }
    }

    public final void C4(ArrayList<d.b.c.j.e.n> arrayList, o1 o1Var) {
        if (o1Var == null || ListUtils.isEmpty(o1Var.B())) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (arrayList.get(i) instanceof a2) {
                if (o1Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, o1Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, o1Var);
        }
    }

    public void D4(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            this.E3 = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.R2(threadInfo);
                    a2Var.a4(5);
                    d.b.j0.x.e0.b bVar = null;
                    if (d.b.j0.x.e0.l.d0(a2Var)) {
                        bVar = new d.b.j0.x.e0.l(a2Var);
                    } else if (d.b.j0.x.e0.k.i0(a2Var)) {
                        bVar = new d.b.j0.x.e0.k();
                        bVar.f64193e = a2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.X("c10816");
                        this.E3.add(bVar);
                    }
                }
            }
            B4(this.E3);
            z4(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            z0 z0Var = new z0();
            this.F3 = z0Var;
            z0Var.j(dataRes.page);
        }
    }

    public void E4(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.E3 = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.R2(threadInfo);
                    a2Var.a4(5);
                    d.b.j0.x.e0.b bVar = null;
                    if (a2Var.s1) {
                        bVar = new d.b.j0.x.e0.k();
                        bVar.f64193e = a2Var;
                    } else if (d.b.j0.x.e0.l.d0(a2Var)) {
                        bVar = new d.b.j0.x.e0.l(a2Var);
                    } else if (d.b.j0.x.e0.k.i0(a2Var)) {
                        bVar = new d.b.j0.x.e0.k();
                        bVar.f64193e = a2Var;
                    }
                    if (bVar != null && bVar.isValid()) {
                        bVar.X("c10816");
                        this.E3.add(bVar);
                    }
                }
            }
            B4(this.E3);
            z4(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            z0 z0Var = new z0();
            this.F3 = z0Var;
            z0Var.j(hotThread.page);
        }
    }

    public final void z4(@NonNull List<ThreadInfo> list) {
        for (ThreadInfo threadInfo : list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.I3.add(a2Var);
        }
    }

    public d(int i) {
        this.H3 = 1;
        this.H3 = i;
    }
}
