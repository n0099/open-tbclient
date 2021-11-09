package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f69034a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69035b;

    /* renamed from: c  reason: collision with root package name */
    public long f69036c;

    /* renamed from: d  reason: collision with root package name */
    public long f69037d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f69038e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f69039f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f69040g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f69050a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1108141813, "Lcom/ss/android/socialbase/appdownloader/h$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1108141813, "Lcom/ss/android/socialbase/appdownloader/h$a;");
                    return;
                }
            }
            f69050a = new h();
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69034a = new ArrayDeque();
        this.f69035b = false;
        this.f69039f = new Handler(Looper.getMainLooper());
        this.f69040g = new Runnable(this) { // from class: com.ss.android.socialbase.appdownloader.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f69041a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69041a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f69041a.c();
                }
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC1983a(this) { // from class: com.ss.android.socialbase.appdownloader.h.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f69042a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69042a = this;
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f69042a.f69034a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                long currentTimeMillis = System.currentTimeMillis() - this.f69042a.f69037d;
                if (currentTimeMillis < a2) {
                    if (this.f69042a.f69039f.hasCallbacks(this.f69042a.f69040g)) {
                        return;
                    }
                    this.f69042a.f69039f.postDelayed(this.f69042a.f69040g, a2 - currentTimeMillis);
                    return;
                }
                this.f69042a.f69037d = System.currentTimeMillis();
                this.f69042a.c();
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int b2 = c.b(context, i2, z);
            if (b2 == 1) {
                this.f69035b = true;
            }
            this.f69036c = System.currentTimeMillis();
            return b2;
        }
        return invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Integer poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b()) {
                synchronized (this.f69034a) {
                    poll = this.f69034a.poll();
                }
                this.f69039f.removeCallbacks(this.f69040g);
                if (poll != null) {
                    Context N = com.ss.android.socialbase.downloader.downloader.c.N();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f69039f.post(new Runnable(this, N, poll) { // from class: com.ss.android.socialbase.appdownloader.h.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f69043a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Integer f69044b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ h f69045c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, N, poll};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f69045c = this;
                                this.f69043a = N;
                                this.f69044b = poll;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f69045c.b(this.f69043a, this.f69044b.intValue(), false);
                                }
                            }
                        });
                    } else {
                        b(N, poll.intValue(), false);
                    }
                    this.f69039f.postDelayed(this.f69040g, 20000L);
                    return;
                }
                this.f69035b = false;
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? System.currentTimeMillis() - this.f69036c < 1000 : invokeV.booleanValue;
    }

    public void a(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, str) == null) || downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SoftReference<JumpUnknownSourceActivity> softReference = this.f69038e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f69038e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f69050a : (h) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return b(context, i2, z);
            }
            if (d()) {
                this.f69039f.postDelayed(new Runnable(this, context, i2, z) { // from class: com.ss.android.socialbase.appdownloader.h.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f69046a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f69047b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f69048c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ h f69049d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, Integer.valueOf(i2), Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69049d = this;
                        this.f69046a = context;
                        this.f69047b = i2;
                        this.f69048c = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f69049d.a(this.f69046a, this.f69047b, this.f69048c);
                        }
                    }
                }, 1000L);
                return 1;
            } else if (com.ss.android.socialbase.downloader.a.a.a().b()) {
                com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
                return b(context, i2, z);
            } else if (b.a()) {
                return 1;
            } else {
                boolean z2 = Build.VERSION.SDK_INT < 29;
                if (this.f69034a.isEmpty() && !this.f69035b && z2) {
                    return b(context, i2, z);
                }
                int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
                synchronized (this.f69034a) {
                    while (this.f69034a.size() > a2) {
                        this.f69034a.poll();
                    }
                }
                if (z2) {
                    this.f69039f.removeCallbacks(this.f69040g);
                    this.f69039f.postDelayed(this.f69040g, com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_timeout", 20000L));
                }
                synchronized (this.f69034a) {
                    if (!this.f69034a.contains(Integer.valueOf(i2))) {
                        this.f69034a.offer(Integer.valueOf(i2));
                    }
                }
                return 1;
            }
        }
        return invokeCommon.intValue;
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jumpUnknownSourceActivity) == null) {
            this.f69038e = new SoftReference<>(jumpUnknownSourceActivity);
        }
    }
}
