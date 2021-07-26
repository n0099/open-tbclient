package d.a.o0.h.u;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50827a;

    /* renamed from: b  reason: collision with root package name */
    public int f50828b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50829c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50830d;

    /* renamed from: e  reason: collision with root package name */
    public int f50831e;

    /* renamed from: f  reason: collision with root package name */
    public String f50832f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50827a = "";
        this.f50828b = Integer.MAX_VALUE;
        this.f50829c = false;
        this.f50830d = false;
    }

    public boolean a(d.a.o0.a.y.b.a aVar) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            try {
                this.f50827a = aVar.C("defaultValue");
                this.f50828b = aVar.r("maxLength");
                this.f50829c = aVar.m("multiple");
                this.f50830d = aVar.m("confirmHold");
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
                    this.f50831e = 6;
                    this.f50832f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                } else if (c2 == 1) {
                    this.f50831e = 5;
                    this.f50832f = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                } else if (c2 == 2) {
                    this.f50831e = 3;
                    this.f50832f = "search";
                } else if (c2 == 3) {
                    this.f50831e = 2;
                    this.f50832f = "go";
                } else if (c2 != 4) {
                    this.f50831e = 6;
                    this.f50832f = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                } else {
                    this.f50831e = 4;
                    this.f50832f = "send";
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
