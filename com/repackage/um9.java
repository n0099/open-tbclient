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
/* loaded from: classes7.dex */
public class um9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;
    public final /* synthetic */ WDownLoadService b;

    public um9(WDownLoadService wDownLoadService, Info info) {
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
            new Handler(Looper.getMainLooper()).post(new rm9(this));
            vl9.d.c = false;
            un9 a = yn9.a(this.b.getApplicationContext());
            a.p(new co9(this.a), 2);
            a.m();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15b2), this.b.getString(R.string.obfuscated_res_0x7f0f15b3), 0);
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
            vl9.d.c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15b6), this.b.getString(R.string.obfuscated_res_0x7f0f15b6), i);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vl9.d.c = false;
            un9 a = yn9.a(this.b.getApplicationContext());
            a.p(new co9(this.a), 200);
            a.m();
            Info info = this.a;
            try {
                sl9.o(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    sl9.K(info.getVv_downf_urls());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            WDownLoadService.a(this.b, this.a);
            this.b.stopSelf();
            un9 a2 = yn9.a(this.b.getApplicationContext());
            co9 co9Var = new co9(this.a);
            String str = this.b.a;
            try {
                a2.b = yn9.d("witr", co9Var);
                a2.l("msg", yn9.b(str));
            } catch (JSONException unused) {
            }
            a2.m();
            sl9.z(this.a, this.b.getApplicationContext(), this.b.a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vl9.d.c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f15b2), this.b.getString(R.string.obfuscated_res_0x7f0f15b3), 0);
            WDownLoadService.a(this.b);
            this.b.stopSelf();
            un9 a = yn9.a(this.b.getApplicationContext());
            a.p(new co9(this.a), 1);
            a.m();
        }
    }
}
