package d.a.s0.h2.k.e.a1;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h2.k.e.r0;
import d.a.s0.z3.i;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f60316a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.h2.i.c f60317b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f60318c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60319d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60320e;

    /* loaded from: classes9.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public c(PbFragment pbFragment, d.a.s0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60318c = null;
        this.f60319d = null;
        this.f60316a = pbFragment;
        this.f60317b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f60318c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f60318c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60318c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f60316a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.f60318c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.f60320e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -r0.f());
            this.f60320e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f60318c.findViewById(R.id.tv_pb_title);
            this.f60319d = textView;
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(textView);
            d2.x(R.dimen.T_X03);
            d2.u(R.dimen.M_T_X003);
            d2.t(R.color.CAM_X0105);
            d2.y(R.string.F_X02);
            d2.q(R.color.CAM_X0304);
            this.f60319d.setVisibility(8);
            if (this.f60319d.getParent() == null) {
                this.f60318c.addView(this.f60319d);
            }
            this.f60318c.setOnTouchListener(this.f60317b);
            this.f60318c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f60318c, R.color.CAM_X0205);
            TextView textView = this.f60319d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                this.f60319d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f60318c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f60318c);
    }

    public void e(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        SpannableStringBuilder b1 = eVar.N().b1();
        SpannableString c2 = r0.c(eVar.N());
        if (!StringUtils.isNull(eVar.N().getTitle())) {
            if (c2 != null) {
                b1.append((CharSequence) c2);
                this.f60319d.setText(b1, TextView.BufferType.SPANNABLE);
            } else {
                this.f60319d.setText(b1);
            }
            h(eVar);
            this.f60319d.setVisibility(0);
            this.f60319d.setMaxLines(3);
            this.f60319d.setEllipsize(TextUtils.TruncateAt.END);
            this.f60319d.invalidate();
            return;
        }
        this.f60319d.setVisibility(8);
    }

    public void f(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            if (eVar != null && !eVar.N().q2() && this.f60319d.getText() != null && this.f60319d.getText().length() > 0) {
                this.f60319d.setVisibility(0);
            } else {
                this.f60319d.setVisibility(8);
            }
        }
    }

    public void g(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        SpannableStringBuilder b1 = eVar.N().b1();
        this.f60319d.setOnTouchListener(new i(b1));
        this.f60319d.setText(b1);
        this.f60319d.setVisibility(0);
    }

    public void h(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || this.f60319d == null) {
            return;
        }
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60319d.getLayoutParams();
        if (eVar.e0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f60319d.setLayoutParams(layoutParams);
    }
}
