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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.k;
import d.l.a.a.a.c.t;
import d.l.a.a.a.f.c;
import d.l.a.d.b.a.d;
import d.l.a.d.b.c;
import d.l.a.d.b.f;
import d.l.a.d.b.l;
import d.l.a.d.b.n;
import d.l.a.d.c;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.a.d;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static d.l.a.d.i.a.a f41300d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Intent f41301a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41302b;

    /* renamed from: c  reason: collision with root package name */
    public d.l.a.b.a.c.b f41303c;

    /* loaded from: classes7.dex */
    public class b implements c.InterfaceC2044c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f41307a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TTDelegateActivity f41308b;

        public b(TTDelegateActivity tTDelegateActivity, d.l.a.b.a.c.b bVar) {
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
            this.f41308b = tTDelegateActivity;
            this.f41307a = bVar;
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void a(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                e.c.a().v("market_openapp_cancel", this.f41307a);
                dialogInterface.dismiss();
                d.q(this.f41308b);
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void b(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                c.d.j(this.f41307a);
                dialogInterface.dismiss();
                d.q(this.f41308b);
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2044c
        public void c(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                d.q(this.f41308b);
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
        this.f41301a = null;
    }

    public static void a(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, strArr) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("type", 1);
            intent.putExtra("permission_id_key", str);
            intent.putExtra("permission_content_key", strArr);
            if (l.a() != null) {
                l.a().startActivity(intent);
            }
        }
    }

    public static void b(String str, d.l.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            c2.putExtra("type", 11);
            c2.putExtra("package_name", str);
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static Intent c(@NonNull d.l.a.b.a.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) ? new Intent(l.a(), TTDelegateActivity.class) : (Intent) invokeL.objValue;
    }

    private void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j) == null) {
            new d.l.a.d.b.e.a(this, j).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            b();
            this.f41301a = getIntent();
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
            this.f41301a = intent;
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
            if (!this.f41302b || this.f41303c == null || (d2 = h.b(null).d(this.f41303c.a())) == null || d2.getCurBytes() < d2.getTotalBytes() || isFinishing()) {
                return;
            }
            finish();
        }
    }

    /* loaded from: classes7.dex */
    public class a implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Activity> f41304a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41305b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TTDelegateActivity f41306c;

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
            this.f41306c = tTDelegateActivity;
            this.f41305b = str;
            this.f41304a = new WeakReference<>(this.f41306c);
        }

        @Override // d.l.a.a.a.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p.a(this.f41305b);
                d.q(this.f41304a.get());
            }
        }

        @Override // d.l.a.a.a.c.t
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h.p.c(this.f41305b, str);
                d.q(this.f41304a.get());
            }
        }
    }

    private void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            long longExtra = this.f41301a.getLongExtra("model_id", 0L);
            String stringExtra = this.f41301a.getStringExtra("message_text");
            String stringExtra2 = this.f41301a.getStringExtra("positive_button_text");
            String stringExtra3 = this.f41301a.getStringExtra("negative_button_text");
            int intExtra = this.f41301a.getIntExtra("type", 0);
            d.l.a.b.a.c.b u = c.g.e().u(longExtra);
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
            this.f41302b = true;
            this.f41303c = u;
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

    public static void b(@NonNull d.l.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            a(aVar, 5, "", "", "");
        }
    }

    public static void a(String str, d.l.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            c2.putExtra("type", 2);
            c2.putExtra("open_url", str);
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void b(@NonNull d.l.a.b.a.c.a aVar, String str, String str2, String str3) {
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

    private void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65547, this, j) == null) || n.a() == null) {
            return;
        }
        d.l.a.b.a.c.b u = c.g.e().u(j);
        if (u != null) {
            DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(u.s());
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
        this.f41302b = true;
        this.f41303c = u;
    }

    public static void a(d.l.a.b.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            c2.putExtra("type", 4);
            c2.putExtra("model_id", aVar.b());
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void a(d.l.a.b.a.c.a aVar, d.l.a.d.i.a.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, aVar, aVar2) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            c2.putExtra("type", 9);
            f41300d = aVar2;
            if (l.a() != null) {
                l.a().startActivity(c2);
            }
        }
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("type", 10);
            intent.putExtra("app_info_id", j);
            if (l.a() != null) {
                l.a().startActivity(intent);
            }
        }
    }

    private void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65555, this, j) == null) {
            d.l.a.b.a.c.b u = c.g.e().u(j);
            if (u == null) {
                f.e.b().d("showOpenAppDialogInner nativeModel null");
                d.l.a.e.a.d.q(this);
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
            d.l.a.e.a.d.q(this);
        }
    }

    public static void a(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j), str2, jSONObject}) == null) {
            Intent intent = new Intent(l.a(), TTDelegateActivity.class);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtra("type", 12);
            intent.putExtra("package_name", str);
            intent.putExtra("model_id", j);
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
                    I.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    I.putExtra("start_only_for_android", true);
                    startActivity(I);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                d.l.a.e.a.d.q(this);
            }
        }
    }

    public static void a(@NonNull d.l.a.b.a.c.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, str, str2, str3) == null) {
            a(aVar, 8, str, str2, str3);
        }
    }

    public static void a(@NonNull d.l.a.b.a.c.a aVar, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Integer.valueOf(i2), str, str2, str3}) == null) {
            Intent c2 = c(aVar);
            c2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (intent = this.f41301a) == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.f41301a.getStringExtra("permission_id_key"), this.f41301a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.f41301a.getStringExtra("open_url"));
                break;
            case 3:
            case 6:
            default:
                d.l.a.e.a.d.q(this);
                break;
            case 4:
                c(this.f41301a.getLongExtra("model_id", 0L));
                break;
            case 5:
                b(this.f41301a.getLongExtra("model_id", 0L));
                break;
            case 7:
            case 8:
                c();
                break;
            case 9:
                d.l.a.d.i.a.a aVar = f41300d;
                if (aVar != null) {
                    aVar.a();
                }
                d.l.a.e.a.d.q(this);
                break;
            case 10:
                d(this.f41301a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.f41301a.getStringExtra("package_name"));
                break;
            case 12:
                h.n.h(this, this.f41301a.getStringExtra("package_name"), this.f41301a.getLongExtra("model_id", 0L), this.f41301a.getStringExtra("param"), this.f41301a.getStringExtra("ext_json"));
                d.l.a.e.a.d.q(this);
                break;
        }
        this.f41301a = null;
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
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    if (d.l.a.e.b.j.a.r().l("fix_app_link_flag")) {
                        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    }
                    intent.putExtra("start_only_for_android", true);
                    startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                d.l.a.e.a.d.q(this);
            }
        }
    }
}
