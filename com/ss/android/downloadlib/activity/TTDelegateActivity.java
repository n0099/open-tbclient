package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadlib.addownload.a.d;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f61160d;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61161b;

    /* renamed from: c  reason: collision with root package name */
    public b f61162c;

    public TTDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static void a(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, strArr) == null) {
            Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 1);
            intent.putExtra("permission_id_key", str);
            intent.putExtra("permission_content_key", strArr);
            if (j.getContext() != null) {
                j.getContext().startActivity(intent);
            }
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 11);
            c2.putExtra("package_name", str);
            if (j.getContext() != null) {
                j.getContext().startActivity(c2);
            }
        }
    }

    public static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) ? new Intent(j.getContext(), TTDelegateActivity.class) : (Intent) invokeL.objValue;
    }

    private void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j2) == null) {
            new com.ss.android.downloadlib.addownload.compliance.a(this, j2).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            b();
            this.a = getIntent();
            j.b(this);
            a();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.a = intent;
            j.b(this);
            a();
        }
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            j.e().a(this, i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            if (!this.f61161b || this.f61162c == null || (a = g.a((Context) null).a(this.f61162c.a())) == null || a.getCurBytes() < a.getTotalBytes() || isFinishing()) {
                return;
            }
            finish();
        }
    }

    private void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            long longExtra = this.a.getLongExtra("model_id", 0L);
            String stringExtra = this.a.getStringExtra("message_text");
            String stringExtra2 = this.a.getStringExtra("positive_button_text");
            String stringExtra3 = this.a.getStringExtra("negative_button_text");
            int intExtra = this.a.getIntExtra("type", 0);
            b d2 = f.a().d(longExtra);
            d.a c2 = new d.a(this).a(false).a(stringExtra).b(stringExtra2).c(stringExtra3);
            if (intExtra == 7) {
                if (com.ss.android.downloadlib.addownload.d.b.a() == null) {
                    return;
                }
                c2.a(com.ss.android.downloadlib.addownload.d.b.a());
                c2.a().show();
                str = "download_percent";
            } else if (intExtra != 8) {
                str = "";
            } else if (com.ss.android.downloadlib.addownload.d.a.a() == null) {
                return;
            } else {
                c2.a(com.ss.android.downloadlib.addownload.d.a.a());
                c2.a().show();
                str = "apk_size";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f61161b = true;
            this.f61162c = d2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", str);
                jSONObject.putOpt("pause_optimise_action", "show_dialog");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, d2);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            a(aVar, 5, "", "", "");
        }
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 2);
            c2.putExtra("open_url", str);
            if (j.getContext() != null) {
                j.getContext().startActivity(c2);
            }
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, aVar, str, str2, str3) == null) {
            a(aVar, 7, str, str2, str3);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
    }

    private void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65547, this, j2) == null) || l.a() == null) {
            return;
        }
        b d2 = f.a().d(j2);
        if (d2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(d2.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d2.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(d2.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, d2);
        }
        new d.a(this).a(false).a(l.a()).a().show();
        this.f61161b = true;
        this.f61162c = d2;
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 4);
            c2.putExtra("model_id", aVar.b());
            if (j.getContext() != null) {
                j.getContext().startActivity(c2);
            }
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, aVar2) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 9);
            f61160d = aVar2;
            if (j.getContext() != null) {
                j.getContext().startActivity(c2);
            }
        }
    }

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j2) == null) {
            Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 10);
            intent.putExtra("app_info_id", j2);
            if (j.getContext() != null) {
                j.getContext().startActivity(intent);
            }
        }
    }

    private void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65555, this, j2) == null) {
            b d2 = f.a().d(j2);
            if (d2 == null) {
                c.a().a("showOpenAppDialogInner nativeModel null");
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                return;
            }
            k c2 = j.c();
            b.a a = new b.a(this).a("已安装完成");
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(d2.N()) ? "刚刚下载的应用" : d2.N();
            c2.b(a.b(String.format("%1$s已安装完成，是否立即打开？", objArr)).c("打开").d("取消").a(false).a(com.ss.android.downloadlib.g.l.c(this, d2.e())).a(new b.InterfaceC2094b(this, d2) { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTDelegateActivity f61165b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, d2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61165b = this;
                    this.a = d2;
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.b.a.b(this.a);
                        dialogInterface.dismiss();
                        com.ss.android.socialbase.appdownloader.c.a((Activity) this.f61165b);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", this.a);
                        dialogInterface.dismiss();
                        com.ss.android.socialbase.appdownloader.c.a((Activity) this.f61165b);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        com.ss.android.socialbase.appdownloader.c.a((Activity) this.f61165b);
                    }
                }
            }).a(2).a());
            com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", d2);
        }
    }

    private void b(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, str, strArr) == null) {
            if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
                s sVar = new s(this, str) { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ TTDelegateActivity f61163b;

                    /* renamed from: c  reason: collision with root package name */
                    public WeakReference<Activity> f61164c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61163b = this;
                        this.a = str;
                        this.f61164c = new WeakReference<>(this.f61163b);
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.ss.android.downloadlib.g.j.a(this.a);
                            com.ss.android.socialbase.appdownloader.c.a(this.f61164c.get());
                        }
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void a(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                            com.ss.android.downloadlib.g.j.a(this.a, str2);
                            com.ss.android.socialbase.appdownloader.c.a(this.f61164c.get());
                        }
                    }
                };
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        j.e().a(this, strArr, sVar);
                        return;
                    } catch (Exception e2) {
                        j.s().a(e2, "requestPermission");
                        sVar.a();
                        return;
                    }
                }
                sVar.a();
                return;
            }
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j2), str2, jSONObject}) == null) {
            Intent intent = new Intent(j.getContext(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 12);
            intent.putExtra("package_name", str);
            intent.putExtra("model_id", j2);
            intent.putExtra("param", str2);
            intent.putExtra("ext_json", jSONObject.toString());
            if (j.getContext() != null) {
                j.getContext().startActivity(intent);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            Intent f2 = com.ss.android.downloadlib.g.l.f(this, str);
            if (f2 == null) {
                return;
            }
            try {
                try {
                    f2.addFlags(268435456);
                    f2.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                    startActivity(f2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, aVar, str, str2, str3) == null) {
            a(aVar, 8, str, str2, str3);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Integer.valueOf(i2), str, str2, str3}) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", i2);
            if (!TextUtils.isEmpty(str2)) {
                c2.putExtra("positive_button_text", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                c2.putExtra("negative_button_text", str3);
            }
            if (!TextUtils.isEmpty(str)) {
                c2.putExtra("message_text", str);
            }
            c2.putExtra("model_id", aVar.b());
            if (j.getContext() != null) {
                j.getContext().startActivity(c2);
            }
        }
    }

    public void a() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (intent = this.a) == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 4:
                c(this.a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                a aVar = f61160d;
                if (aVar != null) {
                    aVar.a();
                }
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
            case 10:
                d(this.a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.a.getStringExtra("package_name"));
                break;
            case 12:
                h.a(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("param"), this.a.getStringExtra("ext_json"));
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                break;
        }
        this.a = null;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.putExtra("open_url", str);
                    intent.addFlags(268435456);
                    if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    }
                    intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                    startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
        }
    }
}
