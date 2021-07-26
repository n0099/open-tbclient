package d.a.o0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class j0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f43756a;

    /* renamed from: b  reason: collision with root package name */
    public float f43757b;

    /* renamed from: c  reason: collision with root package name */
    public float f43758c;

    /* renamed from: d  reason: collision with root package name */
    public float f43759d;

    /* renamed from: e  reason: collision with root package name */
    public int f43760e;

    /* renamed from: f  reason: collision with root package name */
    public int f43761f;

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

    @Override // d.a.o0.a.a0.a.j.a
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
            matrix.setValues(new float[]{this.f43756a, this.f43758c, this.f43760e, this.f43757b, this.f43759d, this.f43761f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.f43756a = (float) jSONArray.optDouble(0);
                    this.f43757b = (float) jSONArray.optDouble(1);
                    this.f43758c = (float) jSONArray.optDouble(2);
                    this.f43759d = (float) jSONArray.optDouble(3);
                    this.f43760e = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(4));
                    this.f43761f = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
