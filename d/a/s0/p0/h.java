package d.a.s0.p0;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f64412e;

    /* renamed from: f  reason: collision with root package name */
    public View f64413f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableString f64414g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64415h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64416i;
    public int j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64417e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64417e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                h hVar = this.f64417e;
                d.a.c.e.m.g.b(hVar, hVar.f64412e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext.getContext(), i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
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
        this.f64412e = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbPageContext = this.f64412e) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(this.j == 1);
        this.f64412e.getLayoutMode().j(this.f64413f);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64413f = LayoutInflater.from(this.f64412e.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
            this.j = TbadkApplication.getInst().getSkinType();
            String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
            this.f64414g = new SpannableString(string);
            this.f64414g.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
            setContentView(this.f64413f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
            TextView textView = (TextView) findViewById(R.id.telphone);
            this.f64415h = textView;
            textView.setText(this.f64414g);
            TextView textView2 = (TextView) findViewById(R.id.confirm);
            this.f64416i = textView2;
            textView2.setOnClickListener(new a(this));
            setCancelable(true);
            b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64413f = LayoutInflater.from(this.f64412e.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
            this.j = TbadkApplication.getInst().getSkinType();
            setContentView(this.f64413f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
            setCancelable(false);
            b();
        }
    }
}
