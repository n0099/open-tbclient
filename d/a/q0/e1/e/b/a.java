package d.a.q0.e1.e.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55816a;

    /* renamed from: b  reason: collision with root package name */
    public View f55817b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f55818c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.e1.e.a.b f55819d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55820e;

    /* renamed from: f  reason: collision with root package name */
    public b f55821f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f55822g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f55823h;

    /* renamed from: d.a.q0.e1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1341a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55824e;

        public C1341a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55824e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f55824e.f55819d == null || i2 >= this.f55824e.f55819d.getCount() || this.f55824e.f55819d.getItem(i2) == null || !(this.f55824e.f55819d.getItem(i2) instanceof d.a.q0.e1.e.c.a)) {
                return;
            }
            d.a.q0.e1.e.c.a aVar = (d.a.q0.e1.e.c.a) this.f55824e.f55819d.getItem(i2);
            if (aVar.f55861d == 1) {
                this.f55824e.f55819d.c(aVar.f55858a);
                if (this.f55824e.f55821f != null) {
                    this.f55824e.f55821f.a(aVar);
                }
                this.f55824e.d();
                d.a.p0.s.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f55858a);
                d.a.p0.s.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f55859b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f55858a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(d.a.q0.e1.e.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55823h = new C1341a(this);
        this.f55816a = tbPageContext;
        this.f55822g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f55817b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f55817b.getParent()).removeView(this.f55817b);
        }
        viewGroup.addView(this.f55817b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f55817b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f55817b.getParent()).removeView(this.f55817b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f55816a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f55817b = inflate;
            this.f55818c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f55819d = new d.a.q0.e1.e.a.b(this.f55816a, 101, this.f55822g);
            this.f55818c.setNumColumns(4);
            this.f55818c.setAdapter((ListAdapter) this.f55819d);
            this.f55818c.setOnItemClickListener(this.f55823h);
            this.f55820e = (TextView) this.f55817b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f55820e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f55817b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f55818c) == null) {
            return;
        }
        gameVideoGridView.d();
    }

    public void h(List<d.a.q0.e1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f55819d.b(list);
        this.f55819d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f55821f = bVar;
        }
    }
}
