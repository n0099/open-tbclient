package d.a.n0.m0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchasePackageData;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class k extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public FacePurchaseRecordsActivity f57267e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsData f57268f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57269g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(k.this.f57267e.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
            k.this.f57267e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f57271a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57272b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57273c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57274d;

        public b(k kVar) {
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.f57267e = facePurchaseRecordsActivity;
    }

    public final View b() {
        View inflate = LayoutInflater.from(this.f57267e.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.f57267e.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.f57267e.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.e.b(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f57267e.getResources().getString(R.string.go_to_download_emotion), new a())));
        d.a.m0.r.c layoutMode = this.f57267e.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.k(skinType == 1);
            layoutMode.j(inflate);
        }
        a2.f(this.f57267e.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    public final View c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f57267e.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        bVar.f57271a = (TbImageView) inflate.findViewById(R.id.cover);
        bVar.f57272b = (TextView) inflate.findViewById(R.id.title);
        bVar.f57273c = (TextView) inflate.findViewById(R.id.time);
        bVar.f57274d = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void d(int i2, b bVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i2);
        if (facePurchasePackageData == null) {
            return;
        }
        bVar.f57271a.setTag(facePurchasePackageData.cover_url);
        bVar.f57271a.R(facePurchasePackageData.cover_url, 10, this.f57267e.getResources().getDimensionPixelSize(R.dimen.ds94), this.f57267e.getResources().getDimensionPixelSize(R.dimen.ds94), false);
        bVar.f57274d.setText(facePurchasePackageData.price);
        bVar.f57272b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.f57273c.setText(d.a.c.e.p.k.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
            this.f57269g = true;
        } else {
            this.f57269g = false;
        }
        this.f57268f = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        FacePurchaseRecordsData facePurchaseRecordsData;
        ArrayList<FacePurchasePackageData> arrayList;
        if (!this.f57269g || (facePurchaseRecordsData = this.f57268f) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
            return 1;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<FacePurchasePackageData> arrayList;
        FacePurchaseRecordsData facePurchaseRecordsData = this.f57268f;
        if (facePurchaseRecordsData == null || (arrayList = facePurchaseRecordsData.buy_his) == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (!this.f57269g) {
            return b();
        }
        if (view == null) {
            view = c();
        }
        b bVar = (b) view.getTag();
        d.a.m0.r.c layoutMode = this.f57267e.getLayoutMode();
        layoutMode.k(skinType == 1);
        layoutMode.j(view);
        d(i2, bVar);
        return view;
    }
}
