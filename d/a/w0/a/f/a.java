package d.a.w0.a.f;

import android.util.Log;
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
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70948a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f70949b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f70950c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.w0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1963a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f70951e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70952f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f70953g;

        public C1963a(String str, String str2, String str3) {
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
            this.f70951e = str;
            this.f70952f = str2;
            this.f70953g = str3;
        }

        @Override // d.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                stringBuffer.append(simpleDateFormat.format(new Date()));
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f70951e);
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f70952f);
                stringBuffer.append(TrackUI.SEPERATOR);
                stringBuffer.append(this.f70953g);
                f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f23157c, a.f70950c.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1419795134, "Ld/a/w0/a/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1419795134, "Ld/a/w0/a/f/a;");
                return;
            }
        }
        f70950c = new StringBuffer();
        if (d.a.w0.a.c.i() != null) {
            f70948a = !com.baidu.ubs.analytics.d.a.a();
            f70949b = true;
            f70950c.append("ABsdkLog-");
            f70950c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f70950c.append("_");
            try {
                f70950c.append(c(d.a.w0.a.e.i.g(d.a.w0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f70950c.append(".log");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (f70948a) {
                Log.w("BaiDuUbs", str);
            }
            d("w", "BaiDuUbs", str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (f70948a) {
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
        if ((interceptable == null || interceptable.invokeLLL(65540, null, str, str2, str3) == null) && f70949b) {
            b.a(new C1963a(str, str2, str3));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f70950c.toString() : (String) invokeV.objValue;
    }
}
