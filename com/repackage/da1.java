package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class da1 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<InstallmentEntity> a;
    public Context b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public View c;

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
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f091762);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091766);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091765);
        }
    }

    public da1(Context context) {
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
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public InstallmentEntity getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (InstallmentEntity) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<InstallmentEntity> list = this.a;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            InstallmentEntity item = getItem(i);
            if (item == null) {
                return view2;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d06a8, (ViewGroup) null, false);
                view2.setTag(new a(view2));
            }
            if (view2.getTag() != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
                aVar.a.setText(item.getTitle());
                aVar.b.setText(item.getPayText());
                if (item.isChecked()) {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f0608bb));
                    aVar.b.setTextSize(1, 10.0f);
                    aVar.b.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f0608bb));
                    aVar.c.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ec6));
                } else {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f060ac9));
                    aVar.b.setTextSize(1, 10.0f);
                    aVar.b.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f0608bc));
                    aVar.c.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ec5));
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
