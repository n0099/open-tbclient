package com.sdk.base.framework.d;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.sdk.base.framework.a.h;
import com.sdk.base.framework.a.i;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.bean.MobileKInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.h.g;
import com.sdk.base.module.config.BaseConfig;
import com.sdk.base.module.manager.SDKManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes16.dex */
public class a<T> {
    private static final String d = a.class.getName();
    private static final boolean e = f.b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4486a;
    public String b;
    public String c;
    private PInfo f;
    private AInfo g;
    private SInfo h;
    private ArrayList<KInfo> i;
    private com.sdk.base.framework.b.a<T> j;
    private e k;

    public a() {
    }

    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        this.f4486a = context;
        this.j = aVar;
        this.k = eVar;
    }

    private com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, ArrayList<File> arrayList, com.sdk.base.framework.b.b<T> bVar, int i, i iVar) {
        com.sdk.base.framework.a.f<T> fVar;
        Exception e2;
        if (dataInfo == null) {
            try {
                dataInfo = new DataInfo();
            } catch (Exception e3) {
                fVar = null;
                e2 = e3;
                com.sdk.base.framework.f.g.a.b(e2.toString());
                a(1, CmdConfigSocket.CMD_SUBPB_FLOOR, "网络访问异常");
                com.sdk.base.framework.a.a.c.b(d, e2.toString(), Boolean.valueOf(e));
                return fVar;
            }
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        String a2 = com.sdk.base.framework.f.j.a.a(this.f4486a);
        String a3 = com.sdk.base.framework.f.j.a.a(16);
        String a4 = com.sdk.base.framework.f.a.a.a(this.f4486a, BaseConfig.apk);
        String a5 = com.sdk.base.framework.f.b.a.a(this.f4486a, "public_key");
        if ("/st/api/v1.0/ses".equals(str2)) {
            a5 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgdQaZgBcrXGxxD6F1TVVXAzvbB3xpoyk2AFMNj4vOcDWZoH1b3Mx5aVcEd0BZPZR6Icb8yi8ecMUVChGCRe20O8EQWLh1aCwR8JazNL+koD3Tn6TIwVwjVEQWy9w6DeXxMtQuFBL/jAChJcU7aDwMsSD1jYpdET37aB4p8Lvn2QIDAQAB";
        }
        if (com.sdk.base.framework.a.a.c.a(a4, a5)) {
            a(1, 101004, "ApiKey或PublicKey不能为空");
            return null;
        }
        try {
            if (com.sdk.base.framework.f.a.a.b() >= 23 && !SDKManager.isClosePermission()) {
                com.sdk.base.module.permission.c cVar = new com.sdk.base.module.permission.c(this.f4486a);
                cVar.a("android.permission.READ_PHONE_STATE");
                cVar.a(new b(this));
                cVar.a();
            }
        } catch (Exception e4) {
        }
        String a6 = a(dataInfo, a3);
        try {
            String b = com.sdk.base.framework.f.i.b.b(a5, a2 + a3);
            treeMap.put("apiKey", a4);
            treeMap.put("params", a6);
            treeMap.put("paramsKey", b);
            String a7 = com.sdk.base.framework.f.k.a.a(a4, str2, treeMap);
            HashMap<String, Object> hashMap = new HashMap<>(16);
            if (com.sdk.base.framework.a.a.c.b(a7).booleanValue()) {
                treeMap.put("sign", a7);
                treeMap.put("sign_Type", "B");
                hashMap.put("sign", a7);
                hashMap.put("api-protocol", "1.1");
            }
            j jVar = new j();
            jVar.a(iVar.toString());
            jVar.b(str + str2);
            jVar.a(bVar);
            jVar.a(i);
            jVar.a(treeMap);
            jVar.a((ArrayList<File>) null);
            jVar.a(hashMap);
            e eVar = this.k;
            g gVar = null;
            if ("/dro/netm/v1.0/qc".equals(str2)) {
                gVar = g.b;
            } else if ("/dro/netm/v1.0/gctcbs".equals(str2)) {
                gVar = g.c;
            }
            jVar.a(gVar);
            h hVar = new h(this.f4486a, jVar);
            fVar = new com.sdk.base.framework.a.f<>(hVar);
            try {
                fVar.c(hVar);
                return fVar;
            } catch (Exception e5) {
                e2 = e5;
                com.sdk.base.framework.f.g.a.b(e2.toString());
                a(1, CmdConfigSocket.CMD_SUBPB_FLOOR, "网络访问异常");
                com.sdk.base.framework.a.a.c.b(d, e2.toString(), Boolean.valueOf(e));
                return fVar;
            }
        } catch (Exception e6) {
            a(1, 101006, "公钥出错");
            com.sdk.base.framework.a.a.c.b(d, "公钥出错：" + e6, Boolean.valueOf(e));
            return null;
        }
    }

    private String a(DataInfo dataInfo, String str) {
        String str2;
        try {
            if (this.g == null) {
                this.g = com.sdk.base.framework.c.a.a(this.f4486a);
            }
            if (this.h == null) {
                this.h = com.sdk.base.framework.c.a.a();
            }
            if (this.i == null) {
                this.i = com.sdk.base.framework.c.a.b(this.f4486a);
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
            if (this.f == null) {
                this.f = com.sdk.base.framework.c.a.c(this.f4486a);
            }
            str2 = "{app:" + this.g + ",sdk:" + this.h + ",device:" + this.f + ",sim:" + arrayList + ",data:" + dataInfo + "}";
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(d, e2.toString(), Boolean.valueOf(e));
            str2 = null;
        }
        return com.sdk.base.framework.f.j.a.a(str2, com.sdk.base.framework.f.b.a.b(this.f4486a, f.f4484a), str);
    }

    public final com.sdk.base.framework.a.f<T> a(String str, String str2, DataInfo dataInfo, com.sdk.base.framework.b.b<T> bVar, int i, i iVar) {
        if (com.sdk.base.framework.a.a.c.a(str).booleanValue()) {
            a(1, 101008, "未检测到域名");
            return null;
        }
        return a(str, str2, dataInfo, null, bVar, 0, iVar);
    }

    public final com.sdk.base.framework.b.b<T> a() {
        return new c(this);
    }

    public final void a(int i, int i2, String str) {
        if (this.j != null) {
            this.j.a(i, i2, str);
            this.j = null;
        }
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        if (this.j != null) {
            this.j.a(i, str, i2, t, str2);
            this.j = null;
        }
    }
}
