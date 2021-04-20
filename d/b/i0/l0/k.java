package d.b.i0.l0;

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
    public FacePurchaseRecordsActivity f57948e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsData f57949f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57950g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(k.this.f57948e.getPageContext().getContext(), CommonStatisticKey.FACESHOP_FROM_MORE)));
            k.this.f57948e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f57952a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57953b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57954c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57955d;

        public b(k kVar) {
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    public k(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
        this.f57948e = facePurchaseRecordsActivity;
    }

    public final View b() {
        View inflate = LayoutInflater.from(this.f57948e.getPageContext().getContext()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.f57948e.getPageContext().getContext(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.EMOTION, (int) this.f57948e.getResources().getDimension(R.dimen.ds160)), NoDataViewFactory.e.b(R.string.buy_no_emotion, R.string.go_to_emotion_store), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f57948e.getResources().getString(R.string.go_to_download_emotion), new a())));
        d.b.h0.r.c layoutMode = this.f57948e.getLayoutMode();
        int skinType = TbadkApplication.getInst().getSkinType();
        if (layoutMode != null) {
            layoutMode.k(skinType == 1);
            layoutMode.j(inflate);
        }
        a2.f(this.f57948e.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    public final View c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f57948e.getPageContext().getContext()).inflate(R.layout.face_purchase_record_item, (ViewGroup) null);
        bVar.f57952a = (TbImageView) inflate.findViewById(R.id.cover);
        bVar.f57953b = (TextView) inflate.findViewById(R.id.title);
        bVar.f57954c = (TextView) inflate.findViewById(R.id.time);
        bVar.f57955d = (TextView) inflate.findViewById(R.id.price);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void d(int i, b bVar) {
        FacePurchasePackageData facePurchasePackageData = (FacePurchasePackageData) getItem(i);
        if (facePurchasePackageData == null) {
            return;
        }
        bVar.f57952a.setTag(facePurchasePackageData.cover_url);
        bVar.f57952a.T(facePurchasePackageData.cover_url, 10, this.f57948e.getResources().getDimensionPixelSize(R.dimen.ds94), this.f57948e.getResources().getDimensionPixelSize(R.dimen.ds94), false);
        bVar.f57955d.setText(facePurchasePackageData.price);
        bVar.f57953b.setText(facePurchasePackageData.pname);
        Date date = new Date();
        date.setTime(facePurchasePackageData.puy_time * 1000);
        bVar.f57954c.setText(d.b.c.e.p.k.getDateStringDay(date));
    }

    public void e(FacePurchaseRecordsData facePurchaseRecordsData) {
        ArrayList<FacePurchasePackageData> arrayList;
        if (facePurchaseRecordsData != null && (arrayList = facePurchaseRecordsData.buy_his) != null && arrayList.size() != 0) {
            this.f57950g = true;
        } else {
            this.f57950g = false;
        }
        this.f57949f = facePurchaseRecordsData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        FacePurchaseRecordsData facePurchaseRecordsData;
        ArrayList<FacePurchasePackageData> arrayList;
        if (!this.f57950g || (facePurchaseRecordsData = this.f57949f) == null || (arrayList = facePurchaseRecordsData.buy_his) == null) {
            return 1;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<FacePurchasePackageData> arrayList;
        FacePurchaseRecordsData facePurchaseRecordsData = this.f57949f;
        if (facePurchaseRecordsData == null || (arrayList = facePurchaseRecordsData.buy_his) == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int skinType = TbadkApplication.getInst().getSkinType();
        if (!this.f57950g) {
            return b();
        }
        if (view == null) {
            view = c();
        }
        b bVar = (b) view.getTag();
        d.b.h0.r.c layoutMode = this.f57948e.getLayoutMode();
        layoutMode.k(skinType == 1);
        layoutMode.j(view);
        d(i, bVar);
        return view;
    }
}
