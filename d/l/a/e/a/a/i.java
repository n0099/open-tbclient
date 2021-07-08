package d.l.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f71572d;

    /* renamed from: e  reason: collision with root package name */
    public String f71573e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, d.l.a.e.b.j.a aVar, String str, String str2, String str3) {
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
                super((Context) objArr2[0], (d.l.a.e.b.j.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71572d = str2;
        this.f71573e = str3;
    }

    @Override // d.l.a.e.a.a.e
    public Intent b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String t = this.f71569b.t("s");
            String b2 = d.l.a.e.a.h.d.b(this.f71569b.t(ContentUtil.RESULT_KEY_AK), t);
            String b3 = d.l.a.e.a.h.d.b(this.f71569b.t("am"), t);
            String b4 = d.l.a.e.a.h.d.b(this.f71569b.t(com.alipay.sdk.sys.a.f1937i), t);
            String str2 = null;
            if (!TextUtils.isEmpty(b4) && b4.split(",").length == 2) {
                String[] split = b4.split(",");
                String b5 = d.l.a.e.a.h.d.b(this.f71569b.t("al"), t);
                String b6 = d.l.a.e.a.h.d.b(this.f71569b.t("ao"), t);
                if (!TextUtils.isEmpty(b6) && b6.split(",").length == 2) {
                    String[] split2 = b6.split(",");
                    JSONObject u = this.f71569b.u("download_dir");
                    if (u != null) {
                        String optString = u.optString("dir_name");
                        if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                            try {
                                str = String.format(optString, this.f71573e);
                            } catch (Throwable unused) {
                                str = this.f71573e;
                            }
                        } else {
                            str = this.f71573e;
                        }
                        str2 = str;
                        if (str2.length() > 255) {
                            str2 = b5.substring(str2.length() - 255);
                        }
                    }
                    Intent intent = new Intent(b2);
                    intent.putExtra(split2[0], split2[1]);
                    intent.putExtra(b3, this.f71572d);
                    intent.putExtra(b5, str2);
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
