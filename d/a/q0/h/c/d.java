package d.a.q0.h.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53103a;

    /* renamed from: b  reason: collision with root package name */
    public String f53104b;

    /* renamed from: c  reason: collision with root package name */
    public String f53105c;

    /* renamed from: d  reason: collision with root package name */
    public float f53106d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53107e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53108f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53109g;

    /* renamed from: h  reason: collision with root package name */
    public int f53110h;

    /* renamed from: i  reason: collision with root package name */
    public float f53111i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035311829, "Ld/a/q0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035311829, "Ld/a/q0/h/c/d;");
                return;
            }
        }
        boolean z = k.f49133a;
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
        this.f53103a = "";
        this.f53104b = "";
        this.f53105c = "";
        this.f53106d = 0.0f;
        this.f53107e = false;
        this.f53108f = false;
        this.f53109g = true;
        this.f53110h = 0;
        this.f53111i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f53105c + "; AutoPlay : " + this.f53107e + "; Volume :" + this.f53111i + "; Loop : " + this.f53108f + "; startTime : " + this.f53106d + "; ObeyMute : " + this.f53109g + "; pos : " + this.f53110h;
        }
        return (String) invokeV.objValue;
    }
}
