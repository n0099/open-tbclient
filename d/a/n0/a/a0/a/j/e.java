package d.a.n0.a.a0.a.j;

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
    public float f43230a;

    /* renamed from: b  reason: collision with root package name */
    public float f43231b;

    /* renamed from: c  reason: collision with root package name */
    public float f43232c;

    /* renamed from: d  reason: collision with root package name */
    public float f43233d;

    /* renamed from: e  reason: collision with root package name */
    public float f43234e;

    /* renamed from: f  reason: collision with root package name */
    public float f43235f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43236g;

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
        this.f43236g = false;
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && this.f43236g) {
            bVar.j.cubicTo(this.f43230a, this.f43231b, this.f43232c, this.f43233d, this.f43234e, this.f43235f);
        }
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.f43230a = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(0));
        this.f43231b = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(1));
        this.f43232c = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(2));
        this.f43233d = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(3));
        this.f43234e = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(4));
        this.f43235f = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(5));
        this.f43236g = true;
    }
}
