package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public class DownloadTaskDeleteActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f62164b;

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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.a == null && (intent = this.f62164b) != null) {
            try {
                boolean z = false;
                int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
                DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
                if (downloadInfo == null) {
                    return;
                }
                String title = downloadInfo.getTitle();
                if (TextUtils.isEmpty(title)) {
                    return;
                }
                String format = String.format(getString(i.a(this, "tt_appdownloader_notification_download_delete")), title);
                c a = d.j().a();
                l a2 = a != null ? a.a(this) : null;
                if (a2 == null) {
                    a2 = new com.ss.android.socialbase.appdownloader.d.a(this);
                }
                if (a2 != null) {
                    int a3 = i.a(this, "tt_appdownloader_tip");
                    int a4 = i.a(this, "tt_appdownloader_label_ok");
                    int a5 = i.a(this, "tt_appdownloader_label_cancel");
                    if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("cancel_with_net_opt", 0) == 1 && f.h() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                        z = true;
                    }
                    if (z) {
                        a4 = i.a(this, "tt_appdownloader_label_reserve_wifi");
                        a5 = i.a(this, "tt_appdownloader_label_cancel_directly");
                        format = getResources().getString(i.a(this, "tt_appdownloader_resume_in_wifi"));
                    }
                    a2.a(a3).a(format).a(a4, new DialogInterface.OnClickListener(this, z, downloadInfo, intExtra) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ boolean a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f62168b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f62169c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ DownloadTaskDeleteActivity f62170d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z), downloadInfo, Integer.valueOf(intExtra)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f62170d = this;
                            this.a = z;
                            this.f62168b = downloadInfo;
                            this.f62169c = intExtra;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                if (!this.a) {
                                    this.f62170d.a(this.f62168b, this.f62169c);
                                } else {
                                    this.f62168b.setOnlyWifi(true);
                                    Downloader.getInstance(this.f62170d).pause(this.f62168b.getId());
                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 a;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                Downloader.getInstance(this.a.f62170d).resume(this.a.f62168b.getId());
                                            }
                                        }
                                    }, 100L);
                                }
                                this.f62170d.finish();
                            }
                        }
                    }).b(a5, new DialogInterface.OnClickListener(this, z, downloadInfo, intExtra) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ boolean a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f62165b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f62166c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ DownloadTaskDeleteActivity f62167d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z), downloadInfo, Integer.valueOf(intExtra)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f62167d = this;
                            this.a = z;
                            this.f62165b = downloadInfo;
                            this.f62166c = intExtra;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                if (this.a) {
                                    this.f62167d.a(this.f62165b, this.f62166c);
                                }
                                this.f62167d.finish();
                            }
                        }
                    }).a(new DialogInterface.OnCancelListener(this) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DownloadTaskDeleteActivity a;

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

                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.a.finish();
                            }
                        }
                    });
                    this.a = a2.a();
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
            this.f62164b = getIntent();
            b();
            k kVar = this.a;
            if (kVar != null && !kVar.b()) {
                this.a.a();
            } else if (this.a == null) {
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
            com.ss.android.socialbase.appdownloader.c.d b2 = d.j().b();
            if (b2 != null) {
                b2.a(downloadInfo);
            }
            z downloadNotificationEventListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadNotificationEventListener(i2);
            if (downloadNotificationEventListener != null) {
                downloadNotificationEventListener.a(10, downloadInfo, "", "");
            }
            if (com.ss.android.socialbase.downloader.downloader.c.N() != null) {
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(i2);
            }
        }
    }
}
