package d.b.i0.r.e0;

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
import d.b.c.a.f;
import d.b.c.a.j;
import d.b.c.e.l.c;
import d.b.c.e.l.d;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51212a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f51213b;

    /* renamed from: c  reason: collision with root package name */
    public final c<d.b.c.j.d.a> f51214c = new C1109a();

    /* renamed from: d.b.i0.r.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1109a extends c<d.b.c.j.d.a> {
        public C1109a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((C1109a) aVar, str, i);
            if (a.this.f51213b == null || aVar == null || !aVar.w()) {
                a.this.f();
                return;
            }
            FragmentTabWidget fragmentTabWidget = a.this.f51213b.getFragmentTabWidget();
            CustomViewPager fragmentViewPager = a.this.f51213b.getFragmentViewPager();
            ViewGroup tabWrapper = a.this.f51213b.getTabWrapper();
            if (fragmentTabWidget == null || fragmentViewPager == null) {
                return;
            }
            a.this.f51213b.setNeedShowThemeStyle(false);
            fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
            SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
            SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
            layoutParams.bottomMargin = l.g(a.this.f51213b.getContext(), R.dimen.tbds100);
            fragmentViewPager.setLayoutParams(layoutParams);
            fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.p()));
        }
    }

    public a(FragmentTabHost fragmentTabHost, int i) {
        this.f51212a = 0;
        this.f51213b = fragmentTabHost;
        this.f51212a = i;
    }

    public final BdUniqueId c() {
        f<?> a2;
        FragmentTabHost fragmentTabHost = this.f51213b;
        if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = j.a(this.f51213b.getContext())) == null) {
            return null;
        }
        return a2.getUniqueId();
    }

    public final void d(String str) {
        d.h().m(str, 10, this.f51214c, c());
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
        FragmentTabHost fragmentTabHost = this.f51213b;
        if (fragmentTabHost == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.f51213b.getFragmentTabWidget().setBackGroundDrawableResId(this.f51212a);
        SkinManager.setBackgroundColor(this.f51213b.getFragmentTabWidget(), this.f51212a);
        SkinManager.setBackgroundColor(this.f51213b.getTabWrapper(), this.f51212a);
    }
}
