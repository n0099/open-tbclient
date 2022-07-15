package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class er4 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<CharSequence> b;
    public c c;
    public final Activity d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final TextView g;
    public final View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;
    public LinearLayout.LayoutParams p;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ er4 c;

        public a(er4 er4Var, int i, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er4Var, Integer.valueOf(i), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = er4Var;
            this.a = i;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.c.a(this.c, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a */
        public static final int obfuscated_res_0x7f1003a5 = 2131755941;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-405175124, "Lcom/repackage/er4$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-405175124, "Lcom/repackage/er4$b;");
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(er4 er4Var, int i, View view2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755728022, "Lcom/repackage/er4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755728022, "Lcom/repackage/er4;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080488)});
        q.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.CAM_X0201)});
    }

    public er4(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d021e, (ViewGroup) null);
        this.e = viewGroup;
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090794);
        this.f = (ViewGroup) this.e.findViewById(R.id.obfuscated_res_0x7f09077a);
        this.h = this.e.findViewById(R.id.obfuscated_res_0x7f0912ba);
        this.i = R.layout.obfuscated_res_0x7f0d021f;
    }

    public void b(d9<?> d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d9Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (d9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) d9Var;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.e);
            }
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811a4);
        }
    }

    public er4 c(d9<?> d9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d9Var)) == null) {
            if (this.m) {
                return this;
            }
            this.m = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.g.setText(this.a);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
            List<CharSequence> list = this.b;
            if (list != null && list.size() > 0) {
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    d(i);
                }
            }
            b(d9Var);
            return this;
        }
        return (er4) invokeL.objValue;
    }

    public final View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View inflate = LayoutInflater.from(this.d).inflate(this.i, this.f, false);
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090785);
            LinearLayout.LayoutParams layoutParams = this.p;
            if (layoutParams != null) {
                textView.setLayoutParams(layoutParams);
            }
            int i2 = this.l;
            if (i2 != -1) {
                textView.setTextSize(0, i2);
            }
            if (this.o != -1) {
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(this.o);
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0912b0);
            CharSequence charSequence = this.b.get(i);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i == this.b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i == 0 && StringUtils.isNull(this.a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.c != null) {
                linearLayout.setOnClickListener(new a(this, i, textView));
            }
            this.f.addView(inflate);
            return inflate;
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.n) == null) {
            return;
        }
        sg.a(alertDialog, this.d);
    }

    public View f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ViewGroup viewGroup = this.f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i < 0 || i > childCount - 1) {
                return null;
            }
            return this.f.getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    public er4 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (er4) invokeI.objValue;
    }

    public er4 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (er4) invokeI.objValue;
    }

    public er4 i(List<CharSequence> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, cVar)) == null) {
            if (list != null && list.size() > 0) {
                this.b = list;
                if (cVar != null) {
                    this.c = cVar;
                }
            }
            return this;
        }
        return (er4) invokeLL.objValue;
    }

    public er4 j(CharSequence[] charSequenceArr, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, cVar)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), cVar);
            }
            return this;
        }
        return (er4) invokeLL.objValue;
    }

    public er4 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            l(this.d.getResources().getString(i));
            return this;
        }
        return (er4) invokeI.objValue;
    }

    public er4 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (er4) invokeL.objValue;
    }

    public er4 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.m) {
                AlertDialog alertDialog = this.n;
                if (alertDialog != null) {
                    sg.i(alertDialog, this.d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.d, R.style.obfuscated_res_0x7f10013a).create();
                this.n = create;
                create.setCanceledOnTouchOutside(true);
                if (sg.i(this.n, this.d)) {
                    Window window = this.n.getWindow();
                    if (this.j == -1) {
                        this.j = b.obfuscated_res_0x7f1003a5;
                    }
                    if (this.k == -1) {
                        this.k = 17;
                    }
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.5f;
                    window.setAttributes(attributes);
                    window.setGravity(this.k);
                    window.setContentView(this.e);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (er4) invokeV.objValue;
    }
}
