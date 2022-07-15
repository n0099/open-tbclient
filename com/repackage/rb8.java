package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rb8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<sb8> b;
    public boolean c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TbImageView c;
        public View d;

        public b(rb8 rb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(rb8 rb8Var, a aVar) {
            this(rb8Var);
        }
    }

    public rb8(Context context) {
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
        this.c = true;
        this.a = context;
        this.b = new ArrayList();
    }

    public void a(List<sb8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            b bVar = new b(this, null);
            bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a26);
            bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a24);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a25);
            bVar.c = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            bVar.d = view2.findViewById(R.id.obfuscated_res_0x7f0912b0);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public sb8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<sb8> list = this.b;
            if (list == null || i >= list.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return (sb8) invokeI.objValue;
    }

    public View d(sb8 sb8Var, View view2, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        b b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, sb8Var, view2, viewGroup)) == null) {
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof b)) {
                b2 = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0743, viewGroup, false);
                b2 = b(view2);
                view2.setTag(b2);
            }
            if (sb8Var == null) {
                return view2;
            }
            b2.a.setText(sb8Var.d);
            b2.b.setText(sb8Var.e);
            b2.c.setDefaultResource(R.drawable.obfuscated_res_0x7f081011);
            b2.c.G(sb8Var.f, 10, 0, 0, false);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<sb8> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) ? d(this.b.get(i), view2, viewGroup) : (View) invokeILL.objValue;
    }
}
