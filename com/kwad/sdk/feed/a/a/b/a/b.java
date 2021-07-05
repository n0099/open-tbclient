package com.kwad.sdk.feed.a.a.b.a;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.e;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f37336b;

    /* renamed from: c  reason: collision with root package name */
    public String f37337c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, e.a> f37338d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37339e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f37340f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37341g;

    /* renamed from: h  reason: collision with root package name */
    public e.a f37342h;

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
        this.f37340f = new Handler();
        this.f37341g = false;
        this.f37342h = new e.a(this) { // from class: com.kwad.sdk.feed.a.a.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37343a;

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
                this.f37343a = this;
            }

            @Override // com.kwad.sdk.lib.widget.recycler.e.a
            public void a(AdTemplate adTemplate, float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLF(1048576, this, adTemplate, f2) == null) {
                    com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this.f37343a).f38574a).f38572h + "--visiblePercent=" + f2);
                    if (f2 < 0.3f || this.f37343a.f37341g) {
                        return;
                    }
                    this.f37343a.f37340f.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.feed.a.a.b.a.b.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f37344a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f37344a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && !this.f37344a.f37343a.f37336b.mPvReported && this.f37344a.f37343a.f37339e.e()) {
                                com.kwad.sdk.core.report.b.a(this.f37344a.f37343a.f37336b, (JSONObject) null);
                                if (this.f37344a.f37343a.f37338d != null && this.f37344a.f37343a.f37342h != null) {
                                    this.f37344a.f37343a.f37338d.remove(this.f37344a.f37343a.f37337c);
                                }
                                com.kwad.sdk.core.d.a.a("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this.f37344a.f37343a).f38574a).f38572h);
                            }
                        }
                    }, 1000L);
                    this.f37343a.f37341g = true;
                }
            }
        };
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f38573i;
            this.f37336b = adTemplate;
            String str = adTemplate.mUniqueId;
            this.f37337c = str;
            this.f37339e = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f37314a.f37379b;
            if (adTemplate.mPvReported) {
                return;
            }
            Map<String, e.a> map = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f37314a.f37380c;
            this.f37338d = map;
            map.put(str, this.f37342h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            Map<String, e.a> map = this.f37338d;
            if (map != null && this.f37342h != null) {
                map.remove(this.f37337c);
            }
            this.f37341g = false;
            this.f37340f.removeCallbacksAndMessages(null);
        }
    }
}
