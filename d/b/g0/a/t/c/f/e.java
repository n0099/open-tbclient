package d.b.g0.a.t.c.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.g0.a.i2.j;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.d;
import d.b.g0.a.q1.b.b.e;
import d.b.g0.a.q1.b.b.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends d.b.g0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.q1.b.b.h f46018d;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f46020f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f46021g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f46022h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ String j;

        /* renamed from: d.b.g0.a.t.c.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnCancelListenerC0810a implements DialogInterface.OnCancelListener {
            public DialogInterface$OnCancelListenerC0810a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a aVar = a.this;
                e.this.c(aVar.j, new d.b.g0.a.t.e.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar = a.this;
                e.this.c(aVar.j, new d.b.g0.a.t.e.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                i iVar = (i) dialogInterface;
                String format = String.format("%02d:%02d", Integer.valueOf(iVar.f()), Integer.valueOf(iVar.g()));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", format);
                    if (d.b.g0.a.t.b.d.f45929c) {
                        Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                    }
                    e.this.c(a.this.j, new d.b.g0.a.t.e.b(0, jSONObject));
                } catch (JSONException e2) {
                    if (d.b.g0.a.t.b.d.f45929c) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public a(String str, Date date, Date date2, Date date3, boolean z, String str2) {
            this.f46019e = str;
            this.f46020f = date;
            this.f46021g = date2;
            this.f46022h = date3;
            this.i = z;
            this.j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.a aVar = new i.a(e.this.h());
            if (!TextUtils.isEmpty(this.f46019e)) {
                aVar.m(this.f46019e);
            }
            aVar.o(this.f46020f);
            aVar.l(this.f46021g);
            aVar.n(this.f46022h);
            aVar.k(this.i);
            aVar.c(true);
            aVar.g(d.b.g0.a.h.aiapps_ok, new c());
            aVar.d(d.b.g0.a.h.aiapps_cancel, new b());
            aVar.f(new DialogInterface$OnCancelListenerC0810a());
            aVar.j();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f46027f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f46028g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f46029h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ String j;

        /* loaded from: classes2.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b bVar = b.this;
                e.this.c(bVar.j, new d.b.g0.a.t.e.b(0));
                dialogInterface.dismiss();
            }
        }

        /* renamed from: d.b.g0.a.t.c.f.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0811b implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0811b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b bVar = b.this;
                e.this.c(bVar.j, new d.b.g0.a.t.e.b(0));
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof d.b.g0.a.q1.b.b.d) {
                    String h2 = ((d.b.g0.a.q1.b.b.d) dialogInterface).h();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", h2);
                        if (d.b.g0.a.t.b.d.f45929c) {
                            Log.d("Api-Base", "handleShowDatePicker params = " + jSONObject.toString());
                        }
                        e.this.c(b.this.j, new d.b.g0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.g0.a.t.b.d.f45929c) {
                            e2.printStackTrace();
                        }
                        b bVar = b.this;
                        e.this.c(bVar.j, new d.b.g0.a.t.e.b(202));
                    }
                }
            }
        }

        public b(String str, Date date, Date date2, Date date3, boolean z, String str2) {
            this.f46026e = str;
            this.f46027f = date;
            this.f46028g = date2;
            this.f46029h = date3;
            this.i = z;
            this.j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a aVar = new d.a(e.this.h());
            if (!TextUtils.isEmpty(this.f46026e)) {
                aVar.m(this.f46026e);
            }
            aVar.o(this.f46027f);
            aVar.l(this.f46028g);
            aVar.n(this.f46029h);
            aVar.k(this.i);
            aVar.c(true);
            aVar.g(d.b.g0.a.h.aiapps_ok, new c());
            aVar.d(d.b.g0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0811b());
            aVar.f(new a());
            aVar.j();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46035g;

        public c(int i, JSONArray jSONArray, int i2) {
            this.f46033e = i;
            this.f46034f = jSONArray;
            this.f46035g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f46018d != null) {
                ((d.b.g0.a.q1.b.b.e) e.this.f46018d).k(this.f46033e, this.f46034f, this.f46035g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46039g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46040h;
        public final /* synthetic */ String i;

        /* loaded from: classes2.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                d dVar = d.this;
                e.this.D(dialogInterface, dVar.f46039g, dVar.i);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d dVar = d.this;
                e.this.D(dialogInterface, dVar.f46039g, dVar.i);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                e.this.f46018d = null;
                try {
                    JSONArray f2 = ((d.b.g0.a.q1.b.b.e) dialogInterface).f();
                    JSONObject jSONObject = new JSONObject();
                    if (f2 != null && f2.length() > 0) {
                        if (d.this.f46039g) {
                            jSONObject.put("value", f2.optInt(0));
                        } else {
                            jSONObject.put("value", f2);
                            jSONObject.put("type", "confirm");
                        }
                    }
                    e.this.c(d.this.i, new d.b.g0.a.t.e.b(0, jSONObject));
                    if (d.b.g0.a.t.b.d.f45929c) {
                        Log.i("Api-Base", "handleOpenMultiPicker: output params = " + jSONObject.toString());
                    }
                } catch (JSONException e2) {
                    if (d.b.g0.a.t.b.d.f45929c) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: d.b.g0.a.t.c.f.e$d$d  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0812d implements BdMultiPicker.b {
            public C0812d() {
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (d.b.g0.a.t.b.d.f45929c) {
                    Log.i("Api-Base", "onMultiSelectedChanged: params=" + d.this.f46040h);
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    jSONObject2.put("type", "columnChange");
                    e.this.c(d.this.i, new d.b.g0.a.t.e.b(0, jSONObject2));
                } catch (JSONException e2) {
                    if (d.b.g0.a.t.b.d.f45929c) {
                        e2.printStackTrace();
                    }
                    d dVar = d.this;
                    e.this.c(dVar.i, new d.b.g0.a.t.e.b(202));
                }
            }
        }

        public d(JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str) {
            this.f46037e = jSONArray;
            this.f46038f = jSONArray2;
            this.f46039g = z;
            this.f46040h = jSONObject;
            this.i = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a aVar = new e.a(e.this.h());
            e eVar = e.this;
            aVar.k(this.f46037e);
            aVar.l(this.f46038f);
            aVar.n(this.f46039g);
            aVar.m(new C0812d());
            aVar.c(true);
            aVar.g(d.b.g0.a.h.aiapps_ok, new c());
            aVar.d(d.b.g0.a.h.aiapps_cancel, new b());
            aVar.f(new a());
            eVar.f46018d = aVar.j();
        }
    }

    public e(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b A(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(202);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("showDatePickerView", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            return new d.b.g0.a.t.e.b(202);
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
                return x(jSONObject, true);
            } catch (JSONException unused) {
                return new d.b.g0.a.t.e.b(1001);
            }
        }
        return new d.b.g0.a.t.e.b(202);
    }

    public final Date B(String str, String[] strArr, String str2) {
        Date d2 = !TextUtils.isEmpty(str) ? j.d(str, strArr) : null;
        return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : j.d(str2, strArr);
    }

    public final Date C(String str) {
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
                if (d.b.g0.a.t.b.d.f45929c) {
                    e.printStackTrace();
                    return date;
                }
                return date;
            }
        } catch (NumberFormatException e3) {
            e = e3;
        }
    }

    public final void D(DialogInterface dialogInterface, boolean z, String str) {
        dialogInterface.dismiss();
        this.f46018d = null;
        if (z) {
            c(str, new d.b.g0.a.t.e.b(0));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", QueryResponse.Options.CANCEL);
            c(str, new d.b.g0.a.t.e.b(0, jSONObject));
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
            c(str, new d.b.g0.a.t.e.b(202));
        }
    }

    public d.b.g0.a.t.e.b E(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(202);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("showDatePickerView", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            d.b.g0.a.c0.c.b("Api-Base", "paramsJson is null");
            return new d.b.g0.a.t.e.b(1001);
        }
        String optString = jSONObject.optString("mode");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(202);
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
                return new d.b.g0.a.t.e.b(202);
            }
            return w(jSONObject);
        }
        return y(jSONObject);
    }

    public d.b.g0.a.t.e.b F(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(202);
        }
        if (this.f46018d == null) {
            return new d.b.g0.a.t.e.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("column");
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("Api-Base", "callback is null");
                return new d.b.g0.a.t.e.b(1001, "callback is null");
            }
            if (optJSONArray != null) {
                k0.X(new c(optInt, optJSONArray, optInt2));
                c(optString, new d.b.g0.a.t.e.b(0, jSONObject));
            }
            return new d.b.g0.a.t.e.b(0);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(202);
        }
    }

    public final d.b.g0.a.t.e.b w(JSONObject jSONObject) {
        Date date;
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString(ProgressInfo.JSON_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("fields");
        String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
        Date B = B(optString, strArr, "1900-01-01");
        Date B2 = B(optString2, strArr, "2099-12-31");
        if (B != null && B2 != null && !B2.before(B)) {
            String optString5 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString5)) {
                d.b.g0.a.c0.c.b("Api-Base", "callback is null");
                return new d.b.g0.a.t.e.b(1001, "callback is null");
            }
            Date B3 = B(optString3, strArr, null);
            if (B3 == null) {
                B3 = new Date();
            }
            if (B3.before(B)) {
                date = B;
            } else {
                date = B3.after(B2) ? B2 : B3;
            }
            k0.X(new b(optString4, B, B2, date, optBoolean, optString5));
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(202);
    }

    public final d.b.g0.a.t.e.b x(JSONObject jSONObject, boolean z) {
        if (this.f46018d != null) {
            return new d.b.g0.a.t.e.b(1001);
        }
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.i("Api-Base", "handleOpenMultiPicker: input params=" + jSONObject);
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        String str = null;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("array");
            jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
            str = jSONObject.optString("cb");
        }
        JSONArray jSONArray3 = jSONArray;
        JSONArray jSONArray4 = jSONArray2;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            d.b.g0.a.c0.c.b("Api-Base", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new d(jSONArray3, jSONArray4, z, jSONObject, str2));
        return new d.b.g0.a.t.e.b(0);
    }

    public final d.b.g0.a.t.e.b y(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString(ProgressInfo.JSON_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        Date C = C(optString);
        Date C2 = C(optString2);
        Date C3 = C(optString3);
        if (C3 == null) {
            C3 = C(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        Date date = C3;
        if (C != null && C2 != null && !C2.before(C) && date != null) {
            String optString5 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString5)) {
                d.b.g0.a.c0.c.b("Api-Base", "callback is null");
                return new d.b.g0.a.t.e.b(1001, "callback is null");
            }
            k0.X(new a(optString4, C, C2, date, optBoolean, optString5));
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(202);
    }

    public d.b.g0.a.t.e.b z(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d.b.g0.a.t.e.b(202);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("showDatePickerView", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            return bVar;
        }
        return x((JSONObject) a2.second, false);
    }
}
