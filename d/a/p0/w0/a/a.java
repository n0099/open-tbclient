package d.a.p0.w0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.p0.w0.a.b> f54150e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f54151f;

    /* renamed from: g  reason: collision with root package name */
    public int f54152g;

    /* renamed from: h  reason: collision with root package name */
    public int f54153h;

    /* renamed from: i  reason: collision with root package name */
    public int f54154i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* renamed from: d.a.p0.w0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1247a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f54155a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f54156b;

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

        public /* synthetic */ b(a aVar, C1247a c1247a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
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
        this.f54150e = null;
        this.f54151f = null;
        this.f54152g = -1;
        this.l = 0;
        this.m = 0;
        this.f54151f = tbPageContext;
        this.f54150e = new ArrayList<>();
        this.f54153h = SkinManager.getColor(R.color.common_color_10043);
        this.f54154i = SkinManager.getColor(R.color.CAM_X0302);
        this.j = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.k = l.g(this.f54151f.getPageActivity(), R.dimen.ds4);
        this.l = l.g(this.f54151f.getPageActivity(), R.dimen.ds36);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = i2 / 4;
            if (i3 == 0) {
                return 1;
            }
            return i3 == this.m - 1 ? 2 : 3;
        }
        return invokeI.intValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54152g = i2;
        }
    }

    public void c(ArrayList<d.a.p0.w0.a.b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.f54150e = arrayList;
            if (arrayList != null) {
                if (arrayList.size() % 4 == 0) {
                    this.m = arrayList.size() / 4;
                } else {
                    this.m = (arrayList.size() / 4) + 1;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<d.a.p0.w0.a.b> arrayList = this.f54150e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<d.a.p0.w0.a.b> arrayList = this.f54150e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f54150e.get(i2);
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == this.f54152g ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f54151f.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f54155a = (LinearLayout) view.findViewById(R.id.photo_container);
                bVar.f54156b = (TbImageView) view.findViewById(R.id.photo);
            } else {
                bVar = (b) view.getTag();
            }
            if (a(i2) == 1) {
                bVar.f54155a.setPadding(0, this.l, 0, 0);
            } else if (a(i2) == 2) {
                bVar.f54155a.setPadding(0, 0, 0, this.l);
            } else {
                bVar.f54155a.setPadding(0, 0, 0, 0);
            }
            bVar.f54156b.setDrawerType(0);
            bVar.f54156b.setBorderSurroundContent(true);
            bVar.f54156b.setDrawBorder(true);
            if (itemViewType == 0) {
                bVar.f54156b.setBorderColor(this.f54153h);
                bVar.f54156b.setBorderWidth(this.j);
            } else {
                bVar.f54156b.setBorderColor(this.f54154i);
                bVar.f54156b.setBorderWidth(this.k);
            }
            bVar.f54156b.setDefaultResource(R.drawable.transparent_bg);
            bVar.f54156b.M(this.f54150e.get(i2).a(), 10, false);
            view.setTag(bVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
