package d.b.j0.a1.g.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.a1.g.j.i;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static long f53262b;

    /* renamed from: a  reason: collision with root package name */
    public String f53263a;

    /* loaded from: classes4.dex */
    public static class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadInfo f53264a;

        public a(ThreadInfo threadInfo) {
            this.f53264a = threadInfo;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            String[] split = d.b.i0.r.d0.b.j().p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            long f2 = d.b.c.e.m.b.f(split[1], 0L);
            if (f2 != 0 && !StringUtils.isNull(str)) {
                d.b.i0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.f53264a.tid + "," + f2);
            }
            return null;
        }
    }

    public static void d(long j, int i, List<ThreadInfo> list, List<n> list2) {
        ThreadInfo threadInfo;
        if (j != f53262b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        if (i == 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list2.get(i2) instanceof b) {
                    list2.remove(i2);
                    return;
                }
            }
            return;
        }
        int i3 = i + 1;
        if (ListUtils.getCount(list) <= i3 || (threadInfo = list.get(i3)) == null || threadInfo.tid.longValue() == 0) {
            return;
        }
        f53262b = threadInfo.tid.longValue();
        h0.b(new a(threadInfo), null);
    }

    public void a(List<n> list) {
        d.b.j0.x.e0.b bVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.f53263a == null) {
                d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
                this.f53263a = j.p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.f53263a)) {
                return;
            }
            String[] split = this.f53263a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long f2 = d.b.c.e.m.b.f(split[1], 0L);
            if (f2 == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i) instanceof d.b.j0.x.e0.b) && (bVar = (d.b.j0.x.e0.b) list.get(i)) != null && !StringUtils.isNull(bVar.l) && bVar.l.equals(str)) {
                    b bVar2 = new b();
                    bVar2.f53260e = f2;
                    bVar2.f53261f = false;
                    list.add(i, bVar2);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        if (!i.f53235a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f53263a = null;
        f53262b = threadInfo.tid.longValue();
        d.b.i0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        if (!TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f53263a = null;
        f53262b = threadInfo.tid.longValue();
        d.b.i0.r.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}
