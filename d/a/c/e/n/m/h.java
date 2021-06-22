package d.a.c.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public static class a extends d.a.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42595c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f42596d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            this.f42595c = aVar;
            this.f42596d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42595c.F(getFileInfo().length());
                if (this.f42596d || this.f42595c.l() > 20480) {
                    h.b(this.f42595c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42597a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, str3, str4, action);
            this.f42597a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42597a.F(0L);
                d.a.c.e.n.l.b.m().s(this.f42597a);
                return;
            }
            BdLog.e("Track Log rename fail!");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.a.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f42598c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, action);
            this.f42598c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42598c.F(getFileInfo().length());
            }
        }
    }

    public static long a(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.v() <= 0) {
            c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
            cVar.setSdCard(aVar.C());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (d.a.c.e.a.d.g().a(cVar)) {
                return aVar.v();
            }
        }
        return aVar.v();
    }

    public static void b(d.a.c.e.n.h.a aVar) {
        if (aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
        bVar.setSdCard(aVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().a(bVar);
    }

    public static void c(d.a.c.e.n.h.a aVar, boolean z) {
        if (aVar == null || aVar.l() == 0) {
            return;
        }
        a aVar2 = new a(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar, z);
        aVar2.setSdCard(aVar.C());
        aVar2.b(aVar.z().toString());
        aVar.f();
        if (!aVar.A()) {
            aVar2.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar2.setTrySuccessWeight(3);
        }
        if (d.a.c.e.a.d.g().a(aVar2)) {
            return;
        }
        BdLog.e("Track Log write to disk fail!");
    }
}
