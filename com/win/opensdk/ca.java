package com.win.opensdk;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import org.json.JSONStringer;
/* loaded from: classes14.dex */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f8138a = {"as", "ac", "ao", "scb", "wdin", "asr", "wbas", "wbao"};
    public static final String[] b = {"ins", Config.DEVICE_BRAND, "wdtr", "witr"};
    public static final String[] c = {"be", "bce", "bpe", "ps", "scbe", "wdst", "wde", "wie", "dplop", "wbe"};
    public static final String[] d = {"Ld", "wdin", "wiin", "wdre", "wiop", "wii"};

    public static /* synthetic */ JSONStringer a(String str, cd cdVar) {
        JSONStringer eJe = eJe();
        eJe.key("e").value(str).key("timeis").value(b());
        if (cdVar != null) {
            eJe.key("pid").value(cdVar.f8141a);
            if (cdVar.qlv != null) {
                JSONStringer key = eJe.key("traceid");
                String traceid = cdVar.qlv.getTraceid();
                try {
                    traceid = v.a(traceid);
                } catch (Exception e) {
                }
                JSONStringer key2 = key.value(traceid).key(IXAdRequestInfo.CELL_ID);
                String id = cdVar.qlv.getId();
                try {
                    id = v.a(id);
                } catch (Exception e2) {
                }
                key2.value(id).key("type").value(cdVar.qlv.getType());
            }
        }
        return eJe;
    }

    public static String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return v.a(valueOf);
        } catch (Exception e) {
            return valueOf;
        }
    }

    public static JSONStringer eJe() {
        return new JSONStringer().object();
    }

    public static bx iT(Context context) {
        return new bx(new ca(), context);
    }

    public static /* synthetic */ String a(String str) {
        try {
            return v.a(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static /* synthetic */ String a() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            return v.a(valueOf);
        } catch (Exception e) {
            return valueOf;
        }
    }
}
