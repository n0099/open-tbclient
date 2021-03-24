package d.b.g0.a.b1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.storage.PathType;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.k0;
import d.b.g0.a.p.c.q;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.c.b f43305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f43306f;

        /* renamed from: d.b.g0.a.b1.c.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0600a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43307e;

            public RunnableC0600a(String str) {
                this.f43307e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.b.g0.a.b1.c.b bVar = aVar.f43305e;
                bVar.f43287c = this.f43307e;
                aVar.f43306f.K(bVar);
            }
        }

        public a(b bVar, d.b.g0.a.b1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
            this.f43305e = bVar2;
            this.f43306f = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            k0.X(new RunnableC0600a(str));
        }
    }

    /* renamed from: d.b.g0.a.b1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0601b implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.c.b f43309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f43310f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43311g;

        /* renamed from: d.b.g0.a.b1.c.d.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43312e;

            public a(String str) {
                this.f43312e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0601b c0601b = C0601b.this;
                d.b.g0.a.b1.c.b bVar = c0601b.f43309e;
                bVar.f43287c = this.f43312e;
                c0601b.f43310f.x(bVar, c0601b.f43311g);
            }
        }

        public C0601b(b bVar, d.b.g0.a.b1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            this.f43309e = bVar2;
            this.f43310f = swanAppAudioPlayer;
            this.f43311g = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            k0.X(new a(str));
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/audio");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46287b) {
            Log.d("AudioPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    @Override // d.b.g0.a.t1.k.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        SwanAppAudioPlayer k;
        char c2;
        boolean z;
        char c3;
        if (a0.f46287b) {
            Log.d("AudioPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar.Z()) {
            if (a0.f46287b) {
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
            c.b("audio", "object is null");
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
                c.b("audio", "player is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.b.g0.a.b1.c.b a2 = d.b.g0.a.b1.c.b.a(j, k.t());
            if (!a2.b()) {
                c.b("audio", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            if (a0.f46287b) {
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
                    c.g("audio", "open, audio id:" + a2.f43285a);
                    n(context, callbackHandler, k, a2);
                    z = true;
                    break;
                case 1:
                    c.g("audio", "update, audio id:" + a2.f43285a);
                    o(context, k, a2);
                    z = true;
                    break;
                case 2:
                    c.g("audio", "play, audio id:" + a2.f43285a);
                    k.A();
                    z = true;
                    break;
                case 3:
                    c.g("audio", "pause, audio id:" + a2.f43285a);
                    k.y();
                    z = true;
                    break;
                case 4:
                    c.g("audio", "seek, audio id:" + a2.f43285a);
                    k.E(a2.f43292h);
                    z = true;
                    break;
                case 5:
                    c.g("audio", "stop, audio id:" + a2.f43285a);
                    k.J();
                    z = true;
                    break;
                case 6:
                    c.g("audio", "release, audio id:" + a2.f43285a);
                    k.C();
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

    public final JSONObject j(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (a0.f46287b) {
                    Log.d("AudioPlayerAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }

    public final SwanAppAudioPlayer k(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.b.g0.a.b1.a e2 = d.b.g0.a.b1.b.e(str);
            if (e2 instanceof SwanAppAudioPlayer) {
                return (SwanAppAudioPlayer) e2.a();
            }
        }
        return null;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.b("AudioPlayerAction", "aiapp or entity is null");
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
            if (a0.f46287b) {
                Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e2) {
            if (a0.f46287b) {
                e2.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public final boolean m(JSONObject jSONObject, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (eVar == null) {
            c.b("AudioPlayerAction", "aiapp or entity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
            eVar.H().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
            if (a0.f46287b) {
                Log.d("AudioPlayerAction", "Audio Mix Changed to " + optBoolean);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } catch (Exception unused) {
            c.b("AudioPlayerAction", "set aiapps global var error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, d.b.g0.a.b1.c.b bVar) {
        q j = d.b.g0.a.w0.a.j();
        if (j != null && d.b.g0.a.a2.b.c(bVar.f43287c) == PathType.CLOUD) {
            j.a(context, bVar.f43287c, new C0601b(this, bVar, swanAppAudioPlayer, callbackHandler));
        } else {
            swanAppAudioPlayer.x(bVar, callbackHandler);
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, d.b.g0.a.b1.c.b bVar) {
        if (TextUtils.isEmpty(bVar.f43287c) && d.b.g0.a.a2.b.c(bVar.f43287c) == PathType.CLOUD) {
            d.b.g0.a.w0.a.j().a(context, bVar.f43287c, new a(this, bVar, swanAppAudioPlayer));
        } else {
            swanAppAudioPlayer.K(bVar);
        }
    }
}
