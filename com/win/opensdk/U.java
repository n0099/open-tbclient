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
/* loaded from: classes8.dex */
public class U {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;
    public final /* synthetic */ WDownLoadService b;

    public U(WDownLoadService wDownLoadService, Info info) {
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
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new T(this));
            N.d.c = false;
            e1.a(this.b.getApplicationContext()).b(new f1(this.a), 2).a();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            if (info != null) {
                string = info.getDl_name();
            } else {
                string = wDownLoadService.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16be);
            }
            wDownLoadService.a(info, string, this.b.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16bf), 0);
            try {
                WDownLoadService.a(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b.stopSelf();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            N.d.c = false;
            e1.a(this.b.getApplicationContext()).b(new f1(this.a), 200).a();
            Info info = this.a;
            try {
                M.a(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    M.g(info.getVv_downf_urls());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            WDownLoadService.a(this.b, this.a);
            this.b.stopSelf();
            d1 a = e1.a(this.b.getApplicationContext());
            f1 f1Var = new f1(this.a);
            String str = this.b.a;
            try {
                a.b = e1.a("witr", f1Var);
                a.a("msg", e1.a(str));
            } catch (JSONException unused) {
            }
            a.a();
            M.b(this.a, this.b.getApplicationContext(), this.b.a);
        }
    }

    public void a(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            N.d.c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            if (info != null) {
                string = info.getDl_name();
            } else {
                string = wDownLoadService.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c2);
            }
            wDownLoadService.a(info, string, this.b.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c2), i);
        }
    }

    public void c() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            N.d.c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.b;
            if (info != null) {
                string = info.getDl_name();
            } else {
                string = wDownLoadService.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16be);
            }
            wDownLoadService.a(info, string, this.b.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16bf), 0);
            WDownLoadService.a(this.b);
            this.b.stopSelf();
            e1.a(this.b.getApplicationContext()).b(new f1(this.a), 1).a();
        }
    }
}
