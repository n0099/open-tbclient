package d.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class p0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f46594a;

    /* renamed from: b  reason: collision with root package name */
    public float f46595b;

    /* renamed from: c  reason: collision with root package name */
    public float f46596c;

    /* renamed from: d  reason: collision with root package name */
    public float f46597d;

    /* renamed from: e  reason: collision with root package name */
    public int f46598e;

    /* renamed from: f  reason: collision with root package name */
    public int f46599f;

    public p0() {
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

    @Override // d.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (bVar.d() == 0) {
                bVar.e(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.f46594a, this.f46596c, this.f46598e, this.f46595b, this.f46597d, this.f46599f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.f46594a = (float) jSONArray.optDouble(0);
                    this.f46595b = (float) jSONArray.optDouble(1);
                    this.f46596c = (float) jSONArray.optDouble(2);
                    this.f46597d = (float) jSONArray.optDouble(3);
                    this.f46598e = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(4));
                    this.f46599f = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
