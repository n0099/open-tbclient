package d.a.l0.a.p0.c;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.p0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0792a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44012f;

        public RunnableC0792a(a aVar, Context context, String str) {
            this.f44011e = context;
            this.f44012f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f44011e, this.f44012f, 1).show();
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/publishThread");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("ExtCore-PublishThread", "handle: publishThread");
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        q0.b0(new RunnableC0792a(this, context, a2.optString("data", "")));
        return true;
    }
}
