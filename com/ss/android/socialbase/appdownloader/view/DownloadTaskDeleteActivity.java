package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.a.d;
import d.l.a.e.a.e;
import d.l.a.e.a.l;
import d.l.a.e.b.l.f;
/* loaded from: classes6.dex */
public class DownloadTaskDeleteActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.m f38378a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f38379b;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadTaskDeleteActivity f38380e;

        public a(DownloadTaskDeleteActivity downloadTaskDeleteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadTaskDeleteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38380e = downloadTaskDeleteActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f38380e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f38381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f38382f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f38383g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DownloadTaskDeleteActivity f38384h;

        public b(DownloadTaskDeleteActivity downloadTaskDeleteActivity, boolean z, DownloadInfo downloadInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadTaskDeleteActivity, Boolean.valueOf(z), downloadInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38384h = downloadTaskDeleteActivity;
            this.f38381e = z;
            this.f38382f = downloadInfo;
            this.f38383g = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (this.f38381e) {
                    this.f38384h.a(this.f38382f, this.f38383g);
                }
                this.f38384h.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f38385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f38386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f38387g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DownloadTaskDeleteActivity f38388h;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f38389e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38389e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.l.a.e.b.g.a.H(this.f38389e.f38388h).B(this.f38389e.f38386f.getId());
                }
            }
        }

        public c(DownloadTaskDeleteActivity downloadTaskDeleteActivity, boolean z, DownloadInfo downloadInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadTaskDeleteActivity, Boolean.valueOf(z), downloadInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38388h = downloadTaskDeleteActivity;
            this.f38385e = z;
            this.f38386f = downloadInfo;
            this.f38387g = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (!this.f38385e) {
                    this.f38388h.a(this.f38386f, this.f38387g);
                } else {
                    this.f38386f.setOnlyWifi(true);
                    d.l.a.e.b.g.a.H(this.f38388h).u(this.f38386f.getId());
                    new Handler(Looper.getMainLooper()).postDelayed(new a(this), 100L);
                }
                this.f38388h.finish();
            }
        }
    }

    public DownloadTaskDeleteActivity() {
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

    private void b() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f38378a == null && (intent = this.f38379b) != null) {
            try {
                boolean z = false;
                int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
                DownloadInfo f2 = d.l.a.e.b.g.a.H(getApplicationContext()).f(intExtra);
                if (f2 == null) {
                    return;
                }
                String title = f2.getTitle();
                if (TextUtils.isEmpty(title)) {
                    Log.w("DeleteActivity", "Missing appName; skipping handle");
                    return;
                }
                String format = String.format(getString(l.a(this, "tt_appdownloader_notification_download_delete")), title);
                d.e b2 = e.G().b();
                d.n a2 = b2 != null ? b2.a(this) : null;
                if (a2 == null) {
                    a2 = new e.C2037e(this);
                }
                if (a2 != null) {
                    int a3 = l.a(this, "tt_appdownloader_tip");
                    int a4 = l.a(this, "tt_appdownloader_label_ok");
                    int a5 = l.a(this, "tt_appdownloader_label_cancel");
                    if (d.l.a.e.b.j.a.d(f2.getId()).b("cancel_with_net_opt", 0) == 1 && f.T0() && f2.getCurBytes() != f2.getTotalBytes()) {
                        z = true;
                    }
                    if (z) {
                        a4 = l.a(this, "tt_appdownloader_label_reserve_wifi");
                        a5 = l.a(this, "tt_appdownloader_label_cancel_directly");
                        format = getResources().getString(l.a(this, "tt_appdownloader_resume_in_wifi"));
                    }
                    a2.a(a3).a(format).b(a4, new c(this, z, f2, intExtra)).a(a5, new b(this, z, f2, intExtra)).c(new a(this));
                    this.f38378a = a2.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            a();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            this.f38379b = getIntent();
            b();
            d.m mVar = this.f38378a;
            if (mVar != null && !mVar.b()) {
                this.f38378a.a();
            } else if (this.f38378a == null) {
                finish();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, downloadInfo, i2) == null) {
            d.f u = e.G().u();
            if (u != null) {
                u.a(downloadInfo);
            }
            d.l.a.e.b.f.d i3 = d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).i(i2);
            if (i3 != null) {
                i3.a(10, downloadInfo, "", "");
            }
            if (d.l.a.e.b.g.e.n() != null) {
                d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).b(i2);
            }
        }
    }
}
