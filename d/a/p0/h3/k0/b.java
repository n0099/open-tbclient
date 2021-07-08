package d.a.p0.h3.k0;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f58080a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f58081b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f58082c;

    /* renamed from: d  reason: collision with root package name */
    public Context f58083d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f58084e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58085f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58086g;

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
        this.f58083d = context;
        this.f58082c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f58083d.getResources().getDisplayMetrics();
            this.f58082c.set(0, 0, this.f58081b.getWidth(), this.f58081b.getHeight());
            canvas.drawBitmap(this.f58081b, this.f58082c, this.f58080a, (Paint) null);
        }
    }
}
