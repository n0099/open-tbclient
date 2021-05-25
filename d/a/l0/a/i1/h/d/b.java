package d.a.l0.a.i1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public a f43013c;

    /* renamed from: d  reason: collision with root package name */
    public e f43014d;

    /* renamed from: e  reason: collision with root package name */
    public d f43015e;

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/vrvideo");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.a("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        char c2;
        boolean c3;
        d.a.l0.a.e0.d.a("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", a0.a(unitedSchemeEntity, "params"));
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
            if (this.f43013c == null) {
                this.f43013c = new a("/swanAPI/vrvideo/open");
            }
            c3 = this.f43013c.c(context, unitedSchemeEntity, callbackHandler, eVar);
        } else if (c2 == 1) {
            if (this.f43014d == null) {
                this.f43014d = new e("/swanAPI/vrvideo/update");
            }
            c3 = this.f43014d.c(context, unitedSchemeEntity, callbackHandler, eVar);
        } else if (c2 != 2) {
            c3 = false;
        } else {
            if (this.f43015e == null) {
                this.f43015e = new d("/swanAPI/vrvideo/remove");
            }
            c3 = this.f43015e.c(context, unitedSchemeEntity, callbackHandler, eVar);
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
