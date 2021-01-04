package com.qq.e.comm.plugin.ab.f;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f12102a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");

    /* renamed from: b  reason: collision with root package name */
    private a f12103b;

    public f(a aVar) {
        this.f12103b = aVar;
    }

    public static boolean a(Uri uri) {
        return uri != null && uri.isHierarchical() && uri.getScheme().equals("gdtmsg") && uri.getAuthority().equals("e.qq.com");
    }

    private com.qq.e.comm.plugin.ab.b.d b(Uri uri) {
        if (uri != null) {
            Matcher matcher = f12102a.matcher(uri.getPath());
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                String group3 = matcher.group(3);
                String queryParameter = uri.getQueryParameter(IXAdRequestInfo.COST_NAME);
                if ("multiAction".equals(group)) {
                    return new com.qq.e.comm.plugin.ab.b.d(group2, group, group3, null, queryParameter);
                }
                try {
                    return new com.qq.e.comm.plugin.ab.b.d(group2, group, group3, !StringUtil.isEmpty(queryParameter) ? new JSONObject(queryParameter) : null);
                } catch (JSONException e) {
                    GDTLogger.report("Exception while json-parse JS Request Paramert Q", e);
                }
            }
        }
        return null;
    }

    public com.qq.e.comm.plugin.ab.b.d a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (a(parse)) {
                return b(parse);
            }
        } catch (Throwable th) {
            GDTLogger.report(String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str), th);
        }
        return null;
    }

    public void a() {
        a(new com.qq.e.comm.plugin.ab.b.c("bridge.onReceived", new String[0]));
    }

    public void a(final com.qq.e.comm.plugin.ab.b.c cVar) {
        if (cVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.f.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        f.this.f12103b.b(cVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while sending JSResponse");
                    }
                }
            });
        }
    }
}
