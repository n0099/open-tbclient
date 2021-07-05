package d.a.y0.f.b.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71022a;

    /* renamed from: b  reason: collision with root package name */
    public String f71023b;

    /* renamed from: c  reason: collision with root package name */
    public String f71024c;

    /* renamed from: d  reason: collision with root package name */
    public float f71025d;

    /* renamed from: e  reason: collision with root package name */
    public String f71026e;

    /* renamed from: f  reason: collision with root package name */
    public String f71027f;

    /* renamed from: g  reason: collision with root package name */
    public String f71028g;

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
            this.f71022a = "";
            this.f71023b = "";
            this.f71024c = "";
            this.f71025d = 0.0f;
            this.f71026e = "";
            this.f71027f = "";
            this.f71028g = "";
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "sft : " + this.f71022a + ", bft : " + this.f71023b + ", fc : " + this.f71024c + ", time : " + this.f71025d + ", cpu : " + this.f71026e + ", mem : " + this.f71027f + ", gpu : " + this.f71028g;
        }
        return (String) invokeV.objValue;
    }
}
