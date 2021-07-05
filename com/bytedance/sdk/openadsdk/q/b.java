package com.bytedance.sdk.openadsdk.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.r.i;
import java.util.List;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes6.dex */
public class b implements com.bytedance.sdk.openadsdk.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f32172a;

    /* renamed from: b  reason: collision with root package name */
    public final f f32173b;

    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: classes6.dex */
    public class a extends com.bytedance.sdk.component.e.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f32178a;

        /* renamed from: b  reason: collision with root package name */
        public final e f32179b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32180c;

        private String c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                if (str.contains("{TS}") || str.contains("__TS__")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
                }
                if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.f32180c)) {
                    str = str.replace("{UID}", this.f32180c).replace("__UID__", this.f32180c);
                }
                String a2 = i.a();
                return ((str.contains("{OAID}") || str.contains("__OAID__")) && !TextUtils.isEmpty(a2)) ? str.replace("{OAID}", a2).replace("__OAID__", a2) : str;
            }
            return (String) invokeL.objValue;
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://")) : invokeL.booleanValue;
        }

        public String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                try {
                    return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return str;
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && com.bytedance.sdk.openadsdk.core.j.g.a() && a(this.f32179b.b())) {
                if (this.f32179b.d() == 0) {
                    this.f32178a.f32173b.c(this.f32179b);
                    return;
                }
                while (this.f32179b.d() > 0) {
                    try {
                        if (this.f32179b.d() == 5) {
                            this.f32178a.f32173b.a(this.f32179b);
                        }
                    } catch (Throwable unused) {
                    }
                    if (!m.a(this.f32178a.b())) {
                        return;
                    }
                    String c2 = c(this.f32179b.b());
                    if (this.f32179b.c()) {
                        c2 = b(c2);
                    }
                    GetExecutor getExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getGetExecutor();
                    getExecutor.setUrl(c2);
                    NetResponse netResponse = null;
                    try {
                        netResponse = getExecutor.execute();
                    } catch (Throwable unused2) {
                    }
                    if (netResponse != null && netResponse.isSuccess()) {
                        this.f32178a.f32173b.c(this.f32179b);
                        if (j.c()) {
                            j.c("trackurl", "track success : " + this.f32179b.b());
                            return;
                        }
                        return;
                    }
                    if (j.c()) {
                        j.c("trackurl", "track fail : " + this.f32179b.b());
                    }
                    this.f32179b.a(this.f32179b.d() - 1);
                    if (this.f32179b.d() == 0) {
                        this.f32178a.f32173b.c(this.f32179b);
                        if (j.c()) {
                            j.c("trackurl", "track fail and delete : " + this.f32179b.b());
                            return;
                        }
                        return;
                    }
                    this.f32178a.f32173b.b(this.f32179b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, e eVar, String str) {
            super("AdsStats");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32178a = bVar;
            this.f32179b = eVar;
            this.f32180c = str;
        }
    }

    public b(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32172a = context;
        this.f32173b = fVar;
    }

    public static com.bytedance.sdk.openadsdk.q.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? d.b() : (com.bytedance.sdk.openadsdk.q.a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.q.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.f32172a;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.q.a
    public void a(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, list, z) == null) && com.bytedance.sdk.openadsdk.core.j.g.a() && h.b(list)) {
            for (String str2 : list) {
                com.bytedance.sdk.component.e.e.b(new a(new e(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str2, z, 5), str));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.q.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && com.bytedance.sdk.openadsdk.core.j.g.a()) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "trackFailedUrls", str) { // from class: com.bytedance.sdk.openadsdk.q.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f32174a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f32175b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32175b = this;
                    this.f32174a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, this.f32175b.f32173b.a()) { // from class: com.bytedance.sdk.openadsdk.q.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ List f32176a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f32177b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f32177b = this;
                                this.f32176a = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass1 anonymousClass1 = this.f32177b;
                                    anonymousClass1.f32175b.a(this.f32176a, anonymousClass1.f32174a);
                                }
                            }
                        });
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<e> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, list, str) == null) && h.b(list)) {
            for (e eVar : list) {
                com.bytedance.sdk.component.e.e.b(new a(eVar, str));
            }
        }
    }
}
