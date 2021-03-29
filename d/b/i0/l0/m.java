package d.b.i0.l0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyData;
import com.baidu.tieba.faceshop.FaceBuyModel;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FacePackageDownloadData;
import com.baidu.tieba.faceshop.FacePackageDownloadModel;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends BaseAdapter {
    public static int o;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f56558e;

    /* renamed from: f  reason: collision with root package name */
    public final FaceShopActivity f56559f;

    /* renamed from: g  reason: collision with root package name */
    public final int f56560g;

    /* renamed from: h  reason: collision with root package name */
    public final int f56561h;
    public final int i;
    public final int j;
    public FacePackageDownloadModel l;
    public FaceBuyModel m;
    public int k = -1;
    public View.OnClickListener n = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                e eVar = (e) view.getTag();
                if (eVar == null) {
                    return;
                }
                int i = eVar.f56576a;
                if (!TbadkCoreApplication.isLogin()) {
                    m.this.k = eVar.f56576a;
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(m.this.f56559f.getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                int i2 = eVar.f56577b;
                if (i2 == 2) {
                    m.this.i(i);
                } else if (i2 == 3) {
                    m.this.j(i);
                } else if (i2 != 4) {
                } else {
                    m.this.g(i);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.b.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f56563a;

        public b(FacePackageData facePackageData) {
            this.f56563a = facePackageData;
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), R.string.neterror);
                return;
            }
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                this.f56563a.pack_url = facePackageDownloadData.pack_url;
                f f2 = f.f();
                String valueOf = String.valueOf(this.f56563a.pid);
                FacePackageData facePackageData = this.f56563a;
                f2.j(valueOf, facePackageData.pname, facePackageData.pack_url);
            } else if (facePackageDownloadData.usermsg != null) {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), facePackageDownloadData.usermsg);
            } else {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.b.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f56565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56566b;

        public c(FacePackageData facePackageData, int i) {
            this.f56565a = facePackageData;
            this.f56566b = i;
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            m.this.f56559f.hideProgressBar();
            if (obj == null || !(obj instanceof FaceBuyData)) {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), R.string.neterror);
                return;
            }
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                String str = buyInfo.buy_url;
                String str2 = buyInfo.return_url;
                if (buyInfo.buy_status == 2) {
                    UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), R.string.has_buy_book);
                    FacePackageData facePackageData = this.f56565a;
                    facePackageData.buy_status = 1;
                    facePackageData.can_download = 1;
                    m.this.notifyDataSetChanged();
                    return;
                }
                this.f56565a.orderId = buyInfo.order_id;
                IntentConfig intentConfig = new IntentConfig(m.this.f56559f);
                intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                intentConfig.getIntent().putExtra("tag_hook_url", str2);
                intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, m.this.f56559f.getString(R.string.buy_book));
                intentConfig.getIntent().putExtra("tag_position", this.f56566b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
            } else if (faceBuyData.usermsg != null) {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), faceBuyData.usermsg);
            } else {
                UtilHelper.showToast(m.this.f56559f.getPageContext().getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f56568a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56569b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f56570c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56571d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f56572e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f56573f;

        /* renamed from: g  reason: collision with root package name */
        public FrameLayout f56574g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f56575h;
        public TbImageView i;
        public TbImageView j;
        public String k;
        public int l;
        public int m;

        public d(m mVar) {
        }

        public /* synthetic */ d(m mVar, a aVar) {
            this(mVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public int f56576a;

        /* renamed from: b  reason: collision with root package name */
        public int f56577b;

        public e(m mVar) {
        }

        public /* synthetic */ e(m mVar, a aVar) {
            this(mVar);
        }
    }

    public m(FaceShopActivity faceShopActivity) {
        this.f56559f = faceShopActivity;
        int k = d.b.b.e.p.l.k(faceShopActivity.getPageContext().getPageActivity());
        o = k;
        int dimensionPixelSize = k - (faceShopActivity.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.f56560g = dimensionPixelSize;
        this.f56561h = (int) (dimensionPixelSize * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.f56559f.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.i = resBitmap.getWidth();
        } else {
            this.i = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.f56559f.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.j = resBitmap2.getWidth();
        } else {
            this.j = 0;
        }
        this.l = null;
        this.m = null;
    }

    public View c(int i, ViewGroup viewGroup) {
        if (i == 1) {
            d dVar = new d(this, null);
            View inflate = LayoutInflater.from(this.f56559f.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            dVar.f56569b = (TextView) inflate.findViewById(R.id.title);
            dVar.f56568a = (TbImageView) inflate.findViewById(R.id.image);
            dVar.f56570c = (FrameLayout) inflate.findViewById(R.id.btn);
            dVar.f56571d = (TextView) inflate.findViewById(R.id.btn_text);
            dVar.f56572e = (TextView) inflate.findViewById(R.id.downloaded);
            dVar.f56574g = (FrameLayout) inflate.findViewById(R.id.downloading);
            dVar.f56573f = (ImageView) inflate.findViewById(R.id.downloading_up);
            dVar.f56575h = (TextView) inflate.findViewById(R.id.intro);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.icon);
            dVar.i = tbImageView;
            tbImageView.setDefaultResource(0);
            dVar.i.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f56560g, this.f56561h);
            layoutParams.setMargins(0, 0, 0, this.f56559f.getResources().getDimensionPixelSize(R.dimen.ds8));
            dVar.f56568a.setLayoutParams(layoutParams);
            dVar.f56571d.setClickable(false);
            dVar.f56570c.setClickable(true);
            dVar.f56570c.setOnClickListener(this.n);
            dVar.j = (TbImageView) inflate.findViewById(R.id.title_tag);
            inflate.setTag(dVar);
            return inflate;
        }
        return null;
    }

    public final void d(int i, d dVar) {
        if (this.f56558e == null || dVar == null) {
            return;
        }
        try {
            FacePackageData facePackageData = (FacePackageData) getItem(i);
            if (facePackageData == null) {
                return;
            }
            dVar.m = i;
            dVar.f56569b.setText(facePackageData.pname);
            dVar.f56575h.setText(facePackageData.pdesc);
            dVar.f56568a.setTag(facePackageData.banner_url);
            dVar.f56568a.T(facePackageData.banner_url, 10, this.f56560g, this.f56561h, false);
            if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                dVar.i.setTag(facePackageData.new_icon);
                dVar.i.W(facePackageData.new_icon, 21, false);
                dVar.i.setVisibility(0);
            } else {
                dVar.i.setVisibility(8);
            }
            dVar.k = facePackageData.price;
            r(facePackageData, dVar);
            e eVar = new e(this, null);
            eVar.f56577b = dVar.l;
            eVar.f56576a = i;
            dVar.f56570c.setTag(eVar);
            if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                dVar.j.setVisibility(0);
                dVar.j.setTag(facePackageData.tag_url);
                dVar.j.W(facePackageData.tag_url, 21, false);
                return;
            }
            dVar.j.setVisibility(8);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public int e() {
        return this.k;
    }

    public final void f(d dVar) {
        if (dVar == null) {
            return;
        }
        dVar.f56571d.setVisibility(8);
        dVar.f56570c.setVisibility(8);
        dVar.f56572e.setVisibility(8);
        dVar.f56574g.setVisibility(8);
    }

    public void g(int i) {
        TiebaStatic.log("emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.f56558e == null) {
            return;
        }
        this.f56559f.showProgressBar();
        String valueOf = String.valueOf(facePackageData.pid);
        FaceBuyModel faceBuyModel = new FaceBuyModel(this.f56559f.getPageContext().getContext());
        this.m = faceBuyModel;
        faceBuyModel.setLoadDataCallBack(new c(facePackageData, i));
        this.m.z(valueOf);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f56558e;
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f56558e;
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f56558e;
        return (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.get(i) == null) ? 2 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view == null) {
            view = c(itemViewType, viewGroup);
        }
        d dVar = (d) view.getTag();
        d.b.h0.r.c layoutMode = this.f56559f.getLayoutMode();
        layoutMode.k(skinType == 1);
        layoutMode.j(view);
        d(i, dVar);
        k(dVar);
        l(dVar, skinType);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void h() {
        FaceBuyModel faceBuyModel = this.m;
        if (faceBuyModel != null) {
            faceBuyModel.cancelLoadData();
        }
        FacePackageDownloadModel facePackageDownloadModel = this.l;
        if (facePackageDownloadModel != null) {
            facePackageDownloadModel.cancelLoadData();
        }
    }

    public void i(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(this.f56559f.getPageContext().getContext());
            this.l = facePackageDownloadModel;
            facePackageDownloadModel.z(String.valueOf(facePackageData.pid));
            this.l.setLoadDataCallBack(new b(facePackageData));
        }
    }

    public void j(int i) {
        TiebaStatic.log("emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData == null) {
            return;
        }
        facePackageData.buy_status = 1;
        notifyDataSetChanged();
    }

    public final void k(d dVar) {
        if (dVar == null) {
            return;
        }
        f(dVar);
        int i = dVar.l;
        if (i == 1) {
            dVar.f56572e.setVisibility(0);
        } else if (i == 2 || i == 3 || i == 4) {
            dVar.f56570c.setVisibility(0);
            dVar.f56571d.setVisibility(0);
        } else if (i != 5) {
        } else {
            dVar.f56574g.setVisibility(0);
        }
    }

    public final void l(d dVar, int i) {
        if (dVar == null) {
            return;
        }
        int i2 = dVar.l;
        if (i2 == 5) {
            p(dVar, i);
        } else if (i2 == 2) {
            o(dVar, i);
        } else if (i2 == 3) {
            q(dVar, i);
        } else if (i2 != 4) {
        } else {
            m(dVar, i);
        }
    }

    public final void m(d dVar, int i) {
        dVar.f56571d.setText(dVar.k);
        dVar.f56571d.setBackgroundResource(0);
        SkinManager.setBackgroundResource(dVar.f56570c, R.drawable.faceshop_list_btn_selector);
    }

    public void n(FaceShopData faceShopData) {
        this.f56558e = faceShopData;
        notifyDataSetChanged();
    }

    public final void o(d dVar, int i) {
        dVar.f56571d.setText((CharSequence) null);
        SkinManager.setBackgroundResource(dVar.f56570c, R.drawable.btn_all_blue);
        SkinManager.setBackgroundResource(dVar.f56571d, R.drawable.icon_content_download);
    }

    public final void p(d dVar, int i) {
        f(dVar);
        dVar.f56574g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(dVar.m);
        if (facePackageData == null) {
            return;
        }
        int i2 = (int) (this.i * (((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)));
        int i3 = this.j;
        if (i2 < i3) {
            i2 = i3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dVar.f56573f.getLayoutParams();
        layoutParams.width = i2;
        dVar.f56573f.setLayoutParams(layoutParams);
    }

    public final void q(d dVar, int i) {
        dVar.f56571d.setText(dVar.k);
        dVar.f56571d.setBackgroundResource(0);
        SkinManager.setBackgroundResource(dVar.f56570c, R.drawable.btn_all_white);
    }

    public final void r(FacePackageData facePackageData, d dVar) {
        if (facePackageData == null || dVar == null) {
            return;
        }
        int i = facePackageData.buy_status;
        int i2 = facePackageData.can_download;
        int i3 = facePackageData.downloaded;
        if (facePackageData.downloading == 1) {
            dVar.l = 5;
        } else if (i3 == 1) {
            dVar.l = 1;
        } else if (i == 2) {
            dVar.l = 6;
        } else if (i == 1) {
            if (i2 == 1) {
                dVar.l = 2;
            }
        } else if (i == 0) {
            if (i2 == 1) {
                dVar.l = 3;
            } else {
                dVar.l = 4;
            }
        }
    }
}
