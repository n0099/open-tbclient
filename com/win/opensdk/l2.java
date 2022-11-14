package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class l2 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ m2 a;

    public l2(m2 m2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m2Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) && (info = this.a.c) != null && info.getOpent() == 1 && j > 10) {
            m2 m2Var = this.a;
            Context context = m2Var.a;
            Info info2 = m2Var.c;
            if (!M.e(context)) {
                Toast.makeText(context, context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1614) + info2.getDl_name(), 0).show();
                e1.a(context).c(new f1(info2), 1).a();
                return;
            }
            try {
                if (M.b(context, info2.getOpen()) && M.b(context, info2)) {
                    d1 a = e1.a(context);
                    f1 f1Var = new f1(info2);
                    String open = info2.getOpen();
                    try {
                        a.b = e1.a("wii", f1Var);
                        a.a("msg", e1.a(open));
                    } catch (JSONException unused) {
                    }
                    a.a();
                    M.b(info2, context, M.a(context, info2.getOpen()));
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (info2 != null) {
                try {
                    if (!TextUtils.isEmpty(info2.getOpen())) {
                        Z1.a(context, info2.getDl_pkg(), info2);
                        Intent intent = new Intent(context, WDownLoadService.class);
                        intent.putExtra("down_load_apk_url", info2.getOpen());
                        intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                        context.startService(intent);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    e1.a(context).c(new f1(info2), 2).a("desc", e2.getMessage()).a();
                }
            }
        }
    }
}
