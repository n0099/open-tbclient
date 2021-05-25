package d.a.m0.r.e0;

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
    public int f49693a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f49694b;

    /* renamed from: c  reason: collision with root package name */
    public final c<d.a.c.j.d.a> f49695c = new C1133a();

    /* renamed from: d.a.m0.r.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1133a extends c<d.a.c.j.d.a> {
        public C1133a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((C1133a) aVar, str, i2);
            if (a.this.f49694b == null || aVar == null || !aVar.w()) {
                a.this.f();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.f49694b.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.f49694b.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.f49694b.getTabWrapper();
            if (fragmentTabWidget == null || fragmentViewPager == null) {
                return;
            }
            a.this.f49694b.setNeedShowThemeStyle(false);
            fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
            SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
            SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
            layoutParams.bottomMargin = l.g(a.this.f49694b.getContext(), R.dimen.tbds100);
            fragmentViewPager.setLayoutParams(layoutParams);
            fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.p()));
        }
    }

    public a(FragmentTabHost fragmentTabHost, int i2) {
        this.f49693a = 0;
        this.f49694b = fragmentTabHost;
        this.f49693a = i2;
    }

    public final BdUniqueId c() {
        f<?> a2;
        FragmentTabHost fragmentTabHost = this.f49694b;
        if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = j.a(this.f49694b.getContext())) == null) {
            return null;
        }
        return a2.getUniqueId();
    }

    public final void d(String str) {
        d.h().m(str, 10, this.f49695c, c());
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
        FragmentTabHost fragmentTabHost = this.f49694b;
        if (fragmentTabHost == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.f49694b.getFragmentTabWidget().setBackGroundDrawableResId(this.f49693a);
        SkinManager.setBackgroundColor(this.f49694b.getFragmentTabWidget(), this.f49693a);
        SkinManager.setBackgroundColor(this.f49694b.getTabWrapper(), this.f49693a);
    }
}
