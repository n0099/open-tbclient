package com.kwad.sdk.lib.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class b<MODEL, PAGE extends BaseResultData> extends a<PAGE, MODEL> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Handler f38514c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38515d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38516e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38517f;

    /* renamed from: g  reason: collision with root package name */
    public i<com.kwad.sdk.core.network.g, PAGE> f38518g;

    /* renamed from: h  reason: collision with root package name */
    public PAGE f38519h;

    public b() {
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
        this.f38514c = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i2, str) == null) {
            com.kwad.sdk.core.d.a.c("BasePageList", "onError: errorCode" + i2 + "--errorMsg:" + str);
            boolean n = n();
            this.f38515d = a(i2);
            this.f38516e = false;
            this.f38517f = false;
            this.f38518g = null;
            this.f38513b.a(n, i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(PAGE page, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, page, z) == null) {
            boolean n = n();
            this.f38515d = b((b<MODEL, PAGE>) page);
            a((b<MODEL, PAGE>) page, this.f38512a);
            this.f38519h = page;
            this.f38513b.b(n, z);
            this.f38516e = false;
            this.f38517f = false;
            this.f38518g = null;
        }
    }

    public abstract i<com.kwad.sdk.core.network.g, PAGE> a();

    public abstract List<MODEL> a(PAGE page);

    public void a(PAGE page, List<MODEL> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, page, list) == null) {
            if (n()) {
                list.clear();
            }
            List<MODEL> a2 = a((b<MODEL, PAGE>) page);
            if (a2 == null) {
                return;
            }
            list.addAll(a2);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b(PAGE page) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, page)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public PAGE d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (PAGE) invokeV.objValue;
    }

    @Override // com.kwad.sdk.lib.b.c
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i<com.kwad.sdk.core.network.g, PAGE> iVar = this.f38518g;
            if (iVar != null) {
                iVar.e();
            }
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f38513b.a();
        }
    }

    @Override // com.kwad.sdk.lib.b.c
    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38515d : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.b.c
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
            m();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f38517f = true;
        }
    }

    @Override // com.kwad.sdk.lib.b.c
    public void m() {
        PAGE d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f38516e) {
            return;
        }
        if (this.f38515d || this.f38517f) {
            this.f38516e = true;
            if (n() && b() && (d2 = d()) != null) {
                this.f38513b.a(n(), true);
                this.f38514c.post(new Runnable(this, d2) { // from class: com.kwad.sdk.lib.b.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseResultData f38520a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ b f38521b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, d2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38521b = this;
                        this.f38520a = d2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f38521b.a((b) this.f38520a, true);
                        }
                    }
                });
                return;
            }
            i<com.kwad.sdk.core.network.g, PAGE> a2 = a();
            this.f38518g = a2;
            if (a2 != null) {
                this.f38513b.a(n(), false);
                this.f38518g.a(new j<com.kwad.sdk.core.network.g, PAGE>(this) { // from class: com.kwad.sdk.lib.b.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f38522a;

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
                        this.f38522a = this;
                    }

                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, gVar, i2, str) == null) {
                            this.f38522a.f38514c.post(new Runnable(this, i2, str) { // from class: com.kwad.sdk.lib.b.b.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ int f38525a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f38526b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f38527c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), str};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f38527c = this;
                                    this.f38525a = i2;
                                    this.f38526b = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f38527c.f38522a.a(this.f38525a, this.f38526b);
                                    }
                                }
                            });
                        }
                    }

                    @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                    public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull PAGE page) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, page) == null) {
                            this.f38522a.f38514c.post(new Runnable(this, page) { // from class: com.kwad.sdk.lib.b.b.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ BaseResultData f38523a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f38524b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, page};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f38524b = this;
                                    this.f38523a = page;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f38524b.f38522a.a((b) this.f38523a, false);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            this.f38515d = false;
            this.f38516e = false;
            this.f38517f = false;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38519h == null || this.f38517f : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.b.c
    @Nullable
    /* renamed from: o */
    public PAGE p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f38519h : (PAGE) invokeV.objValue;
    }
}
