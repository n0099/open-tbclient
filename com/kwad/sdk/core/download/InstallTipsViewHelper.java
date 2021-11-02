package com.kwad.sdk.core.download;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class InstallTipsViewHelper implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdInfo f64421a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f64422b;

    /* renamed from: c  reason: collision with root package name */
    public InstallTipsData f64423c;

    /* renamed from: d  reason: collision with root package name */
    public View f64424d;

    /* renamed from: e  reason: collision with root package name */
    public View f64425e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f64426f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64427g;

    /* renamed from: h  reason: collision with root package name */
    public Button f64428h;

    /* renamed from: i  reason: collision with root package name */
    public int f64429i;
    public long j;
    public Context k;

    /* loaded from: classes2.dex */
    public static class InstallTipsData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ACTION_INSTALL = 1;
        public static final int ACTION_LAUNCH_APP = 2;
        public static int MAX_APP_NAME_LENGTH = 8;
        public static final long serialVersionUID = 5637398311569371631L;
        public transient /* synthetic */ FieldHolder $fh;
        public int clickAction;
        public String displayContent;
        public String downloadId;
        public String iconUrl;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2020083982, "Lcom/kwad/sdk/core/download/InstallTipsViewHelper$InstallTipsData;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2020083982, "Lcom/kwad/sdk/core/download/InstallTipsViewHelper$InstallTipsData;");
            }
        }

        public InstallTipsData(Context context, int i2, AdTemplate adTemplate, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), adTemplate, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.clickAction = 1;
            this.clickAction = i2;
            this.iconUrl = com.kwad.sdk.core.response.b.c.m(adTemplate);
            this.downloadId = com.kwad.sdk.core.response.b.c.i(adTemplate).downloadId;
            String o = com.kwad.sdk.core.response.b.a.o(com.kwad.sdk.core.response.b.c.i(adTemplate));
            if (o.length() >= MAX_APP_NAME_LENGTH) {
                o = o.substring(0, MAX_APP_NAME_LENGTH - 1) + "...";
            }
            this.displayContent = context.getString(i3, o);
        }

        public static InstallTipsData newInstallInstance(Context context, AdTemplate adTemplate) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, adTemplate)) == null) ? new InstallTipsData(context, 1, adTemplate, R.string.ksad_install_tips) : (InstallTipsData) invokeLL.objValue;
        }

        public static InstallTipsData newLaunchInstance(Context context, AdTemplate adTemplate) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, adTemplate)) == null) ? new InstallTipsData(context, 2, adTemplate, R.string.ksad_launch_tips) : (InstallTipsData) invokeLL.objValue;
        }

        public int getClickAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.clickAction : invokeV.intValue;
        }

        public String getClickButtonText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.clickAction == 2 ? "打开" : "安装" : (String) invokeV.objValue;
        }

        public String getDisplayContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.displayContent : (String) invokeV.objValue;
        }

        public String getDownloadId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.downloadId : (String) invokeV.objValue;
        }

        public String getIconUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
        }
    }

    public InstallTipsViewHelper(boolean z, AdInfo adInfo, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), adInfo, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64429i = -1;
        this.j = 10000L;
        Context wrapContextIfNeed = Wrapper.wrapContextIfNeed(KsAdSDKImpl.get().getContext());
        this.k = wrapContextIfNeed;
        if (wrapContextIfNeed == null) {
            return;
        }
        this.f64421a = adInfo;
        this.f64422b = adTemplate;
        this.f64423c = z ? InstallTipsData.newInstallInstance(wrapContextIfNeed, adTemplate) : InstallTipsData.newLaunchInstance(wrapContextIfNeed, adTemplate);
        View inflate = LayoutInflater.from(this.k).inflate(R.layout.ksad_install_tips, (ViewGroup) null, false);
        this.f64424d = inflate;
        a(this.k, inflate);
        InstallTipsData installTipsData = this.f64423c;
        if (installTipsData != null) {
            a(this.k, installTipsData);
        }
    }

    @Nullable
    private Animator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view)) == null) {
            int i2 = this.f64429i;
            if (i2 < 0) {
                return null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, i2, 0.0f);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
            ofFloat.setDuration(260L);
            return ofFloat;
        }
        return (Animator) invokeL.objValue;
    }

    private Animator a(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, view, i2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, 0.0f, i2);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
            ofFloat.setDuration(300L);
            return ofFloat;
        }
        return (Animator) invokeLI.objValue;
    }

    private void a(Context context, View view) {
        String clickButtonText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, view) == null) {
            ViewCompat.setElevation(view, context.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
            this.f64425e = view.findViewById(R.id.ksad_install_tips_close);
            this.f64426f = (ImageView) view.findViewById(R.id.ksad_install_tips_icon);
            this.f64427g = (TextView) view.findViewById(R.id.ksad_install_tips_content);
            this.f64428h = (Button) view.findViewById(R.id.ksad_install_tips_install);
            InstallTipsData installTipsData = this.f64423c;
            if (installTipsData != null && (clickButtonText = installTipsData.getClickButtonText()) != null) {
                this.f64428h.setText(clickButtonText);
            }
            this.f64425e.setOnClickListener(this);
            this.f64428h.setOnClickListener(this);
        }
    }

    private void a(Context context, InstallTipsData installTipsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, installTipsData) == null) {
            if (installTipsData.getIconUrl() != null) {
                KSImageLoader.loadAppIcon(this.f64426f, com.kwad.sdk.core.response.b.a.n(this.f64421a), this.f64422b, 8);
            }
            this.f64427g.setText(installTipsData.getDisplayContent());
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            String str = this.f64421a.downloadFilePath;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.report.a.h(this.f64422b);
                KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.e("InstallTipsViewHelper", "openApp fail appContext:" + context + "--filePath:" + str);
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.k == null) {
                return false;
            }
            String q = com.kwad.sdk.core.response.b.a.q(this.f64421a);
            if (TextUtils.isEmpty(q)) {
                return false;
            }
            return ac.c(this.k, q);
        }
        return invokeV.booleanValue;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64424d : (View) invokeV.objValue;
    }

    public void a(FrameLayout frameLayout) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) || (a2 = a()) == null || this.k == null || a2.getParent() != null) {
            return;
        }
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        int i2 = dimensionPixelSize + dimensionPixelSize2;
        int i3 = -i2;
        this.f64429i = i2 + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = i3;
        frameLayout.addView(a2, layoutParams2);
        a(a2, this.f64429i).start();
        a2.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.core.download.InstallTipsViewHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ InstallTipsViewHelper f64430a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64430a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f64430a.b();
                }
            }
        }, this.j);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || a() == null || a().getParent() == null) {
            return;
        }
        View a2 = a();
        ViewGroup viewGroup = (ViewGroup) a2.getParent();
        Animator a3 = a(a2);
        if (a3 == null) {
            viewGroup.removeView(a2);
            return;
        }
        a3.start();
        a3.addListener(new Animator.AnimatorListener(this, viewGroup, a2, a3) { // from class: com.kwad.sdk.core.download.InstallTipsViewHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f64431a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f64432b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Animator f64433c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ InstallTipsViewHelper f64434d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, viewGroup, a2, a3};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64434d = this;
                this.f64431a = viewGroup;
                this.f64432b = a2;
                this.f64433c = a3;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f64431a.removeView(this.f64432b);
                    this.f64433c.removeListener(this);
                    f.a().a(this.f64434d);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }
        });
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64424d = null;
            this.f64425e = null;
            this.f64426f = null;
            this.f64428h = null;
            this.f64429i = -1;
            this.f64422b = null;
            this.f64423c = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            InstallTipsData installTipsData = this.f64423c;
            int clickAction = installTipsData != null ? installTipsData.getClickAction() : 1;
            int id = view.getId();
            if (id == R.id.ksad_install_tips_install) {
                b();
                if (clickAction == 1) {
                    d();
                    com.kwad.sdk.core.report.a.d(this.f64422b, 45);
                } else if (clickAction != 2) {
                    return;
                }
                e();
                adTemplate = this.f64422b;
                i2 = 47;
            } else if (id != R.id.ksad_install_tips_close) {
                return;
            } else {
                b();
                if (clickAction == 1) {
                    com.kwad.sdk.core.report.a.d(this.f64422b, 46);
                } else if (clickAction != 2) {
                    return;
                }
                adTemplate = this.f64422b;
                i2 = 48;
            }
            com.kwad.sdk.core.report.a.c(adTemplate, i2);
        }
    }
}
