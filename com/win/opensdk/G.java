package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class G {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f39362b;

    public G(WDownLoadService wDownLoadService, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wDownLoadService, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39362b = wDownLoadService;
        this.f39361a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new F(this));
            A.f39315d.f39318c = false;
            x0.a(this.f39362b.getApplicationContext()).a(new y0(this.f39361a), 2).a();
            Info info = this.f39361a;
            WDownLoadService wDownLoadService = this.f39362b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f39362b.getString(R.string.win_wdownload_failed_msg), 0);
            try {
                WDownLoadService.a(this.f39362b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f39362b.stopSelf();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A.f39315d.f39318c = false;
            x0.a(this.f39362b.getApplicationContext()).a(new y0(this.f39361a), 200).a();
            Info info = this.f39361a;
            try {
                z.a(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    z.g(info.getVv_downf_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            WDownLoadService.a(this.f39362b, this.f39361a);
            this.f39362b.stopSelf();
            w0 a2 = x0.a(this.f39362b.getApplicationContext());
            y0 y0Var = new y0(this.f39361a);
            String str = this.f39362b.f39567a;
            try {
                a2.f39697b = x0.a("witr", y0Var);
                a2.a("msg", x0.a(str));
            } catch (JSONException unused) {
            }
            a2.a();
            z.b(this.f39361a, this.f39362b.getApplicationContext(), this.f39362b.f39567a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            A.f39315d.f39318c = false;
            Info info = this.f39361a;
            WDownLoadService wDownLoadService = this.f39362b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f39362b.getString(R.string.win_wdownload_failed_msg), 0);
            WDownLoadService.a(this.f39362b);
            this.f39362b.stopSelf();
            x0.a(this.f39362b.getApplicationContext()).a(new y0(this.f39361a), 1).a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            A.f39315d.f39318c = true;
            Info info = this.f39361a;
            WDownLoadService wDownLoadService = this.f39362b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f39362b.getString(R.string.win_wdownload_processing), i2);
        }
    }
}
