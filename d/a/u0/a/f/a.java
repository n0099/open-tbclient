package d.a.u0.a.f;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68279a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68280b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f68281c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.u0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1921a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f68284g;

        public C1921a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68282e = str;
            this.f68283f = str2;
            this.f68284g = str3;
        }

        @Override // d.a.u0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                stringBuffer.append(simpleDateFormat.format(new Date()));
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f68282e);
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f68283f);
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f68284g);
                f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f23425c, a.f68281c.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2099853504, "Ld/a/u0/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2099853504, "Ld/a/u0/a/f/a;");
                return;
            }
        }
        f68281c = new StringBuffer();
        if (d.a.u0.a.c.i() != null) {
            f68279a = !com.baidu.ubs.analytics.d.a.a();
            f68280b = true;
            f68281c.append("ABsdkLog-");
            f68281c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f68281c.append("_");
            try {
                f68281c.append(c(d.a.u0.a.e.i.g(d.a.u0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f68281c.append(".log");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (f68279a) {
                Log.w("BaiDuUbs", str);
            }
            d("w", "BaiDuUbs", str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (f68279a) {
                Log.e("BaiDuUbs", str);
            }
            d("e", "BaiDuUbs", str);
        }
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) && f68280b) {
            b.a(new C1921a(str, str2, str3));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f68281c.toString() : (String) invokeV.objValue;
    }
}
