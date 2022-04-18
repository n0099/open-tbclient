package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchasePackageData;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class i96 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FacePurchaseRecordsActivity a;
    public FacePurchaseRecordsData b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i96 a;

        public a(i96 i96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(this.a.a.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public TextView d;

        public b(i96 i96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(i96 i96Var, a aVar) {
            this(i96Var);
        }
    }

    public i96(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {facePurchaseRecordsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = facePurchaseRecordsActivity;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0172, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070256)), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0347, R.string.obfuscated_res_0x7f0f07b0), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07af), new a(this))));
            sm4 layoutMode = this.a.getLayoutMode();
            int skinType = TbadkApplication.getInst().getSkinType();
            if (layoutMode != null) {
                layoutMode.k(skinType == 1);
                layoutMode.j(inflate);
            }
            a2.f(this.a.getPageContext(), skinType);
            a2.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d028e, (ViewGroup) null);
            bVar.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09070e);
            bVar.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092013);
            bVar.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091fe7);
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918de);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void d(int i, b bVar) {
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bVar) == null) || (facePurchasePackageData = (FacePurchasePackageData) getItem(i)) == null) {
            return;
        }
        bVar.a.setTag(facePurchasePackageData.cover_url);
        bVar.a.H(facePurchasePackageData.cover_url, 10, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07030f), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07030f), false);
        bVar.d.setText(facePurchasePackageData.price);
        bVar.b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.c.setText(ni.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, facePurchaseRecordsData) == null) {
            if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
                this.c = true;
            } else {
                this.c = false;
            }
            this.b = facePurchaseRecordsData;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        FacePurchaseRecordsData facePurchaseRecordsData;
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.c || (facePurchaseRecordsData = this.b) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
                return 1;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            FacePurchaseRecordsData facePurchaseRecordsData = this.b;
            if (facePurchaseRecordsData == null || (arrayList = facePurchaseRecordsData.buy_his) == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return arrayList.get(i);
        }
        return invokeI.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (!this.c) {
                return b();
            }
            if (view2 == null) {
                view2 = c();
            }
            b bVar = (b) view2.getTag();
            sm4 layoutMode = this.a.getLayoutMode();
            layoutMode.k(skinType == 1);
            layoutMode.j(view2);
            d(i, bVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
