package d.a.q0.t0.d;

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
import d.a.d.e.p.l;
import d.a.q0.t0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a0.b<d.a.q0.t0.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f62981a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62982b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62983c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f62984d;

        /* renamed from: d.a.q0.t0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnLongClickListenerC1647a implements View.OnLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f62985e;

            public View$OnLongClickListenerC1647a(a aVar, b bVar) {
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
                this.f62985e = aVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    for (a aVar : this.f62985e.f62984d.n) {
                        if (aVar != null && aVar.b() != view) {
                            aVar.d(false);
                        }
                    }
                    this.f62985e.d(true);
                    return true;
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: d.a.q0.t0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1648b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f62986e;

            public View$OnClickListenerC1648b(a aVar, b bVar) {
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
                this.f62986e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62986e.f62982b.getText() == null || StringUtils.isNull(this.f62986e.f62982b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, this.f62986e.f62982b.getText().toString()));
            }
        }

        /* loaded from: classes8.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f62987e;

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
                this.f62987e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62987e.f62982b.getText() == null) {
                    return;
                }
                e.b(this.f62987e.f62982b.getText().toString());
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
            this.f62984d = bVar;
            View inflate = LayoutInflater.from(bVar.j().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f62981a = inflate;
            this.f62982b = (TextView) inflate.findViewById(R.id.content);
            this.f62983c = (ImageView) this.f62981a.findViewById(R.id.delete);
            c();
            this.f62982b.setOnLongClickListener(new View$OnLongClickListenerC1647a(this, bVar));
            this.f62982b.setOnClickListener(new View$OnClickListenerC1648b(this, bVar));
            this.f62983c.setOnClickListener(new c(this, bVar));
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62981a : (View) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setViewTextColor(this.f62982b, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f62982b, R.drawable.search_history_item_bg);
                SkinManager.setImageResource(this.f62983c, R.drawable.del_search_btn);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    this.f62983c.setVisibility(0);
                    SkinManager.setImageResource(this.f62983c, R.drawable.del_search_btn);
                    return;
                }
                this.f62983c.setVisibility(4);
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
        this.m = (WrapLineLayout) k();
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.forum_search_history_info : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
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

    public final a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public final void t(int i2) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (size = this.n.size()) == i2) {
            return;
        }
        int i3 = 0;
        if (size < i2) {
            int i4 = i2 - size;
            while (i3 < i4) {
                a s = s();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(s.b(), marginLayoutParams);
                this.n.add(s);
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
    @Override // d.a.q0.a0.b
    /* renamed from: u */
    public void l(d.a.q0.t0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || ListUtils.isEmpty(aVar.c())) {
            return;
        }
        t(aVar.c().size());
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = this.n.get(i2);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f62982b.setText(aVar.c().get(i2));
            }
        }
        m(this.f54320f, TbadkCoreApplication.getInst().getSkinType());
    }
}
