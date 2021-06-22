package d.a.o0.o1.e;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class c implements d.a.n0.t0.a, View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f61640e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f61641f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61642g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f61643h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f61644i;
    public b j;
    public Intent k;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f61640e = tbPageContext;
        this.f61643h = linearLayout;
        this.f61641f = navigationBar;
        b();
        a();
    }

    public final void a() {
        LayoutInflater.from(this.f61640e.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.f61643h, true);
        this.f61644i = (BdListView) this.f61643h.findViewById(R.id.select_position_list);
        b bVar = new b(this.f61640e);
        this.j = bVar;
        this.f61644i.setAdapter((ListAdapter) bVar);
        this.f61644i.setOnItemClickListener(this);
    }

    public final void b() {
        this.f61641f.setCenterTextTitle(this.f61640e.getResources().getString(R.string.select_position_title));
        ImageView imageView = (ImageView) this.f61641f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f61642g = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, l.g(this.f61640e.getPageActivity(), R.dimen.ds10), 0);
        this.f61642g.setLayoutParams(layoutParams);
        this.f61642g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f61642g.setOnClickListener(this);
    }

    @Override // d.a.n0.t0.a
    public Intent getResultIntent() {
        return this.k;
    }

    @Override // d.a.n0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.n0.t0.a
    public boolean isOnViewTop() {
        View childAt;
        BdListView bdListView = this.f61644i;
        return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f61644i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f61642g) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.f61640e.getPageActivity(), 23009)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (this.j == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        if (i2 == 0) {
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            locationEvent.isShowLocation = false;
            this.f61640e.getOrignalPage().publishEvent(locationEvent);
            this.f61640e.getOrignalPage().finish();
            return;
        }
        Object item = this.j.getItem(i2);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
            locationEvent.locName = nearByAddressData.getName();
            locationEvent.locAddr = nearByAddressData.getAddr();
            locationEvent.locSn = nearByAddressData.getSn();
            locationEvent.isShowLocation = true;
            this.f61640e.getOrignalPage().publishEvent(locationEvent);
            this.f61640e.getOrignalPage().finish();
        }
    }

    @Override // d.a.n0.t0.a
    public void onViewChangeSkinType(int i2) {
        this.f61642g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.j.notifyDataSetChanged();
    }
}
