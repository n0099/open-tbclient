package com.kwad.sdk.emotion.a;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.emotion.a.e;
import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.emotion.model.EmotionResponse;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f37178a;

    /* renamed from: e  reason: collision with root package name */
    public static com.kwad.sdk.emotion.model.a f37179e;

    /* renamed from: f  reason: collision with root package name */
    public static com.kwad.sdk.emotion.model.b f37180f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37181b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, f> f37182c;

    /* renamed from: d  reason: collision with root package name */
    public int f37183d;

    /* renamed from: g  reason: collision with root package name */
    public String f37184g;

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
                return;
            }
        }
        this.f37181b = false;
        this.f37182c = new ConcurrentHashMap();
        this.f37184g = "0";
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f37178a == null) {
                synchronized (d.class) {
                    if (f37178a == null) {
                        f37178a = new d();
                    }
                }
            }
            return f37178a;
        }
        return (d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPackage> a(EmotionResponse emotionResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, emotionResponse)) == null) {
            if (emotionResponse == null) {
                return new ArrayList();
            }
            com.kwad.sdk.core.d.a.a("EmotionManager", "load form network: size=" + emotionResponse.mEmotionPackageList.size());
            return emotionResponse.mEmotionPackageList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, f> a(List<EmotionPackage> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list)) == null) {
            com.kwad.sdk.core.d.a.a("EmotionManager", "load form network: size=" + list.size());
            this.f37182c.clear();
            this.f37183d = 0;
            for (EmotionPackage emotionPackage : list) {
                this.f37183d++;
                f fVar = this.f37182c.get(Integer.valueOf(emotionPackage.type));
                if (fVar != null) {
                    fVar.a(emotionPackage.id, emotionPackage);
                } else {
                    f fVar2 = new f();
                    fVar2.a(emotionPackage.id, emotionPackage);
                    this.f37182c.put(Integer.valueOf(emotionPackage.type), fVar2);
                }
            }
            return this.f37182c;
        }
        return (Map) invokeL.objValue;
    }

    @SuppressLint({"CheckResult"})
    public void a(com.kwad.sdk.emotion.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            e.a(new e.a(this, bVar) { // from class: com.kwad.sdk.emotion.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.emotion.b f37186a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f37187b;

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
                    this.f37187b = this;
                    this.f37186a = bVar;
                }

                @Override // com.kwad.sdk.emotion.a.e.a
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f37187b.f37181b = false;
                        com.kwad.sdk.emotion.b bVar2 = this.f37186a;
                        if (bVar2 != null) {
                            bVar2.a(null);
                        }
                    }
                }

                @Override // com.kwad.sdk.emotion.a.e.a
                public void a(EmotionResponse emotionResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionResponse) == null) {
                        this.f37187b.f37181b = true;
                        d dVar = this.f37187b;
                        dVar.a(dVar.a(emotionResponse));
                        com.kwad.sdk.emotion.b bVar2 = this.f37186a;
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                    }
                }
            });
        }
    }

    public void a(@NonNull com.kwad.sdk.emotion.model.a aVar, @NonNull com.kwad.sdk.emotion.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, bVar) == null) {
            z.a(bVar.a());
            z.a(aVar.b());
            f37179e = aVar;
            f37180f = bVar;
            com.kwad.sdk.emotion.b.e.a(aVar.b());
            com.kwad.sdk.core.d.a.a("EmotionManager", "sConfig.getSaveDir()" + f37179e.b());
            a(new com.kwad.sdk.emotion.b(this) { // from class: com.kwad.sdk.emotion.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f37185a;

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
                    this.f37185a = this;
                }

                @Override // com.kwad.sdk.emotion.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37185a.b();
                        com.kwad.sdk.core.d.a.a("EmotionManager", "fetchEmotionInfo");
                    }
                }

                @Override // com.kwad.sdk.emotion.b
                public void a(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        com.kwad.sdk.core.d.a.a("EmotionManager", "fetchEmotionInfo e", th);
                    }
                }
            });
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.emotion.b.b.a().a(f37179e.b());
            if (this.f37181b) {
                c.a().a(this.f37182c.get(1), f37180f.b());
            } else {
                f37180f.b().a(null, new IllegalStateException("not available: invoke `#fetchEmotionInfo()` or check `#isAvailable()`"));
            }
        }
    }
}
