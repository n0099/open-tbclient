package d.a.c.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public static class a extends d.a.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f39907c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f39908d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            this.f39907c = aVar;
            this.f39908d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f39907c.G(getFileInfo().length());
                if (this.f39908d || this.f39907c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(this.f39907c, false, false, false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f39909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f39910b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f39911c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f39912d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            this.f39909a = aVar;
            this.f39910b = z;
            this.f39911c = z2;
            this.f39912d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f39909a.G(0L);
                d.a.c.e.n.l.b.m().r(this.f39909a, this.f39910b, this.f39911c, this.f39912d);
            } else if (this.f39909a.t() < 307200 || this.f39909a.o() == "stat") {
            } else {
                d.a(BdStatisticsManager.getInstance().getWriteDir(), this.f39909a.r(), this.f39909a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.a.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f39913c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, action);
            this.f39913c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f39913c.G(getFileInfo().length());
            }
        }
    }

    public static void a(String str, String str2, d.a.c.e.n.h.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.setSdCard(aVar.E());
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        d.a.c.e.a.d.g().a(diskFileOperate);
    }

    public static long b(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.t() <= 0) {
            c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (d.a.c.e.a.d.g().a(cVar)) {
                return aVar.t();
            }
        }
        return aVar.t();
    }

    public static void c(d.a.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().a(bVar);
    }

    public static void d(d.a.c.e.n.h.a aVar, boolean z) {
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
        d.a.c.e.a.d.g().a(aVar2);
    }
}
