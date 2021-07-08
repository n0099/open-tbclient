package d.a.n0.f.i.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f49276a;

    /* renamed from: b  reason: collision with root package name */
    public int f49277b;

    /* renamed from: c  reason: collision with root package name */
    public int f49278c;

    /* renamed from: d  reason: collision with root package name */
    public int f49279d;

    /* renamed from: e  reason: collision with root package name */
    public int f49280e;

    /* renamed from: f  reason: collision with root package name */
    public int f49281f;

    public c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49276a = i2;
        this.f49277b = i3;
        this.f49278c = i4;
        this.f49279d = i5;
    }
}
