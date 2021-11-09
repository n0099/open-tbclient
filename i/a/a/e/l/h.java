package i.a.a.e.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.a.a.e.n.m;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f72360a;

    /* renamed from: b  reason: collision with root package name */
    public String f72361b;

    /* renamed from: c  reason: collision with root package name */
    public String f72362c;

    public h(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72360a = str;
        this.f72361b = str2;
        this.f72362c = str3;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "TopUiParams{title='" + this.f72360a + ExtendedMessageFormat.QUOTE + ", rightTitle='" + this.f72361b + ExtendedMessageFormat.QUOTE + ", rightUrl='" + m.a(this.f72362c) + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
