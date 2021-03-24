package d.b.b.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public static class a extends d.b.b.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.b.e.n.h.a f41962c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f41963d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.b.b.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            this.f41962c = aVar;
            this.f41963d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f41962c.G(getFileInfo().length());
                if (this.f41963d || this.f41962c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                    d.c(this.f41962c, false, false, false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b.e.n.h.a f41964a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f41965b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41966c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f41967d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.b.b.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            this.f41964a = aVar;
            this.f41965b = z;
            this.f41966c = z2;
            this.f41967d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f41964a.G(0L);
                d.b.b.e.n.l.b.m().r(this.f41964a, this.f41965b, this.f41966c, this.f41967d);
            } else if (this.f41964a.t() < 307200 || this.f41964a.o() == "stat") {
            } else {
                d.a(BdStatisticsManager.getInstance().getWriteDir(), this.f41964a.r(), this.f41964a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.b.b.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.b.e.n.h.a f41968c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.b.b.e.n.h.a aVar) {
            super(str, str2, action);
            this.f41968c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f41968c.G(getFileInfo().length());
            }
        }
    }

    public static void a(String str, String str2, d.b.b.e.n.h.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.setSdCard(aVar.E());
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        d.b.b.e.a.d.g().a(diskFileOperate);
    }

    public static long b(d.b.b.e.n.h.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.t() <= 0) {
            c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (d.b.b.e.a.d.g().a(cVar)) {
                return aVar.t();
            }
        }
        return aVar.t();
    }

    public static void c(d.b.b.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.b.b.e.a.d.g().a(bVar);
    }

    public static void d(d.b.b.e.n.h.a aVar, boolean z) {
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
        d.b.b.e.a.d.g().a(aVar2);
    }
}
