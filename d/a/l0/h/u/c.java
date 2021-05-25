package d.a.l0.h.u;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f47697a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f47698b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47699c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47700d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f47701e;

    /* renamed from: f  reason: collision with root package name */
    public String f47702f;

    public boolean a(d.a.l0.a.y.b.a aVar) throws JSTypeMismatchException {
        try {
            this.f47697a = aVar.C("defaultValue");
            this.f47698b = aVar.r("maxLength");
            this.f47699c = aVar.m("multiple");
            this.f47700d = aVar.m("confirmHold");
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
                this.f47701e = 6;
                this.f47702f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else if (c2 == 1) {
                this.f47701e = 5;
                this.f47702f = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
            } else if (c2 == 2) {
                this.f47701e = 3;
                this.f47702f = "search";
            } else if (c2 == 3) {
                this.f47701e = 2;
                this.f47702f = "go";
            } else if (c2 != 4) {
                this.f47701e = 6;
                this.f47702f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else {
                this.f47701e = 4;
                this.f47702f = "send";
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
