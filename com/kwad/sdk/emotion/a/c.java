package com.kwad.sdk.emotion.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.b.d;
import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwad.sdk.emotion.model.EmotionPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, SoftReference<Bitmap>> f37160a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f37161b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f37162c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, a> f37163d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, EmotionInfo> f37164e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, b> f37165f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.emotion.b.d f37166g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.emotion.c f37167h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicInteger f37168i;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f37170a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionInfo f37171b;

        /* renamed from: c  reason: collision with root package name */
        public String f37172c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37173d;

        public a(c cVar, EmotionInfo emotionInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, emotionInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37170a = cVar;
            this.f37171b = emotionInfo;
            this.f37172c = emotionInfo.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, emotionInfo) == null) && c.f37160a.get(emotionInfo.id) != null && this.f37173d) {
                this.f37170a.a(emotionInfo, this);
            }
        }

        @Nullable
        public Bitmap a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SoftReference softReference = (SoftReference) c.f37160a.get(this.f37172c);
                Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
                if (bitmap == null || bitmap.isRecycled()) {
                    Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f37171b.id, false);
                    c.f37160a.put(this.f37172c, new SoftReference(a2));
                    return a2;
                }
                return bitmap;
            }
            return (Bitmap) invokeV.objValue;
        }

        @SuppressLint({"CheckResult"})
        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f37171b.id, false);
                if (a2 != null) {
                    c.f37160a.put(this.f37171b.id, new SoftReference(a2));
                    a(this.f37171b);
                    bVar.b();
                } else {
                    this.f37170a.f37166g.a(this.f37171b, false, new d.a(this, bVar) { // from class: com.kwad.sdk.emotion.a.c.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f37174a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f37175b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f37175b = this;
                            this.f37174a = bVar;
                        }

                        @Override // com.kwad.sdk.emotion.b.d.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f37174a.e();
                            }
                        }

                        @Override // com.kwad.sdk.emotion.b.d.a
                        public void a(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                c.f37160a.put(this.f37175b.f37171b.id, new SoftReference(BitmapFactory.decodeFile(str)));
                                a aVar = this.f37175b;
                                aVar.a(aVar.f37171b);
                                this.f37174a.b();
                            }
                        }
                    });
                }
                if (!com.kwad.sdk.emotion.b.b.a().b(this.f37171b.id, true)) {
                    this.f37170a.f37166g.a(this.f37171b, true, new d.a(this, bVar) { // from class: com.kwad.sdk.emotion.a.c.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f37176a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f37177b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f37177b = this;
                            this.f37176a = bVar;
                        }

                        @Override // com.kwad.sdk.emotion.b.d.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f37176a.e();
                            }
                        }

                        @Override // com.kwad.sdk.emotion.b.d.a
                        public void a(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                                this.f37177b.f37173d = true;
                                a aVar = this.f37177b;
                                aVar.a(aVar.f37171b);
                                this.f37176a.c();
                            }
                        }
                    });
                    return;
                }
                this.f37173d = true;
                a(this.f37171b);
                bVar.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(577042485, "Lcom/kwad/sdk/emotion/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(577042485, "Lcom/kwad/sdk/emotion/a/c;");
                return;
            }
        }
        f37160a = new HashMap<>(168);
        f37161b = new com.kwad.sdk.emotion.a.a() { // from class: com.kwad.sdk.emotion.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
    }

    public c() {
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
        this.f37163d = new ConcurrentHashMap();
        this.f37164e = new ConcurrentHashMap();
        this.f37165f = new ConcurrentHashMap();
        this.f37166g = new com.kwad.sdk.emotion.b.d();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f37162c == null) {
                synchronized (c.class) {
                    if (f37162c == null) {
                        f37162c = new c();
                    }
                }
            }
            return f37162c;
        }
        return (c) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionInfo emotionInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, emotionInfo, aVar) == null) {
            this.f37164e.put(emotionInfo.id, emotionInfo);
            for (EmotionCode emotionCode : emotionInfo.emotionCodes) {
                for (String str : emotionCode.codes) {
                    this.f37163d.put(str, aVar);
                }
            }
        }
    }

    private void a(EmotionPackage emotionPackage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, emotionPackage) == null) || emotionPackage == null) {
            return;
        }
        b bVar = new b(emotionPackage, this.f37167h, new Runnable(this) { // from class: com.kwad.sdk.emotion.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f37169a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37169a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37169a.f37168i.decrementAndGet();
                }
            }
        });
        this.f37165f.put(emotionPackage.id, bVar);
        List<EmotionInfo> list = emotionPackage.emotions;
        if (list != null) {
            for (EmotionInfo emotionInfo : list) {
                new a(this, emotionInfo).a(bVar);
            }
        }
    }

    public Bitmap a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, context, str, i2)) == null) {
            a aVar = this.f37163d.get(str);
            Bitmap a2 = aVar != null ? aVar.a() : null;
            return a2 != null ? a2 : BitmapFactory.decodeResource(context.getResources(), i2);
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f37163d.get(str).f37172c : (String) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(f fVar, com.kwad.sdk.emotion.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, cVar) == null) || fVar == null) {
            return;
        }
        List<EmotionPackage> a2 = fVar.a();
        this.f37168i = new AtomicInteger(a2.size());
        this.f37167h = cVar;
        for (EmotionPackage emotionPackage : a2) {
            a(emotionPackage);
        }
    }

    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? com.kwad.sdk.emotion.b.d.a(a(str), true) : (Bitmap) invokeL.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f37163d.containsKey(str) : invokeL.booleanValue;
    }
}
