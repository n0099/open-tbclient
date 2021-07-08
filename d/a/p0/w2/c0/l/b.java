package d.a.p0.w2.c0.l;

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
    public String f65829a;

    /* renamed from: b  reason: collision with root package name */
    public String f65830b;

    /* renamed from: c  reason: collision with root package name */
    public long f65831c;

    /* renamed from: d  reason: collision with root package name */
    public int f65832d;

    /* renamed from: e  reason: collision with root package name */
    public long f65833e;

    /* renamed from: f  reason: collision with root package name */
    public String f65834f;

    /* renamed from: g  reason: collision with root package name */
    public String f65835g;

    /* renamed from: h  reason: collision with root package name */
    public int f65836h;

    /* renamed from: i  reason: collision with root package name */
    public String f65837i;
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
                return TextUtils.equals(this.f65829a, bVar.f65829a) && TextUtils.equals(this.f65830b, bVar.f65830b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.f65829a + this.f65830b).hashCode();
        }
        return invokeV.intValue;
    }
}
