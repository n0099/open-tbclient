package d.a.i0.a.i1.g.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.i0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f42823c;

    /* renamed from: d  reason: collision with root package name */
    public k f42824d;

    /* renamed from: e  reason: collision with root package name */
    public e f42825e;

    /* renamed from: f  reason: collision with root package name */
    public d f42826f;

    /* renamed from: g  reason: collision with root package name */
    public i f42827g;

    /* renamed from: h  reason: collision with root package name */
    public b f42828h;

    /* renamed from: i  reason: collision with root package name */
    public j f42829i;
    public h j;

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/video");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.i0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        char c2;
        boolean c3;
        d.a.i0.a.e0.d.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
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
                if (this.f42823c == null) {
                    this.f42823c = new c("/swanAPI/video/open");
                }
                c3 = this.f42823c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.f42824d == null) {
                    this.f42824d = new k("/swanAPI/video/update");
                }
                c3 = this.f42824d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.j == null) {
                    this.j = new h("/swanAPI/video/remove");
                }
                c3 = this.j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.f42825e == null) {
                    this.f42825e = new e("/swanAPI/video/play");
                }
                c3 = this.f42825e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.f42826f == null) {
                    this.f42826f = new d("/swanAPI/video/pause");
                }
                c3 = this.f42826f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.f42827g == null) {
                    this.f42827g = new i("/swanAPI/video/seek");
                }
                c3 = this.f42827g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.f42828h == null) {
                    this.f42828h = new b("/swanAPI/video/fullScreen");
                }
                c3 = this.f42828h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.f42829i == null) {
                    this.f42829i = new j("/swanAPI/video/sendDanmu");
                }
                c3 = this.f42829i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                c3 = false;
                break;
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
