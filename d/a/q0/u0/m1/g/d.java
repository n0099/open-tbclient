package d.a.q0.u0.m1.g;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.p0.s.q.b2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout O;
    public TextView P;
    public TextView Q;
    public TextView R;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.d1.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f63857a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63857a = dVar;
        }

        @Override // d.a.p0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d dVar = this.f63857a;
                if (dVar.z == null || !dVar.Q()) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                d dVar2 = this.f63857a;
                urlManager.dealOneLink(dVar2.f54320f, new String[]{dVar2.z.t()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View k = k();
        this.O = (RelativeLayout) k.findViewById(R.id.lottery_info_layout);
        this.P = (TextView) k.findViewById(R.id.lottery_time_tv);
        this.Q = (TextView) k.findViewById(R.id.lottery_join_count_tv);
        this.R = (TextView) k.findViewById(R.id.lottery_btn);
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ViewHelper.skipToLoginActivity(this.f54320f.getPageActivity());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.card_frs_lottery_new_frame : invokeV.intValue;
    }

    @Override // d.a.q0.u0.m1.g.c, d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            if (this.y != i2) {
                SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.P, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.Q, R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.R, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.R, R.drawable.bg_card_frs_lottery_btn);
            }
            super.m(tbPageContext, i2);
        }
    }

    @Override // d.a.q0.u0.m1.g.c
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.z != null && Q()) {
            UrlManager.getInstance().dealOneLink(this.f54320f, new String[]{this.z.t()});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: z */
    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) || b2Var == null) {
            return;
        }
        if (ListUtils.getCount(b2Var.A0()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(b2Var.A0().get(0));
            b2Var.P3(arrayList);
        }
        super.z(b2Var);
        this.D.setImageClickListener(new a(this));
        d.a.p0.s.q.b bVar = (d.a.p0.s.q.b) ListUtils.getItem(b2Var.o(), 0);
        if (bVar != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.P.setText(StringUtils.string(b().getResources().getString(R.string.lottery_time), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.c())))));
            this.Q.setText(String.format(b().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.f())));
            this.R.setText(R.string.lottery_btn_text);
            this.o.setCommentNumEnable(false);
        }
    }
}
