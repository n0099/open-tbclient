package d.a.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45547e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45548f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f45549g;

        public a(CallbackHandler callbackHandler, String str, Activity activity) {
            this.f45547e = callbackHandler;
            this.f45548f = str;
            this.f45549g = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f45547e, this.f45548f);
                return;
            }
            d.a.h0.a.c0.c.g("ReadContacts", "request authorize success");
            h.this.p(this.f45549g, this.f45547e, this.f45548f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f45551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45553c;

        public b(Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45551a = activity;
            this.f45552b = callbackHandler;
            this.f45553c = str;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            h.this.m(this.f45551a, this.f45552b, this.f45553c);
            d.a.h0.a.c0.c.b("ReadContacts", str + "");
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            d.a.h0.a.v1.c.c.m(10005, this.f45552b, this.f45553c);
            d.a.h0.a.c0.c.b("ReadContacts", str + "");
        }
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/getPhoneContacts");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("ReadContacts", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.h0.a.c0.c.b("ReadContacts", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        d.a.h0.a.c0.c.g("ReadContacts", "params is:" + optParamsAsJo.toString());
        if (!(context instanceof Activity)) {
            d.a.h0.a.c0.c.b("ReadContacts", "the context is error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
            return false;
        }
        Activity activity = (Activity) context;
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("ReadContacts", "the callback is null");
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
            int i2 = -1;
            while (query.moveToNext()) {
                int i3 = query.getInt(query.getColumnIndex("raw_contact_id"));
                if (i2 != i3) {
                    if (jSONObject != null && jSONArray2 != null && jSONArray2.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                    jSONObject = new JSONObject();
                    jSONArray2 = new JSONArray();
                    i2 = i3;
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
            d.a.h0.a.b1.e.a.a(query);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("contacts", jSONArray);
        return jSONObject2;
    }

    public final void m(Activity activity, CallbackHandler callbackHandler, String str) {
        try {
            JSONObject l = l(activity);
            if (a0.f44398b) {
                Log.i("ReadContactsAction", "read contacts:" + l.toString());
            }
            d.a.h0.a.c0.c.b("ReadContacts", "read contacts:" + l.toString());
            o(callbackHandler, str, 0, l);
        } catch (JSONException e2) {
            if (a0.f44398b) {
                Log.e("ReadContactsAction", "read contacts error caused by JsonException");
                e2.printStackTrace();
            }
            d.a.h0.a.c0.c.b("ReadContacts", "read contacts error caused by JsonException");
            n(callbackHandler, str, 1001, "json parse error");
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, int i2, String str2) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
    }

    public final void o(CallbackHandler callbackHandler, String str, int i2, JSONObject jSONObject) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
    }

    public final void p(Activity activity, CallbackHandler callbackHandler, String str) {
        d.a.h0.a.k1.a.a("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CONTACTS"}, 666, activity, new b(activity, callbackHandler, str));
    }
}
