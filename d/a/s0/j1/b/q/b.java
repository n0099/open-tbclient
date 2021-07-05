package d.a.s0.j1.b.q;

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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f62333a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62334b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.g0.g.a f62335c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f62336d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f62337e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62338f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f62339g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialNotificationFragment f62340h;

    /* renamed from: i  reason: collision with root package name */
    public List<ChatMessage> f62341i;
    public List<d.a.c.k.e.a> j;
    public OfficialNotificationTextItemAdapter k;
    public boolean l;
    public boolean m;
    public RecyclerView.OnScrollListener n;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62342a;

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
            this.f62342a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f62342a.f62337e.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f62342a.f62337e.c();
                } else {
                    this.f62342a.f62337e.a();
                }
            }
        }
    }

    /* renamed from: d.a.s0.j1.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1545b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62343e;

        public C1545b(b bVar) {
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
            this.f62343e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62343e.f62335c.d();
                if (!this.f62343e.f62340h.J0() || this.f62343e.m) {
                    this.f62343e.f62335c.g(R.string.no_more_msg);
                    return;
                }
                this.f62343e.f62335c.f(R.string.loading);
                if (this.f62343e.f62340h != null) {
                    this.f62343e.f62340h.N0();
                    this.f62343e.m = true;
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
        this.f62341i = null;
        this.j = new ArrayList();
        this.n = new a(this);
        if (tbPageContext == null) {
            return;
        }
        this.f62338f = tbPageContext;
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) tbPageContext.getPageActivity();
        this.f62339g = baseFragmentActivity;
        this.f62340h = officialNotificationFragment;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(baseFragmentActivity).inflate(R.layout.fragment_official_notification, viewGroup, false);
        this.f62333a = viewGroup2;
        this.f62337e = (NavigationBarShadowView) viewGroup2.findViewById(R.id.navi_shadow_view_official_notification);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f62333a.findViewById(R.id.rv_official_notification);
        this.f62334b = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f62339g));
        this.f62334b.setFadingEdgeLength(0);
        this.f62334b.setOverScrollMode(2);
        this.f62334b.addOnScrollListener(this.n);
        OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = new OfficialNotificationTextItemAdapter(this.f62338f, ChatMessage.TYPE_MSG_LEFT);
        this.k = officialNotificationTextItemAdapter;
        officialNotificationTextItemAdapter.s0(officialNotificationFragment);
        this.j.add(this.k);
        this.f62334b.a(this.j);
        d.a.r0.g0.g.a aVar = new d.a.r0.g0.g.a(this.f62339g, this.f62334b);
        this.f62335c = aVar;
        aVar.h(l.g(this.f62339g, R.dimen.tbds182));
        this.f62335c.a();
        this.f62334b.setNextPage(this.f62335c);
        this.f62334b.setOnSrollToBottomListener(new C1545b(this));
        j();
    }

    public void f(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, msgPageData) == null) || this.f62334b == null || msgPageData == null) {
            return;
        }
        p(msgPageData.getChatMessages());
        this.f62334b.getAdapter().notifyDataSetChanged();
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f62334b;
            return (bdTypeRecyclerView == null || this.f62341i == null || bdTypeRecyclerView.getFirstVisiblePosition() != 0) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public final void h(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msgPageData, i2) == null) || this.f62334b == null) {
            return;
        }
        this.m = false;
        if (msgPageData == null) {
            return;
        }
        try {
            p(msgPageData.getChatMessages());
            this.f62334b.getAdapter().notifyDataSetChanged();
            if (i2 >= 0) {
                this.f62334b.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62333a : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            OfficialNotificationTextItemAdapter officialNotificationTextItemAdapter = this.k;
            if (officialNotificationTextItemAdapter != null) {
                officialNotificationTextItemAdapter.L();
            }
            SkinManager.setBackgroundColor(this.f62334b, R.color.CAM_X0201);
            NoDataView noDataView = this.f62336d;
            if (noDataView != null) {
                noDataView.f(this.f62338f, TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f62336d, R.color.CAM_X0201);
            }
            d.a.r0.g0.g.a aVar = this.f62335c;
            if (aVar != null) {
                aVar.onChangeSkinType(this.f62338f, TbadkCoreApplication.getInst().getSkinType());
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || this.f62334b == null) {
            return;
        }
        this.f62341i = list;
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
            if (this.f62336d == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f62339g, null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f62339g.getResources().getString(R.string.official_notification_no_data)), null);
                this.f62336d = a2;
                a2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.f62336d, R.color.CAM_X0201);
                this.f62333a.addView(this.f62336d);
            }
            if (this.l) {
                return;
            }
            this.l = true;
            this.f62334b.setVisibility(8);
            this.f62336d.setVisibility(0);
            this.f62336d.f(this.f62338f, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        NoDataView noDataView = this.f62336d;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.l = false;
        this.f62334b.setData(arrayList2);
        this.f62334b.setVisibility(0);
    }
}
