package d.b.i0.m1.e;

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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class c implements d.b.h0.t0.a, View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f56872e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f56873f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56874g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f56875h;
    public BdListView i;
    public b j;
    public Intent k;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f56872e = tbPageContext;
        this.f56875h = linearLayout;
        this.f56873f = navigationBar;
        b();
        a();
    }

    public final void a() {
        LayoutInflater.from(this.f56872e.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.f56875h, true);
        this.i = (BdListView) this.f56875h.findViewById(R.id.select_position_list);
        b bVar = new b(this.f56872e);
        this.j = bVar;
        this.i.setAdapter((ListAdapter) bVar);
        this.i.setOnItemClickListener(this);
    }

    public final void b() {
        this.f56873f.setCenterTextTitle(this.f56872e.getResources().getString(R.string.select_position_title));
        ImageView imageView = (ImageView) this.f56873f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f56874g = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, l.g(this.f56872e.getPageActivity(), R.dimen.ds10), 0);
        this.f56874g.setLayoutParams(layoutParams);
        this.f56874g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f56874g.setOnClickListener(this);
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return this.k;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        View childAt;
        BdListView bdListView = this.i;
        return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56874g) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.f56872e.getPageActivity(), 23009)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.j == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        if (i == 0) {
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            locationEvent.isShowLocation = false;
            this.f56872e.getOrignalPage().publishEvent(locationEvent);
            this.f56872e.getOrignalPage().finish();
            return;
        }
        Object item = this.j.getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
            locationEvent.locName = nearByAddressData.getName();
            locationEvent.locAddr = nearByAddressData.getAddr();
            locationEvent.locSn = nearByAddressData.getSn();
            locationEvent.isShowLocation = true;
            this.f56872e.getOrignalPage().publishEvent(locationEvent);
            this.f56872e.getOrignalPage().finish();
        }
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i) {
        this.f56874g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.j.notifyDataSetChanged();
    }
}
