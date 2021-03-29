package d.b.i0.e2.h;

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
public class a extends d.b.b.j.e.a<d.b.i0.e2.d, PersonCenterIntervalHolder> {
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.e2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        i0(i, view, viewGroup, dVar, personCenterIntervalHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public PersonCenterIntervalHolder R(ViewGroup viewGroup) {
        return new PersonCenterIntervalHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.item_person_center_list_interval, viewGroup, false));
    }

    public View i0(int i, View view, ViewGroup viewGroup, d.b.i0.e2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        if (dVar != null && personCenterIntervalHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (personCenterIntervalHolder.f20214a != skinType) {
                personCenterIntervalHolder.f20214a = skinType;
                SkinManager.setBackgroundResource(personCenterIntervalHolder.f20215b, dVar.f54523g);
            }
            ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.f20215b.getLayoutParams();
            int i2 = dVar.f54521e;
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            int i3 = dVar.f54522f;
            if (i3 > 0) {
                layoutParams.width = i3;
            }
            personCenterIntervalHolder.f20215b.setLayoutParams(layoutParams);
            personCenterIntervalHolder.f20215b.setOnClickListener(null);
        }
        return view;
    }
}
