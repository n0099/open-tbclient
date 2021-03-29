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
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46418f;

        public a(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46417e = callbackHandler;
            this.f46418f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f46417e, this.f46418f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46420f;

        public b(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46419e = callbackHandler;
            this.f46420f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            UnitedSchemeUtility.callCallback(this.f46419e, this.f46420f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* renamed from: d.b.g0.a.t1.k.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0839c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46422f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46423g;

        public C0839c(c cVar, List list, Context context, int i) {
            this.f46421e = list;
            this.f46422f = context;
            this.f46423g = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            return (String) this.f46421e.get(i);
        }

        public final void b(@NonNull View view, int i) {
            if (i == 0) {
                view.setBackground(this.f46422f.getResources().getDrawable(d.b.g0.a.e.swan_image_menu_item_rounded_bg));
            } else {
                view.setBackground(this.f46422f.getResources().getDrawable(d.b.g0.a.e.swan_image_menu_item_bg));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f46421e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f46422f, g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(f.text);
            textView.setTextColor(this.f46423g);
            textView.setText(getItem(i));
            b(view, i);
            return view;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.q1.b.b.g f46426g;

        public d(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.b.g0.a.q1.b.b.g gVar) {
            this.f46424e = callbackHandler;
            this.f46425f = unitedSchemeEntity;
            this.f46426g = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i);
                UnitedSchemeUtility.callCallback(this.f46424e, this.f46425f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f46426g.dismiss();
            } catch (JSONException e2) {
                if (a0.f46288b) {
                    e2.printStackTrace();
                }
                UnitedSchemeUtility.callCallback(this.f46424e, this.f46425f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/showActionSheet");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f46288b) {
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
            if (a0.f46288b) {
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
            listView.setAdapter((ListAdapter) new C0839c(this, arrayList, context, i));
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
