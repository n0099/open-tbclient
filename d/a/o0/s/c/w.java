package d.a.o0.s.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53178a;

    /* renamed from: b  reason: collision with root package name */
    public String f53179b;

    /* renamed from: c  reason: collision with root package name */
    public String f53180c;

    /* renamed from: d  reason: collision with root package name */
    public int f53181d;

    /* renamed from: e  reason: collision with root package name */
    public int f53182e;

    /* renamed from: f  reason: collision with root package name */
    public int f53183f;

    /* renamed from: g  reason: collision with root package name */
    public int f53184g;

    /* renamed from: h  reason: collision with root package name */
    public int f53185h;

    public w() {
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
