package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.view.card.AlaCardBottomUserInfoLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class zs5 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public List<ThreadData> b;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public AlaCardBottomUserInfoLayout c;
        public RelativeLayout d;
        public TextView e;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ee5);
            this.c = (AlaCardBottomUserInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901c0);
            this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c1);
        }
    }

    public zs5(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ThreadData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<ThreadData> list = this.b;
            if (list != null && i >= 0 && i <= list.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (ThreadData) invokeI.objValue;
    }

    public void b(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.b)) {
                return 0;
            }
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        AlaInfoData threadAlaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00ec, (ViewGroup) null);
                aVar = new a(view2);
                aVar.b.setIsRound(true);
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setGifIconSupport(false);
                int k = (mi.k(this.a.getPageActivity()) - this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)) / 3;
                int i2 = (k * 16) / 9;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.d.getLayoutParams();
                layoutParams.height = k;
                layoutParams.width = i2;
                aVar.d.setLayoutParams(layoutParams);
                AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
                ((ViewGroup.LayoutParams) layoutParams2).width = i2;
                view2.setLayoutParams(layoutParams2);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            ThreadData item = getItem(i);
            if (item == null || (threadAlaInfo = item.getThreadAlaInfo()) == null) {
                return null;
            }
            aVar.b.K(threadAlaInfo.cover, 10, false);
            aVar.c.setData(item);
            aVar.c.setUserHeadImgVisible(8);
            aVar.e.setText(item.getTitle());
            aVar.c.onChangeSkinType(this.a);
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
