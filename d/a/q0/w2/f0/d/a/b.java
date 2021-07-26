package d.a.q0.w2.f0.d.a;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.h3.z;
import d.a.q0.q.d.g.b;
import d.a.q0.w2.x;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class b extends d.a.q0.w2.f0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public d.a.q0.q.d.h.d z;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66611a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66611a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f66611a.J();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: d.a.q0.w2.f0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1836b implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66612a;

        public C1836b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66612a = bVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f66612a.s != null) {
                    this.f66612a.s.a();
                }
                this.f66612a.n.setVisibility(8);
                this.f66612a.o.setVisibility(8);
                this.f66612a.p.setVisibility(8);
                this.f66612a.t.setVisibility(8);
                this.f66612a.v.setVisibility(8);
                this.f66612a.m.setVisibility(8);
                this.f66612a.w.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f66612a.s == null) {
                return;
            }
            this.f66612a.s.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f66612a.s != null) {
                    this.f66612a.s.c();
                }
                this.f66612a.n.setVisibility(0);
                this.f66612a.o.setVisibility(0);
                this.f66612a.p.setVisibility(0);
                this.f66612a.t.setVisibility(0);
                b bVar = this.f66612a;
                AdvertAppInfo advertAppInfo = bVar.f66607f;
                if (advertAppInfo != null) {
                    bVar.v.setVisibility(advertAppInfo.A4() ? 0 : 8);
                    if (this.f66612a.f66607f.y4()) {
                        this.f66612a.m.setVisibility(0);
                    } else {
                        this.f66612a.w.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f66613e;

        /* renamed from: f  reason: collision with root package name */
        public float f66614f;

        /* renamed from: g  reason: collision with root package name */
        public float f66615g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f66616h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f66617i;

        public c(b bVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66617i = bVar;
            this.f66616h = onClickListener;
            this.f66613e = 0.0f;
            this.f66614f = 0.0f;
            this.f66615g = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f66617i.q = 10.0f < this.f66615g;
                        b bVar = this.f66617i;
                        if (!bVar.q) {
                            this.f66616h.onClick(bVar.l);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.f66613e;
                        float y = motionEvent.getY() - this.f66614f;
                        this.f66615g = (float) (this.f66615g + Math.sqrt((x * x) + (y * y)));
                        this.f66613e = motionEvent.getX();
                        this.f66614f = motionEvent.getY();
                    }
                } else {
                    this.f66617i.q = false;
                    this.f66613e = motionEvent.getX();
                    this.f66614f = motionEvent.getY();
                    this.f66615g = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66618e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66618e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int w;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f66618e;
                if (bVar.f66607f == null || bVar.f66606e == null) {
                    return;
                }
                if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.image_ad_button) {
                    w = this.f66618e.v(view);
                    str = "button";
                } else if (view.getId() == R.id.bottom_container) {
                    w = this.f66618e.u();
                    str = "title";
                } else {
                    w = this.f66618e.w();
                    str = this.f66618e.f66607f.x4() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.f66618e.j.a(w, hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66619a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66619a = bVar;
        }

        @Override // d.a.q0.q.d.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                d.a.q0.n1.o.h.c.h(d.a.q0.n1.o.h.c.e(this.f66619a.f66607f));
                b bVar = this.f66619a;
                if (bVar.f66609h != null && x.o(bVar.f66606e.getScheme()) && x.q(this.f66619a.f66607f.j4)) {
                    b bVar2 = this.f66619a;
                    x.d(bVar2.f66609h, bVar2.f66606e.getScheme(), this.f66619a.f66607f.getDownloadId(), this.f66619a.f66607f.Y3);
                    return true;
                } else if (this.f66619a.f66609h == null || d.a.q0.a.h().s() || z.a((Activity) this.f66619a.f66609h)) {
                    return false;
                } else {
                    l.L((Activity) this.f66619a.f66609h, R.string.write_external_storage_permission_denied_fun_disable);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.z = null;
        this.A = new d(this);
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? x.d(this.f66609h, this.f66606e.getScheme(), this.f66606e.getDownloadId(), this.f66607f.Y3) : invokeV.intValue;
    }

    public final void B() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f66607f.A4() && (videoInfo = this.x) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.f66606e.getPicUrl();
            }
            this.l.setEvent(new a(this));
            this.l.J(picUrl, this.f66608g ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f66608g);
                this.r.setUrl(picUrl, true);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            I();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.y == null || this.z == null) {
            return;
        }
        d.a.q0.q.d.e.c().i(this.y, this.z);
    }

    public final void E(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void F(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.s = hVar;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
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
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setOuterOnTouchListener(new c(this, onClickListener));
            }
        }
    }

    public DownloadData H(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, advertAppInfo, i2)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.i4);
            downloadData.setName(advertAppInfo.e4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(d.a.d.e.m.b.d(advertAppInfo.R3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.y == null || this.z == null) {
            return;
        }
        d.a.q0.q.d.e.c().q(this.y, this.z);
    }

    public void J() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (windowManager = (WindowManager) this.f66609h.getSystemService("window")) == null) {
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

    @Override // d.a.q0.w2.f0.d.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f66610i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f66609h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
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
        TbPageContext tbPageContext = this.f66610i;
        if (tbPageContext != null) {
            apkDownloadView.j(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.w.i();
        G(this.A);
    }

    @Override // d.a.q0.w2.f0.d.a.a
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            r();
            this.x = this.f66606e.videoInfo;
            B();
            y(this.f66607f, this.f66606e);
            if (!TextUtils.isEmpty(this.f66607f.e4)) {
                this.o.setText(this.f66607f.e4);
                this.p.setText(this.f66609h.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.n.setText(adCard.threadTitle);
            }
            this.v.setVisibility(this.f66607f.A4() ? 0 : 8);
            G(this.A);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l.setVisibility(4);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                this.k.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f66609h);
            this.r = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.r.setIsCanDrag(true);
            this.r.setCanScale(false);
            this.r.setDragToExitListener(new C1836b(this));
            this.k.addView(this.r, 0);
        }
    }

    public void s(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        I();
        this.z = null;
        AdDownloadData b2 = d.a.q0.q.d.e.c().b(downloadCacheKey);
        AdCard adCard = this.f66606e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f66606e.getAdvertAppInfo().b4;
            b2.setExtInfo(this.f66606e.getAdvertAppInfo().Y3);
            b2.setDownloadKey(this.f66606e.getDownloadKey());
            JSONObject json = App.toJson(this.f66606e.getAdvertAppInfo().d4);
            if (json != null) {
                b2.setAppJson(json.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f66606e.scheme);
        }
        d.a.q0.q.c.b.d.a aVar = new d.a.q0.q.c.b.d.a(this.w, b2);
        this.z = new d.a.q0.q.d.h.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        this.w.c(b2.getCurrentState());
        D();
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? A() : invokeV.intValue;
    }

    public final int v(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) ? A() : invokeL.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f66607f.x4()) {
                return A();
            }
            return x();
        }
        return invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f66607f == null || (adCard = this.f66606e) == null || this.x == null) {
                return 0;
            }
            return x.g(this.f66609h, adCard.getScheme(), this.f66607f);
        }
        return invokeV.intValue;
    }

    public void y(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.f66607f = advertAppInfo;
        this.f66606e = adCard;
        if (advertAppInfo.y4()) {
            this.m.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setInitText(adCard.getButtonText());
        this.w.setOnClickInterceptListener(new e(this));
        DownloadData H = H(this.f66607f, d.a.d.e.m.b.d(this.f66607f.X3, -1));
        E(H);
        this.w.setData(H);
        this.w.setVisibility(0);
        this.m.setVisibility(8);
        z(adCard, advertAppInfo);
    }

    public final void z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.w4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.q0.q.d.e.c().g(downloadId);
        } else {
            h2 = d.a.q0.q.d.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.i4, advertAppInfo.j4);
            d.a.q0.q.d.e.c().i(h2, null);
        }
        s(h2);
    }
}
