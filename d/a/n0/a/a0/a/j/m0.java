package d.a.n0.a.a0.a.j;

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
public class m0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Path f43275a;

    public m0() {
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

    @Override // d.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f43275a == null) {
            return;
        }
        int alpha = bVar.f43220g.getAlpha();
        bVar.f(bVar.f43220g);
        canvas.drawPath(this.f43275a, bVar.f43220g);
        bVar.f43220g.setAlpha(alpha);
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    int g4 = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(2));
                    int g5 = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(3));
                    Path path = new Path();
                    this.f43275a = path;
                    path.addRect(new RectF(g2, g3, g2 + g4, g3 + g5), Path.Direction.CW);
                }
            } catch (Exception e2) {
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
