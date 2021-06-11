package d.a.l0.a.i1.g.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f46673c;

    /* renamed from: d  reason: collision with root package name */
    public k f46674d;

    /* renamed from: e  reason: collision with root package name */
    public e f46675e;

    /* renamed from: f  reason: collision with root package name */
    public d f46676f;

    /* renamed from: g  reason: collision with root package name */
    public i f46677g;

    /* renamed from: h  reason: collision with root package name */
    public b f46678h;

    /* renamed from: i  reason: collision with root package name */
    public j f46679i;
    public h j;

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/video");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        char c2;
        boolean c3;
        d.a.l0.a.e0.d.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
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
                if (this.f46673c == null) {
                    this.f46673c = new c("/swanAPI/video/open");
                }
                c3 = this.f46673c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.f46674d == null) {
                    this.f46674d = new k("/swanAPI/video/update");
                }
                c3 = this.f46674d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.j == null) {
                    this.j = new h("/swanAPI/video/remove");
                }
                c3 = this.j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.f46675e == null) {
                    this.f46675e = new e("/swanAPI/video/play");
                }
                c3 = this.f46675e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.f46676f == null) {
                    this.f46676f = new d("/swanAPI/video/pause");
                }
                c3 = this.f46676f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.f46677g == null) {
                    this.f46677g = new i("/swanAPI/video/seek");
                }
                c3 = this.f46677g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.f46678h == null) {
                    this.f46678h = new b("/swanAPI/video/fullScreen");
                }
                c3 = this.f46678h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.f46679i == null) {
                    this.f46679i = new j("/swanAPI/video/sendDanmu");
                }
                c3 = this.f46679i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                c3 = false;
                break;
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
