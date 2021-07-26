package d.a.q0.u3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater;
import com.baidu.ugc.editvideo.subtitle.ninepatchchunk.NinePatchChunk;
import d.a.w0.t.t;
import d.a.w0.t.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64821a;

    /* renamed from: b  reason: collision with root package name */
    public int f64822b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64823c;

    /* renamed from: d  reason: collision with root package name */
    public TextWordsEntity.TextStyleEntity f64824d;

    /* renamed from: e  reason: collision with root package name */
    public TextWordsEntity.TextFontEntity f64825e;

    /* renamed from: f  reason: collision with root package name */
    public final TextPaint f64826f;

    /* renamed from: g  reason: collision with root package name */
    public final TextPaint f64827g;

    /* renamed from: h  reason: collision with root package name */
    public final TextPaint f64828h;

    /* renamed from: i  reason: collision with root package name */
    public int f64829i;
    public List<String> j;

    public d() {
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
        this.f64822b = 5;
        this.j = new ArrayList();
        this.f64826f = new TextPaint(1);
        this.f64827g = new TextPaint(1);
        this.f64828h = new TextPaint(1);
        this.f64821a = t.j(R.dimen.tbds72);
    }

    public static d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (k == null) {
                synchronized (d.class) {
                    if (k == null) {
                        k = new d();
                    }
                }
            }
            return k;
        }
        return (d) invokeV.objValue;
    }

    public final void a(String str, Canvas canvas, int i2, int i3, int i4, TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, canvas, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), textPaint}) == null) {
            i(textPaint);
            canvas.drawText(str, i2, i3, textPaint);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64826f.setTypeface(Typeface.DEFAULT);
            this.f64827g.setTypeface(Typeface.DEFAULT);
            this.f64828h.setTypeface(Typeface.DEFAULT);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64826f.setShader(null);
            this.f64826f.setColor(-1);
            this.f64826f.clearShadowLayer();
            this.f64827g.clearShadowLayer();
            this.f64828h.clearShadowLayer();
            this.j.clear();
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str.contains("\n")) {
                String[] split = str.split("\n");
                if (split.length > 1) {
                    int i2 = 0;
                    int i3 = 0;
                    for (int i4 = 0; i4 < split.length; i4++) {
                        int length = split[i4].length();
                        if (length > i3) {
                            i2 = i4;
                            i3 = length;
                        }
                    }
                    return split[i2];
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (int) (v.e() * 0.85d) : invokeV.intValue;
    }

    public final int[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new int[]{0, 0};
            }
            String e2 = e(str);
            int[] iArr = new int[2];
            TextPaint textPaint = new TextPaint(1);
            i(textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(this.f64821a);
            float measureText = textPaint.measureText(e2) + 2.0f + 40.0f;
            if (measureText > f()) {
                measureText = f() + 2.0f;
            }
            float f2 = 0.0f;
            if (measureText > 0.0f) {
                StaticLayout measuredStaticLayout = NewSubTitleCreater.getMeasuredStaticLayout(str, textPaint, (int) measureText, this.f64822b, Layout.Alignment.ALIGN_CENTER, 0);
                this.f64829i = measuredStaticLayout.getLineCount();
                int i2 = 0;
                for (int i3 = 0; i3 < this.f64829i; i3++) {
                    int lineEnd = measuredStaticLayout.getLineEnd(i3);
                    if (lineEnd != 0) {
                        this.j.add(str.substring(i2, lineEnd));
                        i2 = lineEnd;
                    }
                }
                f2 = measuredStaticLayout.getHeight() + 2.0f + 40.0f;
            }
            iArr[0] = (int) measureText;
            iArr[1] = (int) f2;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public Bitmap h(Context context, String str, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextFontEntity textFontEntity) {
        InterceptResult invokeLLLL;
        int i2;
        int i3;
        int i4;
        Canvas canvas;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, str, textStyleEntity, textFontEntity)) == null) {
            c();
            this.f64823c = context;
            this.f64824d = textStyleEntity;
            this.f64825e = textFontEntity;
            this.f64826f.setTextSize(this.f64821a);
            int[] g2 = g(str);
            if (g2[0] >= 1 && g2[1] >= 1) {
                Bitmap a2 = d.a.w0.t.f.a(this.f64824d);
                NinePatchChunk f2 = d.a.w0.t.f.f(a2, this.f64824d);
                if (f2 != null) {
                    Rect rect = f2.padding;
                    i2 = rect.left;
                    int i5 = rect.top;
                    g2[0] = g2[0] + i2;
                    g2[1] = g2[1] + i5;
                    g2[0] = g2[0] + rect.right;
                    g2[1] = g2[1] + rect.bottom;
                    if (a2 != null && g2[0] < a2.getWidth()) {
                        g2[0] = a2.getWidth();
                    }
                    i3 = i5;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                Bitmap createBitmap = Bitmap.createBitmap(g2[0], g2[1], Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.save();
                int i6 = 20;
                d.a.w0.t.f.b(a2, f2, canvas2, 20);
                int g3 = d.a.w0.t.f.g(this.f64826f);
                int i7 = i2 + 20;
                int abs = (g3 / 2) + ((int) (Math.abs(this.f64826f.ascent() + this.f64826f.descent()) / 2.0f)) + 20 + i3;
                int i8 = 0;
                while (i8 < this.f64829i) {
                    int i9 = i8 + 1;
                    d.a.w0.t.f.c(this.f64826f, this.f64824d);
                    int[] d2 = d.a.w0.t.f.d(this.f64826f, this.f64827g, this.f64828h, this.f64824d);
                    d.a.w0.t.f.e(canvas2, this.f64826f, i7, (g3 * i8) + i6 + i3, (g3 * i9) + i6 + i3, this.f64824d);
                    if (d2[0] != 0) {
                        i4 = i8;
                        canvas = canvas2;
                        a(this.j.get(i8), canvas2, i7, abs, i4, this.f64827g);
                    } else {
                        i4 = i8;
                        canvas = canvas2;
                    }
                    if (d2[1] != 0) {
                        a(this.j.get(i4), canvas, i7, abs, i4, this.f64828h);
                    }
                    a(this.j.get(i4), canvas, i7, abs, i4, this.f64826f);
                    abs += g3;
                    canvas2 = canvas;
                    i8 = i9;
                    i6 = 20;
                }
                canvas2.restore();
                return createBitmap;
            }
            return Bitmap.createBitmap(10, this.f64821a, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeLLLL.objValue;
    }

    public final void i(TextPaint textPaint) {
        TextWordsEntity.TextFontEntity textFontEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, textPaint) == null) || (textFontEntity = this.f64825e) == null) {
            return;
        }
        try {
            if (textFontEntity.isDefault()) {
                b();
                return;
            }
            this.f64825e.setFontRootDir(new File(FileHelper.getVideoTmpDir()));
            textPaint.setTypeface(Typeface.createFromFile(this.f64825e.getSourceFile()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f64821a = i2;
        }
    }
}
