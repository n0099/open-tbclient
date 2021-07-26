package d.a.o0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f43742a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f43743b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f43744c;

    public f() {
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
        this.f43743b = new Paint();
        this.f43744c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || this.f43742a == null) {
            return;
        }
        this.f43743b.setXfermode(this.f43744c);
        canvas.drawRect(this.f43742a, this.f43743b);
    }

    @Override // d.a.o0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g2 = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    int g3 = d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f43742a = new Rect(g2, g3, d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, d.a.o0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
                }
            } catch (Exception e2) {
                if (d.a.o0.a.k.f46335a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
