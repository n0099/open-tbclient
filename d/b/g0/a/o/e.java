package d.b.g0.a.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.o.b f45408c;

    /* loaded from: classes3.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f45409a;

        public a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45409a = unitedSchemeEntity;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d {
        public b(e eVar, CallbackHandler callbackHandler, String str) {
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/rewardedVideoAd");
        this.f45408c = null;
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46287b) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        String optString = a2.optString("cb");
        String optString2 = a2.optString("action");
        b bVar = new b(this, callbackHandler, optString);
        a aVar = new a(this, unitedSchemeEntity, callbackHandler);
        if (this.f45408c == null) {
            d.b.g0.a.o.b b2 = d.b.g0.a.w0.a.b().b(a2, bVar, aVar);
            this.f45408c = b2;
            if (b2 == null) {
                this.f45408c = new d.b.g0.a.o.a();
            }
        }
        if (TextUtils.equals(optString2, "show")) {
            this.f45408c.a(a2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, TrackLoadSettingsAtom.TYPE)) {
            this.f45408c.b(a2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }
}
