package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class pq4 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<qq4> a;
    public TbPageContext<?> b;
    public boolean c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;

        public b(pq4 pq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(pq4 pq4Var, a aVar) {
            this(pq4Var);
        }
    }

    public pq4(TbPageContext<?> tbPageContext) {
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
        this.c = false;
        this.b = tbPageContext;
        this.a = new ArrayList<>();
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<qq4> arrayList = this.a;
            return arrayList != null && i == arrayList.size() - 1;
        }
        return invokeI.booleanValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.c = z;
        }
    }

    public void c(ArrayList<qq4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.a = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.a.get(i) : invokeI.objValue;
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
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            qq4 qq4Var = this.a.get(i);
            if (qq4Var == null) {
                return null;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022c, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f3b);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f1f);
                bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090606);
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.a.setText(qq4Var.c());
            if (StringUtils.isNull(qq4Var.a())) {
                bVar.b.setVisibility(8);
            } else {
                bVar.b.setText(qq4Var.a());
                bVar.b.setVisibility(0);
            }
            if (qq4Var.d()) {
                bVar.c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080811, WebPManager.ResourceStateType.NORMAL));
                bVar.c.setVisibility(0);
            } else if (this.c) {
                WebPManager.setPureDrawable(bVar.c, R.drawable.obfuscated_res_0x7f0809c6, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
                bVar.c.setVisibility(0);
            } else {
                bVar.c.setVisibility(4);
            }
            if (a(i)) {
                SkinManager.setBackgroundResource(view2, R.drawable.dialog_single_button_bg_selector);
            } else {
                SkinManager.setBackgroundResource(view2, R.drawable.dialg_alert_btn_bg);
            }
            view2.setTag(bVar);
            this.b.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.b.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
