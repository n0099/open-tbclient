package d.a.n0.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f46894a;

    /* renamed from: b  reason: collision with root package name */
    public String f46895b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f46896c;

    /* renamed from: d  reason: collision with root package name */
    public j f46897d;

    /* renamed from: e  reason: collision with root package name */
    public long f46898e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f46899f;

    /* renamed from: g  reason: collision with root package name */
    public String f46900g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f46901h;

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
}
