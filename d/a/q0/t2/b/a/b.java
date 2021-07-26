package d.a.q0.t2.b.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f63024e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f63025a;

    /* renamed from: b  reason: collision with root package name */
    public Point f63026b;

    /* renamed from: c  reason: collision with root package name */
    public Point f63027c;

    /* renamed from: d  reason: collision with root package name */
    public Point f63028d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-254806246, "Ld/a/q0/t2/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-254806246, "Ld/a/q0/t2/b/a/b;");
                return;
            }
        }
        f63024e = Pattern.compile(",");
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63025a = context;
    }

    public static boolean a(Camera camera) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, camera)) == null) ? d(camera.getParameters().getSupportedFocusModes(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO) != null : invokeL.booleanValue;
    }

    public static int b(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i2)) == null) {
            int i3 = 0;
            for (String str : f63024e.split(charSequence)) {
                try {
                    double parseDouble = Double.parseDouble(str.trim());
                    int i4 = (int) (10.0d * parseDouble);
                    if (Math.abs(i2 - parseDouble) < Math.abs(i2 - i3)) {
                        i3 = i4;
                    }
                } catch (NumberFormatException unused) {
                    return i2;
                }
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static Point c(List<Camera.Size> list, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, point)) == null) {
            Iterator<Camera.Size> it = list.iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = Integer.MAX_VALUE;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                int i5 = next.width;
                int i6 = next.height;
                int abs = Math.abs(i5 - point.x) + Math.abs(i6 - point.y);
                if (abs == 0) {
                    i3 = i6;
                    i2 = i5;
                    break;
                } else if (abs < i4) {
                    i3 = i6;
                    i2 = i5;
                    i4 = abs;
                }
            }
            if (i2 <= 0 || i3 <= 0) {
                return null;
            }
            return new Point(i2, i3);
        }
        return (Point) invokeLL.objValue;
    }

    public static String d(Collection<String> collection, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, collection, strArr)) == null) {
            if (collection != null) {
                for (String str : strArr) {
                    if (collection.contains(str)) {
                        return str;
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static Point g(Camera.Parameters parameters, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, parameters, point)) == null) {
            Point c2 = c(parameters.getSupportedPreviewSizes(), point);
            return c2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : c2;
        }
        return (Point) invokeLL.objValue;
    }

    public Point e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63027c : (Point) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i2 = 0;
            Camera.getCameraInfo(0, cameraInfo);
            int rotation = ((WindowManager) this.f63025a.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return invokeV.intValue;
    }

    public void h(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, camera) == null) {
            Camera.Parameters parameters = camera.getParameters();
            if (a(camera)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.f63026b = a.d(this.f63025a);
            Point point = new Point();
            Point point2 = this.f63026b;
            point.x = point2.x;
            point.y = point2.y;
            int c2 = a.c(this.f63025a);
            if (c2 == 0) {
                Point point3 = this.f63026b;
                point.x = point3.y;
                point.y = point3.x;
            }
            Point g2 = g(parameters, point);
            this.f63028d = g2;
            if (c2 == 0) {
                Point point4 = this.f63028d;
                this.f63027c = new Point(point4.y, point4.x);
                return;
            }
            this.f63027c = g2;
        }
    }

    public void i(Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, camera) == null) {
            Camera.Parameters parameters = camera.getParameters();
            Point point = this.f63028d;
            parameters.setPreviewSize(point.x, point.y);
            j(parameters);
            camera.setDisplayOrientation(f());
            camera.setParameters(parameters);
        }
    }

    public final void j(Camera.Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, parameters) == null) {
            String str = parameters.get("zoom-supported");
            if (str == null || Boolean.parseBoolean(str)) {
                int i2 = 27;
                String str2 = parameters.get("max-zoom");
                if (str2 != null) {
                    try {
                        int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                        if (27 > parseDouble) {
                            i2 = parseDouble;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                String str3 = parameters.get("taking-picture-zoom-max");
                if (str3 != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (i2 > parseInt) {
                            i2 = parseInt;
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
                String str4 = parameters.get("mot-zoom-values");
                if (str4 != null) {
                    i2 = b(str4, i2);
                }
                String str5 = parameters.get("mot-zoom-step");
                if (str5 != null) {
                    try {
                        int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                        if (parseDouble2 > 1) {
                            i2 -= i2 % parseDouble2;
                        }
                    } catch (NumberFormatException unused3) {
                    }
                }
                if (str2 != null || str4 != null) {
                    parameters.set("zoom", String.valueOf(i2 / 10.0d));
                }
                if (str3 != null) {
                    parameters.set("taking-picture-zoom", i2);
                }
            }
        }
    }
}
