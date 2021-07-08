package com.bytedance.sdk.openadsdk.l.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.l;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.e.e;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.e.t;
import com.bytedance.sdk.openadsdk.l.a.a;
import com.bytedance.sdk.openadsdk.l.a.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f31406a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31407b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final l f31408c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f31409d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f31410e;

    /* renamed from: f  reason: collision with root package name */
    public t f31411f;

    /* renamed from: g  reason: collision with root package name */
    public long f31412g;

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0354b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
        public void a(String str, com.bytedance.sdk.openadsdk.l.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, dVar) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.l.a.b.InterfaceC0354b
        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.l.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0354b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.l.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.l.a.c f31434a;

        /* renamed from: b  reason: collision with root package name */
        public m f31435b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0354b> f31436c;

        /* renamed from: d  reason: collision with root package name */
        public VAdError f31437d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.l.a.d f31438e;

        public d(com.bytedance.sdk.openadsdk.l.a.c cVar, InterfaceC0354b interfaceC0354b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, interfaceC0354b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31436c = new CopyOnWriteArrayList();
            this.f31434a = cVar;
            a(interfaceC0354b);
        }

        public void a(InterfaceC0354b interfaceC0354b) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, interfaceC0354b) == null) || interfaceC0354b == null) {
                return;
            }
            this.f31436c.add(interfaceC0354b);
        }

        public boolean a() {
            InterceptResult invokeV;
            com.bytedance.sdk.openadsdk.l.a.d dVar;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31437d == null && (dVar = this.f31438e) != null && dVar.c() : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-349404129, "Lcom/bytedance/sdk/openadsdk/l/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-349404129, "Lcom/bytedance/sdk/openadsdk/l/a/b;");
        }
    }

    public b(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31409d = new Handler(Looper.getMainLooper());
        this.f31410e = Collections.synchronizedMap(new HashMap());
        this.f31408c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.openadsdk.l.b bVar, InterfaceC0354b interfaceC0354b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0353a a2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{bVar, interfaceC0354b, Integer.valueOf(i2), Integer.valueOf(i3), scaleType}) == null) || bVar == null) {
            return;
        }
        String b2 = bVar.b();
        String a3 = bVar.a();
        if (TextUtils.isEmpty(b2)) {
            b2 = com.bytedance.sdk.openadsdk.l.a.a.a().a(a3, i2, i3, scaleType);
        }
        j.f("splashLoadAd", " GiftLoader doTask cacheKey " + b2);
        if (f31407b) {
            a2 = com.bytedance.sdk.openadsdk.l.a.a.a().b(b2);
        } else {
            a2 = com.bytedance.sdk.openadsdk.l.a.a.a().a(b2);
        }
        a.C0353a c0353a = a2;
        if (c0353a != null && (bArr = c0353a.f31405a) != null) {
            this.f31409d.postAtFrontOfQueue(new Runnable(this, interfaceC0354b, a3, c0353a, new c(new com.bytedance.sdk.openadsdk.l.a.d(bArr), interfaceC0354b, b2, a3)) { // from class: com.bytedance.sdk.openadsdk.l.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ InterfaceC0354b f31421a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f31422b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a.C0353a f31423c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ c f31424d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f31425e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, interfaceC0354b, a3, c0353a, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31425e = this;
                    this.f31421a = interfaceC0354b;
                    this.f31422b = a3;
                    this.f31423c = c0353a;
                    this.f31424d = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f31421a != null) {
                            j.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                            b.f31406a = 1;
                            this.f31425e.a(true);
                            this.f31421a.a(this.f31422b, new com.bytedance.sdk.openadsdk.l.a.d(this.f31423c.f31405a));
                        }
                        InterfaceC0354b interfaceC0354b2 = this.f31421a;
                        if (interfaceC0354b2 != null) {
                            interfaceC0354b2.a(this.f31424d);
                        }
                    }
                }
            });
            return;
        }
        d dVar = this.f31410e.get(b2);
        if (dVar != null) {
            dVar.a(interfaceC0354b);
            return;
        }
        a(false);
        j.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + a3);
        com.bytedance.sdk.openadsdk.l.a.c a4 = a(a3, i2, i3, scaleType, b2);
        d dVar2 = new d(a4, interfaceC0354b);
        c();
        this.f31408c.a(a4);
        this.f31410e.put(b2, dVar2);
    }

    private void c() {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (tVar = this.f31411f) != null && tVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f31412g = currentTimeMillis;
            t tVar2 = this.f31411f;
            tVar2.h(currentTimeMillis - tVar2.t());
            this.f31411f.n(this.f31412g);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.l.b bVar, InterfaceC0354b interfaceC0354b, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, interfaceC0354b, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            f31407b = z;
            a(bVar, interfaceC0354b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.l.a.d f31429a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0354b f31430b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31431c;

        /* renamed from: d  reason: collision with root package name */
        public final String f31432d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f31433e;

        public c(com.bytedance.sdk.openadsdk.l.a.d dVar, InterfaceC0354b interfaceC0354b, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, interfaceC0354b, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f31429a = dVar;
            this.f31430b = interfaceC0354b;
            this.f31431c = str;
            this.f31432d = str2;
            this.f31433e = null;
        }

        public c(VAdError vAdError, InterfaceC0354b interfaceC0354b, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vAdError, interfaceC0354b, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31433e = vAdError;
            this.f31430b = interfaceC0354b;
            this.f31431c = str;
            this.f31432d = str2;
            this.f31429a = null;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.l.b bVar, InterfaceC0354b interfaceC0354b, int i2, int i3, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, interfaceC0354b, Integer.valueOf(i2), Integer.valueOf(i3), scaleType}) == null) {
            if (interfaceC0354b != null) {
                this.f31409d.post(new Runnable(this, interfaceC0354b) { // from class: com.bytedance.sdk.openadsdk.l.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC0354b f31413a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ b f31414b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, interfaceC0354b};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31414b = this;
                        this.f31413a = interfaceC0354b;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC0354b interfaceC0354b2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (interfaceC0354b2 = this.f31413a) == null) {
                            return;
                        }
                        interfaceC0354b2.a();
                    }
                });
            }
            e.a(new g(this, "GifLoader get", bVar, interfaceC0354b, i2, i3, scaleType) { // from class: com.bytedance.sdk.openadsdk.l.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.l.b f31415a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ InterfaceC0354b f31416b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f31417c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31418d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ImageView.ScaleType f31419e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f31420f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, bVar, interfaceC0354b, Integer.valueOf(i2), Integer.valueOf(i3), scaleType};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31420f = this;
                    this.f31415a = bVar;
                    this.f31416b = interfaceC0354b;
                    this.f31417c = i2;
                    this.f31418d = i3;
                    this.f31419e = scaleType;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f31420f.b(this.f31415a, this.f31416b, this.f31417c, this.f31418d, this.f31419e);
                    }
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65545, this, z) == null) && (tVar = this.f31411f) != null && tVar.z()) {
            this.f31411f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.l.a.c a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, str2})) == null) {
            com.bytedance.sdk.openadsdk.l.a.c cVar = new com.bytedance.sdk.openadsdk.l.a.c(str, new c.a(this, str2, str) { // from class: com.bytedance.sdk.openadsdk.l.a.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31426a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f31427b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f31428c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31428c = this;
                    this.f31426a = str2;
                    this.f31427b = str;
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a.c.a
                public void a(String str3, com.bytedance.sdk.openadsdk.l.a.d dVar) {
                    d dVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, dVar) == null) || (dVar2 = (d) this.f31428c.f31410e.get(this.f31426a)) == null) {
                        return;
                    }
                    for (InterfaceC0354b interfaceC0354b : dVar2.f31436c) {
                        if (interfaceC0354b != null) {
                            b.f31406a = 2;
                            interfaceC0354b.a(str3, dVar);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.adnet.core.m.a
                public void b(m<com.bytedance.sdk.openadsdk.l.a.d> mVar) {
                    d dVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, mVar) == null) || (dVar = (d) this.f31428c.f31410e.remove(this.f31426a)) == null) {
                        return;
                    }
                    dVar.f31435b = mVar;
                    dVar.f31437d = mVar.f28033c;
                    this.f31428c.a(this.f31426a, this.f31427b, dVar);
                }

                @Override // com.bytedance.sdk.component.adnet.core.m.a
                public void a(m<com.bytedance.sdk.openadsdk.l.a.d> mVar) {
                    d dVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) || (dVar = (d) this.f31428c.f31410e.remove(this.f31426a)) == null) {
                        return;
                    }
                    dVar.f31435b = mVar;
                    dVar.f31438e = mVar.f28031a;
                    this.f31428c.a(this.f31426a, this.f31427b, dVar);
                }
            }, i2, i3, scaleType, Bitmap.Config.RGB_565, str2);
            cVar.a(this.f31411f);
            return cVar;
        }
        return (com.bytedance.sdk.openadsdk.l.a.c) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, this, str, str2, dVar) == null) || dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0354b> list = dVar.f31436c;
        if (list != null) {
            for (InterfaceC0354b interfaceC0354b : list) {
                if (interfaceC0354b != null) {
                    if (a2) {
                        interfaceC0354b.a(new c(dVar.f31438e, interfaceC0354b, str, str2));
                    } else {
                        interfaceC0354b.b(new c(dVar.f31437d, interfaceC0354b, str, str2));
                    }
                    interfaceC0354b.b();
                }
            }
            dVar.f31436c.clear();
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public t b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31411f : (t) invokeV.objValue;
    }

    public void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            this.f31411f = tVar;
        }
    }
}
