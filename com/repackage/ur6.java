package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Deprecated
/* loaded from: classes7.dex */
public class ur6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<GiftCommonList.GiftItem> b;
    public int c;
    public RelativeLayout.LayoutParams d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public View b;
        public TextView c;
        public TextView d;

        public b(ur6 ur6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(ur6 ur6Var, a aVar) {
            this(ur6Var);
        }
    }

    public ur6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = context;
        this.d = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c9) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (GiftCommonList.GiftItem) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<GiftCommonList.GiftItem> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 != null && view2.getTag() != null) {
                bVar = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d037c, (ViewGroup) null);
                bVar = new b(this, null);
                bVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e6f);
                bVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0913ba);
                bVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091504);
                bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091936);
                view2.setTag(bVar);
            }
            bVar.b.setLayoutParams(this.d);
            SkinManager.setBackgroundResource(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(bVar.c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.d, R.color.CAM_X0301, 1);
            if (i == this.c) {
                SkinManager.setBackgroundResource(bVar.b, R.drawable.obfuscated_res_0x7f08044f);
            } else {
                bVar.b.setBackgroundResource(R.color.common_color_10022);
            }
            GiftCommonList.GiftItem item = getItem(i);
            if (item != null) {
                bVar.c.setText(item.getName());
                bVar.d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f13a6), Integer.valueOf(item.getPrice())));
                bVar.a.K(item.getThumbnailUrl(), 10, false);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
