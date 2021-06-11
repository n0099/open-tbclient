package d.q.a.a.a.a;

import android.content.Context;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
import com.yxcorp.kuaishou.addfp.a.b.f.g;
import d.q.a.a.c.b.e;
/* loaded from: classes7.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f71318e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ Context f71319f;

    /* renamed from: g  reason: collision with root package name */
    public /* synthetic */ b f71320g;

    public c(b bVar, a aVar, Context context) {
        this.f71320g = bVar;
        this.f71318e = aVar;
        this.f71319f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        d.q.a.a.a.b.b bVar2;
        d.q.a.a.a.b.b bVar3;
        d.q.a.a.a.b.b bVar4;
        d.q.a.a.a.b.b bVar5;
        d.q.a.a.a.b.b bVar6;
        d.q.a.a.a.b.b bVar7;
        d.q.a.a.a.b.b bVar8;
        try {
            this.f71320g.f71315a = this.f71318e;
            String e2 = b.e(this.f71320g);
            char c2 = 65535;
            switch (e2.hashCode()) {
                case -1619859642:
                    if (e2.equals("blackshark")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1537600024:
                    if (e2.equals("freemeos")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -1320380160:
                    if (e2.equals("oneplus")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1206476313:
                    if (e2.equals(RomUtils.MANUFACTURER_HUAWEI)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1106355917:
                    if (e2.equals("lenovo")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -759499589:
                    if (e2.equals(RomUtils.MANUFACTURER_XIAOMI)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -151542385:
                    if (e2.equals("motorola")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 120939:
                    if (e2.equals("zte")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 3003984:
                    if (e2.equals("asus")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3418016:
                    if (e2.equals(RomUtils.MANUFACTURER_OPPO)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3540212:
                    if (e2.equals("ssui")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 3620012:
                    if (e2.equals(RomUtils.MANUFACTURER_VIVO)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 103777484:
                    if (e2.equals("meizu")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 105170387:
                    if (e2.equals("nubia")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1864941562:
                    if (e2.equals(ManufacturerUtils.SAMSUNG)) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    bVar = this.f71320g;
                    bVar2 = new d.q.a.a.a.b.j.b(this.f71319f);
                    bVar.f71317c = bVar2;
                    break;
                case 2:
                    bVar = this.f71320g;
                    bVar2 = new e(this.f71319f);
                    bVar.f71317c = bVar2;
                    break;
                case 3:
                    this.f71320g.f71317c = new d.q.a.a.a.b.i.b(this.f71319f);
                    bVar3 = this.f71320g.f71317c;
                    ((d.q.a.a.a.b.i.b) bVar3).b("100215079");
                    break;
                case 4:
                    bVar = this.f71320g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
                case 5:
                case 6:
                    bVar = this.f71320g;
                    bVar2 = new g(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
                case 7:
                case '\b':
                    bVar = this.f71320g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
                case '\t':
                    bVar = this.f71320g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
                case '\n':
                    bVar = this.f71320g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
                case 11:
                    bVar = this.f71320g;
                    bVar2 = new d.q.a.a.a.b.f.b(this.f71319f);
                    bVar.f71317c = bVar2;
                    break;
                case '\f':
                case '\r':
                case 14:
                    bVar = this.f71320g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.f71319f, b.c());
                    bVar.f71317c = bVar2;
                    break;
            }
            bVar4 = this.f71320g.f71317c;
            if (bVar4 == null) {
                this.f71320g.a(false, null);
                return;
            }
            bVar5 = this.f71320g.f71317c;
            if (!bVar5.a()) {
                bVar8 = this.f71320g.f71317c;
                bVar8.a(b.c());
                return;
            }
            bVar6 = this.f71320g.f71317c;
            if (!bVar6.c()) {
                this.f71320g.a(false, null);
                return;
            }
            b bVar9 = this.f71320g;
            bVar7 = this.f71320g.f71317c;
            bVar9.a(true, bVar7);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
