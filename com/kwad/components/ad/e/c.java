package com.kwad.components.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.b;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdSourceLogoType;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;
    public AdInfo b;
    @Nullable
    public com.kwad.components.core.c.a.b c;
    @Nullable
    public KsNativeAd.AdInteractionListener d;
    public d e;
    @Nullable
    public KsNativeAd.VideoPlayListener f;
    public KsNativeAd.VideoPlayListener g;
    public a h;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(View view2);

        boolean a(DialogInterface.OnClickListener onClickListener);

        void b();

        void c();
    }

    public c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new KsNativeAd.VideoPlayListener(this) { // from class: com.kwad.components.ad.e.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayComplete() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f == null) {
                    return;
                }
                this.a.f.onVideoPlayComplete();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) || this.a.f == null) {
                    return;
                }
                this.a.f.onVideoPlayError(i3, i4);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayPause() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f == null) {
                    return;
                }
                try {
                    this.a.f.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayReady() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.f == null) {
                    return;
                }
                try {
                    this.a.f.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayResume() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.f == null) {
                    return;
                }
                try {
                    this.a.f.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.b(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.a.f == null) {
                    return;
                }
                this.a.f.onVideoPlayStart();
            }
        };
        this.h = new a(this) { // from class: com.kwad.components.ad.e.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.d == null) {
                    return;
                }
                this.a.d.onAdShow(this.a);
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void a(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || this.a.d == null) {
                    return;
                }
                this.a.d.onAdClicked(view2, this.a);
            }

            @Override // com.kwad.components.ad.e.c.a
            public final boolean a(DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener)) == null) {
                    if (this.a.d != null) {
                        try {
                            return this.a.d.handleDownloadDialog(onClickListener);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.b(th);
                            return false;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.d == null) {
                    return;
                }
                try {
                    this.a.d.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.d == null) {
                    return;
                }
                try {
                    this.a.d.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        };
        this.a = adTemplate;
        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(adTemplate);
        this.b = i3;
        if (com.kwad.sdk.core.response.a.a.I(i3)) {
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.a);
            this.c = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.c.a((DialogInterface.OnDismissListener) this);
            this.c.a(new b.a(this) { // from class: com.kwad.components.ad.e.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.c.a.b.a
                public final boolean a(DialogInterface.OnClickListener onClickListener) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, onClickListener)) == null) ? this.a.h.a(onClickListener) : invokeL.booleanValue;
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.e(this.b), this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: a */
    public com.kwad.components.core.internal.api.a getVideoCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature Q = com.kwad.sdk.core.response.a.a.Q(this.b);
            if (TextUtils.isEmpty(Q.coverUrl)) {
                return null;
            }
            return new com.kwad.components.core.internal.api.a(Q.width, Q.height, Q.coverUrl);
        }
        return (com.kwad.components.core.internal.api.a) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context] */
    public void a(@Nullable Activity activity, View view2, y.a aVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{activity, view2, aVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (activity == 0) {
                activity = view2.getContext();
            }
            com.kwad.components.core.c.a.a.a(new a.C0507a(Wrapper.wrapContextIfNeed(activity)).a(this.a).a(this.c).b(i).g(z).a(new a.b(this, aVar, view2) { // from class: com.kwad.components.ad.e.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ y.a a;
                public final /* synthetic */ View b;
                public final /* synthetic */ c c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = aVar;
                    this.b = view2;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.c.a, new f().a(this.a), (JSONObject) null);
                        this.c.h.a(this.b);
                    }
                }
            }));
        }
    }

    private void a(Activity activity, @NonNull ViewGroup viewGroup, int i, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, viewGroup, Integer.valueOf(i), view2, Boolean.valueOf(z)}) == null) {
            y.a aVar = new y.a();
            view2.setOnTouchListener(new View.OnTouchListener(this, aVar, viewGroup) { // from class: com.kwad.components.ad.e.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ y.a a;
                public final /* synthetic */ ViewGroup b;
                public final /* synthetic */ c c;
                public int[] d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, viewGroup};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = aVar;
                    this.b = viewGroup;
                    this.d = new int[2];
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.a.a(this.b.getWidth(), this.b.getHeight());
                            this.b.getLocationOnScreen(this.d);
                            this.a.a(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                        } else if (action == 1) {
                            this.a.b(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            view2.setOnClickListener(new View.OnClickListener(this, activity, aVar, i, z) { // from class: com.kwad.components.ad.e.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Activity a;
                public final /* synthetic */ y.a b;
                public final /* synthetic */ int c;
                public final /* synthetic */ boolean d;
                public final /* synthetic */ c e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, aVar, Integer.valueOf(i), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = activity;
                    this.b = aVar;
                    this.c = i;
                    this.d = z;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        this.e.a(this.a, view3, this.b, this.c, this.d);
                    }
                }
            });
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, activity, viewGroup, list) == null) {
            for (View view2 : list) {
                a(activity, viewGroup, 0, view2, false);
            }
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, activity, viewGroup, map) == null) {
            for (View view2 : map.keySet()) {
                a(activity, viewGroup, map.get(view2).intValue(), view2, true);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, viewGroup) == null) {
            if (!com.kwad.sdk.core.config.d.Y() && com.kwad.sdk.core.config.d.X() >= 0.0f) {
                c(viewGroup);
                com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(aVar);
                aVar.setViewCallback(new a.InterfaceC0527a(this) { // from class: com.kwad.components.ad.e.c.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.core.widget.a.InterfaceC0527a
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.a.a.mPvReported) {
                                this.a.h.a();
                            }
                            com.kwad.components.core.l.c.a().a(this.a.a, null, null);
                        }
                    }
                });
                aVar.c();
                return;
            }
            com.kwad.components.core.widget.c b = b(viewGroup);
            if (b == null) {
                b = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
                viewGroup.addView(b);
            }
            b.setViewCallback(new c.a(this) { // from class: com.kwad.components.ad.e.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.widget.c.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.a.a.mPvReported) {
                            this.a.h.a();
                        }
                        com.kwad.components.core.l.c.a().a(this.a.a, null, null);
                    }
                }
            });
            b.setNeedCheckingShow(true);
        }
    }

    public static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, viewGroup)) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.kwad.components.core.widget.c) {
                    return (com.kwad.components.core.widget.c) childAt;
                }
            }
            return null;
        }
        return (com.kwad.components.core.widget.c) invokeL.objValue;
    }

    @NonNull
    private AdTemplate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.a : (AdTemplate) invokeV.objValue;
    }

    public static void c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, viewGroup) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.kwad.components.core.widget.a) {
                    viewGroup.removeView(childAt);
                }
            }
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.a.a.H(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.z(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.G(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(@AdSourceLogoType int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            AdInfo adInfo = this.b;
            if (adInfo == null) {
                return null;
            }
            return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.D(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.response.a.a.aE(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.a.a.A(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.response.a.a.C(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(this.b) : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.response.a.a.ao(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.response.a.a.E(this.b) : invokeV.floatValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.response.a.a.al(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.response.a.a.M(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.a);
            int Y = com.kwad.sdk.core.response.a.a.Y(this.b);
            if (Y == 2 || Y == 3) {
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : i.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                        arrayList.add(new com.kwad.components.core.internal.api.a(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? com.kwad.sdk.core.response.a.a.L(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? com.kwad.sdk.core.response.a.a.Y(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.response.a.a.am(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.response.a.a.an(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.response.a.a.B(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080c2d);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? com.kwad.sdk.core.response.a.a.c(this.b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? com.kwad.sdk.core.response.a.a.Q(this.b).videoHeight : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? com.kwad.sdk.core.response.a.a.b(this.b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, context, ksAdVideoPlayConfig)) == null) {
            if (TextUtils.isEmpty(getVideoUrl())) {
                com.kwad.sdk.core.d.b.d("KsNativeAdControl", "videoUrl is empty");
                return null;
            }
            if (this.e == null) {
                d dVar = new d(context);
                this.e = dVar;
                dVar.setInnerAdInteractionListener(this.h);
                this.e.setVideoPlayListener(this.g);
                this.e.a(this.a, this.c, ksAdVideoPlayConfig);
            }
            return this.e;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, context, z)) == null) ? getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build()) : (View) invokeLZ.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? com.kwad.sdk.core.response.a.a.Q(this.b).videoWidth : invokeV.intValue;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dialogInterface) == null) {
            this.h.c();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, dialogInterface) == null) || (aVar = this.h) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048606, this, activity, viewGroup, list, adInteractionListener) == null) {
            this.d = adInteractionListener;
            a(viewGroup);
            a(activity, viewGroup, list);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048607, this, activity, viewGroup, map, adInteractionListener) == null) {
            this.d = adInteractionListener;
            a(viewGroup);
            a(activity, viewGroup, map);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, viewGroup, list, adInteractionListener) == null) {
            registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.a, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            com.kwad.sdk.core.report.a.i(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            com.kwad.sdk.core.report.a.h(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            AdTemplate adTemplate = this.a;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.l(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.c.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, ksAppDownloadListener) == null) || (bVar = this.c) == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, videoPlayListener) == null) {
            this.f = videoPlayListener;
        }
    }
}
