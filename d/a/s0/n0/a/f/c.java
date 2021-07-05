package d.a.s0.n0.a.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // d.a.s0.n0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.s0.n0.a.g.c cVar = this.f63663a;
            if (cVar.f63683h == null) {
                this.f63664b.onError(cVar.f63681f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(cVar.f63676a, cVar.f63677b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.f63663a.f63683h);
            g(new d.a.s0.n0.a.g.b(), createBitmap);
        }
    }
}
