package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.FormattableUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f62050d;

    /* renamed from: e  reason: collision with root package name */
    public String f62051e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.ss.android.socialbase.downloader.g.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62050d = str2;
        this.f62051e = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String c2 = this.f62047b.c("s");
            String a = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c(ContentUtil.RESULT_KEY_AK), c2);
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("am"), c2);
            String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c(com.alipay.sdk.sys.a.r), c2);
            String str2 = null;
            if (!TextUtils.isEmpty(a3) && a3.split(",").length == 2) {
                String[] split = a3.split(",");
                String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("al"), c2);
                String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("ao"), c2);
                if (!TextUtils.isEmpty(a5) && a5.split(",").length == 2) {
                    String[] split2 = a5.split(",");
                    JSONObject d2 = this.f62047b.d("download_dir");
                    if (d2 != null) {
                        String optString = d2.optString("dir_name");
                        if (!TextUtils.isEmpty(optString) && optString.contains(FormattableUtils.SIMPLEST_FORMAT)) {
                            try {
                                str = String.format(optString, this.f62051e);
                            } catch (Throwable unused) {
                                str = this.f62051e;
                            }
                        } else {
                            str = this.f62051e;
                        }
                        str2 = str;
                        if (str2.length() > 255) {
                            str2 = a4.substring(str2.length() - 255);
                        }
                    }
                    Intent intent = new Intent(a);
                    intent.putExtra(split2[0], split2[1]);
                    intent.putExtra(a2, this.f62050d);
                    intent.putExtra(a4, str2);
                    intent.putExtra(split[0], Integer.parseInt(split[1]));
                    intent.addFlags(268468224);
                    return intent;
                }
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }
}
