package d.a.n0.a.c0.c.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c0.b.b;
/* loaded from: classes7.dex */
public final class a extends d.a.n0.a.c0.b.a<CameraPreview, d.a.n0.a.z.e.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull d.a.n0.a.z.e.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(2);
    }

    @Override // d.a.n0.a.c0.b.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
            CameraPreview q = q();
            if (q != null) {
                q.h();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.c0.b.a
    @NonNull
    /* renamed from: H */
    public CameraPreview v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new CameraPreview(context, n()) : (CameraPreview) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.c0.b.a
    /* renamed from: I */
    public void D(@NonNull CameraPreview cameraPreview, @NonNull d.a.n0.a.z.e.a aVar, @NonNull d.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cameraPreview, aVar, bVar) == null) {
            super.D(cameraPreview, aVar, bVar);
            if (t()) {
                cameraPreview.p(aVar);
            }
        }
    }
}
