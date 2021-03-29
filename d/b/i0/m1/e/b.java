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
    public ArrayList<Object> f56863e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f56864f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56865g;

    /* renamed from: d.b.i0.m1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1346b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56866a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56867b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f56868c;

        public C1346b() {
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f56869a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f56870b;

        /* renamed from: c  reason: collision with root package name */
        public View f56871c;

        public c() {
        }
    }

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.f56864f = tbPageContext;
        LocationData b2 = d.b.i0.c3.m0.b.a().b();
        this.f56865g = !d.b.i0.c3.m0.b.a().d();
        if (b2 == null) {
            return;
        }
        this.f56863e = c(b2.getPoi_info(), b2.getFormatted_address());
    }

    public final View a(View view, int i, boolean z) {
        C1346b c1346b;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view != null && (view.getTag() instanceof c)) {
                c1346b = (C1346b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f56864f.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                c1346b = new C1346b();
                c1346b.f56866a = (TextView) view.findViewById(R.id.select_location_name);
                c1346b.f56867b = (TextView) view.findViewById(R.id.select_location_address);
                c1346b.f56868c = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(c1346b);
            }
            c1346b.f56867b.setText(nearByAddressData.getAddr());
            if (this.f56865g && i == 1) {
                c1346b.f56868c.setVisibility(0);
                c1346b.f56868c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    c1346b.f56867b.setText(R.string.select_location_current);
                }
            } else {
                c1346b.f56868c.setVisibility(4);
            }
            c1346b.f56866a.setText(nearByAddressData.getName());
            this.f56864f.getLayoutMode().k(z);
            this.f56864f.getLayoutMode().j(view);
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
                view = LayoutInflater.from(this.f56864f.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                cVar = new c();
                cVar.f56869a = (TextView) view.findViewById(R.id.select_location_title);
                cVar.f56870b = (ImageView) view.findViewById(R.id.select_location_tick);
                cVar.f56871c = view.findViewById(R.id.select_location_line);
                view.setTag(cVar);
            }
            if (i == 0 && !this.f56865g) {
                cVar.f56870b.setVisibility(0);
                cVar.f56870b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                cVar.f56870b.setVisibility(4);
            }
            cVar.f56869a.setText(str);
            SkinManager.setBackgroundColor(cVar.f56871c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(cVar.f56869a, R.color.CAM_X0302, 1);
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
        TbPageContext<SelectLocationActivity> tbPageContext = this.f56864f;
        if (tbPageContext != null) {
            arrayList.add(0, tbPageContext.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Object> arrayList = this.f56863e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Object> arrayList = this.f56863e;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f56863e.get(i);
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
