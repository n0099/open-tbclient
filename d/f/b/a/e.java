package d.f.b.a;

import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes8.dex */
public final class e implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.h0.h f70118a;

    /* renamed from: b  reason: collision with root package name */
    public final long f70119b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70120c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70121d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70122e;

    /* renamed from: f  reason: collision with root package name */
    public final PriorityTaskManager f70123f;

    /* renamed from: g  reason: collision with root package name */
    public int f70124g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70125h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(new d.f.b.a.h0.h(true, 65536));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((d.f.b.a.h0.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.m
    public void a(r[] rVarArr, d.f.b.a.d0.t tVar, d.f.b.a.f0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rVarArr, tVar, gVar) == null) {
            this.f70124g = 0;
            for (int i2 = 0; i2 < rVarArr.length; i2++) {
                if (gVar.a(i2) != null) {
                    this.f70124g += d.f.b.a.i0.v.p(rVarArr[i2].e());
                }
            }
            this.f70118a.h(this.f70124g);
        }
    }

    @Override // d.f.b.a.m
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(true);
        }
    }

    @Override // d.f.b.a.m
    public boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int g2 = g(j);
            boolean z = true;
            boolean z2 = this.f70118a.f() >= this.f70124g;
            boolean z3 = this.f70125h;
            if (g2 != 2 && (g2 != 1 || !z3 || z2)) {
                z = false;
            }
            this.f70125h = z;
            PriorityTaskManager priorityTaskManager = this.f70123f;
            if (priorityTaskManager != null && z != z3) {
                if (z) {
                    priorityTaskManager.a(0);
                } else {
                    priorityTaskManager.b(0);
                }
            }
            return this.f70125h;
        }
        return invokeJ.booleanValue;
    }

    @Override // d.f.b.a.m
    public boolean d(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            long j2 = z ? this.f70122e : this.f70121d;
            return j2 <= 0 || j >= j2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.m
    public d.f.b.a.h0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70118a : (d.f.b.a.h0.b) invokeV.objValue;
    }

    @Override // d.f.b.a.m
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(true);
        }
    }

    public final int g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j > this.f70120c) {
                return 0;
            }
            return j < this.f70119b ? 2 : 1;
        }
        return invokeJ.intValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f70124g = 0;
            PriorityTaskManager priorityTaskManager = this.f70123f;
            if (priorityTaskManager != null && this.f70125h) {
                priorityTaskManager.b(0);
            }
            this.f70125h = false;
            if (z) {
                this.f70118a.g();
            }
        }
    }

    @Override // d.f.b.a.m
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(d.f.b.a.h0.h hVar) {
        this(hVar, 15000, 30000, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, 5000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.f.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(d.f.b.a.h0.h hVar, int i2, int i3, long j, long j2) {
        this(hVar, i2, i3, j, j2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.f.b.a.h0.h) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), (PriorityTaskManager) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(d.f.b.a.h0.h hVar, int i2, int i3, long j, long j2, PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), priorityTaskManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f70118a = hVar;
        this.f70119b = i2 * 1000;
        this.f70120c = i3 * 1000;
        this.f70121d = j * 1000;
        this.f70122e = j2 * 1000;
        this.f70123f = priorityTaskManager;
    }
}
