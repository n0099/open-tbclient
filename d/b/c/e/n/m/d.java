package d.b.c.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public static class a extends d.b.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42700c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f42701d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            this.f42700c = aVar;
            this.f42701d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42700c.G(getFileInfo().length());
                if (this.f42701d || this.f42700c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(this.f42700c, false, false, false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42702a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42703b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f42704c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f42705d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            this.f42702a = aVar;
            this.f42703b = z;
            this.f42704c = z2;
            this.f42705d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42702a.G(0L);
                d.b.c.e.n.l.b.m().r(this.f42702a, this.f42703b, this.f42704c, this.f42705d);
            } else if (this.f42702a.t() < 307200 || this.f42702a.o() == "stat") {
            } else {
                d.a(BdStatisticsManager.getInstance().getWriteDir(), this.f42702a.r(), this.f42702a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.b.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42706c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar) {
            super(str, str2, action);
            this.f42706c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42706c.G(getFileInfo().length());
            }
        }
    }

    public static void a(String str, String str2, d.b.c.e.n.h.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.setSdCard(aVar.E());
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        d.b.c.e.a.d.g().a(diskFileOperate);
    }

    public static long b(d.b.c.e.n.h.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.t() <= 0) {
            c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (d.b.c.e.a.d.g().a(cVar)) {
                return aVar.t();
            }
        }
        return aVar.t();
    }

    public static void c(d.b.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.b.c.e.a.d.g().a(bVar);
    }

    public static void d(d.b.c.e.n.h.a aVar, boolean z) {
        if (aVar == null || aVar.m() == 0) {
            return;
        }
        a aVar2 = new a(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar, z);
        aVar2.setSdCard(aVar.E());
        aVar2.b(aVar.x().toString());
        aVar.d();
        if (!aVar.A()) {
            aVar2.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar2.setTrySuccessWeight(3);
        }
        d.b.c.e.a.d.g().a(aVar2);
    }
}
