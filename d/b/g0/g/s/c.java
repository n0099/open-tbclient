package d.b.g0.g.s;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48563a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f48564b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48565c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48566d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f48567e;

    /* renamed from: f  reason: collision with root package name */
    public String f48568f;

    public boolean a(d.b.g0.g.e.d.c cVar) throws JSTypeMismatchException {
        try {
            this.f48563a = cVar.B("defaultValue");
            this.f48564b = cVar.r("maxLength");
            this.f48565c = cVar.m("multiple");
            this.f48566d = cVar.m("confirmHold");
            String B = cVar.B("confirmType");
            char c2 = 65535;
            switch (B.hashCode()) {
                case -906336856:
                    if (B.equals("search")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3304:
                    if (B.equals("go")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (B.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3377907:
                    if (B.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3526536:
                    if (B.equals("send")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.f48567e = 6;
                this.f48568f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else if (c2 == 1) {
                this.f48567e = 5;
                this.f48568f = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
            } else if (c2 == 2) {
                this.f48567e = 3;
                this.f48568f = "search";
            } else if (c2 == 3) {
                this.f48567e = 2;
                this.f48568f = "go";
            } else if (c2 != 4) {
                this.f48567e = 6;
                this.f48568f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
            } else {
                this.f48567e = 4;
                this.f48568f = "send";
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
