package d.a.s0.u0.a2;

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
import d.a.s0.a0.t;
import tbclient.Item;
import tbclient.ItemInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f65735a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f65736b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f65737c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.u0.a2.f.a f65738d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f65739e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f65740f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.u0.a2.a f65741g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.u0.a2.d f65742h;

    /* renamed from: i  reason: collision with root package name */
    public Button f65743i;
    public View j;
    public String k;
    public RecyclerView.OnScrollListener l;
    public View.OnClickListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes9.dex */
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

    /* renamed from: d.a.s0.u0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1703b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1703b(b bVar) {
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
                if (tag instanceof d.a.r0.r.f0.o.a) {
                    Item a2 = ((d.a.r0.r.f0.o.a) tag).a();
                    if (ItemCardHelper.f12680a.equals(a2.button_name) || ItemCardHelper.f12681b.equals(a2.button_name)) {
                        d.a.s0.u0.a2.h.a aVar = new d.a.s0.u0.a2.h.a(8);
                        aVar.j(ItemCardHelper.f12680a.equals(a2.button_name) ? 1 : 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, aVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65744e;

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
            this.f65744e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.f65744e.f65743i.getBackground();
                gradientDrawable.setCornerRadius(this.f65744e.f65743i.getHeight() / 2);
                this.f65744e.f65743i.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65745a;

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
            this.f65745a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f65745a.k = (String) customResponsedMessage.getData();
                ItemCardHelper.r(this.f65745a.f65743i, this.f65745a.k);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65746a;

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
            this.f65746a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof d.a.s0.u0.k2.a)) {
                    return;
                }
                d.a.s0.u0.k2.a aVar = (d.a.s0.u0.k2.a) customResponsedMessage.getData();
                if (aVar.f66229b == this.f65746a.f65735a.f15867e) {
                    int i2 = aVar.f66230c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f66228a = this.f65746a.f65743i;
                    } else if (i2 == 1) {
                        aVar.f66228a = null;
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
        this.m = new View$OnClickListenerC1703b(this);
        this.n = new e(this, 2921591);
        f fVar = new f(this, 2921590);
        this.o = fVar;
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f65735a = frsItemTabFragment;
        fVar.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.o);
        frsItemTabFragment.registerListener(this.n);
        Button button = (Button) view.findViewById(R.id.frs_btn_order_or_download);
        this.f65743i = button;
        button.setOnClickListener(this.m);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_item_tab_recycler_view);
        this.f65740f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f65740f.setFadingEdgeLength(0);
        this.f65740f.setOverScrollMode(2);
        this.f65740f.addOnScrollListener(this.l);
        this.f65740f.setRecyclerListener(new c(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f65740f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f65740f.getPaddingBottom());
        this.f65736b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f65737c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f65738d = new d.a.s0.u0.a2.f.a(frsItemTabFragment.getContext());
        this.f65739e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f65741g = new d.a.s0.u0.a2.a(frsItemTabFragment, this.f65740f);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65740f.removeHeaderView(this.f65736b);
            this.f65740f.removeHeaderView(this.f65737c);
            this.f65740f.removeHeaderView(this.f65738d.a());
            this.f65740f.removeHeaderView(this.f65739e);
            d.a.s0.u0.a2.d dVar = this.f65742h;
            if (dVar == null) {
                return;
            }
            if (dVar.f65752e != null) {
                this.f65740f.s(this.f65736b);
                this.f65736b.setData(this.f65742h.f65752e);
            }
            if (!ListUtils.isEmpty(this.f65742h.f65753f)) {
                this.f65740f.s(this.f65737c);
                this.f65737c.setData(this.f65742h.f65753f);
            }
            ItemInfo itemInfo = this.f65742h.f65752e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f65740f.s(this.f65738d.a());
                this.f65738d.d(this.f65742h.f65752e);
            }
            if (this.f65742h.f65752e != null) {
                this.f65740f.s(this.f65739e);
                this.f65739e.setData(this.f65742h.f65752e);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.u0.a2.a aVar = this.f65741g;
            if (aVar != null) {
                aVar.d();
            }
            this.f65736b.onChangeSkinType(this.f65735a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f65737c.onChangeSkinType(this.f65735a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f65738d.c();
            this.f65739e.onChangeSkinType(this.f65735a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void g() {
        d.a.s0.u0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f65741g) == null) {
            return;
        }
        aVar.e();
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d.a.s0.u0.k2.a aVar = new d.a.s0.u0.k2.a();
            aVar.f66229b = z ? this.f65735a.f15867e : 0;
            aVar.f66230c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f65735a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void i(d.a.s0.u0.a2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f65742h = dVar;
        e();
        if (dVar.f65752e != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(d.a.c.e.m.b.f(String.valueOf(dVar.f65752e.id), 0L));
            ItemInfo itemInfo = dVar.f65752e;
            builder.forum_name = itemInfo.forum_name;
            builder.button_link = itemInfo.button_link;
            builder.button_link_type = itemInfo.button_link_type;
            builder.button_name = itemInfo.button_name;
            builder.item_name = itemInfo.name;
            d.a.r0.r.f0.o.a aVar = new d.a.r0.r.f0.o.a(builder.build(true), 0);
            ItemCardHelper.i(this.f65743i, aVar, this.k);
            Item a2 = aVar.a();
            if (!ItemCardHelper.f12683d.equals(a2.button_name)) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (ItemCardHelper.f12682c.equals(a2.button_name)) {
                    this.f65743i.setTextColor(d.a.s0.h3.c.a(d.a.s0.h3.c.c(this.k), d.a.r0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), d.a.s0.h3.c.a(d.a.s0.h3.c.c(this.k), d.a.r0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0201));
                    this.f65743i.setBackgroundDrawable(gradientDrawable);
                } else {
                    this.f65743i.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(d.a.s0.h3.c.c(this.k));
                    this.f65743i.setBackgroundDrawable(gradientDrawable);
                }
                this.f65743i.post(new d(this));
                this.f65743i.setVisibility(0);
                this.f65743i.setText(a2.button_name);
                if (this.j == null) {
                    this.j = new View(this.f65735a.getContext());
                    this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
                }
                this.f65740f.setFooterView(this.j);
                if (ItemCardHelper.f12680a.equals(a2.button_name) || ItemCardHelper.f12681b.equals(a2.button_name)) {
                    d.a.s0.u0.a2.h.a aVar2 = new d.a.s0.u0.a2.h.a(7);
                    aVar2.j(ItemCardHelper.f12680a.equals(a2.button_name) ? 1 : 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, aVar2));
                }
            }
        }
        this.f65741g.f(dVar.f65754g);
        this.f65741g.d();
    }

    public void j(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bdTypeRecyclerView = this.f65740f) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (bdTypeRecyclerView = this.f65740f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }
}
