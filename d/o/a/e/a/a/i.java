package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f70903d;

    /* renamed from: e  reason: collision with root package name */
    public String f70904e;

    public i(Context context, d.o.a.e.b.j.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        this.f70903d = str2;
        this.f70904e = str3;
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        String str;
        String t = this.f70900b.t("s");
        String b2 = d.o.a.e.a.h.b.b(this.f70900b.t(ContentUtil.RESULT_KEY_AK), t);
        String b3 = d.o.a.e.a.h.b.b(this.f70900b.t("am"), t);
        String b4 = d.o.a.e.a.h.b.b(this.f70900b.t(com.alipay.sdk.sys.a.f1933i), t);
        String str2 = null;
        if (!TextUtils.isEmpty(b4) && b4.split(",").length == 2) {
            String[] split = b4.split(",");
            String b5 = d.o.a.e.a.h.b.b(this.f70900b.t("al"), t);
            String b6 = d.o.a.e.a.h.b.b(this.f70900b.t("ao"), t);
            if (!TextUtils.isEmpty(b6) && b6.split(",").length == 2) {
                String[] split2 = b6.split(",");
                JSONObject u = this.f70900b.u("download_dir");
                if (u != null) {
                    String optString = u.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.f70904e);
                        } catch (Throwable unused) {
                            str = this.f70904e;
                        }
                    } else {
                        str = this.f70904e;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = b5.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(b2);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(b3, this.f70903d);
                intent.putExtra(b5, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
