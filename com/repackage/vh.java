package com.repackage;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vh {
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
                    this.c.F(getFileInfo().length());
                    if (this.d || this.c.l() > 20480) {
                        vh.b(this.c);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, DiskFileOperate.Action action, bh bhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, str4, action, bhVar};
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
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.F(0L);
                    lh.m().u(this.a);
                    return;
                }
                BdLog.e("Track Log rename fail!");
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
                    this.c.F(getFileInfo().length());
                }
            }
        }
    }

    public static long a(bh bhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bhVar)) == null) {
            if (bhVar == null) {
                return -1L;
            }
            if (bhVar.v() <= 0) {
                c cVar = new c(BdStatisticsManager.getInstance().getTrackLogWriteDir(), bhVar.s(), DiskFileOperate.Action.INFO, bhVar);
                cVar.setSdCard(bhVar.C());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                if (rb.f().a(cVar)) {
                    return bhVar.v();
                }
            }
            return bhVar.v();
        }
        return invokeL.longValue;
    }

    public static void b(bh bhVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, bhVar) == null) || bhVar == null) {
            return;
        }
        b bVar = new b(BdStatisticsManager.getInstance().getTrackLogWriteDir(), bhVar.s(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), bhVar.r(), DiskFileOperate.Action.RENAME, bhVar);
        bVar.setSdCard(bhVar.C());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        rb.f().a(bVar);
    }

    public static void c(bh bhVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, bhVar, z) == null) || bhVar == null || bhVar.l() == 0) {
            return;
        }
        a aVar = new a(BdStatisticsManager.getInstance().getTrackLogWriteDir(), bhVar.s(), DiskFileOperate.Action.APPEND, bhVar, z);
        aVar.setSdCard(bhVar.C());
        aVar.b(bhVar.z().toString());
        bhVar.f();
        if (!bhVar.A()) {
            aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar.setTrySuccessWeight(3);
        }
        if (rb.f().a(aVar)) {
            return;
        }
        BdLog.e("Track Log write to disk fail!");
    }
}
