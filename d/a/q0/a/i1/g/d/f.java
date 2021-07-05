package d.a.q0.a.i1.g.d;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
/* loaded from: classes8.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f48931c;

    /* renamed from: d  reason: collision with root package name */
    public k f48932d;

    /* renamed from: e  reason: collision with root package name */
    public e f48933e;

    /* renamed from: f  reason: collision with root package name */
    public d f48934f;

    /* renamed from: g  reason: collision with root package name */
    public i f48935g;

    /* renamed from: h  reason: collision with root package name */
    public b f48936h;

    /* renamed from: i  reason: collision with root package name */
    public j f48937i;
    public h j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/video");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.q0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        char c2;
        boolean c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            d.a.q0.a.e0.d.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
            switch (str.hashCode()) {
                case -1701478259:
                    if (str.equals("/swanAPI/video/pause")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440375597:
                    if (str.equals("/swanAPI/video/open")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440349763:
                    if (str.equals("/swanAPI/video/play")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440267007:
                    if (str.equals("/swanAPI/video/seek")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1145507635:
                    if (str.equals("/swanAPI/video/remove")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1049743086:
                    if (str.equals("/swanAPI/video/update")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -274000988:
                    if (str.equals("/swanAPI/video/fullScreen")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 711122280:
                    if (str.equals("/swanAPI/video/sendDanmu")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (this.f48931c == null) {
                        this.f48931c = new c("/swanAPI/video/open");
                    }
                    c3 = this.f48931c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 1:
                    if (this.f48932d == null) {
                        this.f48932d = new k("/swanAPI/video/update");
                    }
                    c3 = this.f48932d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 2:
                    if (this.j == null) {
                        this.j = new h("/swanAPI/video/remove");
                    }
                    c3 = this.j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 3:
                    if (this.f48933e == null) {
                        this.f48933e = new e("/swanAPI/video/play");
                    }
                    c3 = this.f48933e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 4:
                    if (this.f48934f == null) {
                        this.f48934f = new d("/swanAPI/video/pause");
                    }
                    c3 = this.f48934f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 5:
                    if (this.f48935g == null) {
                        this.f48935g = new i("/swanAPI/video/seek");
                    }
                    c3 = this.f48935g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 6:
                    if (this.f48936h == null) {
                        this.f48936h = new b("/swanAPI/video/fullScreen");
                    }
                    c3 = this.f48936h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 7:
                    if (this.f48937i == null) {
                        this.f48937i = new j("/swanAPI/video/sendDanmu");
                    }
                    c3 = this.f48937i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                default:
                    c3 = false;
                    break;
            }
            return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        return invokeLLLLL.booleanValue;
    }
}
