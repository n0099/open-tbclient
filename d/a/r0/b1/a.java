package d.a.r0.b1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f54862e;

    /* renamed from: f  reason: collision with root package name */
    public int f54863f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f54864g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f54865h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f54866i;

    /* renamed from: d.a.r0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1222a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f54867a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54868b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54869c;

        public C1222a(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f54867a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f54868b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f54869c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f54870a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54871b;

        public b(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54870a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f54871b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
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
        this.f54863f = 0;
        this.f54862e = context;
        this.f54864g = new ArrayList();
        this.f54865h = new ArrayList();
        this.f54866i = new ArrayList();
    }

    public void a(C1222a c1222a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1222a) == null) || c1222a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1222a.f54868b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1222a.f54869c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f54870a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f54871b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f54865h.clear();
            this.f54866i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f54865h.addAll(list);
                this.f54866i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f54864g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f54864g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f54863f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f54865h)) {
                return 0;
            }
            return this.f54865h.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? super.getItemViewType(i2) : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int i3 = this.f54863f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f54862e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f54865h) && this.f54865h.size() > i2 && !TextUtils.isEmpty(this.f54865h.get(i2))) {
                    bVar.f54870a.setText(this.f54865h.get(i2));
                    bVar.f54870a.setVisibility(0);
                } else {
                    bVar.f54870a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f54866i) && this.f54866i.size() > i2 && !TextUtils.isEmpty(this.f54866i.get(i2))) {
                    bVar.f54871b.setText(this.f54866i.get(i2));
                    bVar.f54871b.setVisibility(0);
                } else {
                    bVar.f54871b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f54862e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
                C1222a c1222a = new C1222a(this, view);
                if (!ListUtils.isEmpty(this.f54864g) && this.f54864g.size() > i2 && !TextUtils.isEmpty(this.f54864g.get(i2))) {
                    c1222a.f54867a.setDefaultResource(R.drawable.transparent_bg);
                    c1222a.f54867a.M(this.f54864g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f54865h) && this.f54865h.size() > i2 && !TextUtils.isEmpty(this.f54865h.get(i2))) {
                    c1222a.f54868b.setText(this.f54865h.get(i2));
                    c1222a.f54868b.setVisibility(0);
                } else {
                    c1222a.f54868b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f54866i) && this.f54866i.size() > i2 && !TextUtils.isEmpty(this.f54866i.get(i2))) {
                    c1222a.f54869c.setText(this.f54866i.get(i2));
                    c1222a.f54869c.setVisibility(0);
                } else {
                    c1222a.f54869c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c1222a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
