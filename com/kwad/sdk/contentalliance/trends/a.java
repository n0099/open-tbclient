package com.kwad.sdk.contentalliance.trends;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.home.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35446c;

    /* renamed from: d  reason: collision with root package name */
    public int f35447d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35448e;

    /* renamed from: f  reason: collision with root package name */
    public String f35449f;

    /* renamed from: g  reason: collision with root package name */
    public List<TrendInfo> f35450g;

    /* renamed from: h  reason: collision with root package name */
    public int f35451h;

    /* renamed from: i  reason: collision with root package name */
    public TrendInfo f35452i;
    public int j;

    public a(SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35448e = false;
        this.f35446c = sceneImpl;
    }

    private void a(boolean z, h.a aVar, @NonNull TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Boolean.valueOf(z), aVar, trendInfo}) == null) {
            i.a aVar2 = new i.a(this, z) { // from class: com.kwad.sdk.contentalliance.trends.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35453a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f35454b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35454b = this;
                    this.f35453a = z;
                }

                @Override // com.kwad.sdk.core.g.i.a
                @MainThread
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f35454b.a(i2, str);
                        this.f35454b.f35448e = false;
                    }
                }

                @Override // com.kwad.sdk.core.g.i.a
                @MainThread
                public void a(@NonNull List<AdTemplate> list) {
                    a aVar3;
                    TrendInfo trendInfo2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (this.f35453a) {
                            this.f35454b.f35447d = 0;
                            this.f35454b.f35004a.clear();
                        }
                        if (this.f35454b.f35004a.isEmpty()) {
                            m.e();
                        }
                        this.f35454b.f35004a.addAll(list);
                        a aVar4 = this.f35454b;
                        aVar4.a(this.f35453a, aVar4.f35447d);
                        this.f35454b.f35448e = false;
                        a.e(this.f35454b);
                        if (this.f35454b.j + 1 < this.f35454b.f35450g.size()) {
                            aVar3 = this.f35454b;
                            trendInfo2 = (TrendInfo) aVar3.f35450g.get(this.f35454b.j + 1);
                        } else {
                            aVar3 = this.f35454b;
                            trendInfo2 = null;
                        }
                        aVar3.f35452i = trendInfo2;
                        a.h(this.f35454b);
                    }
                }
            };
            if (trendInfo != null) {
                o.a(aVar, trendInfo, new o.c(this, aVar2, trendInfo) { // from class: com.kwad.sdk.contentalliance.trends.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i.a f35455a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TrendInfo f35456b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f35457c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar2, trendInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35457c = this;
                        this.f35455a = aVar2;
                        this.f35456b = trendInfo;
                    }

                    @Override // com.kwad.sdk.core.g.o.c
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            this.f35455a.a(i2, str);
                        }
                    }

                    @Override // com.kwad.sdk.core.g.o.c
                    public void a(@NonNull List<AdTemplate> list) {
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                            int i2 = 0;
                            while (i2 < list.size()) {
                                AdTemplate adTemplate = list.get(i2);
                                adTemplate.mCurrentTrendTitle = this.f35456b.toJson().toString();
                                if (i2 != 0 || this.f35457c.f35447d <= 0 || this.f35457c.f35447d - 1 >= this.f35457c.f35450g.size()) {
                                    str = (i2 == list.size() + (-1) && this.f35457c.f35447d + 1 < this.f35457c.f35450g.size()) ? "上一个热点" : "上一个热点";
                                    i2++;
                                } else {
                                    str = "下一个热点";
                                }
                                adTemplate.mTrendSlideType = str;
                                i2++;
                            }
                            this.f35455a.a(list);
                        }
                    }
                });
                return;
            }
            int i2 = f.f36360c.k;
            aVar2.a(i2, f.f36360c.l + "(无视频资源)");
        }
    }

    private int c(TrendInfo trendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, trendInfo)) == null) {
            if (trendInfo != null && this.f35450g != null) {
                for (int i2 = 0; i2 < this.f35450g.size(); i2++) {
                    if (trendInfo.trendId == this.f35450g.get(i2).trendId) {
                        return i2;
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f35447d;
        aVar.f35447d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h(a aVar) {
        int i2 = aVar.f35451h;
        aVar.f35451h = i2 + 1;
        return i2;
    }

    public void a(TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, trendInfo) == null) {
            this.f35452i = trendInfo;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f35449f = str;
        this.f35450g = TrendInfo.asList(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (r8 != null) goto L24;
     */
    @Override // com.kwad.sdk.contentalliance.home.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2, int i2) {
        f fVar;
        TrendInfo trendInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35448e) {
            return;
        }
        int i3 = 1;
        this.f35448e = true;
        com.kwad.sdk.core.d.a.a("DataFetcher", "loadData isRefresh=" + z);
        a(z, z2, i2, this.f35447d);
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar2 = new com.kwad.sdk.core.g.a.f(this.f35446c);
        fVar2.f36139b = this.f35446c.getPageScene();
        fVar2.f36140c = 100L;
        aVar.f36273a.add(fVar2);
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        if (i2 == 0) {
            i3 = 3;
        } else if (i2 != 1 && i2 != 2 && i2 != 3) {
            i3 = i2 != 4 ? 0 : 2;
        }
        cVar.f36125c = i3;
        cVar.f36126d = this.f35451h;
        aVar.f36274b = cVar;
        if (this.f35449f == null || this.f35450g.size() <= 0) {
            if (i3 != 3 || (trendInfo = this.f35452i) == null) {
                if (i3 != 2) {
                    this.f35448e = false;
                    a(z, this.f35447d);
                    fVar = f.f36358a;
                }
                this.f35448e = false;
                a(z, this.f35447d);
                fVar = f.f36364g;
            }
            this.j = c(trendInfo);
            a(z, aVar, this.f35452i);
            return;
        }
        if (this.f35447d < this.f35450g.size()) {
            trendInfo = this.f35452i;
        }
        this.f35448e = false;
        a(z, this.f35447d);
        fVar = f.f36364g;
        a(fVar.k, fVar.l);
    }

    public boolean b(@NonNull TrendInfo trendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, trendInfo)) == null) {
            if (this.f35448e) {
                return false;
            }
            this.f35448e = true;
            this.f35447d = 0;
            this.j = c(trendInfo);
            a(true, false, 1, this.f35447d);
            h.a aVar = new h.a();
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f35446c);
            fVar.f36139b = this.f35446c.getPageScene();
            fVar.f36140c = 100L;
            aVar.f36273a.add(fVar);
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f36125c = 1;
            cVar.f36126d = this.f35451h;
            aVar.f36274b = cVar;
            a(true, aVar, trendInfo);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
        }
    }
}
