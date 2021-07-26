package d.a.q0.w2.c0.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66504a;

    /* renamed from: b  reason: collision with root package name */
    public String f66505b;

    /* renamed from: c  reason: collision with root package name */
    public long f66506c;

    /* renamed from: d  reason: collision with root package name */
    public int f66507d;

    /* renamed from: e  reason: collision with root package name */
    public long f66508e;

    /* renamed from: f  reason: collision with root package name */
    public String f66509f;

    /* renamed from: g  reason: collision with root package name */
    public String f66510g;

    /* renamed from: h  reason: collision with root package name */
    public int f66511h;

    /* renamed from: i  reason: collision with root package name */
    public String f66512i;
    public String j;
    public String k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return TextUtils.equals(this.f66504a, bVar.f66504a) && TextUtils.equals(this.f66505b, bVar.f66505b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.f66504a + this.f66505b).hashCode();
        }
        return invokeV.intValue;
    }
}
