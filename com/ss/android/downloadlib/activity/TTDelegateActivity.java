package com.ss.android.downloadlib.activity;

import android.app.Activity;
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
import c.p.a.a.a.c.k;
import c.p.a.a.a.c.t;
import c.p.a.a.a.f.c;
import c.p.a.d.b.c;
import c.p.a.d.b.f;
import c.p.a.d.b.l;
import c.p.a.d.b.n;
import c.p.a.d.c;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.ss.android.downloadlib.addownload.a.d;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c.p.a.d.i.a.a f76010d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Intent f76011a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f76012b;

    /* renamed from: c  reason: collision with root package name */
    public c.p.a.b.a.c.b f76013c;

    /* loaded from: classes10.dex */
    public class b implements c.InterfaceC1520c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f76017a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TTDelegateActivity f76018b;

        public b(TTDelegateActivity tTDelegateActivity, c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tTDelegateActivity, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76018b = tTDelegateActivity;
            this.f76017a = bVar;
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void a(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                c.d.j(this.f76017a);
                dialogInterface.dismiss();
                d.q(this.f76018b);
            }
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void b(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                e.c.a().v("market_openapp_cancel", this.f76017a);
                dialogInterface.dismiss();
                d.q(this.f76018b);
            }
        }

        @Override // c.p.a.a.a.f.c.InterfaceC1520c
        public void c(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                d.q(this.f76018b);
            }
        }
    }

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
        this.f76011a = null;
    }

    public static void a(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, strArr) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 1);
            intent.putExtra("permission_id_key", str);
            intent.putExtra("permission_content_key", strArr);
            if (l.a() != null) {
                l.a().startActivity(intent);
            }
        }
    }

    public static void b(String str, c.p.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 11);
            c2.putExtra("package_name", str);
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static Intent c(@NonNull c.p.a.b.a.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) ? new Intent(l.a(), TTDelegateActivity.class) : (Intent) invokeL.objValue;
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
            this.f76011a = getIntent();
            l.n(this);
            a();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.f76011a = intent;
            l.n(this);
            a();
        }
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            l.r().a(this, i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        DownloadInfo d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            if (!this.f76012b || this.f76013c == null || (d2 = h.b(null).d(this.f76013c.a())) == null || d2.getCurBytes() < d2.getTotalBytes() || isFinishing()) {
                return;
            }
            finish();
        }
    }

    /* loaded from: classes10.dex */
    public class a implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f76014a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76015b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TTDelegateActivity f76016c;

        public a(TTDelegateActivity tTDelegateActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tTDelegateActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76016c = tTDelegateActivity;
            this.f76015b = str;
            this.f76014a = new WeakReference<>(this.f76016c);
        }

        @Override // c.p.a.a.a.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p.a(this.f76015b);
                d.q(this.f76014a.get());
            }
        }

        @Override // c.p.a.a.a.c.t
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h.p.c(this.f76015b, str);
                d.q(this.f76014a.get());
            }
        }
    }

    private void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            long longExtra = this.f76011a.getLongExtra("model_id", 0L);
            String stringExtra = this.f76011a.getStringExtra("message_text");
            String stringExtra2 = this.f76011a.getStringExtra("positive_button_text");
            String stringExtra3 = this.f76011a.getStringExtra("negative_button_text");
            int intExtra = this.f76011a.getIntExtra("type", 0);
            c.p.a.b.a.c.b u = c.g.e().u(longExtra);
            d.c cVar = new d.c(this);
            cVar.c(false);
            cVar.b(stringExtra);
            cVar.e(stringExtra2);
            cVar.f(stringExtra3);
            if (intExtra == 7) {
                if (f.h.c() == null) {
                    return;
                }
                cVar.a(f.h.c());
                cVar.d().show();
                str = "download_percent";
            } else if (intExtra != 8) {
                str = "";
            } else if (f.g.c() == null) {
                return;
            } else {
                cVar.a(f.g.c());
                cVar.d().show();
                str = "apk_size";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f76012b = true;
            this.f76013c = u;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", str);
                jSONObject.putOpt("pause_optimise_action", "show_dialog");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("pause_optimise", jSONObject, u);
        }
    }

    public static void b(@NonNull c.p.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            a(aVar, 5, "", "", "");
        }
    }

    public static void a(String str, c.p.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 2);
            c2.putExtra("open_url", str);
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void b(@NonNull c.p.a.b.a.c.a aVar, String str, String str2, String str3) {
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
        if (!(interceptable == null || interceptable.invokeJ(65547, this, j2) == null) || n.a() == null) {
            return;
        }
        c.p.a.b.a.c.b u = c.g.e().u(j2);
        if (u != null) {
            DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(u.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - u.Q()));
                jSONObject.putOpt("click_download_size", Long.valueOf(u.R()));
                if (f2 != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(f2.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(f2.getCurBytes() / f2.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(f2.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.c.a().w("pause_reserve_wifi_dialog_show", jSONObject, u);
        }
        d.c cVar = new d.c(this);
        cVar.c(false);
        cVar.a(n.a());
        cVar.d().show();
        this.f76012b = true;
        this.f76013c = u;
    }

    public static void a(c.p.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 4);
            c2.putExtra("model_id", aVar.b());
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void a(c.p.a.b.a.c.a aVar, c.p.a.d.i.a.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, aVar2) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(268435456);
            c2.putExtra("type", 9);
            f76010d = aVar2;
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j2) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 10);
            intent.putExtra("app_info_id", j2);
            if (l.a() != null) {
                l.a().startActivity(intent);
            }
        }
    }

    private void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65555, this, j2) == null) {
            c.p.a.b.a.c.b u = c.g.e().u(j2);
            if (u == null) {
                f.e.b().d("showOpenAppDialogInner nativeModel null");
                c.p.a.e.a.d.q(this);
                return;
            }
            k p = l.p();
            c.b bVar = new c.b(this);
            bVar.e("已安装完成");
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(u.K()) ? "刚刚下载的应用" : u.K();
            bVar.h(String.format("%1$s已安装完成，是否立即打开？", objArr));
            bVar.j("打开");
            bVar.l("取消");
            bVar.f(false);
            bVar.c(h.r.E(this, u.e()));
            bVar.d(new b(this, u));
            bVar.b(2);
            p.b(bVar.g());
            e.c.a().v("market_openapp_window_show", u);
        }
    }

    private void b(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, str, strArr) == null) {
            if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
                a aVar = new a(this, str);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        l.r().a(this, strArr, aVar);
                        return;
                    } catch (Exception e2) {
                        l.F().a(e2, "requestPermission");
                        aVar.a();
                        return;
                    }
                }
                aVar.a();
                return;
            }
            c.p.a.e.a.d.q(this);
        }
    }

    public static void a(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j2), str2, jSONObject}) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 12);
            intent.putExtra("package_name", str);
            intent.putExtra("model_id", j2);
            intent.putExtra("param", str2);
            intent.putExtra("ext_json", jSONObject.toString());
            if (l.a() != null) {
                l.a().startActivity(intent);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            Intent I = h.r.I(this, str);
            if (I == null) {
                return;
            }
            try {
                try {
                    I.addFlags(268435456);
                    I.putExtra("start_only_for_android", true);
                    startActivity(I);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                c.p.a.e.a.d.q(this);
            }
        }
    }

    public static void a(@NonNull c.p.a.b.a.c.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, str, str2, str3) == null) {
            a(aVar, 8, str, str2, str3);
        }
    }

    public static void a(@NonNull c.p.a.b.a.c.a aVar, int i2, String str, String str2, String str3) {
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
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public void a() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (intent = this.f76011a) == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.f76011a.getStringExtra("permission_id_key"), this.f76011a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.f76011a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                c.p.a.e.a.d.q(this);
                break;
            case 4:
                c(this.f76011a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.f76011a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                c.p.a.d.i.a.a aVar = f76010d;
                if (aVar != null) {
                    aVar.a();
                }
                c.p.a.e.a.d.q(this);
                break;
            case 10:
                d(this.f76011a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.f76011a.getStringExtra("package_name"));
                break;
            case 12:
                h.n.h(this, this.f76011a.getStringExtra("package_name"), this.f76011a.getLongExtra("model_id", 0L), this.f76011a.getStringExtra("param"), this.f76011a.getStringExtra("ext_json"));
                c.p.a.e.a.d.q(this);
                break;
        }
        this.f76011a = null;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
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
                    if (c.p.a.e.b.j.a.r().l("fix_app_link_flag")) {
                        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    }
                    intent.putExtra("start_only_for_android", true);
                    startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                c.p.a.e.a.d.q(this);
            }
        }
    }
}
