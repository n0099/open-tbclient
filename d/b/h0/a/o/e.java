package d.b.h0.a.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.o.b f46130c;

    /* loaded from: classes2.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f46131a;

        public a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f46131a = unitedSchemeEntity;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d {
        public b(e eVar, CallbackHandler callbackHandler, String str) {
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/rewardedVideoAd");
        this.f46130c = null;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        String optString = a2.optString("cb");
        String optString2 = a2.optString("action");
        b bVar = new b(this, callbackHandler, optString);
        a aVar = new a(this, unitedSchemeEntity, callbackHandler);
        if (this.f46130c == null) {
            d.b.h0.a.o.b b2 = d.b.h0.a.w0.a.b().b(a2, bVar, aVar);
            this.f46130c = b2;
            if (b2 == null) {
                this.f46130c = new d.b.h0.a.o.a();
            }
        }
        if (TextUtils.equals(optString2, "show")) {
            this.f46130c.a(a2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, TrackLoadSettingsAtom.TYPE)) {
            this.f46130c.b(a2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }
}
