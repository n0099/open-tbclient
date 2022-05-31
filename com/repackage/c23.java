package com.repackage;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c23 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public a(c23 c23Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c23Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;

        public b(c23 c23Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c23Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;

        public c(c23 c23Var, List list, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c23Var, list, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = context;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (String) this.a.get(i) : (String) invokeI.objValue;
        }

        public final void b(@NonNull View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
                if (i == 0) {
                    view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081160));
                } else {
                    view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08115f));
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d00cc, null);
                }
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f06);
                textView.setTextColor(this.c);
                textView.setText(getItem(i));
                b(view2, i);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ ly2 c;

        public d(c23 c23Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, ly2 ly2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c23Var, callbackHandler, unitedSchemeEntity, ly2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = ly2Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    this.c.dismiss();
                } catch (JSONException e) {
                    if (e13.b) {
                        e.printStackTrace();
                    }
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c23(e03 e03Var) {
        super(e03Var, "/swanAPI/showActionSheet");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (hz2Var != null && hz2Var.m0()) {
                if (e13.b) {
                    Log.d("ShowActionSheet", "ShowActionSheet does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (context != null && hz2Var != null) {
                return l(context, unitedSchemeEntity, callbackHandler);
            } else {
                hw1.c("ShowActionSheet", "aiapp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final int k(Context context, int i) {
        InterceptResult invokeLI;
        int s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i)) == null) {
            Resources resources = context.getResources();
            int dimensionPixelSize = ((((i + 1) * resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f7)) + resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f5)) + i) - 1;
            return (!yc3.J() || dimensionPixelSize <= (s = yc3.s(context) - yc3.t())) ? dimensionPixelSize : s;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        int i;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) != null) {
            return invokeLLL.booleanValue;
        }
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
        } catch (IllegalArgumentException | JSONException e) {
            if (e13.b) {
                e.printStackTrace();
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
                i = context.getResources().getColor(R.color.obfuscated_res_0x7f06037f);
            }
            ky2 ky2Var = new ky2(context);
            ky2Var.f(true);
            ky2Var.i(true);
            ky2Var.k(true);
            ky2Var.T(false);
            ky2Var.m(true);
            ky2Var.n(new pe3());
            ky2Var.s(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f5));
            ky2Var.p(R.drawable.obfuscated_res_0x7f080125);
            ky2Var.F(R.color.obfuscated_res_0x7f060a33);
            ky2Var.B(R.string.obfuscated_res_0x7f0f010b, new b(this, callbackHandler, unitedSchemeEntity));
            ky2Var.K(new a(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d00cb, null);
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f09123c);
            listView.setSelector(new ColorDrawable(0));
            listView.setAdapter((ListAdapter) new c(this, arrayList, context, i));
            ky2Var.W(inflate);
            ky2Var.j();
            ky2Var.q(k(context, arrayList.size()));
            ly2 c2 = ky2Var.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setDimAmount(0.65f);
                window.setLayout(yc3.s(context), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100394);
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
