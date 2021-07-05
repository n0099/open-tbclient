package d.a.s0.h3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f61324a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f61325b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f61326c;

    /* renamed from: d  reason: collision with root package name */
    public Context f61327d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f61328e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61329f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61330g;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61327d = context;
        this.f61326c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f61327d.getResources().getDisplayMetrics();
            this.f61326c.set(0, 0, this.f61325b.getWidth(), this.f61325b.getHeight());
            canvas.drawBitmap(this.f61325b, this.f61326c, this.f61324a, (Paint) null);
        }
    }
}
