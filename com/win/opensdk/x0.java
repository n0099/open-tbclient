package com.win.opensdk;

import android.content.Context;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import org.json.JSONStringer;
/* loaded from: classes6.dex */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f37998a = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f37999b = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f38000c = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f38001d = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    public static w0 a(Context context) {
        return new w0(new x0(), context);
    }

    public static /* synthetic */ JSONStringer a(String str, y0 y0Var) {
        JSONStringer d2 = d();
        d2.key("e").value(str).key("timeis").value(c());
        if (y0Var != null) {
            d2.key("pid").value(y0Var.f38009a);
            if (y0Var.f38010b != null) {
                JSONStringer key = d2.key("traceid");
                String traceid = y0Var.f38010b.getTraceid();
                try {
                    traceid = z.a(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key(IAdRequestParam.CELL_ID);
                String id = y0Var.f38010b.getId();
                try {
                    id = z.a(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(y0Var.f38010b.getType());
            }
        }
        return d2;
    }

    public static /* synthetic */ String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return z.a(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static String c() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return z.a(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static JSONStringer d() {
        return new JSONStringer().object();
    }

    public static /* synthetic */ String a(String str) {
        try {
            return z.a(str);
        } catch (Exception unused) {
            return str;
        }
    }
}
