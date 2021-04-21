package d.b.h0.a.l0.d;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.k0;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.l0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0752a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45805f;

        public RunnableC0752a(a aVar, Context context, String str) {
            this.f45804e = context;
            this.f45805f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f45804e, this.f45805f, 1).show();
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/publishThread");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f47009b) {
            Log.d("ExtCore-PublishThread", "handle: publishThread");
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        k0.X(new RunnableC0752a(this, context, a2.optString("data", "")));
        return true;
    }
}
