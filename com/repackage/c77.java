package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.mygroup.PersonalGroupFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c77 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalGroupFragment a;
    public List<GroupInfoData> b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public GroupImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public ImageView g;
        public ImageView h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public ImageView[] m;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c77(PersonalGroupFragment personalGroupFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalGroupFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = personalGroupFragment;
    }

    public final void a(ImageView[] imageViewArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imageViewArr, i) == null) {
            if (i < 0) {
                i = 0;
            }
            if (i > 3) {
                i = 3;
            }
            for (int i2 = 1; i2 <= 3; i2++) {
                if (i2 <= i) {
                    imageViewArr[i2].setVisibility(0);
                } else {
                    imageViewArr[i2].setVisibility(8);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public GroupInfoData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int itemId = (int) getItemId(i);
            if (itemId < 0 || itemId >= this.b.size()) {
                return null;
            }
            return this.b.get(itemId);
        }
        return (GroupInfoData) invokeI.objValue;
    }

    public void c(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0804, viewGroup, false);
                aVar = new a();
                aVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09061b);
                aVar.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907ab);
                aVar.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907aa);
                aVar.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907ac);
                aVar.b = (GroupImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f3a);
                aVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f37);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f38);
                aVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f43);
                aVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f1a);
                aVar.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f33);
                aVar.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f34);
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f35);
                aVar.l = imageView;
                ImageView[] imageViewArr = new ImageView[4];
                aVar.m = imageViewArr;
                imageViewArr[1] = aVar.j;
                imageViewArr[2] = aVar.k;
                imageViewArr[3] = imageView;
                view2.setTag(aVar);
            }
            GroupInfoData groupInfoData = this.b.get(i);
            aVar.b.setTag(null);
            aVar.b.setDrawBorder(true);
            aVar.b.setPlaceHolder(1);
            if (groupInfoData != null) {
                String portrait = groupInfoData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    aVar.b.J(portrait, 10, false);
                } else {
                    aVar.b.J("", 10, false);
                }
                aVar.a.setOnClickListener(this.a);
                aVar.a.setTag(groupInfoData);
                aVar.g.setVisibility(8);
                aVar.i.setVisibility(8);
                aVar.h.setVisibility(0);
                aVar.c.setText(groupInfoData.getName());
                TextView textView = aVar.d;
                textView.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
                aVar.e.setText(groupInfoData.getIntro());
                if (groupInfoData.getIsGroupManager() == 1) {
                    aVar.f.setVisibility(0);
                } else {
                    aVar.f.setVisibility(8);
                }
                a(aVar.m, groupInfoData.getGrade());
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getBaseFragmentActivity().getLayoutMode().j(view2);
            if (groupInfoData != null && groupInfoData.isMemGroup()) {
                SkinManager.setViewTextColor(aVar.c, R.color.common_color_10009, 1);
                SkinManager.setImageResource(aVar.j, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(aVar.k, R.drawable.icon_vip_grade_big_small_s);
                SkinManager.setImageResource(aVar.l, R.drawable.icon_vip_grade_big_small_s);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
