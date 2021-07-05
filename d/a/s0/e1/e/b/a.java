package d.a.s0.e1.e.b;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58527a;

    /* renamed from: b  reason: collision with root package name */
    public View f58528b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f58529c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.e1.e.a.b f58530d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58531e;

    /* renamed from: f  reason: collision with root package name */
    public b f58532f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f58533g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f58534h;

    /* renamed from: d.a.s0.e1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1378a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58535e;

        public C1378a(a aVar) {
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
            this.f58535e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f58535e.f58530d == null || i2 >= this.f58535e.f58530d.getCount() || this.f58535e.f58530d.getItem(i2) == null || !(this.f58535e.f58530d.getItem(i2) instanceof d.a.s0.e1.e.c.a)) {
                return;
            }
            d.a.s0.e1.e.c.a aVar = (d.a.s0.e1.e.c.a) this.f58535e.f58530d.getItem(i2);
            if (aVar.f58572d == 1) {
                this.f58535e.f58530d.c(aVar.f58569a);
                if (this.f58535e.f58532f != null) {
                    this.f58535e.f58532f.a(aVar);
                }
                this.f58535e.d();
                d.a.r0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f58569a);
                d.a.r0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f58570b);
                TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f58569a));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(d.a.s0.e1.e.c.a aVar);
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
        this.f58534h = new C1378a(this);
        this.f58527a = tbPageContext;
        this.f58533g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null || (view = this.f58528b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f58528b.getParent()).removeView(this.f58528b);
        }
        viewGroup.addView(this.f58528b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f58528b) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f58528b.getParent()).removeView(this.f58528b);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f58527a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
            this.f58528b = inflate;
            this.f58529c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
            this.f58530d = new d.a.s0.e1.e.a.b(this.f58527a, 101, this.f58533g);
            this.f58529c.setNumColumns(4);
            this.f58529c.setAdapter((ListAdapter) this.f58530d);
            this.f58529c.setOnItemClickListener(this.f58534h);
            this.f58531e = (TextView) this.f58528b.findViewById(R.id.id_game_video_choose_full_title);
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.f58531e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            View view = this.f58528b;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            }
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gameVideoGridView = this.f58529c) == null) {
            return;
        }
        gameVideoGridView.d();
    }

    public void h(List<d.a.s0.e1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f58530d.b(list);
        this.f58530d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f58532f = bVar;
        }
    }
}
