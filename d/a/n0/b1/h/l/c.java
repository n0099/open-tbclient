package d.a.n0.b1.h.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.n0.b1.h.j.i;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static long f55529b;

    /* renamed from: a  reason: collision with root package name */
    public String f55530a;

    /* loaded from: classes4.dex */
    public static class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadInfo f55531a;

        public a(ThreadInfo threadInfo) {
            this.f55531a = threadInfo;
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            String[] split = d.a.m0.r.d0.b.j().p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            long f2 = d.a.c.e.m.b.f(split[1], 0L);
            if (f2 != 0 && !StringUtils.isNull(str)) {
                d.a.m0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.f55531a.tid + "," + f2);
            }
            return null;
        }
    }

    public static void d(long j, int i2, List<ThreadInfo> list, List<n> list2) {
        ThreadInfo threadInfo;
        if (j != f55529b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
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
        f55529b = threadInfo.tid.longValue();
        h0.b(new a(threadInfo), null);
    }

    public void a(List<n> list) {
        d.a.n0.z.e0.b bVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.f55530a == null) {
                d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                this.f55530a = j.p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.f55530a)) {
                return;
            }
            String[] split = this.f55530a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long f2 = d.a.c.e.m.b.f(split[1], 0L);
            if (f2 == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof d.a.n0.z.e0.b) && (bVar = (d.a.n0.z.e0.b) list.get(i2)) != null && !StringUtils.isNull(bVar.l) && bVar.l.equals(str)) {
                    b bVar2 = new b();
                    bVar2.f55527e = f2;
                    bVar2.f55528f = false;
                    list.add(i2, bVar2);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        if (!i.f55501a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f55530a = null;
        f55529b = threadInfo.tid.longValue();
        d.a.m0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        if (!TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f55530a = null;
        f55529b = threadInfo.tid.longValue();
        d.a.m0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}
