package d.a.q0.f.i.k.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.f.i.c;
import d.a.q0.f.i.g;
import d.a.q0.f.i.k.f.f;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52680a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f52681b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.f.i.k.g.a f52682c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.f.i.k.f.a f52683d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f52684e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52684e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || d.a.q0.f.i.m.a.b() == null) {
                return;
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.NOT_START || this.f52684e.f52682c.f52677a == DownloadState.DELETED) {
                d.a.q0.f.i.m.a.b().b(this.f52684e.f52680a, ((DownloadParams) this.f52684e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f52684e.f52683d);
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.DOWNLOADING) {
                d.a.q0.f.i.m.a.b().b(this.f52684e.f52680a, ((DownloadParams) this.f52684e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f52684e.f52683d);
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.DOWNLOAD_PAUSED) {
                d.a.q0.f.i.m.a.b().b(this.f52684e.f52680a, ((DownloadParams) this.f52684e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f52684e.f52683d);
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.DOWNLOAD_FAILED) {
                d.a.q0.f.i.m.a.b().b(this.f52684e.f52680a, ((DownloadParams) this.f52684e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f52684e.f52683d);
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.DOWNLOADED) {
                this.f52684e.f52683d.b();
                d.a.q0.f.i.m.a.b().b(this.f52684e.f52680a, ((DownloadParams) this.f52684e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.f52684e.f52683d);
            }
            if (this.f52684e.f52682c.f52677a == DownloadState.INSTALLED) {
                String e2 = this.f52684e.f52683d.e();
                if (TextUtils.isEmpty(this.f52684e.f52682c.f52678b) && !TextUtils.isEmpty(e2)) {
                    this.f52684e.a(e2);
                }
                b bVar = this.f52684e;
                bVar.r(bVar.f52682c.f52678b);
            }
        }
    }

    /* renamed from: d.a.q0.f.i.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1100b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52685a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1637691807, "Ld/a/q0/f/i/k/g/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1637691807, "Ld/a/q0/f/i/k/g/b$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f52685a = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52685a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52685a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52685a[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52685a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52685a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

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
            }
        }
    }

    public static float m(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.AD_TEXT_ID, null, f2)) == null) {
            DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
            return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
        }
        return invokeF.floatValue;
    }

    @Override // d.a.q0.f.i.k.f.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f52682c.f52678b = str;
        }
    }

    @Override // d.a.q0.f.i.k.f.f
    public void b(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadState) == null) {
            v(downloadState);
        }
    }

    @Override // d.a.q0.f.i.k.f.f
    public /* bridge */ /* synthetic */ f c(Context context, DownloadParams downloadParams, d.a.q0.f.i.k.f.a aVar) {
        l(context, downloadParams, aVar);
        return this;
    }

    @Override // d.a.q0.f.i.k.f.f
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            t(i2);
        }
    }

    @Override // d.a.q0.f.i.k.f.f
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f52681b.setTag(obj);
        }
    }

    @Override // d.a.q0.f.i.k.f.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u(this.f52681b);
        }
    }

    @Override // d.a.q0.f.i.k.f.f
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52681b : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f52681b = new SwanAdDownloadButtonView(this.f52680a);
            String string = this.f52680a.getResources().getString(g.swanapp_ad_download_button);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (this.f52680a.getResources().getDisplayMetrics().heightPixels * 0.04d);
            this.f52681b.setLayoutParams(layoutParams);
            float n = n(this.f52680a, c.swan_ad_round_text_size);
            int color = this.f52680a.getResources().getColor(d.a.q0.f.i.b.swanapp_ad_download_button_color);
            u(this.f52681b);
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f52681b;
            swanAdDownloadButtonView.j(m(n));
            swanAdDownloadButtonView.f(true);
            swanAdDownloadButtonView.i(-1);
            swanAdDownloadButtonView.h(color);
            swanAdDownloadButtonView.g(true);
            this.f52681b.setText(string);
            this.f52681b.setVisibility(0);
            this.f52681b.setProgress(this.f52682c.f52679c);
        }
    }

    public b l(Context context, DownloadParams downloadParams, d.a.q0.f.i.k.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, downloadParams, aVar)) == null) {
            this.f52680a = context;
            this.f52682c = d.a.q0.f.i.k.g.a.a(downloadParams.f11745a, downloadParams.f11746b);
            this.f52683d = aVar;
            k();
            q();
            return this;
        }
        return (b) invokeLLL.objValue;
    }

    public final float n(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, context, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i2, typedValue, true);
            return typedValue.getFloat();
        }
        return invokeLI.floatValue;
    }

    public final ResolveInfo o(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                return queryIntentActivities.iterator().next();
            }
            return null;
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public Object p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f52681b.getTag() : invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f52681b.setOnClickListener(new a(this));
        }
    }

    public final void r(String str) {
        ResolveInfo o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str) || (o = o(this.f52680a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            this.f52680a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadState)) == null) {
            switch (C1100b.f52685a[downloadState.ordinal()]) {
                case 1:
                    return g.swanapp_ad_download_button;
                case 2:
                    return g.swanapp_ad_download_button_pause;
                case 3:
                    return g.swanapp_ad_download_button_continue;
                case 4:
                    return g.swanapp_ad_download_button_install;
                case 5:
                    return g.swanapp_ad_download_button_failed_retry;
                case 6:
                    return g.swanapp_ad_download_button_open;
                default:
                    return g.swanapp_ad_download_button;
            }
        }
        return invokeL.intValue;
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            d.a.q0.f.i.k.g.a aVar = this.f52682c;
            if (i2 != aVar.f52679c) {
                aVar.f52679c = i2;
                w();
            }
        }
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || view == null) {
            return;
        }
        float n = n(this.f52680a, c.swan_ad_round_width_size);
        float n2 = n(this.f52680a, c.swan_ad_round_height_size);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        if (n >= 0.0f && n <= 1.0f) {
            n *= this.f52680a.getResources().getDisplayMetrics().widthPixels;
        }
        if (n2 > 0.0f && n2 <= 1.0f) {
            n2 *= this.f52680a.getResources().getDisplayMetrics().heightPixels;
        }
        layoutParams.width = (int) n;
        layoutParams.height = (int) n2;
    }

    public final void v(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadState) == null) {
            d.a.q0.f.i.k.g.a aVar = this.f52682c;
            if (downloadState != aVar.f52677a) {
                aVar.f52677a = downloadState;
                w();
            }
        }
    }

    public final void w() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.q0.f.i.k.g.a aVar = this.f52682c;
            if (aVar.f52677a == DownloadState.DOWNLOADING) {
                SwanAdDownloadButtonView swanAdDownloadButtonView = this.f52681b;
                if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                    if (this.f52682c.f52679c < this.f52681b.getMax()) {
                        String string2 = this.f52680a.getResources().getString(g.swanapp_ad_button_downloading);
                        string = String.format(string2, this.f52682c.f52679c + "%");
                    } else {
                        string = this.f52680a.getResources().getString(g.swanapp_ad_download_button_install);
                    }
                    this.f52681b.setText(string);
                    this.f52681b.setProgress(this.f52682c.f52679c);
                }
            } else {
                if (d.a.q0.f.i.r.g.a(this.f52680a, aVar.f52678b)) {
                    this.f52682c.f52677a = DownloadState.INSTALLED;
                }
                String string3 = this.f52680a.getResources().getString(s(this.f52682c.f52677a));
                if (this.f52682c.f52677a == DownloadState.DOWNLOADED) {
                    this.f52681b.setProgress(100);
                }
                d.a.q0.f.i.k.g.a aVar2 = this.f52682c;
                if (aVar2.f52677a == DownloadState.DOWNLOAD_PAUSED) {
                    this.f52681b.setProgress(aVar2.f52679c);
                }
                this.f52681b.setText(string3);
            }
            SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f52681b;
            if (swanAdDownloadButtonView2 != null) {
                swanAdDownloadButtonView2.postInvalidate();
            }
        }
    }
}
