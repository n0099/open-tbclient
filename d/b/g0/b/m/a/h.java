package d.b.g0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f47776g;

        public a(CallbackHandler callbackHandler, String str, Activity activity) {
            this.f47774e = callbackHandler;
            this.f47775f = str;
            this.f47776g = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f47774e, this.f47775f);
                return;
            }
            d.b.g0.a.c0.c.g("ReadContacts", "request authorize success");
            h.this.p(this.f47776g, this.f47774e, this.f47775f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f47778a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47780c;

        public b(Activity activity, CallbackHandler callbackHandler, String str) {
            this.f47778a = activity;
            this.f47779b = callbackHandler;
            this.f47780c = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            h.this.m(this.f47778a, this.f47779b, this.f47780c);
            d.b.g0.a.c0.c.b("ReadContacts", str + "");
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            d.b.g0.a.v1.c.c.m(10005, this.f47779b, this.f47780c);
            d.b.g0.a.c0.c.b("ReadContacts", str + "");
        }
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/getPhoneContacts");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("ReadContacts", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("ReadContacts", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        d.b.g0.a.c0.c.g("ReadContacts", "params is:" + optParamsAsJo.toString());
        if (!(context instanceof Activity)) {
            d.b.g0.a.c0.c.b("ReadContacts", "the context is error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
            return false;
        }
        Activity activity = (Activity) context;
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("ReadContacts", "the callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the callback is null");
            return false;
        }
        eVar.R().g(activity, "mapp_i_read_contacts", new a(callbackHandler, optString, activity));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final JSONObject l(Context context) throws JSONException {
        char c2;
        JSONArray jSONArray = new JSONArray();
        Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
        if (query != null && query.getCount() > 0) {
            JSONObject jSONObject = null;
            JSONArray jSONArray2 = null;
            int i = -1;
            while (query.moveToNext()) {
                int i2 = query.getInt(query.getColumnIndex("raw_contact_id"));
                if (i != i2) {
                    if (jSONObject != null && jSONArray2 != null && jSONArray2.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                    jSONObject = new JSONObject();
                    jSONArray2 = new JSONArray();
                    i = i2;
                }
                if (jSONObject != null) {
                    String string = query.getString(query.getColumnIndex("mimetype"));
                    switch (string.hashCode()) {
                        case -1079224304:
                            if (string.equals("vnd.android.cursor.item/name")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1079210633:
                            if (string.equals("vnd.android.cursor.item/note")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 684173810:
                            if (string.equals("vnd.android.cursor.item/phone_v2")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2034973555:
                            if (string.equals("vnd.android.cursor.item/nickname")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        String string2 = query.getString(query.getColumnIndex("data1"));
                        String string3 = query.getString(query.getColumnIndex("data3"));
                        String string4 = query.getString(query.getColumnIndex("data2"));
                        String string5 = query.getString(query.getColumnIndex("data5"));
                        if (string2 == null) {
                            string2 = "";
                        }
                        jSONObject.put("name", string2);
                        if (string3 == null) {
                            string3 = "";
                        }
                        jSONObject.put("lastName", string3);
                        if (string4 == null) {
                            string4 = "";
                        }
                        jSONObject.put("firstName", string4);
                        jSONObject.put("middleName", string5 != null ? string5 : "");
                    } else if (c2 == 1) {
                        String string6 = query.getString(query.getColumnIndex("data1"));
                        jSONObject.put("remark", string6 != null ? string6 : "");
                    } else if (c2 == 2) {
                        String string7 = query.getString(query.getColumnIndex("data1"));
                        if (!TextUtils.isEmpty(string7) && jSONArray2 != null) {
                            jSONArray2.put(string7);
                        }
                        jSONObject.put("phoneNumbers", jSONArray2);
                    } else if (c2 == 3) {
                        jSONObject.put("nickName", query.getString(query.getColumnIndex("data1")));
                    }
                }
            }
            if (jSONObject != null && jSONArray2 != null && jSONArray2.length() > 0) {
                jSONArray.put(jSONObject);
            }
            d.b.g0.a.b1.e.a.a(query);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("contacts", jSONArray);
        return jSONObject2;
    }

    public final void m(Activity activity, CallbackHandler callbackHandler, String str) {
        try {
            JSONObject l = l(activity);
            if (a0.f46680b) {
                Log.i("ReadContactsAction", "read contacts:" + l.toString());
            }
            d.b.g0.a.c0.c.b("ReadContacts", "read contacts:" + l.toString());
            o(callbackHandler, str, 0, l);
        } catch (JSONException e2) {
            if (a0.f46680b) {
                Log.e("ReadContactsAction", "read contacts error caused by JsonException");
                e2.printStackTrace();
            }
            d.b.g0.a.c0.c.b("ReadContacts", "read contacts error caused by JsonException");
            n(callbackHandler, str, 1001, "json parse error");
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, int i, String str2) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString());
    }

    public final void o(CallbackHandler callbackHandler, String str, int i, JSONObject jSONObject) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
    }

    public final void p(Activity activity, CallbackHandler callbackHandler, String str) {
        d.b.g0.a.k1.a.a("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CONTACTS"}, 666, activity, new b(activity, callbackHandler, str));
    }
}
