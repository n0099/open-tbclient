package d.a.n0.g2.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
/* loaded from: classes5.dex */
public class a extends d.a.c.j.e.a<d.a.n0.g2.d, PersonCenterIntervalHolder> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.n0.g2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        f0(i2, view, viewGroup, dVar, personCenterIntervalHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public PersonCenterIntervalHolder P(ViewGroup viewGroup) {
        return new PersonCenterIntervalHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.item_person_center_list_interval, viewGroup, false));
    }

    public View f0(int i2, View view, ViewGroup viewGroup, d.a.n0.g2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        if (dVar != null && personCenterIntervalHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (personCenterIntervalHolder.f19628a != skinType) {
                personCenterIntervalHolder.f19628a = skinType;
                SkinManager.setBackgroundResource(personCenterIntervalHolder.f19629b, dVar.f55167g);
            }
            ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.f19629b.getLayoutParams();
            int i3 = dVar.f55165e;
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            int i4 = dVar.f55166f;
            if (i4 > 0) {
                layoutParams.width = i4;
            }
            personCenterIntervalHolder.f19629b.setLayoutParams(layoutParams);
            personCenterIntervalHolder.f19629b.setOnClickListener(null);
        }
        return view;
    }
}
