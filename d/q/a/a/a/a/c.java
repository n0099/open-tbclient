package d.q.a.a.a.a;

import android.content.Context;
import com.baidu.android.util.devices.RomUtils;
import com.yxcorp.kuaishou.addfp.a.b.f.g;
import d.q.a.a.c.b.e;
/* loaded from: classes7.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f67284e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ Context f67285f;

    /* renamed from: g  reason: collision with root package name */
    public /* synthetic */ b f67286g;

    public c(b bVar, a aVar, Context context) {
        this.f67286g = bVar;
        this.f67284e = aVar;
        this.f67285f = context;
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
            this.f67286g.f67281a = this.f67284e;
            String e2 = b.e(this.f67286g);
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
                    if (e2.equals(RomUtils.MANUFACTURER_MEIZU)) {
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
                    if (e2.equals("samsung")) {
                        c2 = '\n';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    bVar = this.f67286g;
                    bVar2 = new d.q.a.a.a.b.j.b(this.f67285f);
                    bVar.f67283c = bVar2;
                    break;
                case 2:
                    bVar = this.f67286g;
                    bVar2 = new e(this.f67285f);
                    bVar.f67283c = bVar2;
                    break;
                case 3:
                    this.f67286g.f67283c = new d.q.a.a.a.b.i.b(this.f67285f);
                    bVar3 = this.f67286g.f67283c;
                    ((d.q.a.a.a.b.i.b) bVar3).b("100215079");
                    break;
                case 4:
                    bVar = this.f67286g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
                case 5:
                case 6:
                    bVar = this.f67286g;
                    bVar2 = new g(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
                case 7:
                case '\b':
                    bVar = this.f67286g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
                case '\t':
                    bVar = this.f67286g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
                case '\n':
                    bVar = this.f67286g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
                case 11:
                    bVar = this.f67286g;
                    bVar2 = new d.q.a.a.a.b.f.b(this.f67285f);
                    bVar.f67283c = bVar2;
                    break;
                case '\f':
                case '\r':
                case 14:
                    bVar = this.f67286g;
                    bVar2 = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.f67285f, b.c());
                    bVar.f67283c = bVar2;
                    break;
            }
            bVar4 = this.f67286g.f67283c;
            if (bVar4 == null) {
                this.f67286g.a(false, null);
                return;
            }
            bVar5 = this.f67286g.f67283c;
            if (!bVar5.a()) {
                bVar8 = this.f67286g.f67283c;
                bVar8.a(b.c());
                return;
            }
            bVar6 = this.f67286g.f67283c;
            if (!bVar6.c()) {
                this.f67286g.a(false, null);
                return;
            }
            b bVar9 = this.f67286g;
            bVar7 = this.f67286g.f67283c;
            bVar9.a(true, bVar7);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
