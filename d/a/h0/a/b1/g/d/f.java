package d.a.h0.a.b1.g.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f41550c;

    /* renamed from: d  reason: collision with root package name */
    public k f41551d;

    /* renamed from: e  reason: collision with root package name */
    public e f41552e;

    /* renamed from: f  reason: collision with root package name */
    public d f41553f;

    /* renamed from: g  reason: collision with root package name */
    public i f41554g;

    /* renamed from: h  reason: collision with root package name */
    public b f41555h;

    /* renamed from: i  reason: collision with root package name */
    public j f41556i;
    public h j;

    public f(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/video");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.h0.a.r1.e eVar) {
        char c2;
        boolean c3;
        d.a.h0.a.c0.c.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
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
                if (this.f41550c == null) {
                    this.f41550c = new c("/swanAPI/video/open");
                }
                c3 = this.f41550c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.f41551d == null) {
                    this.f41551d = new k("/swanAPI/video/update");
                }
                c3 = this.f41551d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.j == null) {
                    this.j = new h("/swanAPI/video/remove");
                }
                c3 = this.j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.f41552e == null) {
                    this.f41552e = new e("/swanAPI/video/play");
                }
                c3 = this.f41552e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.f41553f == null) {
                    this.f41553f = new d("/swanAPI/video/pause");
                }
                c3 = this.f41553f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.f41554g == null) {
                    this.f41554g = new i("/swanAPI/video/seek");
                }
                c3 = this.f41554g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.f41555h == null) {
                    this.f41555h = new b("/swanAPI/video/fullScreen");
                }
                c3 = this.f41555h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.f41556i == null) {
                    this.f41556i = new j("/swanAPI/video/sendDanmu");
                }
                c3 = this.f41556i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                c3 = false;
                break;
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
