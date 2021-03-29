package d.b.i0.e2.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoUserPicsHolder;
/* loaded from: classes5.dex */
public class d extends d.b.i0.p.a<f, PersonInfoUserPicsHolder> {
    public View.OnClickListener m;
    public TbPageContext n;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i, view, viewGroup, (f) obj, (PersonInfoUserPicsHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public PersonInfoUserPicsHolder R(ViewGroup viewGroup) {
        PersonInfoUserPicsHolder personInfoUserPicsHolder = new PersonInfoUserPicsHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.person_info_user_pics_layout, viewGroup, false), this.n);
        personInfoUserPicsHolder.f20232e.d(this.m);
        return personInfoUserPicsHolder;
    }

    public View i0(int i, View view, ViewGroup viewGroup, f fVar, PersonInfoUserPicsHolder personInfoUserPicsHolder) {
        if (fVar != null && personInfoUserPicsHolder != null) {
            personInfoUserPicsHolder.c();
            personInfoUserPicsHolder.b(fVar);
        }
        return view;
    }
}
