package d.a.s0.n3.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d> f64264e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f64265f;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f64266a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64267b;

        /* renamed from: c  reason: collision with root package name */
        public View f64268c;

        /* renamed from: d  reason: collision with root package name */
        public View f64269d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64265f = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d> list = this.f64264e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f64264e.size()) {
                return null;
            }
            return this.f64264e.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public void b(List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f64264e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d> list = this.f64264e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f64265f.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
                aVar = new a();
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.dress_icon);
                aVar.f64266a = headImageView;
                headImageView.setDefaultResource(R.drawable.img_default_100);
                aVar.f64266a.setDefaultBgResource(R.color.CAM_X0204);
                aVar.f64267b = (TextView) view.findViewById(R.id.dress_desc_view);
                aVar.f64268c = view.findViewById(R.id.tip_view);
                aVar.f64269d = view.findViewById(R.id.divider_line);
                view.setTag(aVar);
            }
            if (item != null) {
                aVar.f64266a.M(item.a(), 10, false);
                aVar.f64267b.setText(item.b());
                d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
                if (item.d() - j.l("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), 0L) > 0) {
                    aVar.f64268c.setVisibility(0);
                } else {
                    aVar.f64268c.setVisibility(4);
                }
                if (i2 == getCount() - 1) {
                    aVar.f64269d.setVisibility(8);
                } else {
                    aVar.f64269d.setVisibility(0);
                }
            }
            this.f64265f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
