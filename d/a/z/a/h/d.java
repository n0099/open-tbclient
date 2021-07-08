package d.a.z.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.Objects;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static d f68595g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f68596a;

    /* renamed from: b  reason: collision with root package name */
    public File f68597b;

    /* renamed from: c  reason: collision with root package name */
    public File f68598c;

    /* renamed from: d  reason: collision with root package name */
    public File f68599d;

    /* renamed from: e  reason: collision with root package name */
    public File f68600e;

    /* renamed from: f  reason: collision with root package name */
    public File f68601f;

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
            }
        }
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (d.class) {
                if (f68595g == null) {
                    f68595g = new d();
                }
            }
        }
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d().f68600e : (File) invokeV.objValue;
    }

    public static d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f68595g == null) {
                a();
            }
            return f68595g;
        }
        return (d) invokeV.objValue;
    }

    public static File e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File file = new File(context.getFilesDir(), FileUtils.DIR_DUAR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d().f68601f : (File) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return ((Context) Objects.requireNonNull(context)).getExternalFilesDir(FileUtils.DIR_DUAR);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68598c : (File) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68599d : (File) invokeV.objValue;
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f68596a = e(context);
            File c2 = c(context);
            this.f68597b = c2;
            if (c2 == null) {
                this.f68597b = this.f68596a;
            }
            if (this.f68597b != null) {
                this.f68598c = new File(this.f68597b, "sdk");
                File file = new File(this.f68598c, "arsource");
                this.f68599d = file;
                if (!file.exists()) {
                    this.f68599d.mkdirs();
                }
            }
            if (this.f68596a != null) {
                new File(this.f68596a, "sdk");
                File file2 = new File(this.f68596a, "sdklibs/armeabi-v7a");
                this.f68600e = file2;
                if (!file2.exists()) {
                    this.f68600e.mkdirs();
                }
                File file3 = new File(this.f68596a, "sdklibs/armeabi-v7a-2");
                this.f68601f = file3;
                if (file3.exists()) {
                    return;
                }
                this.f68601f.mkdirs();
            }
        }
    }
}
