package d.a.h0.a.b1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.storage.PathType;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.k0;
import d.a.h0.a.p.c.q;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.c.b f41300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f41301f;

        /* renamed from: d.a.h0.a.b1.c.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0572a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41302e;

            public RunnableC0572a(String str) {
                this.f41302e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d.a.h0.a.b1.c.b bVar = aVar.f41300e;
                bVar.f41280c = this.f41302e;
                aVar.f41301f.K(bVar);
            }
        }

        public a(b bVar, d.a.h0.a.b1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
            this.f41300e = bVar2;
            this.f41301f = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            k0.X(new RunnableC0572a(str));
        }
    }

    /* renamed from: d.a.h0.a.b1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0573b implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.b1.c.b f41304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f41305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41306g;

        /* renamed from: d.a.h0.a.b1.c.d.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41307e;

            public a(String str) {
                this.f41307e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0573b c0573b = C0573b.this;
                d.a.h0.a.b1.c.b bVar = c0573b.f41304e;
                bVar.f41280c = this.f41307e;
                c0573b.f41305f.x(bVar, c0573b.f41306g);
            }
        }

        public C0573b(b bVar, d.a.h0.a.b1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            this.f41304e = bVar2;
            this.f41305f = swanAppAudioPlayer;
            this.f41306g = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            k0.X(new a(str));
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/audio");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            Log.d("AudioPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    @Override // d.a.h0.a.t1.k.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        SwanAppAudioPlayer k;
        char c2;
        boolean z;
        char c3;
        if (a0.f44398b) {
            Log.d("AudioPlayerAction", "handleSubAction subAction: " + str);
        }
        if (eVar.Z()) {
            if (a0.f44398b) {
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
            c.b(MediaStreamTrack.AUDIO_TRACK_KIND, "object is null");
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
                c.b(MediaStreamTrack.AUDIO_TRACK_KIND, "player is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.a.h0.a.b1.c.b a2 = d.a.h0.a.b1.c.b.a(j, k.t());
            if (!a2.b()) {
                c.b(MediaStreamTrack.AUDIO_TRACK_KIND, "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            if (a0.f44398b) {
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
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "open, audio id:" + a2.f41278a);
                    n(context, callbackHandler, k, a2);
                    z = true;
                    break;
                case 1:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "update, audio id:" + a2.f41278a);
                    o(context, k, a2);
                    z = true;
                    break;
                case 2:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "play, audio id:" + a2.f41278a);
                    k.A();
                    z = true;
                    break;
                case 3:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "pause, audio id:" + a2.f41278a);
                    k.y();
                    z = true;
                    break;
                case 4:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "seek, audio id:" + a2.f41278a);
                    k.E(a2.f41285h);
                    z = true;
                    break;
                case 5:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "stop, audio id:" + a2.f41278a);
                    k.J();
                    z = true;
                    break;
                case 6:
                    c.g(MediaStreamTrack.AUDIO_TRACK_KIND, "release, audio id:" + a2.f41278a);
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
                if (a0.f44398b) {
                    Log.d("AudioPlayerAction", Log.getStackTraceString(e2));
                }
            }
        }
        return null;
    }

    public final SwanAppAudioPlayer k(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.a.h0.a.b1.a e2 = d.a.h0.a.b1.b.e(str);
            if (e2 instanceof SwanAppAudioPlayer) {
                return (SwanAppAudioPlayer) e2.d();
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
        jSONArray.put(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        jSONArray.put("mic");
        jSONArray.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER);
        jSONArray.put("voice_communication");
        jSONArray.put("voice_recognition");
        try {
            jSONObject.put("audioSources", jSONArray.toString());
            if (a0.f44398b) {
                Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e2) {
            if (a0.f44398b) {
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
            if (a0.f44398b) {
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

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, d.a.h0.a.b1.c.b bVar) {
        q j = d.a.h0.a.w0.a.j();
        if (j != null && d.a.h0.a.a2.b.c(bVar.f41280c) == PathType.CLOUD) {
            j.a(context, bVar.f41280c, new C0573b(this, bVar, swanAppAudioPlayer, callbackHandler));
        } else {
            swanAppAudioPlayer.x(bVar, callbackHandler);
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, d.a.h0.a.b1.c.b bVar) {
        if (TextUtils.isEmpty(bVar.f41280c) && d.a.h0.a.a2.b.c(bVar.f41280c) == PathType.CLOUD) {
            d.a.h0.a.w0.a.j().a(context, bVar.f41280c, new a(this, bVar, swanAppAudioPlayer));
        } else {
            swanAppAudioPlayer.K(bVar);
        }
    }
}
