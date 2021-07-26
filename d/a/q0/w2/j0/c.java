package d.a.q0.w2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.w2.f0.b.f;
import d.a.q0.w2.x;
/* loaded from: classes8.dex */
public class c extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f66714g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66715h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66716i;
    public CountDownTextView j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66717e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f66718f;

        public a(c cVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66718f = cVar;
            this.f66717e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f66718f.f66723b.getContext();
                String str = this.f66717e.f66600d;
                AdvertAppInfo advertAppInfo = this.f66718f.f66725d;
                x.d(context, str, null, advertAppInfo != null ? advertAppInfo.Y3 : "");
                d.a.q0.w2.i0.c cVar = this.f66718f.f66724c;
                if (cVar != null) {
                    cVar.i(302);
                    d.a.q0.w2.i0.e.b().d(this.f66718f.f66724c);
                }
                d.a.q0.n1.o.h.b bVar = this.f66718f.f66726e;
                if (bVar != null) {
                    d.a.q0.n1.o.h.c.h(bVar);
                }
                this.f66718f.a(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view, String str) {
        super(view, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        m();
    }

    @Override // d.a.q0.w2.j0.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.k = z;
            CountDownTextView countDownTextView = this.j;
            if (countDownTextView != null) {
                countDownTextView.setEnableTimeoutListener(z);
            }
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f66715h, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.f66716i, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f66716i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            super.d(fVar);
            this.f66714g.M(fVar.f66599c, 10, false);
            this.f66715h.setText(fVar.f66598b);
            this.f66716i.setText(fVar.f66601e);
            this.f66723b.setOnClickListener(new a(this, fVar));
            this.j.f(fVar.f66604h);
            c();
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.j.e();
        }
    }

    @Override // d.a.q0.w2.j0.e
    public void l(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            super.l(cVar);
            this.j.setTimeoutListener(cVar);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f66714g = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f66714g.setDefaultBgResource(R.color.CAM_X0205);
            this.f66714g.setIsRound(true);
            this.f66715h = (TextView) b(R.id.user_name);
            this.j = (CountDownTextView) b(R.id.count_down_text);
            this.f66716i = (TextView) b(R.id.action);
        }
    }
}
