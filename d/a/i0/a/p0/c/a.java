package d.a.i0.a.p0.c;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.a.p0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0781a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43836f;

        public RunnableC0781a(a aVar, Context context, String str) {
            this.f43835e = context;
            this.f43836f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f43835e, this.f43836f, 1).show();
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/publishThread");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("ExtCore-PublishThread", "handle: publishThread");
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        q0.b0(new RunnableC0781a(this, context, a2.optString("data", "")));
        return true;
    }
}
