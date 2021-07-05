package d.a.s0.i2.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61995a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f61996b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61997c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61998d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f61999e;

    public b(Context context) {
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
        this.f61995a = null;
        this.f61996b = null;
        this.f61997c = null;
        this.f61998d = null;
        this.f61999e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.zan_list_item, (ViewGroup) null);
        this.f61995a = inflate;
        this.f61996b = (HeadImageView) inflate.findViewById(R.id.zan_list_item_head);
        this.f61997c = (TextView) this.f61995a.findViewById(R.id.zan_list_item_name);
        this.f61998d = (TextView) this.f61995a.findViewById(R.id.zan_list_item_time);
        ImageView imageView = (ImageView) this.f61995a.findViewById(R.id.zan_list_item_line_bottom);
        this.f61999e = imageView;
        imageView.setVisibility(0);
        this.f61995a.setTag(this);
    }

    public static b b(Context context, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, view)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                return (b) view.getTag();
            }
            return new b(context);
        }
        return (b) invokeLL.objValue;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61995a : (View) invokeV.objValue;
    }

    public void c(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.f61997c.setText(str);
            this.f61996b.setImageDrawable(null);
            this.f61998d.setText(StringHelper.getFormatTime(j));
            this.f61996b.M(str2, 28, false);
        }
    }
}
