package d.a.q0.v1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v1.c.b.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<r> f65733e;

    /* renamed from: f  reason: collision with root package name */
    public MemberTaskCenterActivity f65734f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f65735g;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f65736a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65737b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65738c;

        /* renamed from: d  reason: collision with root package name */
        public View f65739d;

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

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65733e = new ArrayList();
        this.f65734f = memberTaskCenterActivity;
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public r getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<r> list = this.f65733e;
            if (list == null || list.size() <= i2) {
                return null;
            }
            return this.f65733e.get(i2);
        }
        return (r) invokeI.objValue;
    }

    public void c(List<r> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f65733e.clear();
            if (list != null) {
                this.f65733e.addAll(list);
            }
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f65735g = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<r> list = this.f65733e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof a)) {
                aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f65734f.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
                aVar = new a(this);
                aVar.f65737b = (TextView) view.findViewById(R.id.task_intro);
                aVar.f65736a = (TextView) view.findViewById(R.id.task_name);
                aVar.f65738c = (TextView) view.findViewById(R.id.task_status);
                aVar.f65739d = view.findViewById(R.id.divider_line);
            }
            r item = getItem(i2);
            if (item != null) {
                aVar.f65736a.setText(item.f());
                aVar.f65737b.setText(a(String.valueOf(item.a()), item.b()));
                if (item.d()) {
                    aVar.f65738c.setText(this.f65734f.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                    aVar.f65738c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    aVar.f65738c.setBackgroundDrawable(null);
                    aVar.f65738c.setOnClickListener(null);
                } else {
                    aVar.f65738c.setText(this.f65734f.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                    SkinManager.setViewTextColor(aVar.f65738c, R.color.member_center_task_btn_textcolor);
                    aVar.f65738c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                    aVar.f65738c.setTag(item);
                    aVar.f65738c.setOnClickListener(this.f65735g);
                }
                SkinManager.setViewTextColor(aVar.f65737b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(aVar.f65736a, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(aVar.f65739d, R.color.CAM_X0204);
            }
            view.setTag(aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
