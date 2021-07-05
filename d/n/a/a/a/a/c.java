package d.n.a.a.a.a;

import android.content.Context;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import com.yxcorp.kuaishou.addfp.a.b.f.g;
import d.n.a.a.c.b.e;
/* loaded from: classes10.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f75048e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ Context f75049f;

    /* renamed from: g  reason: collision with root package name */
    public /* synthetic */ b f75050g;

    public c(b bVar, a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75050g = bVar;
        this.f75048e = aVar;
        this.f75049f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        d.n.a.a.a.b.b bVar2;
        d.n.a.a.a.b.b bVar3;
        d.n.a.a.a.b.b bVar4;
        d.n.a.a.a.b.b bVar5;
        d.n.a.a.a.b.b bVar6;
        d.n.a.a.a.b.b bVar7;
        d.n.a.a.a.b.b bVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.f75050g.f75045a = this.f75048e;
                String e2 = b.e(this.f75050g);
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
                        bVar = this.f75050g;
                        bVar2 = new d.n.a.a.a.b.j.b(this.f75049f);
                        bVar.f75047c = bVar2;
                        break;
                    case 2:
                        bVar = this.f75050g;
                        bVar2 = new e(this.f75049f);
                        bVar.f75047c = bVar2;
                        break;
                    case 3:
                        this.f75050g.f75047c = new d.n.a.a.a.b.i.b(this.f75049f);
                        bVar3 = this.f75050g.f75047c;
                        ((d.n.a.a.a.b.i.b) bVar3).b("100215079");
                        break;
                    case 4:
                        bVar = this.f75050g;
                        bVar2 = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                    case 5:
                    case 6:
                        bVar = this.f75050g;
                        bVar2 = new g(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                    case 7:
                    case '\b':
                        bVar = this.f75050g;
                        bVar2 = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                    case '\t':
                        bVar = this.f75050g;
                        bVar2 = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                    case '\n':
                        bVar = this.f75050g;
                        bVar2 = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                    case 11:
                        bVar = this.f75050g;
                        bVar2 = new d.n.a.a.a.b.f.b(this.f75049f);
                        bVar.f75047c = bVar2;
                        break;
                    case '\f':
                    case '\r':
                    case 14:
                        bVar = this.f75050g;
                        bVar2 = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.f75049f, b.c());
                        bVar.f75047c = bVar2;
                        break;
                }
                bVar4 = this.f75050g.f75047c;
                if (bVar4 == null) {
                    this.f75050g.a(false, null);
                    return;
                }
                bVar5 = this.f75050g.f75047c;
                if (!bVar5.a()) {
                    bVar8 = this.f75050g.f75047c;
                    bVar8.a(b.c());
                    return;
                }
                bVar6 = this.f75050g.f75047c;
                if (!bVar6.c()) {
                    this.f75050g.a(false, null);
                    return;
                }
                b bVar9 = this.f75050g;
                bVar7 = this.f75050g.f75047c;
                bVar9.a(true, bVar7);
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }
}
