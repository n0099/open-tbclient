package d.a.p0.v1.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f65280a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f65281b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f65282c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65283d;

    /* renamed from: e  reason: collision with root package name */
    public Context f65284e;

    /* renamed from: f  reason: collision with root package name */
    public String f65285f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().j(this.f65280a);
            d(this.f65285f);
        }
    }

    public View b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f65284e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
            this.f65280a = inflate;
            inflate.setTag(this);
            this.f65282c = (TextView) this.f65280a.findViewById(R.id.tail_management_item_text);
            TextView textView = (TextView) this.f65280a.findViewById(R.id.tail_management_item_delete);
            this.f65283d = textView;
            textView.setTag(this);
            return this.f65280a;
        }
        return (View) invokeL.objValue;
    }

    public TailData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65281b : (TailData) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f65285f = str;
            this.f65282c.setTextColor(d.a.p0.v1.h.f.c.a(str));
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f65282c.setText(TbFaceManager.e().l(this.f65284e, d.a.p0.v1.h.f.d.a(str), null));
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f65283d.setOnClickListener(onClickListener);
        }
    }

    public void g(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bool) == null) {
            this.f65283d.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f65280a.setOnClickListener(onClickListener);
        }
    }

    public void i(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tailData) == null) {
            this.f65281b = tailData;
            e(tailData.getContent());
            d(tailData.getFontColor());
        }
    }
}
