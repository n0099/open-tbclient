package d.b.i0.f2.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<d.b.i0.f2.i.c, PersonInfoAddUserPicViewHolder> {
    public TbPageContext m;
    public View.OnClickListener n;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public PersonInfoAddUserPicViewHolder R(ViewGroup viewGroup) {
        return new PersonInfoAddUserPicViewHolder(LayoutInflater.from(this.m.getPageActivity()).inflate(R.layout.user_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.f2.i.c cVar, PersonInfoAddUserPicViewHolder personInfoAddUserPicViewHolder) {
        if (personInfoAddUserPicViewHolder == null || cVar == null) {
            return null;
        }
        personInfoAddUserPicViewHolder.e(this.n);
        personInfoAddUserPicViewHolder.b(cVar);
        return personInfoAddUserPicViewHolder.a();
    }

    public void j0(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
