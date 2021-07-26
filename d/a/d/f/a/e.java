package d.a.d.f.a;

import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float[] f42106a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42107b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42108c;

    /* renamed from: d  reason: collision with root package name */
    public int f42109d;

    /* renamed from: e  reason: collision with root package name */
    public int f42110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42111f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42112g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42113h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42114i;
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
        this.f42106a = new float[8];
        this.f42113h = false;
        this.f42114i = true;
        this.j = b.f42100a;
        this.k = 1.0f;
        this.o = false;
    }
}
