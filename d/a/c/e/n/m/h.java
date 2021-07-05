package d.a.c.e.n.m;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends d.a.c.e.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f44404c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f44405d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar, boolean z) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44404c = aVar;
            this.f44405d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f44404c.F(getFileInfo().length());
                    if (this.f44405d || this.f44404c.l() > 20480) {
                        h.b(this.f44404c);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f44406a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44406a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f44406a.F(0L);
                    d.a.c.e.n.l.b.m().s(this.f44406a);
                    return;
                }
                BdLog.e("Track Log rename fail!");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends d.a.c.e.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.n.h.a f44407c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.a.c.e.n.h.a aVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44407c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f44407c.F(getFileInfo().length());
                }
            }
        }
    }

    public static long a(d.a.c.e.n.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
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
        return invokeL.longValue;
    }

    public static void b(d.a.c.e.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, aVar) == null) || aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
        bVar.setSdCard(aVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().a(bVar);
    }

    public static void c(d.a.c.e.n.h.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, aVar, z) == null) || aVar == null || aVar.l() == 0) {
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
