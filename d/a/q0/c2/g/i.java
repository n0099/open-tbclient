package d.a.q0.c2.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f55325g = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55326e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f55327f;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f55328a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f55329b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f55330c;

        /* renamed from: d  reason: collision with root package name */
        public int f55331d;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f55332e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55331d = 3;
            if (view == null) {
                return;
            }
            this.f55328a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f55329b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f55330c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (i.f55325g != this.f55331d) {
                    SkinManager.setViewTextColor(this.f55328a, R.color.CAM_X0105);
                    this.f55332e = SkinManager.getDrawable(R.drawable.transmit_check_box);
                }
                this.f55331d = i.f55325g;
            }
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baInfo) == null) || baInfo == null) {
                return;
            }
            this.f55328a.setText(baInfo.forum_name);
            this.f55329b.setChecked(baInfo.isChecked);
            this.f55330c.M(baInfo.forum_Avatar, 10, false);
            this.f55329b.setButtonDrawable(this.f55332e);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1926827727, "Ld/a/q0/c2/g/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1926827727, "Ld/a/q0/c2/g/i;");
        }
    }

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55327f = new ArrayList();
        this.f55326e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f55327f.clear();
            this.f55327f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (f55325g != i2) {
                notifyDataSetChanged();
            }
            f55325g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55327f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            a aVar = null;
            if (view == null) {
                view = LayoutInflater.from(this.f55326e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                Object tag = view.getTag();
                if (tag instanceof a) {
                    aVar = (a) tag;
                }
            }
            if (aVar != null) {
                aVar.a();
                aVar.b(this.f55327f.get(i2));
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
