package d.b.j0.v3.l;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.RenderMode;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public BaseFragmentActivity f63774f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f63775g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.v3.l.c f63776h;
    public View.OnClickListener k;
    public d.b.j0.v3.l.g l;
    public d.b.j0.v3.l.h m;
    public TbCameraView.g n;
    public TbCameraView.e o;
    public d.b.j0.b0.e p;
    public e q;

    /* renamed from: e  reason: collision with root package name */
    public final List<MediaFileInfo> f63773e = new ArrayList();
    public boolean i = false;
    public boolean j = true;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.q.f63783d.playAnimation();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b(i iVar) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.q.f63783d.cancelAnimation();
            i.this.q.f63783d.setFrame(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.p.H();
        }
    }

    /* loaded from: classes5.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public View f63780a;

        /* renamed from: b  reason: collision with root package name */
        public View f63781b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f63782c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f63783d;

        public e(i iVar) {
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public MediaFileInfo f63784e;

        /* renamed from: f  reason: collision with root package name */
        public int f63785f;

        public f(MediaFileInfo mediaFileInfo, int i) {
            this.f63784e = mediaFileInfo;
            this.f63785f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.l == null || this.f63784e == null) {
                    return;
                }
                i.this.l.a(this.f63785f, this.f63784e);
            } else if (view.getId() == R.id.lay_select) {
                if (this.f63784e == null || i.this.m == null) {
                    return;
                }
                i.this.m.a(this.f63785f, this.f63784e);
            } else if (view.getId() != R.id.video_thumb || i.this.m == null || this.f63784e == null) {
            } else {
                i.this.m.a(this.f63785f, this.f63784e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public View f63787a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63788b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63789c;

        public g(i iVar) {
        }

        public /* synthetic */ g(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f63790a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63791b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f63792c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f63793d;

        public h(i iVar) {
        }

        public /* synthetic */ h(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(BaseFragmentActivity baseFragmentActivity, d.b.j0.v3.l.c cVar) {
        this.f63774f = baseFragmentActivity;
        this.f63776h = cVar;
        this.f63775g = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) ListUtils.getItem(this.f63773e, i);
    }

    public final View f(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
            return view;
        }
        e eVar = this.q;
        if (eVar == null || eVar.f63782c == null) {
            this.q = new e(this, null);
            View inflate = this.f63775g.inflate(R.layout.album_make_picture_view, viewGroup, false);
            e eVar2 = this.q;
            eVar2.f63780a = inflate;
            eVar2.f63782c = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
            this.q.f63783d = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
            this.q.f63781b = inflate.findViewById(R.id.icon_placer_holder);
            this.q.f63783d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.q.f63783d.setFrame(0);
            this.q.f63783d.setRenderMode(RenderMode.HARDWARE);
            SkinManager.setLottieAnimation(this.q.f63783d, R.raw.lottie_photo);
            inflate.setTag(this.q);
            if (!d.b.i0.r.d0.b.j().g("write_camera_animaton_key", false)) {
                d.b.i0.r.d0.b.j().t("write_camera_animaton_key", true);
                this.q.f63783d.postDelayed(new a(), 2000L);
            }
            w(this.q.f63781b);
        }
        SkinManager.setBackgroundColor(this.q.f63780a, R.color.black_alpha90);
        this.q.f63782c.setOnRequestPermissionListener(this.n);
        this.q.f63782c.setOnOpenCameraFailedListener(this.o);
        this.q.f63783d.setOnClickListener(this.k);
        this.q.f63782c.setOnClickListener(this.k);
        this.q.f63780a.setOnClickListener(this.k);
        this.q.f63783d.addAnimatorUpdateListener(new b(this));
        this.q.f63783d.addAnimatorListener(new c());
        return this.q.f63780a;
    }

    public final View g(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        h hVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view != null && (view.getTag() instanceof h)) {
                hVar = (h) view.getTag();
            } else {
                h hVar2 = new h(this, null);
                View inflate = this.f63775g.inflate(R.layout.album_image_item_view, viewGroup, false);
                hVar2.f63790a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.pic);
                hVar2.f63791b = tbImageView;
                tbImageView.setDefaultResource(0);
                hVar2.f63791b.setTagPaddingDis(8, 8);
                hVar2.f63791b.setGifIconSupport(true);
                hVar2.f63791b.setLongIconSupport(true);
                hVar2.f63792c = (ImageView) inflate.findViewById(R.id.select_icon);
                hVar2.f63793d = (RelativeLayout) inflate.findViewById(R.id.lay_select);
                d.b.j0.v3.l.c cVar = this.f63776h;
                if (cVar != null && cVar.m() != null && this.f63776h.m().isFromQRCode()) {
                    hVar2.f63793d.setVisibility(8);
                }
                inflate.setTag(hVar2);
                hVar = hVar2;
                view = inflate;
            }
            hVar.f63791b.setIsLongPic(imageFileInfo.isLong());
            hVar.f63791b.W(imageFileInfo.getFilePath(), 35, false);
            s(hVar.f63792c, mediaFileInfo);
            f fVar = new f(mediaFileInfo, i);
            hVar.f63791b.setOnClickListener(fVar);
            hVar.f63793d.setOnClickListener(fVar);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f63773e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.f63773e, i);
        if (mediaFileInfo != null) {
            return mediaFileInfo.getType();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i);
        if (item == null) {
            return view;
        }
        if (item.getType() == 2) {
            return f(i, view, viewGroup, item);
        }
        if (item.getType() == 1) {
            return h(i, view, viewGroup, item);
        }
        return item.getType() == 0 ? g(i, view, viewGroup, item) : view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final View h(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        g gVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view != null && (view.getTag() instanceof h)) {
                gVar = (g) view.getTag();
            } else {
                g gVar2 = new g(this, null);
                View inflate = this.f63775g.inflate(R.layout.album_video_item_view, viewGroup, false);
                gVar2.f63787a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.video_thumb);
                gVar2.f63788b = tbImageView;
                tbImageView.setDefaultResource(0);
                gVar2.f63788b.setTagPaddingDis(8, 8);
                gVar2.f63788b.setGifIconSupport(false);
                gVar2.f63788b.setLongIconSupport(false);
                gVar2.f63789c = (TextView) inflate.findViewById(R.id.video_play_time);
                inflate.setTag(gVar2);
                gVar = gVar2;
                view = inflate;
            }
            gVar.f63788b.W(videoFileInfo.videoPath, 37, false);
            gVar.f63789c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
            gVar.f63788b.setOnClickListener(new f(mediaFileInfo, i));
        }
        return view;
    }

    public int i(ImageFileInfo imageFileInfo) {
        List<MediaFileInfo> list;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.f63773e) != null && list.size() != 0) {
            String filePath = imageFileInfo.getFilePath();
            int size = this.f63773e.size();
            for (int i = 0; i < size; i++) {
                MediaFileInfo mediaFileInfo = this.f63773e.get(i);
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                    if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public TbCameraView j() {
        e eVar = this.q;
        if (eVar != null) {
            return eVar.f63782c;
        }
        return null;
    }

    public boolean k() {
        return this.i;
    }

    public final MediaFileInfo l() {
        return new AddMediaInfo();
    }

    public void m(List<MediaFileInfo> list) {
        this.f63773e.clear();
        if (this.j) {
            this.f63773e.add(l());
        }
        if (!ListUtils.isEmpty(list)) {
            this.f63773e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void n(d.b.j0.v3.l.g gVar) {
        this.l = gVar;
    }

    public void o(TbCameraView.e eVar) {
        this.o = eVar;
    }

    public void p(TbCameraView.g gVar) {
        this.n = gVar;
    }

    public void q(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void r(boolean z) {
        this.i = z;
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        d.b.j0.v3.l.c cVar = this.f63776h;
        if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
            q = cVar.n((ImageFileInfo) mediaFileInfo);
        } else {
            d.b.j0.v3.l.c cVar2 = this.f63776h;
            q = (cVar2 == null || !(mediaFileInfo instanceof VideoFileInfo)) ? false : cVar2.q((VideoFileInfo) mediaFileInfo);
        }
        t(imageView, q);
    }

    public void t(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.f63774f.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.f63774f.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void u(d.b.j0.v3.l.h hVar) {
        this.m = hVar;
    }

    public void v(boolean z) {
        if (this.j != z) {
            this.j = z;
            notifyDataSetChanged();
        }
    }

    public void w(View view) {
        if (this.p == null && view != null) {
            d.b.j0.b0.e eVar = new d.b.j0.b0.e(this.f63774f.getPageContext(), view);
            this.p = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up_left);
            this.p.L(new d());
            this.p.N(16);
            this.p.M(5000);
        }
        if (this.p != null) {
            String n = d.b.i0.r.d0.b.n("key_show_take_photo_tip");
            this.p.i0(this.f63774f.getString(R.string.album_take_photo_tip), n);
        }
    }
}
