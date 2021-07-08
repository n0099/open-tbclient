package d.a.n0.a.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.n0.a.g1.f;
import d.a.n0.a.k;
import d.a.n0.a.v2.l0;
import d.a.n0.t.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48532c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Timer f48533a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.a.z.c.b f48534b;

    /* renamed from: d.a.n0.a.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0991a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z.c.b f48535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f48536f;

        public C0991a(a aVar, d.a.n0.a.z.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48536f = aVar;
            this.f48535e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.z.c.b bVar = this.f48535e;
                if (bVar != null) {
                    bVar.a();
                }
                this.f48536f.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f48537a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(941733415, "Ld/a/n0/a/z/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(941733415, "Ld/a/n0/a/z/a$b;");
                    return;
                }
            }
            f48537a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962988965, "Ld/a/n0/a/z/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962988965, "Ld/a/n0/a/z/a;");
                return;
            }
        }
        f48532c = k.f45831a;
    }

    public /* synthetic */ a(C0991a c0991a) {
        this();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f48537a : (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.n0.a.z.c.b bVar = this.f48534b;
            if (bVar != null) {
                bVar.cancel();
            }
            j();
        }
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0 : invokeL.booleanValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0 : invokeL.booleanValue;
    }

    public void e(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            str3 = "error";
            if (l0.f("1.13.0")) {
                HashMap hashMap = new HashMap();
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                hashMap.put("cameraId", str2);
                hashMap.put("eType", z ? "error" : IntentConfig.STOP);
                f.V().v(new d.a.n0.a.o0.d.b("camera", hashMap));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                jSONObject.put("cameraId", str2);
                if (!z) {
                    str3 = IntentConfig.STOP;
                }
                jSONObject.put("eType", str3);
            } catch (JSONException e2) {
                if (f48532c) {
                    e2.printStackTrace();
                }
            }
            d.a.n0.a.w2.g.c.a.d(str, str2, "camera", jSONObject.optString("eType"), jSONObject);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                CameraPreview.j();
            } catch (Exception e2) {
                if (f48532c) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            a();
        }
    }

    public boolean h(byte[] bArr, String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bArr, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (file.exists()) {
                    boolean delete = file.delete();
                    if (f48532c) {
                        Log.d("SwanAppCameraManager", "delete = " + delete);
                    }
                }
                if (file.getParentFile() != null) {
                    boolean mkdirs = file.getParentFile().mkdirs();
                    if (f48532c) {
                        Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                    }
                }
                boolean createNewFile = file.createNewFile();
                if (f48532c) {
                    Log.d("SwanAppCameraManager", "createNewFile = " + createNewFile);
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (i3 != 0 || z) {
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    if (i3 != 0) {
                        matrix.postRotate(i3);
                    }
                    if (z) {
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i2, bufferedOutputStream);
                bufferedOutputStream.flush();
                d.d(bufferedOutputStream);
                return true;
            } catch (Exception e2) {
                if (f48532c) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            } catch (OutOfMemoryError e3) {
                if (f48532c) {
                    e3.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void i(int i2, d.a.n0.a.z.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, bVar) == null) {
            this.f48534b = bVar;
            Timer timer = new Timer();
            this.f48533a = timer;
            timer.schedule(new C0991a(this, bVar), i2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48534b = null;
            Timer timer = this.f48533a;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
