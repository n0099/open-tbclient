package d.a.s0.v3.k;

import android.hardware.Camera;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68799a;

    /* renamed from: b  reason: collision with root package name */
    public float f68800b;

    /* renamed from: c  reason: collision with root package name */
    public int f68801c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f68802d;

    /* renamed from: e  reason: collision with root package name */
    public i f68803e;

    public b(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {camera};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68799a = 0;
        this.f68802d = camera;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Camera camera = this.f68802d;
            if (camera == null) {
                return -1;
            }
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                if (parameters.getMaxZoom() > 40) {
                    return 40;
                }
                return parameters.getMaxZoom();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            i iVar = this.f68803e;
            if (iVar == null || !iVar.j()) {
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    this.f68799a = 0;
                } else if (action != 2) {
                    if (action == 5) {
                        this.f68799a = 1;
                        this.f68800b = e(motionEvent);
                    }
                } else if (this.f68799a != 1 || motionEvent.getPointerCount() < 2) {
                    return true;
                } else {
                    float e2 = e(motionEvent);
                    int i2 = (int) ((e2 - this.f68800b) / 10.0f);
                    if (i2 >= 1 || i2 <= -1) {
                        int i3 = this.f68801c + i2;
                        if (i3 > a()) {
                            i3 = a();
                        }
                        d(i3 >= 0 ? i3 : 0);
                        this.f68800b = e2;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f68803e = iVar;
        }
    }

    public final void d(int i2) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (camera = this.f68802d) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            parameters.setZoom(i2);
            this.f68802d.setParameters(parameters);
            this.f68801c = i2;
        }
    }

    public final float e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            double x = motionEvent.getX(0) - motionEvent.getX(1);
            double y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }
}
