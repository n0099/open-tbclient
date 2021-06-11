package d.a.n0.o1.e;

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
public class c implements d.a.m0.t0.a, View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f61515e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f61516f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61517g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f61518h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f61519i;
    public b j;
    public Intent k;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f61515e = tbPageContext;
        this.f61518h = linearLayout;
        this.f61516f = navigationBar;
        b();
        a();
    }

    public final void a() {
        LayoutInflater.from(this.f61515e.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.f61518h, true);
        this.f61519i = (BdListView) this.f61518h.findViewById(R.id.select_position_list);
        b bVar = new b(this.f61515e);
        this.j = bVar;
        this.f61519i.setAdapter((ListAdapter) bVar);
        this.f61519i.setOnItemClickListener(this);
    }

    public final void b() {
        this.f61516f.setCenterTextTitle(this.f61515e.getResources().getString(R.string.select_position_title));
        ImageView imageView = (ImageView) this.f61516f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f61517g = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, l.g(this.f61515e.getPageActivity(), R.dimen.ds10), 0);
        this.f61517g.setLayoutParams(layoutParams);
        this.f61517g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f61517g.setOnClickListener(this);
    }

    @Override // d.a.m0.t0.a
    public Intent getResultIntent() {
        return this.k;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewTop() {
        View childAt;
        BdListView bdListView = this.f61519i;
        return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f61519i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f61517g) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.f61515e.getPageActivity(), 23009)));
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
            this.f61515e.getOrignalPage().publishEvent(locationEvent);
            this.f61515e.getOrignalPage().finish();
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
            this.f61515e.getOrignalPage().publishEvent(locationEvent);
            this.f61515e.getOrignalPage().finish();
        }
    }

    @Override // d.a.m0.t0.a
    public void onViewChangeSkinType(int i2) {
        this.f61517g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.j.notifyDataSetChanged();
    }
}
