package d.a.m0.a.f0.b;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.a2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.d;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.j2.k;
import d.a.m0.a.s1.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.m0.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0685a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f45582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f45584g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45585h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45586i;
        public final /* synthetic */ String j;
        public final /* synthetic */ Activity k;

        public C0685a(e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, Activity activity) {
            this.f45582e = eVar;
            this.f45583f = context;
            this.f45584g = z;
            this.f45585h = str;
            this.f45586i = callbackHandler;
            this.j = str2;
            this.k = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            boolean e2 = this.f45582e.j().e(this.f45583f);
            if (!d.h(iVar)) {
                if (!e2 && !this.f45584g) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 7, this.f45585h);
                }
                d.p(iVar, this.f45586i, this.j);
                return;
            }
            if (e2 && !this.f45584g) {
                k.M("success", 7, this.f45585h);
            }
            d.a.m0.a.e0.d.g("ReadContacts", "request authorize success");
            a.this.p(this.k, this.f45586i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f45587a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45588b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45589c;

        public b(Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45587a = activity;
            this.f45588b = callbackHandler;
            this.f45589c = str;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            a.this.m(this.f45587a, this.f45588b, this.f45589c);
            d.a.m0.a.e0.d.b("ReadContacts", str + "");
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            d.n(10005, this.f45588b, this.f45589c);
            d.a.m0.a.e0.d.b("ReadContacts", str + "");
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneContacts");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("ReadContacts", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.m0.a.e0.d.b("ReadContacts", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        d.a.m0.a.e0.d.g("ReadContacts", "params is:" + optParamsAsJo.toString());
        if (!(context instanceof Activity)) {
            d.a.m0.a.e0.d.b("ReadContacts", "the context is error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the context is error");
            return false;
        }
        Activity activity = (Activity) context;
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("ReadContacts", "the callback is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the callback is null");
            return false;
        }
        String optString2 = optParamsAsJo.optString("invokeFrom");
        boolean e2 = eVar.j().e(context);
        if (!e2) {
            k.M("show", 7, optString2);
        }
        eVar.T().g(activity, "mapp_i_read_contacts", new C0685a(eVar, context, e2, optString2, callbackHandler, optString, activity));
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
            d.a.m0.a.i1.e.a.a(query);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("contacts", jSONArray);
        return jSONObject2;
    }

    public final void m(Activity activity, CallbackHandler callbackHandler, String str) {
        try {
            JSONObject l = l(activity);
            if (a0.f44733b) {
                Log.i("ReadContactsAction", "read contacts:" + l.toString());
            }
            d.a.m0.a.e0.d.b("ReadContacts", "read contacts:" + l.toString());
            o(callbackHandler, str, 0, l);
        } catch (JSONException e2) {
            if (a0.f44733b) {
                Log.e("ReadContactsAction", "read contacts error caused by JsonException");
                e2.printStackTrace();
            }
            d.a.m0.a.e0.d.b("ReadContacts", "read contacts error caused by JsonException");
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
        d.a.m0.a.s1.e.e("android.permission.READ_CONTACTS", new String[]{"android.permission.READ_CONTACTS"}, 5, activity, new b(activity, callbackHandler, str));
    }
}
