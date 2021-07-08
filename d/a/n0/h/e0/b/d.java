package d.a.n0.h.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f49952a;

    /* renamed from: b  reason: collision with root package name */
    public long f49953b;

    /* renamed from: c  reason: collision with root package name */
    public String f49954c;

    /* renamed from: d  reason: collision with root package name */
    public String f49955d;

    /* renamed from: e  reason: collision with root package name */
    public String f49956e;

    /* renamed from: f  reason: collision with root package name */
    public String f49957f;

    /* renamed from: g  reason: collision with root package name */
    public String f49958g;

    /* renamed from: h  reason: collision with root package name */
    public String f49959h;

    /* renamed from: i  reason: collision with root package name */
    public int f49960i;
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
            return "{ clipMaxDuration=" + this.f49952a + " , clipMinDuration=" + this.f49953b + " , topicSource=" + this.f49954c + " , publishURL=" + this.f49956e + " , publishType=" + this.k + " , publishTitle=" + this.f49955d + " , atURL=" + this.f49958g + " , topicURL=" + this.f49959h + " , musicURL=" + this.f49957f + " , sourceFrom=" + this.j + " , sourceType=" + this.f49960i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
