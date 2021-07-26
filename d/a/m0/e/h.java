package d.a.m0.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f43546a;

    /* renamed from: b  reason: collision with root package name */
    public int f43547b;

    /* renamed from: c  reason: collision with root package name */
    public int f43548c;

    /* renamed from: d  reason: collision with root package name */
    public String f43549d;

    public h(int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43546a = -1;
        this.f43546a = i2;
        this.f43547b = i3;
        this.f43548c = i4;
        this.f43549d = str;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "CallBackMsg{status=" + this.f43546a + ", subStatus=" + this.f43547b + ", op='" + this.f43548c + "', data='" + this.f43549d + "'}";
        }
        return (String) invokeV.objValue;
    }
}
