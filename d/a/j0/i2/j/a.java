package d.a.j0.i2.j;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.j0.x.b<d.a.j0.i2.e.c> {
    public TbPageContext<?> m;
    public int n;
    public d.a.j0.i2.e.c o;
    public b p;
    public d.a.c.e.k.b<PersonCommonForumItemView> q;
    public TextView r;
    public ListViewPager s;

    /* loaded from: classes4.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (a.this.o == null || ListUtils.isEmpty(a.this.o.f55503e)) {
                return 0;
            }
            return a.this.o.f55503e.size() % 4 == 0 ? a.this.o.f55503e.size() / 4 : (a.this.o.f55503e.size() / 4) + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            List<d.a.j0.i2.e.f> w = a.this.w(i2);
            if (ListUtils.isEmpty(w)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.m.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.q);
            personCommonForumCardView.setData(w);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        this.p = new b();
        this.m = tbPageContext;
        View l = l();
        this.r = (TextView) l.findViewById(R.id.common_forum_title);
        this.s = (ListViewPager) l.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            l.setLayerType(2, null);
            if (l instanceof ViewGroup) {
                ((ViewGroup) l).setClipChildren(true);
            }
        }
        this.s.setOffscreenPageLimit(1);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.person_info_common_forum_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.n != i2) {
            SkinManager.setBackgroundResource(l(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            int childCount = this.s.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.s.getChildAt(i3);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).j();
                }
            }
        }
        this.n = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final List<d.a.j0.i2.e.f> w(int i2) {
        d.a.j0.i2.e.c cVar = this.o;
        if (cVar == null || ListUtils.isEmpty(cVar.f55503e)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = i2 * 4;
        for (int i4 = i3; i4 < i3 + 4; i4++) {
            d.a.j0.i2.e.f fVar = (d.a.j0.i2.e.f) ListUtils.getItem(this.o.f55503e, i4);
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public final boolean x(d.a.j0.i2.e.c cVar) {
        d.a.j0.i2.e.c cVar2;
        if (cVar == null || ListUtils.isEmpty(cVar.f55503e) || cVar == (cVar2 = this.o)) {
            return false;
        }
        if (cVar2 == null || ListUtils.isEmpty(cVar2.f55503e)) {
            return true;
        }
        if (!ListUtils.isEmpty(cVar.f55503e)) {
            if (cVar.f55503e.size() != this.o.f55503e.size()) {
                return true;
            }
            for (int i2 = 0; i2 < cVar.f55503e.size(); i2++) {
                if (this.o.f55503e.get(i2) == null || cVar.f55503e.get(i2).f55513e != this.o.f55503e.get(i2).f55513e) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: y */
    public void m(d.a.j0.i2.e.c cVar) {
        if (x(cVar)) {
            this.o = cVar;
            if (ListUtils.getCount(cVar.f55503e) <= 2) {
                this.s.getLayoutParams().height = d.a.c.e.p.l.g(this.m.getPageActivity(), R.dimen.ds140);
            }
            this.s.setAdapter(this.p);
        }
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public void z(d.a.c.e.k.b<PersonCommonForumItemView> bVar) {
        this.q = bVar;
    }
}
