package d.a.s0.u0.f1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f65962a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65963b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f65964c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65965d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65966e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f65967f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f65968g;

    /* renamed from: h  reason: collision with root package name */
    public View f65969h;

    /* renamed from: i  reason: collision with root package name */
    public b f65970i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f65971e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65971e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f65971e.f65967f.getId()) {
                    if (this.f65971e.f65963b.getPageActivity() != null) {
                        this.f65971e.f65963b.getPageActivity().finish();
                    }
                    this.f65971e.f(2);
                } else if (view.getId() == this.f65971e.f65968g.getId()) {
                    if (this.f65971e.j != null) {
                        this.f65971e.j.onClick(view);
                    }
                    this.f65971e.f(1);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.f65963b = tbPageContext;
        this.f65962a = view;
        this.f65964c = (TextView) view.findViewById(R.id.to_user_name);
        this.f65965d = (TextView) view.findViewById(R.id.content);
        this.f65966e = (TextView) view.findViewById(R.id.sender);
        this.f65967f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.r0.r.f0.m.c cVar = new d.a.r0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f65967f.setConfig(cVar);
        this.f65967f.setTextSize(R.dimen.tbds42);
        this.f65967f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f65967f.setOnClickListener(this.k);
        this.f65968g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f65968g.setConfig(bVar);
        this.f65968g.setTextSize(R.dimen.tbds42);
        this.f65968g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f65968g.setOnClickListener(this.k);
        this.f65969h = view.findViewById(R.id.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f65969h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f65970i = bVar2;
        bVar2.k();
        i();
        String str = this.f65970i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f65970i.f65957e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f65970i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f65970i.f65957e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f65964c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65965d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65966e, R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f65962a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f65964c;
            textView.setText(this.f65970i.f65956d + ":");
            this.f65965d.setText(this.f65970i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f65966e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }
}
