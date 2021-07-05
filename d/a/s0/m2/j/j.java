package d.a.s0.m2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends d.a.s0.a0.b<d.a.s0.m2.e.m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long m;
    public View n;
    public TextView o;
    public HTypeListView p;
    public d.a.s0.m2.c.o q;
    public View.OnClickListener r;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f63607e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63607e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f63607e.t();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.l = 4;
        View l = l();
        this.n = l;
        this.o = (TextView) l.findViewById(R.id.card_person_vedio_list_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.card_person_vedio_view_pager);
        this.p = hTypeListView;
        this.q = new d.a.s0.m2.c.o(this.f57032f, hTypeListView);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_person_vedio_list_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || i2 == this.f57031e) {
            return;
        }
        this.f57031e = i2;
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.f57033g).createNormalCfg(this.m, BaiduWalletServiceProviderMap.PLUGIN_PERSONAL)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: u */
    public void m(d.a.s0.m2.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
            if (mVar != null && !ListUtils.isEmpty(mVar.f63515f)) {
                this.m = mVar.f63514e;
                this.o.setText(R.string.video_title_str);
                this.p.setData(v(mVar.f63515f));
                this.q.b(this.r);
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final List<d.a.c.k.e.n> v(List<d.a.c.k.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<d.a.c.k.e.n> arrayList = new ArrayList<>(list);
            int g2 = d.a.c.e.p.l.g(this.f57032f.getPageActivity(), R.dimen.ds490);
            int g3 = d.a.c.e.p.l.g(this.f57032f.getPageActivity(), R.dimen.ds32);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                d.a.s0.m2.e.h hVar = new d.a.s0.m2.e.h();
                hVar.f63496e = d.a.c.e.p.l.g(this.f57032f.getPageActivity(), R.dimen.ds120);
                hVar.f63497f = d.a.c.e.p.l.g(this.f57032f.getPageActivity(), R.dimen.ds396);
                ListUtils.add(arrayList, hVar);
            }
            d.a.s0.j2.d dVar = new d.a.s0.j2.d(g3, g2);
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
