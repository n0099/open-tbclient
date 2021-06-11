package d.a.l0.e.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.kwai.video.player.KsMediaMeta;
import com.tencent.connect.common.Constants;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.r0;
import d.a.l0.a.z1.b.b.d;
import d.a.l0.a.z1.b.b.e;
import d.a.l0.a.z1.b.b.h;
import d.a.l0.a.z1.b.b.j;
import d.a.l0.a.z1.b.c.a;
import d.a.l0.a.z1.b.f.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class e extends UnitedSchemeBaseDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.l0.a.z1.b.b.i f50252a;

    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f50253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f50254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50255g;

        public a(e eVar, List list, Context context, int i2) {
            this.f50253e = list;
            this.f50254f = context;
            this.f50255g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            return (String) this.f50253e.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f50253e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f50254f, d.a.l0.a.g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(d.a.l0.a.f.text);
            textView.setTextColor(this.f50255g);
            textView.setText(getItem(i2));
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z1.b.b.h f50258g;

        public b(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.l0.a.z1.b.b.h hVar) {
            this.f50256e = callbackHandler;
            this.f50257f = unitedSchemeEntity;
            this.f50258g = hVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i2);
                UnitedSchemeUtility.callCallback(this.f50256e, this.f50257f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f50258g.dismiss();
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f50256e, this.f50257f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f50260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50261g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50262h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50263i;
        public final /* synthetic */ UnitedSchemeEntity j;
        public final /* synthetic */ JSONObject k;
        public final /* synthetic */ String l;

        /* loaded from: classes3.dex */
        public class a implements e.c {
            public a() {
            }

            @Override // d.a.l0.a.z1.b.f.e.c
            public void a() {
                d dVar = d.this;
                dVar.f50263i.handleSchemeDispatchCallback(dVar.l, "");
            }
        }

        /* loaded from: classes3.dex */
        public class b implements e.c {
            public b() {
            }

            @Override // d.a.l0.a.z1.b.f.e.c
            public void a() {
                d dVar = d.this;
                dVar.f50263i.handleSchemeDispatchCallback(dVar.l, "");
            }
        }

        public d(e eVar, String str, Context context, String str2, int i2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, String str3) {
            this.f50259e = str;
            this.f50260f = context;
            this.f50261g = str2;
            this.f50262h = i2;
            this.f50263i = callbackHandler;
            this.j = unitedSchemeEntity;
            this.k = jSONObject;
            this.l = str3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            String str = this.f50259e;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(this.f50260f, this.f50261g);
                g2.l(this.f50262h);
                g2.F();
                UnitedSchemeUtility.callCallback(this.f50263i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                return;
            }
            Uri uri = null;
            if (c2 == 1) {
                d.a.l0.a.z1.b.f.e g3 = d.a.l0.a.z1.b.f.e.g(this.f50260f, this.f50261g);
                g3.n(null);
                g3.l(this.f50262h);
                g3.A();
                UnitedSchemeUtility.callCallback(this.f50263i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
            } else if (c2 != 2) {
                this.j.result = UnitedSchemeUtility.wrapCallbackParams(202);
            } else {
                String optString = this.k.optString("icon");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        uri = Uri.parse(optString);
                    } catch (Exception unused) {
                    }
                }
                int i2 = TextUtils.equals(this.k.optString("bottomIconStyle"), "2") ? 2 : 1;
                String optString2 = this.k.optString("title");
                String optString3 = this.k.optString("buttonText");
                String optString4 = this.k.optString("style");
                int i3 = "2".equals(this.k.optString("bottomShowAnimationType")) ? 2 : 1;
                if (TextUtils.isEmpty(this.l)) {
                    this.j.result = UnitedSchemeUtility.wrapCallbackParams(202);
                } else if (!TextUtils.equals(optString4, "2") && !TextUtils.equals(optString4, "3")) {
                    d.a.l0.a.z1.b.f.e e2 = d.a.l0.a.z1.b.f.e.e(this.f50260f);
                    e2.o(uri);
                    e2.h(i2);
                    e2.s(optString2);
                    e2.q(this.f50261g);
                    e2.k(optString3);
                    e2.j(1);
                    e2.i(i3);
                    e2.l(this.f50262h);
                    e2.t(new b());
                    e2.C();
                    UnitedSchemeUtility.callCallback(this.f50263i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                } else {
                    d.a.l0.a.z1.b.f.e e3 = d.a.l0.a.z1.b.f.e.e(this.f50260f);
                    e3.o(uri);
                    e3.h(i2);
                    e3.s(optString2);
                    e3.q(this.f50261g);
                    e3.k(optString3);
                    e3.j(2);
                    e3.i(i3);
                    e3.l(this.f50262h);
                    e3.t(new a());
                    e3.C();
                    UnitedSchemeUtility.callCallback(this.f50263i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                }
            }
        }
    }

    /* renamed from: d.a.l0.e.p.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC1028e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50267f;

        public DialogInterface$OnClickListenerC1028e(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50266e = callbackHandler;
            this.f50267f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            d.a.l0.a.z1.b.b.i unused = e.f50252a = null;
            UnitedSchemeUtility.callCallback(this.f50266e, this.f50267f, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50270g;

        public f(e eVar, boolean z, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50268e = z;
            this.f50269f = callbackHandler;
            this.f50270g = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            d.a.l0.a.z1.b.b.i unused = e.f50252a = null;
            try {
                JSONArray f2 = ((d.a.l0.a.z1.b.b.e) dialogInterface).f();
                JSONObject jSONObject = new JSONObject();
                if (f2 != null && f2.length() > 0) {
                    if (this.f50268e) {
                        jSONObject.put("value", f2.optInt(0));
                    } else {
                        jSONObject.put("value", f2);
                    }
                }
                UnitedSchemeUtility.callCallback(this.f50269f, this.f50270g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements BdMultiPicker.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50272b;

        public g(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f50271a = unitedSchemeEntity;
            this.f50272b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
        public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
            String optString = UnitedSchemeUtility.optParamsAsJo(this.f50271a).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f50272b.handleSchemeDispatchCallback(optString, jSONObject.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50274f;

        public h(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50273e = callbackHandler;
            this.f50274f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            UnitedSchemeUtility.callCallback(this.f50273e, this.f50274f, 0);
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50276f;

        public i(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50275e = callbackHandler;
            this.f50276f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            d.a.l0.a.z1.b.b.j jVar = (d.a.l0.a.z1.b.b.j) dialogInterface;
            String format = String.format("%02d:%02d", Integer.valueOf(jVar.f()), Integer.valueOf(jVar.g()));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", format);
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                if (d.a.l0.a.k.f46875a) {
                    Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                }
                UnitedSchemeUtility.callCallback(this.f50275e, this.f50276f, wrapCallbackParams);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50278f;

        public j(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50277e = callbackHandler;
            this.f50278f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            UnitedSchemeUtility.callCallback(this.f50277e, this.f50278f, 0);
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50280f;

        public k(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50279e = callbackHandler;
            this.f50280f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            if (dialogInterface instanceof d.a.l0.a.z1.b.b.d) {
                String h2 = ((d.a.l0.a.z1.b.b.d) dialogInterface).h();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", h2);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    if (d.a.l0.a.k.f46875a) {
                        Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                    }
                    UnitedSchemeUtility.callCallback(this.f50279e, this.f50280f, wrapCallbackParams);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50282f;

        public l(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50281e = callbackHandler;
            this.f50282f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                UnitedSchemeUtility.callCallback(this.f50281e, this.f50282f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f50281e, this.f50282f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50284f;

        public m(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50283e = callbackHandler;
            this.f50284f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                UnitedSchemeUtility.callCallback(this.f50283e, this.f50284f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f50283e, this.f50284f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50286f;

        public n(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50285e = callbackHandler;
            this.f50286f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "confirm");
                UnitedSchemeUtility.callCallback(this.f50285e, this.f50286f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f50285e, this.f50286f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50288f;

        public o(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50287e = callbackHandler;
            this.f50288f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f50287e, this.f50288f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50290f;

        public p(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f50289e = callbackHandler;
            this.f50290f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            UnitedSchemeUtility.callCallback(this.f50289e, this.f50290f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    public static String d(Configuration configuration) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return configuration.locale.toString();
        }
        if (i2 < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    public static String e(Context context) {
        int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
        if (frameType == 1) {
            return d.a.l0.a.m2.b.i(d.a.l0.a.c1.b.i().n(), frameType);
        }
        return d.a.l0.a.m2.b.i(d.a.l0.a.h0.u.g.N().V(), frameType);
    }

    public final boolean A(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
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
        Date D = D(optString);
        Date D2 = D(optString2);
        Date D3 = D(optString3);
        if (D3 == null) {
            D3 = D(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        if (D != null && D2 != null && !D2.before(D) && D3 != null && !D3.before(D) && !D3.after(D2)) {
            j.a aVar = new j.a(context);
            if (!TextUtils.isEmpty(optString4)) {
                aVar.n(optString4);
            }
            aVar.p(D);
            aVar.m(D2);
            aVar.o(D3);
            aVar.l(optBoolean);
            aVar.h(d.a.l0.a.h.aiapps_confirm, new i(this, callbackHandler, unitedSchemeEntity));
            aVar.d(d.a.l0.a.h.aiapps_cancel, new h(this, callbackHandler, unitedSchemeEntity));
            aVar.k();
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final boolean B(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }

    public final boolean C(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (f50252a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i2 = jSONObject.getInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int i3 = jSONObject.getInt(ProgressInfo.JSON_KEY_CURRENT);
                if (optJSONArray != null) {
                    ((d.a.l0.a.z1.b.b.e) f50252a).k(i2, optJSONArray, i3);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                return true;
            } catch (JSONException e2) {
                if (d.a.l0.a.k.f46875a) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
    }

    public final Date D(String str) {
        Date date = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            if (str.contains(":")) {
                String[] split = str.split(":");
                if (split.length == 2) {
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
                        e.printStackTrace();
                        return date;
                    }
                }
                return null;
            }
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
        }
    }

    public final int E(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final int b(Context context, int i2) {
        int t;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_bottom_divider)) + i2) - 1;
        return (!n0.F() || dimensionPixelSize <= (t = n0.t(context) - n0.u())) ? dimensionPixelSize : t;
    }

    public final int c(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
        if (optInt >= 0) {
            return optInt;
        }
        String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                return i2;
            }
        }
        return 0;
    }

    public final JSONObject f(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        Pair<Integer, Integer> y = d.a.l0.a.g1.f.V().y();
        Pair<Integer, Integer> r = d.a.l0.a.g1.f.V().r();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", n0.K(((Integer) y.first).intValue()));
            jSONObject.put("screenHeight", n0.K(((Integer) y.second).intValue()));
            jSONObject.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, d(configuration));
            jSONObject.put("version", q0.D());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            jSONObject.put("fontSizeSetting", d.a.l0.a.c1.a.n().q());
            jSONObject.put("SDKVersion", e(context));
            jSONObject.put("swanNativeVersion", d.a.l0.a.l.a());
            jSONObject.put("host", d.a.l0.a.c1.a.m().a());
            jSONObject.put("statusBarHeight", n0.K(n0.u()));
            jSONObject.put("navigationBarHeight", n0.K(n0.j()));
            d.a.l0.a.u.e.p.f.s(jSONObject);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        Date d2;
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString(ProgressInfo.JSON_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "1900-01-01";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "2099-12-31";
        }
        Date c2 = d.a.l0.a.v2.k.c(optString, "yyyy-MM-dd");
        Date c3 = d.a.l0.a.v2.k.c(optString2, "yyyy-MM-dd");
        if (c2 != null && c3 != null && !c3.before(c2)) {
            Date date = new Date();
            if (!TextUtils.isEmpty(optString3) && (d2 = d.a.l0.a.v2.k.d(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) != null) {
                date = d2;
            }
            if (date.before(c2)) {
                date = c2;
            } else if (date.after(c3)) {
                date = c3;
            }
            d.a aVar = new d.a(context);
            if (!TextUtils.isEmpty(optString4)) {
                aVar.n(optString4);
            }
            aVar.p(c2);
            aVar.m(c3);
            aVar.o(date);
            aVar.l(optBoolean);
            aVar.h(d.a.l0.a.h.aiapps_confirm, new k(this, callbackHandler, unitedSchemeEntity));
            aVar.d(d.a.l0.a.h.aiapps_cancel, new j(this, callbackHandler, unitedSchemeEntity));
            aVar.k();
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "utils";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    public final boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        q0.b0(new c(this));
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", r0.b(context).a().toString());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
        if (r1.equals("getCommonSysInfoSync") != false) goto L17;
     */
    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        char c2 = 0;
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            switch (path.hashCode()) {
                case -1920105040:
                    if (path.equals("showModal")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1913642710:
                    if (path.equals("showToast")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1641549650:
                    if (path.equals("getSystemInfoSync")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1496218978:
                    if (path.equals("updateMultiPicker")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1383206285:
                    if (path.equals("previewImage")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -886619478:
                    if (path.equals("getClipboardData")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -550543988:
                    if (path.equals("showActionSheet")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -533453131:
                    break;
                case 216239514:
                    if (path.equals("hideLoading")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 252099448:
                    if (path.equals("openPicker")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 344806259:
                    if (path.equals("getSystemInfo")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 422312381:
                    if (path.equals("dismissToast")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 724809599:
                    if (path.equals("showLoading")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1321118366:
                    if (path.equals("makePhoneCall")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1576904990:
                    if (path.equals("setClipboardData")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1630368510:
                    if (path.equals("showDatePickerView")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1714085202:
                    if (path.equals("getNetworkType")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2103167613:
                    if (path.equals("openMultiPicker")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return j(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return w(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return n(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return s(context, unitedSchemeEntity, callbackHandler);
                case 4:
                    return t(context, unitedSchemeEntity, callbackHandler);
                case 5:
                    return i(context, unitedSchemeEntity, callbackHandler);
                case 6:
                    return k(context, unitedSchemeEntity, callbackHandler);
                case 7:
                    return l(context, unitedSchemeEntity, callbackHandler);
                case '\b':
                    return m(context, unitedSchemeEntity, callbackHandler);
                case '\t':
                    return o(context, unitedSchemeEntity, callbackHandler);
                case '\n':
                    return v(context, unitedSchemeEntity, callbackHandler);
                case 11:
                    return x(context, unitedSchemeEntity, callbackHandler);
                case '\f':
                    return u(context, unitedSchemeEntity, callbackHandler);
                case '\r':
                    return h(context, unitedSchemeEntity, callbackHandler);
                case 14:
                    return y(context, unitedSchemeEntity, callbackHandler);
                case 15:
                    return r(context, unitedSchemeEntity, callbackHandler);
                case 16:
                    return p(context, unitedSchemeEntity, callbackHandler);
                case 17:
                    return C(context, unitedSchemeEntity, callbackHandler);
                default:
                    return B(context, unitedSchemeEntity, callbackHandler);
            }
        }
    }

    public final boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", q0.r());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
            return false;
        }
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        String e2 = SwanAppNetworkUtils.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = "unknown";
        } else if ("no".equals(e2)) {
            e2 = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", e2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException unused) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject f2 = f(context);
        if (f2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(f2, 0));
        return true;
    }

    public final boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject f2 = f(context);
        if (f2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(f2, 0);
        return true;
    }

    public final boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!(context instanceof a.InterfaceC0991a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        d.a.l0.a.z1.b.c.a floatLayer = ((a.InterfaceC0991a) context).getFloatLayer();
        if (floatLayer.e() instanceof LoadingView) {
            floatLayer.g();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null) {
            String optString = optParamsAsJo.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse("tel:" + optString));
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, d.a.l0.a.v2.f.g(context, intent) ? 0 : 1001);
        return true;
    }

    public final boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return q(context, unitedSchemeEntity, callbackHandler, false);
    }

    public final boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        String param = unitedSchemeEntity.getParam("params");
        if (f50252a != null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String string = context.getString(d.a.l0.a.h.aiapps_picker_default_title);
            if (!TextUtils.isEmpty(param)) {
                JSONObject jSONObject = new JSONObject(param);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                jSONObject.optString("title", string);
                jSONArray = optJSONArray;
            }
            e.a aVar = new e.a(context);
            aVar.l(jSONArray);
            aVar.m(jSONArray2);
            aVar.o(z);
            aVar.n(new g(this, unitedSchemeEntity, callbackHandler));
            aVar.h(d.a.l0.a.h.aiapps_confirm, new f(this, z, callbackHandler, unitedSchemeEntity));
            aVar.d(d.a.l0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC1028e(this, callbackHandler, unitedSchemeEntity));
            f50252a = aVar.k();
            return false;
        } catch (JSONException e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONArray optJSONArray = optParamsAsJo.optJSONArray("array");
        int optInt = optParamsAsJo.optInt(ProgressInfo.JSON_KEY_CURRENT);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(optJSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(optInt);
            try {
                optParamsAsJo.put("array", jSONArray);
                optParamsAsJo.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                params.put("params", optParamsAsJo.toString());
                return q(context, unitedSchemeEntity, callbackHandler, true);
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    public final boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                z(optJSONArray);
                int c2 = c(jSONObject, optJSONArray);
                if (c2 >= 0 && c2 < optJSONArray.length()) {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        strArr[i2] = optJSONArray.getString(i2);
                    }
                    d.a.l0.a.c1.a.y().d(context, strArr, c2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } catch (JSONException e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        r0.b(context).c(optParamsAsJo.optString("data"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        int i2;
        String optString;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            optString = optParamsAsJo.optString("itemColor");
        } catch (IllegalArgumentException | JSONException unused) {
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.length() == 4 && optString.charAt(0) == '#') {
                optString = SwanAppConfigData.d(optString);
            }
            i2 = Color.parseColor(optString);
            if (!arrayList.isEmpty()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (i2 == -1) {
                i2 = context.getResources().getColor(d.a.l0.a.c.aiapps_action_sheet_item_color);
            }
            h.a aVar = new h.a(context);
            aVar.f(true);
            aVar.i(true);
            aVar.k(true);
            aVar.m(true);
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.s(context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_bottom_divider));
            aVar.p(d.a.l0.a.e.aiapps_action_sheet_bg);
            aVar.B(d.a.l0.a.h.aiapps_cancel, new p(this, callbackHandler, unitedSchemeEntity));
            aVar.K(new o(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, d.a.l0.a.g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(d.a.l0.a.f.list);
            listView.setAdapter((ListAdapter) new a(this, arrayList, context, i2));
            aVar.W(inflate);
            aVar.j();
            aVar.q(b(context, arrayList.size()));
            d.a.l0.a.z1.b.b.h c2 = aVar.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.t(context), -2);
                window.setWindowAnimations(d.a.l0.a.i.action_sheet_animation);
            }
            c2.a(false);
            c2.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new b(this, callbackHandler, unitedSchemeEntity, c2));
            c2.show();
            return true;
        }
        i2 = -1;
        if (!arrayList.isEmpty()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r4 == 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        r10.result = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(202);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        return g(r9, r10, r11, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
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
            return A(context, unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        LoadingView loadingView;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("title");
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        if (!(context instanceof a.InterfaceC0991a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        d.a.l0.a.z1.b.c.a floatLayer = ((a.InterfaceC0991a) context).getFloatLayer();
        View e2 = floatLayer.e();
        if (e2 instanceof LoadingView) {
            loadingView = (LoadingView) e2;
        } else {
            loadingView = new LoadingView(context);
            floatLayer.k(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        floatLayer.i(optBoolean);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final boolean x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            optParamsAsJo = new JSONObject();
        }
        String optString = optParamsAsJo.optString("confirmText");
        if (TextUtils.isEmpty(optString)) {
            optString = context.getString(d.a.l0.a.h.aiapps_confirm);
        }
        h.a aVar = new h.a(context);
        aVar.V(optParamsAsJo.optString("title"));
        aVar.x(optParamsAsJo.optString("content"));
        aVar.n(new d.a.l0.a.w2.h.a());
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            aVar.E(optParamsAsJo.optString("cancelColor"), d.a.l0.a.c.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(d.a.l0.a.h.aiapps_cancel);
            }
            aVar.C(optString2, new l(this, callbackHandler, unitedSchemeEntity));
            aVar.K(new m(this, callbackHandler, unitedSchemeEntity));
        }
        aVar.R(optParamsAsJo.optString("confirmColor"), d.a.l0.a.c.aiapps_modal_confirm_color);
        aVar.P(optString, new n(this, callbackHandler, unitedSchemeEntity));
        aVar.X();
        return true;
    }

    public final boolean y(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0 && params.containsKey("params") && !TextUtils.isEmpty(params.get("params"))) {
            try {
                JSONObject jSONObject = new JSONObject(params.get("params"));
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("message");
                String optString = jSONObject.optString("time");
                String optString2 = jSONObject.optString("clickCallback");
                if (TextUtils.isEmpty(string2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (TextUtils.isEmpty(string)) {
                    string = "1";
                }
                String str = string;
                try {
                    int E = E(optString);
                    q0.b0(new d(this, str, context, string2, E <= 0 ? 2 : E, callbackHandler, unitedSchemeEntity, jSONObject, optString2));
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final JSONArray z(JSONArray jSONArray) {
        d.a.l0.a.a2.e i2;
        if (jSONArray != null && jSONArray.length() > 0 && (i2 = d.a.l0.a.a2.e.i()) != null && !TextUtils.isEmpty(i2.f44425f) && !TextUtils.isEmpty(i2.Z())) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    String string = jSONArray.getString(i3);
                    PathType s = d.a.l0.a.k2.b.s(string);
                    if (s == PathType.BD_FILE) {
                        string = d.a.l0.a.k2.b.M(string, i2.f44425f);
                    } else if (s == PathType.RELATIVE) {
                        string = d.a.l0.a.k2.b.L(string, i2, i2.Z());
                    }
                    if (!TextUtils.isEmpty(string)) {
                        jSONArray.put(i3, string);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return jSONArray;
    }
}
