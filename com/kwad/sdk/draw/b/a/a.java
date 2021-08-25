package com.kwad.sdk.draw.b.a;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.widget.d;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f72604b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f72605c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f72606d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72607e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f72608f;

    /* renamed from: g  reason: collision with root package name */
    public d f72609g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f72610h;

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
                return;
            }
        }
        this.f72607e = false;
        this.f72608f = false;
        this.f72609g = new d(this) { // from class: com.kwad.sdk.draw.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72611a;

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
                this.f72611a = this;
            }

            @Override // com.kwad.sdk.widget.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    j.c(this.f72611a.f72604b);
                }
            }
        };
        this.f72610h = new e(this) { // from class: com.kwad.sdk.draw.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72612a;

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
                this.f72612a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    if (((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f72612a.a(j3);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f72612a.f72608f = false;
                    if (!this.f72612a.f72604b.mPvReported && ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onAdShow();
                    }
                    if (((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                        this.f72612a.f72607e = false;
                    }
                    com.kwad.sdk.core.report.a.a(this.f72612a.f72604b, (JSONObject) null);
                    com.kwad.sdk.core.report.a.i(this.f72612a.f72604b);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.d();
                    if (!this.f72612a.f72607e) {
                        if (this.f72612a.f72608f) {
                            return;
                        }
                        this.f72612a.f72608f = true;
                        com.kwad.sdk.core.report.d.a(this.f72612a.f72604b, System.currentTimeMillis(), 1);
                        return;
                    }
                    this.f72612a.f72607e = false;
                    if (((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.e();
                    if (((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                    this.f72612a.f72607e = true;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    com.kwad.sdk.core.report.a.j(this.f72612a.f72604b);
                    if (((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f72612a).f72586a.f72587a.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f72606d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f72606d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f72604b, ceil, null);
                    this.f72606d.remove(num);
                    return;
                }
            }
        }
    }

    private void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar) == null) {
            View j2 = j();
            if (j2 instanceof AdBasePvFrameLayout) {
                ((AdBasePvFrameLayout) j2).setVisibleListener(dVar);
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f72586a.f72589c;
            this.f72604b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f72605c = i2;
            this.f72606d = com.kwad.sdk.core.response.b.a.I(i2);
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.a(this.f72610h);
            a(this.f72609g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.a.a) this).f72586a.f72591e.b(this.f72610h);
            a((d) null);
        }
    }
}
