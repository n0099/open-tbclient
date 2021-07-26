package d.a.q0.p0;

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
/* loaded from: classes8.dex */
public class k extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FacePurchaseRecordsActivity f61812e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsData f61813f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61814g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f61815e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61815e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(this.f61815e.f61812e.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
                this.f61815e.f61812e.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61816a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61817b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61818c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61819d;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {facePurchaseRecordsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61813f = null;
        this.f61812e = facePurchaseRecordsActivity;
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f61812e.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.f61812e.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.f61812e.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.e.b(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61812e.getResources().getString(R.string.go_to_download_emotion), new a(this))));
            d.a.p0.s.c layoutMode = this.f61812e.getLayoutMode();
            int skinType = TbadkApplication.getInst().getSkinType();
            if (layoutMode != null) {
                layoutMode.k(skinType == 1);
                layoutMode.j(inflate);
            }
            a2.f(this.f61812e.getPageContext(), skinType);
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
            View inflate = LayoutInflater.from(this.f61812e.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
            bVar.f61816a = (TbImageView) inflate.findViewById(R.id.cover);
            bVar.f61817b = (TextView) inflate.findViewById(R.id.title);
            bVar.f61818c = (TextView) inflate.findViewById(R.id.time);
            bVar.f61819d = (TextView) inflate.findViewById(R.id.price);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void d(int i2, b bVar) {
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bVar) == null) || (facePurchasePackageData = (FacePurchasePackageData) getItem(i2)) == null) {
            return;
        }
        bVar.f61816a.setTag(facePurchasePackageData.cover_url);
        bVar.f61816a.J(facePurchasePackageData.cover_url, 10, this.f61812e.getResources().getDimensionPixelSize(R.dimen.ds94), this.f61812e.getResources().getDimensionPixelSize(R.dimen.ds94), false);
        bVar.f61819d.setText(facePurchasePackageData.price);
        bVar.f61817b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.f61818c.setText(d.a.d.e.p.k.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, facePurchaseRecordsData) == null) {
            if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
                this.f61814g = true;
            } else {
                this.f61814g = false;
            }
            this.f61813f = facePurchaseRecordsData;
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
            if (!this.f61814g || (facePurchaseRecordsData = this.f61813f) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
                return 1;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        ArrayList<FacePurchasePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            FacePurchaseRecordsData facePurchaseRecordsData = this.f61813f;
            if (facePurchaseRecordsData == null || (arrayList = facePurchaseRecordsData.buy_his) == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return arrayList.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (!this.f61814g) {
                return b();
            }
            if (view == null) {
                view = c();
            }
            b bVar = (b) view.getTag();
            d.a.p0.s.c layoutMode = this.f61812e.getLayoutMode();
            layoutMode.k(skinType == 1);
            layoutMode.j(view);
            d(i2, bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
