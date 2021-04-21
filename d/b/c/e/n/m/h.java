package d.b.c.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public static class a extends d.b.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42722c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f42723d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            this.f42722c = aVar;
            this.f42723d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42722c.F(getFileInfo().length());
                if (this.f42723d || this.f42722c.l() > 20480) {
                    h.b(this.f42722c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42724a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar) {
            super(str, str2, str3, str4, action);
            this.f42724a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42724a.F(0L);
                d.b.c.e.n.l.b.m().s(this.f42724a);
                return;
            }
            BdLog.e("Track Log rename fail!");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.b.c.e.a.f.d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.c.e.n.h.a f42725c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.b.c.e.n.h.a aVar) {
            super(str, str2, action);
            this.f42725c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            super.callback(z);
            if (z) {
                this.f42725c.F(getFileInfo().length());
            }
        }
    }

    public static long a(d.b.c.e.n.h.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.v() <= 0) {
            c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
            cVar.setSdCard(aVar.C());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (d.b.c.e.a.d.g().a(cVar)) {
                return aVar.v();
            }
        }
        return aVar.v();
    }

    public static void b(d.b.c.e.n.h.a aVar) {
        if (aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
        bVar.setSdCard(aVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.b.c.e.a.d.g().a(bVar);
    }

    public static void c(d.b.c.e.n.h.a aVar, boolean z) {
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
        if (d.b.c.e.a.d.g().a(aVar2)) {
            return;
        }
        BdLog.e("Track Log write to disk fail!");
    }
}
