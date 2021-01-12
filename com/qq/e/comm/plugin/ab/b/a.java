package com.qq.e.comm.plugin.ab.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.e.comm.plugin.ab.c.g;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11706a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");

    /* renamed from: b  reason: collision with root package name */
    private h f11707b;
    private g c;

    public a(h hVar) {
        this.f11707b = hVar;
        this.c = new g(hVar);
    }

    public static boolean a(Uri uri) {
        return uri != null && uri.isHierarchical() && uri.getScheme().equals("gdtmsg") && uri.getAuthority().equals("e.qq.com");
    }

    private d b(Uri uri) {
        if (uri != null) {
            Matcher matcher = f11706a.matcher(uri.getPath());
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                String group3 = matcher.group(3);
                String queryParameter = uri.getQueryParameter(IXAdRequestInfo.COST_NAME);
                try {
                    return new d(group, group2, group3, !StringUtil.isEmpty(queryParameter) ? new JSONObject(queryParameter) : null);
                } catch (JSONException e) {
                    GDTLogger.report("Exception while json-parse JS Request Paramert Q", e);
                }
            }
        }
        return null;
    }

    public void a() {
        a(new c("bridge.onReceived", new String[0]));
    }

    public void a(final b bVar) {
        if (bVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f11707b.b(bVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while fire JSEvent");
                    }
                }
            });
        }
    }

    public void a(final c cVar) {
        if (cVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f11707b.b(cVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while sending JSResponse");
                    }
                }
            });
        }
    }

    public void a(final e eVar) {
        if (eVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f11707b.b(eVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while sending JSResponse", th);
                    }
                }
            });
        }
    }

    public void a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (a(parse)) {
                d b2 = b(parse);
                if (b2 != null) {
                    this.c.a(b2);
                } else {
                    GDTLogger.report(String.format("ParseJSRequestReturn Null,reqUrl=%s", str));
                }
            } else if (this.f11707b.c(str)) {
                com.qq.e.comm.plugin.w.a.e.a(this.f11707b, str);
            }
        } catch (Throwable th) {
            GDTLogger.report(String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str), th);
        }
    }

    public void a(String str, com.qq.e.comm.plugin.ab.c.e eVar) {
        this.c.a(str, eVar);
    }
}
