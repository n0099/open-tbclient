package d.b.i0.f1;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class f {
    public static void a(Context context, String str) {
        String format;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", str);
        }
        d.b.h0.l.a.l(context, format);
    }
}
