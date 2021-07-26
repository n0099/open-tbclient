package d.a.q0.l0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60534a;

    /* renamed from: b  reason: collision with root package name */
    public View f60535b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60536c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60537d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60538e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60539f;

    public c(TbPageContext<?> tbPageContext) {
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
        this.f60534a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.f60535b = inflate;
        this.f60536c = (ViewGroup) inflate.findViewById(R.id.item_group);
        this.f60537d = (ImageView) this.f60535b.findViewById(R.id.image);
        this.f60538e = (TextView) this.f60535b.findViewById(R.id.hint_text_1);
        this.f60539f = (TextView) this.f60535b.findViewById(R.id.hint_text_2);
        this.f60538e.setText(R.string.no_like_forum_hint_1);
        this.f60539f.setText(R.string.no_like_forum_hint_2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.f60537d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.f60538e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f60539f, R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(l.g(this.f60534a.getPageActivity(), R.dimen.tbds21)).trRadius(l.g(this.f60534a.getPageActivity(), R.dimen.tbds21)).blRadius(l.g(this.f60534a.getPageActivity(), R.dimen.tbds21)).brRadius(l.g(this.f60534a.getPageActivity(), R.dimen.tbds21)).into(this.f60536c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60535b : (View) invokeV.objValue;
    }
}
