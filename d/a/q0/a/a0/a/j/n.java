package d.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class n extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46578a;

    /* renamed from: b  reason: collision with root package name */
    public int f46579b;

    /* renamed from: c  reason: collision with root package name */
    public int f46580c;

    public n() {
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.f46578a)) {
            return;
        }
        TextPaint textPaint = bVar.f46524i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f46580c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        int alpha = textPaint.getAlpha();
        bVar.f(textPaint);
        canvas.drawText(this.f46578a, this.f46579b, f6, textPaint);
        textPaint.setAlpha(alpha);
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.f46578a = jSONArray.optString(0);
                    this.f46579b = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f46580c = d.a.q0.a.v2.n0.g((float) jSONArray.optDouble(2));
                }
            } catch (Exception e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
