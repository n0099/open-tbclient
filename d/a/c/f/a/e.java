package d.a.c.f.a;

import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float[] f44586a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44587b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44588c;

    /* renamed from: d  reason: collision with root package name */
    public int f44589d;

    /* renamed from: e  reason: collision with root package name */
    public int f44590e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44591f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44592g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44593h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44594i;
    public int j;
    public float k;
    public Matrix l;
    public int m;
    public boolean n;
    public boolean o;

    public e() {
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
        this.f44586a = new float[8];
        this.f44593h = false;
        this.f44594i = true;
        this.j = b.f44580a;
        this.k = 1.0f;
        this.o = false;
    }
}
