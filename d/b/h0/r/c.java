package d.b.h0.r;

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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f50427f = false;

    /* renamed from: g  reason: collision with root package name */
    public static String f50428g;

    /* renamed from: h  reason: collision with root package name */
    public static int f50429h;

    /* renamed from: c  reason: collision with root package name */
    public Resources f50432c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f50433d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50430a = false;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, b> f50431b = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f50434e = false;

    public static int g(Resources resources, Resources resources2, int i) {
        int i2;
        if (f50427f) {
            String resourceName = resources.getResourceName(i);
            if (TextUtils.isEmpty(resourceName)) {
                i2 = i;
            } else {
                if (f50429h == 0) {
                    String packageName = BdBaseApplication.getInst().getPackageName();
                    f50428g = packageName;
                    f50429h = packageName.length();
                }
                int length = resourceName.length();
                int i3 = f50429h;
                if (length > i3 && resourceName.charAt(i3) != ':' && resourceName.startsWith(f50428g)) {
                    resourceName = f50428g + resourceName.substring(resourceName.indexOf(":"));
                }
                i2 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
                if (i2 <= 0) {
                    resourceName = SkinManager.PLUGIN_NIGHT_RESOURCE + resourceName.substring(resourceName.indexOf(":"));
                    i2 = resources2.getIdentifier(resourceName + SkinManager.nightSufix, null, null);
                }
            }
            if (i2 == 0) {
                BdLog.e(resourceName + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return i;
    }

    public final void a(View view) {
        Drawable f2;
        Drawable f3;
        Drawable f4;
        int q;
        String str = "@" + view.getId();
        Map<String, b> map = this.f50431b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        b bVar = this.f50431b.get(str);
        if (view instanceof TextView) {
            if (bVar.v() != 0) {
                ((TextView) view).setTextColor(e(this.f50430a, bVar.u(), bVar.v()));
            }
            if (bVar.t() != 0) {
                ((TextView) view).setHintTextColor(e(this.f50430a, bVar.s(), bVar.t()));
            }
            if (bVar.r() != 0) {
                TextView textView = (TextView) view;
                Context context = view.getContext();
                if (this.f50430a) {
                    q = bVar.r();
                } else {
                    q = bVar.q();
                }
                textView.setTextAppearance(context, q);
            }
            if (bVar.k() != 0) {
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, f(this.f50430a, bVar.j(), bVar.k()), (Drawable) null, (Drawable) null);
            }
            if (bVar.g() != 0) {
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(f(this.f50430a, bVar.f(), bVar.g()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (bVar.i() != 0) {
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, f(this.f50430a, bVar.h(), bVar.i()), (Drawable) null);
            }
        } else if (view instanceof ImageButton) {
            if (bVar.n() != 0 && (f4 = f(this.f50430a, bVar.m(), bVar.n())) != null) {
                ((ImageView) view).setImageDrawable(f4);
            }
        } else if (view instanceof ImageView) {
            if (bVar.n() != 0 && (f3 = f(this.f50430a, bVar.m(), bVar.n())) != null) {
                ((ImageView) view).setImageDrawable(f3);
            }
        } else if ((view instanceof ProgressBar) && bVar.p() != 0 && (f2 = f(this.f50430a, bVar.o(), bVar.p())) != null) {
            ((ProgressBar) view).setProgressDrawable(f2);
        }
        if (bVar.c() != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            String resourceTypeName = this.f50432c.getResourceTypeName(bVar.b());
            if (resourceTypeName != null && resourceTypeName.equals("color")) {
                view.setBackgroundColor(d(this.f50430a, bVar.b(), bVar.c()));
            } else {
                view.setBackgroundDrawable(f(this.f50430a, bVar.b(), bVar.c()));
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void b(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        Map<String, b> map = this.f50431b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        b bVar = this.f50431b.get(str);
        if (viewGroup instanceof AdapterView) {
            if ((viewGroup instanceof ListView) && bVar.e() != 0) {
                ListView listView = (ListView) viewGroup;
                int dividerHeight = listView.getDividerHeight();
                listView.setDivider(f(this.f50430a, bVar.d(), bVar.e()));
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
            String resourceTypeName = this.f50432c.getResourceTypeName(bVar.b());
            if (resourceTypeName != null && resourceTypeName.equals("color")) {
                viewGroup.setBackgroundColor(d(this.f50430a, bVar.b(), bVar.c()));
            } else {
                viewGroup.setBackgroundDrawable(f(this.f50430a, bVar.b(), bVar.c()));
            }
            viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public void c() {
        Map<String, b> map = this.f50431b;
        if (map != null) {
            map.clear();
            this.f50431b = null;
        }
    }

    public final int d(boolean z, int i, int i2) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.f50434e && skinType == 4)) {
            return SkinManager.getColor(i);
        }
        if (!z) {
            return this.f50432c.getColor(i);
        }
        if (i == i2) {
            Resources resources = this.f50432c;
            this.f50433d = resources;
            i2 = g(resources, resources, i);
        }
        Resources resources2 = this.f50433d;
        if (resources2 == null) {
            return this.f50432c.getColor(i);
        }
        try {
            return resources2.getColor(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f50432c.getColor(i);
        }
    }

    public final ColorStateList e(boolean z, int i, int i2) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.f50434e && skinType == 4)) {
            return SkinManager.getColorList(i);
        }
        if (!z) {
            return this.f50432c.getColorStateList(i);
        }
        if (i == i2) {
            Resources resources = this.f50432c;
            this.f50433d = resources;
            i2 = g(resources, resources, i);
        }
        Resources resources2 = this.f50433d;
        if (resources2 == null) {
            return this.f50432c.getColorStateList(i);
        }
        try {
            return resources2.getColorStateList(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f50432c.getColorStateList(i);
        }
    }

    public final Drawable f(boolean z, int i, int i2) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 2 || (!this.f50434e && skinType == 4)) {
            return SkinManager.getDrawable(i);
        }
        if (!z) {
            try {
                return this.f50432c.getDrawable(i);
            } catch (Throwable unused) {
                return null;
            }
        }
        if (i == i2) {
            Resources resources = this.f50432c;
            this.f50433d = resources;
            i2 = g(resources, resources, i);
        }
        Resources resources2 = this.f50433d;
        if (resources2 == null) {
            try {
                return this.f50432c.getDrawable(i);
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
            return this.f50432c.getDrawable(i);
        } catch (ArrayIndexOutOfBoundsException unused5) {
            return null;
        }
    }

    public final int[] h(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, g(this.f50432c, this.f50433d, parseInt)};
        }
        return null;
    }

    public void i(String str, Context context, AttributeSet attributeSet) {
        int[] h2;
        int d2;
        try {
            Resources resources = context.getResources();
            this.f50432c = resources;
            this.f50433d = resources;
            int attributeCount = attributeSet.getAttributeCount();
            b bVar = new b();
            bVar.R(str);
            boolean z = false;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
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
                if (z && TbConfig.getDebugSwitch() && (d2 = d.b.b.e.m.b.d(attributeValue.substring(1), 0)) != 0) {
                    String resourceName = this.f50432c.getResourceName(d2);
                    bVar.a(attributeName + "=" + resourceName);
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(bVar.l()) && this.f50431b != null && !this.f50431b.containsKey(bVar.l())) {
                    this.f50431b.put(bVar.l(), bVar);
                } else if (!TextUtils.isEmpty(bVar.l())) {
                    this.f50431b.containsKey(bVar.l());
                }
            }
        } catch (Resources.NotFoundException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(View view) {
        if (view == null) {
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
                    for (int i = 0; i < childCount; i++) {
                        stack.push(viewGroup.getChildAt(i));
                    }
                }
            } else {
                a(view2);
            }
        }
    }

    public void k(boolean z) {
        this.f50430a = z;
    }

    public void l(Resources resources) {
        this.f50433d = resources;
    }
}
