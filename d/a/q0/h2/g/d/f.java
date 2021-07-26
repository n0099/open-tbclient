package d.a.q0.h2.g.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f57417a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57418b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57419c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57420d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57421e;

    public f(View view) {
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
        this.f57417a = view;
        this.f57418b = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.f57419c = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.f57420d = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.f57421e = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f57417a, R.drawable.bg_rec_lick);
            SkinManager.setBackgroundResource(this.f57418b, R.drawable.bg_rec_comment);
            SkinManager.setViewTextColor(this.f57419c, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(this.f57420d, R.color.CAM_X0110, 1);
            SkinManager.setImageResource(this.f57421e, R.drawable.recommend_pb_share_selector);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f57418b.setOnClickListener(onClickListener);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f57420d.setText(str);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f57421e.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f57417a.setVisibility(z ? 0 : 8);
        }
    }
}
