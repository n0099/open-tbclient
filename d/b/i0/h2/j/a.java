package d.b.i0.h2.j;

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
/* loaded from: classes5.dex */
public class a extends d.b.i0.x.b<d.b.i0.h2.e.c> {
    public TbPageContext<?> m;
    public int n;
    public d.b.i0.h2.e.c o;
    public b p;
    public d.b.b.e.k.b<PersonCommonForumItemView> q;
    public TextView r;
    public ListViewPager s;

    /* loaded from: classes5.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (a.this.o == null || ListUtils.isEmpty(a.this.o.f55274e)) {
                return 0;
            }
            return a.this.o.f55274e.size() % 4 == 0 ? a.this.o.f55274e.size() / 4 : (a.this.o.f55274e.size() / 4) + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<d.b.i0.h2.e.f> y = a.this.y(i);
            if (ListUtils.isEmpty(y)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.m.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.q);
            personCommonForumCardView.setData(y);
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
        View m = m();
        this.r = (TextView) m.findViewById(R.id.common_forum_title);
        this.s = (ListViewPager) m.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            m.setLayerType(2, null);
            if (m instanceof ViewGroup) {
                ((ViewGroup) m).setClipChildren(true);
            }
        }
        this.s.setOffscreenPageLimit(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: A */
    public void n(d.b.i0.h2.e.c cVar) {
        if (z(cVar)) {
            this.o = cVar;
            if (ListUtils.getCount(cVar.f55274e) <= 2) {
                this.s.getLayoutParams().height = d.b.b.e.p.l.g(this.m.getPageActivity(), R.dimen.ds140);
            }
            this.s.setAdapter(this.p);
        }
        o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public void B(d.b.b.e.k.b<PersonCommonForumItemView> bVar) {
        this.q = bVar;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.person_info_common_forum_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.n != i) {
            SkinManager.setBackgroundResource(m(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            int childCount = this.s.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.s.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).j();
                }
            }
        }
        this.n = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final List<d.b.i0.h2.e.f> y(int i) {
        d.b.i0.h2.e.c cVar = this.o;
        if (cVar == null || ListUtils.isEmpty(cVar.f55274e)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        for (int i3 = i2; i3 < i2 + 4; i3++) {
            d.b.i0.h2.e.f fVar = (d.b.i0.h2.e.f) ListUtils.getItem(this.o.f55274e, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public final boolean z(d.b.i0.h2.e.c cVar) {
        d.b.i0.h2.e.c cVar2;
        if (cVar == null || ListUtils.isEmpty(cVar.f55274e) || cVar == (cVar2 = this.o)) {
            return false;
        }
        if (cVar2 == null || ListUtils.isEmpty(cVar2.f55274e)) {
            return true;
        }
        if (!ListUtils.isEmpty(cVar.f55274e)) {
            if (cVar.f55274e.size() != this.o.f55274e.size()) {
                return true;
            }
            for (int i = 0; i < cVar.f55274e.size(); i++) {
                if (this.o.f55274e.get(i) == null || cVar.f55274e.get(i).f55283e != this.o.f55274e.get(i).f55283e) {
                    return true;
                }
            }
        }
        return false;
    }
}
