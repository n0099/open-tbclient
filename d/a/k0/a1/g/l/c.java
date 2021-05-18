package d.a.k0.a1.g.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.a1.g.j.i;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static long f51679b;

    /* renamed from: a  reason: collision with root package name */
    public String f51680a;

    /* loaded from: classes4.dex */
    public static class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadInfo f51681a;

        public a(ThreadInfo threadInfo) {
            this.f51681a = threadInfo;
        }

        @Override // d.a.j0.z0.f0
        public Object doInBackground() {
            String[] split = d.a.j0.r.d0.b.j().p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            long f2 = d.a.c.e.m.b.f(split[1], 0L);
            if (f2 != 0 && !StringUtils.isNull(str)) {
                d.a.j0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.f51681a.tid + "," + f2);
            }
            return null;
        }
    }

    public static void d(long j, int i2, List<ThreadInfo> list, List<n> list2) {
        ThreadInfo threadInfo;
        if (j != f51679b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        if (i2 == 0) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list2.get(i3) instanceof b) {
                    list2.remove(i3);
                    return;
                }
            }
            return;
        }
        int i4 = i2 + 1;
        if (ListUtils.getCount(list) <= i4 || (threadInfo = list.get(i4)) == null || threadInfo.tid.longValue() == 0) {
            return;
        }
        f51679b = threadInfo.tid.longValue();
        h0.b(new a(threadInfo), null);
    }

    public void a(List<n> list) {
        d.a.k0.x.e0.b bVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.f51680a == null) {
                d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
                this.f51680a = j.p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.f51680a)) {
                return;
            }
            String[] split = this.f51680a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long f2 = d.a.c.e.m.b.f(split[1], 0L);
            if (f2 == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof d.a.k0.x.e0.b) && (bVar = (d.a.k0.x.e0.b) list.get(i2)) != null && !StringUtils.isNull(bVar.l) && bVar.l.equals(str)) {
                    b bVar2 = new b();
                    bVar2.f51677e = f2;
                    bVar2.f51678f = false;
                    list.add(i2, bVar2);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        if (!i.f51651a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f51680a = null;
        f51679b = threadInfo.tid.longValue();
        d.a.j0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        if (!TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f51680a = null;
        f51679b = threadInfo.tid.longValue();
        d.a.j0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}
