package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ShareFriendTitleData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.transmit.ShareFriendActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gz8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public ShareFriendActivity c;
    public List<MetaData> d;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public a(gz8 gz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz8Var};
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
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public HeadImageView b;
        public TextView c;

        public b(gz8 gz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz8Var};
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
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public c(gz8 gz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz8Var};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755660628, "Lcom/repackage/gz8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755660628, "Lcom/repackage/gz8;");
        }
    }

    public gz8(ShareFriendActivity shareFriendActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shareFriendActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = new ArrayList();
        this.c = shareFriendActivity;
        this.a = shareFriendActivity.getPageContext().getContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<MetaData> list = this.d;
            if (list != null && i < list.size()) {
                return this.d.get(i);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void b(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.d.clear();
            this.d.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (e != i) {
                notifyDataSetChanged();
            }
            e = i;
        }
    }

    public void d(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.d = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<MetaData> list = this.d;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? getItem(i).getItemType() : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        a aVar;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (this.b == null) {
                this.b = viewGroup;
            }
            if (getItemViewType(i) == 0) {
                if (view2 != null && (view2.getTag() instanceof c)) {
                    cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075f, (ViewGroup) null);
                    cVar = new c(this);
                    cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf7);
                    cVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0902f2);
                    view2.setTag(cVar);
                }
                cVar.a.setText(((ShareFriendTitleData) getItem(i)).getTitle());
                gs4 d = gs4.d(cVar.a);
                d.A(R.string.F_X01);
                d.z(R.dimen.T_X08);
                d.v(R.color.CAM_X0107);
                gs4.d(cVar.b).f(R.color.CAM_X0201);
            } else if (getItemViewType(i) != 3 && getItemViewType(i) != 1) {
                if (getItemViewType(i) == 2) {
                    if (view2 != null && (view2.getTag() instanceof a)) {
                        aVar = (a) view2.getTag();
                    } else {
                        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075d, (ViewGroup) null);
                        a aVar2 = new a(this);
                        aVar2.a = inflate.findViewById(R.id.obfuscated_res_0x7f090d02);
                        inflate.setTag(aVar2);
                        view2 = inflate;
                        aVar = aVar2;
                    }
                    gs4.d(aVar.a).f(R.color.CAM_X0204);
                }
            } else {
                MetaData item = getItem(i);
                if (view2 != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075c, (ViewGroup) null);
                    b bVar2 = new b(this);
                    bVar2.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d00);
                    bVar2.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d0e);
                    bVar2.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf7);
                    view2.setTag(bVar2);
                    bVar = bVar2;
                }
                bVar.b.setIsRound(true);
                if (getItemViewType(i) == 1) {
                    UtilHelper.showHeadImageViewBigVForStranger(bVar.b, item);
                } else {
                    UtilHelper.showHeadImageViewFocusBigV(bVar.b, item);
                }
                String avater = item.getAvater();
                bVar.c.setText(item.getName_show());
                bVar.b.setTag(avater);
                bVar.b.K(avater, 12, false);
                gs4 d2 = gs4.d(bVar.a);
                d2.n(R.string.J_X02);
                d2.f(R.color.CAM_X0201);
                gs4 d3 = gs4.d(bVar.c);
                d3.z(R.dimen.T_X07);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0107);
            }
            notifyDataSetChanged();
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
