package d.b.g0.a.b1.g.d;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.t1.k.a0;
/* loaded from: classes2.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public c f43546c;

    /* renamed from: d  reason: collision with root package name */
    public k f43547d;

    /* renamed from: e  reason: collision with root package name */
    public e f43548e;

    /* renamed from: f  reason: collision with root package name */
    public d f43549f;

    /* renamed from: g  reason: collision with root package name */
    public i f43550g;

    /* renamed from: h  reason: collision with root package name */
    public b f43551h;
    public j i;
    public h j;

    public f(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/video");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.b.g0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.g0.a.r1.e eVar) {
        char c2;
        boolean c3;
        d.b.g0.a.c0.c.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
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
                if (this.f43546c == null) {
                    this.f43546c = new c("/swanAPI/video/open");
                }
                c3 = this.f43546c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 1:
                if (this.f43547d == null) {
                    this.f43547d = new k("/swanAPI/video/update");
                }
                c3 = this.f43547d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 2:
                if (this.j == null) {
                    this.j = new h("/swanAPI/video/remove");
                }
                c3 = this.j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 3:
                if (this.f43548e == null) {
                    this.f43548e = new e("/swanAPI/video/play");
                }
                c3 = this.f43548e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 4:
                if (this.f43549f == null) {
                    this.f43549f = new d("/swanAPI/video/pause");
                }
                c3 = this.f43549f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 5:
                if (this.f43550g == null) {
                    this.f43550g = new i("/swanAPI/video/seek");
                }
                c3 = this.f43550g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 6:
                if (this.f43551h == null) {
                    this.f43551h = new b("/swanAPI/video/fullScreen");
                }
                c3 = this.f43551h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            case 7:
                if (this.i == null) {
                    this.i = new j("/swanAPI/video/sendDanmu");
                }
                c3 = this.i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                break;
            default:
                c3 = false;
                break;
        }
        return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
