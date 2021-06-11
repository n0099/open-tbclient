package d.a.l0.h.u;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f51371a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f51372b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51373c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51374d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f51375e;

    /* renamed from: f  reason: collision with root package name */
    public String f51376f;

    public boolean a(d.a.l0.a.y.b.a aVar) throws JSTypeMismatchException {
        try {
            this.f51371a = aVar.C("defaultValue");
            this.f51372b = aVar.r("maxLength");
            this.f51373c = aVar.m("multiple");
            this.f51374d = aVar.m("confirmHold");
            String C = aVar.C("confirmType");
            char c2 = 65535;
            switch (C.hashCode()) {
                case -906336856:
                    if (C.equals("search")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3304:
                    if (C.equals("go")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (C.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3377907:
                    if (C.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3526536:
                    if (C.equals("send")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.f51375e = 6;
                this.f51376f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else if (c2 == 1) {
                this.f51375e = 5;
                this.f51376f = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
            } else if (c2 == 2) {
                this.f51375e = 3;
                this.f51376f = "search";
            } else if (c2 == 3) {
                this.f51375e = 2;
                this.f51376f = "go";
            } else if (c2 != 4) {
                this.f51375e = 6;
                this.f51376f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else {
                this.f51375e = 4;
                this.f51376f = "send";
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
