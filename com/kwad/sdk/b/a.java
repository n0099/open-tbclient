package com.kwad.sdk.b;

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
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends AbstractKsNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33872a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33873b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33874c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f33875d;

    /* renamed from: e  reason: collision with root package name */
    public b f33876e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f33877f;

    /* renamed from: g  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f33878g;

    /* renamed from: h  reason: collision with root package name */
    public C0402a f33879h;

    /* renamed from: com.kwad.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0402a implements KsNativeAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0402a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onClickListener)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, ksNativeAd) == null) {
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) {
            }
        }
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
        this.f33878g = new KsNativeAd.VideoPlayListener(this) { // from class: com.kwad.sdk.b.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f33891a;

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
                this.f33891a = this;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f33891a.f33877f == null) {
                    return;
                }
                this.f33891a.f33877f.onVideoPlayComplete();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) || this.f33891a.f33877f == null) {
                    return;
                }
                this.f33891a.f33877f.onVideoPlayError(i4, i5);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f33891a.f33877f == null) {
                    return;
                }
                this.f33891a.f33877f.onVideoPlayStart();
            }
        };
        this.f33879h = new C0402a(this) { // from class: com.kwad.sdk.b.a.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f33892a;

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
                this.f33892a = this;
            }

            @Override // com.kwad.sdk.b.a.C0402a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, onClickListener)) == null) {
                    if (this.f33892a.f33875d != null) {
                        try {
                            return this.f33892a.f33875d.handleDownloadDialog(onClickListener);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                            return false;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.kwad.sdk.b.a.C0402a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, ksNativeAd) == null) || this.f33892a.f33875d == null) {
                    return;
                }
                this.f33892a.f33875d.onAdClicked(view, this.f33892a);
            }

            @Override // com.kwad.sdk.b.a.C0402a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksNativeAd) == null) || this.f33892a.f33875d == null) {
                    return;
                }
                this.f33892a.f33875d.onAdShow(this.f33892a);
            }
        };
        this.f33872a = adTemplate;
        AdInfo i4 = c.i(adTemplate);
        this.f33873b = i4;
        if (com.kwad.sdk.core.response.b.a.v(i4)) {
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f33872a);
            this.f33874c = bVar;
            bVar.a(new b.a(this) { // from class: com.kwad.sdk.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f33880a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f33880a = this;
                }

                @Override // com.kwad.sdk.core.download.b.b.a
                public boolean a(DialogInterface.OnClickListener onClickListener) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, onClickListener)) == null) ? this.f33880a.f33879h.handleDownloadDialog(onClickListener) : invokeL.booleanValue;
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.c(this.f33873b), this.f33872a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, v.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, view, aVar) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33872a, new a.InterfaceC0413a(this, aVar, view) { // from class: com.kwad.sdk.b.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ v.a f33887a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f33888b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f33889c;

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
                    this.f33889c = this;
                    this.f33887a = aVar;
                    this.f33888b = view;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0413a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.f33889c.f33872a, this.f33887a);
                        if (this.f33889c.f33875d != null) {
                            this.f33889c.f33875d.onAdClicked(this.f33888b, this.f33889c);
                        }
                    }
                }
            }, this.f33874c, false);
        }
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, viewGroup) == null) {
            com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
            if (b2 == null) {
                b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
                viewGroup.addView(b2);
            }
            b2.setViewCallback(new a.InterfaceC0420a(this) { // from class: com.kwad.sdk.b.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f33890a;

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
                    this.f33890a = this;
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0420a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0420a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        if (!this.f33890a.f33872a.mPvReported && this.f33890a.f33875d != null) {
                            this.f33890a.f33875d.onAdShow(this.f33890a);
                        }
                        com.kwad.sdk.core.report.a.a(this.f33890a.f33872a, (JSONObject) null);
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0420a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    }
                }

                @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0420a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }
            });
            b2.setNeedCheckingShow(true);
        }
    }

    private void a(@NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup, list) == null) {
            for (View view : list) {
                v.a aVar = new v.a();
                view.setOnTouchListener(new View.OnTouchListener(this, aVar, viewGroup) { // from class: com.kwad.sdk.b.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ v.a f33881a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ViewGroup f33882b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f33883c;

                    /* renamed from: d  reason: collision with root package name */
                    public int[] f33884d;

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
                        this.f33883c = this;
                        this.f33881a = aVar;
                        this.f33882b = viewGroup;
                        this.f33884d = new int[2];
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.f33881a.a(this.f33882b.getWidth(), this.f33882b.getHeight());
                                this.f33882b.getLocationOnScreen(this.f33884d);
                                this.f33881a.a(Math.abs(motionEvent.getRawX() - this.f33884d[0]), Math.abs(motionEvent.getRawY() - this.f33884d[1]));
                            } else if (action == 1) {
                                this.f33881a.b(Math.abs(motionEvent.getRawX() - this.f33884d[0]), Math.abs(motionEvent.getRawY() - this.f33884d[1]));
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                view.setOnClickListener(new View.OnClickListener(this, aVar) { // from class: com.kwad.sdk.b.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ v.a f33885a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f33886b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f33886b = this;
                        this.f33885a = aVar;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.f33886b.a(view2, this.f33885a);
                        }
                    }
                });
            }
        }
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, viewGroup)) == null) {
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
    public com.kwad.sdk.internal.api.a getVideoCoverImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f33873b);
            if (TextUtils.isEmpty(C.coverUrl)) {
                return null;
            }
            return new com.kwad.sdk.internal.api.a(C.width, C.height, C.coverUrl);
        }
        return (com.kwad.sdk.internal.api.a) invokeV.objValue;
    }

    @NonNull
    public AdTemplate b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33872a : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.u(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.m(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.b.a.t(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.response.b.a.r(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.sdk.core.response.b.a.n(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? com.kwad.sdk.core.response.b.a.o(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.sdk.core.response.b.a.q(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.kwad.sdk.core.response.b.a.ac(this.f33873b) : invokeV.longValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.response.b.a.aa(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? com.kwad.sdk.core.response.b.a.s(this.f33873b) : invokeV.floatValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? com.kwad.sdk.core.response.b.a.ab(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? com.kwad.sdk.core.response.b.a.Y(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f33873b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo i2 = c.i(this.f33872a);
            int H = com.kwad.sdk.core.response.b.a.H(this.f33873b);
            if (H == 2 || H == 3) {
                for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : i2.adMaterialInfo.materialFeatureList) {
                    if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                        arrayList.add(new com.kwad.sdk.internal.api.a(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f33873b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f33873b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? com.kwad.sdk.core.response.b.a.Z(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.kwad.sdk.core.response.b.a.p(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @NonNull
    public Bitmap getSdkLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? com.kwad.sdk.core.response.b.a.b(this.f33873b) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? com.kwad.sdk.core.response.b.a.C(this.f33873b).videoHeight : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? com.kwad.sdk.core.response.b.a.a(this.f33873b) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, context, ksAdVideoPlayConfig)) == null) {
            if (TextUtils.isEmpty(getVideoUrl())) {
                com.kwad.sdk.core.d.a.d("KsNativeAdControl", "videoUrl is empty");
                return null;
            }
            if (this.f33876e == null) {
                b bVar = new b(context);
                this.f33876e = bVar;
                bVar.setAdInteractionListener(this.f33879h);
                this.f33876e.setVideoPlayListener(this.f33878g);
                this.f33876e.a(this.f33872a, this.f33874c, ksAdVideoPlayConfig);
            }
            return this.f33876e;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, context, z)) == null) ? getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build()) : (View) invokeLZ.objValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? com.kwad.sdk.core.response.b.a.C(this.f33873b).videoWidth : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, viewGroup, list, adInteractionListener) == null) {
            this.f33875d = adInteractionListener;
            a(viewGroup);
            a(viewGroup, list);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            com.kwad.sdk.core.report.a.j(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            com.kwad.sdk.core.report.a.i(b());
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            AdTemplate adTemplate = this.f33872a;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.sdk.core.download.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, ksAppDownloadListener) == null) || (bVar = this.f33874c) == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, videoPlayListener) == null) {
            this.f33877f = videoPlayListener;
        }
    }
}
