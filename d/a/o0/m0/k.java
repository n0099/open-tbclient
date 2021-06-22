package d.a.o0.m0;

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
    public FacePurchaseRecordsActivity f61081e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsData f61082f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61083g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(k.this.f61081e.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
            k.this.f61081e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61085a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61086b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61087c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61088d;

        public b(k kVar) {
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.f61081e = facePurchaseRecordsActivity;
    }

    public final View b() {
        View inflate = LayoutInflater.from(this.f61081e.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.f61081e.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.f61081e.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.e.b(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61081e.getResources().getString(R.string.go_to_download_emotion), new a())));
        d.a.n0.r.c layoutMode = this.f61081e.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.k(skinType == 1);
            layoutMode.j(inflate);
        }
        a2.f(this.f61081e.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    public final View c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f61081e.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        bVar.f61085a = (TbImageView) inflate.findViewById(R.id.cover);
        bVar.f61086b = (TextView) inflate.findViewById(R.id.title);
        bVar.f61087c = (TextView) inflate.findViewById(R.id.time);
        bVar.f61088d = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void d(int i2, b bVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i2);
        if (facePurchasePackageData == null) {
            return;
        }
        bVar.f61085a.setTag(facePurchasePackageData.cover_url);
        bVar.f61085a.R(facePurchasePackageData.cover_url, 10, this.f61081e.getResources().getDimensionPixelSize(R.dimen.ds94), this.f61081e.getResources().getDimensionPixelSize(R.dimen.ds94), false);
        bVar.f61088d.setText(facePurchasePackageData.price);
        bVar.f61086b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.f61087c.setText(d.a.c.e.p.k.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
            this.f61083g = true;
        } else {
            this.f61083g = false;
        }
        this.f61082f = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        FacePurchaseRecordsData facePurchaseRecordsData;
        ArrayList<FacePurchasePackageData> arrayList;
        if (!this.f61083g || (facePurchaseRecordsData = this.f61082f) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
            return 1;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<FacePurchasePackageData> arrayList;
        FacePurchaseRecordsData facePurchaseRecordsData = this.f61082f;
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
        if (!this.f61083g) {
            return b();
        }
        if (view == null) {
            view = c();
        }
        b bVar = (b) view.getTag();
        d.a.n0.r.c layoutMode = this.f61081e.getLayoutMode();
        layoutMode.k(skinType == 1);
        layoutMode.j(view);
        d(i2, bVar);
        return view;
    }
}
