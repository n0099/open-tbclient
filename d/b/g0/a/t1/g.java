package d.b.g0.a.t1;

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
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.l0;
import d.b.g0.a.q1.b.b.d;
import d.b.g0.a.q1.b.b.e;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.q1.b.b.i;
import d.b.g0.a.q1.b.c.a;
import d.b.g0.a.q1.b.f.d;
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
public class g extends UnitedSchemeBaseDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.g0.a.q1.b.b.h f46639a;

    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46642g;

        public a(g gVar, List list, Context context, int i) {
            this.f46640e = list;
            this.f46641f = context;
            this.f46642g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            return (String) this.f46640e.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f46640e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f46641f, d.b.g0.a.g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(d.b.g0.a.f.text);
            textView.setTextColor(this.f46642g);
            textView.setText(getItem(i));
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46644f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.q1.b.b.g f46645g;

        public b(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.q1.b.b.g gVar2) {
            this.f46643e = callbackHandler;
            this.f46644f = unitedSchemeEntity;
            this.f46645g = gVar2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i);
                UnitedSchemeUtility.callCallback(this.f46643e, this.f46644f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f46645g.dismiss();
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f46643e, this.f46644f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.q1.b.f.d.a();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46648g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46649h;
        public final /* synthetic */ CallbackHandler i;
        public final /* synthetic */ UnitedSchemeEntity j;
        public final /* synthetic */ JSONObject k;
        public final /* synthetic */ String l;

        /* loaded from: classes3.dex */
        public class a implements d.a {
            public a() {
            }

            @Override // d.b.g0.a.q1.b.f.d.a
            public void a() {
                d dVar = d.this;
                dVar.i.handleSchemeDispatchCallback(dVar.l, "");
            }
        }

        /* loaded from: classes3.dex */
        public class b implements d.a {
            public b() {
            }

            @Override // d.b.g0.a.q1.b.f.d.a
            public void a() {
                d dVar = d.this;
                dVar.i.handleSchemeDispatchCallback(dVar.l, "");
            }
        }

        public d(g gVar, String str, Context context, String str2, int i, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, String str3) {
            this.f46646e = str;
            this.f46647f = context;
            this.f46648g = str2;
            this.f46649h = i;
            this.i = callbackHandler;
            this.j = unitedSchemeEntity;
            this.k = jSONObject;
            this.l = str3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            String str = this.f46646e;
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
                d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(this.f46647f, this.f46648g);
                f2.k(this.f46649h);
                f2.C();
                UnitedSchemeUtility.callCallback(this.i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                return;
            }
            Uri uri = null;
            if (c2 == 1) {
                d.b.g0.a.q1.b.f.d f3 = d.b.g0.a.q1.b.f.d.f(this.f46647f, this.f46648g);
                f3.m(null);
                f3.k(this.f46649h);
                f3.x();
                UnitedSchemeUtility.callCallback(this.i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
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
                int i = TextUtils.equals(this.k.optString("bottomIconStyle"), "2") ? 2 : 1;
                String optString2 = this.k.optString("title");
                String optString3 = this.k.optString("buttonText");
                String optString4 = this.k.optString("style");
                int i2 = "2".equals(this.k.optString("bottomShowAnimationType")) ? 2 : 1;
                if (TextUtils.isEmpty(this.l)) {
                    this.j.result = UnitedSchemeUtility.wrapCallbackParams(202);
                } else if (!TextUtils.equals(optString4, "2") && !TextUtils.equals(optString4, "3")) {
                    d.b.g0.a.q1.b.f.d d2 = d.b.g0.a.q1.b.f.d.d(this.f46647f);
                    d2.n(uri);
                    d2.g(i);
                    d2.r(optString2);
                    d2.p(this.f46648g);
                    d2.j(optString3);
                    d2.i(1);
                    d2.h(i2);
                    d2.k(this.f46649h);
                    d2.s(new b());
                    d2.z();
                    UnitedSchemeUtility.callCallback(this.i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                } else {
                    d.b.g0.a.q1.b.f.d d3 = d.b.g0.a.q1.b.f.d.d(this.f46647f);
                    d3.n(uri);
                    d3.g(i);
                    d3.r(optString2);
                    d3.p(this.f46648g);
                    d3.j(optString3);
                    d3.i(2);
                    d3.h(i2);
                    d3.k(this.f46649h);
                    d3.s(new a());
                    d3.z();
                    UnitedSchemeUtility.callCallback(this.i, this.j, UnitedSchemeUtility.wrapCallbackParams(0));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46653f;

        public e(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46652e = callbackHandler;
            this.f46653f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            d.b.g0.a.q1.b.b.h unused = g.f46639a = null;
            UnitedSchemeUtility.callCallback(this.f46652e, this.f46653f, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46654e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46655f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46656g;

        public f(g gVar, boolean z, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46654e = z;
            this.f46655f = callbackHandler;
            this.f46656g = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            d.b.g0.a.q1.b.b.h unused = g.f46639a = null;
            try {
                JSONArray f2 = ((d.b.g0.a.q1.b.b.e) dialogInterface).f();
                JSONObject jSONObject = new JSONObject();
                if (f2 != null && f2.length() > 0) {
                    if (this.f46654e) {
                        jSONObject.put("value", f2.optInt(0));
                    } else {
                        jSONObject.put("value", f2);
                    }
                }
                UnitedSchemeUtility.callCallback(this.f46655f, this.f46656g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: d.b.g0.a.t1.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0844g implements BdMultiPicker.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46658b;

        public C0844g(g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f46657a = unitedSchemeEntity;
            this.f46658b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
        public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
            String optString = UnitedSchemeUtility.optParamsAsJo(this.f46657a).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f46658b.handleSchemeDispatchCallback(optString, jSONObject.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46660f;

        public h(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46659e = callbackHandler;
            this.f46660f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            UnitedSchemeUtility.callCallback(this.f46659e, this.f46660f, 0);
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46662f;

        public i(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46661e = callbackHandler;
            this.f46662f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            d.b.g0.a.q1.b.b.i iVar = (d.b.g0.a.q1.b.b.i) dialogInterface;
            String format = String.format("%02d:%02d", Integer.valueOf(iVar.f()), Integer.valueOf(iVar.g()));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", format);
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                if (d.b.g0.a.k.f45443a) {
                    Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                }
                UnitedSchemeUtility.callCallback(this.f46661e, this.f46662f, wrapCallbackParams);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46663e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46664f;

        public j(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46663e = callbackHandler;
            this.f46664f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            UnitedSchemeUtility.callCallback(this.f46663e, this.f46664f, 0);
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46666f;

        public k(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46665e = callbackHandler;
            this.f46666f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (dialogInterface instanceof d.b.g0.a.q1.b.b.d) {
                String h2 = ((d.b.g0.a.q1.b.b.d) dialogInterface).h();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", h2);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    if (d.b.g0.a.k.f45443a) {
                        Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                    }
                    UnitedSchemeUtility.callCallback(this.f46665e, this.f46666f, wrapCallbackParams);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46668f;

        public l(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46667e = callbackHandler;
            this.f46668f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                UnitedSchemeUtility.callCallback(this.f46667e, this.f46668f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f46667e, this.f46668f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46670f;

        public m(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46669e = callbackHandler;
            this.f46670f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                UnitedSchemeUtility.callCallback(this.f46669e, this.f46670f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f46669e, this.f46670f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46672f;

        public n(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46671e = callbackHandler;
            this.f46672f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "confirm");
                UnitedSchemeUtility.callCallback(this.f46671e, this.f46672f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } catch (JSONException unused) {
                UnitedSchemeUtility.callCallback(this.f46671e, this.f46672f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46674f;

        public o(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46673e = callbackHandler;
            this.f46674f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f46673e, this.f46674f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes3.dex */
    public class p implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46676f;

        public p(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46675e = callbackHandler;
            this.f46676f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            UnitedSchemeUtility.callCallback(this.f46675e, this.f46676f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
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
            return d.b.g0.a.b2.b.g(d.b.g0.g.m.a.m().s(), frameType);
        }
        return d.b.g0.a.b2.b.g(d.b.g0.a.e0.w.d.L().T(), frameType);
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
            i.a aVar = new i.a(context);
            if (!TextUtils.isEmpty(optString4)) {
                aVar.m(optString4);
            }
            aVar.o(D);
            aVar.l(D2);
            aVar.n(D3);
            aVar.k(optBoolean);
            aVar.g(d.b.g0.a.h.aiapps_ok, new i(this, callbackHandler, unitedSchemeEntity));
            aVar.d(d.b.g0.a.h.aiapps_cancel, new h(this, callbackHandler, unitedSchemeEntity));
            aVar.j();
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
        } else if (f46639a == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i2 = jSONObject.getInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int i3 = jSONObject.getInt(ProgressInfo.JSON_KEY_CURRENT);
                if (optJSONArray != null) {
                    ((d.b.g0.a.q1.b.b.e) f46639a).k(i2, optJSONArray, i3);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                return true;
            } catch (JSONException e2) {
                if (d.b.g0.a.k.f45443a) {
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
        int r;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_bottom_divider)) + i2) - 1;
        return (!h0.C() || dimensionPixelSize <= (r = h0.r(context) - h0.s())) ? dimensionPixelSize : r;
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
        Pair<Integer, Integer> c2 = d.b.g0.a.z0.f.V().c();
        Pair<Integer, Integer> G = d.b.g0.a.z0.f.V().G();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", h0.H(((Integer) c2.first).intValue()));
            jSONObject.put("screenHeight", h0.H(((Integer) c2.second).intValue()));
            jSONObject.put("windowWidth", (int) (((Integer) G.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) G.second).intValue() / displayMetrics.density));
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, d(configuration));
            jSONObject.put("version", k0.z());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            jSONObject.put("fontSizeSetting", d.b.g0.a.w0.a.l().J());
            jSONObject.put("SDKVersion", e(context));
            jSONObject.put("swanNativeVersion", d.b.g0.a.l.a());
            jSONObject.put("host", d.b.g0.a.w0.a.k().g());
            jSONObject.put("statusBarHeight", h0.H(h0.s()));
            jSONObject.put("navigationBarHeight", h0.H(h0.h()));
            d.b.g0.a.t.c.n.d.r(jSONObject);
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
        Date c2 = d.b.g0.a.i2.j.c(optString, "yyyy-MM-dd");
        Date c3 = d.b.g0.a.i2.j.c(optString2, "yyyy-MM-dd");
        if (c2 != null && c3 != null && !c3.before(c2)) {
            Date date = new Date();
            if (!TextUtils.isEmpty(optString3) && (d2 = d.b.g0.a.i2.j.d(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) != null) {
                date = d2;
            }
            if (date.before(c2)) {
                date = c2;
            } else if (date.after(c3)) {
                date = c3;
            }
            d.a aVar = new d.a(context);
            if (!TextUtils.isEmpty(optString4)) {
                aVar.m(optString4);
            }
            aVar.o(c2);
            aVar.l(c3);
            aVar.n(date);
            aVar.k(optBoolean);
            aVar.g(d.b.g0.a.h.aiapps_ok, new k(this, callbackHandler, unitedSchemeEntity));
            aVar.d(d.b.g0.a.h.aiapps_cancel, new j(this, callbackHandler, unitedSchemeEntity));
            aVar.j();
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
        k0.X(new c(this));
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (l0.b(context).a() != null) {
                jSONObject.put("data", l0.b(context).a().toString());
            }
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
            jSONObject.put("imei", k0.r());
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
        if (!(context instanceof a.InterfaceC0777a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0777a) context).getFloatLayer();
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
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, d.b.g0.a.i2.e.f(context, intent) ? 0 : 1001);
        return true;
    }

    public final boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return q(context, unitedSchemeEntity, callbackHandler, false);
    }

    public final boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        String param = unitedSchemeEntity.getParam("params");
        if (f46639a != null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String string = context.getString(d.b.g0.a.h.aiapps_picker_default_title);
            if (!TextUtils.isEmpty(param)) {
                JSONObject jSONObject = new JSONObject(param);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                jSONObject.optString("title", string);
                jSONArray = optJSONArray;
            }
            e.a aVar = new e.a(context);
            aVar.k(jSONArray);
            aVar.l(jSONArray2);
            aVar.n(z);
            aVar.m(new C0844g(this, unitedSchemeEntity, callbackHandler));
            aVar.g(d.b.g0.a.h.aiapps_ok, new f(this, z, callbackHandler, unitedSchemeEntity));
            aVar.d(d.b.g0.a.h.aiapps_cancel, new e(this, callbackHandler, unitedSchemeEntity));
            f46639a = aVar.j();
            return false;
        } catch (JSONException e2) {
            if (d.b.g0.a.k.f45443a) {
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
                    d.b.g0.a.w0.a.s().a(context, strArr, c2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } catch (JSONException e2) {
            if (d.b.g0.a.k.f45443a) {
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
        l0.b(context).c(optParamsAsJo.optString("data"));
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
                i2 = context.getResources().getColor(d.b.g0.a.c.aiapps_action_sheet_item_color);
            }
            g.a aVar = new g.a(context);
            aVar.f(true);
            aVar.i(true);
            aVar.k(true);
            aVar.m(true);
            aVar.n(new d.b.g0.a.j2.g.a());
            aVar.t(context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_bottom_divider));
            aVar.p(d.b.g0.a.e.aiapps_action_sheet_bg);
            aVar.C(d.b.g0.a.h.aiapps_cancel, new p(this, callbackHandler, unitedSchemeEntity));
            aVar.L(new o(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, d.b.g0.a.g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(d.b.g0.a.f.list);
            listView.setAdapter((ListAdapter) new a(this, arrayList, context, i2));
            aVar.W(inflate);
            aVar.j();
            aVar.q(b(context, arrayList.size()));
            d.b.g0.a.q1.b.b.g c2 = aVar.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(h0.r(context), -2);
                window.setWindowAnimations(d.b.g0.a.i.action_sheet_animation);
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
        if (!(context instanceof a.InterfaceC0777a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0777a) context).getFloatLayer();
        View e2 = floatLayer.e();
        if (e2 instanceof LoadingView) {
            loadingView = (LoadingView) e2;
        } else {
            loadingView = new LoadingView(context);
            floatLayer.j(loadingView);
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
            optString = context.getString(d.b.g0.a.h.aiapps_ok);
        }
        g.a aVar = new g.a(context);
        aVar.V(optParamsAsJo.optString("title"));
        aVar.y(optParamsAsJo.optString("content"));
        aVar.n(new d.b.g0.a.j2.g.a());
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            aVar.F(optParamsAsJo.optString("cancelColor"), d.b.g0.a.c.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(d.b.g0.a.h.aiapps_cancel);
            }
            aVar.D(optString2, new l(this, callbackHandler, unitedSchemeEntity));
            aVar.L(new m(this, callbackHandler, unitedSchemeEntity));
        }
        aVar.R(optParamsAsJo.optString("confirmColor"), d.b.g0.a.c.aiapps_modal_confirm_color);
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
                    k0.X(new d(this, str, context, string2, E <= 0 ? 2 : E, callbackHandler, unitedSchemeEntity, jSONObject, optString2));
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
        d.b.g0.a.r1.e y;
        if (jSONArray != null && jSONArray.length() > 0 && (y = d.b.g0.a.r1.e.y()) != null && !TextUtils.isEmpty(y.f46132f) && !TextUtils.isEmpty(y.W())) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    String string = jSONArray.getString(i2);
                    PathType c2 = d.b.g0.a.a2.b.c(string);
                    if (c2 == PathType.BD_FILE) {
                        string = d.b.g0.a.a2.b.u(string, y.f46132f);
                    } else if (c2 == PathType.RELATIVE) {
                        string = d.b.g0.a.a2.b.t(string, y, y.W());
                    }
                    if (!TextUtils.isEmpty(string)) {
                        jSONArray.put(i2, string);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return jSONArray;
    }
}
