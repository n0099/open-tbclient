package d.a.i0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.i0.a.v2.k;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.d;
import d.a.i0.a.z1.b.b.e;
import d.a.i0.a.z1.b.b.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.a.i0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.z1.b.b.i f44768d;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f44770f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f44771g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f44772h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f44773i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        /* renamed from: d.a.i0.a.u.e.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnCancelListenerC0836a implements DialogInterface.OnCancelListener {
            public DialogInterface$OnCancelListenerC0836a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a aVar = a.this;
                e.this.d(aVar.k, new d.a.i0.a.u.h.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                a aVar = a.this;
                e.this.d(aVar.k, new d.a.i0.a.u.h.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                j jVar = (j) dialogInterface;
                String format = String.format("%02d:%02d", Integer.valueOf(jVar.f()), Integer.valueOf(jVar.g()));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", format);
                    if (d.a.i0.a.u.c.d.f44636c) {
                        Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                    }
                    e.this.d(a.this.k, new d.a.i0.a.u.h.b(0, jSONObject));
                } catch (JSONException e2) {
                    if (d.a.i0.a.u.c.d.f44636c) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public a(String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            this.f44769e = str;
            this.f44770f = date;
            this.f44771g = date2;
            this.f44772h = date3;
            this.f44773i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a aVar = new j.a(e.this.i());
            if (!TextUtils.isEmpty(this.f44769e)) {
                aVar.n(this.f44769e);
            }
            aVar.p(this.f44770f);
            aVar.m(this.f44771g);
            aVar.o(this.f44772h);
            aVar.l(this.f44773i);
            aVar.c(true);
            aVar.g(this.j);
            aVar.h(d.a.i0.a.h.aiapps_confirm, new c());
            aVar.d(d.a.i0.a.h.aiapps_cancel, new b());
            aVar.f(new DialogInterface$OnCancelListenerC0836a());
            aVar.k();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f44778f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f44779g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f44780h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f44781i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        /* loaded from: classes2.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b bVar = b.this;
                e.this.d(bVar.k, new d.a.i0.a.u.h.b(0));
                dialogInterface.dismiss();
            }
        }

        /* renamed from: d.a.i0.a.u.e.g.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0837b implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0837b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                b bVar = b.this;
                e.this.d(bVar.k, new d.a.i0.a.u.h.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof d.a.i0.a.z1.b.b.d) {
                    String h2 = ((d.a.i0.a.z1.b.b.d) dialogInterface).h();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", h2);
                        if (d.a.i0.a.u.c.d.f44636c) {
                            Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                        }
                        e.this.d(b.this.k, new d.a.i0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.i0.a.u.c.d.f44636c) {
                            e2.printStackTrace();
                        }
                        b bVar = b.this;
                        e.this.d(bVar.k, new d.a.i0.a.u.h.b(202));
                    }
                }
            }
        }

        public b(String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            this.f44777e = str;
            this.f44778f = date;
            this.f44779g = date2;
            this.f44780h = date3;
            this.f44781i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a aVar = new d.a(e.this.i());
            if (!TextUtils.isEmpty(this.f44777e)) {
                aVar.n(this.f44777e);
            }
            aVar.p(this.f44778f);
            aVar.m(this.f44779g);
            aVar.o(this.f44780h);
            aVar.l(this.f44781i);
            aVar.c(true);
            aVar.g(this.j);
            aVar.h(d.a.i0.a.h.aiapps_confirm, new c());
            aVar.d(d.a.i0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0837b());
            aVar.f(new a());
            aVar.k();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44786f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44787g;

        public c(int i2, JSONArray jSONArray, int i3) {
            this.f44785e = i2;
            this.f44786f = jSONArray;
            this.f44787g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f44768d != null) {
                ((d.a.i0.a.z1.b.b.e) e.this.f44768d).k(this.f44785e, this.f44786f, this.f44787g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44793i;
        public final /* synthetic */ String j;

        /* loaded from: classes2.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                d dVar = d.this;
                e.this.E(dialogInterface, dVar.f44791g, dVar.f44793i);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d dVar = d.this;
                e.this.E(dialogInterface, dVar.f44791g, dVar.f44793i);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                e.this.f44768d = null;
                try {
                    JSONArray f2 = ((d.a.i0.a.z1.b.b.e) dialogInterface).f();
                    JSONObject jSONObject = new JSONObject();
                    if (f2 != null && f2.length() > 0) {
                        if (d.this.f44791g) {
                            jSONObject.put("value", f2.optInt(0));
                        } else {
                            jSONObject.put("value", f2);
                            jSONObject.put("type", "confirm");
                        }
                    }
                    e.this.d(d.this.f44793i, new d.a.i0.a.u.h.b(0, jSONObject));
                    if (d.a.i0.a.u.c.d.f44636c) {
                        Log.i("Api-Base", "handleOpenMultiPicker: output params = " + jSONObject.toString());
                    }
                } catch (JSONException e2) {
                    if (d.a.i0.a.u.c.d.f44636c) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: d.a.i0.a.u.e.g.e$d$d  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0838d implements BdMultiPicker.b {
            public C0838d() {
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (d.a.i0.a.u.c.d.f44636c) {
                    Log.i("Api-Base", "onMultiSelectedChanged: params=" + d.this.f44792h);
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    jSONObject2.put("type", "columnChange");
                    e.this.d(d.this.f44793i, new d.a.i0.a.u.h.b(0, jSONObject2));
                } catch (JSONException e2) {
                    if (d.a.i0.a.u.c.d.f44636c) {
                        e2.printStackTrace();
                    }
                    d dVar = d.this;
                    e.this.d(dVar.f44793i, new d.a.i0.a.u.h.b(202));
                }
            }
        }

        public d(JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str, String str2) {
            this.f44789e = jSONArray;
            this.f44790f = jSONArray2;
            this.f44791g = z;
            this.f44792h = jSONObject;
            this.f44793i = str;
            this.j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a aVar = new e.a(e.this.i());
            e eVar = e.this;
            aVar.l(this.f44789e);
            aVar.m(this.f44790f);
            aVar.o(this.f44791g);
            aVar.n(new C0838d());
            aVar.c(true);
            aVar.g(this.j);
            aVar.h(d.a.i0.a.h.aiapps_confirm, new c());
            aVar.d(d.a.i0.a.h.aiapps_cancel, new b());
            aVar.f(new a());
            eVar.f44768d = aVar.k();
        }
    }

    public e(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b A(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.a.i0.a.u.h.b(202);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("showDatePickerView", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.i0.a.e0.d.b("Api-Base", "parse fail");
            return bVar;
        }
        return y((JSONObject) b2.second, false);
    }

    public d.a.i0.a.u.h.b B(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.a.i0.a.u.h.b(202);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("showDatePickerView", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.i0.a.e0.d.b("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            return new d.a.i0.a.u.h.b(202);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(optJSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(optInt);
            try {
                jSONObject.put("array", jSONArray);
                jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                return y(jSONObject, true);
            } catch (JSONException unused) {
                return new d.a.i0.a.u.h.b(1001);
            }
        }
        return new d.a.i0.a.u.h.b(202);
    }

    public final Date C(String str, String[] strArr, String str2) {
        Date d2 = !TextUtils.isEmpty(str) ? k.d(str, strArr) : null;
        return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : k.d(str2, strArr);
    }

    public final Date D(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return new Date();
        }
        Date date = null;
        if (!str.contains(":") || (split = str.split(":")) == null || split.length != 2) {
            return null;
        }
        try {
            Date date2 = new Date();
            try {
                int parseInt = Integer.parseInt(split[0]);
                if (parseInt >= 0 && parseInt < 24) {
                    date2.setHours(parseInt);
                }
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt2 >= 0 && parseInt2 < 60) {
                    date2.setMinutes(parseInt2);
                }
                return date2;
            } catch (NumberFormatException e2) {
                e = e2;
                date = date2;
                if (d.a.i0.a.u.c.d.f44636c) {
                    e.printStackTrace();
                    return date;
                }
                return date;
            }
        } catch (NumberFormatException e3) {
            e = e3;
        }
    }

    public final void E(DialogInterface dialogInterface, boolean z, String str) {
        dialogInterface.dismiss();
        this.f44768d = null;
        if (z) {
            d(str, new d.a.i0.a.u.h.b(0));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", QueryResponse.Options.CANCEL);
            d(str, new d.a.i0.a.u.h.b(0, jSONObject));
        } catch (JSONException e2) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e2.printStackTrace();
            }
            d(str, new d.a.i0.a.u.h.b(202));
        }
    }

    public d.a.i0.a.u.h.b F(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.a.i0.a.u.h.b(202);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("showDatePickerView", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.i0.a.e0.d.b("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            d.a.i0.a.e0.d.b("Api-Base", "paramsJson is null");
            return new d.a.i0.a.u.h.b(1001);
        }
        String optString = jSONObject.optString("mode");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.i0.a.u.h.b(202);
        }
        char c2 = 65535;
        int hashCode = optString.hashCode();
        if (hashCode != 3076014) {
            if (hashCode == 3560141 && optString.equals("time")) {
                c2 = 0;
            }
        } else if (optString.equals("date")) {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return new d.a.i0.a.u.h.b(202);
            }
            return x(jSONObject);
        }
        return z(jSONObject);
    }

    public d.a.i0.a.u.h.b G(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.a.i0.a.u.h.b(202);
        }
        if (this.f44768d == null) {
            return new d.a.i0.a.u.h.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("column");
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.i0.a.e0.d.b("Api-Base", "callback is null");
                return new d.a.i0.a.u.h.b(1001, "callback is null");
            }
            if (optJSONArray != null) {
                q0.b0(new c(optInt, optJSONArray, optInt2));
                d(optString, new d.a.i0.a.u.h.b(0, jSONObject));
            }
            return new d.a.i0.a.u.h.b(0);
        } catch (JSONException e2) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e2.printStackTrace();
            }
            return new d.a.i0.a.u.h.b(202);
        }
    }

    public final d.a.i0.a.u.h.b x(JSONObject jSONObject) {
        Date date;
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString(ProgressInfo.JSON_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("title");
        String optString5 = jSONObject.optString("fields");
        String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
        Date C = C(optString, strArr, "1900-01-01");
        Date C2 = C(optString2, strArr, "2099-12-31");
        if (C != null && C2 != null && !C2.before(C)) {
            String optString6 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString6)) {
                d.a.i0.a.e0.d.b("Api-Base", "callback is null");
                return new d.a.i0.a.u.h.b(1001, "callback is null");
            }
            Date C3 = C(optString3, strArr, null);
            if (C3 == null) {
                C3 = new Date();
            }
            if (C3.before(C)) {
                date = C;
            } else {
                date = C3.after(C2) ? C2 : C3;
            }
            q0.b0(new b(optString5, C, C2, date, optBoolean, optString4, optString6));
            return new d.a.i0.a.u.h.b(0);
        }
        return new d.a.i0.a.u.h.b(202);
    }

    public final d.a.i0.a.u.h.b y(JSONObject jSONObject, boolean z) {
        String str;
        if (this.f44768d != null) {
            return new d.a.i0.a.u.h.b(1001);
        }
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.i("Api-Base", "handleOpenMultiPicker: input params=" + jSONObject);
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        String str2 = null;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("array");
            jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
            str2 = jSONObject.optString("cb");
            str = jSONObject.optString("title");
        } else {
            str = "";
        }
        String str3 = str;
        String str4 = str2;
        JSONArray jSONArray3 = jSONArray2;
        JSONArray jSONArray4 = jSONArray;
        if (TextUtils.isEmpty(str4)) {
            d.a.i0.a.e0.d.b("Api-Base", "callback is null");
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new d(jSONArray4, jSONArray3, z, jSONObject, str4, str3));
        return new d.a.i0.a.u.h.b(0);
    }

    public final d.a.i0.a.u.h.b z(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString(ProgressInfo.JSON_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("title");
        String optString5 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        Date D = D(optString);
        Date D2 = D(optString2);
        Date D3 = D(optString3);
        if (D3 == null) {
            D3 = D(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
        }
        Date date = D3;
        if (D != null && D2 != null && !D2.before(D) && date != null) {
            String optString6 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString6)) {
                d.a.i0.a.e0.d.b("Api-Base", "callback is null");
                return new d.a.i0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(optString5, D, D2, date, optBoolean, optString4, optString6));
            return new d.a.i0.a.u.h.b(0);
        }
        return new d.a.i0.a.u.h.b(202);
    }
}
