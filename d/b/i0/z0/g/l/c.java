package d.b.i0.z0.g.l;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.z0.g.j.i;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static long f63221b;

    /* renamed from: a  reason: collision with root package name */
    public String f63222a;

    /* loaded from: classes4.dex */
    public static class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadInfo f63223a;

        public a(ThreadInfo threadInfo) {
            this.f63223a = threadInfo;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            String[] split = d.b.h0.r.d0.b.i().o("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            long f2 = d.b.b.e.m.b.f(split[1], 0L);
            if (f2 != 0 && !StringUtils.isNull(str)) {
                d.b.h0.r.d0.b.i().w("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.f63223a.tid + "," + f2);
            }
            return null;
        }
    }

    public static void d(long j, int i, List<ThreadInfo> list, List<n> list2) {
        ThreadInfo threadInfo;
        if (j != f63221b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
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
        f63221b = threadInfo.tid.longValue();
        h0.b(new a(threadInfo), null);
    }

    public void a(List<n> list) {
        d.b.i0.x.e0.b bVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.f63222a == null) {
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                this.f63222a = i.o("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.f63222a)) {
                return;
            }
            String[] split = this.f63222a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long f2 = d.b.b.e.m.b.f(split[1], 0L);
            if (f2 == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof d.b.i0.x.e0.b) && (bVar = (d.b.i0.x.e0.b) list.get(i2)) != null && !StringUtils.isNull(bVar.l) && bVar.l.equals(str)) {
                    b bVar2 = new b();
                    bVar2.f63219e = f2;
                    bVar2.f63220f = false;
                    list.add(i2, bVar2);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        if (!i.f63194a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f63222a = null;
        f63221b = threadInfo.tid.longValue();
        d.b.h0.r.d0.b.i().w("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        if (!TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f63222a = null;
        f63221b = threadInfo.tid.longValue();
        d.b.h0.r.d0.b.i().w("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}
