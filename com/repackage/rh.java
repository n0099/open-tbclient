package com.repackage;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action, bh bhVar, boolean z) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, bhVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bhVar;
            this.d = z;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.G(getFileInfo().length());
                    if (this.d || this.c.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        rh.c(this.c, false, false, false);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, bh bhVar, boolean z, boolean z2, boolean z3) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, bhVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bhVar;
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.G(0L);
                    lh.m().t(this.a, this.b, this.c, this.d);
                } else if (this.a.t() < 307200 || this.a.o() == "stat") {
                } else {
                    rh.a(BdStatisticsManager.getInstance().getWriteDir(), this.a.r(), this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, bh bhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, bhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bhVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.G(getFileInfo().length());
                }
            }
        }
    }

    public static void a(String str, String str2, bh bhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, bhVar) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
            diskFileOperate.setSdCard(bhVar.E());
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            rb.f().a(diskFileOperate);
        }
    }

    public static long b(bh bhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bhVar)) == null) {
            if (bhVar == null) {
                return -1L;
            }
            if (bhVar.t() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getWriteDir(), bhVar.s(), DiskFileOperate.Action.INFO, bhVar);
                cVar.setSdCard(bhVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (rb.f().a(cVar)) {
                    return bhVar.t();
                }
            }
            return bhVar.t();
        }
        return invokeL.longValue;
    }

    public static void c(bh bhVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bhVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || bhVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getWriteDir(), bhVar.s(), BdStatisticsManager.getInstance().getWriteDir(), bhVar.r(), DiskFileOperate.Action.RENAME, bhVar, z, z2, z3);
        bVar.setSdCard(bhVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        rb.f().a(bVar);
    }

    public static void d(bh bhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, bhVar, z) == null) || bhVar == null || bhVar.m() == 0) {
            return;
        }
        a aVar = new a(BdStatisticsManager.getInstance().getWriteDir(), bhVar.s(), DiskFileOperate.Action.APPEND, bhVar, z);
        aVar.setSdCard(bhVar.E());
        aVar.b(bhVar.x().toString());
        bhVar.d();
        if (!bhVar.A()) {
            aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar.setTrySuccessWeight(3);
        }
        rb.f().a(aVar);
    }
}
