package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class so9 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ wo9 a;

    public so9(wo9 wo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wo9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wo9Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || (info = this.a.c) == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        wo9 wo9Var = this.a;
        Context context = wo9Var.a;
        Info info2 = wo9Var.c;
        if (!ll9.H(context)) {
            Toast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f15ac) + info2.getDl_name(), 0).show();
            nn9 a = rn9.a(context);
            a.q(new vn9(info2), 1);
            a.m();
            return;
        }
        try {
            if (ll9.B(context, info2.getOpen()) && ll9.A(context, info2)) {
                nn9 a2 = rn9.a(context);
                vn9 vn9Var = new vn9(info2);
                String open = info2.getOpen();
                try {
                    a2.b = rn9.d("wii", vn9Var);
                    a2.l("msg", rn9.b(open));
                } catch (JSONException unused) {
                }
                a2.m();
                ll9.z(info2, context, ll9.f(context, info2.getOpen()));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (info2 != null) {
            try {
                if (TextUtils.isEmpty(info2.getOpen())) {
                    return;
                }
                bn9.f(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                nn9 a3 = rn9.a(context);
                a3.q(new vn9(info2), 2);
                a3.l("desc", e2.getMessage());
                a3.m();
            }
        }
    }
}
