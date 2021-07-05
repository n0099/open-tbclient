package d.a.s0.n1.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n1.p.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f63918e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63919f;

    /* renamed from: g  reason: collision with root package name */
    public int f63920g;

    /* renamed from: h  reason: collision with root package name */
    public int f63921h;

    /* renamed from: i  reason: collision with root package name */
    public final int f63922i;

    public b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63918e = new ArrayList();
        this.f63920g = 0;
        this.f63921h = 0;
        this.f63919f = context;
        this.f63920g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f63921h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f63922i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.f63918e.size()) {
                return null;
            }
            return this.f63918e.get(i2);
        }
        return (e) invokeI.objValue;
    }

    public void b(List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f63918e.clear();
            if (list != null && list.size() > 0) {
                this.f63918e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63918e.size() : invokeV.intValue;
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
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = new TextView(this.f63919f);
                textView.setGravity(17);
                textView.setTextSize(0, this.f63920g);
                int i3 = this.f63921h;
                textView.setPadding(0, i3, 0, i3);
            }
            e eVar = (e) ListUtils.getItem(this.f63918e, i2);
            if (eVar == null) {
                return null;
            }
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f63905c, 8, null));
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            if (i2 == this.f63922i) {
                SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
            } else {
                SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
            }
            return textView;
        }
        return (View) invokeILL.objValue;
    }
}
