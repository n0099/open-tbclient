package d.a.n0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o0 extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43284a;

    /* renamed from: b  reason: collision with root package name */
    public int f43285b;

    /* renamed from: c  reason: collision with root package name */
    public int f43286c;

    /* renamed from: d  reason: collision with root package name */
    public float f43287d;

    /* renamed from: e  reason: collision with root package name */
    public float f43288e;

    /* renamed from: f  reason: collision with root package name */
    public float f43289f;

    public o0() {
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
        this.f43287d = -1.0f;
        this.f43288e = 0.0f;
        this.f43289f = 1.0f;
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || TextUtils.isEmpty(this.f43284a)) {
            return;
        }
        TextPaint textPaint = bVar.f43222i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f43286c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f43288e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f43284a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f43287d != -1.0f) {
                float f7 = this.f43287d;
                if (rect.width() > f7) {
                    this.f43288e = f7 / rect.width();
                }
            }
            this.f43288e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f43289f);
        textPaint.setColor(bVar.q);
        bVar.f(textPaint);
        canvas.scale(this.f43288e, 1.0f);
        canvas.drawText(this.f43284a, this.f43285b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // d.a.n0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.f43284a = jSONArray.optString(0);
                    this.f43285b = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f43286c = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.f43287d = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(3));
                    }
                    this.f43289f = d.a.n0.a.v2.n0.g(1.0f);
                }
            } catch (Exception e2) {
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
