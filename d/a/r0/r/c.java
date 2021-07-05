package d.a.r0.r;

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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f55567f;

    /* renamed from: g  reason: collision with root package name */
    public static String f55568g;

    /* renamed from: h  reason: collision with root package name */
    public static int f55569h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55570a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, b> f55571b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f55572c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f55573d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55574e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1863179521, "Ld/a/r0/r/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1863179521, "Ld/a/r0/r/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55570a = false;
        this.f55571b = new HashMap();
        this.f55574e = false;
    }

    public static int g(Resources resources, Resources resources2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, resources, resources2, i2)) == null) {
            if (f55567f) {
                String resourceName = resources.getResourceName(i2);
                if (TextUtils.isEmpty(resourceName)) {
                    i3 = i2;
                } else {
                    if (f55569h == 0) {
                        String packageName = BdBaseApplication.getInst().getPackageName();
                        f55568g = packageName;
                        f55569h = packageName.length();
                    }
                    int length = resourceName.length();
                    int i4 = f55569h;
                    if (length > i4 && resourceName.charAt(i4) != ':' && resourceName.startsWith(f55568g)) {
                        resourceName = f55568g + resourceName.substring(resourceName.indexOf(":"));
                    }
                    i3 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
                    if (i3 <= 0) {
                        resourceName = SkinManager.PLUGIN_NIGHT_RESOURCE + resourceName.substring(resourceName.indexOf(":"));
                        i3 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
                    }
                }
                if (i3 == 0) {
                    BdLog.e(resourceName + " 缺少夜间资源,使用了日间资源");
                    return i2;
                }
                return i3;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final void a(View view) {
        Drawable f2;
        Drawable f3;
        Drawable f4;
        int q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            String str = TNCManager.TNC_PROBE_HEADER_SECEPTOR + view.getId();
            Map<String, b> map = this.f55571b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            b bVar = this.f55571b.get(str);
            if (view instanceof TextView) {
                if (bVar.v() != 0) {
                    ((TextView) view).setTextColor(e(this.f55570a, bVar.u(), bVar.v()));
                }
                if (bVar.t() != 0) {
                    ((TextView) view).setHintTextColor(e(this.f55570a, bVar.s(), bVar.t()));
                }
                if (bVar.r() != 0) {
                    TextView textView = (TextView) view;
                    Context context = view.getContext();
                    if (this.f55570a) {
                        q = bVar.r();
                    } else {
                        q = bVar.q();
                    }
                    textView.setTextAppearance(context, q);
                }
                if (bVar.k() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, f(this.f55570a, bVar.j(), bVar.k()), (Drawable) null, (Drawable) null);
                }
                if (bVar.g() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(f(this.f55570a, bVar.f(), bVar.g()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (bVar.i() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, f(this.f55570a, bVar.h(), bVar.i()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (bVar.n() != 0 && (f4 = f(this.f55570a, bVar.m(), bVar.n())) != null) {
                    ((ImageView) view).setImageDrawable(f4);
                }
            } else if (view instanceof ImageView) {
                if (bVar.n() != 0 && (f3 = f(this.f55570a, bVar.m(), bVar.n())) != null) {
                    ((ImageView) view).setImageDrawable(f3);
                }
            } else if ((view instanceof ProgressBar) && bVar.p() != 0 && (f2 = f(this.f55570a, bVar.o(), bVar.p())) != null) {
                ((ProgressBar) view).setProgressDrawable(f2);
            }
            if (bVar.c() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                String resourceTypeName = this.f55572c.getResourceTypeName(bVar.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(d(this.f55570a, bVar.b(), bVar.c()));
                } else {
                    view.setBackgroundDrawable(f(this.f55570a, bVar.b(), bVar.c()));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public final void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            String str = TNCManager.TNC_PROBE_HEADER_SECEPTOR + viewGroup.getId();
            Map<String, b> map = this.f55571b;
            if (map == null || !map.containsKey(str)) {
                return;
            }
            b bVar = this.f55571b.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && bVar.e() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(f(this.f55570a, bVar.d(), bVar.e()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (bVar.c() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                String resourceTypeName = this.f55572c.getResourceTypeName(bVar.b());
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    viewGroup.setBackgroundColor(d(this.f55570a, bVar.b(), bVar.c()));
                } else {
                    viewGroup.setBackgroundDrawable(f(this.f55570a, bVar.b(), bVar.c()));
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public void c() {
        Map<String, b> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (map = this.f55571b) == null) {
            return;
        }
        map.clear();
        this.f55571b = null;
    }

    public final int d(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f55574e && skinType == 4)) {
                return SkinManager.getColor(i2);
            }
            if (!z) {
                return this.f55572c.getColor(i2);
            }
            if (i2 == i3) {
                Resources resources = this.f55572c;
                this.f55573d = resources;
                i3 = g(resources, resources, i2);
            }
            Resources resources2 = this.f55573d;
            if (resources2 == null) {
                return this.f55572c.getColor(i2);
            }
            try {
                return resources2.getColor(i3);
            } catch (Resources.NotFoundException unused) {
                return this.f55572c.getColor(i2);
            }
        }
        return invokeCommon.intValue;
    }

    public final ColorStateList e(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f55574e && skinType == 4)) {
                return SkinManager.getColorList(i2);
            }
            if (!z) {
                return this.f55572c.getColorStateList(i2);
            }
            if (i2 == i3) {
                Resources resources = this.f55572c;
                this.f55573d = resources;
                i3 = g(resources, resources, i2);
            }
            Resources resources2 = this.f55573d;
            if (resources2 == null) {
                return this.f55572c.getColorStateList(i2);
            }
            try {
                return resources2.getColorStateList(i3);
            } catch (Resources.NotFoundException unused) {
                return this.f55572c.getColorStateList(i2);
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public final Drawable f(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 2 || (!this.f55574e && skinType == 4)) {
                return SkinManager.getDrawable(i2);
            }
            if (!z) {
                try {
                    return this.f55572c.getDrawable(i2);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (i2 == i3) {
                Resources resources = this.f55572c;
                this.f55573d = resources;
                i3 = g(resources, resources, i2);
            }
            Resources resources2 = this.f55573d;
            if (resources2 == null) {
                try {
                    return this.f55572c.getDrawable(i2);
                } catch (Throwable unused2) {
                    return null;
                }
            }
            try {
                try {
                    return resources2.getDrawable(i3);
                } catch (Throwable unused3) {
                    return null;
                }
            } catch (Resources.NotFoundException unused4) {
                return this.f55572c.getDrawable(i2);
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
                return new int[]{parseInt, g(this.f55572c, this.f55573d, parseInt)};
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(String str, Context context, AttributeSet attributeSet) {
        int[] h2;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, context, attributeSet) == null) {
            try {
                Resources resources = context.getResources();
                this.f55572c = resources;
                this.f55573d = resources;
                int attributeCount = attributeSet.getAttributeCount();
                b bVar = new b();
                bVar.R(str);
                boolean z = false;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    String attributeName = attributeSet.getAttributeName(i2);
                    String attributeValue = attributeSet.getAttributeValue(i2);
                    if (attributeName.equals("id")) {
                        bVar.G(attributeValue);
                    } else if (attributeName.equals("tb_background")) {
                        int[] h3 = h(attributeValue);
                        if (h3 != null) {
                            bVar.w(h3[0]);
                            bVar.x(h3[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_src")) {
                        int[] h4 = h(attributeValue);
                        if (h4 != null) {
                            bVar.H(h4[0]);
                            bVar.I(h4[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColor")) {
                        int[] h5 = h(attributeValue);
                        if (h5 != null) {
                            bVar.P(h5[0]);
                            bVar.Q(h5[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_style")) {
                        int[] h6 = h(attributeValue);
                        if (h6 != null) {
                            bVar.L(h6[0]);
                            bVar.M(h6[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_divider")) {
                        int[] h7 = h(attributeValue);
                        if (h7 != null) {
                            bVar.y(h7[0]);
                            bVar.z(h7[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableTop")) {
                        int[] h8 = h(attributeValue);
                        if (h8 != null) {
                            bVar.E(h8[0]);
                            bVar.F(h8[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableLeft")) {
                        int[] h9 = h(attributeValue);
                        if (h9 != null) {
                            bVar.A(h9[0]);
                            bVar.B(h9[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableRight")) {
                        int[] h10 = h(attributeValue);
                        if (h10 != null) {
                            bVar.C(h10[0]);
                            bVar.D(h10[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_progressDrawable")) {
                        int[] h11 = h(attributeValue);
                        if (h11 != null) {
                            bVar.J(h11[0]);
                            bVar.K(h11[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColorHint") && (h2 = h(attributeValue)) != null) {
                        bVar.N(h2[0]);
                        bVar.O(h2[1]);
                        z = true;
                    }
                    if (z && TbConfig.getDebugSwitch() && (d2 = d.a.c.e.m.b.d(attributeValue.substring(1), 0)) != 0) {
                        String resourceName = this.f55572c.getResourceName(d2);
                        bVar.a(attributeName + "=" + resourceName);
                    }
                }
                if (z) {
                    if (!TextUtils.isEmpty(bVar.l()) && this.f55571b != null && !this.f55571b.containsKey(bVar.l())) {
                        this.f55571b.put(bVar.l(), bVar);
                    } else if (!TextUtils.isEmpty(bVar.l())) {
                        this.f55571b.containsKey(bVar.l());
                    }
                }
            } catch (Resources.NotFoundException unused) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.isEmpty()) {
            View view2 = (View) stack.pop();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                b(viewGroup);
                if (!(view2 instanceof AdapterView)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        stack.push(viewGroup.getChildAt(i2));
                    }
                }
            } else {
                a(view2);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f55570a = z;
        }
    }

    public void l(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, resources) == null) {
            this.f55573d = resources;
        }
    }
}
