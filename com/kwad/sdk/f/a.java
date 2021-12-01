package com.kwad.sdk.f;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdSourceLogoType;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f58424b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58425c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f58426d;

    /* renamed from: e  reason: collision with root package name */
    public b f58427e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f58428f;

    /* renamed from: g  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f58429g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2040a f58430h;

    /* renamed from: com.kwad.sdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2040a {
        void a();

        void a(View view, KsNativeAd ksNativeAd);

        void a(KsNativeAd ksNativeAd);

        boolean a(DialogInterface.OnClickListener onClickListener);

        void b();
    }

    public a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58429g = new KsNativeAd.VideoPlayListener(this) { // from class: com.kwad.sdk.f.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f58428f == null) {
                    return;
                }
                this.a.f58428f.onVideoPlayComplete();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) || this.a.f58428f == null) {
                    return;
                }
                this.a.f58428f.onVideoPlayError(i4, i5);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f58428f == null) {
                    return;
                }
                this.a.f58428f.onVideoPlayStart();
            }
        };
        this.f58430h = new InterfaceC2040a(this) { // from class: com.kwad.sdk.f.a.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.sdk.f.a.InterfaceC2040a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f58426d == null) {
                    return;
                }
                try {
                    this.a.f58426d.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.sdk.f.a.InterfaceC2040a
            public void a(View view, KsNativeAd ksNativeAd) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, ksNativeAd) == null) || this.a.f58426d == null) {
                    return;
                }
                this.a.f58426d.onAdClicked(view, this.a);
            }

            @Override // com.kwad.sdk.f.a.InterfaceC2040a
            public void a(KsNativeAd ksNativeAd) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) || this.a.f58426d == null) {
                    return;
                }
                this.a.f58426d.onAdShow(this.a);
            }

            @Override // com.kwad.sdk.f.a.InterfaceC2040a
            public boolean a(DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, onClickListener)) == null) {
                    if (this.a.f58426d != null) {
                        try {
                            return this.a.f58426d.handleDownloadDialog(onClickListener);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                            return false;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.f.a.InterfaceC2040a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.f58426d == null) {
                    return;
                }
                try {
                    this.a.f58426d.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        };
        this.a = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f58424b = j2;
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.a);
            this.f58425c = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.f58425c.a((DialogInterface.OnDismissListener) this);
            this.f58425c.a(new b.a(this) { // from class: com.kwad.sdk.f.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                @Override // com.kwad.sdk.core.download.a.b.a
                public boolean a(DialogInterface.OnClickListener onClickListener) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, onClickListener)) == null) ? this.a.f58430h.a(onClickListener) : invokeL.booleanValue;
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.c(this.f58424b), this.a);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context] */
    public void a(@Nullable Activity activity, View view, z.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, activity, view, aVar) == null) {
            if (activity == 0) {
                activity = view.getContext();
            }
            com.kwad.sdk.core.download.a.a.a(Wrapper.wrapContextIfNeed(activity), this.a, new a.b(this, aVar, view) { // from class: com.kwad.sdk.f.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f58436b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f58437c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58437c = this;
                    this.a = aVar;
                    this.f58436b = view;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.f58437c.a, this.a);
                        this.f58437c.f58430h.a(this.f58436b, this.f58437c);
                    }
                }
            }, this.f58425c, false);
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, activity, viewGroup, list) == null) {
            for (View view : list) {
                z.a aVar = new z.a();
                view.setOnTouchListener(new View.OnTouchListener(this, aVar, viewGroup) { // from class: com.kwad.sdk.f.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ z.a a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ViewGroup f58431b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f58432c;

                    /* renamed from: d  reason: collision with root package name */
                    public int[] f58433d;

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
                        this.f58432c = this;
                        this.a = aVar;
                        this.f58431b = viewGroup;
                        this.f58433d = new int[2];
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.a.a(this.f58431b.getWidth(), this.f58431b.getHeight());
                                this.f58431b.getLocationOnScreen(this.f58433d);
                                this.a.a(Math.abs(motionEvent.getRawX() - this.f58433d[0]), Math.abs(motionEvent.getRawY() - this.f58433d[1]));
                            } else if (action == 1) {
                                this.a.b(Math.abs(motionEvent.getRawX() - this.f58433d[0]), Math.abs(motionEvent.getRawY() - this.f58433d[1]));
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                view.setOnClickListener(new View.OnClickListener(this, activity, aVar) { // from class: com.kwad.sdk.f.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Activity a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ z.a f58434b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f58435c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58435c = this;
                        this.a = activity;
                        this.f58434b = aVar;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.f58435c.a(this.a, view2, this.f58434b);
                        }
                    }
                });
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup) == null) {
            com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
            if (b2 == null) {
                b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(b2);
            }
            b2.setViewCallback(new a.InterfaceC2024a(this) { // from class: com.kwad.sdk.f.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2024a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2024a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        if (!this.a.a.mPvReported) {
                            this.a.f58430h.a(this.a);
                        }
                        com.kwad.sdk.core.report.a.a(this.a.a, (JSONObject) null);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2024a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2024a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }
            });
            b2.setNeedCheckingShow(true);
        }
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, viewGroup)) == null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                    return (com.kwad.sdk.core.page.widget.a) childAt;
                }
            }
            return null;
        }
        return (com.kwad.sdk.core.page.widget.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: a */
    public com.kwad.sdk.internal.api.b getVideoCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f58424b);
            if (TextUtils.isEmpty(J.coverUrl)) {
                return null;
            }
            return new com.kwad.sdk.internal.api.b(J.width, J.height, J.coverUrl);
        }
        return (com.kwad.sdk.internal.api.b) invokeV.objValue;
    }

    @NonNull
    public AdTemplate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.A(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.s(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.z(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSourceLogoUrl(@AdSourceLogoType int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            AdInfo adInfo = this.f58424b;
            if (adInfo == null) {
                return null;
            }
            return i2 != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.a.a.w(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.response.a.a.au(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.response.a.a.t(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.response.a.a.v(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.response.a.a.am(this.f58424b) : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.response.a.a.ak(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.response.a.a.x(this.f58424b) : invokeV.floatValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.response.a.a.al(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? com.kwad.sdk.core.response.a.a.ah(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? com.kwad.sdk.core.response.a.a.F(this.f58424b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo j2 = d.j(this.a);
            int R = com.kwad.sdk.core.response.a.a.R(this.f58424b);
            if (R == 2 || R == 3) {
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : j2.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                        arrayList.add(new com.kwad.sdk.internal.api.b(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.response.a.a.E(this.f58424b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.response.a.a.R(this.f58424b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.response.a.a.ai(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? com.kwad.sdk.core.response.a.a.aj(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? com.kwad.sdk.core.response.a.a.u(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public Bitmap getSdkLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? com.kwad.sdk.core.response.a.a.b(this.f58424b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? com.kwad.sdk.core.response.a.a.J(this.f58424b).videoHeight : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? com.kwad.sdk.core.response.a.a.a(this.f58424b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, context, ksAdVideoPlayConfig)) == null) {
            if (TextUtils.isEmpty(getVideoUrl())) {
                com.kwad.sdk.core.d.a.d("KsNativeAdControl", "videoUrl is empty");
                return null;
            }
            if (this.f58427e == null) {
                b bVar = new b(context);
                this.f58427e = bVar;
                bVar.setInnerAdInteractionListener(this.f58430h);
                this.f58427e.setVideoPlayListener(this.f58429g);
                this.f58427e.a(this.a, this.f58425c, ksAdVideoPlayConfig);
            }
            return this.f58427e;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, context, z)) == null) ? getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build()) : (View) invokeLZ.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? com.kwad.sdk.core.response.a.a.J(this.f58424b).videoWidth : invokeV.intValue;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, dialogInterface) == null) {
            this.f58430h.b();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dialogInterface) == null) {
            this.f58430h.a();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048608, this, activity, viewGroup, list, adInteractionListener) == null) {
            this.f58426d = adInteractionListener;
            a(viewGroup);
            a(activity, viewGroup, list);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, viewGroup, list, adInteractionListener) == null) {
            registerViewForInteraction(null, viewGroup, list, adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i2, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.a, i2, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            com.kwad.sdk.core.report.a.j(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            com.kwad.sdk.core.report.a.i(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            AdTemplate adTemplate = this.a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.sdk.core.download.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, ksAppDownloadListener) == null) || (bVar = this.f58425c) == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, videoPlayListener) == null) {
            this.f58428f = videoPlayListener;
        }
    }
}
