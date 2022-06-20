package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class mn8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public List<Object> c;
    public TbPageContext<?> d;
    public PersonalCardItemView.b e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PersonalCardItemView a;
        public PersonalCardItemView b;
        public PersonalCardItemView c;
        public View d;

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

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public b() {
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

    public mn8(TbPageContext<?> tbPageContext) {
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
        this.a = 0;
        this.b = 0;
        this.d = tbPageContext;
        this.a = pi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9);
        this.b = pi.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
    }

    public void a(PersonalCardItemView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void b(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.c = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<Object> list = this.c;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            List<Object> list = this.c;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.c.size()) {
                return null;
            }
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? getItem(i) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            Object item = getItem(i);
            if (itemViewType == 0) {
                if (view2 != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    bVar = new b();
                    view2 = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0128, viewGroup, false);
                    TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c9f);
                    bVar.a = textView;
                    textView.setPadding(0, this.a, 0, this.b);
                    view2.setTag(bVar);
                }
                if (item != null) {
                    bVar.a.setText(item.toString());
                }
            } else if (itemViewType == 1) {
                if (view2 != null && (view2.getTag() instanceof a)) {
                    aVar = (a) view2.getTag();
                } else {
                    a aVar2 = new a();
                    View inflate = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01c2, viewGroup, false);
                    aVar2.a = (PersonalCardItemView) inflate.findViewById(R.id.obfuscated_res_0x7f09049f);
                    aVar2.b = (PersonalCardItemView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a0);
                    aVar2.c = (PersonalCardItemView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a1);
                    aVar2.d = inflate.findViewById(R.id.obfuscated_res_0x7f0907c3);
                    aVar2.a.setCardViewController(this.e);
                    aVar2.b.setCardViewController(this.e);
                    aVar2.c.setCardViewController(this.e);
                    inflate.setTag(aVar2);
                    aVar = aVar2;
                    view2 = inflate;
                }
                if (item != null) {
                    List list = (List) item;
                    int size = list.size();
                    if (size == 1) {
                        aVar.a.c((om8) list.get(0));
                        aVar.a.setVisibility(0);
                        aVar.b.setVisibility(8);
                        aVar.c.setVisibility(8);
                    } else if (size == 2) {
                        aVar.a.c((om8) list.get(0));
                        aVar.b.c((om8) list.get(1));
                        aVar.a.setVisibility(0);
                        aVar.b.setVisibility(0);
                        aVar.c.setVisibility(8);
                    } else if (size != 3) {
                        view2.setVisibility(8);
                    } else {
                        aVar.a.c((om8) list.get(0));
                        aVar.b.c((om8) list.get(1));
                        aVar.c.c((om8) list.get(2));
                        aVar.a.setVisibility(0);
                        aVar.b.setVisibility(0);
                        aVar.c.setVisibility(0);
                    }
                    if (getItem(i + 1) instanceof List) {
                        aVar.d.setVisibility(8);
                    } else {
                        aVar.d.setVisibility(0);
                    }
                }
            }
            this.d.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
