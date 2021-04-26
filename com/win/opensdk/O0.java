package com.win.opensdk;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ P0 f37716a;

    public O0(P0 p0) {
        this.f37716a = p0;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = "";
        HashMap a2 = M0.a(this.f37716a.f37717a);
        a2.put("pid", this.f37716a.f37718b);
        Q0.a(this.f37716a, a2);
        P0 p0 = this.f37716a;
        char c2 = 0;
        try {
            String[] split = s1.o(p0.f37717a).split(",");
            ArrayList<A0> arrayList = new ArrayList();
            arrayList.clear();
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String[] split2 = split[i2].split(":");
                String str2 = split2[c2];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) < s1.m(p0.f37717a)) {
                    A0 a0 = new A0();
                    a0.f37606a = str2;
                    a0.f37607b = Long.parseLong(str3);
                    arrayList.add(a0);
                }
                i2++;
                c2 = 0;
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = str4;
                for (A0 a02 : arrayList) {
                    str4 = str4 + a02.f37606a + ",";
                    str5 = str5 + a02.f37606a + ":" + a02.f37607b + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    a2.put("a605", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    s1.b(p0.f37717a, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        P0 p02 = this.f37716a;
        try {
            String[] split3 = s1.n(p02.f37717a).split(",");
            ArrayList<A0> arrayList2 = new ArrayList();
            arrayList2.clear();
            for (String str6 : split3) {
                String[] split4 = str6.split(":");
                String str7 = split4[0];
                String str8 = split4[1];
                if (System.currentTimeMillis() - Long.parseLong(str8) <= s1.m(p02.f37717a)) {
                    A0 a03 = new A0();
                    a03.f37606a = str7;
                    a03.f37607b = Long.parseLong(str8);
                    arrayList2.add(a03);
                }
            }
            if (!arrayList2.isEmpty()) {
                String str9 = "";
                String str10 = str9;
                for (A0 a04 : arrayList2) {
                    str9 = str9 + a04.f37606a + ",";
                    str10 = str10 + a04.f37606a + ":" + a04.f37607b + ",";
                }
                if (!TextUtils.isEmpty(str9)) {
                    a2.put("a601", str9.substring(0, str9.length() - 1));
                }
                if (!TextUtils.isEmpty(str10)) {
                    s1.a(p02.f37717a, str10.substring(0, str10.length() - 1), true);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            str = this.f37716a.f37719c + M0.a(a2);
        } catch (UnsupportedEncodingException unused) {
        }
        z.a(str, (Map) null, new N0(this));
    }
}
