package d.a.p0.j2.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends d.a.c.k.e.a<d.a.p0.j2.d, PersonCenterIntervalHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.p0.j2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        g0(i2, view, viewGroup, dVar, personCenterIntervalHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public PersonCenterIntervalHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCenterIntervalHolder(LayoutInflater.from(this.f41837e).inflate(R.layout.item_person_center_list_interval, viewGroup, false)) : (PersonCenterIntervalHolder) invokeL.objValue;
    }

    public View g0(int i2, View view, ViewGroup viewGroup, d.a.p0.j2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, personCenterIntervalHolder})) == null) {
            if (dVar != null && personCenterIntervalHolder != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (personCenterIntervalHolder.f19977a != skinType) {
                    personCenterIntervalHolder.f19977a = skinType;
                    SkinManager.setBackgroundResource(personCenterIntervalHolder.f19978b, dVar.f59114g);
                }
                ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.f19978b.getLayoutParams();
                int i3 = dVar.f59112e;
                if (i3 > 0) {
                    layoutParams.height = i3;
                }
                int i4 = dVar.f59113f;
                if (i4 > 0) {
                    layoutParams.width = i4;
                }
                personCenterIntervalHolder.f19978b.setLayoutParams(layoutParams);
                personCenterIntervalHolder.f19978b.setOnClickListener(null);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
