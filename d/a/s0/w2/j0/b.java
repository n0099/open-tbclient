package d.a.s0.w2.j0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.f0.b.f;
import d.a.s0.w2.x;
/* loaded from: classes9.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f69250g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69251h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f69252i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f69253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f69254f;

        public a(b bVar, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69254f = bVar;
            this.f69253e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f69254f.f69264b.getContext();
                f fVar = this.f69253e;
                String str = fVar.f69153d;
                String str2 = fVar.f69155f;
                AdvertAppInfo advertAppInfo = this.f69254f.f69266d;
                x.d(context, str, str2, advertAppInfo != null ? advertAppInfo.S3 : "");
                d.a.s0.w2.i0.c cVar = this.f69254f.f69265c;
                if (cVar != null) {
                    cVar.i(302);
                    d.a.s0.w2.i0.e.b().d(this.f69254f.f69265c);
                }
                d.a.s0.n1.o.h.b bVar = this.f69254f.f69267e;
                if (bVar != null) {
                    d.a.s0.n1.o.h.c.h(bVar);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, String str) {
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

    @Override // d.a.s0.w2.j0.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f69251h, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.f69252i, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f69252i, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.s0.w2.j0.e
    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            super.d(fVar);
            this.f69250g.M(fVar.f69152c, 10, false);
            this.f69251h.setText(fVar.f69151b);
            this.f69252i.setText(fVar.f69154e);
            this.f69264b.setOnClickListener(new a(this, fVar));
            c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f69250g = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f69250g.setDefaultBgResource(R.color.CAM_X0205);
            this.f69250g.setIsRound(true);
            this.f69251h = (TextView) b(R.id.user_name);
            this.f69252i = (TextView) b(R.id.action);
        }
    }
}
