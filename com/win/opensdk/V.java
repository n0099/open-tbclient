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
/* loaded from: classes10.dex */
public class V {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f76916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f76917b;

    public V(WDownLoadService wDownLoadService, Info info) {
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
        this.f76917b = wDownLoadService;
        this.f76916a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new U(this));
            O.f76821d.f76824c = false;
            Z0.a(this.f76917b.getApplicationContext()).a(new a1(this.f76916a), 2).a();
            Info info = this.f76916a;
            WDownLoadService wDownLoadService = this.f76917b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f76917b.getString(R.string.win_wdownload_failed_msg), 0);
            try {
                WDownLoadService.a(this.f76917b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f76917b.stopSelf();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O.f76821d.f76824c = false;
            Z0.a(this.f76917b.getApplicationContext()).a(new a1(this.f76916a), 200).a();
            Info info = this.f76916a;
            try {
                N.a(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    N.g(info.getVv_downf_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            WDownLoadService.a(this.f76917b, this.f76916a);
            this.f76917b.stopSelf();
            Y0 a2 = Z0.a(this.f76917b.getApplicationContext());
            a1 a1Var = new a1(this.f76916a);
            String str = this.f76917b.f77009a;
            try {
                a2.f76935b = Z0.a("witr", a1Var);
                a2.a("msg", Z0.a(str));
            } catch (JSONException unused) {
            }
            a2.a();
            N.b(this.f76916a, this.f76917b.getApplicationContext(), this.f76917b.f77009a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            O.f76821d.f76824c = false;
            Info info = this.f76916a;
            WDownLoadService wDownLoadService = this.f76917b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f76917b.getString(R.string.win_wdownload_failed_msg), 0);
            WDownLoadService.a(this.f76917b);
            this.f76917b.stopSelf();
            Z0.a(this.f76917b.getApplicationContext()).a(new a1(this.f76916a), 1).a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            O.f76821d.f76824c = true;
            Info info = this.f76916a;
            WDownLoadService wDownLoadService = this.f76917b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f76917b.getString(R.string.win_wdownload_processing), i2);
        }
    }
}
