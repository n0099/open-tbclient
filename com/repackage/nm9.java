package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class nm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;
    public final /* synthetic */ WDownLoadService b;

    public nm9(WDownLoadService wDownLoadService, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wDownLoadService, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = wDownLoadService;
        this.a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new km9(this));
            ol9.d.c = false;
            nn9 a = rn9.a(this.b.getApplicationContext());
            a.p(new vn9(this.a), 2);
            a.m();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15a9), this.b.getString(R.string.obfuscated_res_0x7f0f15aa), 0);
            try {
                WDownLoadService.a(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b.stopSelf();
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            ol9.d.c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15ad), this.b.getString(R.string.obfuscated_res_0x7f0f15ad), i);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ol9.d.c = false;
            nn9 a = rn9.a(this.b.getApplicationContext());
            a.p(new vn9(this.a), 200);
            a.m();
            Info info = this.a;
            try {
                ll9.o(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    ll9.K(info.getVv_downf_urls());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            WDownLoadService.a(this.b, this.a);
            this.b.stopSelf();
            nn9 a2 = rn9.a(this.b.getApplicationContext());
            vn9 vn9Var = new vn9(this.a);
            String str = this.b.a;
            try {
                a2.b = rn9.d("witr", vn9Var);
                a2.l("msg", rn9.b(str));
            } catch (JSONException unused) {
            }
            a2.m();
            ll9.z(this.a, this.b.getApplicationContext(), this.b.a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ol9.d.c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15a9), this.b.getString(R.string.obfuscated_res_0x7f0f15aa), 0);
            WDownLoadService.a(this.b);
            this.b.stopSelf();
            nn9 a = rn9.a(this.b.getApplicationContext());
            a.p(new vn9(this.a), 1);
            a.m();
        }
    }
}
