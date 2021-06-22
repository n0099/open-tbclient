package d.a.m0.h.u;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f51479a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f51480b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51481c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51482d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f51483e;

    /* renamed from: f  reason: collision with root package name */
    public String f51484f;

    public boolean a(d.a.m0.a.y.b.a aVar) throws JSTypeMismatchException {
        try {
            this.f51479a = aVar.C("defaultValue");
            this.f51480b = aVar.r("maxLength");
            this.f51481c = aVar.m("multiple");
            this.f51482d = aVar.m("confirmHold");
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
                this.f51483e = 6;
                this.f51484f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else if (c2 == 1) {
                this.f51483e = 5;
                this.f51484f = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
            } else if (c2 == 2) {
                this.f51483e = 3;
                this.f51484f = "search";
            } else if (c2 == 3) {
                this.f51483e = 2;
                this.f51484f = "go";
            } else if (c2 != 4) {
                this.f51483e = 6;
                this.f51484f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else {
                this.f51483e = 4;
                this.f51484f = "send";
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
