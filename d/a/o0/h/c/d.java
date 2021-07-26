package d.a.o0.h.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50305a;

    /* renamed from: b  reason: collision with root package name */
    public String f50306b;

    /* renamed from: c  reason: collision with root package name */
    public String f50307c;

    /* renamed from: d  reason: collision with root package name */
    public float f50308d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50309e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50310f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50311g;

    /* renamed from: h  reason: collision with root package name */
    public int f50312h;

    /* renamed from: i  reason: collision with root package name */
    public float f50313i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355253459, "Ld/a/o0/h/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355253459, "Ld/a/o0/h/c/d;");
                return;
            }
        }
        boolean z = k.f46335a;
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
        this.f50305a = "";
        this.f50306b = "";
        this.f50307c = "";
        this.f50308d = 0.0f;
        this.f50309e = false;
        this.f50310f = false;
        this.f50311g = true;
        this.f50312h = 0;
        this.f50313i = 1.0f;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "url : " + this.f50307c + "; AutoPlay : " + this.f50309e + "; Volume :" + this.f50313i + "; Loop : " + this.f50310f + "; startTime : " + this.f50308d + "; ObeyMute : " + this.f50311g + "; pos : " + this.f50312h;
        }
        return (String) invokeV.objValue;
    }
}
