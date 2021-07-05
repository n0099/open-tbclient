package d.a.q0.h.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53254a;

    /* renamed from: b  reason: collision with root package name */
    public long f53255b;

    /* renamed from: c  reason: collision with root package name */
    public String f53256c;

    /* renamed from: d  reason: collision with root package name */
    public String f53257d;

    /* renamed from: e  reason: collision with root package name */
    public String f53258e;

    /* renamed from: f  reason: collision with root package name */
    public String f53259f;

    /* renamed from: g  reason: collision with root package name */
    public String f53260g;

    /* renamed from: h  reason: collision with root package name */
    public String f53261h;

    /* renamed from: i  reason: collision with root package name */
    public int f53262i;
    public String j;
    public String k;
    public String l;
    public int m;

    public d() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{ clipMaxDuration=" + this.f53254a + " , clipMinDuration=" + this.f53255b + " , topicSource=" + this.f53256c + " , publishURL=" + this.f53258e + " , publishType=" + this.k + " , publishTitle=" + this.f53257d + " , atURL=" + this.f53260g + " , topicURL=" + this.f53261h + " , musicURL=" + this.f53259f + " , sourceFrom=" + this.j + " , sourceType=" + this.f53262i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
