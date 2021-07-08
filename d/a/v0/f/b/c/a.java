package d.a.v0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f67825a;

    /* renamed from: b  reason: collision with root package name */
    public String f67826b;

    /* renamed from: c  reason: collision with root package name */
    public String f67827c;

    /* renamed from: d  reason: collision with root package name */
    public float f67828d;

    /* renamed from: e  reason: collision with root package name */
    public String f67829e;

    /* renamed from: f  reason: collision with root package name */
    public String f67830f;

    /* renamed from: g  reason: collision with root package name */
    public String f67831g;

    public a() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67825a = "";
            this.f67826b = "";
            this.f67827c = "";
            this.f67828d = 0.0f;
            this.f67829e = "";
            this.f67830f = "";
            this.f67831g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f67825a + ", bft : " + this.f67826b + ", fc : " + this.f67827c + ", time : " + this.f67828d + ", cpu : " + this.f67829e + ", mem : " + this.f67830f + ", gpu : " + this.f67831g;
        }
        return (String) invokeV.objValue;
    }
}
