package d.b.g0.a.t1.k.j0;

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
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.h;
import d.b.g0.a.i;
import d.b.g0.a.i2.h0;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
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
        public final /* synthetic */ CallbackHandler f46416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46417f;

        public a(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46416e = callbackHandler;
            this.f46417f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f46416e, this.f46417f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46419f;

        public b(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46418e = callbackHandler;
            this.f46419f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            UnitedSchemeUtility.callCallback(this.f46418e, this.f46419f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* renamed from: d.b.g0.a.t1.k.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0838c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46421f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46422g;

        public C0838c(c cVar, List list, Context context, int i) {
            this.f46420e = list;
            this.f46421f = context;
            this.f46422g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            return (String) this.f46420e.get(i);
        }

        public final void b(@NonNull View view, int i) {
            if (i == 0) {
                view.setBackground(this.f46421f.getResources().getDrawable(d.b.g0.a.e.swan_image_menu_item_rounded_bg));
            } else {
                view.setBackground(this.f46421f.getResources().getDrawable(d.b.g0.a.e.swan_image_menu_item_bg));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f46420e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f46421f, g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(f.text);
            textView.setTextColor(this.f46422g);
            textView.setText(getItem(i));
            b(view, i);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.q1.b.b.g f46425g;

        public d(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.q1.b.b.g gVar) {
            this.f46423e = callbackHandler;
            this.f46424f = unitedSchemeEntity;
            this.f46425g = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i);
                UnitedSchemeUtility.callCallback(this.f46423e, this.f46424f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f46425g.dismiss();
            } catch (JSONException e2) {
                if (a0.f46287b) {
                    e2.printStackTrace();
                }
                UnitedSchemeUtility.callCallback(this.f46423e, this.f46424f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/showActionSheet");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f46287b) {
                Log.d("ShowActionSheet", "ShowActionSheet does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (context != null && eVar != null) {
            return l(context, unitedSchemeEntity, callbackHandler);
        } else {
            d.b.g0.a.c0.c.b("ShowActionSheet", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public final int k(Context context, int i) {
        int r;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((((i + 1) * resources.getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_bottom_divider)) + i) - 1;
        return (!h0.C() || dimensionPixelSize <= (r = h0.r(context) - h0.s())) ? dimensionPixelSize : r;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        int i;
        String optString;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            optString = optParamsAsJo.optString("itemColor");
        } catch (IllegalArgumentException | JSONException e2) {
            if (a0.f46287b) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.length() == 4 && optString.charAt(0) == '#') {
                optString = SwanAppConfigData.d(optString);
            }
            i = Color.parseColor(optString);
            if (!arrayList.isEmpty()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (i == -1) {
                i = context.getResources().getColor(d.b.g0.a.c.aiapps_action_sheet_item_color);
            }
            d.b.g0.a.q1.b.b.f fVar = new d.b.g0.a.q1.b.b.f(context);
            fVar.f(true);
            fVar.i(true);
            fVar.k(true);
            fVar.T(false);
            fVar.m(true);
            fVar.n(new d.b.g0.a.j2.g.a());
            fVar.t(context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_bottom_divider));
            fVar.p(d.b.g0.a.e.aiapps_action_sheet_bg);
            fVar.G(d.b.g0.a.c.swan_app_action_sheet_cancel_text);
            fVar.C(h.aiapps_cancel, new b(this, callbackHandler, unitedSchemeEntity));
            fVar.L(new a(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(f.list);
            listView.setSelector(new ColorDrawable(0));
            listView.setAdapter((ListAdapter) new C0838c(this, arrayList, context, i));
            fVar.W(inflate);
            fVar.j();
            fVar.q(k(context, arrayList.size()));
            d.b.g0.a.q1.b.b.g c2 = fVar.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(h0.r(context), -2);
                window.setWindowAnimations(i.action_sheet_animation);
            }
            c2.a(false);
            c2.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new d(this, callbackHandler, unitedSchemeEntity, c2));
            c2.show();
            return true;
        }
        i = -1;
        if (!arrayList.isEmpty()) {
        }
    }
}
