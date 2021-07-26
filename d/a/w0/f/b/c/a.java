package d.a.w0.f.b.c;

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
    public String f68503a;

    /* renamed from: b  reason: collision with root package name */
    public String f68504b;

    /* renamed from: c  reason: collision with root package name */
    public String f68505c;

    /* renamed from: d  reason: collision with root package name */
    public float f68506d;

    /* renamed from: e  reason: collision with root package name */
    public String f68507e;

    /* renamed from: f  reason: collision with root package name */
    public String f68508f;

    /* renamed from: g  reason: collision with root package name */
    public String f68509g;

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
            this.f68503a = "";
            this.f68504b = "";
            this.f68505c = "";
            this.f68506d = 0.0f;
            this.f68507e = "";
            this.f68508f = "";
            this.f68509g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f68503a + ", bft : " + this.f68504b + ", fc : " + this.f68505c + ", time : " + this.f68506d + ", cpu : " + this.f68507e + ", mem : " + this.f68508f + ", gpu : " + this.f68509g;
        }
        return (String) invokeV.objValue;
    }
}
