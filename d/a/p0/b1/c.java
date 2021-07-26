package d.a.p0.b1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52037a;

    /* renamed from: b  reason: collision with root package name */
    public String f52038b;

    /* renamed from: c  reason: collision with root package name */
    public int f52039c;

    /* renamed from: d  reason: collision with root package name */
    public int f52040d;

    /* renamed from: e  reason: collision with root package name */
    public float f52041e;

    /* renamed from: f  reason: collision with root package name */
    public float f52042f;

    /* renamed from: g  reason: collision with root package name */
    public String f52043g;

    /* renamed from: h  reason: collision with root package name */
    public int f52044h;

    /* renamed from: i  reason: collision with root package name */
    public int f52045i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;

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
