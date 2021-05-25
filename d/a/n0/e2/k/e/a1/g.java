package d.a.n0.e2.k.e.a1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.z.e0.j;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f53126a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.k.c.b f53127b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.g0.a f53128c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f53129d;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.f53128c != null) {
                g.this.f53128c.c(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.m0.b1.m.f {
        public final /* synthetic */ d.a.n0.z.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, int i2, String str, d.a.n0.z.e0.b bVar) {
            super(i2, str);
            this.l = bVar;
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            StatisticItem statisticItem = null;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
            d.a.n0.z.e0.b bVar = this.l;
            if (bVar instanceof k) {
                statisticItem = ((k) bVar).e0();
            } else if (bVar instanceof l) {
                statisticItem = ((l) bVar).c0(null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public g(BdTypeRecyclerView bdTypeRecyclerView, d.a.n0.e2.k.c.b bVar) {
        a aVar = new a();
        this.f53129d = aVar;
        this.f53126a = bdTypeRecyclerView;
        this.f53127b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f53128c = new d.a.n0.g0.a();
    }

    public final void b(List<ThreadInfo> list, List<n> list2, String str) {
        a2 a2Var;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ThreadInfo threadInfo = list.get(i3);
            if (threadInfo != null) {
                a2 a2Var2 = new a2();
                a2Var2.C2 = i3 + 1;
                a2Var2.U2(threadInfo);
                if (a2Var2.h0() != null) {
                    a2Var2.h0().j = str;
                }
                if ((k.i0(a2Var2) || l.d0(a2Var2)) && a2Var2.getType() != a2.l3) {
                    k d2 = d(a2Var2);
                    if (d2 != null && (a2Var = d2.f63459e) != null && a2Var.h0() != null && !StringUtils.isNull(a2Var.h0().f50158b)) {
                        d2.l = a2Var2.y1();
                        d2.position = i2;
                        f(d2);
                        list2.add(d2);
                    }
                    int[] p0 = a2Var2.p0();
                    d.a.n0.z.e0.b c2 = c(a2Var2);
                    if (c2 != null) {
                        c2.l = a2Var2.y1();
                        c2.position = i2;
                        if (c2 instanceof k) {
                            if (a2Var2.Z2() == 1) {
                                h(c2);
                                c2.o = p0[0];
                                c2.p = p0[1];
                            } else if (a2Var2.Z2() >= 2) {
                                g(c2);
                            } else {
                                i(c2);
                            }
                        } else if (c2 instanceof l) {
                            j(c2);
                        }
                    }
                    if (c2 != null && c2.isValid()) {
                        c2.f63459e.L1();
                        if (!a2Var2.B2() && a2Var2.T() != null) {
                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new b(this, 16, a2Var2.T().getUserId(), c2), 0, format.length() - 1, 33);
                            c2.f63459e.M1(spannableString);
                        }
                        list2.add(c2);
                    }
                    k d3 = d(a2Var2);
                    if (d3 != null) {
                        d3.l = a2Var2.y1();
                        d3.position = i2;
                        e(d3);
                    }
                    if (d3 != null && d3.isValid()) {
                        list2.add(d3);
                    }
                }
                i2++;
            }
        }
    }

    public final d.a.n0.z.e0.b c(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        if (k.i0(a2Var)) {
            k kVar = new k();
            a2Var.h2();
            a2Var.v2();
            if (!a2Var.h2() && !a2Var.v2()) {
                a2Var.c2();
            }
            kVar.f63459e = a2Var;
            return kVar;
        } else if (l.d0(a2Var)) {
            return new l(a2Var);
        } else {
            return null;
        }
    }

    public final k d(a2 a2Var) {
        k kVar = new k();
        kVar.f63459e = a2Var;
        a2Var.h2();
        if (!a2Var.h2()) {
            a2Var.c2();
        }
        return kVar;
    }

    public final void e(d.a.n0.z.e0.b bVar) {
        if (bVar instanceof k) {
            ((k) bVar).E = true;
        } else if (bVar instanceof l) {
            ((l) bVar).E = true;
        } else if (bVar instanceof j) {
            ((j) bVar).E = true;
        }
        bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
    }

    public final void f(d.a.n0.z.e0.b bVar) {
        bVar.s = true;
        bVar.setSupportType(BaseCardInfo.SupportType.TOP);
    }

    public final void g(d.a.n0.z.e0.b bVar) {
        ((k) bVar).v = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public final void h(d.a.n0.z.e0.b bVar) {
        ((k) bVar).u = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public final void i(d.a.n0.z.e0.b bVar) {
        ((k) bVar).w = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public final void j(d.a.n0.z.e0.b bVar) {
        ((l) bVar).x = true;
        bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
    }

    public void k(d.a.n0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        String first_class = eVar.l() != null ? eVar.l().getFirst_class() : "";
        List<ThreadInfo> F = eVar.F();
        LinkedList linkedList = new LinkedList();
        b(F, linkedList, first_class);
        this.f53127b.e(linkedList);
    }
}
