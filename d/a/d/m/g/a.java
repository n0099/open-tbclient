package d.a.d.m.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f45222a;

    /* renamed from: b  reason: collision with root package name */
    public String f45223b;

    /* renamed from: c  reason: collision with root package name */
    public int f45224c;

    /* renamed from: d  reason: collision with root package name */
    public String f45225d;

    /* renamed from: e  reason: collision with root package name */
    public int f45226e;

    /* renamed from: f  reason: collision with root package name */
    public int f45227f;

    /* renamed from: g  reason: collision with root package name */
    public int f45228g;

    /* renamed from: h  reason: collision with root package name */
    public int f45229h;

    /* renamed from: i  reason: collision with root package name */
    public int f45230i;
    public String j;
    public int k;
    public int l;

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
                return;
            }
        }
        this.f45230i = 3;
    }
}
