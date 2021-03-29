package d.b.g0.a.d0.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f43825c;

    public a(j jVar) {
        super(jVar, "/swanAPI/setPhoneContact");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (context != null && callbackHandler != null && eVar != null) {
            if (eVar.Z()) {
                if (a0.f46288b) {
                    Log.d("SetPhoneContactAction", "SetPhoneContactAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (a0.f46288b) {
                Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
            }
            String optString = optParamsAsJo.optString("action");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            d.b.g0.a.d0.a a2 = d.b.g0.a.d0.a.a(optParamsAsJo);
            if (!a2.t()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            this.f43825c = optParamsAsJo.optString("cb");
            char c2 = 65535;
            int hashCode = optString.hashCode();
            if (hashCode != -1183792455) {
                if (hashCode == 3108362 && optString.equals("edit")) {
                    c2 = 1;
                }
            } else if (optString.equals("insert")) {
                c2 = 0;
            }
            if (c2 == 0) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                l(context, a2, callbackHandler);
                return true;
            } else if (c2 != 1) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                j(context, a2, callbackHandler);
                return true;
            }
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public final void j(Context context, d.b.g0.a.d0.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("name", aVar.d());
        intent.putExtra("email", aVar.r);
        intent.putParcelableArrayListExtra("data", k(aVar));
        intent.setFlags(268435456);
        m(context, intent, callbackHandler);
    }

    public final ArrayList<ContentValues> k(d.b.g0.a.d0.a aVar) {
        ArrayList<ContentValues> arrayList = new ArrayList<>(16);
        arrayList.add(aVar.j());
        arrayList.add(aVar.h());
        arrayList.add(aVar.s());
        arrayList.add(aVar.i());
        arrayList.add(aVar.g());
        arrayList.add(aVar.r());
        arrayList.add(aVar.k());
        arrayList.add(aVar.o());
        arrayList.add(aVar.n());
        arrayList.add(aVar.m());
        arrayList.add(aVar.l());
        arrayList.add(aVar.b());
        arrayList.add(aVar.p());
        arrayList.add(aVar.e());
        return arrayList;
    }

    public final void l(Context context, d.b.g0.a.d0.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        intent.putExtra("name", aVar.d());
        intent.putExtra("email", aVar.r);
        intent.putParcelableArrayListExtra("data", k(aVar));
        intent.setFlags(268435456);
        m(context, intent, callbackHandler);
    }

    public final void m(Context context, Intent intent, CallbackHandler callbackHandler) {
        try {
            context.startActivity(intent);
            if (TextUtils.isEmpty(this.f43825c)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.f43825c, UnitedSchemeUtility.wrapCallbackParams(0, "ok").toString());
        } catch (Exception e2) {
            if (a0.f46288b) {
                Log.d("SetPhoneContactAction", "startContactActivity:" + e2.toString());
            }
            if (TextUtils.isEmpty(this.f43825c)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.f43825c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
        }
    }
}
