package d.a.q0.a.s1;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.s1.g;
/* loaded from: classes8.dex */
public final class a implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f50594a;

    /* renamed from: b  reason: collision with root package name */
    public final f f50595b;

    public a(int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50594a = i2;
        this.f50595b = fVar;
    }

    @Override // d.a.q0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, strArr, iArr) == null) {
            if (i2 != this.f50594a) {
                this.f50595b.b(2, "request permission fail");
                return;
            }
            for (int i3 : iArr) {
                if (i3 == -1) {
                    this.f50595b.b(1, "user denied");
                    return;
                }
            }
            this.f50595b.a("permission granted successful");
        }
    }
}
