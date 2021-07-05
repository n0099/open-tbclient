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
public class j0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f46554a;

    /* renamed from: b  reason: collision with root package name */
    public float f46555b;

    /* renamed from: c  reason: collision with root package name */
    public float f46556c;

    /* renamed from: d  reason: collision with root package name */
    public float f46557d;

    /* renamed from: e  reason: collision with root package name */
    public int f46558e;

    /* renamed from: f  reason: collision with root package name */
    public int f46559f;

    public j0() {
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
            } else {
                canvas.restoreToCount(bVar.d());
                bVar.e(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.f46554a, this.f46556c, this.f46558e, this.f46555b, this.f46557d, this.f46559f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.f46554a = (float) jSONArray.optDouble(0);
                    this.f46555b = (float) jSONArray.optDouble(1);
                    this.f46556c = (float) jSONArray.optDouble(2);
                    this.f46557d = (float) jSONArray.optDouble(3);
                    this.f46558e = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(4));
                    this.f46559f = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
