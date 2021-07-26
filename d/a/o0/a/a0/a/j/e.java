package d.a.o0.a.a0.a.j;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f43734a;

    /* renamed from: b  reason: collision with root package name */
    public float f43735b;

    /* renamed from: c  reason: collision with root package name */
    public float f43736c;

    /* renamed from: d  reason: collision with root package name */
    public float f43737d;

    /* renamed from: e  reason: collision with root package name */
    public float f43738e;

    /* renamed from: f  reason: collision with root package name */
    public float f43739f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43740g;

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
        this.f43740g = false;
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f43740g) {
            bVar.j.cubicTo(this.f43734a, this.f43735b, this.f43736c, this.f43737d, this.f43738e, this.f43739f);
        }
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f43734a = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f43735b = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f43736c = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f43737d = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f43738e = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f43739f = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f43740g = true;
    }
}
