package d.a.n0.h.e0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49947a;

    /* renamed from: b  reason: collision with root package name */
    public String f49948b;

    /* renamed from: c  reason: collision with root package name */
    public String f49949c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49950d;

    /* renamed from: e  reason: collision with root package name */
    public d f49951e;

    public c() {
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
            return "{ videoPath=" + this.f49947a + " , query=" + this.f49948b + " , title=" + this.f49949c + ", extra=" + this.f49950d + ", videoEditorParams=" + this.f49951e + " }";
        }
        return (String) invokeV.objValue;
    }
}
