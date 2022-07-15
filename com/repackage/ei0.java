package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ei0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<jj0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-413606008, "Lcom/repackage/ei0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-413606008, "Lcom/repackage/ei0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadAction.values().length];
            a = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.FAIL_RETRY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ei0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-413605977, "Lcom/repackage/ei0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-413605977, "Lcom/repackage/ei0$b;");
                    return;
                }
            }
            a = new ei0(null);
        }
    }

    public /* synthetic */ ei0(a aVar) {
        this();
    }

    public static ei0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ei0) invokeV.objValue;
    }

    public static void c(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, si0Var) == null) {
            if (TextUtils.isEmpty(si0Var.p.c) || !qg0.b(si0Var.p.c)) {
                tj0.f(si0Var.d);
                d(AdDownloadAction.OPEN, si0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull si0 si0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, si0Var) == null) || TextUtils.isEmpty(si0Var.p.a)) {
            return;
        }
        String str = si0Var.q.j;
        switch (a.a[adDownloadAction.ordinal()]) {
            case 1:
                logType = ClogBuilder.LogType.DOWNLOAD_START;
                break;
            case 2:
                logType = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                break;
            case 3:
                logType = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                break;
            case 4:
                logType = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                break;
            case 5:
                logType = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                break;
            case 6:
                logType = ClogBuilder.LogType.INSTALL_COMPLETE;
                break;
            case 7:
                logType = ClogBuilder.LogType.DEEP_LINK;
                break;
            case 8:
                logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                break;
            case 9:
                logType = ClogBuilder.LogType.DOWNLOAD_RETRY;
                break;
            default:
                return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ClogBuilder.Area.DOWNLOAD_BUTTON.type;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType).p(si0Var.p.a).v(si0Var.q.a).j(str).k(si0Var.d).l(si0Var.q.a).m(si0Var.q.b).n(si0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(si0Var.q.d)) {
            yx0.f(jSONObject, "ad_download_content_type", si0Var.q.d);
        }
        long j = si0Var.q.e;
        if (j > 0) {
            yx0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = si0Var.n;
        if (i > 0) {
            yx0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(si0Var.o)) {
            yx0.f(jSONObject, "version_name", si0Var.o);
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        iy0.b(clogBuilder);
    }

    public void a(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, si0Var) == null) || si0Var.e()) {
            return;
        }
        this.c.b(si0Var);
        si0Var.c = AdDownloadStatus.NONE;
        e(AdDownloadAction.FAIL, si0Var);
    }

    public void e(@NonNull AdDownloadAction adDownloadAction, @NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, si0Var) == null) {
            d(adDownloadAction, si0Var);
            this.b.readLock().lock();
            try {
                List list = (List) zx0.b(this.a, si0Var.d());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != xx0.k(list); i++) {
                    jj0 jj0Var = (jj0) xx0.d(list, i);
                    if (jj0Var != null && jj0Var.getData() != null) {
                        jj0Var.getData().h(si0Var);
                        jj0Var.a(adDownloadAction, jj0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void f(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, si0Var) == null) {
            this.c.c(si0Var);
        }
    }

    public void g(String str, jj0 jj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, jj0Var) == null) || TextUtils.isEmpty(str) || jj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) zx0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                zx0.e(this.a, str, list);
            }
            xx0.b(list, jj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void h(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, si0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, si0Var);
            this.c.d(si0Var, new fi0(si0Var));
        }
    }

    public void i(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, si0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, si0Var);
            si0Var.b = this.c.a(si0Var, new fi0(si0Var));
            si0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void j(String str, jj0 jj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, jj0Var) == null) || TextUtils.isEmpty(str) || jj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) zx0.b(this.a, str);
            if (list == null) {
                return;
            }
            xx0.j(list, jj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public ei0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>(32);
        this.b = new ReentrantReadWriteLock();
        this.c = lj0.b();
    }
}
