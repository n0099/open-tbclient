package com.win.opensdk;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s1 f40407a;

    public r1(s1 s1Var) {
        this.f40407a = s1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = "";
        HashMap a2 = p1.a(this.f40407a.f40410a);
        a2.put("pid", this.f40407a.f40411b);
        t1.a(this.f40407a, a2);
        s1 s1Var = this.f40407a;
        char c2 = 0;
        try {
            String[] split = V1.q(s1Var.f40410a).split(",");
            ArrayList<d1> arrayList = new ArrayList();
            arrayList.clear();
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                String str2 = split2[c2];
                String str3 = split2[1];
                if (System.currentTimeMillis() - Long.parseLong(str3) < V1.o(s1Var.f40410a)) {
                    d1 d1Var = new d1();
                    d1Var.f40300a = str2;
                    d1Var.f40301b = Long.parseLong(str3);
                    arrayList.add(d1Var);
                }
                i++;
                c2 = 0;
            }
            if (!arrayList.isEmpty()) {
                String str4 = "";
                String str5 = str4;
                for (d1 d1Var2 : arrayList) {
                    str4 = str4 + d1Var2.f40300a + ",";
                    str5 = str5 + d1Var2.f40300a + ":" + d1Var2.f40301b + ",";
                }
                if (!TextUtils.isEmpty(str4)) {
                    a2.put("a605", str4.substring(0, str4.length() - 1));
                }
                if (!TextUtils.isEmpty(str5)) {
                    V1.b(s1Var.f40410a, str5.substring(0, str5.length() - 1), true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        s1 s1Var2 = this.f40407a;
        try {
            String[] split3 = V1.p(s1Var2.f40410a).split(",");
            ArrayList<d1> arrayList2 = new ArrayList();
            arrayList2.clear();
            for (String str6 : split3) {
                String[] split4 = str6.split(":");
                String str7 = split4[0];
                String str8 = split4[1];
                if (System.currentTimeMillis() - Long.parseLong(str8) <= V1.o(s1Var2.f40410a)) {
                    d1 d1Var3 = new d1();
                    d1Var3.f40300a = str7;
                    d1Var3.f40301b = Long.parseLong(str8);
                    arrayList2.add(d1Var3);
                }
            }
            if (!arrayList2.isEmpty()) {
                String str9 = "";
                String str10 = str9;
                for (d1 d1Var4 : arrayList2) {
                    str9 = str9 + d1Var4.f40300a + ",";
                    str10 = str10 + d1Var4.f40300a + ":" + d1Var4.f40301b + ",";
                }
                if (!TextUtils.isEmpty(str9)) {
                    a2.put("a601", str9.substring(0, str9.length() - 1));
                }
                if (!TextUtils.isEmpty(str10)) {
                    V1.a(s1Var2.f40410a, str10.substring(0, str10.length() - 1), true);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            str = this.f40407a.f40412c + p1.a(a2);
        } catch (UnsupportedEncodingException unused) {
        }
        G.a(str, (Map) null, new q1(this));
    }
}
