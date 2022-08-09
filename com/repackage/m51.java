package com.repackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tm0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class m51 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ AdBaseModel b;
        public final /* synthetic */ m51 c;

        public a(m51 m51Var, List list, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m51Var, list, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m51Var;
            this.a = list;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.a != null) {
                    this.c.a.a(this.a);
                }
                this.c.g(this.b, this.a);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ m51 b;

        public b(m51 m51Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m51Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m51Var;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.dismiss();
                mg0.c(this.a.g.c, this.b.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tm0.a a;
        public final /* synthetic */ List b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ m51 e;

        public c(m51 m51Var, tm0.a aVar, List list, TextView textView, TextView textView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m51Var, aVar, list, textView, textView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m51Var;
            this.a = aVar;
            this.b = list;
            this.c = textView;
            this.d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.c()) {
                    this.a.f(false);
                    if (this.b.contains(this.a)) {
                        wx0.j(this.b, this.a);
                    }
                    if (this.b.size() == 0) {
                        this.c.setText(view2.getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0b8e));
                    }
                    this.d.setTextColor(view2.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060263));
                    return;
                }
                this.a.f(true);
                if (!this.b.contains(this.a)) {
                    wx0.b(this.b, this.a);
                }
                this.d.setTextColor(view2.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060271));
                this.c.setText(view2.getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0b8f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(List<tm0.a> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m51(Context context, @NonNull AdBaseModel adBaseModel) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f(adBaseModel);
    }

    public final void c(AdBaseModel adBaseModel) {
        int i;
        tm0 tm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = null;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05cf, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092311);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0912e6);
            textView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0b8e));
            textView.setOnClickListener(new a(this, arrayList, adBaseModel));
            inflate.setBackground(inflate.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d81));
            Resources resources = inflate.getContext().getResources();
            int i2 = R.color.obfuscated_res_0x7f060263;
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060263));
            findViewById.setBackgroundColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602bc));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09126a);
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923c5);
            if (adBaseModel != null && (tm0Var = adBaseModel.g) != null && !TextUtils.isEmpty(tm0Var.c)) {
                if (!TextUtils.isEmpty(adBaseModel.g.a)) {
                    textView2.setText(adBaseModel.g.a);
                }
                textView2.setVisibility(0);
                textView2.setOnClickListener(new b(this, adBaseModel));
            } else {
                textView2.setVisibility(8);
            }
            List<tm0.a> d2 = d(adBaseModel);
            if (d2 == null) {
                linearLayout.setVisibility(8);
                return;
            }
            int min = Math.min(d2.size(), 7);
            int i3 = 0;
            while (i3 < min) {
                tm0.a aVar = (tm0.a) wx0.d(d2, i3);
                if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                    i = i3;
                } else {
                    View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d05dc, viewGroup);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f092331);
                    textView3.setText(aVar.a());
                    textView3.setTextColor(inflate.getContext().getResources().getColor(i2));
                    i = i3;
                    inflate2.setOnClickListener(new c(this, aVar, arrayList, textView, textView3));
                    linearLayout.addView(inflate2);
                }
                i3 = i + 1;
                viewGroup = null;
                i2 = R.color.obfuscated_res_0x7f060263;
            }
            setContentView(inflate);
        }
    }

    public final List<tm0.a> d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        tm0 tm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel)) == null) {
            if (adBaseModel == null || (tm0Var = adBaseModel.g) == null) {
                return null;
            }
            return tm0Var.b;
        }
        return (List) invokeL.objValue;
    }

    public String e(List<tm0.a> list) {
        InterceptResult invokeL;
        tm0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return StringUtil.EMPTY_ARRAY;
            }
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if (((tm0.a) wx0.d(list, i)) != null) {
                    str = !TextUtils.isEmpty(str) ? str + "," + aVar.b() : str + aVar.b();
                }
            }
            return TextUtils.isEmpty(str) ? StringUtil.EMPTY_ARRAY : str;
        }
        return (String) invokeL.objValue;
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || (window = getWindow()) == null) {
            return;
        }
        window.requestFeature(1);
        c(adBaseModel);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.obfuscated_res_0x7f1003c1;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
    }

    public final void g(AdBaseModel adBaseModel, List<tm0.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, list) == null) || adBaseModel == null) {
            return;
        }
        hy0.b(new ly0().e(e(list)).g(adBaseModel.f.d).f(dh0.a().b()));
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.a = dVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Window window = getWindow();
            if (window == null) {
                j01.b(this);
                return;
            }
            window.setFlags(8, 8);
            j01.b(this);
            e11.a(window);
            window.clearFlags(8);
        }
    }
}
