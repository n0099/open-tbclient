package com.win.opensdk;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public final class ed implements Runnable {
    public final /* synthetic */ eh qmg;

    public ed(eh ehVar) {
        this.qmg = ehVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap iV = dw.iV(this.qmg.f8161a);
        iV.put("pid", this.qmg.b);
        el.a(this.qmg, iV);
        eh ehVar = this.qmg;
        try {
            String[] split = bp.q(ehVar.f8161a).split(",");
            ArrayList<cj> arrayList = new ArrayList();
            arrayList.clear();
            for (String str : split) {
                String[] split2 = str.split(":");
                String str2 = split2[0];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) < bp.o(ehVar.f8161a)) {
                    cj cjVar = new cj();
                    cjVar.f8145a = str2;
                    cjVar.b = Long.parseLong(str3);
                    arrayList.add(cjVar);
                }
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = "";
                for (cj cjVar2 : arrayList) {
                    str4 = str4 + cjVar2.f8145a + ",";
                    str5 = str5 + cjVar2.f8145a + ":" + cjVar2.b + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    iV.put("a605", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    bp.b(ehVar.f8161a, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        eh ehVar2 = this.qmg;
        try {
            String[] split3 = bp.p(ehVar2.f8161a).split(",");
            ArrayList<cj> arrayList2 = new ArrayList();
            arrayList2.clear();
            for (String str6 : split3) {
                String[] split4 = str6.split(":");
                String str7 = split4[0];
                String str8 = split4[1];
                if (System.currentTimeMillis() - Long.parseLong(str8) <= bp.o(ehVar2.f8161a)) {
                    cj cjVar3 = new cj();
                    cjVar3.f8145a = str7;
                    cjVar3.b = Long.parseLong(str8);
                    arrayList2.add(cjVar3);
                }
            }
            if (!arrayList2.isEmpty()) {
                String str9 = "";
                String str10 = "";
                for (cj cjVar4 : arrayList2) {
                    str9 = str9 + cjVar4.f8145a + ",";
                    str10 = str10 + cjVar4.f8145a + ":" + cjVar4.b + ",";
                }
                if (!TextUtils.isEmpty(str9)) {
                    iV.put("a601", str9.substring(0, str9.length() - 1));
                }
                if (!TextUtils.isEmpty(str10)) {
                    bp.a(ehVar2.f8161a, str10.substring(0, str10.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str11 = "";
        try {
            str11 = this.qmg.c + dw.a(iV);
        } catch (UnsupportedEncodingException e3) {
        }
        v.a(str11, (Map) null, new ea(this));
    }
}
