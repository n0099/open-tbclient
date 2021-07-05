package com.kwad.sdk.contentalliance.home;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.slide.LiveSlidHomeParam;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35240a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.PageListener f35241b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.VideoListener f35242c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public LiveSlidHomeParam f35243d;

    /* renamed from: e  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.trends.view.c> f35244e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.detail.photo.comment.g> f35245f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f35246g;

    /* renamed from: h  reason: collision with root package name */
    public i f35247h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35248i;
    public boolean j;
    public SceneImpl k;
    public volatile boolean l;

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
        this.f35244e = new ArrayList();
        this.f35245f = new ArrayList();
        this.f35248i = false;
        this.j = false;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.i.a aVar = this.f35240a;
            if (aVar != null) {
                aVar.b();
                this.f35240a.f();
            }
            List<com.kwad.sdk.contentalliance.trends.view.c> list = this.f35244e;
            if (list != null) {
                list.clear();
            }
            List<com.kwad.sdk.contentalliance.detail.photo.comment.g> list2 = this.f35245f;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f35244e.clear();
        }
    }
}
