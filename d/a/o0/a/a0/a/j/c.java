package d.a.o0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RectF f43728a;

    /* renamed from: b  reason: collision with root package name */
    public float f43729b;

    /* renamed from: c  reason: collision with root package name */
    public float f43730c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43731d;

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

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f43728a == null) {
            return;
        }
        if (!this.f43731d && Math.abs(this.f43730c) >= 360.0f) {
            Path path = bVar.j;
            RectF rectF = this.f43728a;
            float f2 = rectF.bottom;
            float f3 = rectF.top;
            path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
            bVar.j.arcTo(this.f43728a, 0.0f, this.f43729b);
            return;
        }
        float f4 = this.f43730c % 360.0f;
        if (f4 < 0.0f && !this.f43731d) {
            f4 += 360.0f;
        } else if (f4 > 0.0f && this.f43731d) {
            f4 -= 360.0f;
        }
        bVar.j.arcTo(this.f43728a, this.f43729b, f4);
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            if (jSONArray.length() > 4) {
                int g2 = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(1));
                int g4 = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(2));
                float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
                float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
                this.f43728a = new RectF(g2 - g4, g3 - g4, g2 + g4, g3 + g4);
                this.f43729b = degrees;
                this.f43730c = degrees2 - degrees;
            }
            if (jSONArray.length() > 5) {
                this.f43731d = jSONArray.optBoolean(5);
            }
        }
    }
}
