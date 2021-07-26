package d.a.q0.n3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f61532e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f61533f;

    /* renamed from: g  reason: collision with root package name */
    public d f61534g;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f61535a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f61536b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f61537c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f61538d;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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

    public e(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61533f = tbPageContext;
        this.f61534g = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f61532e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f61532e.size()) {
                return null;
            }
            return this.f61532e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f61532e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f61532e;
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
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61533f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                aVar = new a(this);
                aVar.f61535a = view.findViewById(R.id.top_white_line);
                aVar.f61536b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                aVar.f61537c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                aVar.f61538d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                view.setTag(aVar);
            }
            if (item != null) {
                if (i2 == 0) {
                    aVar.f61535a.setVisibility(0);
                } else {
                    aVar.f61535a.setVisibility(8);
                }
                aVar.f61536b.e(item.get(0));
                aVar.f61536b.setController(this.f61534g);
                if (item.size() > 2) {
                    aVar.f61537c.e(item.get(1));
                    aVar.f61538d.e(item.get(2));
                    aVar.f61537c.setController(this.f61534g);
                    aVar.f61538d.setController(this.f61534g);
                } else if (item.size() > 1) {
                    aVar.f61537c.e(item.get(1));
                    aVar.f61537c.setController(this.f61534g);
                    aVar.f61538d.f();
                } else {
                    aVar.f61537c.f();
                    aVar.f61538d.f();
                }
            }
            this.f61533f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
