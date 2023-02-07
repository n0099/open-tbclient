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
import com.kwad.components.core.c.a.c;
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
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsNativeAd.VideoPlayListener jA;
    public KsNativeAd.VideoPlayListener jB;
    public a jC;
    @Nullable
    public KsNativeAd.AdInteractionListener jy;
    public d jz;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* loaded from: classes8.dex */
    public interface a {
        void en();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void i(View view2);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
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
        this.jB = new KsNativeAd.VideoPlayListener(this) { // from class: com.kwad.components.ad.e.c.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c jD;

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
                this.jD = this;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayComplete() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.jD.jA == null) {
                    return;
                }
                this.jD.jA.onVideoPlayComplete();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) || this.jD.jA == null) {
                    return;
                }
                this.jD.jA.onVideoPlayError(i3, i4);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayPause() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.jD.jA == null) {
                    return;
                }
                try {
                    this.jD.jA.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayReady() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.jD.jA == null) {
                    return;
                }
                try {
                    this.jD.jA.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayResume() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.jD.jA == null) {
                    return;
                }
                try {
                    this.jD.jA.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.jD.jA == null) {
                    return;
                }
                this.jD.jA.onVideoPlayStart();
            }
        };
        this.jC = new a(this) { // from class: com.kwad.components.ad.e.c.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c jD;

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
                this.jD = this;
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void en() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.jD.jy == null) {
                    return;
                }
                this.jD.jy.onAdShow(this.jD);
            }

            @Override // com.kwad.components.ad.e.c.a
            public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener)) == null) {
                    if (this.jD.jy != null) {
                        try {
                            return this.jD.jy.handleDownloadDialog(onClickListener);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                            return false;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void i(View view2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.jD.jy == null) {
                    return;
                }
                this.jD.jy.onAdClicked(view2, this.jD);
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void onDownloadTipsDialogDismiss() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.jD.jy == null) {
                    return;
                }
                try {
                    this.jD.jy.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.components.ad.e.c.a
            public final void onDownloadTipsDialogShow() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.jD.jy == null) {
                    return;
                }
                try {
                    this.jD.jy.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        };
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mAdInfo = bQ;
        if (com.kwad.sdk.core.response.a.a.am(bQ)) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a(this) { // from class: com.kwad.components.ad.e.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c jD;

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
                    this.jD = this;
                }

                @Override // com.kwad.components.core.c.a.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, onClickListener)) == null) ? this.jD.jC.handleDownloadDialog(onClickListener) : invokeL.booleanValue;
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.D(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context] */
    public void a(@Nullable Activity activity, View view2, aa.a aVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{activity, view2, aVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (activity == 0) {
                activity = view2.getContext();
            }
            com.kwad.components.core.c.a.a.a(new a.C0597a(Wrapper.wrapContextIfNeed(activity)).L(this.mAdTemplate).b(this.mApkDownloadHelper).af(i).aj(true).ap(z).a(new a.b(this, aVar, view2) { // from class: com.kwad.components.ad.e.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c jD;
                public final /* synthetic */ aa.a jF;
                public final /* synthetic */ View jJ;

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
                    this.jD = this;
                    this.jF = aVar;
                    this.jJ = view2;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.jD.mAdTemplate, new f().b(this.jF), (JSONObject) null);
                        this.jD.jC.i(this.jJ);
                    }
                }
            }));
        }
    }

    private void a(Activity activity, @NonNull ViewGroup viewGroup, int i, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{activity, viewGroup, Integer.valueOf(i), view2, Boolean.valueOf(z)}) == null) {
            aa.a aVar = new aa.a();
            view2.setOnTouchListener(new View.OnTouchListener(this, aVar, viewGroup) { // from class: com.kwad.components.ad.e.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewGroup hl;
                public final /* synthetic */ c jD;
                public int[] jE;
                public final /* synthetic */ aa.a jF;

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
                    this.jD = this;
                    this.jF = aVar;
                    this.hl = viewGroup;
                    this.jE = new int[2];
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.jF.q(this.hl.getWidth(), this.hl.getHeight());
                            this.hl.getLocationOnScreen(this.jE);
                            this.jF.e(Math.abs(motionEvent.getRawX() - this.jE[0]), Math.abs(motionEvent.getRawY() - this.jE[1]));
                        } else if (action == 1) {
                            this.jF.f(Math.abs(motionEvent.getRawX() - this.jE[0]), Math.abs(motionEvent.getRawY() - this.jE[1]));
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            view2.setOnClickListener(new View.OnClickListener(this, activity, aVar, i, z) { // from class: com.kwad.components.ad.e.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c jD;
                public final /* synthetic */ aa.a jF;
                public final /* synthetic */ Activity jG;
                public final /* synthetic */ int jH;
                public final /* synthetic */ boolean jI;

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
                    this.jD = this;
                    this.jG = activity;
                    this.jF = aVar;
                    this.jH = i;
                    this.jI = z;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        this.jD.a(this.jG, view3, this.jF, this.jH, this.jI);
                    }
                }
            });
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, viewGroup, list) == null) {
            for (View view2 : list) {
                a(activity, viewGroup, 0, view2, false);
            }
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, activity, viewGroup, map) == null) {
            for (View view2 : map.keySet()) {
                a(activity, viewGroup, map.get(view2).intValue(), view2, true);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, viewGroup) == null) {
            if (!com.kwad.sdk.core.config.d.sm() && com.kwad.sdk.core.config.d.sl() >= 0.0f) {
                c(viewGroup);
                com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(aVar);
                aVar.setViewCallback(new a.InterfaceC0620a(this) { // from class: com.kwad.components.ad.e.c.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c jD;

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
                        this.jD = this;
                    }

                    @Override // com.kwad.components.core.widget.a.InterfaceC0620a
                    public final void em() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.jD.mAdTemplate.mPvReported) {
                                this.jD.jC.en();
                            }
                            com.kwad.components.core.m.c.ox().a(this.jD.mAdTemplate, null, null);
                        }
                    }
                });
                aVar.pW();
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
                public final /* synthetic */ c jD;

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
                    this.jD = this;
                }

                @Override // com.kwad.components.core.widget.c.a
                public final void em() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.jD.mAdTemplate.mPvReported) {
                            this.jD.jC.en();
                        }
                        com.kwad.components.core.m.c.ox().a(this.jD.mAdTemplate, null, null);
                    }
                }
            });
            b.setNeedCheckingShow(true);
        }
    }

    public static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, viewGroup)) == null) {
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

    public static void c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, viewGroup) == null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.kwad.components.core.widget.a) {
                    viewGroup.removeView(childAt);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: el */
    public com.kwad.components.core.internal.api.b getVideoCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(this.mAdInfo);
            if (TextUtils.isEmpty(au.coverUrl)) {
                return null;
            }
            return new com.kwad.components.core.internal.api.b(au.width, au.height, au.coverUrl);
        }
        return (com.kwad.components.core.internal.api.b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.core.response.a.a.al(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.ad(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.ak(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(@AdSourceLogoType int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            AdInfo adInfo = this.mAdInfo;
            if (adInfo == null) {
                return null;
            }
            return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.response.a.a.ah(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.a.a.bn(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.response.a.a.ae(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.response.a.a.ag(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.response.a.a.aX(this.mAdInfo) : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.response.a.a.aV(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.response.a.a.ai(this.mAdInfo) : invokeV.floatValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.response.a.a.aW(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.response.a.a.aS(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            int aD = com.kwad.sdk.core.response.a.a.aD(this.mAdInfo);
            if (aD == 2 || aD == 3) {
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : bQ.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                        arrayList.add(new com.kwad.components.core.internal.api.b(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.response.a.a.aD(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.response.a.a.aT(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.response.a.a.aU(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? com.kwad.sdk.core.response.a.a.af(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080cce);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? com.kwad.sdk.core.response.a.a.B(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? com.kwad.sdk.core.response.a.a.au(this.mAdInfo).videoHeight : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? com.kwad.sdk.core.response.a.a.A(this.mAdInfo) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, context, ksAdVideoPlayConfig)) == null) {
            if (TextUtils.isEmpty(getVideoUrl())) {
                com.kwad.sdk.core.e.b.w("KsNativeAdControl", "videoUrl is empty");
                return null;
            }
            if (this.jz == null) {
                d dVar = new d(context);
                this.jz = dVar;
                dVar.setInnerAdInteractionListener(this.jC);
                this.jz.setVideoPlayListener(this.jB);
                this.jz.a(this.mAdTemplate, this.mApkDownloadHelper, ksAdVideoPlayConfig);
            }
            return this.jz;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, context, z)) == null) ? getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build()) : (View) invokeLZ.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? com.kwad.sdk.core.response.a.a.au(this.mAdInfo).videoWidth : invokeV.intValue;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, dialogInterface) == null) {
            this.jC.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, dialogInterface) == null) || (aVar = this.jC) == null) {
            return;
        }
        aVar.onDownloadTipsDialogShow();
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048607, this, activity, viewGroup, list, adInteractionListener) == null) {
            this.jy = adInteractionListener;
            a(viewGroup);
            a(activity, viewGroup, list);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048608, this, activity, viewGroup, map, adInteractionListener) == null) {
            this.jy = adInteractionListener;
            a(viewGroup);
            a(activity, viewGroup, map);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, viewGroup, list, adInteractionListener) == null) {
            registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            com.kwad.sdk.core.report.a.ax(getAdTemplate());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            com.kwad.sdk.core.report.a.aw(getAdTemplate());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.aA(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.c.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, ksAppDownloadListener) == null) || (cVar = this.mApkDownloadHelper) == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, videoPlayListener) == null) {
            this.jA = videoPlayListener;
        }
    }
}
