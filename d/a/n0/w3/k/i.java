package d.a.n0.w3.k;

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
    public BaseFragmentActivity f66554f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f66555g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.w3.k.c f66556h;
    public View.OnClickListener k;
    public d.a.n0.w3.k.g l;
    public d.a.n0.w3.k.h m;
    public TbCameraView.g n;
    public TbCameraView.e o;
    public d.a.n0.d0.e p;
    public e q;

    /* renamed from: e  reason: collision with root package name */
    public final List<MediaFileInfo> f66553e = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f66557i = false;
    public boolean j = true;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.q.f66564d.playAnimation();
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
            i.this.q.f66564d.cancelAnimation();
            i.this.q.f66564d.setFrame(0);
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
            i.this.p.I();
        }
    }

    /* loaded from: classes5.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public View f66561a;

        /* renamed from: b  reason: collision with root package name */
        public View f66562b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f66563c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f66564d;

        public e(i iVar) {
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public MediaFileInfo f66565e;

        /* renamed from: f  reason: collision with root package name */
        public int f66566f;

        public f(MediaFileInfo mediaFileInfo, int i2) {
            this.f66565e = mediaFileInfo;
            this.f66566f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.l == null || this.f66565e == null) {
                    return;
                }
                i.this.l.a(this.f66566f, this.f66565e);
            } else if (view.getId() == R.id.lay_select) {
                if (this.f66565e == null || i.this.m == null) {
                    return;
                }
                i.this.m.a(this.f66566f, this.f66565e);
            } else if (view.getId() != R.id.video_thumb || i.this.m == null || this.f66565e == null) {
            } else {
                i.this.m.a(this.f66566f, this.f66565e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public View f66568a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f66569b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f66570c;

        public g(i iVar) {
        }

        public /* synthetic */ g(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f66571a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f66572b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f66573c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f66574d;

        public h(i iVar) {
        }

        public /* synthetic */ h(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(BaseFragmentActivity baseFragmentActivity, d.a.n0.w3.k.c cVar) {
        this.f66554f = baseFragmentActivity;
        this.f66556h = cVar;
        this.f66555g = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i2) {
        return (MediaFileInfo) ListUtils.getItem(this.f66553e, i2);
    }

    public final View f(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
            return view;
        }
        e eVar = this.q;
        if (eVar == null || eVar.f66563c == null) {
            this.q = new e(this, null);
            View inflate = this.f66555g.inflate(R.layout.album_make_picture_view, viewGroup, false);
            e eVar2 = this.q;
            eVar2.f66561a = inflate;
            eVar2.f66563c = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
            this.q.f66564d = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
            this.q.f66562b = inflate.findViewById(R.id.icon_placer_holder);
            this.q.f66564d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.q.f66564d.setFrame(0);
            this.q.f66564d.setRenderMode(RenderMode.HARDWARE);
            SkinManager.setLottieAnimation(this.q.f66564d, R.raw.lottie_photo);
            inflate.setTag(this.q);
            if (!d.a.m0.r.d0.b.j().g("write_camera_animaton_key", false)) {
                d.a.m0.r.d0.b.j().t("write_camera_animaton_key", true);
                this.q.f66564d.postDelayed(new a(), 2000L);
            }
            w(this.q.f66562b);
        }
        SkinManager.setBackgroundColor(this.q.f66561a, R.color.black_alpha90);
        this.q.f66563c.setOnRequestPermissionListener(this.n);
        this.q.f66563c.setOnOpenCameraFailedListener(this.o);
        this.q.f66564d.setOnClickListener(this.k);
        this.q.f66563c.setOnClickListener(this.k);
        this.q.f66561a.setOnClickListener(this.k);
        this.q.f66564d.addAnimatorUpdateListener(new b(this));
        this.q.f66564d.addAnimatorListener(new c());
        return this.q.f66561a;
    }

    public final View g(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        h hVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view != null && (view.getTag() instanceof h)) {
                hVar = (h) view.getTag();
            } else {
                h hVar2 = new h(this, null);
                View inflate = this.f66555g.inflate(R.layout.album_image_item_view, viewGroup, false);
                hVar2.f66571a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.pic);
                hVar2.f66572b = tbImageView;
                tbImageView.setDefaultResource(0);
                hVar2.f66572b.setTagPaddingDis(8, 8);
                hVar2.f66572b.setGifIconSupport(true);
                hVar2.f66572b.setLongIconSupport(true);
                hVar2.f66573c = (ImageView) inflate.findViewById(R.id.select_icon);
                hVar2.f66574d = (RelativeLayout) inflate.findViewById(R.id.lay_select);
                d.a.n0.w3.k.c cVar = this.f66556h;
                if (cVar != null && cVar.m() != null && this.f66556h.m().isFromQRCode()) {
                    hVar2.f66574d.setVisibility(8);
                }
                inflate.setTag(hVar2);
                hVar = hVar2;
                view = inflate;
            }
            hVar.f66572b.setIsLongPic(imageFileInfo.isLong());
            hVar.f66572b.U(imageFileInfo.getFilePath(), 35, false);
            s(hVar.f66573c, mediaFileInfo);
            f fVar = new f(mediaFileInfo, i2);
            hVar.f66572b.setOnClickListener(fVar);
            hVar.f66574d.setOnClickListener(fVar);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f66553e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.f66553e, i2);
        if (mediaFileInfo != null) {
            return mediaFileInfo.getType();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i2);
        if (item == null) {
            return view;
        }
        if (item.getType() == 2) {
            return f(i2, view, viewGroup, item);
        }
        if (item.getType() == 1) {
            return h(i2, view, viewGroup, item);
        }
        return item.getType() == 0 ? g(i2, view, viewGroup, item) : view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final View h(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        g gVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view != null && (view.getTag() instanceof h)) {
                gVar = (g) view.getTag();
            } else {
                g gVar2 = new g(this, null);
                View inflate = this.f66555g.inflate(R.layout.album_video_item_view, viewGroup, false);
                gVar2.f66568a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.video_thumb);
                gVar2.f66569b = tbImageView;
                tbImageView.setDefaultResource(0);
                gVar2.f66569b.setTagPaddingDis(8, 8);
                gVar2.f66569b.setGifIconSupport(false);
                gVar2.f66569b.setLongIconSupport(false);
                gVar2.f66570c = (TextView) inflate.findViewById(R.id.video_play_time);
                inflate.setTag(gVar2);
                gVar = gVar2;
                view = inflate;
            }
            gVar.f66569b.U(videoFileInfo.videoPath, 37, false);
            gVar.f66570c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
            gVar.f66569b.setOnClickListener(new f(mediaFileInfo, i2));
        }
        return view;
    }

    public int i(ImageFileInfo imageFileInfo) {
        List<MediaFileInfo> list;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.f66553e) != null && list.size() != 0) {
            String filePath = imageFileInfo.getFilePath();
            int size = this.f66553e.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaFileInfo mediaFileInfo = this.f66553e.get(i2);
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                    if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    public TbCameraView j() {
        e eVar = this.q;
        if (eVar != null) {
            return eVar.f66563c;
        }
        return null;
    }

    public boolean k() {
        return this.f66557i;
    }

    public final MediaFileInfo l() {
        return new AddMediaInfo();
    }

    public void m(List<MediaFileInfo> list) {
        this.f66553e.clear();
        if (this.j) {
            this.f66553e.add(l());
        }
        if (!ListUtils.isEmpty(list)) {
            this.f66553e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void n(d.a.n0.w3.k.g gVar) {
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
        this.f66557i = z;
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        d.a.n0.w3.k.c cVar = this.f66556h;
        if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
            q = cVar.n((ImageFileInfo) mediaFileInfo);
        } else {
            d.a.n0.w3.k.c cVar2 = this.f66556h;
            q = (cVar2 == null || !(mediaFileInfo instanceof VideoFileInfo)) ? false : cVar2.q((VideoFileInfo) mediaFileInfo);
        }
        t(imageView, q);
    }

    public void t(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.f66554f.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.f66554f.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void u(d.a.n0.w3.k.h hVar) {
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
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(this.f66554f.getPageContext(), view);
            this.p = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up_left);
            this.p.M(new d());
            this.p.O(16);
            this.p.N(5000);
        }
        if (this.p != null) {
            String n = d.a.m0.r.d0.b.n("key_show_take_photo_tip");
            this.p.m0(this.f66554f.getString(R.string.album_take_photo_tip), n);
        }
    }
}
