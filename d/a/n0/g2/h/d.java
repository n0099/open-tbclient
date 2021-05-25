package d.a.n0.g2.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoUserPicsHolder;
/* loaded from: classes5.dex */
public class d extends d.a.n0.r.a<f, PersonInfoUserPicsHolder> {
    public View.OnClickListener m;
    public TbPageContext n;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        f0(i2, view, viewGroup, (f) obj, (PersonInfoUserPicsHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public PersonInfoUserPicsHolder P(ViewGroup viewGroup) {
        PersonInfoUserPicsHolder personInfoUserPicsHolder = new PersonInfoUserPicsHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.person_info_user_pics_layout, viewGroup, false), this.n);
        personInfoUserPicsHolder.f19646e.d(this.m);
        return personInfoUserPicsHolder;
    }

    public View f0(int i2, View view, ViewGroup viewGroup, f fVar, PersonInfoUserPicsHolder personInfoUserPicsHolder) {
        if (fVar != null && personInfoUserPicsHolder != null) {
            personInfoUserPicsHolder.c();
            personInfoUserPicsHolder.b(fVar);
        }
        return view;
    }
}
