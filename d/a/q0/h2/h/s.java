package d.a.q0.h2.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f57494a;

    /* renamed from: b  reason: collision with root package name */
    public float f57495b;

    /* renamed from: c  reason: collision with root package name */
    public int f57496c;

    /* renamed from: d  reason: collision with root package name */
    public float f57497d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57498e;

    public s(float f2, float f3, int i2, float f4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Float.valueOf(f4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57494a = f2;
        this.f57495b = f3;
        this.f57496c = i2;
        this.f57497d = f4;
        this.f57498e = z;
    }
}
