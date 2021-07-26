package d.a.q0.l3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.g;
/* loaded from: classes8.dex */
public class d extends Dialog implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60677e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60678f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60679g;

    /* renamed from: h  reason: collision with root package name */
    public View f60680h;

    /* renamed from: i  reason: collision with root package name */
    public View f60681i;
    public InterestFrsData.Tag j;
    public c k;
    public GridView l;
    public LinearLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60677e = context;
        e();
    }

    @Override // d.a.q0.l3.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.k.notifyDataSetChanged();
        }
    }

    @Override // d.a.q0.l3.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.k.notifyDataSetChanged();
        }
    }

    @Override // d.a.q0.l3.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.j = tag;
            if (tag != null) {
                this.f60678f.setText(tag.getBname());
                this.f60679g.setText(tag.getBdesc());
                this.k.a(tag.getCard_list());
            }
        }
    }

    @Override // d.a.q0.l3.a
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.m.setOnClickListener(onClickListener);
            this.k.c(onClickListener);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f60681i = View.inflate(this.f60677e, R.layout.new_user_img_box, null);
            this.k = new c(this.f60677e);
            setCanceledOnTouchOutside(true);
            this.m = (LinearLayout) this.f60681i.findViewById(R.id.box_close_layout);
            GridView gridView = (GridView) this.f60681i.findViewById(R.id.layout_content);
            this.l = gridView;
            gridView.setAdapter((ListAdapter) this.k);
            this.l.setSelector(R.color.common_color_10022);
            setContentView(this.f60681i);
            this.f60678f = (TextView) this.f60681i.findViewById(R.id.prompt_title);
            this.f60679g = (TextView) this.f60681i.findViewById(R.id.prompt_sub_title);
            View findViewById = this.f60681i.findViewById(R.id.view_layout);
            this.f60680h = findViewById;
            findViewById.setBackgroundDrawable(this.f60677e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
        }
    }

    @Override // d.a.q0.l3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60681i : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, d.a.q0.l3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f60677e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }
}
