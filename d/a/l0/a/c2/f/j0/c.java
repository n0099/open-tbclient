package d.a.l0.a.c2.f.j0;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.i;
import d.a.l0.a.v2.n0;
import d.a.l0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44766f;

        public a(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44765e = callbackHandler;
            this.f44766f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f44765e, this.f44766f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44768f;

        public b(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44767e = callbackHandler;
            this.f44768f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            UnitedSchemeUtility.callCallback(this.f44767e, this.f44768f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* renamed from: d.a.l0.a.c2.f.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0640c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44770f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44771g;

        public C0640c(c cVar, List list, Context context, int i2) {
            this.f44769e = list;
            this.f44770f = context;
            this.f44771g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            return (String) this.f44769e.get(i2);
        }

        public final void b(@NonNull View view, int i2) {
            if (i2 == 0) {
                view.setBackground(this.f44770f.getResources().getDrawable(d.a.l0.a.e.swan_image_menu_item_rounded_bg));
            } else {
                view.setBackground(this.f44770f.getResources().getDrawable(d.a.l0.a.e.swan_image_menu_item_bg));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f44769e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f44770f, g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(f.text);
            textView.setTextColor(this.f44771g);
            textView.setText(getItem(i2));
            b(view, i2);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44773f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f44774g;

        public d(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, h hVar) {
            this.f44772e = callbackHandler;
            this.f44773f = unitedSchemeEntity;
            this.f44774g = hVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i2);
                UnitedSchemeUtility.callCallback(this.f44772e, this.f44773f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f44774g.dismiss();
            } catch (JSONException e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
                UnitedSchemeUtility.callCallback(this.f44772e, this.f44773f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showActionSheet");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar != null && eVar.d0()) {
            if (a0.f44625b) {
                Log.d("ShowActionSheet", "ShowActionSheet does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (context != null && eVar != null) {
            return l(context, unitedSchemeEntity, callbackHandler);
        } else {
            d.a.l0.a.e0.d.b("ShowActionSheet", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public final int k(Context context, int i2) {
        int t;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_bottom_divider)) + i2) - 1;
        return (!n0.F() || dimensionPixelSize <= (t = n0.t(context) - n0.u())) ? dimensionPixelSize : t;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
        } catch (IllegalArgumentException | JSONException e2) {
            if (a0.f44625b) {
                e2.printStackTrace();
            }
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
            d.a.l0.a.z1.b.b.g gVar = new d.a.l0.a.z1.b.b.g(context);
            gVar.f(true);
            gVar.i(true);
            gVar.k(true);
            gVar.T(false);
            gVar.m(true);
            gVar.n(new d.a.l0.a.w2.h.a());
            gVar.s(context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_bottom_divider));
            gVar.p(d.a.l0.a.e.aiapps_action_sheet_bg);
            gVar.F(d.a.l0.a.c.swan_app_action_sheet_cancel_text);
            gVar.B(d.a.l0.a.h.aiapps_cancel, new b(this, callbackHandler, unitedSchemeEntity));
            gVar.K(new a(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(f.list);
            listView.setSelector(new ColorDrawable(0));
            listView.setAdapter((ListAdapter) new C0640c(this, arrayList, context, i2));
            gVar.W(inflate);
            gVar.j();
            gVar.q(k(context, arrayList.size()));
            h c2 = gVar.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(n0.t(context), -2);
                window.setWindowAnimations(i.action_sheet_animation);
            }
            c2.a(false);
            c2.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new d(this, callbackHandler, unitedSchemeEntity, c2));
            c2.show();
            return true;
        }
        i2 = -1;
        if (!arrayList.isEmpty()) {
        }
    }
}
