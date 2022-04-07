package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hq8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public TbPageContext<?> b;
    public kq8 c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public BackgroundItemView b;
        public BackgroundItemView c;
        public BackgroundItemView d;
        public View e;

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

    public hq8(TbPageContext<?> tbPageContext, kq8 kq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = kq8Var;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<Object> list = this.a;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (getItem(i) != null) {
                return i;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? getItem(i) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            Object item = getItem(i);
            if (view2 != null) {
                aVar = (a) view2.getTag();
            } else if (getItemViewType(i) == 0) {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0130, viewGroup, false);
                aVar = new a();
                aVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cfe);
                view2.setTag(aVar);
            } else {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0136, viewGroup, false);
                aVar = new a();
                aVar.b = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f09036e);
                aVar.c = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f09036f);
                aVar.d = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f090370);
                aVar.e = view2.findViewById(R.id.obfuscated_res_0x7f0907fd);
                view2.setTag(aVar);
            }
            if (item != null) {
                if (getItemViewType(i) == 0) {
                    aVar.a.setText(item.toString());
                } else {
                    List list = (List) item;
                    aVar.b.e((DressItemData) list.get(0));
                    aVar.b.setController(this.c);
                    if (list.size() > 2) {
                        aVar.c.e((DressItemData) list.get(1));
                        aVar.d.e((DressItemData) list.get(2));
                        aVar.c.setController(this.c);
                        aVar.d.setController(this.c);
                    } else if (list.size() > 1) {
                        aVar.c.e((DressItemData) list.get(1));
                        aVar.c.setController(this.c);
                        aVar.d.f();
                    } else {
                        aVar.c.f();
                        aVar.d.f();
                    }
                    if (getItem(i + 1) instanceof List) {
                        aVar.e.setVisibility(8);
                    } else {
                        aVar.e.setVisibility(0);
                    }
                }
            }
            this.b.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
