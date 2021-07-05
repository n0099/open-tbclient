package d.a.s0.v3.h.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.s0.v3.h.e.a> f68622e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v3.h.e.a f68623f;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f68624a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68625b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68622e = new ArrayList();
    }

    public List<d.a.s0.v3.h.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68622e : (List) invokeV.objValue;
    }

    public void b(d.a.s0.v3.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar == null) {
                List<d.a.s0.v3.h.e.a> list = this.f68622e;
                if (list != null) {
                    this.f68623f = list.get(0);
                }
            } else {
                this.f68623f = aVar;
            }
            notifyDataSetChanged();
        }
    }

    public void c(List<d.a.s0.v3.h.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        this.f68622e = list;
        if (list.size() > 0) {
            this.f68623f = this.f68622e.get(0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68622e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f68622e.size()) {
                return null;
            }
            return this.f68622e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        a aVar;
        d.a.s0.v3.h.e.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.iv_effect);
                aVar.f68624a = tbImageView;
                tbImageView.setIsRound(true);
                aVar.f68624a.setDrawerType(1);
                aVar.f68624a.setDefaultBgResource(R.color.transparent);
                aVar.f68624a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
                aVar.f68624a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.f68624a.setConrers(15);
                TextView textView = (TextView) view2.findViewById(R.id.tv_name);
                aVar.f68625b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
                aVar.f68625b = (TextView) view2.findViewById(R.id.tv_name);
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            if (i2 >= 0 && i2 < this.f68622e.size()) {
                d.a.s0.v3.h.e.a aVar3 = this.f68622e.get(i2);
                if (aVar3 != null) {
                    aVar.f68624a.setTag(aVar3);
                    aVar.f68624a.setOnClickListener(this);
                    aVar.f68624a.M(String.valueOf(aVar3.f68676b), 24, false);
                    aVar.f68625b.setText(aVar3.f68675a);
                }
                if (!TextUtils.isEmpty(aVar3.f68675a) && (aVar2 = this.f68623f) != null && TextUtils.equals(aVar3.f68675a, aVar2.f68675a)) {
                    aVar.f68624a.setDrawBorder(true);
                } else {
                    aVar.f68624a.setDrawBorder(false);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof d.a.s0.v3.h.e.a)) {
            this.f68623f = (d.a.s0.v3.h.e.a) view.getTag();
            notifyDataSetChanged();
        }
    }
}
