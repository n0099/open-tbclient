package d.a.s0.t0.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.t0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<d.a.s0.t0.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f65556a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65557b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f65558c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f65559d;

        /* renamed from: d.a.s0.t0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnLongClickListenerC1684a implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f65560e;

            public View$OnLongClickListenerC1684a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65560e = aVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    for (a aVar : this.f65560e.f65559d.n) {
                        if (aVar != null && aVar.b() != view) {
                            aVar.d(false);
                        }
                    }
                    this.f65560e.d(true);
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: d.a.s0.t0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1685b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f65561e;

            public View$OnClickListenerC1685b(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65561e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65561e.f65557b.getText() == null || StringUtils.isNull(this.f65561e.f65557b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, this.f65561e.f65557b.getText().toString()));
            }
        }

        /* loaded from: classes9.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f65562e;

            public c(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65562e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65562e.f65557b.getText() == null) {
                    return;
                }
                e.b(this.f65562e.f65557b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65559d = bVar;
            View inflate = LayoutInflater.from(bVar.k().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f65556a = inflate;
            this.f65557b = (TextView) inflate.findViewById(R.id.content);
            this.f65558c = (ImageView) this.f65556a.findViewById(R.id.delete);
            c();
            this.f65557b.setOnLongClickListener(new View$OnLongClickListenerC1684a(this, bVar));
            this.f65557b.setOnClickListener(new View$OnClickListenerC1685b(this, bVar));
            this.f65558c.setOnClickListener(new c(this, bVar));
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65556a : (View) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f65557b, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f65557b, R.drawable.search_history_item_bg);
                SkinManager.setImageResource(this.f65558c, R.drawable.del_search_btn);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.f65558c.setVisibility(0);
                    SkinManager.setImageResource(this.f65558c, R.drawable.del_search_btn);
                    return;
                }
                this.f65558c.setVisibility(4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        this.n = new ArrayList();
        this.o = 3;
        this.m = (WrapLineLayout) l();
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.forum_search_history_info : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.o == i2) {
            return;
        }
        for (a aVar : this.n) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.o = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public final void u(int i2) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (size = this.n.size()) == i2) {
            return;
        }
        int i3 = 0;
        if (size < i2) {
            int i4 = i2 - size;
            while (i3 < i4) {
                a t = t();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(t.b(), marginLayoutParams);
                this.n.add(t);
                i3++;
            }
        } else if (i2 == 0) {
            this.m.removeAllViews();
            this.n.clear();
        } else if (size > i2) {
            int i5 = size - i2;
            while (i3 < i5) {
                this.m.removeView(this.n.get(i3).b());
                this.n.remove(i3);
                i3++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: v */
    public void m(d.a.s0.t0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.c())) {
            return;
        }
        u(aVar.c().size());
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = this.n.get(i2);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f65557b.setText(aVar.c().get(i2));
            }
        }
        n(this.f57032f, TbadkCoreApplication.getInst().getSkinType());
    }
}
