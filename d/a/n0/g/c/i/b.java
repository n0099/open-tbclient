package d.a.n0.g.c.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.n0.a.j2.p.e;
import d.a.n0.a.j2.p.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String v;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2136141294:
                    if (str.equals("notifyInstall")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -1996849701:
                    if (str.equals("installHijack")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case -1903789791:
                    if (str.equals("continueClick")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -1768725569:
                    if (str.equals("notifyClick")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -1263222921:
                    if (str.equals("openApp")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1165168761:
                    if (str.equals("notifyList")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case -1164961306:
                    if (str.equals("notifyShow")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -625158317:
                    if (str.equals("deleteDownload")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -606050596:
                    if (str.equals("resumeAllDownload")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -567202649:
                    if (str.equals("continue")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -451216226:
                    if (str.equals("pauseDownload")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -263045656:
                    if (str.equals("installSuccess")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 66344735:
                    if (str.equals("authorizeClick")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 184711125:
                    if (str.equals("resumeDownload")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 388113743:
                    if (str.equals("overTwoDays")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 900412038:
                    if (str.equals("installApp")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1475610601:
                    if (str.equals("authorize")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1554935562:
                    if (str.equals("startDownload")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return "start";
                case 1:
                    return "pause";
                case 2:
                    return "resume";
                case 3:
                    return QueryResponse.Options.CANCEL;
                case 4:
                    return "install";
                case 5:
                    return "open";
                case 6:
                    return "continue";
                case 7:
                    return "authorize";
                case '\b':
                    return AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE;
                case '\t':
                    return "authorizeclick";
                case '\n':
                    return "guideclick";
                case 11:
                    return "notifyshow";
                case '\f':
                    return "notifyclick";
                case '\r':
                    return "notifyinstall";
                case 14:
                    return "notifylist";
                case 15:
                    return "installsuccess";
                case 16:
                    return "overtwodays";
                case 17:
                    return "installhijack";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.n0.a.j2.p.f, d.a.n0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.k = d.a.n0.a.m2.b.e(TextUtils.equals(this.f45817a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
            this.n = SwanAppNetworkUtils.f().type;
            if (this.f45824h == null) {
                this.f45824h = new JSONObject();
            }
            try {
                this.f45824h.put("host", d.a.n0.a.c1.a.m().a());
                this.f45824h.put(AsInstallService.SCHEME_PACKAGE_ADDED, this.v);
            } catch (JSONException e2) {
                if (e.j) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (e.j) {
            Log.d("SwanAppUBCEvent", "setCommonData: " + aVar.a());
        }
        this.f45817a = aVar.f49687a;
        this.f45822f = aVar.f49689c;
        this.f45819c = aVar.f49688b;
        this.o = aVar.f49692f;
        this.p = aVar.f49693g;
        this.s = aVar.f49694h;
        this.u = aVar.f49695i;
        this.l = aVar.f49690d;
        this.m = aVar.f49691e;
    }
}
