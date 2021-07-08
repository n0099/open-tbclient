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
/* loaded from: classes6.dex */
public class D1 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E1 f39346a;

    public D1(E1 e1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39346a = e1;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || (info = this.f39346a.f39357c) == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        E1 e1 = this.f39346a;
        Context context = e1.f39355a;
        Info info2 = e1.f39357c;
        if (!z.e(context)) {
            Toast.makeText(context, context.getString(R.string.win_wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            x0.a(context).b(new y0(info2), 1).a();
            return;
        }
        try {
            if (z.b(context, info2.getOpen()) && z.a(context, info2)) {
                w0 a2 = x0.a(context);
                y0 y0Var = new y0(info2);
                String open = info2.getOpen();
                try {
                    a2.f39697b = x0.a("wii", y0Var);
                    a2.a("msg", x0.a(open));
                } catch (JSONException unused) {
                }
                a2.a();
                z.b(info2, context, z.a(context, info2.getOpen()));
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
                s1.a(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                x0.a(context).b(new y0(info2), 2).a("desc", e3.getMessage()).a();
            }
        }
    }
}
