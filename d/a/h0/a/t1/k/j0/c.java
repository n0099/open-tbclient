package d.a.h0.a.t1.k.j0;

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
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i;
import d.a.h0.a.i2.h0;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
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
        public final /* synthetic */ CallbackHandler f44534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44535f;

        public a(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44534e = callbackHandler;
            this.f44535f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UnitedSchemeUtility.callCallback(this.f44534e, this.f44535f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44537f;

        public b(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44536e = callbackHandler;
            this.f44537f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            UnitedSchemeUtility.callCallback(this.f44536e, this.f44537f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
        }
    }

    /* renamed from: d.a.h0.a.t1.k.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0810c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44538e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44539f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44540g;

        public C0810c(c cVar, List list, Context context, int i2) {
            this.f44538e = list;
            this.f44539f = context;
            this.f44540g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            return (String) this.f44538e.get(i2);
        }

        public final void b(@NonNull View view, int i2) {
            if (i2 == 0) {
                view.setBackground(this.f44539f.getResources().getDrawable(d.a.h0.a.e.swan_image_menu_item_rounded_bg));
            } else {
                view.setBackground(this.f44539f.getResources().getDrawable(d.a.h0.a.e.swan_image_menu_item_bg));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f44538e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.f44539f, g.aiapps_scheme_utils_show_action_sheet_item, null);
            }
            TextView textView = (TextView) view.findViewById(f.text);
            textView.setTextColor(this.f44540g);
            textView.setText(getItem(i2));
            b(view, i2);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44541e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44542f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.q1.b.b.g f44543g;

        public d(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.h0.a.q1.b.b.g gVar) {
            this.f44541e = callbackHandler;
            this.f44542f = unitedSchemeEntity;
            this.f44543g = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tapIndex", i2);
                UnitedSchemeUtility.callCallback(this.f44541e, this.f44542f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                this.f44543g.dismiss();
            } catch (JSONException e2) {
                if (a0.f44398b) {
                    e2.printStackTrace();
                }
                UnitedSchemeUtility.callCallback(this.f44541e, this.f44542f, UnitedSchemeUtility.wrapCallbackParams(201));
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/showActionSheet");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar != null && eVar.Z()) {
            if (a0.f44398b) {
                Log.d("ShowActionSheet", "ShowActionSheet does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (context != null && eVar != null) {
            return l(context, unitedSchemeEntity, callbackHandler);
        } else {
            d.a.h0.a.c0.c.b("ShowActionSheet", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    public final int k(Context context, int i2) {
        int r;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(d.a.h0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(d.a.h0.a.d.aiapps_action_sheet_bottom_divider)) + i2) - 1;
        return (!h0.C() || dimensionPixelSize <= (r = h0.r(context) - h0.s())) ? dimensionPixelSize : r;
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
            if (a0.f44398b) {
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
                i2 = context.getResources().getColor(d.a.h0.a.c.aiapps_action_sheet_item_color);
            }
            d.a.h0.a.q1.b.b.f fVar = new d.a.h0.a.q1.b.b.f(context);
            fVar.f(true);
            fVar.i(true);
            fVar.k(true);
            fVar.T(false);
            fVar.m(true);
            fVar.n(new d.a.h0.a.j2.g.a());
            fVar.t(context.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_action_sheet_bottom_divider));
            fVar.p(d.a.h0.a.e.aiapps_action_sheet_bg);
            fVar.G(d.a.h0.a.c.swan_app_action_sheet_cancel_text);
            fVar.C(h.aiapps_cancel, new b(this, callbackHandler, unitedSchemeEntity));
            fVar.L(new a(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(f.list);
            listView.setSelector(new ColorDrawable(0));
            listView.setAdapter((ListAdapter) new C0810c(this, arrayList, context, i2));
            fVar.W(inflate);
            fVar.j();
            fVar.q(k(context, arrayList.size()));
            d.a.h0.a.q1.b.b.g c2 = fVar.c();
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
        i2 = -1;
        if (!arrayList.isEmpty()) {
        }
    }
}
