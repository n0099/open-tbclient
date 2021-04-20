package com.sdk.base.framework.d;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.h;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.a.k;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.g.g;
import com.sdk.base.module.config.BaseConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final String f38815d = "com.sdk.base.framework.d.a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f38816e = f.f38809b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38817a;

    /* renamed from: b  reason: collision with root package name */
    public String f38818b;

    /* renamed from: c  reason: collision with root package name */
    public String f38819c;

    /* renamed from: f  reason: collision with root package name */
    public PInfo f38820f;

    /* renamed from: g  reason: collision with root package name */
    public AInfo f38821g;

    /* renamed from: h  reason: collision with root package name */
    public SInfo f38822h;
    public ArrayList<KInfo> i;
    public com.sdk.base.framework.b.a<T> j;
    public e k;

    public a() {
    }

    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        this.f38817a = context;
        this.j = aVar;
        this.k = eVar;
    }

    private com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, ArrayList<File> arrayList, com.sdk.base.framework.b.b<T> bVar, int i, j jVar) {
        DataInfo dataInfo2;
        com.sdk.base.framework.a.f<T> fVar = null;
        if (dataInfo == null) {
            try {
                dataInfo2 = new DataInfo();
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            dataInfo2 = dataInfo;
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        String a2 = com.sdk.base.framework.f.i.a.a(this.f38817a);
        String a3 = com.sdk.base.framework.f.i.a.a(16);
        String a4 = com.sdk.base.framework.f.a.a.a(this.f38817a, BaseConfig.apk);
        String a5 = com.sdk.base.framework.f.b.a.a(this.f38817a, com.alipay.sdk.packet.e.m);
        if ("/st/api/v1.0/ses".equals(str2)) {
            a5 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgdQaZgBcrXGxxD6F1TVVXAzvbB3xpoyk2AFMNj4vOcDWZoH1b3Mx5aVcEd0BZPZR6Icb8yi8ecMUVChGCRe20O8EQWLh1aCwR8JazNL+koD3Tn6TIwVwjVEQWy9w6DeXxMtQuFBL/jAChJcU7aDwMsSD1jYpdET37aB4p8Lvn2QIDAQAB";
        }
        if (c.a(a4, a5)) {
            a(1, 101004, "ApiKey或PublicKey不能为空");
            return null;
        }
        String a6 = a(dataInfo2, a3);
        try {
            String b2 = com.sdk.base.framework.f.h.b.b(a5, a2 + a3);
            treeMap.put("apiKey", a4);
            treeMap.put("params", a6);
            treeMap.put("paramsKey", b2);
            String a7 = com.sdk.base.framework.f.j.a.a(a4, str2, treeMap);
            HashMap<String, Object> hashMap = new HashMap<>(16);
            if (c.b(a7).booleanValue()) {
                treeMap.put("sign", a7);
                treeMap.put("sign_Type", "B");
                hashMap.put("sign", a7);
                hashMap.put("api-protocol", "1.1");
            }
            k kVar = new k();
            kVar.a(jVar.toString());
            kVar.b(str + str2);
            kVar.a(bVar);
            kVar.a(i);
            kVar.a(treeMap);
            kVar.a((ArrayList<File>) null);
            kVar.a(hashMap);
            if ("/dro/netm/v1.0/qc".equals(str2)) {
                g gVar = g.f38843a;
            } else if ("/dro/netm/v1.0/gctcbs".equals(str2)) {
                g gVar2 = g.f38844b;
            }
            h hVar = new h(this.f38817a, kVar);
            com.sdk.base.framework.a.f<T> fVar2 = new com.sdk.base.framework.a.f<>(hVar);
            try {
                fVar2.c(hVar);
                return fVar2;
            } catch (Exception e3) {
                e = e3;
                fVar = fVar2;
                com.sdk.base.framework.f.f.a.b(e.toString());
                a(1, 302002, "网络访问异常");
                c.b(f38815d, e.toString(), Boolean.valueOf(f38816e));
                return fVar;
            }
        } catch (Exception e4) {
            a(1, 101006, "公钥出错");
            String str3 = f38815d;
            c.b(str3, "公钥出错：" + e4, Boolean.valueOf(f38816e));
            return null;
        }
    }

    private String a(DataInfo dataInfo, String str) {
        String str2;
        try {
            if (this.f38821g == null) {
                this.f38821g = com.sdk.base.framework.c.a.a(this.f38817a);
            }
            if (this.f38822h == null) {
                this.f38822h = com.sdk.base.framework.c.a.b();
            }
            if (this.i == null) {
                this.i = com.sdk.base.framework.c.a.a();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KInfo> it = this.i.iterator();
            while (it.hasNext()) {
                KInfo next = it.next();
                MobileKInfo mobileKInfo = new MobileKInfo();
                mobileKInfo.setIe(next.getIe());
                mobileKInfo.setIs(next.getIs());
                mobileKInfo.setM(next.getM());
                mobileKInfo.setIdfd(next.isIdfd());
                arrayList.add(mobileKInfo);
            }
            if (this.f38820f == null) {
                this.f38820f = com.sdk.base.framework.c.a.c();
            }
            StringBuilder sb = new StringBuilder("{app:");
            sb.append(this.f38821g);
            sb.append(",sdk:");
            sb.append(this.f38822h);
            sb.append(",device:");
            sb.append(this.f38820f);
            sb.append(",sim:");
            sb.append(arrayList);
            sb.append(",data:");
            sb.append(dataInfo);
            sb.append("}");
            str2 = sb.toString();
        } catch (Exception e2) {
            c.b(f38815d, e2.toString(), Boolean.valueOf(f38816e));
            str2 = null;
        }
        return com.sdk.base.framework.f.i.a.a(str2, com.sdk.base.framework.f.b.a.b(this.f38817a, f.f38808a), str);
    }

    public final com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, com.sdk.base.framework.b.b<T> bVar, int i, j jVar) {
        if (c.a(str).booleanValue()) {
            a(1, 101008, "未检测到域名");
            return null;
        }
        return a(str, str2, dataInfo, null, bVar, 0, jVar);
    }

    public final com.sdk.base.framework.b.b<T> a() {
        return new b(this);
    }

    public final void a(int i, int i2, String str) {
        com.sdk.base.framework.b.a<T> aVar = this.j;
        if (aVar != null) {
            aVar.a(i, i2, str);
            this.j = null;
        }
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        com.sdk.base.framework.b.a<T> aVar = this.j;
        if (aVar != null) {
            aVar.a(i, str, i2, t, str2);
            this.j = null;
        }
    }
}
