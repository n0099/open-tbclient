package d.a.l0.a.f0.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f41807c;

    public b(e eVar) {
        super(eVar, "/swanAPI/setPhoneContact");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (context != null && callbackHandler != null && eVar != null) {
            if (eVar.d0()) {
                if (a0.f40949b) {
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
            if (a0.f40949b) {
                Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
            }
            String optString = optParamsAsJo.optString("action");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            d.a.l0.a.f0.a a2 = d.a.l0.a.f0.a.a(optParamsAsJo);
            if (!a2.t()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            this.f41807c = optParamsAsJo.optString("cb");
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

    public final void j(Context context, d.a.l0.a.f0.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("name", aVar.d());
        intent.putExtra("email", aVar.r);
        intent.putParcelableArrayListExtra("data", k(aVar));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        m(context, intent, callbackHandler);
    }

    public final ArrayList<ContentValues> k(d.a.l0.a.f0.a aVar) {
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

    @SuppressLint({"BDOfflineUrl"})
    public final void l(Context context, d.a.l0.a.f0.a aVar, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        intent.putExtra("name", aVar.d());
        intent.putExtra("email", aVar.r);
        intent.putParcelableArrayListExtra("data", k(aVar));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        m(context, intent, callbackHandler);
    }

    public final void m(Context context, Intent intent, CallbackHandler callbackHandler) {
        try {
            context.startActivity(intent);
            if (TextUtils.isEmpty(this.f41807c)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.f41807c, UnitedSchemeUtility.wrapCallbackParams(0, "ok").toString());
        } catch (Exception e2) {
            if (a0.f40949b) {
                Log.d("SetPhoneContactAction", "startContactActivity:" + e2.toString());
            }
            if (TextUtils.isEmpty(this.f41807c)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(this.f41807c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
        }
    }
}
