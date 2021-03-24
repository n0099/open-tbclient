package com.win.opensdk;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class a1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f39861a = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f39862b = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f39863c = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f39864d = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    public static Z0 a(Context context) {
        return new Z0(new a1(), context);
    }

    public static /* synthetic */ JSONStringer a(String str, b1 b1Var) {
        JSONStringer c2 = c();
        c2.key("e").value(str).key("timeis").value(b());
        if (b1Var != null) {
            c2.key("pid").value(b1Var.f39886a);
            if (b1Var.f39887b != null) {
                JSONStringer key = c2.key("traceid");
                String traceid = b1Var.f39887b.getTraceid();
                try {
                    traceid = G.a(traceid);
                } catch (Exception unused) {
                }
                JSONStringer key2 = key.value(traceid).key(IXAdRequestInfo.CELL_ID);
                String id = b1Var.f39887b.getId();
                try {
                    id = G.a(id);
                } catch (Exception unused2) {
                }
                key2.value(id).key("type").value(b1Var.f39887b.getType());
            }
        }
        return c2;
    }

    public static String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return G.a(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }

    public static JSONStringer c() {
        return new JSONStringer().object();
    }

    public static /* synthetic */ String a(String str) {
        try {
            return G.a(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ String a() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return G.a(valueOf);
        } catch (Exception unused) {
            return valueOf;
        }
    }
}
