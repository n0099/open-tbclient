package d.a.j0.g2.g;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonCenterSmartAppPageView;
import d.a.c.e.p.l;
import d.a.j0.g2.e.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.j0.x.b<k> {
    public List<d.a.j0.g2.e.c> m;
    public List<PersonCenterSmartAppPageView> n;
    public BdBaseViewPager o;
    public TbTabLayout p;
    public View q;
    public a r;
    public PersonCenterSmartAppPageView s;

    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<PersonCenterSmartAppPageView> f54613a;

        public a(d dVar, List<PersonCenterSmartAppPageView> list) {
            this.f54613a = list;
        }

        public void b(List<PersonCenterSmartAppPageView> list) {
            this.f54613a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f54613a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.f54613a.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.f54613a.get(i2);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.o = (BdBaseViewPager) l.findViewById(R.id.vp_person_center_smart_app_banner);
        this.p = (TbTabLayout) l.findViewById(R.id.tl_person_center_smart_app_banner);
        this.q = l.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.p.setTabMode(1);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        a aVar = new a(this, arrayList);
        this.r = aVar;
        this.o.setAdapter(aVar);
        this.p.setupWithViewPager(this.o);
        this.q.setVisibility(8);
        n(k(), this.f62436e);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.n) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.c();
            }
        }
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
        this.p.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0629));
        this.p.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), SkinManager.getColor(R.color.CAM_X0625)));
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s(d.a.j0.g2.e.c cVar) {
        if (this.s.b()) {
            this.s.a(cVar);
            return;
        }
        PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(b());
        this.s = personCenterSmartAppPageView;
        this.n.add(personCenterSmartAppPageView);
        this.s.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(k kVar) {
        if (kVar != null && kVar.h() != null && !ListUtils.isEmpty(kVar.h())) {
            r(0);
            this.n.clear();
            this.m = kVar.h();
            PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(b());
            this.s = personCenterSmartAppPageView;
            this.n.add(personCenterSmartAppPageView);
            int min = Math.min(7, this.m.size());
            for (int i2 = 0; i2 < min; i2++) {
                s((d.a.j0.g2.e.c) ListUtils.getItem(this.m, i2));
            }
            if (this.m.isEmpty()) {
                r(8);
            } else {
                s(new d.a.j0.g2.e.l());
            }
            if (this.n.size() <= 1) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
            }
            this.r.b(this.n);
            n(k(), this.f62436e);
            return;
        }
        r(8);
    }
}
