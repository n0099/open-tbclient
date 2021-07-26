package d.a.p0.d1.m;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52396e;

    /* renamed from: f  reason: collision with root package name */
    public int f52397f;

    /* renamed from: g  reason: collision with root package name */
    public int f52398g;

    /* renamed from: h  reason: collision with root package name */
    public int f52399h;

    /* renamed from: i  reason: collision with root package name */
    public int f52400i;
    public int j;
    public int k;
    public int l;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1312572974, "Ld/a/p0/d1/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1312572974, "Ld/a/p0/d1/m/c;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52396e = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.f52397f = R.color.CAM_X0305;
        this.f52398g = n;
        this.f52399h = o;
        this.f52400i = q;
        this.j = 0;
        this.k = p;
        this.l = 0;
        if (bVar != null) {
            this.f52396e = bVar.f52387a;
            this.f52397f = bVar.f52388b;
            this.f52398g = bVar.f52389c;
            this.f52400i = bVar.f52390d;
            this.f52399h = bVar.f52391e;
            this.j = bVar.f52392f;
            this.k = bVar.f52393g;
            this.l = bVar.f52394h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
            canvas.save();
            canvas.translate(0.0f, this.l);
            paint.setColor(SkinManager.getColor(this.f52397f));
            paint.setAntiAlias(true);
            float descent = this.f52400i - (paint.descent() - paint.ascent());
            float f3 = i5;
            RectF rectF = new RectF(this.j + f2, (paint.ascent() + f3) - descent, this.j + f2 + this.m + (this.f52399h * 2), paint.descent() + f3);
            int i7 = this.f52398g;
            canvas.drawRoundRect(rectF, i7, i7, paint);
            paint.setColor(this.f52396e);
            canvas.drawText(charSequence, i2, i3, this.f52399h + f2 + this.j, f3 - (descent / 2.0f), paint);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            int measureText = (int) paint.measureText(charSequence, i2, i3);
            this.m = measureText;
            return measureText + (this.f52399h * 2) + this.j + this.k;
        }
        return invokeCommon.intValue;
    }
}
