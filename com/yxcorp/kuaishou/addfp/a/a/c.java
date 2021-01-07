package com.yxcorp.kuaishou.addfp.a.a;

import android.content.Context;
import com.baidu.android.util.devices.RomUtils;
import com.yxcorp.kuaishou.addfp.a.b.f.g;
import com.yxcorp.kuaishou.addfp.android.b.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f14637a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Context f14638b;
    private /* synthetic */ b qfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, a aVar, Context context) {
        this.qfV = bVar;
        this.f14637a = aVar;
        this.f14638b = context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        com.yxcorp.kuaishou.addfp.a.b.a aVar;
        com.yxcorp.kuaishou.addfp.a.b.a aVar2;
        com.yxcorp.kuaishou.addfp.a.b.a aVar3;
        com.yxcorp.kuaishou.addfp.a.b.a aVar4;
        com.yxcorp.kuaishou.addfp.a.b.a aVar5;
        com.yxcorp.kuaishou.addfp.a.b.a aVar6;
        char c = 0;
        try {
            this.qfV.f14636a = this.f14637a;
            String a2 = b.a(this.qfV);
            switch (a2.hashCode()) {
                case -1619859642:
                    if (a2.equals("blackshark")) {
                        break;
                    }
                    c = 65535;
                    break;
                case -1537600024:
                    if (a2.equals("freemeos")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1320380160:
                    if (a2.equals("oneplus")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1206476313:
                    if (a2.equals(RomUtils.MANUFACTURER_HUAWEI)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1106355917:
                    if (a2.equals("lenovo")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -759499589:
                    if (a2.equals(RomUtils.MANUFACTURER_XIAOMI)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -151542385:
                    if (a2.equals("motorola")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 120939:
                    if (a2.equals("zte")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 3003984:
                    if (a2.equals("asus")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3418016:
                    if (a2.equals(RomUtils.MANUFACTURER_OPPO)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3540212:
                    if (a2.equals("ssui")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 3620012:
                    if (a2.equals(RomUtils.MANUFACTURER_VIVO)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 103777484:
                    if (a2.equals(RomUtils.MANUFACTURER_MEIZU)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 105170387:
                    if (a2.equals(RomUtils.MANUFACTURER_NUBIA)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1864941562:
                    if (a2.equals("samsung")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.i.b(this.f14638b);
                    break;
                case 2:
                    this.qfV.qfU = new e(this.f14638b);
                    break;
                case 3:
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.h.a(this.f14638b);
                    aVar = this.qfV.qfU;
                    ((com.yxcorp.kuaishou.addfp.a.b.h.a) aVar).a("100215079");
                    break;
                case 4:
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.f14638b, b.eKV());
                    break;
                case 5:
                case 6:
                    this.qfV.qfU = new g(this.f14638b, b.eKV());
                    break;
                case 7:
                case '\b':
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f14638b, b.eKV());
                    break;
                case '\t':
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.f14638b, b.eKV());
                    break;
                case '\n':
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.f14638b, b.eKV());
                    break;
                case 11:
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.e.b(this.f14638b);
                    break;
                case '\f':
                case '\r':
                case 14:
                    this.qfV.qfU = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.f14638b, b.eKV());
                    break;
            }
            aVar2 = this.qfV.qfU;
            if (aVar2 == null) {
                this.qfV.a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
                return;
            }
            aVar3 = this.qfV.qfU;
            if (!aVar3.a()) {
                aVar6 = this.qfV.qfU;
                aVar6.a(b.eKV());
                return;
            }
            aVar4 = this.qfV.qfU;
            if (!aVar4.c()) {
                this.qfV.a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
                return;
            }
            b bVar = this.qfV;
            aVar5 = this.qfV.qfU;
            bVar.a(true, aVar5);
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }
}
