package d.a.q0.a.i1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e0.d;
import d.a.q0.a.p.d.y;
import d.a.q0.a.v2.q0;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.c.b f48675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f48676f;

        /* renamed from: d.a.q0.a.i1.c.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0824a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48677e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48678f;

            public RunnableC0824a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48678f = aVar;
                this.f48677e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f48678f;
                    d.a.q0.a.i1.c.b bVar = aVar.f48675e;
                    bVar.f48655c = this.f48677e;
                    aVar.f48676f.J(bVar);
                }
            }
        }

        public a(b bVar, d.a.q0.a.i1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48675e = bVar2;
            this.f48676f = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new RunnableC0824a(this, str));
            }
        }
    }

    /* renamed from: d.a.q0.a.i1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0825b implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.c.b f48679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f48680f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48681g;

        /* renamed from: d.a.q0.a.i1.c.d.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48682e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0825b f48683f;

            public a(C0825b c0825b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0825b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48683f = c0825b;
                this.f48682e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0825b c0825b = this.f48683f;
                    d.a.q0.a.i1.c.b bVar = c0825b.f48679e;
                    bVar.f48655c = this.f48682e;
                    c0825b.f48680f.w(bVar, c0825b.f48681g);
                }
            }
        }

        public C0825b(b bVar, d.a.q0.a.i1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48679e = bVar2;
            this.f48680f = swanAppAudioPlayer;
            this.f48681g = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/audio");
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
                Log.d("AudioPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // d.a.q0.a.c2.f.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        SwanAppAudioPlayer k;
        char c2;
        boolean z;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("AudioPlayerAction", "handleSubAction subAction: " + str);
            }
            if (eVar.d0()) {
                if (a0.f46883b) {
                    Log.d("AudioPlayerAction", "AudioPlayerAction does not supported when app is invisible.");
                }
                int hashCode = str.hashCode();
                if (hashCode != 1726838360) {
                    if (hashCode == 1726864194 && str.equals("/swanAPI/audio/play")) {
                        c3 = 1;
                        if (c3 != 0) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        } else if (c3 == 1) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        }
                    }
                    c3 = 65535;
                    if (c3 != 0) {
                    }
                } else {
                    if (str.equals("/swanAPI/audio/open")) {
                        c3 = 0;
                        if (c3 != 0) {
                        }
                    }
                    c3 = 65535;
                    if (c3 != 0) {
                    }
                }
            }
            JSONObject j = j(unitedSchemeEntity.getParam("params"));
            if (j == null) {
                d.b("audio", "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (TextUtils.equals(str, "/swanAPI/audio/setInnerAudioOption")) {
                return m(j, eVar, unitedSchemeEntity, callbackHandler);
            } else {
                if (TextUtils.equals(str, "/swanAPI/audio/getAvailableAudioSources")) {
                    return l(unitedSchemeEntity, callbackHandler, eVar);
                }
                String optString = j.optString("audioId");
                if (TextUtils.equals(str, "/swanAPI/audio/open")) {
                    k = new SwanAppAudioPlayer(optString);
                } else {
                    k = k(optString);
                }
                if (k == null) {
                    d.b("audio", "player is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                d.a.q0.a.i1.c.b a2 = d.a.q0.a.i1.c.b.a(j, k.t());
                if (!a2.b()) {
                    d.b("audio", "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                if (a0.f46883b) {
                    Log.d("AudioPlayerAction", "subAction is : " + str);
                }
                switch (str.hashCode()) {
                    case 1726838360:
                        if (str.equals("/swanAPI/audio/open")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726864194:
                        if (str.equals("/swanAPI/audio/play")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726946950:
                        if (str.equals("/swanAPI/audio/seek")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726961680:
                        if (str.equals("/swanAPI/audio/stop")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1806024023:
                        if (str.equals("/swanAPI/audio/update")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1981190058:
                        if (str.equals("/swanAPI/audio/close")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1992873896:
                        if (str.equals("/swanAPI/audio/pause")) {
                            c2 = 3;
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
                        d.g("audio", "open, audio id:" + a2.f48653a);
                        n(context, callbackHandler, k, a2);
                        z = true;
                        break;
                    case 1:
                        d.g("audio", "update, audio id:" + a2.f48653a);
                        o(context, k, a2);
                        z = true;
                        break;
                    case 2:
                        d.g("audio", "play, audio id:" + a2.f48653a);
                        k.z();
                        z = true;
                        break;
                    case 3:
                        d.g("audio", "pause, audio id:" + a2.f48653a);
                        k.x();
                        z = true;
                        break;
                    case 4:
                        d.g("audio", "seek, audio id:" + a2.f48653a);
                        k.D(a2.f48660h);
                        z = true;
                        break;
                    case 5:
                        d.g("audio", "stop, audio id:" + a2.f48653a);
                        k.I();
                        z = true;
                        break;
                    case 6:
                        d.g("audio", "release, audio id:" + a2.f48653a);
                        k.B();
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (a0.f46883b) {
                        Log.d("AudioPlayerAction", Log.getStackTraceString(e2));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final SwanAppAudioPlayer k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                d.a.q0.a.i1.a e2 = d.a.q0.a.i1.b.e(str);
                if (e2 instanceof SwanAppAudioPlayer) {
                    return (SwanAppAudioPlayer) e2.i();
                }
            }
            return null;
        }
        return (SwanAppAudioPlayer) invokeL.objValue;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.b("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            jSONArray.put("mic");
            jSONArray.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER);
            jSONArray.put("voice_communication");
            jSONArray.put("voice_recognition");
            try {
                jSONObject.put("audioSources", jSONArray.toString());
                if (a0.f46883b) {
                    Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                if (a0.f46883b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(JSONObject jSONObject, d.a.q0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, jSONObject, eVar, unitedSchemeEntity, callbackHandler)) == null) {
            if (eVar == null) {
                d.b("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
                eVar.J().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (a0.f46883b) {
                    Log.d("AudioPlayerAction", "Audio Mix Changed to " + optBoolean);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } catch (Exception unused) {
                d.b("AudioPlayerAction", "set aiapps global var error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, d.a.q0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, swanAppAudioPlayer, bVar) == null) {
            y k = d.a.q0.a.c1.a.k();
            if (k != null && d.a.q0.a.k2.b.s(bVar.f48655c) == PathType.CLOUD) {
                k.b(context, bVar.f48655c, new C0825b(this, bVar, swanAppAudioPlayer, callbackHandler));
            } else {
                swanAppAudioPlayer.w(bVar, callbackHandler);
            }
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, d.a.q0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, swanAppAudioPlayer, bVar) == null) {
            if (TextUtils.isEmpty(bVar.f48655c) && d.a.q0.a.k2.b.s(bVar.f48655c) == PathType.CLOUD) {
                d.a.q0.a.c1.a.k().b(context, bVar.f48655c, new a(this, bVar, swanAppAudioPlayer));
            } else {
                swanAppAudioPlayer.J(bVar);
            }
        }
    }
}
