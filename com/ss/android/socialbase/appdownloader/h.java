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
    public final Queue<Integer> f69035a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69036b;

    /* renamed from: c  reason: collision with root package name */
    public long f69037c;

    /* renamed from: d  reason: collision with root package name */
    public long f69038d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f69039e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f69040f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f69041g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f69051a;
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
            f69051a = new h();
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
        this.f69035a = new ArrayDeque();
        this.f69036b = false;
        this.f69040f = new Handler(Looper.getMainLooper());
        this.f69041g = new Runnable(this) { // from class: com.ss.android.socialbase.appdownloader.h.1
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f69042a.c();
                }
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC1983a(this) { // from class: com.ss.android.socialbase.appdownloader.h.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f69043a;

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
                this.f69043a = this;
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f69043a.f69035a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                long currentTimeMillis = System.currentTimeMillis() - this.f69043a.f69038d;
                if (currentTimeMillis < a2) {
                    if (this.f69043a.f69040f.hasCallbacks(this.f69043a.f69041g)) {
                        return;
                    }
                    this.f69043a.f69040f.postDelayed(this.f69043a.f69041g, a2 - currentTimeMillis);
                    return;
                }
                this.f69043a.f69038d = System.currentTimeMillis();
                this.f69043a.c();
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
                this.f69036b = true;
            }
            this.f69037c = System.currentTimeMillis();
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
                synchronized (this.f69035a) {
                    poll = this.f69035a.poll();
                }
                this.f69040f.removeCallbacks(this.f69041g);
                if (poll != null) {
                    Context N = com.ss.android.socialbase.downloader.downloader.c.N();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f69040f.post(new Runnable(this, N, poll) { // from class: com.ss.android.socialbase.appdownloader.h.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f69044a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Integer f69045b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ h f69046c;

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
                                this.f69046c = this;
                                this.f69044a = N;
                                this.f69045b = poll;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f69046c.b(this.f69044a, this.f69045b.intValue(), false);
                                }
                            }
                        });
                    } else {
                        b(N, poll.intValue(), false);
                    }
                    this.f69040f.postDelayed(this.f69041g, 20000L);
                    return;
                }
                this.f69036b = false;
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? System.currentTimeMillis() - this.f69037c < 1000 : invokeV.booleanValue;
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
            SoftReference<JumpUnknownSourceActivity> softReference = this.f69039e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f69039e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f69051a : (h) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return b(context, i2, z);
            }
            if (d()) {
                this.f69040f.postDelayed(new Runnable(this, context, i2, z) { // from class: com.ss.android.socialbase.appdownloader.h.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f69047a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f69048b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f69049c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ h f69050d;

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
                        this.f69050d = this;
                        this.f69047a = context;
                        this.f69048b = i2;
                        this.f69049c = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f69050d.a(this.f69047a, this.f69048b, this.f69049c);
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
                if (this.f69035a.isEmpty() && !this.f69036b && z2) {
                    return b(context, i2, z);
                }
                int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
                synchronized (this.f69035a) {
                    while (this.f69035a.size() > a2) {
                        this.f69035a.poll();
                    }
                }
                if (z2) {
                    this.f69040f.removeCallbacks(this.f69041g);
                    this.f69040f.postDelayed(this.f69041g, com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_timeout", 20000L));
                }
                synchronized (this.f69035a) {
                    if (!this.f69035a.contains(Integer.valueOf(i2))) {
                        this.f69035a.offer(Integer.valueOf(i2));
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
            this.f69039e = new SoftReference<>(jumpUnknownSourceActivity);
        }
    }
}
