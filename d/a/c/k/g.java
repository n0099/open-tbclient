package d.a.c.k;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class g extends DynamicDrawableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f41936e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f41937f;

    /* renamed from: g  reason: collision with root package name */
    public int f41938g;

    /* renamed from: h  reason: collision with root package name */
    public Context f41939h;

    /* renamed from: i  reason: collision with root package name */
    public a f41940i;
    public Rect j;

    /* loaded from: classes7.dex */
    public interface a {
        Drawable a(g gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar, int i2, int i3) {
        super(i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Rect();
        this.f41938g = i2;
        this.f41940i = aVar;
    }

    public void a(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            this.f41936e = drawable;
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.j.set(i2, i3, i4, i5);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        canvas.save();
        int i7 = drawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 0) {
            i5 = i6;
        }
        canvas.translate(f2, i5 - (drawable.getBounds().bottom - 4));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Drawable drawable = this.f41936e;
            if (drawable == null) {
                a aVar = this.f41940i;
                drawable = aVar != null ? aVar.a(this) : null;
            }
            if (drawable != null) {
                return drawable;
            }
            try {
                if (this.f41937f != null) {
                    InputStream openInputStream = this.f41939h.getContentResolver().openInputStream(this.f41937f);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f41939h.getResources(), BitmapFactory.decodeStream(openInputStream));
                    try {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                        openInputStream.close();
                        return bitmapDrawable;
                    } catch (Exception unused) {
                        drawable = bitmapDrawable;
                    }
                } else {
                    drawable = this.f41939h.getResources().getDrawable(this.f41938g);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            } catch (Exception unused2) {
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
            if (this.f41936e == null && this.f41940i != null) {
                if (fontMetricsInt != null) {
                    int i4 = -this.j.bottom;
                    fontMetricsInt.ascent = i4;
                    fontMetricsInt.descent = 0;
                    fontMetricsInt.top = i4;
                    fontMetricsInt.bottom = 0;
                }
                return this.j.right;
            }
            return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
        }
        return invokeCommon.intValue;
    }
}
