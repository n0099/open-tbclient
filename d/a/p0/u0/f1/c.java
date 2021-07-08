package d.a.p0.u0.f1;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f62743a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62744b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62745c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62746d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62747e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f62748f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f62749g;

    /* renamed from: h  reason: collision with root package name */
    public View f62750h;

    /* renamed from: i  reason: collision with root package name */
    public b f62751i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62752e;

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
            this.f62752e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f62752e.f62748f.getId()) {
                    if (this.f62752e.f62744b.getPageActivity() != null) {
                        this.f62752e.f62744b.getPageActivity().finish();
                    }
                    this.f62752e.f(2);
                } else if (view.getId() == this.f62752e.f62749g.getId()) {
                    if (this.f62752e.j != null) {
                        this.f62752e.j.onClick(view);
                    }
                    this.f62752e.f(1);
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
        this.f62744b = tbPageContext;
        this.f62743a = view;
        this.f62745c = (TextView) view.findViewById(R.id.to_user_name);
        this.f62746d = (TextView) view.findViewById(R.id.content);
        this.f62747e = (TextView) view.findViewById(R.id.sender);
        this.f62748f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.o0.r.f0.n.c cVar = new d.a.o0.r.f0.n.c();
        cVar.o(R.color.CAM_X0618);
        this.f62748f.setConfig(cVar);
        this.f62748f.setTextSize(R.dimen.tbds42);
        this.f62748f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f62748f.setOnClickListener(this.k);
        this.f62749g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f62749g.setConfig(bVar);
        this.f62749g.setTextSize(R.dimen.tbds42);
        this.f62749g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f62749g.setOnClickListener(this.k);
        this.f62750h = view.findViewById(R.id.bottom_layout);
        int i4 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f62750h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f62751i = bVar2;
        bVar2.k();
        i();
        String str = this.f62751i.m;
        if (str != null && str.equals("bazhu")) {
            i4 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i4).param("fid", this.f62751i.f62738e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            String str = this.f62751i.m;
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f62751i.f62738e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f62745c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62746d, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62747e, R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f62743a.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f62745c;
            textView.setText(this.f62751i.f62737d + ":");
            this.f62746d.setText(this.f62751i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.f62747e;
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
