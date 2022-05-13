package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ca7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<wy4> b;
    public int c;
    public int d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public View c;

        public b(ca7 ca7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(ca7 ca7Var, a aVar) {
            this(ca7Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public c(ca7 ca7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(ca7 ca7Var, a aVar) {
            this(ca7Var);
        }
    }

    public ca7(Context context) {
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
        this.a = context;
        this.c = R.color.CAM_X0105;
        this.d = R.color.CAM_X0108;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public wy4 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<wy4> list = this.b;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return (wy4) invokeI.objValue;
    }

    public void b(List<wy4> list) {
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
            List<wy4> list = this.b;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            wy4 item = getItem(i);
            if (item == null) {
                return 2;
            }
            return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 0 : 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 2) {
                return null;
            }
            TbadkCoreApplication.getInst().getSkinType();
            wy4 item = getItem(i);
            if (getItemViewType(i) == 0) {
                if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof c)) {
                    cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d074d, (ViewGroup) null);
                    cVar = new c(this, null);
                    cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090133);
                    cVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090132);
                    view2.setTag(cVar);
                }
                if (item.a() != null) {
                    cVar.a.setText(item.a());
                }
                SkinManager.setViewTextColor(cVar.a, this.d, 1);
                SkinManager.setBackgroundColor(cVar.b, R.color.CAM_X0204);
                return view2;
            } else if (getItemViewType(i) == 1) {
                if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    bVar = new b(this, null);
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d074c, (ViewGroup) null);
                    bVar.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09012e);
                    bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09012f);
                    bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f09012d);
                    view2.setTag(bVar);
                }
                if (item.f() != null) {
                    bVar.b.setText(item.f());
                    bVar.a.K(item.h(), 12, false);
                }
                SkinManager.setViewTextColor(bVar.b, this.c, 1);
                SkinManager.setBackgroundResource(bVar.c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view2, R.drawable.select_friend_item_bg);
                return view2;
            } else {
                return null;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
