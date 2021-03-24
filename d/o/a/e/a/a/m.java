package d.o.a.e.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class m extends a {
    public m(Context context, d.o.a.e.b.j.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // d.o.a.e.a.a.e
    public Intent b() {
        String t = this.f66785b.t("s");
        String b2 = d.o.a.e.a.h.b.b(this.f66785b.t("bb"), t);
        if (!TextUtils.isEmpty(b2) && b2.split(",").length == 2) {
            String b3 = d.o.a.e.a.h.b.b(this.f66785b.t("bc"), t);
            if (!TextUtils.isEmpty(b3) && b3.split(",").length == 2) {
                String[] split = b2.split(",");
                String[] split2 = b3.split(",");
                String b4 = d.o.a.e.a.h.b.b(this.f66785b.t(Config.DEVICE_BRAND), t);
                String b5 = d.o.a.e.a.h.b.b(this.f66785b.t("be"), t);
                String b6 = d.o.a.e.a.h.b.b(this.f66785b.t("bf"), t);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(b4, this.f66786c);
                Intent intent = new Intent();
                intent.setAction(b6);
                intent.setData(Uri.parse(b5 + b(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }
}
