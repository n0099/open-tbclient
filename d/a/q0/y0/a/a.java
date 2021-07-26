package d.a.q0.y0.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Deprecated
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f66977e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftCommonList.GiftItem> f66978f;

    /* renamed from: g  reason: collision with root package name */
    public int f66979g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout.LayoutParams f66980h;

    /* renamed from: d.a.q0.y0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1853a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66981a;

        /* renamed from: b  reason: collision with root package name */
        public View f66982b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f66983c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66984d;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1853a c1853a) {
            this(aVar);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66979g = -1;
        this.f66977e = context;
        this.f66980h = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f66978f.get(i2);
        }
        return (GiftCommonList.GiftItem) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66979g : invokeV.intValue;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f66978f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f66979g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<GiftCommonList.GiftItem> list = this.f66978f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
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
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f66977e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                bVar = new b(this, null);
                bVar.f66981a = (TbImageView) view.findViewById(R.id.image);
                bVar.f66982b = view.findViewById(R.id.mask);
                bVar.f66983c = (TextView) view.findViewById(R.id.name);
                bVar.f66984d = (TextView) view.findViewById(R.id.price);
                view.setTag(bVar);
            }
            bVar.f66982b.setLayoutParams(this.f66980h);
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            SkinManager.setViewTextColor(bVar.f66983c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f66984d, R.color.CAM_X0301, 1);
            if (i2 == this.f66979g) {
                SkinManager.setBackgroundResource(bVar.f66982b, R.drawable.chx_box_gift_s);
            } else {
                bVar.f66982b.setBackgroundResource(R.color.common_color_10022);
            }
            GiftCommonList.GiftItem item = getItem(i2);
            if (item != null) {
                bVar.f66983c.setText(item.getName());
                bVar.f66984d.setText(String.format(this.f66977e.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
                bVar.f66981a.M(item.getThumbnailUrl(), 10, false);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
