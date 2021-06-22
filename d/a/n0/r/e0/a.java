package d.a.n0.r.e0;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f53475a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f53476b;

    /* renamed from: c  reason: collision with root package name */
    public final c<d.a.c.k.d.a> f53477c = new C1192a();

    /* renamed from: d.a.n0.r.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1192a extends c<d.a.c.k.d.a> {
        public C1192a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((C1192a) aVar, str, i2);
            if (a.this.f53476b == null || aVar == null || !aVar.w()) {
                a.this.f();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.f53476b.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.f53476b.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.f53476b.getTabWrapper();
            if (fragmentTabWidget == null || fragmentViewPager == null) {
                return;
            }
            a.this.f53476b.setNeedShowThemeStyle(false);
            fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
            SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
            SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
            layoutParams.bottomMargin = l.g(a.this.f53476b.getContext(), R.dimen.tbds100);
            fragmentViewPager.setLayoutParams(layoutParams);
            fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.p()));
        }
    }

    public a(FragmentTabHost fragmentTabHost, int i2) {
        this.f53475a = 0;
        this.f53476b = fragmentTabHost;
        this.f53475a = i2;
    }

    public final BdUniqueId c() {
        f<?> a2;
        FragmentTabHost fragmentTabHost = this.f53476b;
        if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = j.a(this.f53476b.getContext())) == null) {
            return null;
        }
        return a2.getUniqueId();
    }

    public final void d(String str) {
        d.h().m(str, 10, this.f53477c, c());
    }

    public void e(Pair<String, String> pair) {
        if (pair != null) {
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
                d(str2);
            } else if (!TextUtils.isEmpty(str)) {
                d(str);
            } else {
                f();
            }
        }
    }

    public final void f() {
        FragmentTabHost fragmentTabHost = this.f53476b;
        if (fragmentTabHost == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.f53476b.getFragmentTabWidget().setBackGroundDrawableResId(this.f53475a);
        SkinManager.setBackgroundColor(this.f53476b.getFragmentTabWidget(), this.f53475a);
        SkinManager.setBackgroundColor(this.f53476b.getTabWrapper(), this.f53475a);
    }
}
