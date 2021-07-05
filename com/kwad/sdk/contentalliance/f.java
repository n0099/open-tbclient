package com.kwad.sdk.contentalliance;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsContentPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f extends AbstractKsContentPage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsScene f34990a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<g> f34991b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.PageListener f34992c;

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.VideoListener f34993d;

    /* renamed from: e  reason: collision with root package name */
    public List<KsContentPage.SubShowItem> f34994e;

    /* renamed from: f  reason: collision with root package name */
    public a f34995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34996g;

    /* renamed from: h  reason: collision with root package name */
    public String f34997h;

    /* renamed from: com.kwad.sdk.contentalliance.f$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class a implements com.kwad.sdk.contentalliance.home.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.OnPageLoadListener f34998a;

        /* renamed from: b  reason: collision with root package name */
        public final KsContentPage f34999b;

        public a(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onPageLoadListener, ksContentPage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34998a = onPageLoadListener;
            this.f34999b = ksContentPage;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            KsContentPage.OnPageLoadListener onPageLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (onPageLoadListener = this.f34998a) == null) {
                return;
            }
            onPageLoadListener.onLoadError(this.f34999b);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            KsContentPage.OnPageLoadListener onPageLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (onPageLoadListener = this.f34998a) == null) {
                return;
            }
            onPageLoadListener.onLoadFinish(this.f34999b, i2);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            KsContentPage.OnPageLoadListener onPageLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || (onPageLoadListener = this.f34998a) == null) {
                return;
            }
            onPageLoadListener.onLoadStart(this.f34999b, i3);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements KsContentPage.PageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.PageListener f35000a;

        public b(KsContentPage.PageListener pageListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35000a = pageListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageEnter(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, contentItem) == null) || (pageListener = this.f35000a) == null) {
                return;
            }
            pageListener.onPageEnter(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageLeave(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentItem) == null) || (pageListener = this.f35000a) == null) {
                return;
            }
            pageListener.onPageLeave(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPagePause(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentItem) == null) || (pageListener = this.f35000a) == null) {
                return;
            }
            pageListener.onPagePause(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, contentItem) == null) || (pageListener = this.f35000a) == null) {
                return;
            }
            pageListener.onPageResume(contentItem);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements KsContentPage.VideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.VideoListener f35001a;

        public c(KsContentPage.VideoListener videoListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35001a = videoListener;
        }

        public /* synthetic */ c(KsContentPage.VideoListener videoListener, AnonymousClass1 anonymousClass1) {
            this(videoListener);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, contentItem) == null) || (videoListener = this.f35001a) == null) {
                return;
            }
            videoListener.onVideoPlayCompleted(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i2, int i3) {
            KsContentPage.VideoListener videoListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, contentItem, i2, i3) == null) || (videoListener = this.f35001a) == null) {
                return;
            }
            videoListener.onVideoPlayError(contentItem, i2, i3);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentItem) == null) || (videoListener = this.f35001a) == null) {
                return;
            }
            videoListener.onVideoPlayPaused(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, contentItem) == null) || (videoListener = this.f35001a) == null) {
                return;
            }
            videoListener.onVideoPlayResume(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, contentItem) == null) || (videoListener = this.f35001a) == null) {
                return;
            }
            videoListener.onVideoPlayStart(contentItem);
        }
    }

    public f(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34994e = new ArrayList();
        this.f34990a = ksScene;
    }

    private void a(@NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, gVar) == null) {
            KsContentPage.PageListener pageListener = this.f34992c;
            if (pageListener != null) {
                gVar.a(new b(pageListener));
            } else {
                com.kwad.sdk.core.d.a.c("KsContentPage", "mPageListener is null");
            }
            KsContentPage.VideoListener videoListener = this.f34993d;
            if (videoListener != null) {
                gVar.a(new c(videoListener, null));
            } else {
                com.kwad.sdk.core.d.a.c("KsContentPage", "mVideoListener is null");
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f34997h = str;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addPageLoadListener(KsContentPage.OnPageLoadListener onPageLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onPageLoadListener) == null) {
            a aVar = new a(onPageLoadListener, this);
            WeakReference<g> weakReference = this.f34991b;
            g gVar = weakReference != null ? weakReference.get() : null;
            if (gVar != null) {
                gVar.a(aVar);
            } else {
                this.f34995f = aVar;
            }
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            WeakReference<g> weakReference = this.f34991b;
            g gVar = weakReference != null ? weakReference.get() : null;
            if (gVar != null) {
                gVar.a(list);
            } else {
                this.f34994e.addAll(list);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    @NonNull
    public KsFragment getFragment2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g a2 = g.a(this.f34990a);
            this.f34991b = new WeakReference<>(a2);
            a(a2);
            if (!this.f34994e.isEmpty()) {
                a2.a(this.f34994e);
                this.f34994e.clear();
            }
            a aVar = this.f34995f;
            if (aVar != null) {
                a2.a(aVar);
            }
            Bundle arguments = a2.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putBoolean("KEY_INSERTAD_ENABLE", this.f34996g);
            arguments.putString("KEY_PushLINK", this.f34997h);
            return a2;
        }
        return (KsFragment) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public int getSubCountInPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SUBCOUNT");
            return a2 != null ? ((Integer) a2.getValue()).intValue() : com.kwad.sdk.core.config.c.a(this.f34990a.getPosId());
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setAddSubEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f34996g = z;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pageListener) == null) {
            this.f34992c = pageListener;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoListener) == null) {
            this.f34993d = videoListener;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void tryToRefresh() {
        WeakReference<g> weakReference;
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (weakReference = this.f34991b) == null || (gVar = weakReference.get()) == null) {
            return;
        }
        gVar.a();
    }
}
