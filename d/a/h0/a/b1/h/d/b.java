package d.a.h0.a.b1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public a f41566c;

    /* renamed from: d  reason: collision with root package name */
    public e f41567d;

    /* renamed from: e  reason: collision with root package name */
    public d f41568e;

    public b(j jVar) {
        super(jVar, "/swanAPI/vrvideo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.a("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
        return false;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.h0.a.r1.e eVar) {
        char c2;
        boolean c3;
        d.a.h0.a.c0.c.a("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", a0.a(unitedSchemeEntity, "params"));
        int hashCode = str.hashCode();
        if (hashCode == 533456719) {
            if (str.equals("/swanAPI/vrvideo/open")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 1626770505) {
            if (hashCode == 1722535054 && str.equals("/swanAPI/vrvideo/update")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("/swanAPI/vrvideo/remove")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            if (this.f41566c == null) {
                this.f41566c = new a("/swanAPI/vrvideo/open");
            }
            c3 = this.f41566c.c(context, unitedSchemeEntity, callbackHandler, eVar);
        } else if (c2 == 1) {
            if (this.f41567d == null) {
                this.f41567d = new e("/swanAPI/vrvideo/update");
            }
            c3 = this.f41567d.c(context, unitedSchemeEntity, callbackHandler, eVar);
        } else if (c2 != 2) {
            c3 = false;
        } else {
            if (this.f41568e == null) {
                this.f41568e = new d("/swanAPI/vrvideo/remove");
            }
            c3 = this.f41568e.c(context, unitedSchemeEntity, callbackHandler, eVar);
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
