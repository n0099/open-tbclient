package d.a.n0.m0;

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
    public FaceShopData f57283e;

    /* renamed from: f  reason: collision with root package name */
    public final FaceShopActivity f57284f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57285g;

    /* renamed from: h  reason: collision with root package name */
    public final int f57286h;

    /* renamed from: i  reason: collision with root package name */
    public final int f57287i;
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
                int i2 = eVar.f57303a;
                if (!TbadkCoreApplication.isLogin()) {
                    m.this.k = eVar.f57303a;
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(m.this.f57284f.getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                int i3 = eVar.f57304b;
                if (i3 == 2) {
                    m.this.i(i2);
                } else if (i3 == 3) {
                    m.this.j(i2);
                } else if (i3 != 4) {
                } else {
                    m.this.g(i2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f57289a;

        public b(FacePackageData facePackageData) {
            this.f57289a = facePackageData;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), R.string.neterror);
                return;
            }
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                this.f57289a.pack_url = facePackageDownloadData.pack_url;
                f f2 = f.f();
                String valueOf = String.valueOf(this.f57289a.pid);
                FacePackageData facePackageData = this.f57289a;
                f2.j(valueOf, facePackageData.pname, facePackageData.pack_url);
            } else if (facePackageDownloadData.usermsg != null) {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), facePackageDownloadData.usermsg);
            } else {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageData f57291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f57292b;

        public c(FacePackageData facePackageData, int i2) {
            this.f57291a = facePackageData;
            this.f57292b = i2;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            m.this.f57284f.hideProgressBar();
            if (obj == null || !(obj instanceof FaceBuyData)) {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), R.string.neterror);
                return;
            }
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                String str = buyInfo.buy_url;
                String str2 = buyInfo.return_url;
                if (buyInfo.buy_status == 2) {
                    UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), R.string.has_buy_book);
                    FacePackageData facePackageData = this.f57291a;
                    facePackageData.buy_status = 1;
                    facePackageData.can_download = 1;
                    m.this.notifyDataSetChanged();
                    return;
                }
                this.f57291a.orderId = buyInfo.order_id;
                IntentConfig intentConfig = new IntentConfig(m.this.f57284f);
                intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                intentConfig.getIntent().putExtra("tag_hook_url", str2);
                intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, m.this.f57284f.getString(R.string.buy_book));
                intentConfig.getIntent().putExtra("tag_position", this.f57292b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
            } else if (faceBuyData.usermsg != null) {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), faceBuyData.usermsg);
            } else {
                UtilHelper.showToast(m.this.f57284f.getPageContext().getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f57294a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57295b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f57296c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57297d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57298e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f57299f;

        /* renamed from: g  reason: collision with root package name */
        public FrameLayout f57300g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f57301h;

        /* renamed from: i  reason: collision with root package name */
        public TbImageView f57302i;
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
        public int f57303a;

        /* renamed from: b  reason: collision with root package name */
        public int f57304b;

        public e(m mVar) {
        }

        public /* synthetic */ e(m mVar, a aVar) {
            this(mVar);
        }
    }

    public m(FaceShopActivity faceShopActivity) {
        this.f57284f = faceShopActivity;
        int k = d.a.c.e.p.l.k(faceShopActivity.getPageContext().getPageActivity());
        o = k;
        int dimensionPixelSize = k - (faceShopActivity.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.f57285g = dimensionPixelSize;
        this.f57286h = (int) (dimensionPixelSize * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.f57284f.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.f57287i = resBitmap.getWidth();
        } else {
            this.f57287i = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.f57284f.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.j = resBitmap2.getWidth();
        } else {
            this.j = 0;
        }
        this.l = null;
        this.m = null;
    }

    public View c(int i2, ViewGroup viewGroup) {
        if (i2 == 1) {
            d dVar = new d(this, null);
            View inflate = LayoutInflater.from(this.f57284f.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            dVar.f57295b = (TextView) inflate.findViewById(R.id.title);
            dVar.f57294a = (TbImageView) inflate.findViewById(R.id.image);
            dVar.f57296c = (FrameLayout) inflate.findViewById(R.id.btn);
            dVar.f57297d = (TextView) inflate.findViewById(R.id.btn_text);
            dVar.f57298e = (TextView) inflate.findViewById(R.id.downloaded);
            dVar.f57300g = (FrameLayout) inflate.findViewById(R.id.downloading);
            dVar.f57299f = (ImageView) inflate.findViewById(R.id.downloading_up);
            dVar.f57301h = (TextView) inflate.findViewById(R.id.intro);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.icon);
            dVar.f57302i = tbImageView;
            tbImageView.setDefaultResource(0);
            dVar.f57302i.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f57285g, this.f57286h);
            layoutParams.setMargins(0, 0, 0, this.f57284f.getResources().getDimensionPixelSize(R.dimen.ds8));
            dVar.f57294a.setLayoutParams(layoutParams);
            dVar.f57297d.setClickable(false);
            dVar.f57296c.setClickable(true);
            dVar.f57296c.setOnClickListener(this.n);
            dVar.j = (TbImageView) inflate.findViewById(R.id.title_tag);
            inflate.setTag(dVar);
            return inflate;
        }
        return null;
    }

    public final void d(int i2, d dVar) {
        if (this.f57283e == null || dVar == null) {
            return;
        }
        try {
            FacePackageData facePackageData = (FacePackageData) getItem(i2);
            if (facePackageData == null) {
                return;
            }
            dVar.m = i2;
            dVar.f57295b.setText(facePackageData.pname);
            dVar.f57301h.setText(facePackageData.pdesc);
            dVar.f57294a.setTag(facePackageData.banner_url);
            dVar.f57294a.R(facePackageData.banner_url, 10, this.f57285g, this.f57286h, false);
            if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                dVar.f57302i.setTag(facePackageData.new_icon);
                dVar.f57302i.V(facePackageData.new_icon, 21, false);
                dVar.f57302i.setVisibility(0);
            } else {
                dVar.f57302i.setVisibility(8);
            }
            dVar.k = facePackageData.price;
            r(facePackageData, dVar);
            e eVar = new e(this, null);
            eVar.f57304b = dVar.l;
            eVar.f57303a = i2;
            dVar.f57296c.setTag(eVar);
            if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                dVar.j.setVisibility(0);
                dVar.j.setTag(facePackageData.tag_url);
                dVar.j.V(facePackageData.tag_url, 21, false);
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
        dVar.f57297d.setVisibility(8);
        dVar.f57296c.setVisibility(8);
        dVar.f57298e.setVisibility(8);
        dVar.f57300g.setVisibility(8);
    }

    public void g(int i2) {
        TiebaStatic.log("emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i2);
        if (this.f57283e == null) {
            return;
        }
        this.f57284f.showProgressBar();
        String valueOf = String.valueOf(facePackageData.pid);
        FaceBuyModel faceBuyModel = new FaceBuyModel(this.f57284f.getPageContext().getContext());
        this.m = faceBuyModel;
        faceBuyModel.setLoadDataCallBack(new c(facePackageData, i2));
        this.m.z(valueOf);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f57283e;
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f57283e;
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        ArrayList<FacePackageData> arrayList;
        FaceShopData faceShopData = this.f57283e;
        return (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.get(i2) == null) ? 2 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view == null) {
            view = c(itemViewType, viewGroup);
        }
        d dVar = (d) view.getTag();
        d.a.m0.r.c layoutMode = this.f57284f.getLayoutMode();
        layoutMode.k(skinType == 1);
        layoutMode.j(view);
        d(i2, dVar);
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

    public void i(int i2) {
        FacePackageData facePackageData = (FacePackageData) getItem(i2);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(this.f57284f.getPageContext().getContext());
            this.l = facePackageDownloadModel;
            facePackageDownloadModel.z(String.valueOf(facePackageData.pid));
            this.l.setLoadDataCallBack(new b(facePackageData));
        }
    }

    public void j(int i2) {
        TiebaStatic.log("emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i2);
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
        int i2 = dVar.l;
        if (i2 == 1) {
            dVar.f57298e.setVisibility(0);
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            dVar.f57296c.setVisibility(0);
            dVar.f57297d.setVisibility(0);
        } else if (i2 != 5) {
        } else {
            dVar.f57300g.setVisibility(0);
        }
    }

    public final void l(d dVar, int i2) {
        if (dVar == null) {
            return;
        }
        int i3 = dVar.l;
        if (i3 == 5) {
            p(dVar, i2);
        } else if (i3 == 2) {
            o(dVar, i2);
        } else if (i3 == 3) {
            q(dVar, i2);
        } else if (i3 != 4) {
        } else {
            m(dVar, i2);
        }
    }

    public final void m(d dVar, int i2) {
        dVar.f57297d.setText(dVar.k);
        dVar.f57297d.setBackgroundResource(0);
        SkinManager.setBackgroundResource(dVar.f57296c, R.drawable.faceshop_list_btn_selector);
    }

    public void n(FaceShopData faceShopData) {
        this.f57283e = faceShopData;
        notifyDataSetChanged();
    }

    public final void o(d dVar, int i2) {
        dVar.f57297d.setText((CharSequence) null);
        SkinManager.setBackgroundResource(dVar.f57296c, R.drawable.btn_all_blue);
        SkinManager.setBackgroundResource(dVar.f57297d, R.drawable.icon_content_download);
    }

    public final void p(d dVar, int i2) {
        f(dVar);
        dVar.f57300g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(dVar.m);
        if (facePackageData == null) {
            return;
        }
        int i3 = (int) (this.f57287i * (((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)));
        int i4 = this.j;
        if (i3 < i4) {
            i3 = i4;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dVar.f57299f.getLayoutParams();
        layoutParams.width = i3;
        dVar.f57299f.setLayoutParams(layoutParams);
    }

    public final void q(d dVar, int i2) {
        dVar.f57297d.setText(dVar.k);
        dVar.f57297d.setBackgroundResource(0);
        SkinManager.setBackgroundResource(dVar.f57296c, R.drawable.btn_all_white);
    }

    public final void r(FacePackageData facePackageData, d dVar) {
        if (facePackageData == null || dVar == null) {
            return;
        }
        int i2 = facePackageData.buy_status;
        int i3 = facePackageData.can_download;
        int i4 = facePackageData.downloaded;
        if (facePackageData.downloading == 1) {
            dVar.l = 5;
        } else if (i4 == 1) {
            dVar.l = 1;
        } else if (i2 == 2) {
            dVar.l = 6;
        } else if (i2 == 1) {
            if (i3 == 1) {
                dVar.l = 2;
            }
        } else if (i2 == 0) {
            if (i3 == 1) {
                dVar.l = 3;
            } else {
                dVar.l = 4;
            }
        }
    }
}
