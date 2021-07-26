package d.a.q0.j1.b.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationTextItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f59712a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59713b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.i0.g.a f59714c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f59715d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f59716e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f59717f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f59718g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f59719h;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f59720i;
    public List<d.a.d.k.e.a> j;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59721a;

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
            this.f59721a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f59721a.f59716e.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f59721a.f59716e.c();
                } else {
                    this.f59721a.f59716e.a();
                }
            }
        }
    }

    /* renamed from: d.a.q0.j1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1506b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59722e;

        public C1506b(b bVar) {
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
            this.f59722e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59722e.f59714c.d();
                if (!this.f59722e.f59719h.P0() || this.f59722e.m) {
                    this.f59722e.f59714c.g(R.string.no_more_msg);
                    return;
                }
                this.f59722e.f59714c.f(R.string.loading);
                if (this.f59722e.f59719h != null) {
                    this.f59722e.f59719h.T0();
                    this.f59722e.m = true;
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, OfficialNotificationFragment officialNotificationFragment, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, officialNotificationFragment, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59720i = null;
        this.j = new ArrayList();
        this.n = new a(this);
        if (tbPageContext == null) {
            return;
        }
        this.f59717f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f59718g = baseFragmentActivity;
        this.f59719h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f59712a = viewGroup2;
        this.f59716e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f59712a.findViewById(R.id.rv_official_notification);
        this.f59713b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f59718g));
        this.f59713b.setFadingEdgeLength(0);
        this.f59713b.setOverScrollMode(2);
        this.f59713b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f59717f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.p0(officialNotificationFragment);
        this.j.add(this.k);
        this.f59713b.a(this.j);
        d.a.p0.i0.g.a aVar = new d.a.p0.i0.g.a(this.f59718g, this.f59713b);
        this.f59714c = aVar;
        aVar.h(l.g(this.f59718g, R.dimen.tbds182));
        this.f59714c.a();
        this.f59713b.setNextPage(this.f59714c);
        this.f59713b.setOnSrollToBottomListener(new C1506b(this));
        j();
    }

    public void f(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, msgPageData) == null) || this.f59713b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f59713b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59713b;
            return (bdTypeRecyclerView == null || this.f59720i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msgPageData, i2) == null) || this.f59713b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f59713b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f59713b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59712a : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
            if (officialNotificationTextItemAdapter != null) {
                officialNotificationTextItemAdapter.L();
            }
            SkinManager.setBackgroundColor(this.f59713b, R.color.CAM_X0201);
            NoDataView noDataView = this.f59715d;
            if (noDataView != null) {
                noDataView.f(this.f59717f, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f59715d, R.color.CAM_X0201);
            }
            d.a.p0.i0.g.a aVar = this.f59714c;
            if (aVar != null) {
                aVar.onChangeSkinType(this.f59717f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void k(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            if (msgPageData.getIsNewAdd() ? g(msgPageData.getNewAddNum()) : false) {
                l(msgPageData);
            } else {
                m(msgPageData);
            }
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void l(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            o(msgPageData);
            h(msgPageData, 0);
        } catch (Exception unused) {
            h(msgPageData, -1);
        }
    }

    public void m(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, msgPageData) == null) {
            h(msgPageData, -1);
        }
    }

    public void n(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msgPageData) == null) {
            try {
                h(msgPageData, -1);
            } catch (Exception unused) {
                h(msgPageData, -1);
            }
        }
    }

    public final void o(MsgPageData msgPageData) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, msgPageData) == null) || msgPageData == null || msgPageData.getChatMessages() == null || msgPageData.getChatMessages().size() == 0 || (size = msgPageData.getChatMessages().size()) <= 100) {
            return;
        }
        int i2 = size - 100;
        for (int i3 = 0; i3 < i2; i3++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public void p(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || this.f59713b == null) {
            return;
        }
        this.f59720i = list;
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 > 0) {
                if (list.get(i2).getCacheData() == null) {
                    list.get(i2).setCacheData(new MsgCacheData());
                }
                list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
            }
        }
        arrayList2.addAll(arrayList);
        if (arrayList2.isEmpty()) {
            if (this.f59715d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f59718g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f59718g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f59715d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f59715d, R.color.CAM_X0201);
                this.f59712a.addView(this.f59715d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f59713b.setVisibility(8);
            this.f59715d.setVisibility(0);
            this.f59715d.f(this.f59717f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f59715d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f59713b.setData(arrayList2);
        this.f59713b.setVisibility(0);
    }
}
