package d.b.i0.f1;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.c3.z;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public ImageViewerActivity f54670a;

    /* renamed from: b  reason: collision with root package name */
    public b f54671b;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f54673d;

    /* renamed from: e  reason: collision with root package name */
    public final int f54674e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);

    /* renamed from: f  reason: collision with root package name */
    public final int f54675f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f54672c = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f54671b != null) {
                h.this.f54671b.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends PopupWindow implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public Activity f54677e;

        /* renamed from: f  reason: collision with root package name */
        public View f54678f;

        /* renamed from: g  reason: collision with root package name */
        public EMTextView f54679g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f54680h;
        public ImageView i;
        public ImageView j;
        public ImageView k;
        public ImageView l;
        public MultiImageView m;
        public d.b.h0.s.g.g n;

        public b(Activity activity) {
            super(activity);
            this.f54677e = activity;
            this.n = new d.b.h0.s.g.g(activity, null);
            setWidth(l.k(activity) - (h.this.f54675f * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            a();
            d();
        }

        public final void a() {
            View inflate = LayoutInflater.from(this.f54677e).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
            this.f54678f = inflate;
            this.f54679g = (EMTextView) inflate.findViewById(R.id.title);
            ImageView imageView = (ImageView) this.f54678f.findViewById(R.id.qq_friend);
            this.f54680h = imageView;
            imageView.setImageDrawable(this.f54677e.getDrawable(R.drawable.icon_mask_share_qq40_svg));
            this.f54680h.setOnClickListener(this);
            ImageView imageView2 = (ImageView) this.f54678f.findViewById(R.id.qq_zone);
            this.i = imageView2;
            imageView2.setImageDrawable(this.f54677e.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
            this.i.setOnClickListener(this);
            ImageView imageView3 = (ImageView) this.f54678f.findViewById(R.id.wechat_friend);
            this.j = imageView3;
            imageView3.setImageDrawable(this.f54677e.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
            this.j.setOnClickListener(this);
            ImageView imageView4 = (ImageView) this.f54678f.findViewById(R.id.wechat_timeline);
            this.k = imageView4;
            imageView4.setImageDrawable(this.f54677e.getDrawable(R.drawable.icon_mask_share_circle40_svg));
            this.k.setOnClickListener(this);
            ImageView imageView5 = (ImageView) this.f54678f.findViewById(R.id.wechat_emotion);
            this.l = imageView5;
            imageView5.setImageDrawable(this.f54677e.getDrawable(R.drawable.icon_share_wechatexpression));
            this.l.setOnClickListener(this);
            setContentView(this.f54678f);
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
            int i = 5;
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
                shareItem.J = j + "";
                shareItem.I = imageUrlData.forumId;
                i = h.this.e(imageUrlData.from);
            }
            if (!k.isEmpty(str)) {
                shareItem.v = Uri.parse(str);
                shareItem.V = 2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str2);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.z = bundle;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("tid", shareItem.J);
            bundle2.putString("fid", shareItem.I);
            bundle2.putString("uid", TbadkCoreApplication.getCurrentAccount());
            bundle2.putInt("obj_source", i);
            bundle2.putInt("obj_locate", 12);
            shareItem.i(bundle2);
            return shareItem;
        }

        public final boolean c(ShareItem shareItem) {
            return (TextUtils.isEmpty(shareItem.k0) || TextUtils.isEmpty(shareItem.l0)) ? false : true;
        }

        public void d() {
            SkinManager.setViewTextColor(this.f54679g, R.color.CAM_X0109);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f54678f);
            a2.h(R.string.J_X06);
            a2.c(R.color.CAM_X0204);
        }

        public void e() {
            this.m = null;
            this.f54677e = null;
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
            if (!d.b.b.e.p.j.z()) {
                l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (view == this.f54680h) {
                if (z.b(this.f54677e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        d.b.h0.s.g.a.e(b2, this.f54677e, 8, null);
                        return;
                    } else {
                        this.n.h(b2);
                        return;
                    }
                }
                Activity activity = this.f54677e;
                BdToast.c(activity, activity.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.i) {
                if (z.b(this.f54677e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        d.b.h0.s.g.a.e(b2, this.f54677e, 4, null);
                        return;
                    } else {
                        this.n.i(b2);
                        return;
                    }
                }
                Activity activity2 = this.f54677e;
                BdToast.c(activity2, activity2.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.j) {
                if (c(b2) && b2.a() != null && b2.a().contains(3)) {
                    d.b.h0.s.g.a.e(b2, this.f54677e, 3, null);
                } else if (b2.b0 != 1) {
                    this.n.m(b2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b2.J).param("fid", b2.I));
            } else if (view == this.k) {
                if (c(b2) && b2.a() != null && b2.a().contains(2)) {
                    d.b.h0.s.g.a.e(b2, this.f54677e, 2, null);
                } else if (b2.b0 == 1) {
                } else {
                    if (b2.f13712b) {
                        b2.s = "【" + b2.r + "】 " + b2.s;
                    }
                    this.n.n(b2);
                }
            } else if (view != this.l || h.this.f54673d == null) {
            } else {
                h.this.f54673d.onClick(view);
            }
        }
    }

    public h(ImageViewerActivity imageViewerActivity) {
        this.f54670a = imageViewerActivity;
        this.f54671b = new b(imageViewerActivity);
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
        b bVar = this.f54671b;
        if (bVar != null) {
            bVar.e();
        }
        this.f54670a = null;
        this.f54673d = null;
    }

    public void g(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        String str;
        String str2;
        ImageUrlData imageUrlData;
        b bVar = this.f54671b;
        if (bVar == null || multiImageView == null) {
            return;
        }
        if (!bVar.isShowing()) {
            d.b.b.e.m.g.m(this.f54671b, multiImageView, 81, 0, i + d.b.b.e.p.a.b(this.f54670a) + this.f54674e);
            int i2 = 5;
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
                i2 = e2;
            }
            TiebaStatic.log(new StatisticItem("c14045").param("post_id", str3).param("tid", str).param("fid", str2).param("obj_source", i2));
        }
        this.f54671b.f(multiImageView);
        this.f54673d = onClickListener;
        d.b.b.e.m.e.a().removeCallbacks(this.f54672c);
        d.b.b.e.m.e.a().postDelayed(this.f54672c, 5000L);
    }
}
