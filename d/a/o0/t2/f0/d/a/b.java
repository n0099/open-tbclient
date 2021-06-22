package d.a.o0.t2.f0.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import d.a.c.e.p.l;
import d.a.o0.e3.z;
import d.a.o0.k1.o.l.j;
import d.a.o0.q.d.g.b;
import d.a.o0.t2.y;
import java.util.HashMap;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class b extends d.a.o0.t2.f0.d.a.a implements j {
    public final View.OnClickListener A;
    public RelativeLayout k;
    public TbImageView l;
    public TBSpecificationBtn m;
    public TextView n;
    public TextView o;
    public TextView p;
    public boolean q;
    public UrlDragImageView r;
    public DragImageView.h s;
    public RelativeLayout t;
    public RelativeLayout u;
    public ImageView v;
    public ApkDownloadView w;
    public VideoInfo x;
    public DownloadCacheKey y;
    public d.a.o0.q.d.h.d z;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                b.this.H();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* renamed from: d.a.o0.t2.f0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1680b implements DragImageView.h {
        public C1680b() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            if (b.this.s != null) {
                b.this.s.a();
            }
            b.this.n.setVisibility(8);
            b.this.o.setVisibility(8);
            b.this.p.setVisibility(8);
            b.this.t.setVisibility(8);
            b.this.v.setVisibility(8);
            b.this.m.setVisibility(8);
            b.this.w.setVisibility(8);
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            if (b.this.s != null) {
                b.this.s.b();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            if (b.this.s != null) {
                b.this.s.c();
            }
            b.this.n.setVisibility(0);
            b.this.o.setVisibility(0);
            b.this.p.setVisibility(0);
            b.this.t.setVisibility(0);
            b bVar = b.this;
            AdvertAppInfo advertAppInfo = bVar.f64904f;
            if (advertAppInfo != null) {
                bVar.v.setVisibility(advertAppInfo.J4() ? 0 : 8);
                if (b.this.f64904f.H4()) {
                    b.this.m.setVisibility(0);
                } else {
                    b.this.w.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public float f64910e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f64911f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f64912g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f64913h;

        public c(View.OnClickListener onClickListener) {
            this.f64913h = onClickListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    b.this.q = 10.0f < this.f64912g;
                    b bVar = b.this;
                    if (!bVar.q) {
                        this.f64913h.onClick(bVar.l);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.f64910e;
                    float y = motionEvent.getY() - this.f64911f;
                    this.f64912g = (float) (this.f64912g + Math.sqrt((x * x) + (y * y)));
                    this.f64910e = motionEvent.getX();
                    this.f64911f = motionEvent.getY();
                }
            } else {
                b.this.q = false;
                this.f64910e = motionEvent.getX();
                this.f64911f = motionEvent.getY();
                this.f64912g = 0.0f;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int w;
            String str;
            b bVar = b.this;
            if (bVar.f64904f == null || bVar.f64903e == null) {
                return;
            }
            if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (view.getId() == R.id.image_ad_button) {
                w = b.this.v(view);
                str = "button";
            } else if (view.getId() == R.id.bottom_container) {
                w = b.this.u();
                str = "title";
            } else {
                w = b.this.w();
                str = b.this.f64904f.G4() ? "image" : "video";
            }
            hashMap.put("da_area", str);
            b.this.j.a(w, hashMap);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.a.o0.q.d.g.b.a
        public boolean b(View view) {
            d.a.o0.k1.o.h.c.h(d.a.o0.k1.o.h.c.e(b.this.f64904f));
            b bVar = b.this;
            if (bVar.f64906h != null && y.o(bVar.f64903e.getScheme()) && y.q(b.this.f64904f.b4)) {
                b bVar2 = b.this;
                y.d(bVar2.f64906h, bVar2.f64903e.getScheme(), b.this.f64904f.getDownloadId(), b.this.f64904f.Q3);
                return true;
            } else if (b.this.f64906h == null || d.a.o0.a.h().r() || z.a((Activity) b.this.f64906h)) {
                return false;
            } else {
                l.L((Activity) b.this.f64906h, R.string.write_external_storage_permission_denied_fun_disable);
                return false;
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.q = false;
        this.z = null;
        this.A = new d();
    }

    public final int A() {
        return y.d(this.f64906h, this.f64903e.getScheme(), this.f64903e.getDownloadId(), this.f64904f.Q3);
    }

    public final void B() {
        String picUrl;
        VideoInfo videoInfo;
        if (this.f64904f.J4() && (videoInfo = this.x) != null) {
            picUrl = videoInfo.thumbnail_url;
        } else {
            picUrl = this.f64903e.getPicUrl();
        }
        this.l.setEvent(new a());
        this.l.R(picUrl, this.f64905g ? 30 : 31, PeerConnectionClient.HD_VIDEO_HEIGHT, PeerConnectionClient.HD_VIDEO_HEIGHT, false);
        UrlDragImageView urlDragImageView = this.r;
        if (urlDragImageView != null) {
            urlDragImageView.setIsCdn(this.f64905g);
            this.r.setUrl(picUrl, true);
        }
    }

    public final void C() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.a.o0.q.d.e.c().i(this.y, this.z);
    }

    public final void D(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void E(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.m;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setOnClickListener(onClickListener);
        }
        TbImageView tbImageView = this.l;
        if (tbImageView != null) {
            tbImageView.setOnClickListener(onClickListener);
        }
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        this.r.setOuterOnTouchListener(new c(onClickListener));
    }

    public DownloadData F(AdvertAppInfo advertAppInfo, int i2) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
        downloadData.setUrl(advertAppInfo.a4);
        downloadData.setName(advertAppInfo.W3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.J3, 0));
        return downloadData;
    }

    public final void G() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.a.o0.q.d.e.c().q(this.y, this.z);
    }

    public void H() {
        WindowManager windowManager = (WindowManager) this.f64906h.getSystemService("window");
        if (windowManager == null) {
            return;
        }
        int width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        double loadedHeight = this.l.getLoadedHeight() / this.l.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (width * loadedHeight);
            layoutParams.width = width;
        }
        this.l.setLayoutParams(layoutParams);
    }

    @Override // d.a.o0.k1.o.l.j
    public void a(DragImageView.h hVar) {
        this.s = hVar;
    }

    @Override // d.a.o0.k1.o.l.j
    public View b() {
        return this.k;
    }

    @Override // d.a.o0.t2.f0.d.a.a
    public void d() {
        if (this.f64907i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f64906h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.m.setConfig(bVar);
        this.m.setTextHorizontalCenter(true);
        this.n = (TextView) this.k.findViewById(R.id.ad_title);
        this.o = (TextView) this.k.findViewById(R.id.ad_brand);
        this.p = (TextView) this.k.findViewById(R.id.ad_tag);
        this.t = (RelativeLayout) this.k.findViewById(R.id.ad_info_container);
        this.u = (RelativeLayout) this.k.findViewById(R.id.bottom_container);
        ImageView imageView = (ImageView) this.k.findViewById(R.id.video_ad_play_icon);
        this.v = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.k.findViewById(R.id.image_download_button);
        this.w = apkDownloadView;
        TbPageContext tbPageContext = this.f64907i;
        if (tbPageContext != null) {
            apkDownloadView.j(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.w.i();
        s();
        E(this.A);
    }

    @Override // d.a.o0.t2.f0.d.a.a
    public void e(AdCard adCard) {
        super.e(adCard);
        if (this.f64904f == null) {
            return;
        }
        this.x = this.f64903e.videoInfo;
        B();
        y(this.f64904f, this.f64903e);
        if (!TextUtils.isEmpty(this.f64904f.W3)) {
            this.o.setText(this.f64904f.W3);
            this.p.setText(this.f64906h.getString(R.string.advert_label));
        }
        if (!TextUtils.isEmpty(adCard.threadTitle)) {
            this.n.setText(adCard.threadTitle);
        }
        this.v.setVisibility(this.f64904f.J4() ? 0 : 8);
        E(this.A);
    }

    @Override // d.a.o0.k1.o.l.j
    public void onDestroy() {
        G();
    }

    public void s() {
        this.l.setVisibility(4);
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.f64906h);
        this.r = urlDragImageView;
        urlDragImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.r.setIsCanDrag(true);
        this.r.setCanScale(false);
        this.r.setDragToExitListener(new C1680b());
        this.k.addView(this.r, 0);
    }

    public void t(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        G();
        this.z = null;
        AdDownloadData b2 = d.a.o0.q.d.e.c().b(downloadCacheKey);
        AdCard adCard = this.f64903e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f64903e.getAdvertAppInfo().T3;
            b2.setExtInfo(this.f64903e.getAdvertAppInfo().Q3);
            b2.setDownloadKey(this.f64903e.getDownloadKey());
            b2.setAppJson(App.toJson(this.f64903e.getAdvertAppInfo().V3).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f64903e.scheme);
        }
        d.a.o0.q.c.b.d.a aVar = new d.a.o0.q.c.b.d.a(this.w, b2);
        this.z = new d.a.o0.q.d.h.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        this.w.c(b2.getCurrentState());
        C();
    }

    public final int u() {
        return A();
    }

    public final int v(View view) {
        return A();
    }

    public final int w() {
        if (this.f64904f.G4()) {
            return A();
        }
        return x();
    }

    public final int x() {
        AdCard adCard;
        if (this.f64904f == null || (adCard = this.f64903e) == null || this.x == null) {
            return 0;
        }
        return y.g(this.f64906h, adCard.getScheme(), this.f64904f);
    }

    public void y(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null || adCard == null) {
            return;
        }
        this.f64904f = advertAppInfo;
        this.f64903e = adCard;
        if (advertAppInfo.H4()) {
            this.m.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setInitText(adCard.getButtonText());
        this.w.setOnClickInterceptListener(new e());
        DownloadData F = F(this.f64904f, d.a.c.e.m.b.d(this.f64904f.P3, -1));
        D(F);
        this.w.setData(F);
        this.w.setVisibility(0);
        this.m.setVisibility(8);
        z(adCard, advertAppInfo);
    }

    public final void z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        if (advertAppInfo == null || !advertAppInfo.F4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.o0.q.d.e.c().g(downloadId);
        } else {
            h2 = d.a.o0.q.d.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.a4, advertAppInfo.b4);
            d.a.o0.q.d.e.c().i(h2, null);
        }
        t(h2);
    }
}
