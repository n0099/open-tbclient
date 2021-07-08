package d.a.p0.n3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.p0.n3.d.c;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static int f60886i = 16;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f60887e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.p0.n3.d.a> f60888f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.n3.d.b f60889g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f60890h;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f60891a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f60892b;

        /* renamed from: c  reason: collision with root package name */
        public View f60893c;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-970480542, "Ld/a/p0/n3/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-970480542, "Ld/a/p0/n3/d/d;");
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60887e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.p0.n3.d.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.p0.n3.d.a> list = this.f60888f;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f60888f.get(i2);
        }
        return (d.a.p0.n3.d.a) invokeI.objValue;
    }

    public void b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f60890h = aVar;
        }
    }

    public void c(List<d.a.p0.n3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f60888f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<d.a.p0.n3.d.a> list = this.f60888f;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f60887e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f60891a = (TextView) view.findViewById(R.id.category_name);
                bVar.f60892b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
                bVar.f60893c = view.findViewById(R.id.line_divider);
                view.setTag(bVar);
            }
            d.a.p0.n3.d.a item = getItem(i2);
            if (StringUtils.isNull(item.a())) {
                bVar.f60891a.setVisibility(8);
            } else {
                bVar.f60891a.setVisibility(0);
                bVar.f60891a.setText(k.cutString(item.a(), f60886i));
            }
            if (item != null && !ListUtils.isEmpty(item.b())) {
                d.a.p0.n3.d.b bVar2 = new d.a.p0.n3.d.b(this.f60887e);
                this.f60889g = bVar2;
                bVar2.d(item.b());
                bVar.f60892b.setAdapter((ListAdapter) this.f60889g);
                this.f60889g.c(this.f60890h);
            }
            if (i2 == getCount() - 1) {
                bVar.f60893c.setVisibility(8);
            } else {
                bVar.f60893c.setVisibility(0);
            }
            SkinManager.setBackgroundColor(bVar.f60893c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.f60891a, R.color.CAM_X0109);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
