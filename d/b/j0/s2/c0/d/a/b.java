package d.b.j0.s2.c0.d.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import d.b.c.e.p.l;
import d.b.j0.d3.z;
import d.b.j0.j1.o.l.j;
import d.b.j0.o.d.f.b;
import d.b.j0.s2.w;
import java.util.HashMap;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class b extends d.b.j0.s2.c0.d.a.a implements j {
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
    public d.b.j0.o.d.g.d z;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                b.this.I();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* renamed from: d.b.j0.s2.c0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1602b implements DragImageView.h {
        public C1602b() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            if (b.this.s != null) {
                b.this.s.a();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            if (b.this.s != null) {
                b.this.s.b();
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
        public void c() {
            if (b.this.s != null) {
                b.this.s.c();
            }
            b.this.n.setVisibility(0);
            b.this.o.setVisibility(0);
            b.this.p.setVisibility(0);
            b.this.t.setVisibility(0);
            b bVar = b.this;
            AdvertAppInfo advertAppInfo = bVar.f62026f;
            if (advertAppInfo != null) {
                bVar.v.setVisibility(advertAppInfo.F4() ? 0 : 8);
                if (b.this.f62026f.D4()) {
                    b.this.m.setVisibility(0);
                } else {
                    b.this.w.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public float f62031e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f62032f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f62033g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f62034h;

        public c(View.OnClickListener onClickListener) {
            this.f62034h = onClickListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    b.this.q = 10.0f < this.f62033g;
                    b bVar = b.this;
                    if (!bVar.q) {
                        this.f62034h.onClick(bVar.l);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX() - this.f62031e;
                    float y = motionEvent.getY() - this.f62032f;
                    this.f62033g = (float) (this.f62033g + Math.sqrt((x * x) + (y * y)));
                    this.f62031e = motionEvent.getX();
                    this.f62032f = motionEvent.getY();
                }
            } else {
                b.this.q = false;
                this.f62031e = motionEvent.getX();
                this.f62032f = motionEvent.getY();
                this.f62033g = 0.0f;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int x;
            String str;
            b bVar = b.this;
            if (bVar.f62026f == null || bVar.f62025e == null) {
                return;
            }
            if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            if (view.getId() == R.id.image_ad_button) {
                x = b.this.w(view);
                str = "button";
            } else if (view.getId() == R.id.bottom_container) {
                x = b.this.v();
                str = "title";
            } else {
                x = b.this.x();
                str = b.this.f62026f.C4() ? "image" : "video";
            }
            hashMap.put("da_area", str);
            b.this.j.a(x, hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.b.j0.o.d.f.b.a
        public boolean b(View view) {
            d.b.j0.j1.o.h.c.h(d.b.j0.j1.o.h.c.e(b.this.f62026f));
            b bVar = b.this;
            if (bVar.f62028h != null && w.o(bVar.f62025e.getScheme()) && w.q(b.this.f62026f.J3)) {
                b bVar2 = b.this;
                Context context = bVar2.f62028h;
                String scheme = bVar2.f62025e.getScheme();
                AdvertAppInfo advertAppInfo = b.this.f62026f;
                w.d(context, scheme, advertAppInfo.J3, advertAppInfo.T3);
                return true;
            } else if (b.this.f62028h == null || d.b.j0.a.e().o() || z.a((Activity) b.this.f62028h)) {
                return false;
            } else {
                l.K((Activity) b.this.f62028h, R.string.write_external_storage_permission_denied_fun_disable);
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

    public final void A(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        if (advertAppInfo == null || !advertAppInfo.B4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String str = TextUtils.isEmpty(advertAppInfo.J3) ? advertAppInfo.E3 : advertAppInfo.J3;
        if (!TextUtils.isEmpty(str)) {
            h2 = d.b.j0.o.d.d.c().g(str);
        } else {
            h2 = d.b.j0.o.d.d.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(str, advertAppInfo.I3, advertAppInfo.J3);
            d.b.j0.o.d.d.c().i(h2, null);
        }
        t(h2);
    }

    public final int B() {
        String scheme = this.f62025e.getScheme() != null ? this.f62025e.getScheme() : this.f62026f.H3;
        return w.d(this.f62028h, scheme, this.f62025e.getAdvertAppInfo() != null ? u(this.f62025e.getAdvertAppInfo()) : scheme, this.f62025e.getAdvertAppInfo() != null ? this.f62025e.getAdvertAppInfo().T3 : "");
    }

    public final void C() {
        String str;
        VideoInfo videoInfo;
        this.l.setEvent(new a());
        if (this.f62026f.F4() && (videoInfo = this.x) != null) {
            str = videoInfo.thumbnail_url;
        } else {
            str = this.f62026f.U3.f12877f;
        }
        this.l.T(str, this.f62027g ? 30 : 31, PeerConnectionClient.HD_VIDEO_HEIGHT, PeerConnectionClient.HD_VIDEO_HEIGHT, false);
        UrlDragImageView urlDragImageView = this.r;
        if (urlDragImageView != null) {
            urlDragImageView.setIsCdn(this.f62027g);
            this.r.setUrl(str, true);
        }
    }

    public final void D() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.b.j0.o.d.d.c().i(this.y, this.z);
    }

    public final void E(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void F(View.OnClickListener onClickListener) {
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

    public DownloadData G(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.J3);
        downloadData.setUrl(advertAppInfo.I3);
        downloadData.setName(advertAppInfo.F3);
        downloadData.setPosition(i);
        downloadData.setNotifyId(d.b.c.e.m.b.d(advertAppInfo.E3, 0));
        return downloadData;
    }

    public final void H() {
        if (this.y == null || this.z == null) {
            return;
        }
        d.b.j0.o.d.d.c().q(this.y, this.z);
    }

    public void I() {
        WindowManager windowManager = (WindowManager) this.f62028h.getSystemService("window");
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

    @Override // d.b.j0.j1.o.l.j
    public void a(DragImageView.h hVar) {
        this.s = hVar;
    }

    @Override // d.b.j0.j1.o.l.j
    public View b() {
        return this.k;
    }

    @Override // d.b.j0.s2.c0.d.a.a
    public void d() {
        if (this.i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f62028h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        d.b.i0.r.f0.m.b bVar = new d.b.i0.r.f0.m.b();
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
        TbPageContext tbPageContext = this.i;
        if (tbPageContext != null) {
            apkDownloadView.j(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.w.i();
        s();
        F(this.A);
    }

    @Override // d.b.j0.s2.c0.d.a.a
    public void g(AdCard adCard) {
        super.g(adCard);
        AdvertAppInfo advertAppInfo = this.f62026f;
        if (advertAppInfo == null || advertAppInfo.U3 == null) {
            return;
        }
        this.x = this.f62025e.videoInfo;
        C();
        z(this.f62026f, this.f62025e);
        if (!TextUtils.isEmpty(this.f62026f.U3.f12873b)) {
            this.o.setText(this.f62026f.U3.f12873b);
            if (!TextUtils.isEmpty(this.f62026f.U3.n)) {
                this.p.setText(this.f62026f.U3.n);
            } else {
                this.p.setText(this.f62028h.getString(R.string.advert_label));
            }
        }
        if (!TextUtils.isEmpty(this.f62026f.U3.f12875d)) {
            this.n.setText(this.f62026f.U3.f12875d);
        }
        this.v.setVisibility(this.f62026f.F4() ? 0 : 8);
        F(this.A);
    }

    @Override // d.b.j0.j1.o.l.j
    public void onDestroy() {
        H();
    }

    public void s() {
        this.l.setVisibility(4);
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.f62028h);
        this.r = urlDragImageView;
        urlDragImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.r.setIsCanDrag(true);
        this.r.setCanScale(false);
        this.r.setDragToExitListener(new C1602b());
        this.k.addView(this.r, 0);
    }

    public void t(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        H();
        this.z = null;
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(downloadCacheKey);
        AdCard adCard = this.f62025e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f62025e.getAdvertAppInfo().c4;
            b2.setExtInfo(this.f62025e.getAdvertAppInfo().T3);
            b2.setDownloadKey(this.f62025e.getDownloadKey());
            b2.setAppJson(App.toJson(this.f62025e.getAdvertAppInfo().d4).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f62025e.scheme);
        }
        d.b.j0.o.c.b.d.a aVar = new d.b.j0.o.c.b.d.a(this.w, b2);
        this.z = new d.b.j0.o.d.g.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        this.w.c(b2.getCurrentState());
        D();
    }

    public String u(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.J3) ? advertAppInfo.E3 : advertAppInfo.J3;
    }

    public final int v() {
        return B();
    }

    public final int w(View view) {
        return B();
    }

    public final int x() {
        if (this.f62026f.C4()) {
            return B();
        }
        return y();
    }

    public final int y() {
        AdCard adCard;
        if (this.f62026f == null || (adCard = this.f62025e) == null || this.x == null) {
            return 0;
        }
        return w.g(this.f62028h, adCard.getScheme(), this.f62026f);
    }

    public void z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo == null || adCard == null) {
            return;
        }
        this.f62026f = advertAppInfo;
        this.f62025e = adCard;
        if (advertAppInfo.D4()) {
            String str = this.f62026f.U3.i;
            if (TextUtils.isEmpty(str)) {
                str = this.f62028h.getString(R.string.check_immediately);
            }
            this.m.setText(str);
            this.w.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setOnClickInterceptListener(new e());
        DownloadData G = G(this.f62026f, d.b.c.e.m.b.d(this.f62026f.K3, -1));
        E(G);
        this.w.setData(G);
        this.w.setVisibility(0);
        this.m.setVisibility(8);
        A(adCard, advertAppInfo);
    }
}
