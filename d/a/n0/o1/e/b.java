package d.a.n0.o1.e;

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
    public ArrayList<Object> f61506e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f61507f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61508g;

    /* renamed from: d.a.n0.o1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1510b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61509a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61510b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61511c;

        public C1510b() {
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61512a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f61513b;

        /* renamed from: c  reason: collision with root package name */
        public View f61514c;

        public c() {
        }
    }

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.f61507f = tbPageContext;
        LocationData b2 = d.a.n0.e3.m0.b.a().b();
        this.f61508g = !d.a.n0.e3.m0.b.a().d();
        if (b2 == null) {
            return;
        }
        this.f61506e = c(b2.getPoi_info(), b2.getFormatted_address());
    }

    public final View a(View view, int i2, boolean z) {
        C1510b c1510b;
        Object item = getItem(i2);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view != null && (view.getTag() instanceof c)) {
                c1510b = (C1510b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61507f.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                c1510b = new C1510b();
                c1510b.f61509a = (TextView) view.findViewById(R.id.select_location_name);
                c1510b.f61510b = (TextView) view.findViewById(R.id.select_location_address);
                c1510b.f61511c = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(c1510b);
            }
            c1510b.f61510b.setText(nearByAddressData.getAddr());
            if (this.f61508g && i2 == 1) {
                c1510b.f61511c.setVisibility(0);
                c1510b.f61511c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    c1510b.f61510b.setText(R.string.select_location_current);
                }
            } else {
                c1510b.f61511c.setVisibility(4);
            }
            c1510b.f61509a.setText(nearByAddressData.getName());
            this.f61507f.getLayoutMode().k(z);
            this.f61507f.getLayoutMode().j(view);
            SkinManager.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }

    public final View b(View view, int i2, boolean z) {
        c cVar;
        Object item = getItem(i2);
        if (item instanceof String) {
            String str = (String) item;
            if (view != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61507f.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                cVar = new c();
                cVar.f61512a = (TextView) view.findViewById(R.id.select_location_title);
                cVar.f61513b = (ImageView) view.findViewById(R.id.select_location_tick);
                cVar.f61514c = view.findViewById(R.id.select_location_line);
                view.setTag(cVar);
            }
            if (i2 == 0 && !this.f61508g) {
                cVar.f61513b.setVisibility(0);
                cVar.f61513b.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_chx__site_ok24, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                cVar.f61513b.setVisibility(4);
            }
            cVar.f61512a.setText(str);
            SkinManager.setBackgroundColor(cVar.f61514c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(cVar.f61512a, R.color.CAM_X0302, 1);
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
        TbPageContext<SelectLocationActivity> tbPageContext = this.f61507f;
        if (tbPageContext != null) {
            arrayList.add(0, tbPageContext.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Object> arrayList = this.f61506e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<Object> arrayList = this.f61506e;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f61506e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        Object item = getItem(i2);
        if (item instanceof String) {
            return 0;
        }
        return item instanceof LocationData.NearByAddressData ? 1 : 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                return null;
            }
            return a(view, i2, z);
        }
        return b(view, i2, z);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
