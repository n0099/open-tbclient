package d.a.d.e.n.o;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.d.e.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41901c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f41902d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar, boolean z) {
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
            this.f41901c = aVar;
            this.f41902d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41901c.G(getFileInfo().length());
                    if (this.f41902d || this.f41901c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        d.c(this.f41901c, false, false, false);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f41904b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41905c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f41906d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
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
            this.f41903a = aVar;
            this.f41904b = z;
            this.f41905c = z2;
            this.f41906d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41903a.G(0L);
                    d.a.d.e.n.n.b.m().r(this.f41903a, this.f41904b, this.f41905c, this.f41906d);
                } else if (this.f41903a.t() < 307200 || this.f41903a.o() == "stat") {
                } else {
                    d.a(BdStatisticsManager.getInstance().getWriteDir(), this.f41903a.r(), this.f41903a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends d.a.d.e.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.n.j.a f41907c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, d.a.d.e.n.j.a aVar) {
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
            this.f41907c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f41907c.G(getFileInfo().length());
                }
            }
        }
    }

    public static void a(String str, String str2, d.a.d.e.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, aVar) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
            diskFileOperate.setSdCard(aVar.E());
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            d.a.d.e.a.d.g().a(diskFileOperate);
        }
    }

    public static long b(d.a.d.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return -1L;
            }
            if (aVar.t() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), DiskFileOperate.Action.INFO, aVar);
                cVar.setSdCard(aVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (d.a.d.e.a.d.g().a(cVar)) {
                    return aVar.t();
                }
            }
            return aVar.t();
        }
        return invokeL.longValue;
    }

    public static void c(d.a.d.e.n.j.a aVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || aVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.d.e.a.d.g().a(bVar);
    }

    public static void d(d.a.d.e.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, aVar, z) == null) || aVar == null || aVar.m() == 0) {
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
        d.a.d.e.a.d.g().a(aVar2);
    }
}
