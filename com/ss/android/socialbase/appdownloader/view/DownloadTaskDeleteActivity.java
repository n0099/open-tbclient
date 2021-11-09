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
/* loaded from: classes2.dex */
public class DownloadTaskDeleteActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public k f69051a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f69052b;

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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f69051a == null && (intent = this.f69052b) != null) {
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
                c a2 = d.j().a();
                l a3 = a2 != null ? a2.a(this) : null;
                if (a3 == null) {
                    a3 = new com.ss.android.socialbase.appdownloader.d.a(this);
                }
                if (a3 != null) {
                    int a4 = i.a(this, "tt_appdownloader_tip");
                    int a5 = i.a(this, "tt_appdownloader_label_ok");
                    int a6 = i.a(this, "tt_appdownloader_label_cancel");
                    if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("cancel_with_net_opt", 0) == 1 && f.h() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                        z = true;
                    }
                    if (z) {
                        a5 = i.a(this, "tt_appdownloader_label_reserve_wifi");
                        a6 = i.a(this, "tt_appdownloader_label_cancel_directly");
                        format = getResources().getString(i.a(this, "tt_appdownloader_resume_in_wifi"));
                    }
                    a3.a(a4).a(format).a(a5, new DialogInterface.OnClickListener(this, z, downloadInfo, intExtra) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ boolean f69058a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f69059b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f69060c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ DownloadTaskDeleteActivity f69061d;

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
                            this.f69061d = this;
                            this.f69058a = z;
                            this.f69059b = downloadInfo;
                            this.f69060c = intExtra;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                if (!this.f69058a) {
                                    this.f69061d.a(this.f69059b, this.f69060c);
                                } else {
                                    this.f69059b.setOnlyWifi(true);
                                    Downloader.getInstance(this.f69061d).pause(this.f69059b.getId());
                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f69062a;

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
                                            this.f69062a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                Downloader.getInstance(this.f69062a.f69061d).resume(this.f69062a.f69059b.getId());
                                            }
                                        }
                                    }, 100L);
                                }
                                this.f69061d.finish();
                            }
                        }
                    }).b(a6, new DialogInterface.OnClickListener(this, z, downloadInfo, intExtra) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ boolean f69054a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ DownloadInfo f69055b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f69056c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ DownloadTaskDeleteActivity f69057d;

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
                            this.f69057d = this;
                            this.f69054a = z;
                            this.f69055b = downloadInfo;
                            this.f69056c = intExtra;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                                if (this.f69054a) {
                                    this.f69057d.a(this.f69055b, this.f69056c);
                                }
                                this.f69057d.finish();
                            }
                        }
                    }).a(new DialogInterface.OnCancelListener(this) { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ DownloadTaskDeleteActivity f69053a;

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
                            this.f69053a = this;
                        }

                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.f69053a.finish();
                            }
                        }
                    });
                    this.f69051a = a3.a();
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
            this.f69052b = getIntent();
            b();
            k kVar = this.f69051a;
            if (kVar != null && !kVar.b()) {
                this.f69051a.a();
            } else if (this.f69051a == null) {
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
