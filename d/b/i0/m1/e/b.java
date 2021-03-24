package d.b.i0.m1.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Object> f56862e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f56863f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56864g;

    /* renamed from: d.b.i0.m1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1345b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56865a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56866b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f56867c;

        public C1345b() {
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56868a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f56869b;

        /* renamed from: c  reason: collision with root package name */
        public View f56870c;

        public c() {
        }
    }

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.f56863f = tbPageContext;
        LocationData b2 = d.b.i0.c3.m0.b.a().b();
        this.f56864g = !d.b.i0.c3.m0.b.a().d();
        if (b2 == null) {
            return;
        }
        this.f56862e = c(b2.getPoi_info(), b2.getFormatted_address());
    }

    public final View a(View view, int i, boolean z) {
        C1345b c1345b;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view != null && (view.getTag() instanceof c)) {
                c1345b = (C1345b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f56863f.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                c1345b = new C1345b();
                c1345b.f56865a = (TextView) view.findViewById(R.id.select_location_name);
                c1345b.f56866b = (TextView) view.findViewById(R.id.select_location_address);
                c1345b.f56867c = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(c1345b);
            }
            c1345b.f56866b.setText(nearByAddressData.getAddr());
            if (this.f56864g && i == 1) {
                c1345b.f56867c.setVisibility(0);
                c1345b.f56867c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    c1345b.f56866b.setText(R.string.select_location_current);
                }
            } else {
                c1345b.f56867c.setVisibility(4);
            }
            c1345b.f56865a.setText(nearByAddressData.getName());
            this.f56863f.getLayoutMode().k(z);
            this.f56863f.getLayoutMode().j(view);
            SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }

    public final View b(View view, int i, boolean z) {
        c cVar;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f56863f.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                cVar = new c();
                cVar.f56868a = (TextView) view.findViewById(R.id.select_location_title);
                cVar.f56869b = (ImageView) view.findViewById(R.id.select_location_tick);
                cVar.f56870c = view.findViewById(R.id.select_location_line);
                view.setTag(cVar);
            }
            if (i == 0 && !this.f56864g) {
                cVar.f56869b.setVisibility(0);
                cVar.f56869b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                cVar.f56869b.setVisibility(4);
            }
            cVar.f56868a.setText(str);
            SkinManager.setBackgroundColor(cVar.f56870c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(cVar.f56868a, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }

    public final ArrayList<Object> c(List<LocationData.NearByAddressData> list, String str) {
        LocationData.NearByAddressData nearByAddressData = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        for (LocationData.NearByAddressData nearByAddressData2 : list) {
            if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                    nearByAddressData = nearByAddressData2;
                } else {
                    arrayList.add(nearByAddressData2);
                }
            }
        }
        if (nearByAddressData != null) {
            arrayList.add(0, nearByAddressData);
        } else {
            LocationData.NearByAddressData nearByAddressData3 = new LocationData.NearByAddressData();
            nearByAddressData3.setName(str);
            arrayList.add(0, nearByAddressData3);
        }
        TbPageContext<SelectLocationActivity> tbPageContext = this.f56863f;
        if (tbPageContext != null) {
            arrayList.add(0, tbPageContext.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Object> arrayList = this.f56862e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Object> arrayList = this.f56862e;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f56862e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        return item instanceof LocationData.NearByAddressData ? 1 : 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                return null;
            }
            return a(view, i, z);
        }
        return b(view, i, z);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
