package d.a.k0.s2.f0.d.a;

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
import d.a.k0.d3.z;
import d.a.k0.j1.o.l.j;
import d.a.k0.o.d.f.b;
import d.a.k0.s2.y;
import java.util.HashMap;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class b extends d.a.k0.s2.f0.d.a.a implements j {
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
    public d.a.k0.o.d.g.d z;

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

    /* renamed from: d.a.k0.s2.f0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1614b implements DragImageView.h {
        public C1614b() {
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
            AdvertAppInfo advertAppInfo = bVar.f60985f;
            if (advertAppInfo != null) {
                bVar.v.setVisibility(advertAppInfo.H4() ? 0 : 8);
                if (b.this.f60985f.F4()) {
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
        public float f60991e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f60992f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f60993g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f60994h;

        public c(View.OnClickListener onClickListener) {
            this.f60994h = onClickListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    b.this.q = 10.0f < this.f60993g;
                    b bVar = b.this;
                    if (!bVar.q) {
                        this.f60994h.onClick(bVar.l);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.f60991e;
                    float y = motionEvent.getY() - this.f60992f;
                    this.f60993g = (float) (this.f60993g + Math.sqrt((x * x) + (y * y)));
                    this.f60991e = motionEvent.getX();
                    this.f60992f = motionEvent.getY();
                }
            } else {
                b.this.q = false;
                this.f60991e = motionEvent.getX();
                this.f60992f = motionEvent.getY();
                this.f60993g = 0.0f;
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
            if (bVar.f60985f == null || bVar.f60984e == null) {
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
                str = b.this.f60985f.E4() ? "image" : "video";
            }
            hashMap.put("da_area", str);
            b.this.j.a(w, hashMap);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.a.k0.o.d.f.b.a
        public boolean b(View view) {
            d.a.k0.j1.o.h.c.h(d.a.k0.j1.o.h.c.e(b.this.f60985f));
            b bVar = b.this;
            if (bVar.f60987h != null && y.o(bVar.f60984e.getScheme()) && y.q(b.this.f60985f.X3)) {
                b bVar2 = b.this;
                y.d(bVar2.f60987h, bVar2.f60984e.getScheme(), b.this.f60985f.getDownloadId(), b.this.f60985f.M3);
                return true;
            } else if (b.this.f60987h == null || d.a.k0.a.e().o() || z.a((Activity) b.this.f60987h)) {
                return false;
            } else {
                l.L((Activity) b.this.f60987h, R.string.write_external_storage_permission_denied_fun_disable);
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
        return y.d(this.f60987h, this.f60984e.getScheme(), this.f60984e.getDownloadId(), this.f60985f.M3);
    }

    public final void B() {
        String picUrl;
        VideoInfo videoInfo;
        if (this.f60985f.H4() && (videoInfo = this.x) != null) {
            picUrl = videoInfo.thumbnail_url;
        } else {
            picUrl = this.f60984e.getPicUrl();
        }
        this.l.setEvent(new a());
        this.l.R(picUrl, this.f60986g ? 30 : 31, PeerConnectionClient.HD_VIDEO_HEIGHT, PeerConnectionClient.HD_VIDEO_HEIGHT, false);
        UrlDragImageView urlDragImageView = this.r;
        if (urlDragImageView != null) {
            urlDragImageView.setIsCdn(this.f60986g);
            this.r.setUrl(picUrl, true);
        }
    }

    public final void C() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.a.k0.o.d.d.c().i(this.y, this.z);
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
        downloadData.setUrl(advertAppInfo.W3);
        downloadData.setName(advertAppInfo.S3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.F3, 0));
        return downloadData;
    }

    public final void G() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.a.k0.o.d.d.c().q(this.y, this.z);
    }

    public void H() {
        WindowManager windowManager = (WindowManager) this.f60987h.getSystemService("window");
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

    @Override // d.a.k0.j1.o.l.j
    public void a(DragImageView.h hVar) {
        this.s = hVar;
    }

    @Override // d.a.k0.j1.o.l.j
    public View b() {
        return this.k;
    }

    @Override // d.a.k0.s2.f0.d.a.a
    public void c() {
        if (this.f60988i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f60987h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.m.setConfig(bVar);
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
        TbPageContext tbPageContext = this.f60988i;
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

    @Override // d.a.k0.s2.f0.d.a.a
    public void d(AdCard adCard) {
        super.d(adCard);
        if (this.f60985f == null) {
            return;
        }
        this.x = this.f60984e.videoInfo;
        B();
        y(this.f60985f, this.f60984e);
        if (!TextUtils.isEmpty(this.f60985f.S3)) {
            this.o.setText(this.f60985f.S3);
            this.p.setText(this.f60987h.getString(R.string.advert_label));
        }
        if (!TextUtils.isEmpty(adCard.threadTitle)) {
            this.n.setText(adCard.threadTitle);
        }
        this.v.setVisibility(this.f60985f.H4() ? 0 : 8);
        E(this.A);
    }

    @Override // d.a.k0.j1.o.l.j
    public void onDestroy() {
        G();
    }

    public void s() {
        this.l.setVisibility(4);
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.f60987h);
        this.r = urlDragImageView;
        urlDragImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.r.setIsCanDrag(true);
        this.r.setCanScale(false);
        this.r.setDragToExitListener(new C1614b());
        this.k.addView(this.r, 0);
    }

    public void t(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        G();
        this.z = null;
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        AdCard adCard = this.f60984e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f60984e.getAdvertAppInfo().P3;
            b2.setExtInfo(this.f60984e.getAdvertAppInfo().M3);
            b2.setDownloadKey(this.f60984e.getDownloadKey());
            b2.setAppJson(App.toJson(this.f60984e.getAdvertAppInfo().R3).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f60984e.scheme);
        }
        d.a.k0.o.c.b.d.a aVar = new d.a.k0.o.c.b.d.a(this.w, b2);
        this.z = new d.a.k0.o.d.g.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.d(b2);
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
        if (this.f60985f.E4()) {
            return A();
        }
        return x();
    }

    public final int x() {
        AdCard adCard;
        if (this.f60985f == null || (adCard = this.f60984e) == null || this.x == null) {
            return 0;
        }
        return y.g(this.f60987h, adCard.getScheme(), this.f60985f);
    }

    public void y(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null || adCard == null) {
            return;
        }
        this.f60985f = advertAppInfo;
        this.f60984e = adCard;
        if (advertAppInfo.F4()) {
            this.m.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setOnClickInterceptListener(new e());
        DownloadData F = F(this.f60985f, d.a.c.e.m.b.d(this.f60985f.L3, -1));
        D(F);
        this.w.setData(F);
        this.w.setVisibility(0);
        this.m.setVisibility(8);
        z(adCard, advertAppInfo);
    }

    public final void z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        if (advertAppInfo == null || !advertAppInfo.D4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.k0.o.d.d.c().g(downloadId);
        } else {
            h2 = d.a.k0.o.d.d.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.W3, advertAppInfo.X3);
            d.a.k0.o.d.d.c().i(h2, null);
        }
        t(h2);
    }
}
