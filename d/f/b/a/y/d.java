package d.f.b.a.y;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f70745a;

    /* renamed from: b  reason: collision with root package name */
    public int f70746b;

    /* renamed from: c  reason: collision with root package name */
    public int f70747c;

    /* renamed from: d  reason: collision with root package name */
    public int f70748d;

    /* renamed from: e  reason: collision with root package name */
    public int f70749e;

    /* renamed from: f  reason: collision with root package name */
    public int f70750f;

    /* renamed from: g  reason: collision with root package name */
    public int f70751g;

    /* renamed from: h  reason: collision with root package name */
    public int f70752h;

    /* renamed from: i  reason: collision with root package name */
    public int f70753i;

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

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
            }
        }
    }
}
