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
public class zo9 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ dp9 a;

    public zo9(dp9 dp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dp9Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || (info = this.a.c) == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        dp9 dp9Var = this.a;
        Context context = dp9Var.a;
        Info info2 = dp9Var.c;
        if (!sl9.H(context)) {
            Toast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f15b5) + info2.getDl_name(), 0).show();
            un9 a = yn9.a(context);
            a.q(new co9(info2), 1);
            a.m();
            return;
        }
        try {
            if (sl9.B(context, info2.getOpen()) && sl9.A(context, info2)) {
                un9 a2 = yn9.a(context);
                co9 co9Var = new co9(info2);
                String open = info2.getOpen();
                try {
                    a2.b = yn9.d("wii", co9Var);
                    a2.l("msg", yn9.b(open));
                } catch (JSONException unused) {
                }
                a2.m();
                sl9.z(info2, context, sl9.f(context, info2.getOpen()));
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
                in9.f(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                un9 a3 = yn9.a(context);
                a3.q(new co9(info2), 2);
                a3.l("desc", e2.getMessage());
                a3.m();
            }
        }
    }
}
