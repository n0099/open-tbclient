package d.a.n.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n.c.g;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43683d;

    /* renamed from: e  reason: collision with root package name */
    public static a f43684e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43685a;

    /* renamed from: b  reason: collision with root package name */
    public String f43686b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f43687c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1439384210, "Ld/a/n/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1439384210, "Ld/a/n/a/a;");
                return;
            }
        }
        f43683d = AppConfig.isDebug();
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
                return;
            }
        }
        d();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f43684e == null) {
                synchronized (a.class) {
                    if (f43684e == null) {
                        f43684e = new a();
                    }
                }
            }
            return f43684e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43686b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43685a : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43687c = AppRuntime.getAppContext().getSharedPreferences(ChannelManager.PREFS_NAME, 0);
            f();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String g2 = g();
            this.f43686b = g2;
            if (!TextUtils.isEmpty(g2) || TextUtils.isEmpty(this.f43685a)) {
                return;
            }
            this.f43686b = this.f43685a;
            j();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String i2 = i();
            this.f43685a = i2;
            if (TextUtils.isEmpty(i2)) {
                this.f43685a = h();
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43687c.getString("channel", null) : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0084 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #0 {Exception -> 0x0080, blocks: (B:47:0x007c, B:51:0x0084), top: B:61:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            InputStream inputStream2 = null;
            String str2 = null;
            try {
                inputStream = AppRuntime.getAppContext().getAssets().open("channel");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    inputStream2 = inputStream;
                    str = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                str = null;
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                inputStream = null;
            }
            try {
                str2 = bufferedReader.readLine();
                inputStream.close();
                bufferedReader.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        if (f43683d) {
                            Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e4);
                            return str2;
                        }
                        return str2;
                    }
                }
                bufferedReader.close();
                return str2;
            } catch (Exception e5) {
                e = e5;
                String str3 = str2;
                inputStream2 = inputStream;
                str = str3;
                try {
                    if (f43683d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e6) {
                            if (f43683d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e6);
                            }
                            return str;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str;
                } catch (Throwable th4) {
                    InputStream inputStream3 = inputStream2;
                    th = th4;
                    inputStream = inputStream3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                            if (f43683d) {
                                Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e7);
                            }
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (d.a.n.a.a.f43683d == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        android.util.Log.e(com.baidu.searchbox.logsystem.basic.upload.identity.ChannelManager.TAG, "readLastChannelFromRaw", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (d.a.n.a.a.f43683d == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = null;
            try {
                InputStream openRawResource = AppRuntime.getAppContext().getResources().openRawResource(g.tnconfig);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
                try {
                    str = bufferedReader.readLine();
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    if (f43683d) {
                        Log.e(ChannelManager.TAG, "readLastChannelFromRaw", e3);
                    }
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Exception e5) {
                if (f43683d) {
                    Log.e(ChannelManager.TAG, "readLastChannelFromAssets", e5);
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f43687c.edit().putString("channel", this.f43686b).apply();
        }
    }
}
