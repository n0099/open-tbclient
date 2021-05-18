package d.a.k0.f2.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import d.a.j0.t.o;
/* loaded from: classes5.dex */
public class c extends d.a.c.j.e.a<o, PersonInfoUserPicViewHolder> {
    public TbPageContext m;
    public View.OnClickListener n;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public PersonInfoUserPicViewHolder P(ViewGroup viewGroup) {
        return new PersonInfoUserPicViewHolder(LayoutInflater.from(this.m.getPageActivity()).inflate(R.layout.user_pic_nomal_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, o oVar, PersonInfoUserPicViewHolder personInfoUserPicViewHolder) {
        if (personInfoUserPicViewHolder == null || oVar == null) {
            return null;
        }
        personInfoUserPicViewHolder.e(this.n);
        personInfoUserPicViewHolder.b(oVar);
        return personInfoUserPicViewHolder.a();
    }

    public void g0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
