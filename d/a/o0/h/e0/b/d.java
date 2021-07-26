package d.a.o0.h.e0.b;

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
    public long f50456a;

    /* renamed from: b  reason: collision with root package name */
    public long f50457b;

    /* renamed from: c  reason: collision with root package name */
    public String f50458c;

    /* renamed from: d  reason: collision with root package name */
    public String f50459d;

    /* renamed from: e  reason: collision with root package name */
    public String f50460e;

    /* renamed from: f  reason: collision with root package name */
    public String f50461f;

    /* renamed from: g  reason: collision with root package name */
    public String f50462g;

    /* renamed from: h  reason: collision with root package name */
    public String f50463h;

    /* renamed from: i  reason: collision with root package name */
    public int f50464i;
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
            return "{ clipMaxDuration=" + this.f50456a + " , clipMinDuration=" + this.f50457b + " , topicSource=" + this.f50458c + " , publishURL=" + this.f50460e + " , publishType=" + this.k + " , publishTitle=" + this.f50459d + " , atURL=" + this.f50462g + " , topicURL=" + this.f50463h + " , musicURL=" + this.f50461f + " , sourceFrom=" + this.j + " , sourceType=" + this.f50464i + ",target=" + this.l + ",showToast=" + this.m + " }";
        }
        return (String) invokeV.objValue;
    }
}
