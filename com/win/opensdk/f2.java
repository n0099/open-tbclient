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
/* loaded from: classes10.dex */
public class f2 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f77346a;

    public f2(g2 g2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77346a = g2Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || (info = this.f77346a.f77353c) == null || info.getOpent() != 1 || j2 <= 10) {
            return;
        }
        g2 g2Var = this.f77346a;
        Context context = g2Var.f77351a;
        Info info2 = g2Var.f77353c;
        if (!N.e(context)) {
            Toast.makeText(context, context.getString(R.string.win_wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            Z0.a(context).b(new a1(info2), 1).a();
            return;
        }
        try {
            if (N.b(context, info2.getOpen()) && N.a(context, info2)) {
                Y0 a2 = Z0.a(context);
                a1 a1Var = new a1(info2);
                String open = info2.getOpen();
                try {
                    a2.f77254b = Z0.a("wii", a1Var);
                    a2.a("msg", Z0.a(open));
                } catch (JSONException unused) {
                }
                a2.a();
                N.b(info2, context, N.a(context, info2.getOpen()));
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (info2 != null) {
            try {
                if (TextUtils.isEmpty(info2.getOpen())) {
                    return;
                }
                U1.a(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                Z0.a(context).b(new a1(info2), 2).a("desc", e3.getMessage()).a();
            }
        }
    }
}
