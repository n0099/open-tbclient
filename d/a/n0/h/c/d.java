package d.a.n0.h.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49801a;

    /* renamed from: b  reason: collision with root package name */
    public String f49802b;

    /* renamed from: c  reason: collision with root package name */
    public String f49803c;

    /* renamed from: d  reason: collision with root package name */
    public float f49804d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49805e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49806f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49807g;

    /* renamed from: h  reason: collision with root package name */
    public int f49808h;

    /* renamed from: i  reason: collision with root package name */
    public float f49809i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132259374, "Ld/a/n0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132259374, "Ld/a/n0/h/c/d;");
                return;
            }
        }
        boolean z = k.f45831a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49801a = "";
        this.f49802b = "";
        this.f49803c = "";
        this.f49804d = 0.0f;
        this.f49805e = false;
        this.f49806f = false;
        this.f49807g = true;
        this.f49808h = 0;
        this.f49809i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f49803c + "; AutoPlay : " + this.f49805e + "; Volume :" + this.f49809i + "; Loop : " + this.f49806f + "; startTime : " + this.f49804d + "; ObeyMute : " + this.f49807g + "; pos : " + this.f49808h;
        }
        return (String) invokeV.objValue;
    }
}
