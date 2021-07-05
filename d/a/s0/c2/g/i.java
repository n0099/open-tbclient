package d.a.s0.c2.g;

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
/* loaded from: classes9.dex */
public class i extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f58036g = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f58037e;

    /* renamed from: f  reason: collision with root package name */
    public List<BazhuInfoData.BaInfo> f58038f;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f58039a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f58040b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f58041c;

        /* renamed from: d  reason: collision with root package name */
        public int f58042d;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f58043e;

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
            this.f58042d = 3;
            if (view == null) {
                return;
            }
            this.f58039a = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.f58040b = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f58041c = (BarImageView) view.findViewById(R.id.forum_avatar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (i.f58036g != this.f58042d) {
                    SkinManager.setViewTextColor(this.f58039a, R.color.CAM_X0105);
                    this.f58043e = SkinManager.getDrawable(R.drawable.transmit_check_box);
                }
                this.f58042d = i.f58036g;
            }
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baInfo) == null) || baInfo == null) {
                return;
            }
            this.f58039a.setText(baInfo.forum_name);
            this.f58040b.setChecked(baInfo.isChecked);
            this.f58041c.M(baInfo.forum_Avatar, 10, false);
            this.f58040b.setButtonDrawable(this.f58043e);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1533800717, "Ld/a/s0/c2/g/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1533800717, "Ld/a/s0/c2/g/i;");
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
        this.f58038f = new ArrayList();
        this.f58037e = context;
    }

    public void b(List<BazhuInfoData.BaInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f58038f.clear();
            this.f58038f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (f58036g != i2) {
                notifyDataSetChanged();
            }
            f58036g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58038f.size() : invokeV.intValue;
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
                view = LayoutInflater.from(this.f58037e).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
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
                aVar.b(this.f58038f.get(i2));
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
