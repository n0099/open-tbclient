package d.a.n0.h1;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.e3.z;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public ImageViewerActivity f55431a;

    /* renamed from: b  reason: collision with root package name */
    public b f55432b;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f55434d;

    /* renamed from: e  reason: collision with root package name */
    public final int f55435e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);

    /* renamed from: f  reason: collision with root package name */
    public final int f55436f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f55433c = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f55432b != null) {
                h.this.f55432b.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends PopupWindow implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public Activity f55438e;

        /* renamed from: f  reason: collision with root package name */
        public View f55439f;

        /* renamed from: g  reason: collision with root package name */
        public EMTextView f55440g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f55441h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f55442i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public MultiImageView m;
        public d.a.m0.s.g.g n;

        public b(Activity activity) {
            super(activity);
            this.f55438e = activity;
            this.n = new d.a.m0.s.g.g(activity, null);
            setWidth(l.k(activity) - (h.this.f55436f * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            a();
            d();
        }

        public final void a() {
            View inflate = LayoutInflater.from(this.f55438e).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.f55439f = inflate;
            this.f55440g = (EMTextView) inflate.findViewById(R.id.title);
            ImageView imageView = (ImageView) this.f55439f.findViewById(R.id.qq_friend);
            this.f55441h = imageView;
            imageView.setImageDrawable(this.f55438e.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.f55441h.setOnClickListener(this);
            ImageView imageView2 = (ImageView) this.f55439f.findViewById(R.id.qq_zone);
            this.f55442i = imageView2;
            imageView2.setImageDrawable(this.f55438e.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.f55442i.setOnClickListener(this);
            ImageView imageView3 = (ImageView) this.f55439f.findViewById(R.id.wechat_friend);
            this.j = imageView3;
            imageView3.setImageDrawable(this.f55438e.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.j.setOnClickListener(this);
            ImageView imageView4 = (ImageView) this.f55439f.findViewById(R.id.wechat_timeline);
            this.k = imageView4;
            imageView4.setImageDrawable(this.f55438e.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.k.setOnClickListener(this);
            ImageView imageView5 = (ImageView) this.f55439f.findViewById(R.id.wechat_emotion);
            this.l = imageView5;
            imageView5.setImageDrawable(this.f55438e.getDrawable(R.drawable.icon_share_wechatexpression));
            this.l.setOnClickListener(this);
            setContentView(this.f55439f);
        }

        public final ShareItem b() {
            UrlDragImageView currentUrlDragImageView;
            String str;
            String str2;
            MultiImageView multiImageView = this.m;
            if (multiImageView == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
                return null;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            if (imageUrlData != null) {
                str = imageUrlData.imageUrl;
                str2 = BigImageLoaderProc.getNameMd5FromUrl(str);
            } else {
                str = "";
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.m.getCurrentImageUrl();
                str2 = TbMd5.getNameMd5FromUrl(str);
            }
            ShareItem shareItem = new ShareItem();
            int i2 = 5;
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
                shareItem.K = j + "";
                shareItem.J = imageUrlData.forumId;
                i2 = h.this.e(imageUrlData.from);
            }
            if (!k.isEmpty(str)) {
                shareItem.v = Uri.parse(str);
                shareItem.W = 2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str2);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.A = bundle;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("tid", shareItem.K);
            bundle2.putString("fid", shareItem.J);
            bundle2.putString("uid", TbadkCoreApplication.getCurrentAccount());
            bundle2.putInt("obj_source", i2);
            bundle2.putInt("obj_locate", 12);
            shareItem.k(bundle2);
            return shareItem;
        }

        public final boolean c(ShareItem shareItem) {
            return (TextUtils.isEmpty(shareItem.m0) || TextUtils.isEmpty(shareItem.n0)) ? false : true;
        }

        public void d() {
            SkinManager.setViewTextColor(this.f55440g, R.color.CAM_X0109);
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f55439f);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0204);
        }

        public void e() {
            this.m = null;
            this.f55438e = null;
            this.n = null;
        }

        public void f(MultiImageView multiImageView) {
            this.m = multiImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem b2 = b();
            if (b2 == null) {
                return;
            }
            if (!d.a.c.e.p.j.z()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (view == this.f55441h) {
                if (z.b(this.f55438e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        d.a.m0.s.g.a.e(b2, this.f55438e, 8, null);
                        return;
                    } else {
                        this.n.h(b2);
                        return;
                    }
                }
                Activity activity = this.f55438e;
                BdToast.c(activity, activity.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.f55442i) {
                if (z.b(this.f55438e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        d.a.m0.s.g.a.e(b2, this.f55438e, 4, null);
                        return;
                    } else {
                        this.n.i(b2);
                        return;
                    }
                }
                Activity activity2 = this.f55438e;
                BdToast.c(activity2, activity2.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.j) {
                if (c(b2) && b2.a() != null && b2.a().contains(3)) {
                    d.a.m0.s.g.a.e(b2, this.f55438e, 3, null);
                } else if (b2.d0 != 1) {
                    this.n.m(b2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b2.K).param("fid", b2.J));
            } else if (view == this.k) {
                if (c(b2) && b2.a() != null && b2.a().contains(2)) {
                    d.a.m0.s.g.a.e(b2, this.f55438e, 2, null);
                } else if (b2.d0 == 1) {
                } else {
                    if (b2.f12596b) {
                        b2.s = "【" + b2.r + "】 " + b2.s;
                    }
                    this.n.n(b2);
                }
            } else if (view != this.l || h.this.f55434d == null) {
            } else {
                h.this.f55434d.onClick(view);
            }
        }
    }

    public h(ImageViewerActivity imageViewerActivity) {
        this.f55431a = imageViewerActivity;
        this.f55432b = new b(imageViewerActivity);
    }

    public final int e(String str) {
        if ("index".equals(str)) {
            return 1;
        }
        if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
            return 2;
        }
        if ("hot_topic".equals(str)) {
            return 3;
        }
        return "frs".equals(str) ? 4 : 5;
    }

    public void f() {
        b bVar = this.f55432b;
        if (bVar != null) {
            bVar.e();
        }
        this.f55431a = null;
        this.f55434d = null;
    }

    public void g(MultiImageView multiImageView, int i2, View.OnClickListener onClickListener) {
        String str;
        String str2;
        ImageUrlData imageUrlData;
        b bVar = this.f55432b;
        if (bVar == null || multiImageView == null) {
            return;
        }
        if (!bVar.isShowing()) {
            d.a.c.e.m.g.m(this.f55432b, multiImageView, 81, 0, i2 + d.a.c.e.p.a.b(this.f55431a) + this.f55435e);
            int i3 = 5;
            UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
            String str3 = "";
            if (currentUrlDragImageView == null || (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) == null) {
                str = "";
                str2 = str;
            } else {
                String str4 = imageUrlData.threadId + "";
                str2 = imageUrlData.forumId + "";
                str3 = imageUrlData.postId + "";
                int e2 = e(imageUrlData.from);
                str = str4;
                i3 = e2;
            }
            TiebaStatic.log(new StatisticItem("c14045").param("post_id", str3).param("tid", str).param("fid", str2).param("obj_source", i3));
        }
        this.f55432b.f(multiImageView);
        this.f55434d = onClickListener;
        d.a.c.e.m.e.a().removeCallbacks(this.f55433c);
        d.a.c.e.m.e.a().postDelayed(this.f55433c, 5000L);
    }
}
