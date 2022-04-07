package com.repackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes7.dex */
public class tm4 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Map<String, sm4> b;
    public Resources c;
    public Resources d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755285962, "Lcom/repackage/tm4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755285962, "Lcom/repackage/tm4;");
        }
    }

    public tm4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.e = false;
    }

    public static int g(Resources resources, Resources resources2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, resources, resources2, i)) == null) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                i2 = i;
            } else {
                String packageName = SkinManager.getPackageName();
                f = packageName;
                if (StringUtils.isNull(packageName)) {
                    f = BdBaseApplication.getInst().getPackageName();
                }
                resourceName = f + resourceName.substring(resourceName.indexOf(":"));
                i2 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
            }
            if (i2 == 0) {
                BdLog.e(resourceName + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final void a(View view2) {
        Drawable f2;
        Drawable f3;
        Drawable f4;
        int q;
        ColorStateList e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            String str = "@" + view2.getId();
            Map<String, sm4> map = this.b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            sm4 sm4Var = this.b.get(str);
            if (view2 instanceof TextView) {
                if (sm4Var.v() != 0 && (e = e(this.a, sm4Var.u(), sm4Var.v())) != null) {
                    ((TextView) view2).setTextColor(e);
                }
                if (sm4Var.t() != 0) {
                    ((TextView) view2).setHintTextColor(e(this.a, sm4Var.s(), sm4Var.t()));
                }
                if (sm4Var.r() != 0) {
                    TextView textView = (TextView) view2;
                    Context context = view2.getContext();
                    if (this.a) {
                        q = sm4Var.r();
                    } else {
                        q = sm4Var.q();
                    }
                    textView.setTextAppearance(context, q);
                }
                if (sm4Var.k() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, f(this.a, sm4Var.j(), sm4Var.k()), (Drawable) null, (Drawable) null);
                }
                if (sm4Var.g() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(f(this.a, sm4Var.f(), sm4Var.g()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (sm4Var.i() != 0) {
                    ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, f(this.a, sm4Var.h(), sm4Var.i()), (Drawable) null);
                }
            } else if (view2 instanceof ImageButton) {
                if (sm4Var.n() != 0 && (f4 = f(this.a, sm4Var.m(), sm4Var.n())) != null) {
                    ((ImageView) view2).setImageDrawable(f4);
                }
            } else if (view2 instanceof ImageView) {
                if (sm4Var.n() != 0 && (f3 = f(this.a, sm4Var.m(), sm4Var.n())) != null) {
                    ((ImageView) view2).setImageDrawable(f3);
                }
            } else if ((view2 instanceof ProgressBar) && sm4Var.p() != 0 && (f2 = f(this.a, sm4Var.o(), sm4Var.p())) != null) {
                ((ProgressBar) view2).setProgressDrawable(f2);
            }
            if (sm4Var.c() != 0) {
                int paddingLeft = view2.getPaddingLeft();
                int paddingTop = view2.getPaddingTop();
                int paddingRight = view2.getPaddingRight();
                int paddingBottom = view2.getPaddingBottom();
                String resourceTypeName = this.c.getResourceTypeName(sm4Var.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view2.setBackgroundColor(d(this.a, sm4Var.b(), sm4Var.c()));
                } else {
                    view2.setBackgroundDrawable(f(this.a, sm4Var.b(), sm4Var.c()));
                }
                view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public final void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            String str = "@" + viewGroup.getId();
            Map<String, sm4> map = this.b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            sm4 sm4Var = this.b.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && sm4Var.e() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(f(this.a, sm4Var.d(), sm4Var.e()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (sm4Var.c() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.c.getResourceTypeName(sm4Var.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(d(this.a, sm4Var.b(), sm4Var.c()));
                } else {
                    viewGroup.setBackgroundDrawable(f(this.a, sm4Var.b(), sm4Var.c()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public void c() {
        Map<String, sm4> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (map = this.b) == null) {
            return;
        }
        map.clear();
        this.b = null;
    }

    public final int d(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.e && skinType == 4)) {
                return SkinManager.getColor(i);
            }
            if (!z) {
                return this.c.getColor(i);
            }
            if (i == i2) {
                Resources resources = this.c;
                this.d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.d;
            if (resources2 == null) {
                return this.c.getColor(i);
            }
            try {
                return resources2.getColor(i2);
            } catch (Resources.NotFoundException unused) {
                return this.c.getColor(i);
            }
        }
        return invokeCommon.intValue;
    }

    public final ColorStateList e(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.e && skinType == 4)) {
                return SkinManager.getColorList(i);
            }
            if (!z) {
                return this.c.getColorStateList(i);
            }
            if (i == i2) {
                Resources resources = this.c;
                this.d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.d;
            if (resources2 == null) {
                return this.c.getColorStateList(i);
            }
            try {
                return resources2.getColorStateList(i2);
            } catch (Resources.NotFoundException unused) {
                return this.c.getColorStateList(i);
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public final Drawable f(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.e && skinType == 4)) {
                return SkinManager.getDrawable(i);
            }
            if (!z) {
                try {
                    return this.c.getDrawable(i);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (i == i2) {
                Resources resources = this.c;
                this.d = resources;
                i2 = g(resources, resources, i);
            }
            Resources resources2 = this.d;
            if (resources2 == null) {
                try {
                    return this.c.getDrawable(i);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            try {
                try {
                    return resources2.getDrawable(i2);
                } catch (Throwable unused3) {
                    return null;
                }
            } catch (Resources.NotFoundException unused4) {
                return this.c.getDrawable(i);
            } catch (ArrayIndexOutOfBoundsException unused5) {
                return null;
            }
        }
        return (Drawable) invokeCommon.objValue;
    }

    public final int[] h(String str) {
        InterceptResult invokeL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
                return new int[]{parseInt, g(this.c, this.d, parseInt)};
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(String str, Context context, AttributeSet attributeSet) {
        int[] h;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, context, attributeSet) == null) {
            try {
                Resources resources = context.getResources();
                this.c = resources;
                this.d = resources;
                int attributeCount = attributeSet.getAttributeCount();
                sm4 sm4Var = new sm4();
                sm4Var.R(str);
                boolean z = false;
                for (int i = 0; i < attributeCount; i++) {
                    String attributeName = attributeSet.getAttributeName(i);
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeName.equals("id")) {
                        sm4Var.G(attributeValue);
                    } else if (attributeName.equals("tb_background")) {
                        int[] h2 = h(attributeValue);
                        if (h2 != null) {
                            sm4Var.w(h2[0]);
                            sm4Var.x(h2[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_src")) {
                        int[] h3 = h(attributeValue);
                        if (h3 != null) {
                            sm4Var.H(h3[0]);
                            sm4Var.I(h3[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColor")) {
                        int[] h4 = h(attributeValue);
                        if (h4 != null) {
                            sm4Var.P(h4[0]);
                            sm4Var.Q(h4[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_style")) {
                        int[] h5 = h(attributeValue);
                        if (h5 != null) {
                            sm4Var.L(h5[0]);
                            sm4Var.M(h5[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_divider")) {
                        int[] h6 = h(attributeValue);
                        if (h6 != null) {
                            sm4Var.y(h6[0]);
                            sm4Var.z(h6[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableTop")) {
                        int[] h7 = h(attributeValue);
                        if (h7 != null) {
                            sm4Var.E(h7[0]);
                            sm4Var.F(h7[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableLeft")) {
                        int[] h8 = h(attributeValue);
                        if (h8 != null) {
                            sm4Var.A(h8[0]);
                            sm4Var.B(h8[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableRight")) {
                        int[] h9 = h(attributeValue);
                        if (h9 != null) {
                            sm4Var.C(h9[0]);
                            sm4Var.D(h9[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_progressDrawable")) {
                        int[] h10 = h(attributeValue);
                        if (h10 != null) {
                            sm4Var.J(h10[0]);
                            sm4Var.K(h10[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColorHint") && (h = h(attributeValue)) != null) {
                        sm4Var.N(h[0]);
                        sm4Var.O(h[1]);
                        z = true;
                    }
                    if (z && TbConfig.getDebugSwitch() && (e = mg.e(attributeValue.substring(1), 0)) != 0) {
                        String resourceName = this.c.getResourceName(e);
                        sm4Var.a(attributeName + "=" + resourceName);
                    }
                }
                if (!z || TextUtils.isEmpty(sm4Var.l()) || this.b == null || this.b.containsKey(sm4Var.l())) {
                    return;
                }
                this.b.put(sm4Var.l(), sm4Var);
            } catch (Resources.NotFoundException unused) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(view2);
        while (!stack.isEmpty()) {
            View view3 = (View) stack.pop();
            if (view3 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view3;
                b(viewGroup);
                if (!(view3 instanceof AdapterView)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        stack.push(viewGroup.getChildAt(i));
                    }
                }
            } else {
                a(view3);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }

    public void l(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, resources) == null) {
            this.d = resources;
        }
    }
}
