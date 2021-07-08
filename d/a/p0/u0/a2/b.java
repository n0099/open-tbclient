package d.a.p0.u0.a2;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoAlbumLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoBriefLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoDownloadLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.a0.t;
import tbclient.Item;
import tbclient.ItemInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f62516a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f62517b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f62518c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.u0.a2.f.a f62519d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f62520e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f62521f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.u0.a2.a f62522g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.u0.a2.d f62523h;

    /* renamed from: i  reason: collision with root package name */
    public Button f62524i;
    public View j;
    public String k;
    public RecyclerView.OnScrollListener l;
    public View.OnClickListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                t.b().e(true);
            }
        }
    }

    /* renamed from: d.a.p0.u0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1662b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1662b(b bVar) {
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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view));
                Object tag = view.getTag(R.id.item_data);
                if (tag instanceof d.a.o0.r.f0.p.a) {
                    Item a2 = ((d.a.o0.r.f0.p.a) tag).a();
                    if (ItemCardHelper.f12697a.equals(a2.button_name) || ItemCardHelper.f12698b.equals(a2.button_name)) {
                        d.a.p0.u0.a2.h.a aVar = new d.a.p0.u0.a2.h.a(8);
                        aVar.j(ItemCardHelper.f12697a.equals(a2.button_name) ? 1 : 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, aVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
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
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            PlayVoiceBnt playVoiceBnt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice)) == null) {
                return;
            }
            playVoiceBnt.h();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62525e;

        public d(b bVar) {
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
            this.f62525e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.f62525e.f62524i.getBackground();
                gradientDrawable.setCornerRadius(this.f62525e.f62524i.getHeight() / 2);
                this.f62525e.f62524i.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62526a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62526a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f62526a.k = (String) customResponsedMessage.getData();
                ItemCardHelper.r(this.f62526a.f62524i, this.f62526a.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62527a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62527a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof d.a.p0.u0.k2.a)) {
                    return;
                }
                d.a.p0.u0.k2.a aVar = (d.a.p0.u0.k2.a) customResponsedMessage.getData();
                if (aVar.f63010b == this.f62527a.f62516a.f15906e) {
                    int i2 = aVar.f63011c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f63009a = this.f62527a.f62524i;
                    } else if (i2 == 1) {
                        aVar.f63009a = null;
                    }
                }
            }
        }
    }

    public b(FrsItemTabFragment frsItemTabFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.l = new a(this);
        this.m = new View$OnClickListenerC1662b(this);
        this.n = new e(this, 2921591);
        f fVar = new f(this, 2921590);
        this.o = fVar;
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f62516a = frsItemTabFragment;
        fVar.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.o);
        frsItemTabFragment.registerListener(this.n);
        Button button = (Button) view.findViewById(R.id.frs_btn_order_or_download);
        this.f62524i = button;
        button.setOnClickListener(this.m);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_item_tab_recycler_view);
        this.f62521f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f62521f.setFadingEdgeLength(0);
        this.f62521f.setOverScrollMode(2);
        this.f62521f.addOnScrollListener(this.l);
        this.f62521f.setRecyclerListener(new c(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f62521f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f62521f.getPaddingBottom());
        this.f62517b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f62518c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f62519d = new d.a.p0.u0.a2.f.a(frsItemTabFragment.getContext());
        this.f62520e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f62522g = new d.a.p0.u0.a2.a(frsItemTabFragment, this.f62521f);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62521f.removeHeaderView(this.f62517b);
            this.f62521f.removeHeaderView(this.f62518c);
            this.f62521f.removeHeaderView(this.f62519d.a());
            this.f62521f.removeHeaderView(this.f62520e);
            d.a.p0.u0.a2.d dVar = this.f62523h;
            if (dVar == null) {
                return;
            }
            if (dVar.f62533e != null) {
                this.f62521f.s(this.f62517b);
                this.f62517b.setData(this.f62523h.f62533e);
            }
            if (!ListUtils.isEmpty(this.f62523h.f62534f)) {
                this.f62521f.s(this.f62518c);
                this.f62518c.setData(this.f62523h.f62534f);
            }
            ItemInfo itemInfo = this.f62523h.f62533e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f62521f.s(this.f62519d.a());
                this.f62519d.d(this.f62523h.f62533e);
            }
            if (this.f62523h.f62533e != null) {
                this.f62521f.s(this.f62520e);
                this.f62520e.setData(this.f62523h.f62533e);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.p0.u0.a2.a aVar = this.f62522g;
            if (aVar != null) {
                aVar.d();
            }
            this.f62517b.onChangeSkinType(this.f62516a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f62518c.onChangeSkinType(this.f62516a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f62519d.c();
            this.f62520e.onChangeSkinType(this.f62516a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        d.a.p0.u0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f62522g) == null) {
            return;
        }
        aVar.e();
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d.a.p0.u0.k2.a aVar = new d.a.p0.u0.k2.a();
            aVar.f63010b = z ? this.f62516a.f15906e : 0;
            aVar.f63011c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f62516a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void i(d.a.p0.u0.a2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f62523h = dVar;
        e();
        if (dVar.f62533e != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(d.a.c.e.m.b.f(String.valueOf(dVar.f62533e.id), 0L));
            ItemInfo itemInfo = dVar.f62533e;
            builder.forum_name = itemInfo.forum_name;
            builder.button_link = itemInfo.button_link;
            builder.button_link_type = itemInfo.button_link_type;
            builder.button_name = itemInfo.button_name;
            builder.item_name = itemInfo.name;
            d.a.o0.r.f0.p.a aVar = new d.a.o0.r.f0.p.a(builder.build(true), 0);
            ItemCardHelper.i(this.f62524i, aVar, this.k);
            Item a2 = aVar.a();
            if (!ItemCardHelper.f12700d.equals(a2.button_name)) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (ItemCardHelper.f12699c.equals(a2.button_name)) {
                    this.f62524i.setTextColor(d.a.p0.h3.c.a(d.a.p0.h3.c.c(this.k), d.a.o0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), d.a.p0.h3.c.a(d.a.p0.h3.c.c(this.k), d.a.o0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0201));
                    this.f62524i.setBackgroundDrawable(gradientDrawable);
                } else {
                    this.f62524i.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(d.a.p0.h3.c.c(this.k));
                    this.f62524i.setBackgroundDrawable(gradientDrawable);
                }
                this.f62524i.post(new d(this));
                this.f62524i.setVisibility(0);
                this.f62524i.setText(a2.button_name);
                if (this.j == null) {
                    this.j = new View(this.f62516a.getContext());
                    this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
                }
                this.f62521f.setFooterView(this.j);
                if (ItemCardHelper.f12697a.equals(a2.button_name) || ItemCardHelper.f12698b.equals(a2.button_name)) {
                    d.a.p0.u0.a2.h.a aVar2 = new d.a.p0.u0.a2.h.a(7);
                    aVar2.j(ItemCardHelper.f12697a.equals(a2.button_name) ? 1 : 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, aVar2));
                }
            }
        }
        this.f62522g.f(dVar.f62535g);
        this.f62522g.d();
    }

    public void j(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bdTypeRecyclerView = this.f62521f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }

    public void l(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (bdTypeRecyclerView = this.f62521f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }
}
