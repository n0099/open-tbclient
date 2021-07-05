package d.a.q0.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50196a;

    /* renamed from: b  reason: collision with root package name */
    public String f50197b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f50198c;

    /* renamed from: d  reason: collision with root package name */
    public j f50199d;

    /* renamed from: e  reason: collision with root package name */
    public long f50200e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f50201f;

    /* renamed from: g  reason: collision with root package name */
    public String f50202g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f50203h;

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
