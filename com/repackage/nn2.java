package com.repackage;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nn2 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements bf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;
        public final /* synthetic */ SwanAppAudioPlayer b;

        /* renamed from: com.repackage.nn2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0536a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public RunnableC0536a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    jn2 jn2Var = aVar.a;
                    jn2Var.c = this.a;
                    aVar.b.update(jn2Var);
                }
            }
        }

        public a(nn2 nn2Var, jn2 jn2Var, SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nn2Var, jn2Var, swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn2Var;
            this.b = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    o73.b("audio", 3001, "cloud url is null", -1, "");
                }
                ce3.e0(new RunnableC0536a(this, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;
        public final /* synthetic */ SwanAppAudioPlayer b;
        public final /* synthetic */ CallbackHandler c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    jn2 jn2Var = bVar.a;
                    jn2Var.c = this.a;
                    bVar.b.x(jn2Var, bVar.c);
                }
            }
        }

        public b(nn2 nn2Var, jn2 jn2Var, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nn2Var, jn2Var, swanAppAudioPlayer, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn2Var;
            this.b = swanAppAudioPlayer;
            this.c = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    o73.b("audio", 3001, "cloud url is null", -1, "");
                }
                ce3.e0(new a(this, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nn2(f13 f13Var) {
        super(f13Var, "/swanAPI/audio");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.f23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (unitedSchemeEntity != null) {
                ln2.b("AudioPlayerAction", "#handle entity.uri=" + unitedSchemeEntity.getUri());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[ADDED_TO_REGION] */
    @Override // com.repackage.f23
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, i03 i03Var) {
        InterceptResult invokeLLLLL;
        SwanAppAudioPlayer k;
        char c;
        boolean z;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, i03Var)) == null) {
            ln2.b("AudioPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            if (i03Var.n0()) {
                if (f23.b) {
                    Log.d("AudioPlayerAction", "AudioPlayerAction does not supported when app is invisible.");
                }
                int hashCode = str.hashCode();
                if (hashCode != 1726838360) {
                    if (hashCode == 1726864194 && str.equals("/swanAPI/audio/play")) {
                        c2 = 1;
                        if (c2 != 0 || c2 == 1) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        }
                    }
                    c2 = 65535;
                    if (c2 != 0) {
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                if (str.equals("/swanAPI/audio/open")) {
                    c2 = 0;
                    if (c2 != 0) {
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject j = j(unitedSchemeEntity.getParam("params"));
            if (j == null) {
                o73.b("audio", 1001, "param is null", 201, "param is null");
                ix1.c("audio", "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (TextUtils.equals(str, "/swanAPI/audio/setInnerAudioOption")) {
                return m(j, i03Var, unitedSchemeEntity, callbackHandler);
            } else {
                if (TextUtils.equals(str, "/swanAPI/audio/getAvailableAudioSources")) {
                    return l(unitedSchemeEntity, callbackHandler, i03Var);
                }
                String optString = j.optString("audioId");
                if (TextUtils.equals(str, "/swanAPI/audio/open")) {
                    k = new SwanAppAudioPlayer(optString);
                } else {
                    k = k(optString);
                }
                if (k == null) {
                    o73.b("audio", 2001, "player is null", 201, "player is null");
                    ix1.c("audio", "player is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                jn2 a2 = jn2.a(j, k.u());
                if (!a2.b()) {
                    o73.b("audio", 2001, "param is invalid", 201, "param is invalid");
                    ix1.c("audio", "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                switch (str.hashCode()) {
                    case 1726838360:
                        if (str.equals("/swanAPI/audio/open")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1726864194:
                        if (str.equals("/swanAPI/audio/play")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1726946950:
                        if (str.equals("/swanAPI/audio/seek")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1726961680:
                        if (str.equals("/swanAPI/audio/stop")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1806024023:
                        if (str.equals("/swanAPI/audio/update")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1981190058:
                        if (str.equals("/swanAPI/audio/close")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1992873896:
                        if (str.equals("/swanAPI/audio/pause")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        ix1.i("audio", "open, audio id:" + a2.a);
                        n(context, callbackHandler, k, a2);
                        z = true;
                        break;
                    case 1:
                        ix1.i("audio", "update, audio id:" + a2.a);
                        o(context, k, a2);
                        z = true;
                        break;
                    case 2:
                        ix1.i("audio", "play, audio id:" + a2.a);
                        k.A();
                        z = true;
                        break;
                    case 3:
                        ix1.i("audio", "pause, audio id:" + a2.a);
                        k.y();
                        z = true;
                        break;
                    case 4:
                        ix1.i("audio", "seek, audio id:" + a2.a);
                        k.E(a2.h);
                        z = true;
                        break;
                    case 5:
                        ix1.i("audio", "stop, audio id:" + a2.a);
                        k.J();
                        z = true;
                        break;
                    case 6:
                        ix1.i("audio", "release, audio id:" + a2.a);
                        k.C();
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                ln2.b("AudioPlayerAction", "#handleSubAction invokeSuccess=" + z);
                if (z) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                return super.i(context, unitedSchemeEntity, callbackHandler, str, i03Var);
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
                } catch (JSONException e) {
                    if (f23.b) {
                        Log.d("AudioPlayerAction", Log.getStackTraceString(e));
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
                gn2 e = hn2.e(str);
                if (e instanceof SwanAppAudioPlayer) {
                    return (SwanAppAudioPlayer) e.i();
                }
            }
            return null;
        }
        return (SwanAppAudioPlayer) invokeL.objValue;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (i03Var == null) {
                ix1.c("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("auto");
            jSONArray.put("mic");
            jSONArray.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER);
            jSONArray.put("voice_communication");
            jSONArray.put("voice_recognition");
            try {
                jSONObject.put("audioSources", jSONArray.toString());
                if (f23.b) {
                    Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e) {
                if (f23.b) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(JSONObject jSONObject, i03 i03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, jSONObject, i03Var, unitedSchemeEntity, callbackHandler)) == null) {
            if (i03Var == null) {
                ix1.c("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
                i03Var.U().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (f23.b) {
                    Log.d("AudioPlayerAction", "Audio Mix Changed to " + optBoolean);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } catch (Exception unused) {
                ix1.c("AudioPlayerAction", "set aiapps global var error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, jn2 jn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, swanAppAudioPlayer, jn2Var) == null) {
            qk1 l = pj2.l();
            if (l != null && q73.s(jn2Var.c) == PathType.CLOUD) {
                l.b(context, jn2Var.c, new b(this, jn2Var, swanAppAudioPlayer, callbackHandler));
            } else {
                swanAppAudioPlayer.x(jn2Var, callbackHandler);
            }
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, jn2 jn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, swanAppAudioPlayer, jn2Var) == null) {
            if (TextUtils.isEmpty(jn2Var.c) && q73.s(jn2Var.c) == PathType.CLOUD) {
                pj2.l().b(context, jn2Var.c, new a(this, jn2Var, swanAppAudioPlayer));
            } else {
                swanAppAudioPlayer.update(jn2Var);
            }
        }
    }
}
