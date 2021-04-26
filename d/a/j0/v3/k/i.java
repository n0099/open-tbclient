package d.a.j0.v3.k;

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
    public BaseFragmentActivity f62008f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f62009g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.v3.k.c f62010h;
    public View.OnClickListener k;
    public d.a.j0.v3.k.g l;
    public d.a.j0.v3.k.h m;
    public TbCameraView.g n;
    public TbCameraView.e o;
    public d.a.j0.b0.e p;
    public e q;

    /* renamed from: e  reason: collision with root package name */
    public final List<MediaFileInfo> f62007e = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f62011i = false;
    public boolean j = true;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.q.f62018d.playAnimation();
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
            i.this.q.f62018d.cancelAnimation();
            i.this.q.f62018d.setFrame(0);
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
        public View f62015a;

        /* renamed from: b  reason: collision with root package name */
        public View f62016b;

        /* renamed from: c  reason: collision with root package name */
        public TbCameraView f62017c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f62018d;

        public e(i iVar) {
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public MediaFileInfo f62019e;

        /* renamed from: f  reason: collision with root package name */
        public int f62020f;

        public f(MediaFileInfo mediaFileInfo, int i2) {
            this.f62019e = mediaFileInfo;
            this.f62020f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.l == null || this.f62019e == null) {
                    return;
                }
                i.this.l.a(this.f62020f, this.f62019e);
            } else if (view.getId() == R.id.lay_select) {
                if (this.f62019e == null || i.this.m == null) {
                    return;
                }
                i.this.m.a(this.f62020f, this.f62019e);
            } else if (view.getId() != R.id.video_thumb || i.this.m == null || this.f62019e == null) {
            } else {
                i.this.m.a(this.f62020f, this.f62019e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public View f62022a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62023b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62024c;

        public g(i iVar) {
        }

        public /* synthetic */ g(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f62025a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62026b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62027c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f62028d;

        public h(i iVar) {
        }

        public /* synthetic */ h(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i(BaseFragmentActivity baseFragmentActivity, d.a.j0.v3.k.c cVar) {
        this.f62008f = baseFragmentActivity;
        this.f62010h = cVar;
        this.f62009g = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i2) {
        return (MediaFileInfo) ListUtils.getItem(this.f62007e, i2);
    }

    public final View f(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo == null || mediaFileInfo.getType() != 2) {
            return view;
        }
        e eVar = this.q;
        if (eVar == null || eVar.f62017c == null) {
            this.q = new e(this, null);
            View inflate = this.f62009g.inflate(R.layout.album_make_picture_view, viewGroup, false);
            e eVar2 = this.q;
            eVar2.f62015a = inflate;
            eVar2.f62017c = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
            this.q.f62018d = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
            this.q.f62016b = inflate.findViewById(R.id.icon_placer_holder);
            this.q.f62018d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.q.f62018d.setFrame(0);
            this.q.f62018d.setRenderMode(RenderMode.HARDWARE);
            SkinManager.setLottieAnimation(this.q.f62018d, R.raw.lottie_photo);
            inflate.setTag(this.q);
            if (!d.a.i0.r.d0.b.j().g("write_camera_animaton_key", false)) {
                d.a.i0.r.d0.b.j().t("write_camera_animaton_key", true);
                this.q.f62018d.postDelayed(new a(), 2000L);
            }
            w(this.q.f62016b);
        }
        SkinManager.setBackgroundColor(this.q.f62015a, R.color.black_alpha90);
        this.q.f62017c.setOnRequestPermissionListener(this.n);
        this.q.f62017c.setOnOpenCameraFailedListener(this.o);
        this.q.f62018d.setOnClickListener(this.k);
        this.q.f62017c.setOnClickListener(this.k);
        this.q.f62015a.setOnClickListener(this.k);
        this.q.f62018d.addAnimatorUpdateListener(new b(this));
        this.q.f62018d.addAnimatorListener(new c());
        return this.q.f62015a;
    }

    public final View g(int i2, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        h hVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view != null && (view.getTag() instanceof h)) {
                hVar = (h) view.getTag();
            } else {
                h hVar2 = new h(this, null);
                View inflate = this.f62009g.inflate(R.layout.album_image_item_view, viewGroup, false);
                hVar2.f62025a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.pic);
                hVar2.f62026b = tbImageView;
                tbImageView.setDefaultResource(0);
                hVar2.f62026b.setTagPaddingDis(8, 8);
                hVar2.f62026b.setGifIconSupport(true);
                hVar2.f62026b.setLongIconSupport(true);
                hVar2.f62027c = (ImageView) inflate.findViewById(R.id.select_icon);
                hVar2.f62028d = (RelativeLayout) inflate.findViewById(R.id.lay_select);
                d.a.j0.v3.k.c cVar = this.f62010h;
                if (cVar != null && cVar.m() != null && this.f62010h.m().isFromQRCode()) {
                    hVar2.f62028d.setVisibility(8);
                }
                inflate.setTag(hVar2);
                hVar = hVar2;
                view = inflate;
            }
            hVar.f62026b.setIsLongPic(imageFileInfo.isLong());
            hVar.f62026b.V(imageFileInfo.getFilePath(), 35, false);
            s(hVar.f62027c, mediaFileInfo);
            f fVar = new f(mediaFileInfo, i2);
            hVar.f62026b.setOnClickListener(fVar);
            hVar.f62028d.setOnClickListener(fVar);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f62007e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.f62007e, i2);
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
                View inflate = this.f62009g.inflate(R.layout.album_video_item_view, viewGroup, false);
                gVar2.f62022a = inflate;
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.video_thumb);
                gVar2.f62023b = tbImageView;
                tbImageView.setDefaultResource(0);
                gVar2.f62023b.setTagPaddingDis(8, 8);
                gVar2.f62023b.setGifIconSupport(false);
                gVar2.f62023b.setLongIconSupport(false);
                gVar2.f62024c = (TextView) inflate.findViewById(R.id.video_play_time);
                inflate.setTag(gVar2);
                gVar = gVar2;
                view = inflate;
            }
            gVar.f62023b.V(videoFileInfo.videoPath, 37, false);
            gVar.f62024c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
            gVar.f62023b.setOnClickListener(new f(mediaFileInfo, i2));
        }
        return view;
    }

    public int i(ImageFileInfo imageFileInfo) {
        List<MediaFileInfo> list;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.f62007e) != null && list.size() != 0) {
            String filePath = imageFileInfo.getFilePath();
            int size = this.f62007e.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaFileInfo mediaFileInfo = this.f62007e.get(i2);
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
            return eVar.f62017c;
        }
        return null;
    }

    public boolean k() {
        return this.f62011i;
    }

    public final MediaFileInfo l() {
        return new AddMediaInfo();
    }

    public void m(List<MediaFileInfo> list) {
        this.f62007e.clear();
        if (this.j) {
            this.f62007e.add(l());
        }
        if (!ListUtils.isEmpty(list)) {
            this.f62007e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void n(d.a.j0.v3.k.g gVar) {
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
        this.f62011i = z;
    }

    public final void s(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean q;
        d.a.j0.v3.k.c cVar = this.f62010h;
        if (cVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
            q = cVar.n((ImageFileInfo) mediaFileInfo);
        } else {
            d.a.j0.v3.k.c cVar2 = this.f62010h;
            q = (cVar2 == null || !(mediaFileInfo instanceof VideoFileInfo)) ? false : cVar2.q((VideoFileInfo) mediaFileInfo);
        }
        t(imageView, q);
    }

    public void t(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.f62008f.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.f62008f.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void u(d.a.j0.v3.k.h hVar) {
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
            d.a.j0.b0.e eVar = new d.a.j0.b0.e(this.f62008f.getPageContext(), view);
            this.p = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up_left);
            this.p.L(new d());
            this.p.N(16);
            this.p.M(5000);
        }
        if (this.p != null) {
            String n = d.a.i0.r.d0.b.n("key_show_take_photo_tip");
            this.p.i0(this.f62008f.getString(R.string.album_take_photo_tip), n);
        }
    }
}
